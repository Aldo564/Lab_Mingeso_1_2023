package com.Mingeso_Aldo.Pep1;

import com.Mingeso_Aldo.Pep1.Entities.PorcentajeEntity;
import com.Mingeso_Aldo.Pep1.Repositories.PorcentajeRepository;
import com.Mingeso_Aldo.Pep1.Services.PorcentajeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class PorcentajeServiceTests {

	@Autowired
	private PorcentajeService porcentajeService;

	@Autowired
	private PorcentajeRepository porcentajeRepository;

	@Test
	void contextLoads() {
	}

	// Dos archivos
	@Test
	public void testObtenerCantArchivos()
	{
		//##############################################################
		// Poblando db con datos dummies

		PorcentajeEntity porcentaje = new PorcentajeEntity();
		porcentaje.setID_PORCENTAJE(1);
		porcentaje.setID_archivo(1);
		porcentaje.setCod_proveedor("1003");
		porcentaje.setGrasa(15);
		porcentaje.setSolido(15);
		porcentaje.setFecha("17/03/2023");

		porcentajeRepository.save(porcentaje);

		PorcentajeEntity porcentaje2 = new PorcentajeEntity();
		porcentaje2.setID_PORCENTAJE(2);
		porcentaje2.setID_archivo(2);
		porcentaje2.setCod_proveedor("1003");
		porcentaje2.setGrasa(20);
		porcentaje2.setSolido(10);
		porcentaje2.setFecha("28/02/2023");

		porcentajeRepository.save(porcentaje2);

		//##############################################################

		ArrayList<PorcentajeEntity> porcentajes = porcentajeService.obtenerPorcentajes();
		int result = porcentajeService.obtenerCantArchivos(porcentajes);

		assertEquals(2, result);

		porcentajeService.eliminarData(porcentajes);
	}

	// El codigo 1003 tiene 15% de grasa asociado
	@Test
	public void testObtenerGrasa()
	{
		//##############################################################
		// Poblando db con datos dummies

		PorcentajeEntity porcentaje = new PorcentajeEntity();
		porcentaje.setID_PORCENTAJE(1);
		porcentaje.setID_archivo(1);
		porcentaje.setCod_proveedor("1003");
		porcentaje.setGrasa(15);
		porcentaje.setSolido(15);
		porcentaje.setFecha("17/03/2023");

		porcentajeRepository.save(porcentaje);

		PorcentajeEntity porcentaje2 = new PorcentajeEntity();
		porcentaje2.setID_PORCENTAJE(2);
		porcentaje2.setID_archivo(2);
		porcentaje2.setCod_proveedor("1003");
		porcentaje2.setGrasa(20);
		porcentaje2.setSolido(10);
		porcentaje2.setFecha("28/02/2023");

		porcentajeRepository.save(porcentaje2);

		//##############################################################

		int result = porcentajeService.obtenerGrasa("1003");

		assertEquals(20, result);

		ArrayList<PorcentajeEntity> porcentajes = porcentajeService.obtenerPorcentajes();
		porcentajeService.eliminarData(porcentajes);
	}

	// El codigo 1003 tiene 15% de Solidos totales asociados
	@Test
	public void testObtenerSolido()
	{
		//##############################################################
		// Poblando db con datos dummies

		PorcentajeEntity porcentaje = new PorcentajeEntity();
		porcentaje.setID_PORCENTAJE(1);
		porcentaje.setID_archivo(1);
		porcentaje.setCod_proveedor("1003");
		porcentaje.setGrasa(15);
		porcentaje.setSolido(15);
		porcentaje.setFecha("17/03/2023");

		porcentajeRepository.save(porcentaje);

		PorcentajeEntity porcentaje2 = new PorcentajeEntity();
		porcentaje2.setID_PORCENTAJE(2);
		porcentaje2.setID_archivo(2);
		porcentaje2.setCod_proveedor("1003");
		porcentaje2.setGrasa(20);
		porcentaje2.setSolido(10);
		porcentaje2.setFecha("28/02/2023");

		porcentajeRepository.save(porcentaje2);

		//##############################################################

		int result = porcentajeService.obtenerSolido("1003");

		assertEquals(10, result);

		ArrayList<PorcentajeEntity> porcentajes = porcentajeService.obtenerPorcentajes();
		porcentajeService.eliminarData(porcentajes);
	}

	// El acopio actual tiene un 66% más de grasa
	@Test
	public void testObtenerDiferenciaGrasa()
	{
		//##############################################################
		// Poblando db con datos dummies

		PorcentajeEntity porcentaje = new PorcentajeEntity();
		porcentaje.setID_PORCENTAJE(1);
		porcentaje.setID_archivo(1);
		porcentaje.setCod_proveedor("1003");
		porcentaje.setGrasa(15);
		porcentaje.setSolido(15);
		porcentaje.setFecha("17/03/2023");

		porcentajeRepository.save(porcentaje);

		PorcentajeEntity porcentaje2 = new PorcentajeEntity();
		porcentaje2.setID_PORCENTAJE(2);
		porcentaje2.setID_archivo(2);
		porcentaje2.setCod_proveedor("1003");
		porcentaje2.setGrasa(20);
		porcentaje2.setSolido(10);
		porcentaje2.setFecha("28/02/2023");

		porcentajeRepository.save(porcentaje2);

		//##############################################################

		String result = porcentajeService.obtenerDiferenciaGrasa("1003");

		assertEquals("133", result);

		ArrayList<PorcentajeEntity> porcentajes = porcentajeService.obtenerPorcentajes();
		porcentajeService.eliminarData(porcentajes);
	}

	// El acopio actual tiene un 66% más de grasa
	@Test
	public void testObtenerDiferenciaGrasa2()
	{
		//##############################################################
		// Poblando db con datos dummies

		PorcentajeEntity porcentaje = new PorcentajeEntity();
		porcentaje.setID_PORCENTAJE(1);
		porcentaje.setID_archivo(1);
		porcentaje.setCod_proveedor("1003");
		porcentaje.setGrasa(15);
		porcentaje.setSolido(15);
		porcentaje.setFecha("17/03/2023");

		porcentajeRepository.save(porcentaje);

		//##############################################################

		String result = porcentajeService.obtenerDiferenciaGrasa("1003");

		assertEquals("0", result);

		ArrayList<PorcentajeEntity> porcentajes = porcentajeService.obtenerPorcentajes();
		porcentajeService.eliminarData(porcentajes);
	}

	// El acopio actual tiene un 66% menos de solidos totales
	@Test
	public void testDiferenciaSolido()
	{
		//##############################################################
		// Poblando db con datos dummies

		PorcentajeEntity porcentaje = new PorcentajeEntity();
		porcentaje.setID_PORCENTAJE(1);
		porcentaje.setID_archivo(1);
		porcentaje.setCod_proveedor("1003");
		porcentaje.setGrasa(15);
		porcentaje.setSolido(10);
		porcentaje.setFecha("17/03/2023");


		PorcentajeEntity porcentaje2 = new PorcentajeEntity();
		porcentaje2.setID_PORCENTAJE(2);
		porcentaje2.setID_archivo(2);
		porcentaje2.setCod_proveedor("1003");
		porcentaje2.setGrasa(20);
		porcentaje2.setSolido(15);
		porcentaje2.setFecha("28/03/2023");

		porcentajeRepository.save(porcentaje);
		porcentajeRepository.save(porcentaje2);

		//##############################################################

		String result = porcentajeService.obtenerDiferenciaSolido("1003");

		assertEquals("150", result);

		ArrayList<PorcentajeEntity> porcentajes = porcentajeService.obtenerPorcentajes();
		porcentajeService.eliminarData(porcentajes);
	}

	// El acopio actual tiene un 66% menos de solidos totales
	@Test
	public void testDiferenciaSolido2()
	{
		//##############################################################
		// Poblando db con datos dummies

		PorcentajeEntity porcentaje = new PorcentajeEntity();
		porcentaje.setID_PORCENTAJE(1);
		porcentaje.setID_archivo(1);
		porcentaje.setCod_proveedor("1000");
		porcentaje.setGrasa(15);
		porcentaje.setSolido(15);
		porcentaje.setFecha("17/03/2023");

		porcentajeRepository.save(porcentaje);

		//##############################################################

		String result = porcentajeService.obtenerDiferenciaSolido("1000");

		assertEquals("0", result);

		ArrayList<PorcentajeEntity> porcentajes = porcentajeService.obtenerPorcentajes();
		porcentajeService.eliminarData(porcentajes);
	}


}
