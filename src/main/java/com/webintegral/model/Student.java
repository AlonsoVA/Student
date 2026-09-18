package com.webintegral.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.webintegral.dto.StudentDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "student")
// Entidad que representa a un estudiante en la base de datos
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Identificador único del estudiante
    private Integer id;
<<<<<<< HEAD
    @Column(name = "name", columnDefinition = "varchar(80)")
    private String name;
    @Column(name = "last_name", columnDefinition = "varchar(50)")
    private String lastName;
    @Column(name = "phone", columnDefinition = "varchar(20)")
    private String phone;
    @Column(name = "email", columnDefinition = "varchar(80)")
    private String email;

    public StudentDto toDto() {
        return StudentDto.builder()
                .id(this.id)
                .name(this.name)
                .lastName(this.lastName)
                .phone(this.phone)
                .email(this.email)
                .build();
    }

    @SneakyThrows
    @Override
    public String toString() {
        return new ObjectMapper().writeValueAsString(this);
    }
}
=======

    @Column(length = 80)
    // Nombre del estudiante
    private String name;

    @Column(name = "last_name", length = 80)
    // Apellido del estudiante
    private String lastName;

    @Column(length = 20)
    // Teléfono de contacto
    private String phone;

    @Column(length = 80)
    // Correo electrónico
    private String email;
}
>>>>>>> MolinaDev
