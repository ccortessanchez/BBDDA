/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import java.util.Set;

/**
 *
 * @author carlos
 */
public class Recepta {
    
    private String nom;
    private String elaboracio;
    private int idRecepta;
    private int temps;
    private int dificultat;
    private Xef xef;
    private Plat plat;
    private Menjar menjar;
    private Set<Ingredient> ingredients;

    public Set<Ingredient> getIngredients() {
      return this.ingredients;
    }

    public void setIngredients(Set<Ingredient> ingredients) {
      this.ingredients = ingredients;
    }

    public Recepta(String nom, String elaboracio, int idRecepta, int temps, int dificultat) {
      this.nom = nom;
      this.elaboracio = elaboracio;
      this.idRecepta = idRecepta;
      this.temps = temps;
      this.dificultat = dificultat;
      this.xef = new Xef();
      this.plat = new Plat();
      this.menjar = new Menjar();
    }

    public String getNom() {
      return this.nom;
    }

    public void setNom(String nom) {
      this.nom = nom;
    }

    public String getElaboracio() {
      return this.elaboracio;
    }

    public void setElaboracio(String elaboracio) {
      this.elaboracio = elaboracio;
    }

    public int getIdRecepta() {
      return this.idRecepta;
    }

    public void setIdRecepta(int idRecepta) {
      this.idRecepta = idRecepta;
    }

    public int getTemps() {
      return this.temps;
    }

    public void setTemps(int temps) {
      this.temps = temps;
    }

    public int getDificultat() {
      return this.dificultat;
    }

    public void setDificultat(int dificultat) {
      this.dificultat = dificultat;
    }
    
}
