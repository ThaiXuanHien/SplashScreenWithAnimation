package com.example.splashscreenwithanimation;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity {

    Button btnSignUp, btnLogin;
    ImageView imgLogo;
    TextView txtHello, txtSignInTo;
    TextInputLayout edtUsername, edtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);

        // anh xa
        btnSignUp = findViewById(R.id.buttonSignUp);
        btnLogin = findViewById(R.id.buttonLogin);
        imgLogo = findViewById(R.id.imageviewLogoLogin);
        txtHello = findViewById(R.id.textviewHello);
        txtSignInTo = findViewById(R.id.textviewSignInTo);
        edtUsername = findViewById(R.id.edittextUsername);
        edtPassword = findViewById(R.id.edittextPassword);

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SignUpActivity.class);
                Pair[] pairs = new Pair[7];
                pairs[0] = new Pair<View, String>(imgLogo, "logo_image");
                pairs[1] = new Pair<View, String>(txtHello, "logo_text");
                pairs[2] = new Pair<View, String>(txtSignInTo, "slogan");
                pairs[3] = new Pair<View, String>(edtUsername, "username_tran");
                pairs[4] = new Pair<View, String>(edtPassword, "password_tran");
                pairs[5] = new Pair<View, String>(btnLogin, "login_tran");
                pairs[6] = new Pair<View, String>(btnSignUp, "signUp_tran");
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                    ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(LoginActivity.this, pairs);
                    startActivity(intent, options.toBundle());

                }
            }
        });
    }
}