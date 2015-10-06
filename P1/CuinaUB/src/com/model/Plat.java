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
public class Plat {
    
    private String nom;
    private int idPlat;
    private String descripcio;
    private Set<Plat> receptes;

    
    public Set<Plat> getReceptes() {
      return this.receptes;
    }

    public void setReceptes(Set<Plat> receptes) {
      this.receptes = receptes;
    }

    public Plat(String nom, int idPlat, String descripcio) {
      this.nom = nom;
      this.idPlat = idPlat;
      this.descripcio = descripcio;
    }

    public Plat() {
    }

    public String getNom() {
      return this.nom;
    }

    public void setNom(String nom) {
      this.nom = nom;
    }

    public int getIdPlat() {
      return this.idPlat;
    }

    public void setIdPlat(int idPlat) {
      this.idPlat = idPlat;
    }

    public String getDescripcio() {
      return this.descripcio;
    }

    public void setDescripcio(String descripcio) {
      this.descripcio = descripcio;
    }
}
