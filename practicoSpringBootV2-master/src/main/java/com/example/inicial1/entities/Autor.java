package com.example.inicial1.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.envers.Audited;

//Lombok
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
//JPA
@Entity
@Table(name = "Autor")
//Envers
@Audited

public class Autor extends Base{
    @Column(name = "Apellido")
    private String apellido;
    @Column(name = "Nombre")
    private String nombre;
    @Column(name = "Biografia")
    private String biografia;
}
