package com.example.proyectofin.adaptador;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyectofin.R;
import com.example.proyectofin.modelo.Artista;
import com.example.proyectofin.modelo.Exposicion;

import java.util.ArrayList;

public class AdaptadorArtistas extends RecyclerView.Adapter<AdaptadorArtistas.HolderArti> {
    public class HolderArti extends RecyclerView.ViewHolder
    {
        TextView arti;
        Button mostrarArti;

        HolderArti(View itemView)
        {
         /* En el constructor obtendremos los recursos del fichero
         de recursos xml que tengamos asociado a la clase, en
         este caso el fichero listitem_titular.xml
         */
            super(itemView);
            arti = itemView.findViewById(R.id.textViewVerArti);
            //mostrarArti = itemView.findViewById(R.id.button2);

        }

        public void removeItem(int position)
        {
            listaArti.remove(position);
            //notifyItemRemoved(position);
        }
    };



    private Context contexto;
    protected View.OnClickListener onClickListener;
    private ArrayList<Artista> listaArti;

    public AdaptadorArtistas(Context contexto, ArrayList<Artista> arrayentrante)
    {
        this.contexto = contexto;
        this.listaArti = arrayentrante;
    }

    /**
     * Cuando clicamos en el hijo de un recview
     * @param onClickListener
     */
    public void setOnItemClickListener(View.OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    /**
     * Agrega los datos que queramos mostrar
     * @param arrayentrante Datos a mostrar, en este caso, titulares
     */
    public void add(ArrayList<String> arrayentrante)
    {
        arrayentrante.clear();
        arrayentrante.addAll(arrayentrante);
    }
    /**
     * Actualiza los datos del ReciclerView
     */
    //public void refrescar()
//    {
//        notifyDataSetChanged();
//    }

    //@Override
    public AdaptadorArtistas.HolderArti onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.verartistas, parent, false);
        v.setOnClickListener(onClickListener);
        AdaptadorArtistas.HolderArti pvh = new AdaptadorArtistas.HolderArti(v);
        return pvh;
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onBindViewHolder(final AdaptadorArtistas.HolderArti itemAc, final int position)
    {
        itemAc.arti.setText(listaArti.get(position).getNombre());
    }

    @Override
    public int getItemCount()
    {
        return listaArti.size();
    }
    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView)
    {
        //super.onAttachedToRecyclerView(recyclerView);
    }
}
