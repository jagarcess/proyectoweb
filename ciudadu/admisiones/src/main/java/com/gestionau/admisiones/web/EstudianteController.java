package com.gestionau.admisiones.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ModelAttribute;

//import com.gestionau.admisiones.dominio.Estudiante;
import com.gestionau.admisiones.service.EstudianteService;
import com.gestionau.admisiones.dominio.Estudiante;
//validaciones
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.validation.BindingResult;
//import org.springframework.validation.annotation.Validated;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.transaction.annotation.Transactional;


import org.springframework.validation.Validator;
//import javax.validation.Valid;

import java.util.HashMap;
import java.util.Map;
//import java.util.ArrayList;

//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;

@Controller
@SessionAttributes(value = { "editableEstudiante" })
@RequestMapping(value = "/estudiante")
public class EstudianteController {
	
	@Autowired
	private Validator validator;
	
 	@Autowired
 //	@Qualifier("ES")
    private EstudianteService estudianteService;
	
 	@Transactional(readOnly = true)
 	@RequestMapping(value="/list.htm")
 	public  ModelAndView listEstudiante() {
 		
 		Map<String, Object> myModel = new HashMap<String, Object>();
 		myModel.put("estudiantes", this.estudianteService.getEstudiantes());
 		//ArrayList<Estudiante> Estudiantes= estudianteService.getEstudiantes();
 		
 		return new  ModelAndView("list","model",myModel);
 	}
 	
 	//modo avanzado
 	//@RequestMapping(value="/new.htm")
 	@RequestMapping(value="/new.htm",params = "fdAction=new", method = RequestMethod.POST)
 	public  ModelAndView  newEstudiante() {
 	/*	Estudiante estudiante=new Estudiante();
 		estudiante.setDocumento("50171518");
 		estudiante.setTipodoc("cc");
 		Map<String, Object> myModel = new HashMap<String, Object>();
 		myModel.put("estudiante", estudiante);
 		return  new ModelAndView ("newestudiante",myModel);	*/
 		return  new ModelAndView ("newestudiante");	
 	}
 	
 	@ModelAttribute(value = "newEstudiante")
	public Estudiante getEstudiante() {
 		Estudiante estudiante = new Estudiante();
		return estudiante;
	}
 	//public ModelAndView createEstudiante(@ModelAttribute(value = "estudiante") Estudiante estudia, BindingResult bindingResult) {
 	//public ModelAndView createEstudiante(@Validated Estudiante estudia, BindingResult bindingResult) {
 	//public ModelAndView createEstudiante(@ModelAttribute(value = "estudiante") Estudiante estudia, BindingResult bindingResult, @RequestParam(value = "prueba") String p) {
	//no public ModelAndView createEstudiante(@RequestParam(value = "estudiante") Estudiante estudia) {
 	
 	@RequestMapping(value="/create.htm",method = RequestMethod.POST)
 	public ModelAndView createEstudiante( @ModelAttribute(value = "newEstudiante") Estudiante estudia, BindingResult bindingResult) {	
 		//Map<String, Object> myModel = new HashMap<String, Object>();
 		//@Valid
		validator.validate(estudia, bindingResult);
 		new EstudianteValidador().validate(estudia,bindingResult);
 		
 		if (bindingResult.hasErrors()) {
 			//,"model",myModel
 			return new ModelAndView("newestudiante"); //
 		}
 		else
 		{		estudianteService.saveEstudiante(estudia);
 				return new ModelAndView("redirect:/estudiante/list.htm");
 		}
 	}
 	
    //mostrar registro a editar
 	@RequestMapping(value="/view.htm", method = RequestMethod.GET)
	public ModelAndView viewEstudiante(
			@RequestParam(value = "estudianteId") long estudianteId) {
		Estudiante estudiante = estudianteService.getEstudiante(estudianteId);
		Map<String, Object> modelMap = new HashMap<String, Object>();
		modelMap.put("editableEstudiante", estudiante);
	
		return new ModelAndView("editEstudianteForm", modelMap);
	}
 	
 	//guardar registro editado
 	@RequestMapping(value="/edit.htm", method = RequestMethod.POST)
	public String editFixedDeposit(
			@ModelAttribute("editableEstudiante") Estudiante estudiante,
			BindingResult bindingResult, SessionStatus sessionStatus) {

 		validator.validate(estudiante, bindingResult);
		new EstudianteValidador().validate(estudiante,bindingResult);

		if (bindingResult.hasErrors()) {
			return "editEstudianteForm";
		} else {
			estudianteService.editEstudiante(estudiante);
			sessionStatus.setComplete();
			return "redirect:/estudiante/list.htm";
		}
	}
 	
 	//borrar
 	@RequestMapping(value="/erase.htm", method = RequestMethod.GET)
	public String erase(
			@RequestParam(value = "estudianteId") long estudianteId) {
		estudianteService.borrarEstudiante(estudianteId);
	
		return "redirect:/estudiante/list.htm";
	}

 	
 	
 	
 	//modo basico
 	@RequestMapping(value="/new1.htm")
 	public  ModelAndView  newEstudiante1() {
 		Estudiante estudiante=new Estudiante();
 		estudiante.setDocumento("72192617");
 		estudiante.setTipodoc("cc");
 		
 		Map<String, Object> myModel = new HashMap<String, Object>();
 		myModel.put("estudiante", estudiante);
 	
 		//return "newestudiante"
 		return  new ModelAndView ("newestudiante1",myModel);
 	}
 	
 	@RequestMapping(value="/create1.htm",method = RequestMethod.POST)
	public ModelAndView createEstudiante1(
			@RequestParam Map<String, String> params) {
            
 		String documento = params.get("documento");
	//	String tipodoc = params.get("tipodoc");
		
		if (documento.equals("1") )
		{	Estudiante estudiante=new Estudiante();
 		    estudiante.setDocumento("000001");
 		    estudiante.setTipodoc("ti");
 		    Map<String, Object> myModel = new HashMap<String, Object>();
 	 		myModel.put("estudiante", estudiante);
 	 		
 		    return new ModelAndView("newestudiante1",myModel);
		}	
		else
		   return new ModelAndView("redirect:/he.htm");
 	} 	
 	
 	@InitBinder
	public void initBinder_New(WebDataBinder webDataBinder) {
	//	logger.info("initBinder_New() method: Registering CustomDateEditor");
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(
				new SimpleDateFormat("dd-MM-yyyy"), false));
	}
 	
}
