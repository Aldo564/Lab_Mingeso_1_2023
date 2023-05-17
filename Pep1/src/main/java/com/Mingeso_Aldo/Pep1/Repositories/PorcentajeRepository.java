package com.Mingeso_Aldo.Pep1.Repositories;

import com.Mingeso_Aldo.Pep1.Entities.AcopioEntity;
import com.Mingeso_Aldo.Pep1.Entities.PorcentajeEntity;
import com.Mingeso_Aldo.Pep1.Services.PorcentajeService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface PorcentajeRepository extends JpaRepository<PorcentajeEntity, String> {

    @Query("select e from PorcentajeEntity e where e.cod_proveedor = :codigo")
    ArrayList<PorcentajeEntity> findByCodigo(String codigo);

    @Query("select e from PorcentajeEntity e")
    ArrayList<PorcentajeEntity> getAll();

    @Query("select e from PorcentajeEntity e where e.cod_proveedor = :codigo and e.ID_archivo = :id_archivo")
    PorcentajeEntity findFiltro(Integer id_archivo, String codigo);
}
