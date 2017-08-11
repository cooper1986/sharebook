package com.lirun.sharebook.controller;

import java.security.Principal;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.jasig.cas.client.authentication.AttributePrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.lirun.sharebook.service.StudentsService;
import com.lirun.sharebook.vo.Students;

@Controller
public class StudentsController {
	@Autowired
	StudentsService studentService;
	
	
	@RequestMapping("/getStudentById.do")
	public ModelAndView getStudents(HttpServletRequest request,Model model){
		System.out.println("asdf");
//		Subject subject = SecurityUtils.getSubject(); 
//		if(subject.getPrincipals() != null){
//		    List<Object> list = subject.getPrincipals().asList();  
//		    for(Object s :list){
//		    	System.out.println(s);
//		    }
//		}
//		String id = request.getSession().getId();
//		System.out.println(id);
//		Students students = studentService.getStudentById(1);
//		model.addAttribute("studentInfo",students);
		return new ModelAndView("studentInfo");
	}
}
