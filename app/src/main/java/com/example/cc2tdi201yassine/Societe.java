package com.example.cc2tdi201yassine;

import java.io.Serializable;

public class Societe implements Serializable {

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public String getSecteur_activite() {
        return Secteur_activite;
    }

    public void setSecteur_activite(String secteur_activite) {
        Secteur_activite = secteur_activite;
    }

    public int getNombre_employe() {
        return Nombre_employe;
    }

    public void setNombre_employe(int nombre_employe) {
        Nombre_employe = nombre_employe;
    }

    private int ID;
    private String Nom ;
    private String Secteur_activite ;
    private int Nombre_employe;




    public Societe() {
    }

    public Societe(String nom, String secteur_activite, int nombre_employe) {
        Nom = nom;
        Secteur_activite = secteur_activite;
        Nombre_employe = nombre_employe;
    }

    public Societe(int ID, String nom, String secteur_activite, int nombre_employe) {
        this.ID = ID;
        Nom = nom;
        Secteur_activite = secteur_activite;
        Nombre_employe = nombre_employe;
    }
}
