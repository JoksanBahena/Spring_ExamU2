package com.example.ExamU2_JBP.models.client;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Long> {
    Optional<Client> findById(Long id);
    Optional<Client> findByEmail(String email);

    boolean existsByEmail(String email);
}
