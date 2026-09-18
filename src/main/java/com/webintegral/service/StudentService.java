package com.webintegral.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.webintegral.dto.StudentDto;
import com.webintegral.model.Student;
import com.webintegral.repository.StudentRepository;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<StudentDto> findAll() {
        return studentRepository.findAll().stream()
                .map(Student::toDto)
                .toList();
    }
}
