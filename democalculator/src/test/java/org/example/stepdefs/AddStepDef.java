package org.example.stepdefs;

import io.cucumber.java.en.Given;
import org.example.World;

public class AddStepDef {
    World world;

   public AddStepDef(World world) {
        this.world = world;
    }

    @Given("I add {int} and {int}")
    public void iAddAndTheADDServiceShouldReturnMe(int arg0, int arg1) {
        world.addServiceResponse = world.calculatorSoapIns.add(arg0, arg1);
    }

}
