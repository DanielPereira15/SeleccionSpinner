package com.example.seleccionspinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Spinner comboPaises;
    TextView estado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        estado=findViewById(R.id.tvSeleccion);
        comboPaises=findViewById(R.id.idSpinnerPaises);

        //origen de los datos
        //ArrayList<String>paises = new ArrayList<String>();
        //paises.add("Seleccione");
        //paises.add("España");
        //paises.add("Francia");
        //paises.add("Alemania");
        //paises.add("Italia");
        //paises.add("Holanda");


        //llenar Adaptador con el origen de los datos
        //ArrayAdapter<CharSequence> adaptador = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item,paises);

        ArrayAdapter<CharSequence> adaptador= ArrayAdapter.createFromResource(this,R.array.arrayPaises, android.R.layout.simple_spinner_dropdown_item);



        //llenamos el combo con los datos del adaptador
        comboPaises.setAdapter(adaptador);


        comboPaises.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(),"Seleccionado: "+adapterView.getItemAtPosition(i).toString(),Toast.LENGTH_LONG).show();
                estado.setText("Seleccionado: "+adapterView.getItemAtPosition(i).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}