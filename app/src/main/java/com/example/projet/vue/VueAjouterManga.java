package com.example.projet.vue;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.projet.R;
import com.example.projet.donnee.MangaDAO;
import com.example.projet.modele.Manga;

import java.util.HashMap;

public class VueAjouterManga extends AppCompatActivity {

    protected EditText vueAjouterMangaChampTitres;
    protected EditText vueAjouterMangaChampAuteurStudio;
    protected MangaDAO mangaDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vue_ajouter_manga);

        Button vueAjouterMangaActionAnnuler = (Button)findViewById(R.id.vueAjouterMangaActionAnnuler);

        vueAjouterMangaActionAnnuler.setOnClickListener(

                new View.OnClickListener() {

                    public void onClick(View arg0) {
                        //TODO : +tard

                        /*
                        Toast message = Toast.makeText(
                                getApplication(),
                                "Action annuler",
                                Toast.LENGTH_SHORT);
                        message.show();
                        */
                        naviguerRetourManga();
                    }
                }
        );

        vueAjouterMangaChampTitres = (EditText)findViewById(R.id.vueAjouterMangaChampTitres);
        vueAjouterMangaChampAuteurStudio = (EditText)findViewById(R.id.vueAjouterMangaChampAuteurStudio);

        Button vueAjouterMangaActionAjouter = (Button)findViewById(R.id.vueAjouterMangaActionAjouter);

        vueAjouterMangaActionAjouter.setOnClickListener(

                new View.OnClickListener() {

                    public void onClick(View arg0) {
                        //TODO : +tard

                        /*
                        Toast message = Toast.makeText(
                                getApplicationContext(),
                                "Champ Titres : "+vueAjouterMangaChampTitres.getText().toString()+
                                        "Champ Auteur/Studio : "+vueAjouterMangaChampAuteurStudio.getText().toString(),
                                Toast.LENGTH_SHORT);
                        message.show();
                        */
                        enregistrerManga();
                        naviguerRetourManga();
                    }
                }
        );
    }

    private void enregistrerManga() {
        /*
        HashMap<String,String> manga;

        manga = new HashMap<String ,String>();
        manga.put("titreFr - titreJp", vueAjouterMangaChampTitres.getText().toString());
        manga.put("auteur - studio", vueAjouterMangaChampAuteurStudio.getText().toString());

        mangaDAO = MangaDAO.getInstance();
        mangaDAO.ajouterManga(manga);
        */

        Manga manga = new Manga(vueAjouterMangaChampTitres.getText().toString(),
                vueAjouterMangaChampAuteurStudio.getText().toString(),0);

        mangaDAO = MangaDAO.getInstance();
        mangaDAO.ajouterManga(manga);
    }

    public void naviguerRetourManga(){
        this.finish();
    }
}