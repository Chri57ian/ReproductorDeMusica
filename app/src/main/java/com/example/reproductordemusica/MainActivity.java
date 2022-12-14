package com.example.reproductordemusica;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {


    Button play_pause, btn_repetir;
    MediaPlayer mp;
    ImageView iv;
    int repetir = 2, posicion = 0;

    MediaPlayer vectormp  [] = new MediaPlayer[3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        play_pause = (Button) findViewById(R.id.btnreproducir);
        btn_repetir = (Button) findViewById(R.id.btnrepetir);
        iv = (ImageView) findViewById(R.id.imageView);

        //Lista de canciones a reproducir dentro de la carpeta Raw
        vectormp[0] = MediaPlayer.create(this, R.raw.audio1);
        vectormp[1] = MediaPlayer.create( this, R.raw.audio2);
        vectormp[2] = MediaPlayer.create( this, R.raw.audio3);
        vectormp[0] = MediaPlayer.create(this, R.raw.feelinggood);
        vectormp[1] = MediaPlayer.create( this, R.raw.followgod);
        vectormp[2] = MediaPlayer.create( this, R.raw.ghosttown);
        vectormp[0] = MediaPlayer.create(this, R.raw.iwonder);
        vectormp[1] = MediaPlayer.create( this, R.raw.les);
        vectormp[2] = MediaPlayer.create( this, R.raw.ojitoslindos);
        vectormp[1] = MediaPlayer.create( this, R.raw.passionfruit);
        vectormp[2] = MediaPlayer.create( this, R.raw.pride);
        vectormp[0] = MediaPlayer.create(this, R.raw.tuconel);
        vectormp[1] = MediaPlayer.create( this, R.raw.tuyo);
    }


        public void PlayPause(View view){
            if(vectormp[posicion].isPlaying()){
                vectormp[posicion].pause();
                play_pause.setBackgroundResource(R.drawable.reproducir);
                Toast.makeText(this,"Pausa", Toast.LENGTH_SHORT).show();
            }
            else{
                vectormp[posicion].start();
                play_pause.setBackgroundResource(R.drawable.reproducir);
                Toast.makeText( this, "Play", Toast.LENGTH_SHORT).show();
            }
        }

        public void stop(View view){
            if(vectormp[posicion] !=null){
                vectormp[posicion].stop();

                vectormp[0] = MediaPlayer.create( this, R.raw.audio1);
                vectormp[1] = MediaPlayer.create( this, R.raw.audio2);
                vectormp[2] = MediaPlayer.create( this, R.raw.audio3);
                posicion = 0;
                play_pause.setBackgroundResource(R.drawable.reproducir);
                iv.setImageResource(R.drawable.portada1);
                Toast.makeText(this, "Stop", Toast.LENGTH_SHORT).show();
            }
        }




        //M??todo repetir una pista
        public void Repetir (View view) {
            if(repetir == 1) {
                btn_repetir.setBackgroundResource(R.drawable.no_repetir);
                Toast.makeText(this, "No repetir", Toast.LENGTH_SHORT).show();
                vectormp[posicion].setLooping(false);
                repetir = 2;
            }
            else {
                    btn_repetir.setBackgroundResource(R.drawable.repetir);
                    Toast.makeText(this, "Repetir", Toast. LENGTH_SHORT). show() ;
                    vectormp[posicion].setLooping(true);
                    repetir = 1;

                }

            }


            public void Siguiente( View view){
            if(posicion < vectormp.length -1){

                if(vectormp[posicion].isPlaying()){
                    vectormp[posicion].stop();
                    posicion++;
                    vectormp[posicion].start();

                    if(posicion == 0){
                        iv.setImageResource(R.drawable.portada1);
                    }  else if (posicion ==1){
                        iv.setImageResource(R.drawable.portada2);
                    }  else if (posicion ==2){
                        iv.setImageResource(R.drawable.portada3);
                    }


                } else {
                    posicion++;

                    if(posicion==0){
                        iv.setImageResource(R.drawable.portada1);
                    }  else if (posicion ==1){
                        iv.setImageResource(R.drawable.portada2);
                    } else if (posicion ==2){
                        iv.setImageResource(R.drawable.portada3);
                    }
                }
            }else {
                Toast.makeText(this, "No hay mas canciones", Toast.LENGTH_SHORT).show();

            }
        }


        //M??todo para regresar a la canci??n anterior
        public void Anterior(View view) {
            if (posicion >= 1) {


                if (vectormp[posicion].isPlaying()) {
                    vectormp[posicion].stop();
                    vectormp[0] = MediaPlayer.create(this, R.raw.audio1);
                    vectormp[1] = MediaPlayer.create(this, R.raw.audio2);
                    vectormp[2] = MediaPlayer.create(this, R.raw.audio3);
                    posicion--;

                    if (posicion == 0) {
                        iv.setImageResource(R.drawable.portada1);
                    } else if (posicion == 1) {
                        iv.setImageResource(R.drawable.portada2);
                    } else if (posicion == 2) {
                        iv.setImageResource(R.drawable.portada3);
                    }

                    vectormp[posicion].start();

                } else {
                    posicion--;

                    if (posicion == 0) {
                        iv.setImageResource(R.drawable.portada1);
                    } else if (posicion == 1) {
                        iv.setImageResource(R.drawable.portada2);
                    } else if (posicion == 2) {
                        iv.setImageResource(R.drawable.portada3);
                    }
                }
            }

            else {
                        Toast.makeText(this, "No hay m??s canciones", Toast.LENGTH_SHORT).show();
                    }

                }

        }