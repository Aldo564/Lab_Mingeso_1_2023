package com.Mingeso_Aldo.Pep1.Repositories;

import com.Mingeso_Aldo.Pep1.Entities.PorcentajeEntity;
import com.Mingeso_Aldo.Pep1.Entities.ProveedorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface PorcentajeRepository extends JpaRepository<PorcentajeEntity, String> {


}
