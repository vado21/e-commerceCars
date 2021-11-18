package services;

import java.util.List;
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
public interface CacheDB<T> {
    
    List<T> getLastRequest(String type);
    void deleteCache(String type);
    void setCache(String type, List<T> obj);
    boolean isEmpty(String type);
}
