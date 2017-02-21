package com.davidenterprises.tabuada;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class TabuadaActivity extends AppCompatActivity {

    private TextView txtNum1;
    private TextView txtNum2;
    private EditText resposta;
    private ImageView[] imgGarrafa = new ImageView[4];
    private int pontos = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabuada);

        txtNum1 = (TextView) findViewById(R.id.txtNum1);
        txtNum2 = (TextView) findViewById(R.id.txtNum2);
        resposta = (EditText) findViewById(R.id.edtResposta);
        imgGarrafa[0] = (ImageView) findViewById(R.id.garrafa1);
        imgGarrafa[1] = (ImageView) findViewById(R.id.garrafa2);
        imgGarrafa[2] = (ImageView) findViewById(R.id.garrafa3);
        imgGarrafa[3] = (ImageView) findViewById(R.id.garrafa4);

        sortear();
    }

    private void sortear() {
        Random r = new Random();
        int num1 = r.nextInt(9) + 1;
        int num2 = r.nextInt(9) + 1;

        txtNum1.setText(String.valueOf(num1));
        txtNum2.setText(String.valueOf(num2));
        resposta.setText("");
    }

    private void marcarPonto(){
        this.imgGarrafa[pontos].setImageResource(android.R.drawable.screen_background_light_transparent);
        this.pontos++;
        this.imgGarrafa[pontos].setImageResource(R.drawable.garrafa);
    }

    public void btnOk_click(View v){
        String resp = resposta.getText().toString();

        int num1 = Integer.parseInt(txtNum1.getText().toString());
        int num2 = Integer.parseInt(txtNum2.getText().toString());

        if (Integer.parseInt(resp) == num1 * num2){
            marcarPonto();
        }

        if (pontos == (imgGarrafa.length -1)){
            Toast.makeText(this, R.string.msgWon, Toast.LENGTH_SHORT).show();

            this.imgGarrafa[pontos].setImageResource(android.R.drawable.screen_background_light_transparent);
            this.pontos = 0;
            this.imgGarrafa[pontos].setImageResource(R.drawable.garrafa);
        }
        sortear();
    }
}