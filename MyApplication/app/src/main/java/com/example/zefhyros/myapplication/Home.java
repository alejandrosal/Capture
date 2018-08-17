package com.example.zefhyros.myapplication;

import android.app.Dialog;
import android.content.DialogInterface;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //
        //Boton Fecha
        //

        Button btnFecha = (Button) findViewById(R.id.btnFecha);

        btnFecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder mensajeFecha = new AlertDialog.Builder(Home.this);
                mensajeFecha.setMessage("Selecciona la fecha de tu viaje")
                        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                            }
                        });

                CalendarView calendar = new CalendarView(Home.this);
                mensajeFecha.setView(calendar);
                mensajeFecha.show();
            }
        });

        //
        //Boton Presupuesto
        //

        Button btnPresupuesto = (Button) findViewById(R.id.btnPresupuesto);

        btnPresupuesto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final AlertDialog.Builder mensajePresupuesto = new AlertDialog.Builder(Home.this);
                mensajePresupuesto.setMessage("Selecciona el presupuesto de tu viaje")
                        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                            }
                        });

                EditText txtPresupuesto = new EditText(Home.this);
                TextView textoPresupuesto = new TextView(Home.this);
                textoPresupuesto.setText("$2000 - $200000");
                LinearLayout linear = new LinearLayout(Home.this);
                linear.setOrientation(LinearLayout.VERTICAL);
                linear.addView(txtPresupuesto);
                linear.addView(textoPresupuesto);
                ConstraintLayout nuevo = new ConstraintLayout(Home.this);
                nuevo.addView(linear);

                mensajePresupuesto.setView(nuevo);
                mensajePresupuesto.show();
            }
        });

        //
        //Boton Proposito
        //

        Button btnProposito = (Button) findViewById(R.id.btnProposito);

        btnProposito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final AlertDialog.Builder mensajeProposito = new AlertDialog.Builder(Home.this);
                mensajeProposito.setMessage("Selecciona el proposito de tu viaje")
                        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                            }
                        });

                Spinner spinnerProposito = new Spinner(Home.this);

                List<String> categories = new ArrayList<String>();
                categories.add("uno");
                categories.add("dos");
                categories.add("tres");

                ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(Home.this, android.R.layout.simple_spinner_item, categories);

                dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

                spinnerProposito.setAdapter(dataAdapter);

                mensajeProposito.setView(spinnerProposito);
                mensajeProposito.show();
            }
        });

    }

}
