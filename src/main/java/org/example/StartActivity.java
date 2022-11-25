package org.example;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class StartActivity {
    public static void startActivity() {
        SmokeShop smokeShop = new SmokeShop();
        ArrayList<Smoker> smokers = new ArrayList<>() {{
            add(new Smoker(0, smokeShop));
            add(new Smoker(1, smokeShop));
            add(new Smoker(2, smokeShop));
        }};
        ExecutorService executor = Executors.newFixedThreadPool(4);
        for (Smoker smoker : smokers) {
            executor.execute(smoker);
        }
        executor.execute(new Tobacconist(smokeShop));
        executor.shutdown();
    }
}
