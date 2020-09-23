package com.example.projet.donnee;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import androidx.core.app.BundleCompat;
import androidx.core.app.ComponentActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.example.projet.R;
import com.example.projet.modele.Manga;

public class MangaDAO {

    private static MangaDAO instance = null;
    //private List<HashMap<String,String>> listeManga;
    private List<Manga> listeManga;


    private BDD bDD;

    private MangaDAO(){

        this.bDD = BDD.getInstance();

        //listeManga = new ArrayList<HashMap<String,String>>();
        listeManga = new ArrayList<Manga>();
        //preparerListeManga();
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

    /*public List<Manga> listerManga(){
        return listeManga;
    }*/

    public List<Manga> listerManga(){
        String LISTER_MANGA = "SELECT * FROM manga";
        Cursor curseur = bDD.getReadableDatabase().rawQuery(LISTER_MANGA,null);
        this.listeManga.clear();
        Manga manga;

        int indexId = curseur.getColumnIndex("id");
        int indexAuteurstudio = curseur.getColumnIndex("auteurstudio");
        int indexTitres = curseur.getColumnIndex("titres");

        for(curseur.moveToFirst();!curseur.isAfterLast();curseur.moveToNext()){
            int id = curseur.getInt(indexId);
            String auteurstudio = curseur.getString(indexAuteurstudio);
            String titres = curseur.getString(indexTitres);
            manga = new Manga(titres, auteurstudio, id);
            this.listeManga.add(manga);
        }
        return listeManga;
    }

    /*public void ajouterManga(HashMap<String,String> manga){
        //listeManga.add(manga);
    }*/

    public void ajouterManga(Manga manga){
        SQLiteDatabase bDDEcriture = bDD.getWritableDatabase();

        bDDEcriture.beginTransaction();
        try{
            ContentValues mangaEnCleValeur = new ContentValues();
            mangaEnCleValeur.put("auteurstudio", manga.getAuteurstudio());
            mangaEnCleValeur.put("titres", manga.getTitres());

            bDDEcriture.insertOrThrow("manga", null, mangaEnCleValeur);
            bDDEcriture.setTransactionSuccessful();
        } catch (Exception e){
            Log.d("MangaDAO", "Erreur en tentant d'ajouter un manga dans la base de données");
        } finally {
            bDDEcriture.endTransaction();
        }
    }

    public Manga chercherMangaParId(int id){
        listerManga();
        for(Manga mangaRecherche : this.listeManga){
            if(mangaRecherche.getId() == id) return mangaRecherche;
        }
        return null;
    }

    public void modifierManga(Manga manga){
        SQLiteDatabase bDDModif = bDD.getWritableDatabase();

        bDDModif.beginTransaction();
        try{
            ContentValues mangaEnCleValeur = new ContentValues();
            mangaEnCleValeur.put("auteurstudio", manga.getAuteurstudio());
            mangaEnCleValeur.put("titres", manga.getTitres());

            bDDModif.update("manga", mangaEnCleValeur, "id" + "= " + manga.getId(), null/*new String[]{String.valueOf(manga.getId())}*/);
            bDDModif.setTransactionSuccessful();
        } catch (Exception e){
            Log.d("MangaDAO", "Erreur en tentant de modifier un manga dans la base de données");
        } finally {
            bDDModif.endTransaction();
        }
    }
    public void alerteManga(Manga manga){
        SQLiteDatabase bDDAl = bDD.getWritableDatabase();

        bDDAl.beginTransaction();
        try{
            ContentValues mangaEnCleValeur = new ContentValues();
            mangaEnCleValeur.put("auteurstudio", manga.getAuteurstudio());
            mangaEnCleValeur.put("titres", manga.getTitres());

            bDDAl.insertOrThrow("manga", null, mangaEnCleValeur);
            bDDAl.setTransactionSuccessful();
        } catch (Exception e){
            Log.d("MangaDAO", "Erreur en tentant de modifier un manga dans la base de données");
        } finally {
            bDDAl.endTransaction();
        }
    }
}
