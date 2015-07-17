package com.vspavlov.domain;

/**
 * Created by Vasiliy on 16.07.2015.
 */
public class EnergyMeter {

    private int id;
    private String energyMeterName;
    private int phaseNumber;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEnergyMeterName() {
        return energyMeterName;
    }

    public void setEnergyMeterName(String energyMeterName) {
        this.energyMeterName = energyMeterName;
    }

    public int getPhaseNumber() {
        return phaseNumber;
    }

    public void setPhaseNumber(int phaseNumber) {
        this.phaseNumber = phaseNumber;
    }
}
