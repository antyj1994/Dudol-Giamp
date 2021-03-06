package com.ilmale.doodlejump;

import android.arch.persistence.room.Room;
import android.arch.persistence.room.migration.Migration;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.ilmale.doodlejump.database.OurDatabase;

//activity that handles the fragments of the account management

public class RegisterActivity extends AppCompatActivity {

    public static FragmentManager fm;
    private AudioManager audioManager = AudioManager.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        fm=getSupportFragmentManager();
        if(findViewById(R.id.fragment_container)!=null) {

            if (savedInstanceState != null) {
                return;
            }
            fm.beginTransaction().add(R.id.fragment_container, new RegisterFragment()).commit();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        audioManager.playBg_audio();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(audioManager.isCanStopBgAudio()){
            audioManager.pauseBg_audio();
        }
        audioManager.setCanStopBgAudio(true);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        audioManager.setCanStopBgAudio(false);
    }
}
