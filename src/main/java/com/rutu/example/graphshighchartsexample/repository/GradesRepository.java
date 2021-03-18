package com.rutu.example.graphshighchartsexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rutu.example.graphshighchartsexample.entity.Grades;

@Repository
public interface GradesRepository extends JpaRepository<Grades, Integer>{

}
