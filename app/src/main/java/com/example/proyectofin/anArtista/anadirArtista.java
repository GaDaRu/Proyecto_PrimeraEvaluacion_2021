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
import com.example.proyectofin.modelo.Artista;

import java.text.SimpleDateFormat;
import java.util.Date;

public class anadirArtista extends Fragment {

    private Button boton;
    private Context context;
    private BDExposiciones bd;
    private TextView dni;
    private TextView Nombre;
    private TextView Direccion;
    private TextView Poblacion;
    private TextView Provincia;
    private TextView Pais;
    private TextView MT;
    private TextView MP;
    private TextView TF;
    private TextView Email;
    private TextView Web;
    private TextView fecha;
    private SimpleDateFormat form = new SimpleDateFormat("yyyy/MM/dd");

    public static anadirArtista newInstance() {
        return new anadirArtista();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View vista = inflater.inflate(R.layout.anadir_artista_fragment, container, false);
        boton = vista.findViewById(R.id.button);

        dni = vista.findViewById(R.id.DNIArti);
        Nombre = vista.findViewById(R.id.NomArti);
        Direccion = vista.findViewById(R.id.DireArti);
        Poblacion = vista.findViewById(R.id.PoArti);
        Provincia = vista.findViewById(R.id.ProArti);
        Pais = vista.findViewById(R.id.PaArti);
        MT = vista.findViewById(R.id.MTArti);
        MP = vista.findViewById(R.id.MPArti);
        TF = vista.findViewById(R.id.TFArti);
        Email = vista.findViewById(R.id.EmaArti);
        Web = vista.findViewById(R.id.WebArti);
        fecha = vista.findViewById(R.id.fecArti);

        context = getContext();
        bd = new BDExposiciones(context);

        return vista;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        boton.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 String dni1 = dni.getText().toString();
                 String nombre1 = Nombre.getText().toString();
                 String Di = Direccion.getText().toString();
                 String Po = Poblacion.getText().toString();
                 String Pro = Provincia.getText().toString();
                 String Pa = Pais.getText().toString();
                 int tt = Integer.parseInt(MT.getText().toString());
                 int tp = Integer.parseInt(MP.getText().toString());
                 int tf = Integer.parseInt(TF.getText().toString());
                 String Em = Email.getText().toString();
                 String We = Web.getText().toString();
                 Date fe = null;
                 try {
                    fe = form.parse(fecha.getText().toString());
                 }catch (Exception e){
                     System.out.println(e);
                 }

                 Artista arti = new Artista(dni1, nombre1, Di, Po,Pro, Pa, Em, We, tt, tp, tf, fe);
                 bd.insertarArtista(arti);
                 System.out.println("Insertado OK");
                 bd.close();
             }
         }
        );
        super.onActivityCreated(savedInstanceState);
    }

}