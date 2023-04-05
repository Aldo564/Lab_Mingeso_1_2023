package com.Mingeso_Aldo.Pep1.Controllers;

import com.Mingeso_Aldo.Pep1.Entities.ProveedorEntity;
import com.Mingeso_Aldo.Pep1.Services.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

public class ProveedorController {

    @Autowired
    private ProveedorService proveedorService;

    @GetMapping("/ver-proveedores")
    public String listar(Model model) {
        ArrayList<ProveedorEntity> proveedores = proveedorService.obtenerProveedores();
        model.addAttribute("proveedores", proveedores);
        return "verProveedores";
    }

    @GetMapping("/ingresar-proveedor")
    public String proveedor(){
        return "ingresarProveedor";
    }
    @PostMapping("/ingresar-proveedor")
    public String nuevoProveedor(@RequestParam("codigo") String codigo,
                                 @RequestParam("nombre") String nombre,
                                 @RequestParam("categoria") String categoria,
                                 @RequestParam("retencion") Boolean retencion){
        proveedorService.guardarProveedor(codigo, nombre, categoria, retencion);
        return "redirect:/ingresar-proveedor";
    }
}
