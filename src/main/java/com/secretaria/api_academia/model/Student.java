package com.secretaria.api_academia.model;

import com.secretaria.api_academia.dto.DadosStudent;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "tb_students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String cpf;
    private String email;
    private String telephone;

    @ManyToOne
    private Classroom aulaDesejada;

    public Student(DadosStudent dados) {
        this.name = dados.name();
        this.email = dados.email();
        this.telephone = dados.telephone();
    }
}
