package com.secretaria.api_academia.repository;

import com.secretaria.api_academia.model.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ClasroomRepository extends JpaRepository<Classroom, Long> {
}
