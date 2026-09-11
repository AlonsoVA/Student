package com.webintegral.controller;

import com.webintegral.dto.StudentDto;
import com.webintegral.model.Student;
import com.webintegral.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentRepository studentRepository;

    @GetMapping
    public List<StudentDto> findAll() {
        return studentRepository.findAll().stream()
                .map(Student::toDto)
                .toList();
    }

    @GetMapping("/{id}")
    public StudentDto findById(@PathVariable Integer id) {
        return studentRepository.findById(id)
                .map(Student::toDto)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public StudentDto create(@RequestBody StudentDto studentDto) {
        Student student = Student.builder()
                .name(studentDto.getName())
                .lastName(studentDto.getLastName())
                .phone(studentDto.getPhone())
                .email(studentDto.getEmail())
                .build();
        return studentRepository.save(student).toDto();
    }

    @PutMapping("/{id}")
    public StudentDto update(@PathVariable Integer id, @RequestBody StudentDto studentDto) {
        Student existing = studentRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found"));

        existing.setName(studentDto.getName());
        existing.setLastName(studentDto.getLastName());
        existing.setPhone(studentDto.getPhone());
        existing.setEmail(studentDto.getEmail());

        return studentRepository.save(existing).toDto();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        if (!studentRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found");
        }
        studentRepository.deleteById(id);
    }
}
