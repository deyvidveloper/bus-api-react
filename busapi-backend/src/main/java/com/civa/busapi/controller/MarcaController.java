package com.civa.busapi.controller;

import com.civa.busapi.model.Marca;
import com.civa.busapi.service.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/marca")
public class MarcaController {

    @Autowired
    private MarcaService marcaService;

    @GetMapping
    public List<Marca> obtenerTodas() {
        return marcaService.listarTodas();
    }

    @PostMapping
    public Marca crearMarca(@RequestBody Marca marca) {
        return marcaService.guardar(marca);
    }
}