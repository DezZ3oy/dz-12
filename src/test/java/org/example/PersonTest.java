package org.example;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PersonTest {

    @Test
    public void testSettersAndGetters() {
        Person person = new Person("Олександр", "Джонсон", 40);
        person.setFirstName("Олег");
        person.setLastName("Пауль");
        person.setAge(45);

        Assert.assertEquals(person.getFirstName(), "Олег", "Ім'я має бути Олег");
        Assert.assertEquals(person.getLastName(), "Пауль", "Прізвище має бути Пауль");
        Assert.assertEquals(person.getAge(), 45, "Вік повинен бути 45");
    }

    @Test
    public void testPartner() {
        Person person1 = new Person("Остап", "Хоменко", 40);
        Person person2 = new Person("Соломія", "Фещенко", 35);

        person1.setPartner(person2);
        Assert.assertEquals(person1.getPartner(), person2, "Партнером має бути person2");
    }
}