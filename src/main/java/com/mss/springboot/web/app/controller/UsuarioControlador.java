package com.mss.springboot.web.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mss.springboot.web.app.model.Usuarios;
import com.mss.springboot.web.app.repository.UsuariosRepositorio;



@RestController
@RequestMapping("/usuarios")
public class UsuarioControlador {
	
	
	@Autowired
	private UsuariosRepositorio usuariosRepositorio;
	
	
	
	//	Crear
	@PostMapping
	public ResponseEntity<?> saveUser(@RequestBody Usuarios usuarios){
		try {
			Usuarios userSave = usuariosRepositorio.save(usuarios);
			return new ResponseEntity<Usuarios> (userSave, HttpStatus.CREATED);
		}catch(Exception e) {
			return new ResponseEntity<String> (e.getCause().toString(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	
	//	Actualizar
	@PutMapping
	public ResponseEntity<?> updateUser(@RequestBody Usuarios usuarios){
		try {
			Usuarios userSave = usuariosRepositorio.save(usuarios);
			return new ResponseEntity<Usuarios> (userSave, HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<String> (e.getCause().toString(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	//	Listar
	@GetMapping
	public ResponseEntity<?> findAllUsers(){
		try {
			List<Usuarios> users = usuariosRepositorio.findAll();
			return new ResponseEntity<List<Usuarios>> (users, HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<String> (e.getCause().toString(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	//	Buscar por ID
	@GetMapping("/{id}")
	public ResponseEntity<?> getUserById(@PathVariable("id") Integer id) {
	    Optional<Usuarios> user = usuariosRepositorio.findById(id);
	    if (user.isPresent()) {
	        return new ResponseEntity<Usuarios>(user.get(), HttpStatus.OK);
	    } else {
	        return new ResponseEntity<String>("Usuario no encontrado", HttpStatus.NOT_FOUND);
	    }
	}
	
	
	//	Eliminar
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable("id") Integer id){
		try {
			usuariosRepositorio.deleteById(id);
			return new ResponseEntity<String> ("Usuario Eliminado ;)", HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<String> (e.getCause().toString(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
	
}