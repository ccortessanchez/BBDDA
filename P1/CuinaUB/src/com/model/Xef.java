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
public class Xef {
    private String nom;
    private int idXef;
    private int estrelles;
    private Set<Plat> receptes;

    public Xef(String nom, int idXef, int estrelles) {
      this.nom = nom;
      this.idXef = idXef;
      this.estrelles = estrelles;
    }

    public Set<Plat> getReceptes() {
      return this.receptes;
    }

    public void setReceptes(Set<Plat> receptes) {
      this.receptes = receptes;
    }

    public Xef() {
    }

    public String getNom() {
      return this.nom;
    }

    public void setNom(String nom) {
      this.nom = nom;
    }

    public int getIdXef() {
      return this.idXef;
    }

    public void setIdXef(int idXef) {
      this.idXef = idXef;
    }

    public int getEstrelles() {
      return this.estrelles;
    }

    public void setEstrelles(int estrelles) {
      this.estrelles = estrelles;
    }
}
