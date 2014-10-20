package com.gestionau.admisiones.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.ModelMap;

@Controller
public class HelloController {

    int x;
	protected final Log logger = LogFactory.getLog(getClass());

    @RequestMapping(value="/he1.htm")
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        x++;
        ModelMap modelMap = new ModelMap();
        String now = (new Date()).toString();
        logger.info("Returning hello view with " + now);
        String p2="Caracoles de colores";
        modelMap.put("now",now);
        modelMap.put("p2",p2);
        return new ModelAndView("hello", modelMap);
    }
}