package com.Mingeso_Aldo.Pep1;

import com.Mingeso_Aldo.Pep1.Entities.PorcentajeEntity;
import com.Mingeso_Aldo.Pep1.Entities.ProveedorEntity;
import com.Mingeso_Aldo.Pep1.Repositories.AcopioRepository;
import com.Mingeso_Aldo.Pep1.Repositories.PorcentajeRepository;
import com.Mingeso_Aldo.Pep1.Repositories.ProveedorRepository;
import com.Mingeso_Aldo.Pep1.Services.PorcentajeService;
import com.Mingeso_Aldo.Pep1.Services.ProveedorService;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ProveedorServiceTests {

	@Autowired
	private ProveedorService proveedorService;

	@Autowired
	private ProveedorRepository proveedorRepository;

	@Test
	void contextLoads() {
	}

	// Se deberían obtener los mismos dos que se crearon en setup
	@Test
	public void testObtenerProveedores()
	{
		//##################################################################
		// Poblando db con datos dummies

		ProveedorEntity proveedor = new ProveedorEntity();
		proveedor.setCodigo("1003");
		proveedor.setNombre("Juan");
		proveedor.setCategoria("A");
		proveedor.setRetencion(true);

		ProveedorEntity proveedor2 = new ProveedorEntity();
		proveedor2.setCodigo("1000");
		proveedor2.setNombre("Pedro");
		proveedor2.setCategoria("B");
		proveedor2.setRetencion(false);

		proveedorRepository.save(proveedor);
		proveedorRepository.save(proveedor2);

		//##################################################################

		ArrayList<ProveedorEntity> expected = new ArrayList<>();

		ProveedorEntity aux1 = new ProveedorEntity();
		aux1.setID_PROVEEDOR(5);
		aux1.setCodigo("1003");
		aux1.setNombre("Juan");
		aux1.setCategoria("A");
		aux1.setRetencion(true);

		ProveedorEntity aux2 = new ProveedorEntity();
		aux2.setID_PROVEEDOR(6);
		aux2.setCodigo("1000");
		aux2.setNombre("Pedro");
		aux2.setCategoria("B");
		aux2.setRetencion(false);

		expected.add(aux1);
		expected.add(aux2);

		ArrayList<ProveedorEntity> result = proveedorService.obtenerProveedores();

		assertEquals(expected, result);

		proveedorService.eliminarData(result);
	}

	@Test
	public void testObtenerCategoria()
	{
		//##################################################################
		// Poblando db ocn datos dummies

		ProveedorEntity proveedor = new ProveedorEntity();
		proveedor.setID_PROVEEDOR(0);
		proveedor.setCodigo("1003");
		proveedor.setNombre("Juan");
		proveedor.setCategoria("A");
		proveedor.setRetencion(true);

		proveedorRepository.save(proveedor);

		ProveedorEntity proveedor2 = new ProveedorEntity();
		proveedor2.setID_PROVEEDOR(1);
		proveedor2.setCodigo("1000");
		proveedor2.setNombre("Pedro");
		proveedor2.setCategoria("B");
		proveedor2.setRetencion(false);

		proveedorRepository.save(proveedor2);

		//##################################################################

		String result = proveedorService.obtenerCategoria("1003");

		assertEquals("A", result);

		ArrayList<ProveedorEntity> proveedores = proveedorService.obtenerProveedores();
		proveedorService.eliminarData(proveedores);
	}

	@Test
	public void testFindByCodigo()
	{
		//##################################################################
		// Poblando db ocn datos dummies

		ProveedorEntity proveedor = new ProveedorEntity();
		proveedor.setCodigo("1003");
		proveedor.setNombre("Juan");
		proveedor.setCategoria("A");
		proveedor.setRetencion(true);

		proveedorRepository.save(proveedor);

		ProveedorEntity proveedor2 = new ProveedorEntity();
		proveedor2.setCodigo("1000");
		proveedor2.setNombre("Pedro");
		proveedor2.setCategoria("B");
		proveedor2.setRetencion(false);

		proveedorRepository.save(proveedor2);

		//##################################################################

		ProveedorEntity expected = new ProveedorEntity();
		expected.setID_PROVEEDOR(3);
		expected.setCodigo("1003");
		expected.setNombre("Juan");
		expected.setCategoria("A");
		expected.setRetencion(true);

		ProveedorEntity result = proveedorService.findByCodigo("1003");

		assertEquals(expected, result);

		ArrayList<ProveedorEntity> proveedores = proveedorService.obtenerProveedores();
		proveedorService.eliminarData(proveedores);
	}




}
