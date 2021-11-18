package services;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ricardocazares
 */
public class CacheService<T> implements CacheDB {
    
    Map<String,List<T>> cache;
    
    public CacheService(){
        this.cache = new HashMap<String,List<T>>();
    }
    
    @Override
    public List<T> getLastRequest(String type) {
        return this.cache.get(type);
    }

    @Override
    public void deleteCache(String type) {
        if(this.cache.containsKey(type)){
            this.cache.remove(type);
        }
        if(this.cache.containsKey("all")){
            this.cache.remove("all");
        }
    }

    @Override
    public void setCache(String type, List obj) {
        this.cache.put(type, obj);
    }
     
    @Override
    public boolean isEmpty(String type){
        return !this.cache.containsKey(type);  
      }
}
