/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package routes;

import Repositories.TestRepository;
import models.test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ricardocazares
 */
 @RestController
public class TestRoute {
     
    @Autowired
    TestRepository repo;
     
    @GetMapping("/status")
    public String index (){
        return "hello world";
    }
    
    @GetMapping("/obtain")
    public void index2 (){
        
        test t = new test("myname2",2012);
        repo.save(t);
         
    }
}
