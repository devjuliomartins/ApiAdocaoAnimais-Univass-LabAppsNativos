package com.jftech.api_adocao.model;

public class AnimalResponse {
    private Long id;
    private String nome;
    private String especie;
    private Sexo sexo;

    public AnimalResponse() {}

    public AnimalResponse(Long id, String nome, String especie, Sexo sexo) {
        this.id = id;
        this.nome = nome;
        this.especie = especie;
        this.sexo = sexo;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

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
