package com.astro.predictionservice.repository;

import com.astro.predictionservice.model.Prediction;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface PredictionRepository extends JpaRepository<Prediction, Long> {
    Optional<Prediction> findByZodiacSign(String zodiacSign);
}
