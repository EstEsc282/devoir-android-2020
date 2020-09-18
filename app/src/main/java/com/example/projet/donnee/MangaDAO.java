package com.example.projet.donnee;

import com.example.projet.modele.Manga;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MangaDAO {

    private static MangaDAO instance = null;
    //private List<HashMap<String,String>> listeManga;
    private List<Manga> listeManga;

    private MangaDAO(){

        //listeManga = new ArrayList<HashMap<String,String>>();
        listeManga = new ArrayList<Manga>();
        preparerListeManga();
    }

    public void preparerListeManga() {

        /*
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
        */

        listeManga.add(new Manga("Naruto - Naruto", "Masashi Kishimoto - Kana", 0));
        listeManga.add(new Manga("Les Chevaliers du Zodiaque - Seitōshi Seiya", "Masashi Kishimoto - Kana", 1));
        listeManga.add(new Manga("Goblin Slayer - Goburin Sureiyā", "Kumo Kagyu - Kurokawa", 2));

    }

    public static MangaDAO getInstance(){
        if(null == instance){
            instance = new MangaDAO();
        }
        return instance;
    }

    public List<Manga> listerManga(){
        return listeManga;
    }

    public void ajouterManga(HashMap<String,String> manga){
        //listeManga.add(manga);
    }
}
