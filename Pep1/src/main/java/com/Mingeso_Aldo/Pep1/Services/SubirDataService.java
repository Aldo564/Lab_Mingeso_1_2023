package com.Mingeso_Aldo.Pep1.Services;

import com.Mingeso_Aldo.Pep1.Entities.PorcentajeEntity;
import com.Mingeso_Aldo.Pep1.Entities.AcopioEntity;
import com.Mingeso_Aldo.Pep1.Repositories.AcopioRepository;
import com.Mingeso_Aldo.Pep1.Repositories.PorcentajeRepository;
import lombok.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


@Service
public class SubirDataService {

    @Autowired
    private AcopioRepository dataAcopioRepository;
    @Autowired
    private PorcentajeRepository dataPorcentajeRepository;

    Integer ID_ARCHIVO_ACOPIO = 1;
    Integer ID_ARCHIVO_PORCENTAJE = 1;
    private final Logger logg = LoggerFactory.getLogger(SubirDataService.class);

    @Generated
    public boolean guardar(MultipartFile file){
        String filename = file.getOriginalFilename();
        if(filename != null){
            if(!file.isEmpty()){
                try{
                    byte [] bytes = file.getBytes();
                    Path path  = Paths.get(file.getOriginalFilename());
                    Files.write(path, bytes);
                    logg.info("Archivo guardado");
                }
                catch (IOException e){
                    logg.error("ERROR", e);
                }
            }
            return true;
        }
        else{
            return false;
        }
    }

    /* Metodos para guardar datos de los archivos .csv de Acopio*/

    @Generated
    public boolean leerCsvAcopio(String direccion){
        String texto = "";
        BufferedReader bf = null;
        //dataAcopioRepository.deleteAll();
        try{
            bf = new BufferedReader(new FileReader(direccion));
            String temp = "";
            String bfRead;
            int count = 1;
            while((bfRead = bf.readLine()) != null){
                if (count == 1){
                    count = 0;
                }
                else{
                    guardarDataDBAcopio(ID_ARCHIVO_ACOPIO, bfRead.split(";")[0], bfRead.split(";")[1], bfRead.split(";")[2], Integer.parseInt(bfRead.split(";")[3]));
                    temp = temp + "\n" + bfRead;
                }
            }
            texto = temp;
            System.out.println("Archivo leido exitosamente");
            ID_ARCHIVO_ACOPIO++;
            return true;
        }catch(Exception e){
            System.err.println("No se encontro el archivo");
        }finally{
            if(bf != null){
                try{
                    bf.close();
                }catch(IOException e){
                    logg.error("ERROR", e);
                }
            }
        }
        return false;
    }

    public void guardarDataAcopio(AcopioEntity data){
        dataAcopioRepository.save(data);
    }

    public void guardarDataDBAcopio(Integer ID_archivo, String fecha, String turno, String proveedor, Integer kg_leche){
        AcopioEntity newData = new AcopioEntity();
        newData.setID_archivo(ID_archivo);
        newData.setFecha(fecha);
        newData.setTurno(turno);
        newData.setProveedor(proveedor);
        newData.setKg_leche(kg_leche);
        guardarDataAcopio(newData);
    }

    /* Metodos para guardar datos de los archivos .csv de Porcentaje*/

    @Generated
    public boolean leerCsvPorcentaje(String direccion){
        String texto = "";
        BufferedReader bf = null;
        //dataPorcentajeRepository.deleteAll();
        try{
            bf = new BufferedReader(new FileReader(direccion));
            String temp = "";
            String bfRead;
            int count = 1;
            while((bfRead = bf.readLine()) != null){
                if (count == 1){
                    count = 0;
                }
                else{
                    guardarDataDBPorcentaje(ID_ARCHIVO_PORCENTAJE,bfRead.split(";")[0], Integer.parseInt(bfRead.split(";")[1]), Integer.parseInt(bfRead.split(";")[2]), LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd")));
                    temp = temp + "\n" + bfRead;
                }
            }
            texto = temp;
            System.out.println("Archivo leido exitosamente");
            ID_ARCHIVO_PORCENTAJE++;
            return true;
        }catch(Exception e){
            System.err.println("No se encontro el archivo");
        }finally{
            if(bf != null){
                try{
                    bf.close();
                }catch(IOException e){
                    logg.error("ERROR", e);
                }
            }
        }
        return false;
    }

    public void guardarDataPorcentaje(PorcentajeEntity data){
        dataPorcentajeRepository.save(data);
    }

    public void guardarDataDBPorcentaje(int id_archivo,String cod_proveedor, int grasa, int solido, String fecha){
        PorcentajeEntity newData = new PorcentajeEntity();
        newData.setID_archivo(id_archivo);
        newData.setCod_proveedor(cod_proveedor);
        newData.setGrasa(grasa);
        newData.setSolido(solido);
        newData.setFecha(fecha);
        guardarDataPorcentaje(newData);
    }

}
