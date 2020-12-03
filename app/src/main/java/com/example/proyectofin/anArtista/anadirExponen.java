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
import com.example.proyectofin.modelo.Exponen;

public class anadirExponen extends Fragment {

    private Button boton;
    private Context context;
    private BDExposiciones bd;
    private TextView idEx;
    private TextView dni;

    public static anadirExponen newInstance() {
        return new anadirExponen();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.anadir_exponen_fragment, container, false);

        boton = vista.findViewById(R.id.button3);
        idEx = vista.findViewById(R.id.idExponen);
        dni = vista.findViewById(R.id.nombreExponen);

        context = getContext();
        bd = new BDExposiciones(context);

        return vista;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = idEx.getText().toString();
                String dn = dni.getText().toString();

                Exponen ex = new Exponen(id, dn);

                bd.insertarExponen(ex);
                bd.close();
            }
        });

        super.onActivityCreated(savedInstanceState);
    }

}