package com.Mingeso_Aldo.Pep1;

import com.Mingeso_Aldo.Pep1.Controllers.PlanillaController;
import com.Mingeso_Aldo.Pep1.Entities.AcopioEntity;
import com.Mingeso_Aldo.Pep1.Entities.PorcentajeEntity;
import com.Mingeso_Aldo.Pep1.Entities.ProveedorEntity;
import com.Mingeso_Aldo.Pep1.Repositories.AcopioRepository;
import com.Mingeso_Aldo.Pep1.Repositories.PorcentajeRepository;
import com.Mingeso_Aldo.Pep1.Repositories.ProveedorRepository;
import com.Mingeso_Aldo.Pep1.Services.AcopioService;
import com.Mingeso_Aldo.Pep1.Services.PorcentajeService;
import com.Mingeso_Aldo.Pep1.Services.ProveedorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ui.Model;
import org.springframework.ui.ExtendedModelMap;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class PlanillaControllerTests {

	@Autowired
	PlanillaController planillaController;

	@Autowired
	AcopioRepository acopioRepository;

	@Autowired
	AcopioService acopioService;

	@Autowired
	ProveedorRepository proveedorRepository;

	@Autowired
	ProveedorService proveedorService;

	@Autowired
	PorcentajeRepository porcentajeRepository;

	@Autowired
	PorcentajeService porcentajeService;

	@Test
	void contextLoads() {
	}

	@Test
	void mainTest()
	{
		Model model = new ExtendedModelMap();
		String result = planillaController.main(model);

		assertEquals("seleccionarPlanilla", result);
	}

	/*
	@Test
	void generarPlanillaTests()
	{

		//################################################################
		// Poblando db con datos dummies

		AcopioEntity aux1 = new AcopioEntity();
		aux1.setID_ACOPIO(1);
		aux1.setID_archivo(2);
		aux1.setFecha("17/03/2023");
		aux1.setTurno("M");
		aux1.setProveedor("1003");
		aux1.setKg_leche(50);

		AcopioEntity aux2 = new AcopioEntity();
		aux2.setID_ACOPIO(2);
		aux2.setID_archivo(2);
		aux2.setFecha("17/03/2023");
		aux2.setTurno("T");
		aux2.setProveedor("1003");
		aux2.setKg_leche(50);

		AcopioEntity aux3 = new AcopioEntity();
		aux3.setID_ACOPIO(3);
		aux3.setID_archivo(2);
		aux3.setFecha("16/03/2023");
		aux3.setTurno("M");
		aux3.setProveedor("1000");
		aux3.setKg_leche(50);

		AcopioEntity aux4 = new AcopioEntity();
		aux4.setID_ACOPIO(4);
		aux4.setID_archivo(1);
		aux4.setFecha("31/03/2023");
		aux4.setTurno("M");
		aux4.setProveedor("1000");
		aux4.setKg_leche(50);

		AcopioEntity aux5 = new AcopioEntity();
		aux5.setID_ACOPIO(5);
		aux5.setID_archivo(1);
		aux5.setFecha("31/03/2023");
		aux5.setTurno("M");
		aux5.setProveedor("1003");
		aux5.setKg_leche(25);

		acopioRepository.save(aux1);
		acopioRepository.save(aux2);
		acopioRepository.save(aux3);
		acopioRepository.save(aux4);
		acopioRepository.save(aux5);

		ProveedorEntity proveedor = new ProveedorEntity();
		proveedor.setID_PROVEEDOR(1);
		proveedor.setCodigo("1003");
		proveedor.setNombre("Juan");
		proveedor.setCategoria("A");
		proveedor.setRetencion(true);

		proveedorRepository.save(proveedor);

		PorcentajeEntity porcentaje = new PorcentajeEntity();
		porcentaje.setID_PORCENTAJE(1);
		porcentaje.setID_archivo(1);
		porcentaje.setCod_proveedor("1003");
		porcentaje.setGrasa(15);
		porcentaje.setSolido(15);
		porcentaje.setFecha("17/03/2023");

		porcentajeRepository.save(porcentaje);

		//################################################################

		Model model = new ExtendedModelMap();
		String result = planillaController.generarPlanilla(model, "1003");

		assertEquals("mostrarPlanilla", result);

		ArrayList<AcopioEntity> acopios = acopioService.obtenerAcopios();
		ArrayList<ProveedorEntity> proveedores = proveedorService.obtenerProveedores();
		ArrayList<PorcentajeEntity> porcentajes = porcentajeService.obtenerPorcentajes();
		acopioService.eliminarData(acopios);
		proveedorService.eliminarData(proveedores);
		porcentajeService.eliminarData(porcentajes);
	}
	 */

}
