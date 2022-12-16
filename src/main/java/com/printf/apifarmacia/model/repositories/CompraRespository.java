package com.printf.apifarmacia.model.repositories;

import com.printf.apifarmacia.model.entities.Compra;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompraRespository extends JpaRepository<Compra, Long> {
}
