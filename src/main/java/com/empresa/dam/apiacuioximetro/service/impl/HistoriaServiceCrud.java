package com.empresa.dam.apiacuioximetro.service.impl;

import com.empresa.dam.apiacuioximetro.entity.HistoriaOxigeno;
import com.empresa.dam.apiacuioximetro.repository.HistoriaNivelRepository;
import com.empresa.dam.apiacuioximetro.service.CrudService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
@NoArgsConstructor
public class HistoriaServiceCrud implements CrudService<HistoriaOxigeno> {
    private HistoriaNivelRepository repository;

    @Autowired
    public HistoriaServiceCrud(HistoriaNivelRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<HistoriaOxigeno> findAll() {
        return this.repository.findAll();
    }

    @Override
    public HistoriaOxigeno findById(int id) {
        return this.repository.findById(id).orElseThrow(() -> new RuntimeException("Historial de oxigeno no encotrado"));
    }

    @Override
    public HistoriaOxigeno create(HistoriaOxigeno entity) {
        return this.repository.save(entity);
    }

    @Override
    public HistoriaOxigeno update(HistoriaOxigeno entity) {
        if (!this.repository.existsById(entity.idEstanque())) throw new RuntimeException("Historial de oxigeno no encontrado");
        return this.repository.save(entity);
    }

    @Override
    public boolean deleteById(int id) {
        this.repository.deleteById(id);
        return !this.repository.existsById(id);
    }
}
