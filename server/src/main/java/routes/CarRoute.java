/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package routes;

import Repositories.CarRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import models.Armored;
import models.Car;
import models.Commercial;
import models.Luxury;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import services.CacheDB;
import services.CacheService;
import services.Log;
import services.LoggerSingleton;

/**
 *
 * @author ricardocazares
 */

@CrossOrigin
@RestController
public class CarRoute implements RestEndpoint {

    @Autowired
    CarRepository repo;
    
    
    private static CacheDB<Car> cache = new CacheService<>();
    private LoggerSingleton logger = new LoggerSingleton();

    @Override
    @GetMapping("/car")
    public Object list(@RequestParam String filter) {
        
    if(!this.cache.isEmpty(filter)){
        return this.cache.getLastRequest(filter);
    }
    
     List<Car> result = new ArrayList<>();
    switch (filter) {
        case "car":
            result = repo.getOnlyCars(); 
            break;
        case "luxury":
            result = repo.getOnlyLuxury();
            break;
        case "armored":
            result = repo.getOnlyArmored();
            break;
        case "commercial":
            result = repo.getOnlyCommercial();
            break;
        default:
            result = repo.findAll();
            break;
    }
    
    this.cache.setCache(filter,result);
    this.logger.write("Request for " + filter);
    return result;
    }

    @PostMapping("/car")
    public Object create(@RequestBody Car car) {
        repo.save(car);
        this.cache.deleteCache("car");
        this.logger.write("Create JSON" + car.toString());

        return new ResponseEntity(HttpStatus.CREATED);
    }
    
    @PostMapping("/luxury")
    public Object create(@RequestBody Luxury car) {
        repo.save(car);
        this.cache.deleteCache("luxury");
        this.logger.write("Create JSON" + car.toString());

        return new ResponseEntity(HttpStatus.CREATED);
    }
    
    @PostMapping("/commercial")
    public Object create(@RequestBody Commercial car) {
        repo.save(car);
        this.cache.deleteCache("commercial");
        this.logger.write("Create JSON" + car.toString());

        return new ResponseEntity(HttpStatus.CREATED);
    }
    
    @PostMapping("/armored")
    public Object create(@RequestBody Armored car) {
        repo.save(car);
        this.cache.deleteCache("armored");
        this.logger.write("Create JSON" + car.toString());

        return new ResponseEntity(HttpStatus.CREATED);
    }

    @Override
    @DeleteMapping("/car/{id}")
    public Object delete(@PathVariable String id) {
        repo.deleteById(id);
        this.cache.deleteCache("car");
        this.cache.deleteCache("luxury");
        this.cache.deleteCache("commercial");
        this.cache.deleteCache("armored");

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @Override
    @GetMapping("/car/{id}")
    public Object index(@PathVariable String id) {
        Optional<Car> car = repo.findById(id);
        if (car.isPresent()) {
            return car;
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

}
