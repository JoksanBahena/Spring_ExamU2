package com.example.ExamU2_JBP.models.details;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DetailsRepository extends JpaRepository<Details, Long> {
    Optional<Details> findById(Long id);
    Optional<Details> findByFacture_id(Long facture_id);
    Optional<Details> findByProduct_id(Long product_id);
}
