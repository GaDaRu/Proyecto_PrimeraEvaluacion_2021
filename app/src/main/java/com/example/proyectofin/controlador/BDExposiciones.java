package com.example.proyectofin.controlador;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.proyectofin.modelo.Artista;
import com.example.proyectofin.modelo.Comentarios;
import com.example.proyectofin.modelo.Exponen;
import com.example.proyectofin.modelo.Exposicion;
import com.example.proyectofin.modelo.Trabajos;

import java.util.ArrayList;
import java.util.Date;


public class BDExposiciones extends SQLiteOpenHelper
{
    private Context contexto;

    private final String SQLCREATEExposicion = "CREATE TABLE IF NOT EXISTS Exposiciones (idExposicion INTEGER primary key, Nombre TEXT, Descripcion TEXT, FechaIni Date, FechaFin Date)";

    private final String SQLCreateExponen = "CREATE TABLE IF NOT EXISTS Exponen(idEsposicion INTEGER, DniPasaporte TEXT, foreign key(idEsposicion) references Exposiciones(idExposicion), foreign key (DniPasaporte) references Artistas(dniPasaporte), primary key(idEsposicion,DniPasaporte)) ";
    private final String SQLDrop = "DROP TABLE IF EXISTS Exposiciones";

    private final String SQLCreateArtistas = "CREATE TABLE IF NOT EXISTS Artistas(dniPasaporte TEXT, Nombre TEXT, Direccion TEXT, Poblacion TEXT, Provincia TEXT, Pais TEXT, MovilTrabajo INTEGER, MovilPersonal INTEGER, TelFijo INTEGER, Email TEXT, WebBlog TEXT, FechaNacimiento DATE, primary key(dniPasaporte))";

    private final String SQLCreateTrabajos = "CREATE TABLE IF NOT EXISTS Trabajos(NombreTrab TEXT, Descripcion TEXT, Tamano INTEGER, Peso INTEGER, DniPasaporte TEXT, Foto TEXT, primary key(NombreTrab), foreign key(DniPasaporte) references Artistas(dniPasaporte))";

    private final String SQLCreateComentarios = "CREATE TABLE IF NOT EXISTS Comentarios(IdExpo INTEGER, NombreTra TEXT, Comentario TEXT, foreign key(IdExpo) references Exposiciones(idExposicion), foreign key(NombreTra) references Trabajos(NombreTrab), primary key(IdExpo,NombreTra)) ";

    // Base de datos
    private SQLiteDatabase bd = null;
    public static final int DATABASE_VERSION = 5;
    public static final String DATABASE_NAME = "Exposicioes.db";

    public BDExposiciones(Context contexto)
    {
        super(contexto, DATABASE_NAME, null, DATABASE_VERSION);

        this.contexto = contexto;
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(SQLCREATEExposicion);
        db.execSQL(SQLCreateExponen);
        db.execSQL(SQLCreateArtistas);
        db.execSQL(SQLCreateTrabajos);
        db.execSQL(SQLCreateComentarios);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int versionAnterior, int versionNueva)
    {
        db.execSQL(SQLDrop);

        db.execSQL(SQLCREATEExposicion);
    }

    public void cerrarBD()
    {
        if( bd != null ) {
            bd.close();
        }
    }

    public void insertarTrabajos(Trabajos tr)
    {
        bd = getWritableDatabase();

        if(bd != null)
        {
            long newRowId;

            String nombre = tr.getNombreTra();
            String descrip = tr.getDescripcion();
            int tamano = tr.getTamano();
            int peso = tr.getPeso();
            String dni = tr.getDni();
            String foto = tr.getFoto();

            try {
                ContentValues valor = new ContentValues();

                valor.put("NombreTrab", nombre);
                valor.put("Descripcion", descrip); 
                valor.put("Tamano", tamano);
                valor.put("Peso", peso);
                valor.put("DniPasaporte", dni);
                valor.put("Foto", foto);

                newRowId = bd.insert("Trabajos", "", valor);
            }catch (Exception e){
                newRowId = -1;
                System.out.println(e);
            }
        }
    }

    public void insertarComentarios(Comentarios co)
    {
        bd = getWritableDatabase();

        if(bd != null)
        {
            long newRowId;

            String id = co.getIdExposicion();
            String nombre = co.getNombreTra();
            String comentario = co.getComentario();

            try {
                ContentValues valor = new ContentValues();

                valor.put("IdExpo", id);
                valor.put("NombreTra", nombre);
                valor.put("Comentario", comentario);

                newRowId = bd.insert("Comentarios", "", valor);
                co.setIdExposicion(""+newRowId);
            }catch (Exception e){
                newRowId = -1;
                System.out.println(e);
            }
        }
    }

    public void insertarExposicion(Exposicion ex)
    {
        bd = getWritableDatabase();

        if(bd != null)
        {
            long newRowId;

            String id = ex.getIdExposicion();
            String nombre = ex.getNombre();
            String des = ex.getDescripcion();
            Date feci = ex.getFechaIni();
            Date fecF = ex.getFechaFin();

            try {
                ContentValues valor = new ContentValues();

                valor.put("Nombre", nombre);
                valor.put("Descripcion", des);
                valor.put("FechaIni", ""+feci);
                valor.put("FechaFin", ""+fecF);

                newRowId = bd.insert("Exposiciones", "", valor);
                ex.setIdExposicion(""+newRowId);
            }catch (Exception e){
                newRowId = -1;
                System.out.println(e);
            }
        }
    }

    public void insertarExponen(Exponen ex)
    {
        bd = getWritableDatabase();

        if(bd != null)
        {
            long newRowId;

            String id = ex.getIdExposicion();
            String nombre = ex.getDni();

            try {
                ContentValues valor = new ContentValues();

                valor.put("idEsposicion", id);
                valor.put("DniPasaporte", nombre);

                newRowId = bd.insert("Exponen", "", valor);
                ex.setIdExposicion(""+newRowId);
            }catch (Exception e){
                newRowId = -1;
                System.out.println(e);
            }
        }
    }

    public long insertarArtista(Artista arti)
    {
        bd = getWritableDatabase();
        long newRowId = 1;

        if(bd != null)
        {
            String pasaporte = arti.getDni();
            String nombre = arti.getNombre();
            String direccion = arti.getDireccion();
            String pobla = arti.getPoblacion();
            String Provin = arti.getProvincia();
            String pais = arti.getPais();
            int movil = arti.getMovilPersonal();
            int trabajo = arti.getMovilTrabajo();
            int fijo = arti.getTelefono();
            String email = arti.getEmail();
            String web = arti.getWebBlog();
            Date fec = arti.getFechaN();

            try {
                ContentValues valor = new ContentValues();

                valor.put("dniPasaporte", pasaporte);
                valor.put("Nombre", nombre);
                valor.put("Direccion", direccion);
                valor.put("Poblacion", pobla);
                valor.put("Provincia", Provin);
                valor.put("Pais", ""+pais);
                valor.put("MovilPersonal", ""+movil);
                valor.put("MovilTrabajo", ""+trabajo);
                valor.put("TelFijo", ""+fijo);
                valor.put("Email", ""+email);
                valor.put("WebBlog", ""+web);
                valor.put("FechaNacimiento", ""+fec);

                newRowId = bd.insert("Artistas", "", valor);

            }catch (Exception e){
                newRowId = -1;
                System.out.println(e);
            }
        }
        return newRowId;
    }

    public void actualizarNombre(String nombreantiguo, int codigo, String nombrenuevo)
    {
        bd = getWritableDatabase();

        if(bd != null)
        {
            ContentValues values = new ContentValues();
            values.put("codigo", codigo);
            values.put("nombre", nombrenuevo);
            String selection = "nombre = ?";
            String[] updateArgs = { nombreantiguo };

            bd.update("Usuarios", values, selection, updateArgs);
        }
    }

    public ArrayList<Exposicion> consultarExposiciones()
    {
        ArrayList<Exposicion> le = new ArrayList<Exposicion>();
        bd = getReadableDatabase();

        if(bd != null)
        {

            Cursor c = bd.query
                    (
                            "Exposiciones",
                            null,
                            null,
                            null,
                            null,
                            null,
                            null
                    );

            c.moveToFirst();
            if( c.getCount() > 0 )
            {
                do
                {
                    Exposicion expo = new Exposicion(c.getString(0), c.getString(1), c.getString(2), new Date(c.getString(3)), new Date(c.getString(4)));
                    le.add(expo);
                } while (c.moveToNext());
            }
        }
        return le;
    }

    public Artista buscarArtistas(String[] artis){
        ArrayList<Artista> la = new ArrayList<Artista>();

        bd = getReadableDatabase();

        Artista arti = null;
        if(bd != null)
        {

            Cursor c = bd.query
                    (
                            "Artistas",
                            null,
                            "dniPasaporte=?",
                            artis,
                            null,
                            null,
                            null
                    );

            c.moveToFirst();
            if( c.getCount() > 0 )
            {
                do
                {
                    arti = new Artista(c.getString(0), c.getString(1), c.getString(2), c.getString(3), c.getString(4), c.getString(5), c.getString(9), c.getString(10), c.getInt(6), c.getInt(7), c.getInt(8), new Date(c.getString(11)));
                    la.add(arti);
                } while (c.moveToNext());
            }

        }
        return arti;
    }

    public ArrayList<Trabajos> buscarTrabajosArti(String[] arti){
        ArrayList<Trabajos> tra = new ArrayList<>();

        bd = getReadableDatabase();

        Trabajos trabajos = null;
        if(bd != null)
        {
            Cursor c = bd.query
                    (
                            "Trabajos",
                            null,
                            "DniPasaporte=?",
                            arti,
                            null,
                            null,
                            null
                    );

            c.moveToFirst();
            //System.out.println(c.getCount());
            if( c.getCount() > 0 )
            {

                do
                {
                    trabajos = new Trabajos(c.getString(0), c.getString(1), c.getString(4), c.getString(5), c.getInt(2), c.getInt(3));
                    tra.add(trabajos);
                } while (c.moveToNext());
            }

        }
        return tra;
    }

    public Trabajos buscarTrabajo(String[] arti){

        bd = getReadableDatabase();

        Trabajos trabajos = null;
        if(bd != null)
        {
            System.out.println("Hola BD");
            Cursor c = bd.query
                    (
                            "Trabajos",
                            null,
                            "NombreTrab=?",
                            arti,
                            null,
                            null,
                            null
                    );

            c.moveToFirst();
            //System.out.println(c.getCount());
            if( c.getCount() > 0 )
            {

                do
                {
                    trabajos = new Trabajos(c.getString(0), c.getString(1), c.getString(4), c.getString(5), c.getInt(2), c.getInt(3));
                } while (c.moveToNext());
            }

        }
        return trabajos;
    }

    public ArrayList<Artista> consultarArtistas(){
        ArrayList<Artista> la = new ArrayList<Artista>();

        bd = getReadableDatabase();

        Artista arti = null;
        if(bd != null)
        {

            Cursor c = bd.query
                    (
                            "Artistas",
                            null,
                            null,
                            null,
                            null,
                            null,
                            null
                    );

            c.moveToFirst();
            if( c.getCount() > 0 )
            {
                do
                {
                    arti = new Artista(c.getString(0), c.getString(1), c.getString(2), c.getString(3), c.getString(4), c.getString(5), c.getString(9), c.getString(10), c.getInt(6), c.getInt(7), c.getInt(8), new Date(c.getString(11)));
                    la.add(arti);
                } while (c.moveToNext());
            }

        }
        return la;
    }

    public ArrayList<Exponen> buscarExponen(String[] expo){
        ArrayList<Exponen> le = new ArrayList<Exponen>();

        bd = getReadableDatabase();

        if(bd != null)
        {

            Cursor c = bd.query
                    (
                            "Exponen",
                            null,
                            "idEsposicion=?",
                            expo,
                            null,
                            null,
                            null
                    );

            c.moveToFirst();
            if( c.getCount() > 0 )
            {
                do
                {
                    Exponen ex = new Exponen(c.getString(0), c.getString(1));
                    le.add(ex);
                } while (c.moveToNext());
            }

        }
        return le;
    }

    public Artista buscarListaArtistas(String[] expo){

        Artista arti = null;

        bd = getReadableDatabase();

        if(bd != null)
        {

            Cursor c = bd.query
                    (
                            "Artistas",
                            null,
                            "dniPasaporte=?",
                            expo,
                            null,
                            null,
                            null
                    );

            c.moveToFirst();
            if( c.getCount() > 0 )
            {

                do
                {
                    arti = new Artista(c.getString(0), c.getString(1), c.getString(2), c.getString(3), c.getString(4), c.getString(5), c.getString(9), c.getString(10), c.getInt(6), c.getInt(7), c.getInt(8), new Date(c.getString(11)));
                } while (c.moveToNext());
            }

        }
        return arti;
    }

    public ArrayList<Comentarios> buscarComentarios(String[] tra){
        ArrayList<Comentarios> lc = new ArrayList<Comentarios>();

        bd = getReadableDatabase();

        if(bd != null)
        {

            Cursor c = bd.query
                    (
                            "Comentarios",
                            null,
                            "NombreTra=?",
                            tra,
                            null,
                            null,
                            null
                    );

            c.moveToFirst();
            if( c.getCount() > 0 )
            {
                do
                {
                    Comentarios co = new Comentarios(c.getString(0), c.getString(1), c.getString(2));
                    lc.add(co);
                } while (c.moveToNext());
            }

        }
        return lc;
    }

    public ArrayList<Trabajos> buscarTrabajos(String[] tra){
        ArrayList<Trabajos> lt = new ArrayList<Trabajos>();
        Trabajos tr = null;
        bd = getReadableDatabase();

        if(bd != null)
        {

            Cursor c = bd.query
                    (
                            "Trabajos",
                            null,
                            "DniPasaporte=?",
                            tra,
                            null,
                            null,
                            null
                    );

            c.moveToFirst();
            if( c.getCount() > 0 )
            {

                do
                {
                    tr = new Trabajos(c.getString(0), c.getString(1), c.getString(4), c.getString(5), c.getInt(2), c.getInt(3));
                    lt.add(tr);
                } while (c.moveToNext());
            }

        }
        return lt;
    }

    public ArrayList<Trabajos> buscarListaTrabajos(){
        ArrayList<Trabajos> lt = new ArrayList<Trabajos>();

        bd = getReadableDatabase();

        if(bd != null)
        {

            Cursor c = bd.query
                    (
                            "Trabajos",
                            null,
                            null,
                            null,
                            null,
                            null,
                            null
                    );

            c.moveToFirst();
            if( c.getCount() > 0 )
            {

                do
                {
                    Trabajos tr = new Trabajos(c.getString(0), c.getString(1), c.getString(4), c.getString(5), c.getInt(2), c.getInt(3));
                    lt.add(tr);
                } while (c.moveToNext());
            }

        }
        return lt;
    }
}