package com.celular.model;

import java.util.Dictionary;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;

public class Loja {
    private String nome;
    private Long telefone;
    private List<Celular> celulares = new LinkedList<Celular>();
    private HashSet<Integer> hashCelulares = new HashSet<Integer>();
    private Dictionary<Integer, Celular> dicCelulares = new Hashtable<Integer, Celular>();

    public Loja() {}

    public void addCelular(Celular celular) {
        celulares.add(celular);
        hashCelulares.add(celular.getId());
        dicCelulares.put(celular.getId(), celular);
    }

    public List<Celular> getCelular() {
        return celulares;
    }

    public HashSet<Integer> getHashCelular() {
        return hashCelulares;
    }

    public Dictionary<Integer, Celular> getDicCelular() {
        return dicCelulares;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getTelefone() {
        return this.telefone;
    }

    public void setTelefone(Long telefone) {
        this.telefone = telefone;
    }

    public List<Celular> getCelulares() {
        return this.celulares;
    }

    public void setCelulares(List<Celular> celulares) {
        this.celulares = celulares;
    }
}
