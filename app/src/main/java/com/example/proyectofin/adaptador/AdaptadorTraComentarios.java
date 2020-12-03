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
import com.example.proyectofin.modelo.Comentarios;
import com.example.proyectofin.modelo.Trabajos;

import java.util.ArrayList;

public class AdaptadorTraComentarios extends RecyclerView.Adapter<AdaptadorTraComentarios.HolderComen> {
    public class HolderComen extends RecyclerView.ViewHolder
    {
        TextView arti;

        HolderComen(View itemView)
        {
         /* En el constructor obtendremos los recursos del fichero
         de recursos xml que tengamos asociado a la clase, en
         este caso el fichero listitem_titular.xml
         */
            super(itemView);
            arti = itemView.findViewById(R.id.textViewComentario);
            //mostrarArti = itemView.findViewById(R.id.button2);

        }

        public void removeItem(int position)
        {
            listaTra.remove(position);
            //notifyItemRemoved(position);
        }
    };



    private Context contexto;
    protected View.OnClickListener onClickListener;
    private ArrayList<Comentarios> listaTra;

    public AdaptadorTraComentarios(Context contexto, ArrayList<Comentarios> arrayentrante)
    {
        this.contexto = contexto;
        this.listaTra = arrayentrante;
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
    public AdaptadorTraComentarios.HolderComen onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.comentarios, parent, false);
        v.setOnClickListener(onClickListener);
        AdaptadorTraComentarios.HolderComen pvh = new AdaptadorTraComentarios.HolderComen(v);
        return pvh;
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onBindViewHolder(final AdaptadorTraComentarios.HolderComen itemAc, final int position)
    {
        //System.out.println(listaTra.get(position).getNombreTra());
        itemAc.arti.setText(listaTra.get(position).getComentario());
    }

    @Override
    public int getItemCount()
    {
        return listaTra.size();
    }
    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView)
    {
        //super.onAttachedToRecyclerView(recyclerView);
    }
}
