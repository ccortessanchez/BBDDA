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
public class Menjar {
    
    private String nom;
    private int idMenjar;
    private String descripcio;
    private Set<Plat> receptes;

    public Set<Plat> getReceptes() {
      return this.receptes;
    }

    public void setReceptes(Set<Plat> receptes) {
      this.receptes = receptes;
    }

    public Menjar(String nom, int idMenjar, String descripcio) {
      this.nom = nom;
      this.idMenjar = idMenjar;
      this.descripcio = descripcio;
    }

    public Menjar() {
    }

    public String getNom() {
      return this.nom;
    }

    public void setNom(String nom) {
      this.nom = nom;
    }

    public int getIdMenjar() {
      return this.idMenjar;
    }

    public void setIdMenjar(int idMenjar) {
      this.idMenjar = idMenjar;
    }

    public String getDescripcio() {
      return this.descripcio;
    }

    public void setDescripcio(String descripcio) {
      this.descripcio = descripcio;
    }
    
}
