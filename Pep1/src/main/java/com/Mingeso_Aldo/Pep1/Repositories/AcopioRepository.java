package com.Mingeso_Aldo.Pep1.Repositories;

import com.Mingeso_Aldo.Pep1.Entities.AcopioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface AcopioRepository extends JpaRepository<AcopioEntity, String> {

    //@Query("SELECT SUM(AcopioEntity.kg_leche) AS kgs_leche FROM AcopioEntity WHERE proveedor = :codigo")
    //String kgs_leche(@Param("codigo")String codigo);

    //@Query("SELECT AcopioEntity.fecha AS kgs_leche FROM AcopioEntity WHERE proveedor = :codigo")
    //ArrayList<String> obtenerFechas(@Param("codigo")String codigo);

    @Query("select e from AcopioEntity e where e.proveedor = :codigo")
    ArrayList<AcopioEntity> findByCodigo(@Param("codigo")String codigo);

    @Query("select e from AcopioEntity e")
    ArrayList<AcopioEntity> getAll();

    @Query("select e from AcopioEntity e where e.proveedor = :codigo and e.ID_archivo = :id_archivo")
    ArrayList<AcopioEntity> findFiltro(Integer id_archivo, String codigo);

    /*
    @Query(value = "select e.fecha from acopio e where e.proveedor = :codigo and e.ID_archivo = :id_archivo", nativeQuery = true)
    ArrayList<String> fechasFiltro(@Param("id_archivo") Integer id_archivo,@Param("codigo") String codigo);
    */

    @Query("select e.fecha from AcopioEntity e where e.ID_archivo = :id_archivo and e.proveedor = :codigo")
    ArrayList<String> fechasFiltro(Integer id_archivo, String codigo);

    @Query("select e.kg_leche from AcopioEntity e where e.proveedor = :codigo and e.ID_archivo = :id_archivo")
    ArrayList<Integer> kgsFiltro(Integer id_archivo, String codigo);

    @Query("select e.turno from AcopioEntity e where e.proveedor = :codigo and e.ID_archivo = :id_archivo")
    ArrayList<String> findTurnos(Integer id_archivo, String codigo);
}
