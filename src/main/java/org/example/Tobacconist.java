package org.example;

import java.util.ArrayList;

public class Tobacconist extends Thread {
    SmokeShop smokeShop;

    public Tobacconist(SmokeShop smokeShop) {
        this.smokeShop = smokeShop;
    }

    public SmokeShop getSmokeShop() {
        return smokeShop;
    }

    public void setSmokeShop(SmokeShop smokeShop) {
        this.smokeShop = smokeShop;
    }

    @Override
    public void run() {
        while (true) {
            int notAvailableProduct = (int) (Math.random() * 3);
            smokeShop.putIngredient(notAvailableProduct);
            try {
                sleep(2300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
