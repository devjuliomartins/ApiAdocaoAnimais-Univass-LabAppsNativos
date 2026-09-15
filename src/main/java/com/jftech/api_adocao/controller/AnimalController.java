package com.jftech.api_adocao.controller;

import com.jftech.api_adocao.model.*;
import com.jftech.api_adocao.service.AnimalService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/animal")
public class AnimalController {

    private final AnimalService service;

    public AnimalController(AnimalService service) {
        this.service = service;
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<AnimalResponse> cadastrar(@Valid @RequestBody AnimalCreateRequest dto) {
        AnimalResponse response = service.criar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<AnimalResponse>> consultar() {
        List<AnimalResponse> lista = service.listar();
        return ResponseEntity.ok(lista);
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<AnimalResponse> consultarId(@PathVariable Long id) {
        AnimalResponse response = service.buscarPorId(id);
        return ResponseEntity.ok(response);
    }

    @PutMapping(value = "/{id}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<AnimalResponse> atualizar(@PathVariable Long id, @Valid @RequestBody AnimalUpdateRequest dto) {
        AnimalResponse response = service.atualizar(id, dto);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
