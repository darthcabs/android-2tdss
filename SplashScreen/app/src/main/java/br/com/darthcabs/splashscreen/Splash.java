package br.com.darthcabs.splashscreen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Thread(new Tempo()).start();
    }

    class Tempo implements Runnable {
        @Override
        public void run() {
            try {
                Thread.sleep(2000);
                Intent i = new Intent(Splash.this, MainActivity.class);
                startActivity(i);
                finish();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}