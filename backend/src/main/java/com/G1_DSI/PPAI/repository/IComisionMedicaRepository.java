package com.G1_DSI.PPAI.repository;

import com.G1_DSI.PPAI.model.ComisionMedica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IComisionMedicaRepository extends JpaRepository<ComisionMedica, Integer> {
}
