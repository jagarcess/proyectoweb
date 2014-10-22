package com.gestionau.admisiones.dominio;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class EstudianteTest {

	private Estudiante estudiante;
	
	  @Before
	    public void setUp() throws Exception {
	        estudiante = new Estudiante();
	    }
	
	  @Test
	    public void testSetAndGetDocumento() {
	        String testDocumento = "aDescription";
	        assertNull(estudiante.getDocumento());
	        estudiante.setDocumento(testDocumento);
	        assertEquals(testDocumento, estudiante.getDocumento());
	    }
	  
	  @Test
	    public void testSetAndGetTipodoc() {
	        String testTipodoc="cc";
	        assertNull(estudiante.getTipodoc()); 
	        estudiante.setTipodoc(testTipodoc);
	        assertEquals(testTipodoc, estudiante.getTipodoc());
	    }
	  
}
