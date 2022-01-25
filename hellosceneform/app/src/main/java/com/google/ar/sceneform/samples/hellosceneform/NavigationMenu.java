package com.google.ar.sceneform.samples.hellosceneform;

/*
This activity is the main activity with the navigation drawer.
 */

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.ar.sceneform.samples.hellosceneform.utilities.Utilities;

public class NavigationMenu extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    FragmentManager fragmentManager;
    SqLiteConectionHelper conn;
    TextView textId;
    TextView textPrice;
    TextView textName;
    TextView textDescription;
    ImageView imageTool;
    public String sID;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        fragmentManager = getSupportFragmentManager();
        textId = (TextView)findViewById(R.id.textViewID);
        textPrice = (TextView)findViewById(R.id.textViewPrice);
        textName = (TextView)findViewById(R.id.textViewName);
        textDescription = (TextView)findViewById(R.id.textViewDescription);
        imageTool = (ImageView)findViewById(R.id.imageViewToolImage);



        toolsRecord();

        conn = new SqLiteConectionHelper(getApplicationContext(), "bd_tools", null, 1);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_menu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        //The next method sets the function of the fab button.

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                fragmentManager.beginTransaction().replace(R.id.contenedor, new FragmentProducts()).commit();
            }
        });

        //Configurations of the navigation drawer.

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        conn = new SqLiteConectionHelper(this, "bd_tools", null, 1);

        fragmentManager.beginTransaction().replace(R.id.contenedor, new FragmentProducts()).commit();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigation_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")

    //Here is confugured the response of the lateral options list.
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        fragmentManager = getSupportFragmentManager();

        if (id == R.id.nav_products) {
            fragmentManager.beginTransaction().replace(R.id.contenedor, new FragmentProducts()).commit();
        } else if (id == R.id.nav_web_store) {
            fragmentManager.beginTransaction().replace(R.id.contenedor, new FragmentWebStore()).commit();
        } else if (id == R.id.nav_us) {
            fragmentManager.beginTransaction().replace(R.id.contenedor, new FragmentUs()).commit();
        } else if (id == R.id.nav_help) {
            fragmentManager.beginTransaction().replace(R.id.contenedor, new FragmentHelp()).commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    //This method begins the AR function.
    public void herramienta1(View v){
        Intent intent = new Intent(NavigationMenu.this, AR_SceneformActivity.class);
        startActivity(intent);
        finish();
    }


    //This method calls the consult of the dremel ID tool & shows the tool details.
    public void buttonDremel(View v){
        consultSQLite("3562");
        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.contenedor, new FragmentTool2()).commit();
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        Utilities.TOOL_MODEL = 1;
    }


    //This method calls the consult of the vertical drill ID tool & shows the tool details.
    public void buttonTaladro(View v){
        consultSQLite("5619");
        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.contenedor, new FragmentTool()).commit();
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        Utilities.TOOL_MODEL = 0;
    }


    //This method sets the tools data into the SQLite file.
    private void toolsRecord() {
        SqLiteConectionHelper conn = new SqLiteConectionHelper(this, "bd_tools", null, 1);
        SQLiteDatabase db = conn.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Utilities.FIELD_ID, "5619");
        values.put(Utilities.FIELD_NAME, "Taladro de columna PBD 40");
        values.put(Utilities.FIELD_PRICE, "388.99");
        values.put(Utilities.FIELD_DESCRIPTION, "El PBD 40 es un taladro de mesa para los aficionados al bricolaje que " +
                "quieren taladrar con la máxima precisión. Gracias al equipamiento técnico resulta especialmente preciso " +
                "y muy sencillo de manejar. Para ello, un motor universal con 710 W de potencia.");

        Long resultId = db.insert(Utilities.TOOL_TABLE, Utilities.FIELD_ID, values);

        values = new ContentValues();
        values.put(Utilities.FIELD_ID, "3562");
        values.put(Utilities.FIELD_NAME, "Dremel 3000");
        values.put(Utilities.FIELD_PRICE, "50.32");
        values.put(Utilities.FIELD_DESCRIPTION, "Con la herramienta rotativa Dremel 3000, tienes en tus manos la herramienta" +
                " perfecta para distintos proyectos. Son 8 diferentes funciones para que puedas trabajar en muchos materiales " +
                "con la practicidad de solo utilizar una herramienta, cambiando accesorios y la velocidad de acuerdo con tu necesidad.");

        resultId = db.insert(Utilities.TOOL_TABLE, Utilities.FIELD_ID, values);

        db.close();
    }


    //This method makes a consult by ID into the SQLite database file.
    public void consultSQLite(String id){
        SQLiteDatabase db = conn.getReadableDatabase();
        String[] param = {id};
        String[] fields = {Utilities.FIELD_ID, Utilities.FIELD_NAME, Utilities.FIELD_PRICE, Utilities.FIELD_DESCRIPTION};

        Cursor cursor = db.query(Utilities.TOOL_TABLE, fields, Utilities.FIELD_ID+"=?", param, null, null, null);
        cursor.moveToFirst();


        Utilities.TOOL_ID = "ID: "+cursor.getString(0);
        Utilities.TOOL_NAME = "Name: "+cursor.getString(1);
        Utilities.TOOL_PRICE = "Price: $"+cursor.getString(2);
        Utilities.TOOL_DESCRIPTION = cursor.getString(3);

        cursor.close();


    }


}
