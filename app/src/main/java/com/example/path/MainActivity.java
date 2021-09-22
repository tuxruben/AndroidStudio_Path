package com.example.path;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    private Drawable miImagen;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(new EjemploView(this));
           Context res = getApplicationContext();
            miImagen = res.getDrawable(R.drawable.descarga2);
            miImagen.setBounds(30,400,200,600);
        }


        public class EjemploView extends View {
            public EjemploView (Context context) {
                super(context);
            }
            @Override
            protected void onDraw (Canvas canvas) {

                Path trazo = new Path ();
                trazo.addCircle(150,150, 100, Path.Direction.CW);
                canvas.drawColor(Color.WHITE);
                Paint pincel = new Paint();
                pincel.setColor(Color.BLUE);
                pincel.setStrokeWidth(8);
                pincel.setStyle(Paint.Style.STROKE);
                canvas.drawPath(trazo,pincel);
                pincel.setStrokeWidth(1);
                pincel.setStyle (Paint.Style.FILL);
                pincel.setTextSize(20);
                pincel.setTypeface(Typeface.SANS_SERIF);
                canvas.drawTextOnPath("Desarrollo de aplicaciones para móviles con Android ", trazo, -10, -40, pincel);
                miImagen.draw(canvas);
            }
        }
    }