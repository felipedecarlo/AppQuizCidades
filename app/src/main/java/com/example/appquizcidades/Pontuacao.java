package com.example.appquizcidades;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Pontuacao extends AppCompatActivity {

    TextView textViewOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pontuacao);

        textViewOutput = findViewById(R.id.textViewPontuacao);

        Intent it = getIntent();

        if (it != null) {
            int pontos = it.getIntExtra("pontos", 0);
            System.out.println("pontos:" + pontos);
            textViewOutput.setText(Integer.valueOf(pontos).toString());
        }
    }
}