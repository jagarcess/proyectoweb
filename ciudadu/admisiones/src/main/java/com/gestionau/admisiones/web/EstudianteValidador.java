package com.gestionau.admisiones.web;

import org.springframework.validation.Errors;
//import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.gestionau.admisiones.dominio.Estudiante;

public class EstudianteValidador  implements Validator{
  
	public boolean supports(Class<?> clazz) {
		
		return Estudiante.class.isAssignableFrom(clazz);
	
	}
	

	public void validate(Object target, Errors errors) {
	
		Estudiante estudiante = (Estudiante) target;

		long tamano = estudiante.getTipodoc().length();
	//	String email = fixedDepositDetails.getEmail();

		if (tamano < 1) {
			errors.rejectValue("tipodoc", "error.depositAmount.less",
					"Debes escribir un tipo documento");
		}
        
		
	}
	
}
