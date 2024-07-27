package org.example;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class WomanTest {

    @DataProvider(name = "womanDataProvider")
    public Object[][] womanDataProvider() {
        return new Object[][] {
                {"Крістіна", "Бондаренко", 20},
                {"Ірина", "Когач", 34},
                {"Катерина", "Кіпкало", 66}
        };
    }

    @Test(dataProvider = "womanDataProvider")
    public void testWoman(String firstName, String lastName, int age) {
        Woman woman = new Woman(firstName, lastName, age);
        Assert.assertEquals(woman.getFirstName(), firstName);
        Assert.assertEquals(woman.getLastName(), lastName);
        Assert.assertEquals(woman.getAge(), age);
        Assert.assertEquals(woman.isRetired(), age > 60);
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
                {"Крістіна", "Бондаренко", 20},
                {"Ірина", "Когач", 34},
                {"Катерина", "Кіпкало", 66}
        };
    }

    @Test(dataProvider = "setterGetterProvider")
    public void testSettersAndGetters(String firstName, String lastName, int age) {
        Woman woman = new Woman(firstName, lastName, age);
        woman.setFirstName(firstName);
        woman.setLastName(lastName);
        woman.setAge(age);

        Assert.assertEquals(woman.getFirstName(), firstName);
        Assert.assertEquals(woman.getLastName(), lastName);
        Assert.assertEquals(woman.getAge(), age);
    }
}
