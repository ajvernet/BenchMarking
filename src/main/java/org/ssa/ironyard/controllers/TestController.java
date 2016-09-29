package org.ssa.ironyard.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

        @RequestMapping(value = "")
        public ResponseEntity<String> home()
        {
            
            String str = "reached";
        
            return ResponseEntity.ok().body(str);
            
        }
    
    
    }  

