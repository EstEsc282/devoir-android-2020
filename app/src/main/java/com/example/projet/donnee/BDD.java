package com.example.projet.donnee;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BDD extends SQLiteOpenHelper{
    private static BDD instance = null;

    public static synchronized BDD getInstance(Context contexte){
        instance = new BDD(contexte);
        return instance;
    }

    public static BDD getInstance(){
        return instance;
    }

    public BDD(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context, name, factory, version);
    }

    public BDD(Context contexte){
        super(contexte, "bbibliomanga", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        String CREATE_TABLE = "create table manga(id INTEGER PRIMARY KEY, titres TEXT, auteurstudio TEXT)";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onOpen(SQLiteDatabase db){

        String DELETE = "delete from manga where 1 = 1";
        db.execSQL(DELETE);

        String INSERT_1 = "insert into manga(titres, auteurstudio) VALUES('Naruto - Naruto', 'Masashi Kishimoto - Kana')";
        String INSERT_2 = "insert into manga(titres, auteurstudio) VALUES('Les Chevaliers du Zodiaque - Seitōshi Seiya', 'Masashi Kishimoto - Kana')";
        String INSERT_3 = "insert into manga(titres, auteurstudio) VALUES('Goblin Slayer - Goburin Sureiyā', 'Kumo Kagyu - Kurokawa')";

        db.execSQL(INSERT_1);
        db.execSQL(INSERT_2);
        db.execSQL(INSERT_3);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int arg1, int arg2){
        //String DROP_TABLE = "drop table manga;
        //db.execSQL(DROP_TABLE);
        String CREER_TABLE = "create table manga(id INTEGER PRIMARY KEY, titres TEXT, auteurstudio TEXT)";
        db.execSQL(CREER_TABLE);
    }

}
