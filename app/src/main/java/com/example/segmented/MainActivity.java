package com.example.segmented;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.segmented.ui.main.SectionsPagerAdapter;

public class MainActivity extends AppCompatActivity {
    View creadorReloj;

    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        /*
        TODO:
            //NO TOCAR FUNCIONAMIENTO Y CREACION DE CREADOR RELOJ. FUNCIONA. (como max intentar pasarlo a un nuevo objeto)
            1- boton volver hace que la view de creador reloj desaparezca
            2- incluir botón de atrás en Item 3 que lleve al item anterior (almacenar en un int?)
            3- Item 3 visible SOLO on action del listener del boton fab


        NOTAS:

            1- reloj principal actual
            2- relojes creados
            3- creador de relojes


        viewPager es la IU capa superior que maneja el setting
        sectionsPagerAdapter es el tool que realmente maneja el cambio entre items
        sectionsPagerAdapter.getCount return numero secciones
        PageViewModel donde manejar las secciones

        METODOS:
            viewPager.setCurrentItem
            viewPager.getCurrentItem
            viewPager.addOnPageChangeListener             añadir listener que se activara cuando cambie el item: recomendado con su remove
            viewPager.removeOnPageChangeListener          para borrar el listener
            viewPager.setPageTransformer                  para transformar cada pagina indifivudalmetnet


            sectionsPagerAdapter.getItem        obtener item actual
            */


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
        //(ViewPager) findViewById(R.id.fieldspager);

        FloatingActionButton boton_anadir = findViewById(R.id.anadir);
        boton_anadir.hide();

        //  BOTON NUEVO RELOJ, ITEM 1
        boton_anadir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*
                //change tab to creador_reloj
                Snackbar.make(view, "Añadir nuevo reloj", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                viewPager.setCurrentItem(3,true);
                //SectionsPagerAdapter.getItem(viewPager.getCurrentItem());
                //MediatorLiveData<>.setValue(2);
                */

                creadorReloj = crearVistaReloj(viewPager);
                viewPager.addView(creadorReloj, 4, R.layout.creador);

                //anadir_volver.show();
                //vistaReloj.setVisibility(0x00000000);
                /*
                0x00000000      View.VISIBLE
                0x00000004      invisible
                 */
            }
        });


        //ViewPager.SimpleOnPageChangeListener pageChanger;
        //pageChanger = viewPager.SimpleOnPageChangeListener;
        //idk why tf he hecho eso, no se ni si funciona, el listener de abajo si


        viewPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener(){
            @Override
            public void onPageSelected(int position) {
                //NOTA: POSITION DEL ARRAY, NO ITEM. ITEM 1 = POSITION 0
                if(position==1){
                    boton_anadir.show();
                    //if(viewPager.getCurrentItem()==2) fab.show();
                } else{
                    boton_anadir.hide();
                }
            }
        });



    }

    public View crearVistaReloj(ViewPager vipag){
        View nuevoReloj= new View(this);
        super.onCreateView(nuevoReloj, "Creador", this, null);
        setContentView(R.layout.creador);

        FloatingActionButton anadir_volver = findViewById(R.id.volver);
        //anadir_volver.hide();

        // BOTON VOLVER DESDE CREAR RELOJ, VIEW NUEVORELOJ
        anadir_volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //view.setVisibility(0x00000004);
                //anadir_volver.hide();
                //vistaReloj.setVisibility(0x00000000);
                /*
                0x00000000      View.VISIBLE
                0x00000004      invisible
                 */

                //PRUEBA
                Snackbar.make(view, "Volver", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                creadorReloj.setVisibility(View.GONE);
                vipag.setCurrentItem(1,true);
                //creadorReloj=null;
                //(ViewPager) creadorReloj.getParent()).removeView(creadorReloj);
                //vipag.removeView(creadorReloj);

            }
        });

        return nuevoReloj;
    }
}