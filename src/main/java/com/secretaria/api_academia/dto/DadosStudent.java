package com.secretaria.api_academia.dto;

import com.secretaria.api_academia.model.Student;
import com.secretaria.api_academia.status.Status;

import java.util.Date;

public record DadosStudent(
        String name,
        String email,
        String cpf,
        String telephone,
        String descricao,
        Double valorMensalidade,
        Double valorPago,
        Date dataPagamento,
        Status status
        ) {
    public DadosStudent(Student student) {
        this(student.getName(),
                student.getEmail(),
                student.getCpf(),
                student.getTelephone(),
                student.getDescricao(),
                student.getValorMensalidade(),
                student.getValorPago(),
                student.getDataPagamento(),
                student.getStatus()
        );
    }
}
