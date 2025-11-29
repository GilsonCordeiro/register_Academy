package com.secretaria.api_academia.dto;

import com.secretaria.api_academia.model.Student;

public record DadosStudent(
        String name,
        String email,
        String telephone
) {
    public DadosStudent(Student student) {
        this(student.getName(), student.getEmail(), student.getTelephone());
    }
}
