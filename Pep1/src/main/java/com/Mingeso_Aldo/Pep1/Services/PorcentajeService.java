package com.Mingeso_Aldo.Pep1.Services;

import com.Mingeso_Aldo.Pep1.Entities.AcopioEntity;
import com.Mingeso_Aldo.Pep1.Entities.PlanillaEntity;
import com.Mingeso_Aldo.Pep1.Entities.PorcentajeEntity;
import com.Mingeso_Aldo.Pep1.Repositories.AcopioRepository;
import com.Mingeso_Aldo.Pep1.Repositories.PorcentajeRepository;
import lombok.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PorcentajeService {

    @Autowired
    PorcentajeRepository porcentajeRepository;

    @Autowired
    AcopioRepository acopioRepository;

    public ArrayList<PorcentajeEntity> obtenerPorcentajes() {
        return (ArrayList<PorcentajeEntity>) porcentajeRepository.findAll();
    }

    public int obtenerCantArchivos(ArrayList<PorcentajeEntity> porcentajes)
    {
        int cant = 0;
        ArrayList<Integer> aux = new ArrayList<>();
        for (PorcentajeEntity porcentaje:porcentajes)
        {
            if (!(aux.contains(porcentaje.getID_archivo())))
            {
                aux.add(porcentaje.getID_archivo());
            }
        }

        cant = aux.size();
        return cant;
    }

    public int obtenerGrasa(String codigo)
    {
        ArrayList<PorcentajeEntity> porcentajes = porcentajeRepository.getAll();
        int id = obtenerCantArchivos(porcentajes);

        PorcentajeEntity porcentaje_Actual_Filtrado = porcentajeRepository.findFiltro(id, codigo);
        int grasa = porcentaje_Actual_Filtrado.getGrasa();

        return grasa;
    }

    public int obtenerSolido(String codigo)
    {
        ArrayList<PorcentajeEntity> porcentajes = porcentajeRepository.getAll();
        int id = obtenerCantArchivos(porcentajes);

        PorcentajeEntity porcentaje_Actual_Filtrado = porcentajeRepository.findFiltro(id, codigo);
        int solido = porcentaje_Actual_Filtrado.getSolido();

        return solido;
    }

    public String obtenerDiferenciaGrasa(String codigo)
    {
        ArrayList<PorcentajeEntity> porcentajes = porcentajeRepository.getAll();
        int id = obtenerCantArchivos(porcentajes);
        String variacion = "0";

        if (id == 1)
        {
            variacion = "0";
        }
        else
        {
            PorcentajeEntity porcentaje_Actual = porcentajeRepository.findFiltro(id, codigo);
            PorcentajeEntity porcentaje_Pasado = porcentajeRepository.findFiltro(id-1, codigo);

            if (porcentaje_Pasado != null)
            {
                int porcentaje = (porcentaje_Actual.getGrasa() * 100)/porcentaje_Pasado.getGrasa();
                variacion = Integer.toString(porcentaje);
            }
        }

        return variacion;
    }

    public String obtenerDiferenciaSolido(String codigo)
    {
        ArrayList<PorcentajeEntity> porcentajes = obtenerPorcentajes();
        int id = obtenerCantArchivos(porcentajes);
        String variacion = "0";

        if (id == 1)
        {
            variacion = "0";
        }
        else
        {
            PorcentajeEntity porcentaje_Actual = porcentajeRepository.findFiltro(id, codigo);
            PorcentajeEntity porcentaje_Pasado = porcentajeRepository.findFiltro(id-1, codigo);

            if (porcentaje_Pasado != null)
            {
                int porcentaje = (porcentaje_Actual.getSolido() * 100)/porcentaje_Pasado.getSolido();
                variacion = Integer.toString(porcentaje);
            }
        }

        return variacion;
    }

    @Generated
    public void eliminarData(ArrayList<PorcentajeEntity> datas)
    {
        porcentajeRepository.deleteAll(datas);
    }

}
