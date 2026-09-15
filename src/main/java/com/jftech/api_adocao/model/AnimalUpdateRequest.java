package com.jftech.api_adocao.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class AnimalUpdateRequest {
    @NotBlank(message = "Nome não pode ser vazio")
    private String nome;

    @NotBlank(message = "Espécie não pode ser vazia")
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
