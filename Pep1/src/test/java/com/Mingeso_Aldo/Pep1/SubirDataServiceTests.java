package com.Mingeso_Aldo.Pep1;

import com.Mingeso_Aldo.Pep1.Entities.AcopioEntity;
import com.Mingeso_Aldo.Pep1.Entities.PorcentajeEntity;
import com.Mingeso_Aldo.Pep1.Entities.ProveedorEntity;
import com.Mingeso_Aldo.Pep1.Repositories.AcopioRepository;
import com.Mingeso_Aldo.Pep1.Repositories.PorcentajeRepository;
import com.Mingeso_Aldo.Pep1.Repositories.ProveedorRepository;
import com.Mingeso_Aldo.Pep1.Services.AcopioService;
import com.Mingeso_Aldo.Pep1.Services.PorcentajeService;
import com.Mingeso_Aldo.Pep1.Services.ProveedorService;
import com.Mingeso_Aldo.Pep1.Services.SubirDataService;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class SubirDataServiceTests {

	@Autowired
	private PorcentajeService porcentajeService;

	@Autowired
	private PorcentajeRepository porcentajeRepository;

	@Autowired
	private AcopioService acopioService;

	@Autowired
	private AcopioRepository acopioRepository;

	@Autowired
	private SubirDataService subirDataService;

	@Test
	void contextLoads() {
	}


	@Test
	public void testGuardarDataAcopio()
	{
		AcopioEntity acopio = new AcopioEntity();
		acopio.setID_ACOPIO(30);
		acopio.setID_archivo(1);
		acopio.setFecha("15/04/2023");
		acopio.setTurno("M");
		acopio.setProveedor("1003");
		acopio.setKg_leche(50);

		ArrayList<AcopioEntity> expected = new ArrayList<>();
		expected.add(acopio);

		subirDataService.guardarDataAcopio(acopio);

		ArrayList<AcopioEntity> result = acopioService.obtenerAcopios();

		assertEquals(expected, result);

		acopioService.eliminarData(result);
	}

	@Test
	public void testGuardarDataPorcentaje()
	{
		PorcentajeEntity porcentaje = new PorcentajeEntity();
		porcentaje.setID_PORCENTAJE(13);
		porcentaje.setID_archivo(1);
		porcentaje.setCod_proveedor("1003");
		porcentaje.setGrasa(15);
		porcentaje.setSolido(15);
		porcentaje.setFecha("15/01/2023");

		ArrayList<PorcentajeEntity> expected = new ArrayList<>();
		expected.add(porcentaje);

		subirDataService.guardarDataPorcentaje(porcentaje);

		ArrayList<PorcentajeEntity> result = porcentajeService.obtenerPorcentajes();

		assertEquals(expected, result);

		porcentajeService.eliminarData(result);
	}

	@Test
	public void testGuardarDataDBAcopio()
	{
		AcopioEntity acopio2 = new AcopioEntity();
		acopio2.setID_ACOPIO(31);
		acopio2.setID_archivo(1);
		acopio2.setFecha("16/04/2023");
		acopio2.setTurno("T");
		acopio2.setProveedor("1000");
		acopio2.setKg_leche(50);

		ArrayList<AcopioEntity> expected = new ArrayList<>();
		expected.add(acopio2);

		subirDataService.guardarDataDBAcopio(1, "16/04/2023", "T", "1000", 50);

		ArrayList<AcopioEntity> result = acopioService.obtenerAcopios();

		assertEquals(expected, result);

		acopioService.eliminarData(result);
	}

	@Test
	public void testGuardarDataDBPorcentaje()
	{
		PorcentajeEntity porcentaje2 = new PorcentajeEntity();
		porcentaje2.setID_PORCENTAJE(14);
		porcentaje2.setID_archivo(1);
		porcentaje2.setCod_proveedor("1000");
		porcentaje2.setGrasa(30);
		porcentaje2.setSolido(10);
		porcentaje2.setFecha("15/01/2023");

		ArrayList<PorcentajeEntity> expected = new ArrayList<>();
		expected.add(porcentaje2);

		subirDataService.guardarDataDBPorcentaje(1, "1000", 30, 10, "15/01/2023");

		ArrayList<PorcentajeEntity> result = porcentajeService.obtenerPorcentajes();

		assertEquals(expected, result);

		porcentajeService.eliminarData(result);
	}
}
