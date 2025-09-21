package com.civa.busapi.repository;

import com.civa.busapi.model.Bus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusRepository extends JpaRepository<Bus, Long> {
    Page<Bus> findAll(Pageable pageable);
}