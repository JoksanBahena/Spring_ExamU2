package com.example.ExamU2_JBP.models.client;

import com.example.ExamU2_JBP.models.facture.Facture;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "clients")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Client {
    @Id
    @GeneratedValue(generator = "id", strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "lastname", nullable = false, length = 100)
    private String lastname;

    @Column(name = "direction", nullable = false, length = 255)
    private String direction;

    @Column(name = "birthday", nullable = false)
    private String birthday;

    @Column(name = "phone_number", nullable = false)
    private String phone_number;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "category", nullable = false)
    private String category;

    @OneToMany(mappedBy = "client")
    private Set<Facture> factures;
}
