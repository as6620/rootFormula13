package com.example.rootformula13;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class solActivity extends AppCompatActivity {
    Button button;
    TextView tV3, tV4;
    ImageView iV;
    double x1, x2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sol);

        button = (Button) findViewById(R.id.button);
        tV3 = findViewById(R.id.tV3);
        tV4 = findViewById(R.id.tV4);
        iV = findViewById(R.id.iV);

        Intent gi = getIntent();
        double a = gi.getDoubleExtra("a", 0);
        double b = gi.getDoubleExtra("b", 0);
        double c = gi.getDoubleExtra("c", 0);

        double discriminant = b * b - 4 * a * c;
        tV3.setText(""+discriminant);
        if (discriminant > 0) {
            x1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            x2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            tV3.setText("Solution 1 (x1): " + x1);
            tV4.setText("Solution 2 (x2): " + x2);
        } else if (discriminant == 0) {
            x1 = -b / (2 * a);
            tV3.setText("there is 1 solution: " + x1);
            tV4.setText("");
        } else {
            tV3.setText("No real solutions");
            tV4.setText("");
        }
        if (discriminant == 0 || discriminant > 0) {
            if (a>0 && c>0)
                iV.setImageResource(R.drawable.smileup);
            else if (a>0 && c==0)
                iV.setImageResource(R.drawable.smile);
            else if (a>0 && c<0)
                iV.setImageResource(R.drawable.smiledown);
            else if (a<0 && c>0)
                iV.setImageResource(R.drawable.sadup);
            else if (a<0 && c==0)
                iV.setImageResource(R.drawable.sad);
            else
                iV.setImageResource(R.drawable.saddown);
//            else if (a<0 && c<0)
//                iV.setImageResource(R.drawable.saddown);
//            else
//                iV.setImageResource(R.drawable.error);
        }
    }

    public void goBack(View view) {
        Intent giIntent = new Intent();
        giIntent.putExtra("x1", x1);
        giIntent.putExtra("x2", x2);
        setResult(RESULT_OK, giIntent);
        finish();
    }
}