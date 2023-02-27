package com.example.ExamU2_JBP.models.facture;

import com.example.ExamU2_JBP.models.client.Client;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

@Entity
@Table(name = "factures")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Facture {
    @Id
    @GeneratedValue(generator = "id", strategy = GenerationType.IDENTITY)
    private Long Id;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @Column(name = "date", nullable = false, columnDefinition = "datetime default current_timestamp", insertable = false, updatable = false)
    private String date;
}
