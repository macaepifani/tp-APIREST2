package com.example.inicial1.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.envers.Audited;
import java.util.ArrayList;
import java.util.List;

//Lombok
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
//JPA
@Entity
@Table(name = "Libro")
//Envers
@Audited

public class Libro extends Base{
    @Column(name = "Fecha_Publicacion")
    private int fecha;
    @Column(name = "Genero")
    private String genero;
    @Column(name = "Cantidad_Paginas")
    private int paginas;
    @Column(name = "Titulo")
    private String titulo;

    @ManyToMany(cascade = {CascadeType.REFRESH})
    @JoinTable(name = "LibroAutor", joinColumns = @JoinColumn(name = "LibroID"), inverseJoinColumns = @JoinColumn(name = "AutorID"))
    private List<Autor> autores = new ArrayList<Autor>();
}
