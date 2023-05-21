package com.Mingeso_Aldo.Pep1.Controllers;

import com.Mingeso_Aldo.Pep1.Services.SubirDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping
public class subirDataController {

    @Autowired
    private SubirDataService subirData;

    @GetMapping("/subirArchivoAcopio")
    public String mainAcopio() {
        return "subirArchivoAcopio";
    }

    @GetMapping("/subirArchivoPorcentaje")
    public String mainPorcentaje() {
        return "subirArchivoPorcentaje";
    }

    @PostMapping("/subirArchivoAcopio")
    public String uploadAcopio(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
        subirData.guardar(file);
        boolean correcto = subirData.leerCsvAcopio(file.getOriginalFilename());
        if (correcto)
        {
            redirectAttributes.addFlashAttribute("mensaje", "¡Archivo cargado correctamente!");
        }
        else
        {
            redirectAttributes.addFlashAttribute("mensaje", "Verifique el archivo que esta subiendo");
        }

        return "redirect:/subirArchivoAcopio";
    }

    @PostMapping("/subirArchivoPorcentaje")
    public String uploadPorcentaje(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
        subirData.guardar(file);
        boolean correcto = subirData.leerCsvPorcentaje(file.getOriginalFilename());
        if (correcto)
        {
            redirectAttributes.addFlashAttribute("mensaje", "¡Archivo cargado correctamente!");
        }
        else
        {
            redirectAttributes.addFlashAttribute("mensaje", "Verifique el archivo que esta subiendo");
        }

        return "redirect:/subirArchivoPorcentaje";
    }


}
