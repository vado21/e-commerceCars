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
public class Commercial extends Car {
    float spaceVolume;
    float maxWeightCargo;
    String motor;

    public float getSpaceVolume() {
        return spaceVolume;
    }

    public void setSpaceVolume(float spaceVolume) {
        this.spaceVolume = spaceVolume;
    }

    public float getMaxWeightCargo() {
        return maxWeightCargo;
    }

    public void setMaxWeightCargo(float maxWeightCargo) {
        this.maxWeightCargo = maxWeightCargo;
    }

    public String getMotor() {
        return motor;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }
    
}
