package org.example;

public class Smoker extends Thread {

    private int ingredient;
    private SmokeShop smokeShop;

    public Smoker(int ingredient, SmokeShop smokeShop) {
        this.ingredient = ingredient;
        this.smokeShop = smokeShop;
    }

    public int getIngredient() {
        return ingredient;
    }

    public void setIngredient(int ingredient) {
        this.ingredient = ingredient;
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
            smokeShop.getIngredient(this.ingredient);
            System.out.println("El fumador " + ingredient + " va a fumar.");
            try {
                sleep(2200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("El fumador " + ingredient + " ha terminado de fumar.");
        }
    }
}
