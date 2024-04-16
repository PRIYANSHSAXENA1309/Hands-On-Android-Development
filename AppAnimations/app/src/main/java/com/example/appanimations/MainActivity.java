package com.example.appanimations;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView txtAnim;
    Button btn1,btn2,btn3,btn4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        txtAnim = findViewById(R.id.txtAnim);
        Animation move,alpha,scale,rotate;
        move= AnimationUtils.loadAnimation(this,R.anim.move);
        alpha= AnimationUtils.loadAnimation(this,R.anim.alpha);
        scale= AnimationUtils.loadAnimation(this,R.anim.scale);
        rotate= AnimationUtils.loadAnimation(this,R.anim.rotate);

        btn1 = findViewById(R.id.btnTranslate);
        btn2 = findViewById(R.id.btnAlpha);
        btn3 = findViewById(R.id.btnScale);
        btn4 = findViewById(R.id.btnRotate);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtAnim.startAnimation(move);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtAnim.startAnimation(alpha);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtAnim.startAnimation(scale);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtAnim.startAnimation(rotate);
            }
        });
    }
}