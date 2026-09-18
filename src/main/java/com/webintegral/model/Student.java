package com.webintegral.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
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