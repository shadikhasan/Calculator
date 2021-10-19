package com.example.calculator;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import org.mariuszgromada.math.mxparser.*;

public class MainActivity extends AppCompatActivity {

    Button bZero, b1, b2, b3, b4, b5, b6, b7, b8, b9, bDot;
    Button bEqual, bPlus, bMinus, bDivide, bMultiply, bAC, bC, bFirstBracket1, bFirstBracket2, bPercentage, bE, bXfactorial, bXpowerN, bRoot, bXinverse, bSin, bCos, bTan, bPi, bLog, bLn;

    TextView tvResult, tvExpression;

    String valueOfPi = "3.141592653589793238462643383279502";
    String valueOfE = "2.718281828459045";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        //Number Buttons
        bZero = findViewById(R.id.bZero);
        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
        b3 = findViewById(R.id.b3);
        b4 = findViewById(R.id.b4);
        b5 = findViewById(R.id.b5);
        b6 = findViewById(R.id.b6);
        b7 = findViewById(R.id.b7);
        b8 = findViewById(R.id.b8);
        b9 = findViewById(R.id.b9);
        bDot = findViewById(R.id.bDot);

        //Operator Buttons
        bEqual = findViewById(R.id.bEqual);
        bPlus = findViewById(R.id.bPlus);
        bMinus = findViewById(R.id.bMinus);
        bDivide = findViewById(R.id.bDivide);
        bMultiply = findViewById(R.id.bMultiply);

        //special buttons
        bAC = findViewById(R.id.bAc);
        bC = findViewById(R.id.bC);
        bFirstBracket1 = findViewById(R.id.bFirstBracket1);
        bFirstBracket2 = findViewById(R.id.bFirstBracket2);
        bPercentage = findViewById(R.id.bPercentage);

        //fuctional button
        bSin = findViewById(R.id.bSin);
        bCos = findViewById(R.id.bCos);
        bTan = findViewById(R.id.bTan);
        bLog = findViewById(R.id.bLog);
        bLn = findViewById(R.id.bLn);

        bXfactorial = findViewById(R.id.bXfactorial);
        bXpowerN = findViewById(R.id.bXpowerN);
        bRoot = findViewById(R.id.bRoot);
        bXinverse = findViewById(R.id.bXinverse);
        bPi = findViewById(R.id.bPi);
        bE = findViewById(R.id.bE);

        //textview 1 & 2
        tvResult = findViewById(R.id.tvResult);
        tvExpression = findViewById(R.id.tvExpression);

        clearScreen();

        bAC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvResult.setTextColor(Color.WHITE);
                clearScreen();
            }
        });
        bC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = tvExpression.getText().toString();
                if (!str.equals("")) {
                    str = str.substring(0, str.length() - 1);
                    tvExpression.setText(str);
                }
            }
        });

        bPercentage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeExpression("%");
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeExpression("1");
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeExpression("2");
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeExpression("3");
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeExpression("4");
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeExpression("5");
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeExpression("6");
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeExpression("7");
            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeExpression("8");
            }
        });
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeExpression("9");
            }
        });
        bZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeExpression("0");
            }
        });
        bDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeExpression(".");
            }
        });
        bFirstBracket1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeExpression("(");
            }
        });
        bFirstBracket2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeExpression(")");
            }
        });
        bSin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mXparser.setDegreesMode();
                writeExpression("sin(");
            }
        });
        bCos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mXparser.setDegreesMode();
                writeExpression("cos(");
            }
        });
        bTan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mXparser.setDegreesMode();
                writeExpression("tan(");
            }
        });
        bLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeExpression("log10(");
            }
        });
        bLn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeExpression("ln(");
            }
        });
        bXfactorial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeExpression("!");
            }
        });
        bXpowerN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeExpression("^");
            }
        });
        bRoot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeExpression("sqrt(");
            }
        });
        bXinverse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeExpression("^-1");
            }
        });
        bPi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeExpression("pi");
            }
        });
        bE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeExpression("e");
            }
        });


        bDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeExpression("/");
            }
        });
        bMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeExpression("*");
            }
        });
        bMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeExpression("-");
            }
        });
        bPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeExpression("+");
            }
        });

        //Equal Function
        bEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String expression = tvExpression.getText().toString();

                tvResult.setTextColor(Color.WHITE);
                Expression e = new Expression(expression);
                String result = String.valueOf(e.calculate());

                if(result == "NaN"){
                    result = "Invalid input!";
                    tvResult.setTypeface(null, Typeface.BOLD);
                    tvResult.setTextColor(Color.RED);
                }
                tvResult.setText(result);
            }
        });
        tvResult.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                String result2 = tvResult.getText().toString();

                if(result2 != "Invalid input!")
                {
                    tvExpression.setText(result2);
                }
                return true;
            }
        });


    }

    //menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.aboutMenuId) {

            ViewGroup viewGroup = findViewById(android.R.id.content);

            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            View view1 = LayoutInflater.from(MainActivity.this).inflate(R.layout.about_layout, viewGroup, false);
            builder.setTitle(" ");

            builder.setView(view1);

            AlertDialog alertDialog = builder.create();
            alertDialog.getWindow().setLayout(600, 700);
            alertDialog.show();


            builder.setCancelable(false);
        }
        return super.onOptionsItemSelected(item);
    }

    void writeExpression(String value) {
        String expression = tvExpression.getText().toString();
        expression = expression + value;

        tvExpression.setText(expression);
    }

    void clearScreen() {
        tvExpression.setText("");
        tvResult.setText("0.00");
    }
}