package com.Mingeso_Aldo.Pep1;

import com.Mingeso_Aldo.Pep1.Entities.AcopioEntity;
import com.Mingeso_Aldo.Pep1.Repositories.AcopioRepository;
import com.Mingeso_Aldo.Pep1.Services.AcopioService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class AcopioServiceTests {

	@Autowired
	private AcopioService acopioService;

	@Autowired
	private AcopioRepository acopioRepository;

	@Test
	void contextLoads() {
	}

	/*
	// 4 datos de acopio distintos
	@Test
	public void testObtenerAcopios()
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

		acopioRepository.save(aux1);
		acopioRepository.save(aux2);
		acopioRepository.save(aux3);
		acopioRepository.save(aux4);

		//################################################################

		ArrayList<AcopioEntity> expected = new ArrayList<>();

		AcopioEntity aux6 = new AcopioEntity();
		aux6.setID_ACOPIO(1);
		aux6.setID_archivo(2);
		aux6.setFecha("17/03/2023");
		aux6.setTurno("M");
		aux6.setProveedor("1003");
		aux6.setKg_leche(50);

		AcopioEntity aux7 = new AcopioEntity();
		aux7.setID_ACOPIO(2);
		aux7.setID_archivo(2);
		aux7.setFecha("17/03/2023");
		aux7.setTurno("T");
		aux7.setProveedor("1003");
		aux7.setKg_leche(50);

		AcopioEntity aux8 = new AcopioEntity();
		aux8.setID_ACOPIO(3);
		aux8.setID_archivo(2);
		aux8.setFecha("16/03/2023");
		aux8.setTurno("M");
		aux8.setProveedor("1000");
		aux8.setKg_leche(50);

		AcopioEntity aux9 = new AcopioEntity();
		aux9.setID_ACOPIO(4);
		aux9.setID_archivo(1);
		aux9.setFecha("31/03/2023");
		aux9.setTurno("M");
		aux9.setProveedor("1000");
		aux9.setKg_leche(50);

		expected.add(aux6);
		expected.add(aux7);
		expected.add(aux8);
		expected.add(aux9);

		ArrayList<AcopioEntity> result = acopioService.obtenerAcopios();

		assertEquals(expected, result);

		acopioService.eliminarData(result);
		acopioService.eliminarData(expected);
	}

 	*/

	// 100 kls de leche en el último acopio
	@Test
	public void testKgs_leche()
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

		acopioRepository.save(aux1);
		acopioRepository.save(aux2);
		acopioRepository.save(aux3);
		acopioRepository.save(aux4);

		//################################################################

		int result = acopioService.kgs_leche("1003");

		assertEquals(100, result);

		ArrayList<AcopioEntity> acopios = acopioService.obtenerAcopios();
		acopioService.eliminarData(acopios);
	}

	// Dos archivos
	@Test
	public void testObtenerCantArchivos()
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

		//################################################################

		ArrayList<AcopioEntity> acopios = acopioService.obtenerAcopios();
		int result = acopioService.obtenerCantArchivos(acopios);

		assertEquals(2, result);

		ArrayList<AcopioEntity> datas = acopioService.obtenerAcopios();
		acopioService.eliminarData(datas);
	}


	// Una sola fecha anexada al codigo 1003, pero repetida dos veces [17/03/2023,17/03/2023]
	@Test
	public void testObtenerFechas()
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

		//################################################################

		ArrayList<String> expected = new ArrayList<>();
		expected.add("17/03/2023");
		expected.add("17/03/2023");

		ArrayList<String> result = acopioService.obtenerFechas("1003");

		assertEquals(expected, result);

		ArrayList<AcopioEntity> acopios = acopioService.obtenerAcopios();
		acopioService.eliminarData(acopios);
	}



	// Variacion del 400% con 75kg mas en relacion al anterior (25kg)
	@Test
	public void testObtenerVariacionLeche()
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

		//################################################################

		ArrayList<String> expected = new ArrayList<>();
		expected.add("75");
		expected.add("400");

		ArrayList<String> result = acopioService.obtenerVariacionLeche("1003");

		assertEquals(expected, result);

		ArrayList<AcopioEntity> acopios = acopioService.obtenerAcopios();
		acopioService.eliminarData(acopios);
	}

	// El codigo 1003 deburr retornar [True, True] ya que entrego mañana y tarde
	@Test
	public void testObtenerTurnos()
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

		//################################################################

		ArrayList<Boolean> expected = new ArrayList<>();
		expected.add(true);
		expected.add(true);

		ArrayList<Boolean> result = acopioService.obtenerTurnos("1003");

		assertEquals(expected, result);

		ArrayList<AcopioEntity> acopios = acopioService.obtenerAcopios();
		acopioService.eliminarData(acopios);
	}


}
