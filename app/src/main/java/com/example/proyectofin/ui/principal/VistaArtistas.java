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
import android.widget.Button;
import android.widget.TextView;

import com.example.proyectofin.R;
import com.example.proyectofin.adaptador.AdaptadorArtistas;
import com.example.proyectofin.adaptador.AdaptadorExposiciones;
import com.example.proyectofin.controlador.BDExposiciones;
import com.example.proyectofin.modelo.Artista;
import com.example.proyectofin.modelo.Exponen;
import com.example.proyectofin.modelo.Exposicion;

import java.util.ArrayList;

public class VistaArtistas extends Fragment {

    public static VistaArtistas newInstance() {
        return new VistaArtistas();
    }

    //private Button alta;

    private View root;

    private ArrayList<Artista> artistas;

    private ArrayList<Exponen> exponen;

    private RecyclerView rv;

    private AdaptadorArtistas adaptador;

    private BDExposiciones db;

    private RecyclerView.LayoutManager rl;

    private TextView tx;

    private SharedPreferences sp;

    private SharedPreferences.Editor spe;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.vista_artistas_fragment, container, false);

        rv = (RecyclerView)root.findViewById(R.id.reciclerAristas);
        db = new BDExposiciones(getContext());
        //tx = (TextView)root.findViewById(R.id.textView3);
        sp = PreferenceManager.getDefaultSharedPreferences(getContext());
        spe = sp.edit();
        artistas = new ArrayList<Artista>();
        exponen = new ArrayList<Exponen>();
        String[] arti = new String[1];
        arti[0] = sp.getString("key", "");
        exponen = db.buscarExponen(arti);
        for(int i = 0; i<exponen.size(); i++){
            String[] ex = new String[1];
            ex[0] = exponen.get(i).getDni();
            artistas.add(db.buscarArtistas(ex));
        }


        Context conte = getContext();
        BDExposiciones bd = new BDExposiciones(conte);

        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        rl = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        rv.setLayoutManager(rl);
        adaptador = new AdaptadorArtistas(getContext(), artistas);
        rv.setAdapter(adaptador);

        adaptador.setOnItemClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(root).navigate(R.id.verArti);
                spe.putString("artiKey", artistas.get(rv.getChildAdapterPosition(v)).getDni());//exposiciones.get(rv.getChildAdapterPosition(v)).getIdExposicion());
                spe.commit();
            }
        });
    }


}