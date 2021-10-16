/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositories;

import java.util.List;
import models.Car;
import models.Luxury;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Service;

/**
 *
 * @author ricardocazares
 */
@Service
public interface CarRepository extends MongoRepository<Car, String>{
    
    @Query("{ '_class' : 'models.Car' }")
    List<Car> getOnlyCars ();
}
