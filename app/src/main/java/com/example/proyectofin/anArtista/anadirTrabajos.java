package com.example.proyectofin.anArtista;

import androidx.lifecycle.ViewModelProviders;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.proyectofin.R;
import com.example.proyectofin.controlador.BDExposiciones;
import com.example.proyectofin.modelo.Trabajos;

public class anadirTrabajos extends Fragment {

    private Button boton;
    private Context context;
    private BDExposiciones bd;
    private TextView nombre;
    private TextView descrip;
    private TextView tamano;
    private TextView peso;
    private TextView DNI;
    private TextView foto;

    public static anadirTrabajos newInstance() {
        return new anadirTrabajos();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.anadir_trabajos_fragment, container, false);

        boton = vista.findViewById(R.id.button4);
        nombre = vista.findViewById(R.id.nombreTrabajo);
        descrip = vista.findViewById(R.id.descriTrabajo);
        tamano = vista.findViewById(R.id.tamanoTrabajo);
        peso = vista.findViewById(R.id.pesoTrabajo);
        DNI = vista.findViewById(R.id.dniTrabajo);
        foto = vista.findViewById(R.id.fotoTrabajo);

        context = getContext();
        bd = new BDExposiciones(context);

        return vista;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nom = nombre.getText().toString();
                String des = descrip.getText().toString();
                int ta = Integer.parseInt(tamano.getText().toString());
                int pe = Integer.parseInt(peso.getText().toString());
                String dn = DNI.getText().toString();
                String fo = foto.getText().toString();

                Trabajos tra = new Trabajos(nom, des, dn, fo, ta, pe);
                bd.insertarTrabajos(tra);
                bd.close();
            }
        });
        super.onActivityCreated(savedInstanceState);
    }

}