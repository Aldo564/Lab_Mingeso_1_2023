package com.Mingeso_Aldo.Pep1.Services;

import com.Mingeso_Aldo.Pep1.Entities.AcopioEntity;
import com.Mingeso_Aldo.Pep1.Entities.PorcentajeEntity;
import com.Mingeso_Aldo.Pep1.Repositories.AcopioRepository;
import com.Mingeso_Aldo.Pep1.Repositories.PorcentajeRepository;
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
        System.out.println("obtener grasa");
        ArrayList<PorcentajeEntity> porcentajes = porcentajeRepository.getAll();
        int id = obtenerCantArchivos(porcentajes) - 1;

        PorcentajeEntity porcentaje_Actual_Filtrado = porcentajeRepository.findFiltro(id, codigo);
        System.out.println("7.1");

        int grasa = porcentaje_Actual_Filtrado.getGrasa();

        return grasa;
    }

    public int obtenerSolido(String codigo)
    {
        ArrayList<PorcentajeEntity> porcentajes = porcentajeRepository.getAll();
        int id = obtenerCantArchivos(porcentajes) - 1;

        PorcentajeEntity porcentaje_Actual_Filtrado = porcentajeRepository.findFiltro(id, codigo);
        int solido = porcentaje_Actual_Filtrado.getSolido();

        return solido;
    }

    public String obtenerDiferenciaGrasa(String codigo)
    {
        ArrayList<PorcentajeEntity> porcentajes = porcentajeRepository.getAll();
        int id = obtenerCantArchivos(porcentajes) - 1;
        String variacion = "";

        if (id == 0)
        {
            variacion = "0";
        }
        else
        {
            PorcentajeEntity porcentaje_Actual = porcentajeRepository.findFiltro(id, codigo);
            PorcentajeEntity porcentaje_Pasado = porcentajeRepository.findFiltro(id-1, codigo);

            int porcentaje = (porcentaje_Actual.getGrasa() * 100)/porcentaje_Pasado.getGrasa();
            if (porcentaje >= 100)
            {
                porcentaje = porcentaje - 100;
            }
            variacion = Integer.toString(porcentaje);
        }

        return variacion;
    }

    public String obtenerDiferenciaSolido(String codigo)
    {
        ArrayList<PorcentajeEntity> porcentajes = porcentajeRepository.getAll();
        int id = obtenerCantArchivos(porcentajes) - 1;
        String variacion = "";

        if (id == 0)
        {
            variacion = "0";
        }
        else
        {
            PorcentajeEntity porcentaje_Actual = porcentajeRepository.findFiltro(id, codigo);
            PorcentajeEntity porcentaje_Pasado = porcentajeRepository.findFiltro(id-1, codigo);

            int porcentaje = (porcentaje_Actual.getSolido() * 100)/porcentaje_Pasado.getSolido();
            if (porcentaje >= 100)
            {
                porcentaje = porcentaje - 100;
            }
            variacion = Integer.toString(porcentaje);
        }

        return variacion;
    }
}
