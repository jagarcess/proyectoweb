package com.gestionau.admisiones.dao;

import static org.junit.Assert.*;

import java.util.List;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.gestionau.admisiones.dominio.Estudiante;
import com.gestionau.admisiones.dao.EstudianteDaoImpl;

public class EstudianteDaoImplTest {

private EstudianteDaoImpl estudianteDao1;
    
private  List<Estudiante> estudiantes;

    @Before
    public void setUp() throws Exception {
    	estudiantes= new ArrayList<Estudiante>();
    	estudianteDao1 = new EstudianteDaoImpl();
  	    Estudiante x= new Estudiante("001","cc");
  	    estudiantes.add(x);
  	    Estudiante y= new Estudiante("002","TI");
    	estudiantes.add(y);  
    	estudianteDao1.setEstudiantes(estudiantes);
    }
    
    @Test
    public void testGetEstudiantesDaoSinLista() {
    	
    	EstudianteDaoImpl estudianteDao2 = new EstudianteDaoImpl();
    	assertNull(estudianteDao2.getEstudiantes());
    	//assertNotNull(estudianteDao.getEstudiantes());
    }
    
    @Test
    public void testGetEstudiante() {
    	List<Estudiante> estudiantes = estudianteDao1.getEstudiantes();
        assertNotNull(estudiantes); 
        //tamaño
        assertEquals(2, estudianteDao1.getEstudiantes().size());
        //contenido de campos reg 1
        
        assertEquals("001", estudianteDao1.getEstudiantes().get(0).getDocumento());
        assertEquals("cc", estudianteDao1.getEstudiantes().get(0).getTipodoc());
        
    }
	
}
