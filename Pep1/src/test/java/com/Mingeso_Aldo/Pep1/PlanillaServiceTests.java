package com.Mingeso_Aldo.Pep1;

import com.Mingeso_Aldo.Pep1.Entities.AcopioEntity;
import com.Mingeso_Aldo.Pep1.Entities.PlanillaEntity;
import com.Mingeso_Aldo.Pep1.Repositories.AcopioRepository;
import com.Mingeso_Aldo.Pep1.Repositories.PlanillaRepository;
import com.Mingeso_Aldo.Pep1.Services.AcopioService;
import com.Mingeso_Aldo.Pep1.Services.PlanillaService;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class PlanillaServiceTests {

	@Autowired
	private PlanillaService planillaService;

	@Autowired
	private PlanillaRepository planillaRepository;

	@Test
	void contextLoads() {
	}

	// Deberia resultar una planilla identica a la descrita
	@Test
	public void testGetAll()
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

		PlanillaEntity expected = new PlanillaEntity();
		expected.setID_PLANILLA(1);
		expected.setFecha("2");
		expected.setCodigo("1003");
		expected.setNombre("Pedro");
		expected.setKg_leche("100");
		expected.setPromedio_kg("100");
		expected.setVariacion_leche("75");
		expected.setGrasa("15");
		expected.setVariacion_grasa("0");
		expected.setSolidos("15");
		expected.setVariacion_st("0");
		expected.setPago_leche("64000");
		expected.setPago_grasa("3000");
		expected.setPago_solidos("-9000");
		expected.setBonif_freq("0");
		expected.setDct_variacion_leche("0");
		expected.setDct_variacion_grasa("0");
		expected.setDct_variacion_st("0");
		expected.setPago_total("64000");
		expected.setMonto_retencion("0");
		expected.setMonto_final("64000");

		PlanillaEntity result = planillaService.getAll();

		assertEquals(expected, result);

		// Borramos el contenido dela db para que no molest en la ejecucion de la aplicacion
		ArrayList<PlanillaEntity> planillas = new ArrayList<>();
		planillas.add(expected);
		planillaService.eliminarData(planillas);
	}


}
