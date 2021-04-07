package com.example.session_01app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.session_01app.models.Usuario;

@Controller
@RequestMapping("/app")
public class ControllerIndex {

	@GetMapping("/index")
	public String index(Model model) {
		model.addAttribute("titulo", "bienvenidos a spring");
		return "index";
	}
	
	@RequestMapping("/perfil")
	public String perfil(Model model) {
		Usuario usuario = new Usuario();
		usuario.setNombre("Jhon");
		usuario.setApellido("Soplopuco");
		usuario.setEmail("jhon.correo");
		model.addAttribute("usuario", usuario);
		
		model.addAttribute("titulo","Perfil del usuario: ".concat(usuario.getNombre()));
		return "perfil";
	}
	
	@RequestMapping("/listar")
	public String listar(Model model) {	
		model.addAttribute("titulo","Listado de usuario");
		
		return "listar";
	}
	
	
	//El ModelAtribute se utiliza para reutilizar ya sea una lista en varias vistas
	@ModelAttribute("usuarios")
	public List<Usuario> listarUsuarios(){
		List<Usuario> usuarios = new ArrayList<>(); 
		usuarios.add(new Usuario("Jhon","Soplopuco","jhon@jhon.com"));
		usuarios.add(new Usuario("Jhonatan","Soplopucosa","jhon@jhonatan.com"));
		usuarios.add(new Usuario("Jhony","Soplopucoes","jhon@jhony.com"));
		
		return usuarios;
	}
	
}
