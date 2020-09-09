package com.example.projet.donnee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MangaDAO {

    private static MangaDAO instance = null;
    private List<HashMap<String,String>> listeManga;

    private MangaDAO(){

        listeManga = new ArrayList<HashMap<String,String>>();
        preparerListeManga();
    }

    public void preparerListeManga() {

        HashMap<String,String> manga;

        manga = new HashMap<String,String>();
        manga.put("titreFr - titreJp", "Naruto - Naruto");
        manga.put("auteur - studio", "Masashi Kishimoto - Kana");
        listeManga.add(manga);

        manga = new HashMap<String,String>();
        manga.put("titreFr - titreJp", "Les Chevaliers du Zodiaque - Seitōshi Seiya");
        manga.put("auteur - studio", "Masami Kurumada - Kana");
        listeManga.add(manga);

        manga = new HashMap<String,String>();
        manga.put("titreFr - titreJp", "Goblin Slayer - Goburin Sureiyā");
        manga.put("auteur - studio", "Kumo Kagyu - Kurokawa");
        listeManga.add(manga);

    }

    public static MangaDAO getInstance(){
        if(null == instance){
            instance = new MangaDAO();
        }
        return instance;
    }

    public List<HashMap<String,String>> listerManga(){
        return listeManga;
    }

    public void ajouterManga(HashMap<String,String> manga){
        listeManga.add(manga);
    }
}
