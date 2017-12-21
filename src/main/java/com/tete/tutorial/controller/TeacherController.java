package com.tete.tutorial.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("teacher")
public class TeacherController {
	
	@RequestMapping("list")
	public String list(){
		return "/teacher/main";
	}

}
