package com.gestionau.admisiones.dao;

//import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import javax.persistence.PersistenceContext;

import com.gestionau.admisiones.dominio.Estudiante;

import org.springframework.transaction.annotation.Transactional;

//import javax.persistence.Persistence;

@Repository(value = "estudianteDao")
public class EstudianteDaoImpl implements EstudianteDao {

	private EntityManager em = null;
	
	@PersistenceContext
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }
	
	//private  List<Estudiante> estudiantes;
	
	@SuppressWarnings("unchecked")
	public List<Estudiante> getEstudiantes()
	{
		return em.createQuery("select p from Estudiante p order by p.id").getResultList();	
		  
	}

	  @Transactional(readOnly = false)
	public void saveEstudiante(Estudiante estudiante)
	{  
		  
		   em.persist(estudiante);  
		
	}

	  @Transactional(readOnly = false)
	public void borrarEstudiante(long estudianteId)
	{   Estudiante estudiante= em.find(Estudiante.class,estudianteId);
		em.remove(estudiante);
		
	}

	public Estudiante getEstudiante(long estudianteId)
	{
		Estudiante estudiante= em.find(Estudiante.class,estudianteId);
		 
		return estudiante;
	}

	 @Transactional(readOnly = false)
	public void editEstudiante(Estudiante estudiante)
	{
		em.merge(estudiante);
		//throw new UnsupportedOperationException();  
	}
	
	public void setEstudiantes(List<Estudiante> estudiantes)
	{
		//this.estudiantes=estudiantes;
	}
	
}
