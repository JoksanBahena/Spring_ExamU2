package com.example.ExamU2_JBP.models.facture;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FactureRepository extends JpaRepository<Facture, Long> {
    Optional<Facture> findById(Long id);
    Optional<Facture> findByClient_id(Long client_id);

}
