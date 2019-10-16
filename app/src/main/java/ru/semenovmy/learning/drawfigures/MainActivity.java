package ru.semenovmy.learning.drawfigures;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import ru.semenovmy.learning.drawfigures.model.FigureType;

public class MainActivity extends AppCompatActivity {

    private Button mGraphButton;
    private Button mLineButton;
    private Button mSquareButton;

    private Button mAccentColorButton;
    private Button mBlackColorButton;
    private Button mBlueColorButton;
    private Button mPrimaryColorButton;
    private Button mPrimaryDarkColorButton;
    private Button mRedColorButton;
    private Button mYellowColorButton;
    private Button mVioletColorButton;

    private Button mClearButton;
    private DrawView mDrawView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDrawView = findViewById(R.id.draw_view);

        buttonInit();
        toastInit();
    }

    private void toastInit() {
        Toast toast = Toast.makeText(MainActivity.this, R.string.toast, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

    private void buttonInit() {
        mGraphButton = findViewById(R.id.button_graph);
        mLineButton = findViewById(R.id.button_line);
        mSquareButton = findViewById(R.id.button_square);
        mRedColorButton = findViewById(R.id.color_red);
        mBlueColorButton = findViewById(R.id.color_blue);
        mYellowColorButton = findViewById(R.id.color_yellow);
        mPrimaryColorButton = findViewById(R.id.color_primary);
        mPrimaryDarkColorButton = findViewById(R.id.color_primary_dark);
        mAccentColorButton = findViewById(R.id.color_accent);
        mBlackColorButton = findViewById(R.id.color_black);
        mVioletColorButton = findViewById(R.id.color_violet);
        mClearButton = findViewById(R.id.btn_clear);

        mGraphButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDrawView.setDrawType(FigureType.GRAPH);
            }
        });

        mLineButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDrawView.setDrawType(FigureType.LINE);
            }
        });

        mSquareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDrawView.setDrawType(FigureType.SQUARE);
            }
        });

        mRedColorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDrawView.setPaintColor(getResources().getColor(R.color.colorRed));
            }
        });

        mBlueColorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDrawView.setPaintColor(getResources().getColor(R.color.colorBlue));
            }
        });

        mYellowColorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDrawView.setPaintColor(getResources().getColor(R.color.colorYellow));
            }
        });

        mPrimaryColorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDrawView.setPaintColor(getResources().getColor(R.color.colorPrimary));
            }
        });

        mPrimaryDarkColorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDrawView.setPaintColor(getResources().getColor(R.color.colorPrimaryDark));
            }
        });

        mAccentColorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDrawView.setPaintColor(getResources().getColor(R.color.colorAccent));
            }
        });

        mBlackColorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDrawView.setPaintColor(getResources().getColor(R.color.colorBlack));
            }
        });

        mVioletColorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDrawView.setPaintColor(getResources().getColor(R.color.colorViolet));
            }
        });

        mClearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDrawView.clear();
            }
        });
    }
}
