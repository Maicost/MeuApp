package br.com.maplus.meuapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class CamposPreechimento extends AppCompatActivity {

    EditText editTextNome, editTextEmail, editTextTelefone, editTextIdade;
    RadioButton radioButtonAndroid, radioButtonIOS, radioButtonWindowsPhone;
    Spinner spinnerEstado;
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

        spinnerEstado = findViewById(R.id.spinner);

        btn_continuar = findViewById(R.id.button2);

        radioButtonAndroid.setChecked(true);

        ArrayList<String> estados = new ArrayList<>();
        estados.add("Rio Grande do Sul");
        estados.add("Santa Catarina");
        estados.add("Paraná");
        estados.add("São Paulo");

        InitialSpinners(spinnerEstado, estados);

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

                intent.putExtra("estado", ""+spinnerEstado.getSelectedItem().toString());

                startActivity(intent);
            }
        });
    }
    private void InitialSpinners(Spinner spinner, ArrayList<String> arrayList){
        final List<String> list = new ArrayList<String>();

        try {
            list.addAll(arrayList);
        }
        catch (Exception e){
            list.add("Vazio");
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    } //ID spinner and List of items
}