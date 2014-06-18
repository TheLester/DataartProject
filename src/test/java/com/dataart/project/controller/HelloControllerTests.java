package com.dataart.project.controller;

import static org.junit.Assert.*;
import junit.framework.TestSuite;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

public class HelloControllerTests extends TestSuite {

	@Ignore
	public void testHandleRequestView() throws Exception{
        HelloController controller = new HelloController();
        ModelAndView modelAndView = controller.getdata();
        assertEquals("WEB-INF/pages/default.jsp", modelAndView.getViewName());
        System.out.println(modelAndView.getViewName());
        assertNotNull(modelAndView.getModel());
        String nowValue = (String) modelAndView.getModel().get("now");
        
        assertNotNull(nowValue);
       
    }
}