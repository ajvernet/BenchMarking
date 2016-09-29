package org.ssa.ironyard.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.ssa.ironyard.daos.FrameworkDAO;
import org.ssa.ironyard.domain_objects.Framework;

@Component
public class FrameworkService {

    FrameworkDAO frameDAO;
    
    @Autowired
    public FrameworkService(FrameworkDAO frameDAO)
    {
        this.frameDAO = frameDAO;
    }
    
    public FrameworkService(){}
    
    @Transactional
    public Framework getFramework(int id)
    {
        return frameDAO.read(id);
    }
    
    @Transactional
    public List<Framework> getAllFrameworks()
    {
        return frameDAO.readAll();
    }
    
    @Transactional
    public List<Framework> getFrameWorksByLang(String language)
    {
        return frameDAO.eagerReadLanguage(language);
    }
    
    @Transactional
    public List<Framework> getFrameWorksByServ(String server)
    {
        return frameDAO.eagerReadServer(server);
    }
}
