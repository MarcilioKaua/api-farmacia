package com.printf.apifarmacia.model.repositories;

import com.printf.apifarmacia.model.entities.Medicamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicamentoRespository extends JpaRepository<Medicamento, Long> {
}
