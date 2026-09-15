package com.jftech.api_adocao.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class AnimalCreateRequest {

    @NotBlank(message = "Nome é obrigatório")
    @Size(min = 2, max = 50)
    private String nome;

    @NotBlank(message = "Espécie é obrigatória")
    private String especie;

    @NotNull
    private Sexo sexo;

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecie() {
        return especie;
    }
    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public Sexo getSexo() {
        return sexo;
    }
    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }
}
