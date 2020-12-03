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
import com.example.proyectofin.modelo.Exposicion;

import java.text.SimpleDateFormat;
import java.util.Date;

public class anadirExposiciones extends Fragment {

    private Button boton;
    private Context context;
    private BDExposiciones bd;
    private TextView idEx;
    private TextView Nombre;
    private TextView Descripcion;
    private TextView Fechai;
    private TextView FechaF;
    private SimpleDateFormat form = new SimpleDateFormat("yyyy/MM/dd");

    public static anadirExposiciones newInstance() {
        return new anadirExposiciones();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.anadir_exposiciones_fragment, container, false);

        boton = vista.findViewById(R.id.button2);
        idEx = vista.findViewById(R.id.idExpo);
        Nombre = vista.findViewById(R.id.nombreExpo);
        Descripcion = vista.findViewById(R.id.DescriExpo);
        Fechai = vista.findViewById(R.id.fechaIExpo);
        FechaF = vista.findViewById(R.id.fechaFExpo);

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
                String nom = Nombre.getText().toString();
                String desc = Descripcion.getText().toString();
                Date fei = null;
                Date fef = null;
                try{
                    fei = form.parse(Fechai.getText().toString());
                    fef = form.parse(FechaF.getText().toString());
                }catch (Exception e){
                    System.out.println(e);
                }

                Exposicion ex = new Exposicion(id, nom, desc, fei, fef);
                bd.insertarExposicion(ex);
                bd.close();
            }
        });
        super.onActivityCreated(savedInstanceState);
    }

}