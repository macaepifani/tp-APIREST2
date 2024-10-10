package com.example.inicial1.repositories;

import com.example.inicial1.entities.Persona;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PersonaRepository extends BaseRepository<Persona,Long> {
    //Metodo de query
    List<Persona> findByNombreContainingOrApellidoContaining(String nombre, String apellido);
    Page<Persona> findByNombreContainingOrApellidoContaining(String nombre, String apellido, Pageable pageable);

    //JPQL
    @Query(value = "SELECT p FROM Persona p WHERE p.nombre LIKE %:filtro% OR p.apellido LIKE %:filtro%")
    List<Persona> search(@Param("filtro") String filtro);

    @Query(value = "SELECT p FROM Persona p WHERE p.nombre LIKE %:filtro% OR p.apellido LIKE %:filtro%")
    Page<Persona> search(@Param("filtro") String filtro, Pageable pageable);

    //SQL
    @Query(
            value = "SELECT * FROM PERSONA WHERE PERSONA.NOMBRE LIKE %:filtro% OR persona.apellido LIKE %:filtro%",
                     //SELECT * FROM PERSONA WHERE PERSONA.NOMBRE LIKE '%Augusto%' OR PERSONA.APELLIDO LIKE '%Abaca%'
            nativeQuery = true
    )
    List<Persona> searchNativo(@Param("filtro") String filtro);

    @Query(
            value = "SELECT * FROM PERSONA WHERE PERSONA.NOMBRE LIKE %:filtro% OR persona.apellido LIKE %:filtro%",
            //SELECT * FROM PERSONA WHERE PERSONA.NOMBRE LIKE '%Augusto%' OR PERSONA.APELLIDO LIKE '%Abaca%'
            countQuery = "SELECT count(*) FROM persona",
            nativeQuery = true
    )
    Page<Persona> searchNativo(@Param("filtro") String filtro, Pageable pageable);
}