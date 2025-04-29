package com.astro.predictionservice.controller;

import com.astro.predictionservice.model.Prediction;
import com.astro.predictionservice.repository.PredictionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/predictions")
public class PredictionController {

    @Autowired
    private PredictionRepository predictionRepository;

    // Get prediction by zodiac sign
    @GetMapping("/{sign}")
    public Prediction getPredictionBySign(@PathVariable String sign) {
        Optional<Prediction> prediction = predictionRepository.findByZodiacSign(sign);
        return prediction.orElseThrow(() -> new RuntimeException("Prediction not found"));
    }

    // Add new prediction
    @PostMapping
    public Prediction createPrediction(@RequestBody Prediction prediction) {
        return predictionRepository.save(prediction);
    }
}
