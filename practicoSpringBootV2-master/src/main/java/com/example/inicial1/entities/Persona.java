package com.example.inicial1.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.envers.Audited;

import java.util.ArrayList;
import java.util.List;

//Lombok
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder
//Envers
@Audited
//JPA
@Entity
@Table(name = "Persona")

public class Persona extends Base {
    @Column(name = "Nombre")
    private String nombre;
    @Column(name = "Apellido")
    private String apellido;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinTable(name = "PersonaLibro", joinColumns = @JoinColumn(name = "PersonaID"), inverseJoinColumns = @JoinColumn(name = "LibroID"))
    @Builder.Default
    private List<Libro> libros = new ArrayList<Libro>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "FK_Domicilio")
    private Domicilio domicilio;
}

