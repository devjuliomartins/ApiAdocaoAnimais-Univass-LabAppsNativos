package com.jftech.api_adocao.model;

import org.springframework.stereotype.Component;

@Component
public class AnimalMapper {

    public Animal toEntity(AnimalCreateRequest dto) {
        Animal animal = new Animal();
        animal.setNome(dto.getNome());
        animal.setEspecie(dto.getEspecie());
        animal.setSexo(dto.getSexo());
        return animal;
    }

    public AnimalResponse toResponse(Animal animal) {
        return new AnimalResponse(
                animal.getId(),
                animal.getNome(),
                animal.getEspecie(),
                animal.getSexo()
        );
    }

    public void updateEntityFromDto(AnimalUpdateRequest dto, Animal animal) {
        animal.setNome(dto.getNome());
        animal.setEspecie(dto.getEspecie());
        animal.setSexo(dto.getSexo());
    }
}
