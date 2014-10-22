package com.gestionau.admisiones.service;

import java.util.List;

import com.gestionau.admisiones.dominio.Estudiante;
import com.gestionau.admisiones.dao.EstudianteDao;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;

@Service  //("ES")
public class EstudianteServiceImpl implements EstudianteService {

	@Autowired
    private EstudianteDao estudianteDao;
	
	public List<Estudiante> getEstudiantes()
	{
		return estudianteDao.getEstudiantes();  
	}

	
	public void saveEstudiante(Estudiante estudiante)
	{
		estudianteDao.saveEstudiante(estudiante);
		//throw new UnsupportedOperationException();
	}

	public void borrarEstudiante(long estudianteId)
	{
		estudianteDao.borrarEstudiante(estudianteId);  
	}

	public Estudiante getEstudiante(long estudianteId)
	{
		return estudianteDao.getEstudiante(estudianteId); 
	}
	
	public void editEstudiante(Estudiante estudiante)
	{
	   estudianteDao.editEstudiante(estudiante);  
	}
	
}
