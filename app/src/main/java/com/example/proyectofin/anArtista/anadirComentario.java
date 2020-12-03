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
import com.example.proyectofin.modelo.Comentarios;

public class anadirComentario extends Fragment {

    private Button boton;
    private Context context;
    private BDExposiciones bd;
    private TextView id;
    private TextView nombre;
    private TextView comentario;

    public static anadirComentario newInstance() {
        return new anadirComentario();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.anadir_comentario_fragment, container, false);

        boton = vista.findViewById(R.id.button5);
        id = vista.findViewById(R.id.idComentario);
        nombre = vista.findViewById(R.id.nomComentario);
        comentario = vista.findViewById(R.id.comentario);

        context = getContext();
        bd = new BDExposiciones(context);

        return vista;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        String Expo = id.getText().toString();
        String nom = nombre.getText().toString();
        String come = comentario.getText().toString();

        Comentarios co = new Comentarios(Expo, nom, come);

        bd.insertarComentarios(co);
        bd.close();

        super.onActivityCreated(savedInstanceState);
    }

}