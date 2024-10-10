package com.example.inicial1.entities;

import  jakarta.persistence.*;
import lombok.*;
import org.hibernate.envers.Audited;

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
@Table(name = "Domicilio")

public class Domicilio extends Base {
    @Column(name = "Calle")
    private String calle;
    @Column(name = "Numero")
    private int numero;

    @ManyToOne
    @JoinColumn(name = "FK_Localidad")
    private Localidad localidad;

}

