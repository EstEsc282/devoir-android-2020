package com.example.projet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class VueManga extends AppCompatActivity {

    protected ListView VueMangaListe;
    protected List<HashMap<String, String>> listeManga;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vue_manga);
        VueMangaListe = (ListView)findViewById(R.id.vueMangaListe);

        listeManga = preparerListeLivre();

        SimpleAdapter adapteur = new SimpleAdapter(
                this,
                listeManga,
                android.R.layout.two_line_list_item,
                new String[] {"titreFr - titreJp", "auteur - studio"},
                new int[] {android.R.id.text1, android.R.id.text2});

        VueMangaListe.setAdapter(adapteur);
    }

    public List<HashMap<String, String>> preparerListeLivre() {
        List<HashMap<String,String>> listeManga = new ArrayList<HashMap<String,String>>();

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

        return listeManga;
    }
}