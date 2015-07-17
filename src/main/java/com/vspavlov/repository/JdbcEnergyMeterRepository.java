package com.vspavlov.repository;

import com.vspavlov.domain.EnergyMeter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Vasiliy on 16.07.2015.
 */
@Repository
public class JdbcEnergyMeterRepository implements EnergyMeterRepository{
    private static final String SQL_INSERT_ENERGYMETER =
            "INSERT INTO ENERGYMETER (ID, em, phn) VALUES (?, ?, ?)";
    private JdbcOperations jdbcOperations;

    @Autowired
    public JdbcEnergyMeterRepository(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

    @Override
    public void insert(EnergyMeter energyMeter) {

        jdbcOperations.update(SQL_INSERT_ENERGYMETER,energyMeter.getId(),
                energyMeter.getEnergyMeterName(),energyMeter.getPhaseNumber());
    }

    @Override
    public   EnergyMeter  findByEnergyMeterId(int energyMeterId) {
        return jdbcOperations.queryForObject("SELECT id,em,phn from energymeter where id = ?", new EnergyMeterRowMapper(),energyMeterId);

    }

    private static final class EnergyMeterRowMapper implements RowMapper<EnergyMeter>{
        @Override
        public EnergyMeter mapRow(ResultSet resultSet, int i) throws SQLException {
            EnergyMeter en = new EnergyMeter();
            en.setId(resultSet.getInt("id"));
            en.setEnergyMeterName(resultSet.getString("em"));
            en.setPhaseNumber(resultSet.getInt("phn"));
            return en;
        }
    }
}
