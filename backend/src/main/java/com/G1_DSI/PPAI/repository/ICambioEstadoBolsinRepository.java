package com.G1_DSI.PPAI.repository;

import com.G1_DSI.PPAI.model.CambioEstadoBolsin;
import com.G1_DSI.PPAI.model.CambioEstadoBolsinId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICambioEstadoBolsinRepository extends JpaRepository<CambioEstadoBolsin, CambioEstadoBolsinId> {
}
