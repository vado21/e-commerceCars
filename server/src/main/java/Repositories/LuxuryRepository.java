/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositories;

import models.Luxury;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author ricardocazares
 */
@Service
public interface LuxuryRepository extends MongoRepository<Luxury, String>{
    
}
