package com.gestionau.admisiones.dao;

import java.util.List;
import com.gestionau.admisiones.dominio.Estudiante;

public interface EstudianteDao {
	
	List<Estudiante> getEstudiantes();

	void saveEstudiante(Estudiante estudiante);

	void borrarEstudiante(long estudianteId);

	Estudiante getEstudiante(long estudianteId);

	void editEstudiante(Estudiante estudiante);
	
	//void setEstudiantes(List <Estudiante> estudiantes);

}
