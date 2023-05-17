package com.Mingeso_Aldo.Pep1.Controllers;

import com.Mingeso_Aldo.Pep1.Entities.ProveedorEntity;
import com.Mingeso_Aldo.Pep1.Services.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
@RequestMapping
public class ProveedorController {

    @Autowired
    private ProveedorService proveedorService;


    @GetMapping("/verProveedores")
    public String listar(Model model) {
        ArrayList<ProveedorEntity> proveedores = proveedorService.obtenerProveedores();
        if(proveedores.isEmpty())
        {
            model.addAttribute("noDataMessage", "No existen proveedores en el sistema");
        }
        else
        {
            model.addAttribute("proveedores", proveedores);
        }
        return "verProveedores";
    }

    @GetMapping("/ingresarProveedor")
    public String proveedor(){
        return "ingresarProveedor";
    }

    @PostMapping("/ingresarProveedor")
    public String nuevoProveedor(@RequestParam("codigo") String codigo,
                                 @RequestParam("nombre") String nombre,
                                 @RequestParam("categoria") String categoria,
                                 @RequestParam("retencion") Boolean retencion){
        proveedorService.guardarProveedor(codigo, nombre, categoria, retencion);
        return "redirect:/verProveedores";
    }
}
