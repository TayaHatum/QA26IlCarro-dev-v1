package com.telranqa26.tests;

import com.telranqa26.model.Car;
import org.testng.annotations.Test;

public class CarCreationTest extends TestBase{

    @Test
    public void testCarCreation() throws InterruptedException {
        app.getCarHelper().initAddingNewCar();

        app.getCarHelper().fillCarForm(
                new Car().withContry("Israel")
                .withAddress( "Herzel1").withDistance( "500")
                .withSerial_number("233-67-222").withBrand("Honda")
                .withModel("Civic").withYear("2015").withEngine("HC325679YH")
                .withFuel_consumption("6.5").withFuel("petrol")
                .withTransmition("full Drive").withwD("4WD")
                .withHorsepower("149").withTorque("120").withDoors("5")
                .withSeats("5").withClasS("C").withAbout("Very good car")
                .withFeature("no smoking").withPrice("55"));
        app.getCarHelper().pause(3000);
        app.getCarHelper().clickYallaButton();
    }


}
