package com.civa.busapi.service;

import com.civa.busapi.model.Bus;
import com.civa.busapi.model.Marca;
import com.civa.busapi.repository.BusRepository;
import com.civa.busapi.repository.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusService {

    @Autowired
    private BusRepository busRepository;

    @Autowired
    private MarcaRepository marcaRepository;

    public List<Bus> listarTodos() {
        return busRepository.findAll();
    }

    public Page<Bus> listarPaginado(Pageable pageable) {
        return busRepository.findAll(pageable);
    }

    public Bus obtenerPorId(Long id) {
        return busRepository.findById(id).orElse(null);
    }

    public Bus guardar(Bus bus) {
        Marca marcaCompleta = marcaRepository.findById(bus.getMarca().getId()).orElse(null);
        bus.setMarca(marcaCompleta);
        Bus nuevoBus = busRepository.save(bus);
        return busRepository.findById(nuevoBus.getId()).orElse(null);
    }
}