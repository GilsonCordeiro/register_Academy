package com.secretaria.api_academia.repository;

import com.secretaria.api_academia.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query("select s from Student s where s.valorPago IS NOT NULL and s.valorPago > 0")
    List<Student> searchPagamentoPendente();

    //@Query("select s from Student s where s.status = 2")
    @Query("select s from Student s where s.status = 2")

    List<Student> searchPagamentoCancelados();
}
