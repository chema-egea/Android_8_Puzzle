package com.example.chema.puzle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button[] botones;
    private Boolean bad_move=false;
    private static final Integer[] objetivo = new Integer[] {0,1,2,3,4,5,6,7,8};
    private ArrayList<Integer> celdas = new ArrayList<Integer>();
    private TextView textoFeedback;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botones = dameBotones();

        for(int i=0;i<9;i++)
        {
            this.celdas.add(i);
        }

        //Log.i("Numero de celdas", "" + celdas.size());


        //Log.i("Hemos RELLENADO EL GRID", "-----------------------");

        textoFeedback = (TextView) findViewById(R.id.textoFeedback);

        //Log.i("Vamos a dar un listener a cada uno de los botones", "--------------------");

        for (int i = 0; i < 9; i++) {
            if(botones[i] != null) {
                botones[i].setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        hacerMovimeinto((Button) v);
                    }
                });
            }
        }

        //Log.i("LISTENER DADOS", "EXITO");

        //Collections.shuffle(this.celdas); //colocamos las celdas de forma aleatoria
        Random rn = new Random();
        for (int i=0;i<50;i++)
        {
            int random_p = rn.nextInt(8 - 0 + 1) + 0;
            //Log.i("RANDOM ", "" + random_p);
            if(botones[random_p]!=null) {
                hacerMovimeinto(botones[random_p]);
            }
        }

        //Log.i("Hemos ordenado las celdas?", "Si");

        rellenar_grid();




    }

    public void hacerMovimeinto(final Button b)
    {
        if(b.getText().length()!=0) {
            bad_move = true;

            int b_text;
            int b_pos;
            int zuk_pos;

            b_text = Integer.parseInt((String) b.getText());

            b_pos = encontrar_elemento(b_text);

            zuk_pos = encontrar_elemento(9);

            //Log.i("El elemento vacio esta en la posicion",""+(zuk_pos+1));
            //Log.i("El boton pulsado esta en la posicion",""+(b_pos+1));
            //Log.i("El boton pulsado es ",""+b_text);

            switch (zuk_pos)
            {
                case (0):
                {
                    if (b_pos == 1 || b_pos == 3)
                        bad_move = false;
                    break;
                }
                case (1):
                {
                    if (b_pos == 0 || b_pos == 2 || b_pos == 4)
                        bad_move = false;
                    break;
                }
                case (2):
                {
                    if (b_pos == 1 || b_pos == 5)
                        bad_move = false;
                    break;
                }
                case (3):
                {
                    if (b_pos == 0 || b_pos == 4 || b_pos == 6)
                        bad_move = false;
                    break;
                }
                case (4):
                {
                    if (b_pos == 1 || b_pos == 3 || b_pos == 5 || b_pos == 7)
                        bad_move = false;
                    break;
                }
                case (5):
                {
                    if (b_pos == 2 || b_pos == 4 || b_pos == 8)
                        bad_move = false;
                    break;
                }
                case (6):
                {
                    if (b_pos == 3 || b_pos == 7)
                        bad_move = false;
                    break;
                }
                case (7):
                {
                    if (b_pos == 4 || b_pos == 6 || b_pos == 8)
                        bad_move = false;

                    break;
                }
                case (8):
                {
                    if (b_pos == 5 || b_pos == 7)
                        bad_move = false;
                    break;
                }
            }

        if(bad_move==true)
        {
            //textoFeedback.setText("Movimiento no permitido "+b_text);
            return;
        }

            //textoFeedback.setText("Movimiento OK");

            celdas.remove(b_pos);
            celdas.add(b_pos, 8);
            celdas.remove(zuk_pos);
            celdas.add(zuk_pos, b_text - 1);

            rellenar_grid();


            for (int i = 0; i < 9; i++) {
                if (celdas.get(i) != objetivo[i]) {
                    return;
                }
            }
            //textoFeedback.setText("Has Ganado");
        }
    }


    public Button[] dameBotones()
    {
        Button[] b = new Button[9];

        b[0] = (Button) findViewById(R.id.n1);
        b[1] = (Button) findViewById(R.id.n2);
        b[2] = (Button) findViewById(R.id.n3);
        b[3] = (Button) findViewById(R.id.n4);
        b[4] = (Button) findViewById(R.id.n5);
        b[5] = (Button) findViewById(R.id.n6);
        b[6] = (Button) findViewById(R.id.n7);
        b[7] = (Button) findViewById(R.id.n8);
        b[8] = (Button) findViewById(R.id.vacio);
        return b;
    }


    public void rellenar_grid()
    {
        for(int i=0;i<9;i++)
        {
            if(celdas.get(i) !=null) {
                int text = celdas.get(i);

                if (text!=8)
                {
                    Log.i("text vale", "" + (text+1));
                }
                else
                {
                    Log.i("text vale", "vacio");
                }
                //TableLayout.LayoutParams absParams = (TableLayout.LayoutParams) botones[text].getLayoutParams();


                switch (i) {
                    case (0):
                    {
                        if (text==8)
                        {
                            botones[i].setText("");
                        }
                        else {
                            botones[i].setText("" + (text + 1));
                        }
                        break;
                    }
                    case (1):
                    {
                        if (text==8)
                        {
                            botones[i].setText("");
                        }
                        else {
                            botones[i].setText("" + (text + 1));
                        }
                        break;
                    }
                    case (2):
                    {
                        if (text==8)
                        {
                            botones[i].setText("");
                        }
                        else {
                            botones[i].setText("" + (text + 1));
                        }
                        break;
                    }
                    case (3):
                    {
                        if (text==8)
                        {
                            botones[i].setText("");
                        }
                        else {
                            botones[i].setText("" + (text + 1));
                        }
                        break;
                    }
                    case (4):
                    {
                        if (text==8)
                        {
                            botones[i].setText("");
                        }
                        else {
                            botones[i].setText("" + (text + 1));
                        }
                        break;
                    }
                    case (5):
                    {
                        if (text==8)
                        {
                            botones[i].setText("");
                        }
                        else {
                            botones[i].setText("" + (text + 1));
                        }
                        break;
                    }
                    case (6):
                    {
                        if (text==8)
                        {
                            botones[i].setText("");
                        }
                        else {
                            botones[i].setText("" + (text + 1));
                        }
                        break;
                    }
                    case (7):
                    {
                        if (text==8)
                        {
                            botones[i].setText("");
                        }
                        else {
                            botones[i].setText("" + (text + 1));
                        }
                        break;
                    }
                    case (8):
                    {
                        if (text==8)
                        {
                            botones[i].setText("");
                        }
                        else {
                            botones[i].setText("" + (text + 1));
                        }
                        break;
                    }

                }

            }


        }

    }

    public int encontrar_elemento(int elemento)
    {
        //Log.i("RECORREMOS LAS CELDAS, el elemento a buscar es", "" + elemento);
        for (int i = 0; i < 9; i++)
        {
            //Log.i("Recorremos celda, elemento en i es", "" + (celdas.get(i) + 1));
            if (celdas.get(i).intValue() == (elemento-1))
            {
                //Log.i("Devolvemos la celda, que es ", "" + (celdas.get(i) + 1));
                return i;
            }
        }
        return 8;
    }



    public void barajarBotones(View view)
    {
        Random rn = new Random();
        for (int i=0;i<50;i++)
        {
            int random_p = rn.nextInt(8 - 0 + 1) + 0;
            //Log.i("RANDOM ", "" + random_p);
            if(botones[random_p]!=null) {
                hacerMovimeinto(botones[random_p]);
            }
        }
        //Collections.shuffle(this.celdas); //colocamos las celdas de forma aleatoria
        rellenar_grid();
    }








}
