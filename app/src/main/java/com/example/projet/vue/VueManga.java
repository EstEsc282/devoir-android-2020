package com.example.projet.vue;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.example.projet.R;
import com.example.projet.donnee.MangaDAO;
import com.example.projet.modele.Manga;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static android.widget.Toast.makeText;

public class VueManga extends AppCompatActivity {

    protected ListView VueMangaListe;
    //protected List<HashMap<String, String>> listeManga;
    protected List<Manga> listeManga;
    protected MangaDAO mangaDAO;

    protected Intent intentionNaviguerAjouterManga;
    protected Intent intentionNaviguerModifierManga;

    static final public int ACTIVITE_AJOUTER_MANGA = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vue_manga);
        VueMangaListe = (ListView)findViewById(R.id.vueMangaListe);

        mangaDAO = MangaDAO.getInstance();
        /*
        listeManga = mangaDAO.listerManga();

        SimpleAdapter adapteur = new SimpleAdapter(
                this,
                listeManga,
                android.R.layout.two_line_list_item,
                new String[] {"titreFr - titreJp", "auteur - studio"},
                new int[] {android.R.id.text1, android.R.id.text2});

        VueMangaListe.setAdapter(adapteur);
        */

        afficherListeManga();

        Button vueMangaActionAjouterManga = (Button)findViewById(R.id.vueMangaListeActionAjouterManga);

        intentionNaviguerAjouterManga = new Intent(this,VueAjouterManga.class);

        vueMangaActionAjouterManga.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View arg0) {
                        //TODO : +tard
                        /*
                        Toast message = Toast.makeText(
                                getApplication(),
                                "Action ajouter manga",
                                Toast.LENGTH_SHORT);
                        message.show();
                        */
                        //startActivity(intentionNaviguerAjouterManga);
                        startActivityForResult(intentionNaviguerAjouterManga, ACTIVITE_AJOUTER_MANGA);
                    }
                }
        );

        intentionNaviguerModifierManga = new Intent(this,VueModifierManga.class);

        VueMangaListe.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent,
                                            View vue,
                                            int positionDansAdapteur,
                                            long positionItem) {
                        ListView VueMangaListe = (ListView)vue.getParent();

                        @SuppressWarnings("unchecked")
                        HashMap<String,String> manga =
                                (HashMap<String,String>)
                                        VueMangaListe.getItemAtPosition((int)positionItem);
                        /*
                        Toast message = Toast.makeText(getApplicationContext(),
                                "Position " + positionItem + " titres " + manga.get("titreFr - titreJp"),
                                Toast.LENGTH_SHORT);
                        message.show();
                        */
                        startActivity(intentionNaviguerModifierManga);
                    }
                }
        );
    }

    protected void onActivityResult(int activite, int resultat, Intent donnees){
        super.onActivityResult(activite, resultat, donnees);
        switch (activite){
            case ACTIVITE_AJOUTER_MANGA:
                afficherListeManga();
                break;
        }
    }

    public void afficherListeManga(){
        listeManga = mangaDAO.listerManga();

        List<HashMap<String,String>> listeMangaPourAfficher =
                new ArrayList<HashMap<String, String>>();

        for(Manga manga:listeManga){
            listeMangaPourAfficher.add(manga.obtenirMangaPourAfficher());
        }

        SimpleAdapter adapter = new SimpleAdapter(
                this,
                listeMangaPourAfficher,
                android.R.layout.two_line_list_item,
                new String[] {"titreFr - titreJp","auteur - studio"},
                new int[] {android.R.id.text1, android.R.id.text2});
        VueMangaListe.setAdapter(adapter);
    }

/*
    public List<HashMap<String, String>> preparerListeManga() {
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
    }*/
}