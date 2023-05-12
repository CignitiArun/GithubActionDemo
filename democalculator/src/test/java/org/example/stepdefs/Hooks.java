package org.example.stepdefs;

import io.cucumber.core.api.Scenario;
import io.cucumber.java.Before;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.example.World;
import org.example.pojos.CalculatorSoap;
import org.example.utils.Constants;

public class Hooks {

    World world;

    public Hooks(World world) {
        this.world = world;
    }

    @Before
    public void initialise() {
        JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
        factory.setServiceClass(CalculatorSoap.class);
        factory.setAddress(Constants.TEST_URL);
        world.calculatorSoapIns = (CalculatorSoap) factory.create();
    }
}
