package com.example.inicial1.services;

import com.example.inicial1.entities.Localidad;
import com.example.inicial1.repositories.BaseRepository;
import org.springframework.stereotype.Service;

@Service
public class LocalidadServiceImplem extends BaseServiceImplem<Localidad, Long> implements LocalidadService {

    public LocalidadServiceImplem(BaseRepository<Localidad, Long> baseRepository) {
        super(baseRepository);
    }
}
