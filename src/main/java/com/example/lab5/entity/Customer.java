package com.example.lab5.entity;

import jakarta.persistence.*;
import lombok.Data;
import jakarta.validation.constraints.*;

@Entity
@Data
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "El nombre es requerido")
    @Column(name = "name")
    private String name;

    @NotBlank(message = "El tipo de documento es requerido")
    @Column(name = "document_type", nullable = false)
    private String documentType;

    @NotBlank(message = "El nombre es requerido")
    @Column(name = "document", unique = true, nullable = false)
    private String document;
}





