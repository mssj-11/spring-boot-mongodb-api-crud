package com.mss.springboot.web.app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mss.springboot.web.app.model.Usuarios;


public interface UsuariosRepositorio extends MongoRepository<Usuarios, Integer>{
	
}