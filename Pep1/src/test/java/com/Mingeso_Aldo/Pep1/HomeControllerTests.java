package com.Mingeso_Aldo.Pep1;

import com.Mingeso_Aldo.Pep1.Controllers.HomeController;
import com.Mingeso_Aldo.Pep1.Entities.PlanillaEntity;
import com.Mingeso_Aldo.Pep1.Repositories.PlanillaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class HomeControllerTests {

	@Autowired
	HomeController homeController;

	@Autowired
	PlanillaRepository planillaRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void mainTest()
	{
		String result = homeController.main();

		assertEquals("home", result);
	}

	@Test
	void mainTest2()
	{
		//############################################################3
		// Poblando db con datos dummies

		PlanillaEntity planilla = new PlanillaEntity();
		planilla.setID_PLANILLA(1);
		planilla.setFecha("2");
		planilla.setCodigo("1003");
		planilla.setNombre("Pedro");
		planilla.setKg_leche("100");
		planilla.setPromedio_kg("100");
		planilla.setVariacion_leche("75");
		planilla.setGrasa("15");
		planilla.setVariacion_grasa("0");
		planilla.setSolidos("15");
		planilla.setVariacion_st("0");
		planilla.setPago_leche("64000");
		planilla.setPago_grasa("3000");
		planilla.setPago_solidos("-9000");
		planilla.setBonif_freq("0");
		planilla.setDct_variacion_leche("0");
		planilla.setDct_variacion_grasa("0");
		planilla.setDct_variacion_st("0");
		planilla.setPago_total("64000");
		planilla.setMonto_retencion("0");
		planilla.setMonto_final("64000");

		planillaRepository.save(planilla);

		//############################################################3

		String result = homeController.main();

		assertEquals("home", result);
	}
}
