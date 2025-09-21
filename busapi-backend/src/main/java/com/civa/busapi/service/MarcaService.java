package com.civa.busapi.service;

import com.civa.busapi.model.Marca;
import com.civa.busapi.repository.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarcaService {

    @Autowired
    private MarcaRepository marcaRepository;

    public List<Marca> listarTodas() {
        return marcaRepository.findAll();
    }

    public Marca guardar(Marca marca) {
        return marcaRepository.save(marca);
    }
}