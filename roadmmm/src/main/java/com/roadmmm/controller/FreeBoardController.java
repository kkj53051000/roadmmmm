package com.roadmmm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class FreeBoardController {
	
	@GetMapping("/flist")
	public String FreeBoardList() {
		return "freeBoardList";
	}
}