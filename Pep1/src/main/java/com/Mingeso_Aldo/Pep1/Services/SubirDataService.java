package com.Mingeso_Aldo.Pep1.Services;

import com.Mingeso_Aldo.Pep1.Entities.PorcentajeEntity;
import com.Mingeso_Aldo.Pep1.Entities.ProveedorEntity;
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

@Service
public class SubirDataService {

    @Autowired
    private AcopioRepository dataAcopioRepository;
    private PorcentajeRepository dataPorcentajeRepository;
    private ProveedorRepository dataProveedorRepository;


    private final Logger logg = LoggerFactory.getLogger(SubirDataService.class);

    public ArrayList<AcopioRepository> obtenerDataAcopio(){
        return (ArrayList<AcopioRepository>) AcopioRepository.findAll();
    }

    public ArrayList<PorcentajeRepository> obtenerDataPorcentaje(){
        return (ArrayList<PorcentajeRepository>) PorcentajeRepository.findAll();
    }

    public ArrayList<ProveedorRepository> obtenerDataProveedor(){
        return (ArrayList<ProveedorRepository>) ProveedorRepository.findAll();
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
        AcopioRepository.deleteAll();
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
        AcopioRepository.save(data);
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
        AcopioRepository.deleteAll(datas);
    }

    /* Metodos para guardar datos de los archivos .csv de Porcentaje*/

    @Generated
    public void leerCsvPorcentaje(String direccion){
        String texto = "";
        BufferedReader bf = null;
        PorcentajeRepository.deleteAll();
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
                    guardarDataDBPorcentaje(bfRead.split(";")[0], bfRead.split(";")[1], bfRead.split(";")[2], bfRead.split(";")[3]);
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
        PorcentajeRepository.save(data);
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
        PorcentajeRepository.deleteAll(datas);
    }

    /*
    Metodos para guardar datos de los archivos .csv de Proveedores

    @Generated
    public void leerCsvProveedores(String direccion){
        String texto = "";
        BufferedReader bf = null;
        ProveedorRepository.deleteAll();
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
                    guardarDataDBProveedor(bfRead.split(";")[0], bfRead.split(";")[1], bfRead.split(";")[2], bfRead.split(";")[3]);
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

    public void guardarDataProveedor(ProveedorEntity data){
        ProveedorRepository.save(data);
    }

    public void guardarDataDBProveedor(String codigo, String nombre, String categoria, Boolean retencion){
        ProveedorEntity newData = new ProveedorEntity();
        newData.setCodigo(codigo);
        newData.setNombre(nombre);
        newData.setCategoria(categoria);
        newData.setRetencion(retencion);
        guardarDataProveedor(newData);
    }

    public void eliminarDataProveedor(ArrayList<ProveedorEntity> datas){
        ProveedorRepository.deleteAll(datas);
    }
    */
    }
