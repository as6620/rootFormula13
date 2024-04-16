package com.example.rootformula13;

import android.app.Activity;
import android.content.Intent;
import  android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    final int REQUEST_CODE = 1234;
    Random random = new Random();
    EditText etA, etB, etC;
    TextView tV1, tV2;
    Button rnd, cal;
    Double a, b, c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tV1 = (TextView) findViewById(R.id.tV1);
        tV2 = (TextView) findViewById(R.id.tV2);
        etA = (EditText) findViewById(R.id.etA);
        etB = (EditText) findViewById(R.id.etB);
        etC = (EditText) findViewById(R.id.etC);
    }

    public void goRandom(View view) {
        a = (double) (random.nextInt(10) + 1);
        b = (double) (random.nextInt(10) + 1);
        c = (double) (random.nextInt(100) + 1);
        etA.setText("" + a);
        etB.setText("" + b);
        etC.setText("" + c);
    }

    public void goCal(View view) {
        String aStr = etA.getText().toString();
        String bStr = etB.getText().toString();
        String cStr = etC.getText().toString();


        if (aStr.isEmpty() | aStr.equals("-") | aStr.equals("-.") | aStr.equals("+") | aStr.equals("+.") | bStr.isEmpty() | bStr.equals("-") | bStr.equals("-.") | bStr.equals("+") | bStr.equals("+.") | cStr.isEmpty() | cStr.equals("-") | cStr.equals("-.") | cStr.equals("+") | cStr.equals("+."))
            Toast.makeText(this, "Invalid input", Toast.LENGTH_SHORT).show();
        else {
            double aDouble = Double.parseDouble(aStr);
            if (aDouble == 0)
                Toast.makeText(this, "'a' can't be 0", Toast.LENGTH_SHORT).show();
            else {
                Intent si = new Intent(this, solActivity.class);
                si.putExtra("a", aDouble);
                si.putExtra("b", Double.parseDouble(bStr));
                si.putExtra("c", Double.parseDouble(cStr));
                startActivityForResult(si, REQUEST_CODE);
            }
        }
    }
    @Override
    protected void onActivityResult(int source, int result, @Nullable Intent data_back) {
        super.onActivityResult(source, result, data_back);
        if (source == REQUEST_CODE && result == Activity.RESULT_OK && data_back != null) {
            double x1 = data_back.getDoubleExtra("x1", Double.NaN);
            double x2 = data_back.getDoubleExtra("x2", Double.NaN);
            tV1.setText("x1: " + x1);
            tV2.setText("x2: " + x2);
        }
    }
}