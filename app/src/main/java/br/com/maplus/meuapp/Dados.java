package br.com.maplus.meuapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Dados extends AppCompatActivity {

    private TextView nome, email, idade, estado, sistemaOperacional;
    private Button btn_fechar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dados);

        nome = findViewById(R.id.textView4);
        email = findViewById(R.id.textView6);
        idade = findViewById(R.id.textView8);
        estado = findViewById(R.id.textView10);
        sistemaOperacional = findViewById(R.id.textView12);

        btn_fechar = findViewById(R.id.button3);

        nome.setText(getIntent().getExtras().getString("nome"));
        email.setText(getIntent().getExtras().getString("email"));
        idade.setText(getIntent().getExtras().getString("idade"));
        estado.setText(getIntent().getExtras().getString("estado"));
        sistemaOperacional.setText(getIntent().getExtras().getString("sistemaOperacional"));

        btn_fechar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finishAffinity();
            }
        });
    }
}