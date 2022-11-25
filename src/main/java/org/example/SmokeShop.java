package org.example;

import java.util.ArrayList;

public class SmokeShop {

    private int notAvailable;
    private boolean emptyTable = false;

    private ArrayList<String> ingredients = new ArrayList<>() {{
        add("Tabaco");
        add("Fósforo");
        add("Papel");
    }};

    public synchronized void getIngredient(int clientIngredient) {
        while (clientIngredient != this.notAvailable || !this.emptyTable) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.emptyTable = false;
        notify();
    }

    public synchronized void putIngredient(int notAvailable) {
        while (this.emptyTable) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.emptyTable = true;
        this.notAvailable = notAvailable;
        System.out.println("El estanquero no pone el ingrediente: " + notAvailable + "(" + ingredients.get(notAvailable) + ").");
        notifyAll();
    }
}