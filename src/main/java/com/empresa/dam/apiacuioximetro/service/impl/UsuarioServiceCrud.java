package com.empresa.dam.apiacuioximetro.service.impl;

import com.empresa.dam.apiacuioximetro.entity.Usuario;
import com.empresa.dam.apiacuioximetro.repository.UsuarioRepository;
import com.empresa.dam.apiacuioximetro.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceCrud implements CrudService<Usuario> {
    private final UsuarioRepository repository;

    @Autowired
    public UsuarioServiceCrud(UsuarioRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Usuario> findAll() {
        return repository.findAll();
    }

    @Override
    public Usuario findById(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Usuario create(Usuario entity) {
        return repository.save(entity);
    }

    @Override
    public Usuario update(Usuario entity) {
        if(!repository.existsById(entity.idUsuario())) throw new RuntimeException("Usuario no existe");
        return repository.save(entity);
    }

    @Override
    public boolean deleteById(int id) {
        repository.deleteById(id);
        return !repository.existsById(id);
    }
}