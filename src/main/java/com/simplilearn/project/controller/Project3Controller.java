package com.simplilearn.project.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Project3Controller {

	@GetMapping("/")
	public String index() {
		return "### SimpliLearn - DevOps Certification Training - Project 3";
	}

}