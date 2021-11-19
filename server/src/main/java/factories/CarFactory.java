/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factories;

import models.Armored;
import models.Car;
import models.Commercial;
import models.Luxury;

/**
 *
 * @author ricardocazares
 */
public class CarFactory {
    
    public Car get(String type){
        switch(type){
            case "normal":
                return new Car();
            case "commercial":
                return new Commercial();
            case "luxury":
                return new Luxury();
            case "armored":
                return new Armored();
            default:
                return null;
        }
    }
}
