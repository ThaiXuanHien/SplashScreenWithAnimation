package com.example.splashscreenwithanimation;


import androidx.appcompat.app.AppCompatActivity;


import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;

import android.os.Handler;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Animation topAnim, bottomAnim;
    TextView txtName, txtSlogan;
    ImageView imgLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);


        topAnim = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);
        imgLogo = findViewById(R.id.imageviewLogo);
        txtName = findViewById(R.id.textviewName);
        txtSlogan = findViewById(R.id.textviewSlogan);

        imgLogo.setAnimation(topAnim);
        txtSlogan.setAnimation(bottomAnim);
        txtName.setAnimation(bottomAnim);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                // Attach all the elements those you want to animate in design
                Pair[] pairs = new Pair[3];
                pairs[0] = new Pair<View, String>(imgLogo, "logo_image");
                pairs[1] = new Pair<View, String>(txtName, "logo_text");
                pairs[2] = new Pair<View, String>(txtSlogan, "slogan");
                //wrap the call in API level 21 or higher
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                    ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this, pairs);
                    startActivity(intent, options.toBundle());

                }
                
            }
        }, 5000);

    }
}
