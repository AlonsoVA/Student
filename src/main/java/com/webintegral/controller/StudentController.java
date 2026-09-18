package com.webintegral.controller;

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

// Controlador REST para la gestión de estudiantes
@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

    // Inyección del repositorio de estudiantes
    private final StudentRepository studentRepository;

    // Obtiene la lista de todos los estudiantes
    @GetMapping
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    // Busca un estudiante por su ID
    @GetMapping("/{id}")
    public Student findById(@PathVariable Integer id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found"));
    }

    // Crea un nuevo estudiante
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Student create(@RequestBody Student student) {
        student.setId(null);
        return studentRepository.save(student);
    }

    // Actualiza los datos de un estudiante existente
    @PutMapping("/{id}")
    public Student update(@PathVariable Integer id, @RequestBody Student student) {
        Student existing = studentRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found"));

        existing.setName(student.getName());
        existing.setLastName(student.getLastName());
        existing.setPhone(student.getPhone());
        existing.setEmail(student.getEmail());

        return studentRepository.save(existing);
    }

    // Elimina un estudiante por su ID
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        if (!studentRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found");
        }
        studentRepository.deleteById(id);
    }
}