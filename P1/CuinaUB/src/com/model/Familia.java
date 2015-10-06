/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import java.util.Set;

/**
 *
 * @author Carlos Cortes i Pol Girbal
 */
public class Familia {
    private String nom;
    private int idFamilia;
    private String descripcio;
    private Set<Ingredient> ingredients;
  
    public Set<Ingredient> getIngredients() {
        return this.ingredients;
    }
  
    public void setIngredients(Set<Ingredient> ingredients) {
      this.ingredients = ingredients;
    }

    public Familia(String nom, int idFamilia, String descripcio){
      this.nom = nom;
      this.idFamilia = idFamilia;
      this.descripcio = descripcio;
    }

    public Familia() {
    }

    public String getNom() {
      return this.nom;
    }

    public void setNom(String nom) {
      this.nom = nom;
    }

    public int getIdFamilia() {
      return this.idFamilia;
    }

    public void setIdFamilia(int idFamilia) {
      this.idFamilia = idFamilia;
    }

    public String getDescripcio() {
      return this.descripcio;
    }

    public void setDescripcio(String descripcio) {
      this.descripcio = descripcio;
    }
}
