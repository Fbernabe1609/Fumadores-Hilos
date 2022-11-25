package org.example;

public class Tobacconist extends Thread {
    private SmokeShop smokeShop;
    private int putTime = 2300;

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
            System.out.println("El estanquero no pone el ingrediente " + notAvailableProduct + "(" + smokeShop.getIngredients().get(notAvailableProduct) + ").");
            try {
                sleep(putTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
