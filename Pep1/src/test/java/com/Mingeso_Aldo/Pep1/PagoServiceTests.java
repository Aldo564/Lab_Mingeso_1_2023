package com.Mingeso_Aldo.Pep1;

import com.Mingeso_Aldo.Pep1.Entities.AcopioEntity;
import com.Mingeso_Aldo.Pep1.Entities.PlanillaEntity;
import com.Mingeso_Aldo.Pep1.Entities.PorcentajeEntity;
import com.Mingeso_Aldo.Pep1.Entities.ProveedorEntity;
import com.Mingeso_Aldo.Pep1.Repositories.AcopioRepository;
import com.Mingeso_Aldo.Pep1.Repositories.PorcentajeRepository;
import com.Mingeso_Aldo.Pep1.Repositories.ProveedorRepository;
import com.Mingeso_Aldo.Pep1.Services.AcopioService;
import com.Mingeso_Aldo.Pep1.Services.PagoService;
import com.Mingeso_Aldo.Pep1.Services.PorcentajeService;
import com.Mingeso_Aldo.Pep1.Services.ProveedorService;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class PagoServiceTests {

	@Autowired
	private PagoService pagoService;

	@Autowired
	private AcopioRepository acopioRepository;

	@Autowired
	private AcopioService acopioService;

	@Autowired
	private ProveedorRepository proveedorRepository;

	@Autowired
	private ProveedorService proveedorService;

	@Autowired
	private PorcentajeRepository porcentajeRepository;

	@Autowired
	private PorcentajeService porcentajeService;

	@Test
	void contextLoads() {
	}

	// Con entradas sólido = 22 y kilos = 5, la salida debiera ser 475
	@Test
	public void testPagoPorcentajeSolido()
	{
		int result = pagoService.pagoPorcentajeSolido(22,5);

		assertEquals(475, result);
	}

	// Con entradas sólido = 5 y kilos = 5, la salida debiera ser -650
	@Test
	public void testPagoPorcentajeSolido2()
	{
		int result = pagoService.pagoPorcentajeSolido(5,5);

		assertEquals(-650, result);
	}

	// Con entradas sólido = 10 y kilos = 10, la salida debiera ser -900
	@Test
	public void testPagoPorcentajeSolido3()
	{
		int result = pagoService.pagoPorcentajeSolido(10,10);

		assertEquals(-900, result);
	}

	// Con entradas sólido = 38 y kilos = 15, la salida debiera ser 475
	@Test
	public void testPagoPorcentajeSolido4()
	{
		int result = pagoService.pagoPorcentajeSolido(10,10);

		assertEquals(2250, result);
	}

	// Con entradas grasa = 18 y kilos = 10 la salida debiera ser 300
	@Test
	public void testPagoPorcentajeGrasa()
	{
		int result = pagoService.pagoPorcentajeGrasa(18,10);

		assertEquals(300, result);
	}

	// Con entradas categoria = "A" y kilos = 7 la salida debiera ser 4900
	@Test
	public void testPagoCategoria()
	{
		int result = pagoService.pagoCategoria("A", 7);

		assertEquals(4900, result);
	}

	// Con entrada dif_kilos = 15 la salida debiera ser 7
	@Test
	public void testVariacionKilos()
	{
		int result = pagoService.variacionKilos(15);

		assertEquals(7, result);
	}

	// Con entrada dif_Grasa = 18 la salida debiera ser 12
	@Test
	public void testVariacionGrasa()
	{
		int result = pagoService.variacionGrasa(18);

		assertEquals(12, result);
	}

	// Con entrada dif_solido = 10 la salida debiera ser 18
	@Test
	public void testVariacionSolido()
	{
		int result = pagoService.variacionSolido(10);

		assertEquals(18, result);
	}


	// Con las entradas pagoAcopio = 100, maniana = false y tarde = true la salida debiera ser 8
	@Test
	public void testPagoFrecuencia()
	{
		double result = pagoService.pagoFrecuencia(100, false, true);

		assertEquals(8, result);
	}

	// Con entradas de arraylist con 2 días distintos, pero uno de ellos repetido, la salida debiera ser 2
	@Test
	public void testObtenerDias()
	{
		ArrayList<String> fechas = new ArrayList<>();
		fechas.add("17/03/2023");
		fechas.add("18/03/2023");
		fechas.add("18/03/2023");

		int result = Integer.parseInt(pagoService.obtenerDias(fechas));

		assertEquals(2, result);
	}

	// Con entrada codigo = "1003" la salida de la planilla deberia ser algo asi:
	/*
	*
	* Quincena: 2
	* Codigo: 1003
	* Nombre: Juan
	* Kgs leche: 100
	* Días: 1
	* Promedio de kilos por día: 100
	* Variacion de kilos: 75
	* Porcentaje de grasa: 15
	* variacion de grasa: 0
	* Porcentaje de solidos totales: 15
	* variacion de solidos totales: 0
	* Pago acopio de leche: 64.000
	* Pago por porcentaje de grasas: 3.000
	* Pago por porcentaje de solidos totales: -9.000
	* Pago por frecuencia = 0
	* Variacion porcentual de kilos: 400.00
	* Variacion de grasa: 0
	* Variacion de sólido: 0
	* Pago_total: 64.000
	* Retencion: 0
	* Pago final: 64.000
	*
	* */
	@Test
	public void testGenerarPlanilla()
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

		PlanillaEntity expected = new PlanillaEntity();
		expected.setID_PLANILLA(1);
		expected.setFecha("2");
		expected.setCodigo("1003");
		expected.setNombre("Juan");
		expected.setKg_leche("100");
		expected.setDias("1");
		expected.setPromedio_kg("100");
		expected.setVariacion_leche("0.0");
		expected.setGrasa("15");
		expected.setVariacion_grasa("0");
		expected.setSolidos("15");
		expected.setVariacion_st("0");
		expected.setPago_leche("70000");
		expected.setPago_grasa("3000");
		expected.setPago_solidos("-9000");
		expected.setBonif_freq("0.0");
		expected.setDct_variacion_leche("0.0");
		expected.setDct_variacion_grasa("0.0");
		expected.setDct_variacion_st("0.0");
		expected.setPago_total("64000.0");
		expected.setMonto_retencion("0.0");
		expected.setMonto_final("64000.0");

		PlanillaEntity result = pagoService.generarPlanilla("1003");

		assertEquals(expected, result);

		ArrayList<AcopioEntity> acopios = acopioService.obtenerAcopios();
		ArrayList<ProveedorEntity> proveedores = proveedorService.obtenerProveedores();
		ArrayList<PorcentajeEntity> porcentajes = porcentajeService.obtenerPorcentajes();
		acopioService.eliminarData(acopios);
		proveedorService.eliminarData(proveedores);
		porcentajeService.eliminarData(porcentajes);
	}


}
