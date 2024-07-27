package org.example;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ManTest {

    @DataProvider(name = "manDataProvider")
    public Object[][] manDataProvider() {
        return new Object[][] {
                {"Владислав", "Тригуб", 24},
                {"Олексій", "Бойко", 42},
                {"Ігнат", "Степура", 73}
        };
    }

    @Test(dataProvider = "manDataProvider")
    public void testMan(String firstName, String lastName, int age) {
        Man man = new Man(firstName, lastName, age);
        Assert.assertEquals(man.getFirstName(), firstName);
        Assert.assertEquals(man.getLastName(), lastName);
        Assert.assertEquals(man.getAge(), age);
        Assert.assertEquals(man.isRetired(), age > 65);
    }

    @DataProvider(name = "partnershipProvider")
    public Object[][] partnershipProvider() {
        return new Object[][] {
                {new Man("Владислав", "Тригуб", 24), new Woman("Крістіна", "Бондаренко", 20)},
                {new Man("Олексій", "Бойко", 42), new Woman("Ірина", "Когач", 34)},
                {new Man("Ігнат", "Степура", 73), new Woman("Катерина", "Кіпкало", 66)}
        };
    }

    @Test(dataProvider = "partnershipProvider")
    public void testPartnershipRegistration(Man man, Woman woman) {
        man.registerPartnership(woman);
        Assert.assertEquals(woman.getLastName(), man.getLastName());
        Assert.assertEquals(man.getPartner(), woman);
        Assert.assertEquals(woman.getPartner(), man);
    }

    @Test(dataProvider = "partnershipProvider")
    public void testPartnershipDeregistration(Man man, Woman woman) {
        man.registerPartnership(woman);
        man.deregisterPartnership(true);
        Assert.assertEquals(woman.getLastName(), woman.getOriginalLastName());
        Assert.assertNull(man.getPartner());
        Assert.assertNull(woman.getPartner());
    }

    @DataProvider(name = "setterGetterProvider")
    public Object[][] setterGetterProvider() {
        return new Object[][] {
                {"Владислав", "Тригуб", 24},
                {"Олексій", "Бойко", 42},
                {"Ігнат", "Степура", 73}
        };
    }

    @Test(dataProvider = "setterGetterProvider")
    public void testSettersAndGetters(String firstName, String lastName, int age) {
        Man man = new Man(firstName, lastName, age);
        man.setFirstName(firstName);
        man.setLastName(lastName);
        man.setAge(age);

        Assert.assertEquals(man.getFirstName(), firstName);
        Assert.assertEquals(man.getLastName(), lastName);
        Assert.assertEquals(man.getAge(), age);
    }
}
