package com.astro.predictionservice.model;

import jakarta.persistence.*;

@Entity
public class Prediction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String zodiacSign;
    private String predictionText;

    // Constructors
    public Prediction() {}

    public Prediction(String zodiacSign, String predictionText) {
        this.zodiacSign = zodiacSign;
        this.predictionText = predictionText;
    }

    // Getters & Setters
    public Long getId() {
        return id;
    }

    public String getZodiacSign() {
        return zodiacSign;
    }

    public void setZodiacSign(String zodiacSign) {
        this.zodiacSign = zodiacSign;
    }

    public String getPredictionText() {
        return predictionText;
    }

    public void setPredictionText(String predictionText) {
        this.predictionText = predictionText;
    }
}
