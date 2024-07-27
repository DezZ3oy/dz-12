package org.example;

public class App {
    public static void main(String[] args) {
        Man man1 = new Man("Владислав", "Тригуб", 24);
        Man man2 = new Man("Олексій", "Бойко", 42);
        Man man3 = new Man("Ігнат", "Степура", 73);

        Woman woman1 = new Woman("Крістіна", "Бондаренко", 20);
        Woman woman2 = new Woman("Ірина", "Когач", 34);
        Woman woman3 = new Woman("Катерина", "Кіпкало", 66);

        Person[] people = {man1, man2, man3, woman1, woman2, woman3};

        System.out.println("------------------------------");
        
        for (Person person : people) {
            System.out.printf("%-10s %-10s %-5d\n", person.getLastName(), person.getFirstName(), person.getAge());
        }


        System.out.println("------------------------------------------------------------------------");


        for (Person person : people) {
            if (person instanceof Man) {
                Man man = (Man) person;
                System.out.println(man.getLastName()+ " " +  man.getFirstName()+ " є в списку пенсіонерів? -> " + man.isRetired());
            } else if (person instanceof Woman) {
                Woman woman = (Woman) person;
                System.out.println(woman.getLastName() + " " + woman.getFirstName() + " є в списку пенсіонерів? -> " + woman.isRetired());
            }
        }

        System.out.println("------------------------------------------------------------------------");

        Man[] men = {man1, man2, man3};
        Woman[] women = {woman1, woman2, woman3};

        for (int i = 0; i < men.length; i++) {
            Man man = men[i];
            Woman woman = women[i];

            man.registerPartnership(woman);
            System.out.println(woman.getFirstName() + " змінила своє прізвище після одруження на: " + woman.getLastName());

            man.deregisterPartnership(true);
            System.out.println(woman.getFirstName() + " повернула своє прізвище після розлучення на: " + woman.getLastName());
        }
        System.out.println("------------------------------------------------------------------------");
    }
}
