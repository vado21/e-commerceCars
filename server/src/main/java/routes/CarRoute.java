/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package routes;

import Repositories.CarRepository;
import Repositories.LuxuryRepository;
import java.util.Optional;
import models.Car;
import models.Luxury;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ricardocazares
 */
 @RestController
public class CarRoute implements RestEndpoint {
    
    @Autowired
    CarRepository repo;
    
    @Override
    @GetMapping("/car")
    public Object index() {
        return repo.findAll();
    }

    @PostMapping("/car")
    public Object create(@RequestBody Car car) {
        repo.save(car);
        
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @Override
    @DeleteMapping("/car/{id}")
    public Object delete(@PathVariable String id) {
        repo.deleteById(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @Override
    @GetMapping("/car/{id}")
    public Object index(@PathVariable String id) {
        Optional<Car> car = repo.findById(id);
        if(car.isPresent()){
            return car;
        }
        else{
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
    
}
