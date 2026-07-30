package com.G1_DSI.PPAI.repository;

import com.G1_DSI.PPAI.model.Bolsin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBolsinRepository extends JpaRepository<Bolsin, Integer> {
}
