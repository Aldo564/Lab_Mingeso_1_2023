package com.Mingeso_Aldo.Pep1.Controllers;

import com.Mingeso_Aldo.Pep1.Entities.PlanillaEntity;
import com.Mingeso_Aldo.Pep1.Entities.ProveedorEntity;
import com.Mingeso_Aldo.Pep1.Services.PagoService;
import com.Mingeso_Aldo.Pep1.Services.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
@RequestMapping
public class PlanillaController {

    @Autowired
    private ProveedorService proveedorService;

    @Autowired
    private PagoService pagoService;


    @GetMapping("/seleccionarPlanilla")
    public String main(Model model){
        ArrayList<ProveedorEntity> proveedores = proveedorService.obtenerProveedores();

        if (proveedores.isEmpty())
        {
            model.addAttribute("NoProveedores", "No Existen proveedores ingresados en el sistema.");
        }
        else
        {
            model.addAttribute("proveedores", proveedores);
        }
        return "seleccionarPlanilla";
    }


    @GetMapping("/generarPlanilla")
    public String generarPlanilla(Model model, @RequestParam("codigo") String codigo)
    {
        PlanillaEntity planilla = pagoService.generarPlanilla(codigo);
        if (planilla == null)
        {
            model.addAttribute("NoDataMessage", "No existen pagos asociados a este codigo de proveedor");
        }
        else
        {
            model.addAttribute("planilla", planilla);
        }
        return "mostrarPlanilla";
    }

}
