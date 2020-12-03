package com.example.proyectofin.ui.principal;

import androidx.lifecycle.ViewModelProviders;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.proyectofin.R;
import com.example.proyectofin.adaptador.AdaptadorTraComentarios;
import com.example.proyectofin.adaptador.AdaptadorTrabajos;
import com.example.proyectofin.controlador.BDExposiciones;
import com.example.proyectofin.modelo.Artista;
import com.example.proyectofin.modelo.Comentarios;
import com.example.proyectofin.modelo.Trabajos;

import java.util.ArrayList;

public class VistaTrabajo extends Fragment {

    private View root;

    private ArrayList<Artista> artistas;

    private ArrayList<Trabajos> trabajos;

    private ArrayList<Comentarios> comen;

    private RecyclerView rv;

    private AdaptadorTraComentarios adaptador;

    private BDExposiciones db;

    private RecyclerView.LayoutManager rl;

    private TextView tx;

    private SharedPreferences sp;

    private SharedPreferences.Editor spe;

    public static VistaTrabajo newInstance() {
        return new VistaTrabajo();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.vista_trabajo_fragment, container, false);

        rv = (RecyclerView)root.findViewById(R.id.comentariosTrabajo);
        db = new BDExposiciones(getContext());
        tx = (TextView)root.findViewById(R.id.textViewTituloTrabajo);
        sp = PreferenceManager.getDefaultSharedPreferences(getContext());
        spe = sp.edit();

        Context conte = getContext();

        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        comen = new ArrayList<Comentarios>();
        String[] arti = new String[1];
        arti[0] = sp.getString("trabajo", "");

        Trabajos tr = db.buscarTrabajo(arti);

        String[] ex = new String[1];
        ex[0] = tr.getNombreTra();

        //trabajos = db.buscarTrabajosArti(ex);

        comen = db.buscarComentarios(ex);
        //System.out.println(db.buscarComentarios(ex).size());
        tx.setText(tr.getNombreTra());

        rl = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        rv.setLayoutManager(rl);
        adaptador = new AdaptadorTraComentarios(getContext(), db.buscarComentarios(ex));
        rv.setAdapter(adaptador);

        adaptador.setOnItemClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Navigation.findNavController(root).navigate(R.id.verArti);
//                spe.putString("trabajo", trabajos.get(rv.getChildAdapterPosition(v)).getNombreTra());
//                spe.commit();
            }
        });

    }

}