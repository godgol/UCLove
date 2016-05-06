package com.example.christophe.uclove;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Christophe on 06.05.2016.
 */
public class OutgoingActivity extends AppCompatActivity{
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.outgoing_content);

        //cette classe était prévu pour afficher toutes les requêtes sortantes de l'utilisateur, c.à.d.
        //toutes les requêtes qu'il a envoyé en likant un utilisateur dans l'Activité People

    }
}
