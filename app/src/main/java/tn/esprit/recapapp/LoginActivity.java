package tn.esprit.recapapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText edtEmail, edtPassword;
    private CheckBox cbRememberMe;
    private Button btnSignIn, btnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtEmail = findViewById(R.id.edtEmail);
        edtPassword = findViewById(R.id.edtPassword);
        cbRememberMe = findViewById(R.id.cbRememberMe);
        btnSignIn = findViewById(R.id.btnSignIn);
        btnSignUp = findViewById(R.id.btnSignUp);

        btnSignUp.setOnClickListener(view -> {

            Intent mainIntent = new Intent(LoginActivity.this, SignUpActivity.class);
            startActivity(mainIntent);

        });

        btnSignIn.setOnClickListener(view -> {
            if (validate()){
                Intent mainIntent = new Intent(LoginActivity.this,
                        HomeActivity.class);
                startActivity(mainIntent);
            }
        });

    }

    private boolean validate(){

        if (edtEmail.getText().toString().isEmpty()){
            Toast.makeText(this, "Donner Votre Email !", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (edtPassword.getText().toString().isEmpty()){
            Toast.makeText(this, "Donner Votre Password !", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (!edtEmail.getText().toString().equals("admin")
                && !edtPassword.getText().toString().equals("admin") ){
            Toast.makeText(this, "Erreur dans les champs !", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }
}