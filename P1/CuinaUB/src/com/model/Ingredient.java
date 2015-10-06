/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

/**
 *
 * @author Carlos Cortes i Pol Girbal
 */
public class Ingredient {
    private String nom;
    private int idIngredient;
    private boolean refrigeracio;
    private Familia familia;

    public Ingredient(String nom, int idIngredient, boolean refrigeracio) {
      this.nom = nom;
      this.idIngredient = idIngredient;
      this.refrigeracio = refrigeracio;
      this.familia = new Familia();
    }

    public String getNom() {
      return this.nom;
    }

    public void setNom(String nom) {
      this.nom = nom;
    }

    public int getIdIngredient() {
      return this.idIngredient;
    }

    public void setIdIngredient(int idIngredient) {
      this.idIngredient = idIngredient;
    }

    public boolean isRefrigeracio() {
      return this.refrigeracio;
    }

    public void setRefrigeracio(boolean refrigeracio) {
      this.refrigeracio = refrigeracio;
    }
    
}
