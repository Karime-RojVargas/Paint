package com.example.frias.pintaryfrag;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;


public class Frag extends Fragment {

    Pintar pintar;
    RelativeLayout relativeLayout;
    private int corX, corY;
    String accion;
    Path path;

    
    public Frag() {
        // Required empty public constructor
        corX=200;
        corY=200;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_,container,false);

        relativeLayout = view.findViewById(R.id.rec);
        relativeLayout.addView(new Pintar(getActivity()));
        path = new Path();

        return view;
    }

    class Pintar extends View {
        public Pintar(Context context) {
            super (context);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            canvas.drawRGB(255,255,0);
            Paint paint = new Paint();
            //paint.setColor(Color.BLACK);
            paint.setColor(Color.BLUE);
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(4);

            if(accion=="down"){
                path.moveTo(corX,corY);
            }
            if(accion=="move"){
                path.lineTo(corX,corY);
            }
            canvas.drawPath(path,paint);
        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            int acc=event.getAction();
            corX=(int) event.getX();
            corY=(int) event.getY();
            if(acc==MotionEvent.ACTION_DOWN){
                accion="down";
            }
            if(acc==MotionEvent.ACTION_MOVE){
                accion="move";
            }
            invalidate();  //Sirve para refrescar para poder dibujar

            return true;
        }
    }






}
