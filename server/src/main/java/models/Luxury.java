/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author ricardocazares
 */
@Document("Car")
public class Luxury extends Car{
    
    boolean fiberCarbon;
    boolean exoticDoors;
    String origin;
    int hp;

    public boolean isFiberCarbon() {
        return fiberCarbon;
    }

    public void setFiberCarbon(boolean fiberCarbon) {
        this.fiberCarbon = fiberCarbon;
    }

    public boolean isExoticDoors() {
        return exoticDoors;
    }

    public void setExoticDoors(boolean exoticDoors) {
        this.exoticDoors = exoticDoors;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }
}
