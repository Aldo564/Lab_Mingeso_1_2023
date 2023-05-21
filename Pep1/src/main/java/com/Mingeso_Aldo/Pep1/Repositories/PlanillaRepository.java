package com.Mingeso_Aldo.Pep1.Repositories;

import com.Mingeso_Aldo.Pep1.Entities.PlanillaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface PlanillaRepository extends JpaRepository<PlanillaEntity, String> {


    @Query("select e from PlanillaEntity e")
    PlanillaEntity find();

    @Query("delete from PlanillaEntity p where p.ID_PLANILLA = 0")
    void deleteById();

}
