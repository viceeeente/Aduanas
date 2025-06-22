package com.Aduanas.Aduana.repository;

import com.Aduanas.Aduana.model.TramiteFormularioSalidaOIngreso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TramiteRepository extends JpaRepository<TramiteFormularioSalidaOIngreso, Long> {
}
