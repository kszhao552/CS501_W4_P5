package com.example.w4_p5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import org.jetbrains.annotations.NotNull;

public class MainActivity extends AppCompatActivity {
    Button b;
    TextView t;
    GridLayout griddy;

    // maybe need this? not sure how to handle orientation change, i tried to help
    @Override
    public void onConfigurationChanged(@NotNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        // Checks the orientation of the screen
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {

        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){

        }
    }

    // THERE IS NO HINT BUTTON IN PORTRAIT MODE, BE CAREFUL WHEN REFERENCING IT

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView hanger = findViewById(R.id.hang_image);

        griddy = (GridLayout) findViewById(R.id.choice_grid);

        t = findViewById(R.id.test);

        View.OnClickListener selector = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ugly_name = view.getResources().getResourceName(view.getId());
                String letter = String.valueOf(ugly_name.charAt(ugly_name.length()-1));
                t.setText(t.getText() + letter);
            }
        };

        int c = griddy.getChildCount();

        for(int i = 0; i < c; i++){
            griddy.getChildAt(i).setOnClickListener(selector);
        }

//        b.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                hanger.setImageDrawable(getResources().getDrawable(R.drawable.fail));
//            }
//        });


        // write helper function that gets called in onclicklistener
        // to determine current state and next state (array of drawables?)

    }
}