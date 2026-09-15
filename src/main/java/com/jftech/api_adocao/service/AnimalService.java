package com.jftech.api_adocao.service;

import com.jftech.api_adocao.model.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class AnimalService {

    private final List<Animal> banco = new ArrayList<>(); // banco na memória
    private final AnimalMapper mapper;
    private final AtomicLong sequence = new AtomicLong(1);

    public AnimalService(AnimalMapper mapper) {
        this.mapper = mapper;
    }

    public long gerarNovoId() {
        return sequence.getAndIncrement();
    }

    public AnimalResponse criar(AnimalCreateRequest dto) {
        Animal animal = mapper.toEntity(dto);
        animal.setId(sequence.getAndIncrement());

        banco.add(animal);

        return mapper.toResponse(animal);
    }

    public List<AnimalResponse> listar() {
        return banco.stream()
                .map(mapper::toResponse)
                .toList();
    }

    public AnimalResponse buscarPorId(Long id) {
        Optional<Animal> optAnimal = banco.stream()
                .filter(animal -> animal.getId().equals(id))
                .findFirst();
        return mapper.toResponse(optAnimal.get());
    }

    public AnimalResponse atualizar(Long id, AnimalUpdateRequest dto) {
        Optional<Animal> optAnimal = banco.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();

        if (optAnimal.isEmpty()) {
            throw new RuntimeException("Animal não encontrado");
        }

        Animal animal = optAnimal.get();
        mapper.updateEntityFromDto(dto, animal);

        return mapper.toResponse(animal);
    }

    public void excluir(Long id) {
        boolean removido = banco.removeIf(
        animal -> animal.getId().equals(id)
        );
    }
}
