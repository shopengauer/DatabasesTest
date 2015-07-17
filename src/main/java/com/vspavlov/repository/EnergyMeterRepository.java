package com.vspavlov.repository;

import com.vspavlov.domain.EnergyMeter;

/**
 * Created by Vasiliy on 16.07.2015.
 */
public interface EnergyMeterRepository {

    void insert(EnergyMeter energyMeter);
    EnergyMeter findByEnergyMeterId(int energyMeterId);
}
