package com.example.projet.vue;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.projet.R;
import com.example.projet.donnee.MangaDAO;
import com.example.projet.modele.Manga;
import com.example.projet.modele.NotificationReceiver;

import java.util.HashMap;

public class VueAlerteManga extends AppCompatActivity {

    protected EditText vueAlerteMangaChampTitres;
    protected EditText vueAlerteMangaChampAuteurstudio;
    protected MangaDAO mangaDAO;
    protected Manga manga;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vue_alerte_manga);

        Button vueAlerteMangaActionAnnuler = (Button)findViewById(R.id.vueAlerteMangaActionAnnuler);

        vueAlerteMangaActionAnnuler.setOnClickListener(

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

        vueAlerteMangaChampTitres = (EditText)findViewById(R.id.vueAlerteMangaChampTitres);
        vueAlerteMangaChampAuteurstudio = (EditText)findViewById(R.id.vueAlerteMangaChampAuteurstudio);
        vueAlerteMangaChampTitres.setText(manga.getTitres());

        Button vueAlerteMangaActionAjouter = (Button)findViewById(R.id.vueAlerteMangaActionAjouter);

        vueAlerteMangaActionAjouter.setOnClickListener(

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
                        scheduleNotification( getApplication(),10,"title","ok boomer");
                        naviguerRetourManga();
                    }
                }
        );
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public static void scheduleNotification(Context context, long time, String title, String text) {
        Intent intent = new Intent(context, NotificationReceiver.class);
        intent.putExtra("title", title);
        intent.putExtra("text", text);
        PendingIntent pending = PendingIntent.getBroadcast(context, 42, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        // Schdedule notification
        AlarmManager manager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        manager.setExactAndAllowWhileIdle(AlarmManager.ELAPSED_REALTIME, time, pending);
    }

    public static void cancelNotification(Context context, String title, String text) {
        Intent intent = new Intent(context, NotificationReceiver.class);
        intent.putExtra("title", title);
        intent.putExtra("text", text);
        PendingIntent pending = PendingIntent.getBroadcast(context, 42, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        // Cancel notification
        AlarmManager manager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        manager.cancel(pending);
    }

    private void enregistrerManga() {
        Manga manga = new Manga(vueAlerteMangaChampTitres.getText().toString(),
                vueAlerteMangaChampAuteurstudio.getText().toString(),0);

        mangaDAO = MangaDAO.getInstance();
        mangaDAO.alerteManga(manga);
    }

    public void naviguerRetourManga(){
        this.finish();
    }
}