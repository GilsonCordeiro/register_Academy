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

    public StudentController(StudentService service) {
        this.service = service;
    }

    StudentService service;

    @PostMapping
    public ResponseEntity<Student> saverStudent(@RequestBody DadosStudent dados) {
        var student = service.salvarStudent(dados);
        URI location = URI.create("/student/"+student.getId());
        return ResponseEntity.created(location).body(student);
    }
    @GetMapping
    public ResponseEntity<List<DadosStudent>> listAllStudent() {
        var list = service.listarAll();
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }
    @GetMapping("/pendente")
    public List<Student> searchPendente() {
        return service.searchPgPendente();
    }
    @GetMapping("/cancelados")
    public List<Student> searchCancelados() {
        return service.searchPgCancelados();
    }


    @GetMapping("/{id}")
    public ResponseEntity<Student> findByIdStudent(@PathVariable Long id) {
        var student = service.buscarPorId(id);
        return ResponseEntity.status(HttpStatus.OK).body(student);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Student> updateById(@RequestBody Student dados) {
        var student = service.updateStudent(dados);
        return ResponseEntity.status(HttpStatus.OK).body(student);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
         service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }

}
