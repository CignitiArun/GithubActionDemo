package org.example.stepdefs;

import org.example.World;
import org.testng.Assert;

import io.cucumber.java.en.Then;

public class AssertionStepDef {

    World world;

    public AssertionStepDef(World world) {
        this.world = world;
    }

    @Then("ADD service should return me {int}")
    public void addServiceShouldReturnMe(int arg0) {
        Assert.assertEquals(world.addServiceResponse, arg0, "ADD service is not working as expected");
    }
    
    @Then("Subtract service should return me {int}")
    public void subServiceShouldReturnMe(int arg0) {
        Assert.assertEquals(world.subtractServiceResponse, arg0, "ADD service is not working as expected");
    }
    
    @Then("Multiply service should return me {int}")
    public void mulServiceShouldReturnMe(int arg0) {
        Assert.assertEquals(world.multiplyServiceResponse, arg0, "ADD service is not working as expected");
    }
    
    @Then("Divide service should return me {int}")
    public void divServiceShouldReturnMe(int arg0) {
        Assert.assertEquals(world.divideServiceResponse, arg0, "ADD service is not working as expected");
    }
    
}
