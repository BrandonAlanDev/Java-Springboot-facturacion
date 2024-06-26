package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.models.entity.cliente;
import com.example.demo.models.service.ClienteServiceImp;

@Controller
public class ClienteController {
	@Autowired
	ClienteServiceImp clienteService;
	
	@GetMapping("/listar")
	//-----ResponseEntity<?> en algular
	public String listar(Model model) {
		List<cliente> lista=clienteService.findAll();
		model.addAttribute("lista",lista);
		model.addAttribute("titulo","Lista de clientes");
		return "Listar";
	}
	
	@GetMapping("/form")
	//-----ResponseEntity<?> en algular
	public String form(Model model) {
		List<cliente> lista=clienteService.findAll();
		model.addAttribute("lista",lista);
		model.addAttribute("titulo","Cargar cliente");
		return "form";
	}
	
	@PostMapping("/form")
	public String guardar(cliente client, RedirectAttributes flash) {
		clienteService.save(client);
		flash.addFlashAttribute("Success","Cliente creado con exito");
		return "redirect:/listar";
	}
}
