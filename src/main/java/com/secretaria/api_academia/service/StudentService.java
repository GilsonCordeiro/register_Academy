package com.secretaria.api_academia.service;

import com.secretaria.api_academia.dto.DadosStudent;
import com.secretaria.api_academia.model.Student;
import com.secretaria.api_academia.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepository repository;

    public List<DadosStudent> listarAll() {
        var list = repository.findAll().stream().map(DadosStudent::new).toList();
        return list;
    }

    public Student salvarStudent(DadosStudent dados) {
        var newStudent = repository.save(new Student(dados));
        return newStudent;
    }


    public Student buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }
}
