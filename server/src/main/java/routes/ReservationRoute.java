package routes;

import Repositories.ReservationRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import models.Car;
import models.Reservation;
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
import services.LoggerSingleton;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ricardocazares
 */
@CrossOrigin
@RestController
public class ReservationRoute implements RestEndpoint {
    
    @Autowired
    ReservationRepository repo;
    
    private static CacheDB<Reservation> cache = new CacheService<>();
    private LoggerSingleton logger = new LoggerSingleton();
    
    @Override
    @GetMapping("/reservation")
    public Object list(@RequestParam String filter) {
    List<Reservation> result = new ArrayList<>();
         
    if(!this.cache.isEmpty(filter)){
        System.out.print("Using Cache");
        return this.cache.getLastRequest(filter);
    }
    
    switch (filter) {
        case "new":
            result = repo.getNew(); 
            break;
        case "complete":
            result = repo.getComplete();
            break;
        default:
            result = repo.findAll();
            break;
    }
    this.cache.setCache(filter,result);
    this.logger.write("Request for " + filter);
    return result;
    }

    @PostMapping("/reservation")
    public Object create(@RequestBody Reservation data){
        repo.save(data);
        this.cache.deleteCache("new");
        this.cache.deleteCache("complete");
        this.logger.write("Create JSON" + data.toString());
        return new ResponseEntity(HttpStatus.CREATED);
    }
    
    @Override
    @DeleteMapping("/reservation/{id}")
    public Object delete(@PathVariable String id) {
        repo.deleteById(id);
        this.cache.deleteCache("new");
        this.cache.deleteCache("complete");
        this.logger.write("Deletion Reservation " + id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @Override
    @GetMapping("/reservation/{id}")
    public Object index(@PathVariable String id) {
        Optional<Reservation> res = repo.findById(id);
        if (res.isPresent()) {
            return res;
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
    
}
