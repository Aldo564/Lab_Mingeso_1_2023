package com.Mingeso_Aldo.Pep1.Services;

import com.Mingeso_Aldo.Pep1.Entities.AcopioEntity;
import com.Mingeso_Aldo.Pep1.Entities.PorcentajeEntity;
import com.Mingeso_Aldo.Pep1.Repositories.AcopioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AcopioService {

    @Autowired
    AcopioRepository acopioRepository;

    public ArrayList<AcopioEntity> obtenerAcopios(){
        return (ArrayList<AcopioEntity>) acopioRepository.findAll();
    }

    public int kgs_leche(String codigo)
    {
        int total_kgs = 0;
        ArrayList<AcopioEntity> acopios = acopioRepository.getAll();

        int id = obtenerCantArchivos(acopios) - 1;
        ArrayList<Integer> kgs_leche = acopioRepository.kgsFiltro(id, codigo);

        for (Integer kg:kgs_leche)
        {
            total_kgs = total_kgs + kg;
        }

        return total_kgs;
    }

    public int obtenerCantArchivos(ArrayList<AcopioEntity> acopios)
    {
        int cant = 0;
        ArrayList<Integer> aux = new ArrayList<>();
        for (AcopioEntity acopio:acopios)
        {
            if (!(aux.contains(acopio.getID_archivo())))
            {
                aux.add(acopio.getID_archivo());
            }
        }

        cant = aux.size();
        return cant;
    }

    public ArrayList<String> obtenerFechas(String codigo)
    {
        ArrayList<AcopioEntity> acopios = acopioRepository.getAll();
        int id = obtenerCantArchivos(acopios) - 1;

        ArrayList<String> fechas = acopioRepository.fechasFiltro(id, codigo);

        return fechas;
    }

    public ArrayList<AcopioEntity> findByCodigo(String codigo)
    {
        return acopioRepository.findByCodigo(codigo);
    }


    public ArrayList<String> obtenerVariacionLeche(String codigo)
    {
        ArrayList<String> salida = new ArrayList<>();
        String variacion = "0";
        String variacionNum = "0";

        ArrayList<AcopioEntity> acopios = acopioRepository.getAll();

        int cant_Archivos = obtenerCantArchivos(acopios);

        if (cant_Archivos != 1)
        {
            AcopioEntity acopio_Actual = acopios.get(cant_Archivos-1);
            Integer id_acopio_Actual = acopio_Actual.getID_ACOPIO();

            AcopioEntity acopio_Pasado = acopios.get(cant_Archivos-2);
            Integer id_acopio_Pasado = acopio_Pasado.getID_ACOPIO();

            ArrayList<AcopioEntity> acopio_Actual_Filtrado = acopioRepository.findFiltro(id_acopio_Actual, codigo);
            ArrayList<AcopioEntity> acopio_Pasado_Filtrado = acopioRepository.findFiltro(id_acopio_Pasado, codigo);

            int kilos_Actual = 0;
            int kilos_pasado = 0;

            for(AcopioEntity acopio:acopio_Actual_Filtrado)
            {
                kilos_Actual = kilos_Actual + acopio.getKg_leche();
            }

            for(AcopioEntity acopio:acopio_Pasado_Filtrado)
            {
                kilos_pasado = kilos_pasado + acopio.getKg_leche();
            }

            variacionNum = Integer.toString(Math.abs(kilos_Actual-kilos_pasado));

            int porcentaje = (kilos_pasado * 100)/kilos_Actual;
            if (porcentaje >= 100)
            {
                porcentaje = porcentaje - 100;
            }
            variacion = Integer.toString(porcentaje);
        }

        salida.add(variacionNum);
        salida.add(variacion);

        return salida;
    }


    public ArrayList<Boolean> obtenerTurnos(String codigo)
    {
        ArrayList<Boolean> salida = new ArrayList<>();
        ArrayList<AcopioEntity> acopios = acopioRepository.getAll();
        int id = obtenerCantArchivos(acopios) - 1;

        ArrayList<String> turnos = acopioRepository.findTurnos(id, codigo);

        if (turnos.contains("M"))
        {
            salida.add(true);
        }
        else
        {
            salida.add(false);
        }

        if (turnos.contains("T"))
        {
            salida.add(true);
        }
        else
        {
            salida.add(false);
        }
        
        return salida;
    }
}
