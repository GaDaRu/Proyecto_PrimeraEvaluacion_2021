package com.example.proyectofin.ui.principal;

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
import com.example.proyectofin.adaptador.AdaptadorExposiciones;
import com.example.proyectofin.controlador.BDExposiciones;
import com.example.proyectofin.modelo.Artista;
import com.example.proyectofin.modelo.Comentarios;
import com.example.proyectofin.modelo.Exponen;
import com.example.proyectofin.modelo.Exposicion;
import com.example.proyectofin.modelo.Trabajos;

import java.util.ArrayList;
import java.util.Date;

public class BlankFragment1 extends Fragment {

    public static BlankFragment1 newInstance() {
        return new BlankFragment1();
    }

    private Button alta;

    private View root;

    private ArrayList<Exposicion> exposiciones;

    private RecyclerView rv;

    private AdaptadorExposiciones adaptador;

    private BDExposiciones db;

    private RecyclerView.LayoutManager rl;

    private TextView tx;

    private SharedPreferences sp;

    private SharedPreferences.Editor spe;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        root = inflater.inflate(R.layout.blank_fragment1_fragment, container, false);

        exposiciones = new ArrayList<Exposicion>();
        rv = (RecyclerView)root.findViewById(R.id.recyclerView);
        db = new BDExposiciones(getContext());
        tx = (TextView)root.findViewById(R.id.textView3);
        sp = PreferenceManager.getDefaultSharedPreferences(getContext());
        spe = sp.edit();

        //alta = root.findViewById(R.id.buttonAltaArtista);

        Context conte = getContext();
        BDExposiciones bd = new BDExposiciones(conte);


        bd.getWritableDatabase();
        //if(bd != null){
//            //Exposicion ex = new Exposicion("0", "David", "Hola mundo", new Date(), new Date());
//            Exposicion ex2 = new Exposicion("1", "ExpoAlmeria", "Exposicion en Almeria", new Date(), new Date());
//            Exposicion ex = new Exposicion("2", "ExpoGranada", "Exposicion en Granada", new Date(), new Date());
//            Artista arti = new Artista("C01", "Juan", "cc", "cc", "cd", "j", "Hola@gmail.com", "www", 666, 555, 444, new Date());
//            Artista arti2 = new Artista("C02", "David", "cc", "cc", "cd", "j", "Hola@gmail.com", "www", 666, 555, 444, new Date());
//            Artista arti3 = new Artista("C03", "Ana", "cc", "cc", "cd", "j", "Hola@gmail.com", "www", 666, 555, 444, new Date());
//
//            Exponen exp = new Exponen("1", "C01");
//            Exponen exp2 = new Exponen("2", "C02");
//            Exponen exp3 = new Exponen("2", "C03");
//
//            Trabajos tr = new Trabajos("Noche", "Noche oscura", "C02", "Hola", 300, 20);
//            Trabajos tr2 = new Trabajos("Noche2", "Noche oscura2", "C02", "Hola", 300, 20);
//            Trabajos tr3 = new Trabajos("Dia", "Dia oscura", "C03", "Hola", 300, 20);
//
//            Comentarios co = new Comentarios("2", "Noche", "Esta guay");
//            Comentarios c2 = new Comentarios("2", "Noche", "Esta guay, si");
//            Comentarios c3 = new Comentarios("2", "Noche2", "Es una caca");
           // Comentarios c4 = new Comentarios("2", "Dia oscura", "Jejejeje");
//
//            bd.insertarExposicion(ex2);
//            bd.insertarExposicion(ex);
//            bd.insertarArtista(arti);
//            bd.insertarArtista(arti2);
//            bd.insertarArtista(arti3);
//            bd.insertarExponen(exp);
//            bd.insertarExponen(exp2);
//            bd.insertarExponen(exp3);
//            bd.insertarTrabajos(tr);
//            bd.insertarTrabajos(tr2);
//            bd.insertarTrabajos(tr3);
//            bd.insertarComentarios(co);
//            bd.insertarComentarios(c2);
//            bd.insertarComentarios(c3);
            //bd.insertarComentarios(c4);

           //bd.cerrarBD();
        //}


        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        exposiciones = db.consultarExposiciones();
        rl = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        rv.setLayoutManager(rl);
        adaptador = new AdaptadorExposiciones(getContext(), db.consultarExposiciones());
        rv.setAdapter(adaptador);

        adaptador.setOnItemClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(root).navigate(R.id.mostrarArti);
                spe.putString("key", exposiciones.get(rv.getChildAdapterPosition(v)).getIdExposicion());
                spe.commit();
            }
        });
    }
}