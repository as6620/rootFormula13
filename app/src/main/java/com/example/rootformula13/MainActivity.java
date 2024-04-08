package com.example.rootformula13;

import  android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Random random = new Random();
    EditText etA, etB, etC;
    Button rnd, cal;
    Double a,b,c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void goRandom(View view) {
        a = (double) (random.nextInt(10) + 1);
        b = (double) (random.nextInt(10) + 1);
        c = (double) (random.nextInt(10) + 1);
        etA.setText(""+a);
        etB.setText(""+b);
        etC.setText(""+c);
    }

    public void goCal(View view) {

    }
}
