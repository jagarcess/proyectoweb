package com.gestionau.admisiones.service;

import java.util.List;
import com.gestionau.admisiones.dominio.Estudiante;

public interface EstudianteService {

	List<Estudiante> getEstudiantes();

	void saveEstudiante(Estudiante estudiante);

	void borrarEstudiante(long estudianteId);

	Estudiante getEstudiante(long estudianteId);
	
	void editEstudiante(Estudiante estudiante);
	
	
}
