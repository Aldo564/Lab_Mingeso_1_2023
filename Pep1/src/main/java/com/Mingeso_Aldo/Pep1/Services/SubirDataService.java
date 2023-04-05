package com.Mingeso_Aldo.Pep1.Services;

import com.Mingeso_Aldo.Pep1.Entities.PorcentajeEntity;
import com.Mingeso_Aldo.Pep1.Entities.AcopioEntity;
import com.Mingeso_Aldo.Pep1.Repositories.AcopioRepository;
import com.Mingeso_Aldo.Pep1.Repositories.PorcentajeRepository;
import com.Mingeso_Aldo.Pep1.Repositories.ProveedorRepository;
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
import java.util.ArrayList;
import java.util.List;

@Service
public class SubirDataService {

    @Autowired
    private AcopioRepository dataAcopioRepository;
    private PorcentajeRepository dataPorcentajeRepository;
    private ProveedorRepository dataProveedorRepository;


    private final Logger logg = LoggerFactory.getLogger(SubirDataService.class);

    public ArrayList<AcopioEntity> obtenerDataAcopio(){
        ArrayList<AcopioEntity> acopios = (ArrayList<AcopioEntity>) dataAcopioRepository.findAll();
        return acopios;
    }

    public List<PorcentajeEntity> obtenerDataPorcentaje() {
        ArrayList<PorcentajeEntity> porcentajes = (ArrayList<PorcentajeEntity>) dataPorcentajeRepository.findAll();
        return porcentajes;
    }

    @Generated
    public String guardar(MultipartFile file){
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
            return "Archivo guardado con exito!";
        }
        else{
            return "No se pudo guardar el archivo";
        }
    }

    /* Metodos para guardar datos de los archivos .csv de Acopio*/

    @Generated
    public void leerCsvAcopio(String direccion){
        String texto = "";
        BufferedReader bf = null;
        dataAcopioRepository.deleteAll();
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
                    guardarDataDBAcopio(bfRead.split(";")[0], bfRead.split(";")[1], bfRead.split(";")[2], bfRead.split(";")[3]);
                    temp = temp + "\n" + bfRead;
                }
            }
            texto = temp;
            System.out.println("Archivo leido exitosamente");
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
    }

    public void guardarDataAcopio(AcopioEntity data){
        dataAcopioRepository.save(data);
    }

    public void guardarDataDBAcopio(String fecha, String turno, String proveedor, String kls_leche){
        AcopioEntity newData = new AcopioEntity();
        newData.setFecha(fecha);
        newData.setTurno(turno);
        newData.setProveedor(proveedor);
        newData.setKls_leche(kls_leche);
        guardarDataAcopio(newData);
    }

    public void eliminarDataAcopio(ArrayList<AcopioEntity> datas){
        dataAcopioRepository.deleteAll(datas);
    }

    /* Metodos para guardar datos de los archivos .csv de Porcentaje*/

    @Generated
    public void leerCsvPorcentaje(String direccion){
        String texto = "";
        BufferedReader bf = null;
        dataPorcentajeRepository.deleteAll();
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
                    guardarDataDBPorcentaje(bfRead.split(";")[0], Integer.parseInt(bfRead.split(";")[1]), Integer.parseInt(bfRead.split(";")[2]), bfRead.split(";")[3]);
                    temp = temp + "\n" + bfRead;
                }
            }
            texto = temp;
            System.out.println("Archivo leido exitosamente");
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
    }

    public void guardarDataPorcentaje(PorcentajeEntity data){
        dataPorcentajeRepository.save(data);
    }

    public void guardarDataDBPorcentaje(String cod_proveedor, int grasa, int solido, String fecha){
        PorcentajeEntity newData = new PorcentajeEntity();
        newData.setCod_proveedor(cod_proveedor);
        newData.setGrasa(grasa);
        newData.setSolido(solido);
        newData.setFecha(fecha);
        guardarDataPorcentaje(newData);
    }

    public void eliminarDataPorcentaje(ArrayList<PorcentajeEntity> datas){
        dataPorcentajeRepository.deleteAll(datas);
    }
}
