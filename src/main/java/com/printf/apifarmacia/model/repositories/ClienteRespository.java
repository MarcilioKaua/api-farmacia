package com.printf.apifarmacia.model.repositories;

import com.printf.apifarmacia.model.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRespository extends JpaRepository<Cliente, Long> {
}
