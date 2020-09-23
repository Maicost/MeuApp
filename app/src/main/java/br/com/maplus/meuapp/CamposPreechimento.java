package br.com.maplus.meuapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class CamposPreechimento extends AppCompatActivity {

    EditText editTextNome, editTextEmail, editTextTelefone, editTextIdade;
    RadioButton radioButtonAndroid, radioButtonIOS, radioButtonWindowsPhone;
    Button btn_continuar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_campos_preechimento);

        editTextNome = findViewById(R.id.Nome);
        editTextEmail = findViewById(R.id.Email);
        editTextTelefone = findViewById(R.id.Telefone);
        editTextIdade = findViewById(R.id.Idade);

        radioButtonAndroid = findViewById(R.id.Android);
        radioButtonIOS = findViewById(R.id.IOS);
        radioButtonWindowsPhone = findViewById(R.id.WindowsPhone);

        btn_continuar = findViewById(R.id.button2);

        btn_continuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CamposPreechimento.this, Dados.class);
                intent.putExtra("nome", "" + editTextNome.getText());
                intent.putExtra("email", "" + editTextEmail.getText());
                intent.putExtra("idade", "" + editTextIdade.getText());
                if (radioButtonAndroid.isChecked()) {
                    intent.putExtra("sistemaOperacional", ""+radioButtonWindowsPhone.getText());
                }
                if (radioButtonIOS.isChecked()) {
                    intent.putExtra("sistemaOperacional", ""+radioButtonIOS.getText());
                }
                if (radioButtonWindowsPhone.isChecked()) {
                    intent.putExtra("sistemaOperacional", ""+radioButtonWindowsPhone.getText());
                }

                startActivity(intent);
            }
        });
    }
}