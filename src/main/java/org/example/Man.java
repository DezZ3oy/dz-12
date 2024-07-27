package org.example;

public class Man extends Person {
    public Man(String firstName, String lastName, int age) {
        super(firstName, lastName, age);
    }

    public boolean isRetired() {
        return this.age > 65;
    }

    public void registerPartnership(Woman woman) {
        if (this.partner != null || woman.getPartner() != null) {
            System.out.println("Один з партнерів вже заручений!");
            return;
        }
        this.partner = woman;
        woman.setPartner(this);
        woman.setLastName(this.lastName);
    }

    public void deregisterPartnership(boolean returnToMaidenName) {
        if (this.partner instanceof Woman) {
            Woman womanPartner = (Woman) this.partner;
            if (returnToMaidenName) {
                womanPartner.setLastName(womanPartner.getOriginalLastName());
            }
            womanPartner.setPartner(null);
        }
        this.partner = null;
    }
}
