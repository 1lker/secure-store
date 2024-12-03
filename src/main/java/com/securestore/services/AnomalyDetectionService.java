package com.securestore.services;

import java.util.Random;

public class AnomalyDetectionService {
    private Random random = new Random();

    public AnomalyDetectionService() {
        // Boş constructor
    }

    public boolean isAnomalousActivity(double[] features) {
        // Rastgele bir değer döndür
        return random.nextBoolean();
    }
}
