package com.secretaria.api_academia.controller;

import com.secretaria.api_academia.dto.DadosStudent;
import com.secretaria.api_academia.model.Student;
import com.secretaria.api_academia.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RequestMapping("/students" )
@RestController
public class StudentController {
    @Autowired
    StudentService service;

    @PostMapping
    public ResponseEntity<Student> saverStudent(@RequestBody DadosStudent dados) {
        var student = service.salvarStudent(dados);
        URI location = URI.create("/student/"+student.getId());
        return ResponseEntity.created(location).body(student);
    }
    @GetMapping
    public ResponseEntity<List<DadosStudent>> listStudent() {
        var list = service.listarAll();
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }
}
