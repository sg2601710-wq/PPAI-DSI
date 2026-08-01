package com.G1_DSI.PPAI.repository;

import com.G1_DSI.PPAI.model.Rol;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRolRepository extends JpaRepository<Rol, String> {
}
