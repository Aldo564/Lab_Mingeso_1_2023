package com.Mingeso_Aldo.Pep1.Repositories;

import com.Mingeso_Aldo.Pep1.Entities.AcopioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface AcopioRepository extends JpaRepository<AcopioEntity, String> {

}
