package com.example.projet.vue;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.projet.R;
import com.example.projet.donnee.MangaDAO;
import com.example.projet.modele.Manga;

public class VueModifierManga extends AppCompatActivity {

    protected EditText vueModifierMangaChampTitres;
    protected EditText vueModifierMangaChampAuteurstudio;
    protected MangaDAO mangaDAO;
    protected Manga manga;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vue_modifier_manga);

        Button vueModifierMangaActionAnnuler = (Button)findViewById(R.id.vueModifierMangaActionAnnuler);

        vueModifierMangaActionAnnuler.setOnClickListener(

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

        Bundle parametres = this.getIntent().getExtras();
        String idParametre = (String) parametres.get("id");
        int id = Integer.parseInt(idParametre);
        mangaDAO = MangaDAO.getInstance();
        manga = mangaDAO.chercherMangaParId(id);

        vueModifierMangaChampTitres = (EditText)findViewById(R.id.vueModifierMangaChampTitres);
        vueModifierMangaChampAuteurstudio = (EditText)findViewById(R.id.vueModifierMangaChampAuteurstudio);
        vueModifierMangaChampTitres.setText(manga.getTitres());
        vueModifierMangaChampAuteurstudio.setText(manga.getAuteurstudio());

        Button vueModifierMangaActionModifier = (Button)findViewById(R.id.vueModifierMangaActionModifier);

        vueModifierMangaActionModifier.setOnClickListener(
                new View.OnClickListener(){

                    public void onClick(View arg0) {
/*
                        Toast message = Toast.makeText(
                                getApplicationContext(),
                                "Champ titres:"+vueModifierMangaChampTitres.getText().toString()+
                                        " Champ auteur et studio:"+vueModifierMangaChampAuteurstudio.getText().toString(),
                                Toast.LENGTH_SHORT);
                        message.show();
*/
                        enregistrerManga();
                        naviguerRetourManga();
                    }
                }
        );
    }

    private void enregistrerManga(){
        manga.setAuteurstudio(vueModifierMangaChampAuteurstudio.getText().toString());
        manga.setTitres(vueModifierMangaChampTitres.getText().toString());
        mangaDAO.modifierManga(manga);
    }

    public void naviguerRetourManga(){
        this.finish();
    }
}