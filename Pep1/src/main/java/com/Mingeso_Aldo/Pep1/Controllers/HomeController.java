package com.Mingeso_Aldo.Pep1.Controllers;

import com.Mingeso_Aldo.Pep1.Entities.PlanillaEntity;
import com.Mingeso_Aldo.Pep1.Repositories.PlanillaRepository;
import com.Mingeso_Aldo.Pep1.Services.PlanillaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.reflect.Array;
import java.util.ArrayList;

@Controller
@RequestMapping
public class HomeController {

    @Autowired
    PlanillaService planillaService;

    @GetMapping("/")
    public String main(){
        /*
        PlanillaEntity planilla = planillaService.getAll();
        if (planilla != null)
        {
            planillaService.deleteAll();
        }
        */
        return "home";
    }
}