package com.G1_DSI.PPAI.repository;

import com.G1_DSI.PPAI.model.Estado;
import com.G1_DSI.PPAI.model.EstadoId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEstadoRepository extends JpaRepository<Estado, EstadoId> {
}
