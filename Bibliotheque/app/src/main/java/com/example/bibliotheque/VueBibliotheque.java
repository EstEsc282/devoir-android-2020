package com.example.bibliotheque;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class VueBibliotheque extends AppCompatActivity {

    protected ListView VueBibliothequeListeLivre;
    protected List<HashMap<String, String>> listeLivre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vue_bibliotheque);
        VueBibliothequeListeLivre = (ListView)findViewById(R.id.vueBibliothequeListeLivre);

        listeLivre = preparerListeLivre();

        SimpleAdapter adapteur = new SimpleAdapter(
                this,
                listeLivre,
                android.R.layout.two_line_list_item,
                new String[] {"titre","auteur"},
                new int[] {android.R.id.text1, android.R.id.text2});

        VueBibliothequeListeLivre.setAdapter(adapteur);
    }

    public List<HashMap<String, String>> preparerListeLivre() {
        List<HashMap<String,String>> listeLivre = new ArrayList<HashMap<String,String>>();

        HashMap<String,String> livre;

        livre = new HashMap<String,String>();
        livre.put("titre", "Android pour les nuls");
        livre.put("auteur", "Département d'informatique");
        listeLivre.add(livre);

        return listeLivre;
    }
}