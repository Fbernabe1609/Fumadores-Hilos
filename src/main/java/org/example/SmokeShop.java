package org.example;

import java.util.ArrayList;

public class SmokeShop {

    private int notAvailable;
    private boolean emptyTable = false;
    private ArrayList<String> ingredients = new ArrayList<>() {{
        add("Tabaco");
        add("Papel");
        add("Fósforo");
    }};

    public ArrayList<String> getIngredients() {
        return ingredients;
    }

    public int getNotAvailable() {
        return notAvailable;
    }

    public void setNotAvailable(int notAvailable) {
        this.notAvailable = notAvailable;
    }

    public boolean isEmptyTable() {
        return emptyTable;
    }

    public void setEmptyTable(boolean emptyTable) {
        this.emptyTable = emptyTable;
    }

    public void setIngredients(ArrayList<String> ingredients) {
        this.ingredients = ingredients;
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
        notifyAll();
    }

    public synchronized void getIngredient(int clientIngredient) {
        while (!this.emptyTable || clientIngredient != this.notAvailable) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.emptyTable = false;
        notify();
    }
}