package com.secretaria.api_academia.model;

import com.secretaria.api_academia.dto.DadosStudent;
import com.secretaria.api_academia.status.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

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
    private Date dataIncial = new Date();
    private Date dataFinal = new Date();
    private String descricao;
    private String email;
    private String telephone;
    private Double valorMensalidade;
    private Double valorPago;
    private Date dataPagamento;
    private Status status;


//    @ManyToOne
//    private Classroom aulaDesejada;

    public Student(DadosStudent dados) {
        this.name = dados.name();
        this.email = dados.email();
        this.cpf = dados.cpf();
        this.telephone = dados.telephone();
        this.dataPagamento = dados.dataPagamento();
        this.valorMensalidade = dados.valorMensalidade();
        this.valorPago = dados.valorPago();
        this.descricao = dados.descricao();

    }
}
