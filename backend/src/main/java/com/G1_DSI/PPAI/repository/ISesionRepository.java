package com.G1_DSI.PPAI.repository;

import com.G1_DSI.PPAI.model.Sesion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISesionRepository extends JpaRepository<Sesion, Integer> {
}
