package com.example.projet.modele;

import java.util.HashMap;

public class Manga {
    protected String titres;
    protected String auteurstudio;
    protected int id;

    public Manga(String titres, String auteurstudio, int id) {
        this.titres = titres;
        this.auteurstudio = auteurstudio;
        this.id = id;
    }

    public String getTitres() {
        return titres;
    }

    public void setTitres(String titres) {
        this.titres = titres;
    }

    public String getAuteurstudio() {
        return auteurstudio;
    }

    public void setAuteurstudio(String auteurstudio) {
        this.auteurstudio = auteurstudio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public HashMap<String,String> obtenirMangaPourAfficher() {
        HashMap<String,String> mangaPourAfficher = new HashMap<String,String>();
        mangaPourAfficher.put("titres", this.titres);
        mangaPourAfficher.put("auteurstudio", this.auteurstudio);
        mangaPourAfficher.put("id","" + this.id);
        return mangaPourAfficher;
    }
}
