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

        for(int i=0;i<botones.length;i++)
        {
            this.celdas.add(i);
        }

        Log.i("Numero de celdas", ""+celdas.size());

        Collections.shuffle(this.celdas); //colocamos las celdas de forma aleatoria

        Log.i("Hemos ordenado las celdas?", "Si");

        rellenar_grid();

        Log.i("Hemos RELLENADO EL GRID", "-----------------------");

        textoFeedback = (TextView) findViewById(R.id.textoFeedback);

        Log.i("Vamos a dar un listener a cada uno de los botones", "--------------------");

        for (int i = 1; i < 9; i++) {
            if(botones[i] != null) {
                botones[i].setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        hacerMovimeinto((Button) v);
                    }
                });
            }
        }

        Log.i("LISTENER DADOS", "EXITO");

    }

    public void hacerMovimeinto(final Button b)
    {
        bad_move=true;

        int b_text;
        int b_pos;
        int zuk_pos;

        b_text=Integer.parseInt((String) b.getText());

        b_pos=encontrar_posicion(b_text);

        zuk_pos=encontrar_posicion(0);

        switch(zuk_pos)
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
            {   if(b_pos==5||b_pos==7)
                    bad_move=false;
                break;
            }
        }

        /*if(bad_move==true)
        {
            feedbackText.setText("Move Not Allowed");
            return;
        }*/

        //feedbackText.setText("Move OK");

        celdas.remove(b_pos);
        celdas.add(b_pos, 0);
        celdas.remove(zuk_pos);
        celdas.add(zuk_pos, b_text);


        rellenar_grid();


        for(int i=0;i<9;i++)
        {
            if(celdas.get(i)!=objetivo[i])
            {
                return;
            }
        }
        textoFeedback.setText("Has Ganado");
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

                Log.i("text vale", "" + text);

                //TableLayout.LayoutParams absParams = (TableLayout.LayoutParams) botones[text].getLayoutParams();


                switch (i) {
                    case (0): {
                        //absParams.x = 5;
                        //absParams.y = 5;
                        //botones[text].setLayoutParams(absParams);
                        if (text==8)
                        {
                            botones[i].setText("");
                        }
                        else {
                            botones[i].setText("" + (text + 1));
                        }
                        break;
                    }
                    case (1): {
                        //absParams.x = 110;
                        //absParams.y = 5;
                        //botones[text].setLayoutParams(absParams);
                        if (text==8)
                        {
                            botones[i].setText("");
                        }
                        else {
                            botones[i].setText("" + (text + 1));
                        }
                        break;
                    }
                    case (2): {
                        //absParams.x = 215;
                        //absParams.y = 5;
                        //botones[text].setLayoutParams(absParams);
                        if (text==8)
                        {
                            botones[i].setText("");
                        }
                        else {
                            botones[i].setText("" + (text + 1));
                        }
                        break;
                    }
                    case (3): {
                        //absParams.x = 5;
                        //absParams.y = 110;
                        //botones[text].setLayoutParams(absParams);
                        if (text==8)
                        {
                            botones[i].setText("");
                        }
                        else {
                            botones[i].setText("" + (text + 1));
                        }
                        break;
                    }
                    case (4): {
                        //absParams.x = 110;
                        //absParams.y = 110;
                        //botones[text].setLayoutParams(absParams);
                        if (text==8)
                        {
                            botones[i].setText("");
                        }
                        else {
                            botones[i].setText("" + (text + 1));
                        }
                        break;
                    }
                    case (5): {
                        //absParams.x = 215;
                        //absParams.y = 110;
                        //botones[text].setLayoutParams(absParams);
                        if (text==8)
                        {
                            botones[i].setText("");
                        }
                        else {
                            botones[i].setText("" + (text + 1));
                        }
                        break;
                    }
                    case (6): {
                        //absParams.x = 5;
                        //absParams.y = 215;
                        //botones[text].setLayoutParams(absParams);
                        if (text==8)
                        {
                            botones[i].setText("");
                        }
                        else {
                            botones[i].setText("" + (text + 1));
                        }
                        break;
                    }
                    case (7): {
                        //absParams.x = 110;
                        //absParams.y = 215;
                        //botones[text].setLayoutParams(absParams);
                        if (text==8)
                        {
                            botones[i].setText("");
                        }
                        else {
                            botones[i].setText("" + (text + 1));
                        }
                        break;
                    }
                    case (8): {
                        //absParams.x = 215;
                        //absParams.y = 215;
                        //botones[text].setLayoutParams(absParams);
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

    public int encontrar_posicion(int elemento)
    {
        int i=0;
        for(i=0;i<9;i++)
        {
            if(celdas.get(i)==elemento)
            {
                break;
            }
        }
        return i;
    }



    public void barajarBotones(View view)
    {
        Collections.shuffle(this.celdas); //colocamos las celdas de forma aleatoria
        rellenar_grid();
    }








}
