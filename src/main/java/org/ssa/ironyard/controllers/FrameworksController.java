package org.ssa.ironyard.controllers;

import java.util.HashMap;
import java.util.List;

import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.InternalResourceView;
import org.ssa.ironyard.domain_objects.Framework;
import org.ssa.ironyard.services.FrameworkService;

@RestController
@RequestMapping("/benchmarks")
public class FrameworksController {

    
    
    static final Logger LOGGER = LogManager.getLogger(FrameworksController.class);
    final FrameworkService service;
    
    @Autowired
    public FrameworksController(FrameworkService service)
    {
        this.service = service;
    }
  
    @RequestMapping(value = "")
    public View home()
    {
        return new InternalResourceView("templates/home.html");
    }
    
    @RequestMapping(produces = "application/json", value = "/showAll", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<HashMap<String, List<Framework>>> allFrameworks()
    {
        ResponseEntity.status(HttpStatus.CREATED);
        HashMap<String, List<Framework>> map = new HashMap<String, List<Framework>>();
        List<Framework> frameworks = service.getAllFrameworks();
        
        if(frameworks.size() == 0)
        {
            map.put("error", frameworks);
            return ResponseEntity.ok().header("Benchmark App", "Frameworks").body(map);
        } else
        {
            map.put("success", frameworks);
            return ResponseEntity.ok().header("Benchmark App", "Frameworks").body(map);
        }     
    }
    
    @RequestMapping(produces = "application/json", value = "/fblang/{name}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<HashMap<String, List<Framework>>> frameworksByLanguage(@PathVariable String name)
    {
        ResponseEntity.status(HttpStatus.CREATED);
        HashMap<String, List<Framework>> map = new HashMap<String, List<Framework>>();
        List<Framework> frameworks = service.getFrameWorksByLang(name);
        
        if(frameworks.size() == 0)
        {
            map.put("error", frameworks);
            return ResponseEntity.ok().header("Benchmark App", "Frameworks").body(map);
        } else
        {
            map.put("success", frameworks);
            return ResponseEntity.ok().header("Benchmark App", "Frameworks").body(map);
        }     
    }
    
    @RequestMapping(produces = "application/json", value = "/fbserv/{name}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<HashMap<String, List<Framework>>> frameworksByServere(@PathVariable String name)
    {
        ResponseEntity.status(HttpStatus.CREATED);
        HashMap<String, List<Framework>> map = new HashMap<String, List<Framework>>();
        List<Framework> frameworks = service.getFrameWorksByServ(name);
        
        if(frameworks.size() == 0)
        {
            map.put("error", frameworks);
            return ResponseEntity.ok().header("Benchmark App", "Frameworks").body(map);
        } else
        {
            map.put("success", frameworks);
            return ResponseEntity.ok().header("Benchmark App", "Frameworks").body(map);
        }     
    }
    
    
}
