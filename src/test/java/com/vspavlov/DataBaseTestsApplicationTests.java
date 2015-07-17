package com.vspavlov;

import com.vspavlov.domain.EnergyMeter;
import com.vspavlov.repository.EnergyMeterRepository;
import com.vspavlov.repository.JdbcEnergyMeterRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DataBaseTestsApplication.class)
public class DataBaseTestsApplicationTests {



	@Autowired
	private EnergyMeterRepository jdbcEnergyMeterRepository;
	@Autowired
	private JdbcOperations jdbcTemplate;

	@Test
	public void contextLoads() {

		EnergyMeter energyMeter = new EnergyMeter();
     	energyMeter.setEnergyMeterName("NP71E.1-2-1");
		energyMeter.setPhaseNumber(1);

		jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS energymeter(id INT NOT NULL AUTO_INCREMENT,em VARCHAR(45) NOT NULL,phn INT NOT NULL,  PRIMARY KEY (id))");

		jdbcEnergyMeterRepository.insert(energyMeter);
        System.out.println(jdbcEnergyMeterRepository.findByEnergyMeterId(1).getEnergyMeterName());
 		jdbcTemplate.execute("create table if not exists mytable2 (id integer, name varchar(100))");
		//System.out.println(jdbcTemplate);
	}

}
