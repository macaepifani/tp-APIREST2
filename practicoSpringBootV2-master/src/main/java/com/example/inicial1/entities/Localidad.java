package com.example.inicial1.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.envers.Audited;

//Lombok
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
//JPA
@Entity
@Table(name = "Localidad")
//Envers
@Audited

public class Localidad extends Base{
    @Column(name = "Denominacion")
    private String denominacion;
}
