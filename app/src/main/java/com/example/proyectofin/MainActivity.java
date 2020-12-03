package com.example.proyectofin;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private AppBarConfiguration mAppBarConfiguration;

    private Button aArtistas;
    private Button aExposiciones;
    private Button aTrabajos;
    private Button aComentarios;
    private Button aExponen;
    NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.principal)
                .setDrawerLayout(drawer)
                .build();
        navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        Toolbar tolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(tolbar);

        aArtistas = findViewById(R.id.anadirArtista);
        aExposiciones = findViewById(R.id.anadirExposicion);
        aTrabajos = findViewById(R.id.anadirTrabajos);
        aComentarios = findViewById(R.id.anadirComentarios);
        aExponen = findViewById(R.id.anadirExponen);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.anadirArtista:
                System.out.println("Hola");
                navController.navigate(R.id.action_principal_to_anadirArti);
                break;
            case R.id.anadirExposicion:
                navController.navigate(R.id.action_principal_to_anadirExposiciones);
                break;
            case R.id.anadirTrabajos:
                navController.navigate(R.id.action_principal_to_anadirTrabajo);
                break;
            case R.id.anadirComentarios:
                navController.navigate(R.id.action_principal_to_anadirComentario);
                break;
            case R.id.anadirExponen:
                navController.navigate(R.id.action_principal_to_anadirExposicion);
                break;
            default:
                return super.onOptionsItemSelected(item);
        }

        return true;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        System.out.println(id);
        switch (id){
            case R.id.anadirArtista:
                System.out.println("Hola");
                navController.navigate(R.id.action_principal_to_anadirArti);
                break;
            case R.id.anadirExposicion:
                navController.navigate(R.id.action_principal_to_anadirExposiciones);
                break;
            case R.id.anadirTrabajos:
                navController.navigate(R.id.action_principal_to_anadirTrabajo);
                break;
            case R.id.anadirComentarios:
                navController.navigate(R.id.action_principal_to_anadirComentario);
                break;
            case R.id.anadirExponen:
                navController.navigate(R.id.action_principal_to_anadirExposicion);
                break;
            default:
                return super.onOptionsItemSelected(item);
        }

        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }


}