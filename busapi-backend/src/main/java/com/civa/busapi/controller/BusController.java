package com.civa.busapi.controller;

import com.civa.busapi.model.Bus;
import com.civa.busapi.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bus")
public class BusController {

    @Autowired
    private BusService busService;

    @GetMapping
    public List<Bus> obtenerTodos() {
        return busService.listarTodos();
    }

    @GetMapping("/paginado")
    public ResponseEntity<Page<Bus>> obtenerPaginado(@RequestParam(defaultValue = "0") int page,
                                                     @RequestParam(defaultValue = "5") int size) {
        PageRequest pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(busService.listarPaginado(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bus> obtenerPorId(@PathVariable Long id) {
        Bus bus = busService.obtenerPorId(id);
        if (bus == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(bus);
    }

    @PostMapping
    public ResponseEntity<Bus> crearBus(@RequestBody Bus bus) {
        Bus nuevoBus = busService.guardar(bus);
        Bus completo = busService.obtenerPorId(nuevoBus.getId());
        return ResponseEntity.ok(completo);
    }
}