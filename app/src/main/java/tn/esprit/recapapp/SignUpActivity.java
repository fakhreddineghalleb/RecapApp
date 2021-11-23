package tn.esprit.recapapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class SignUpActivity extends AppCompatActivity {

    private EditText edtLastName, edtfirstName, edtEmail, edtPassword, edtPhoneNumber;
    private Button btnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        edtLastName = findViewById(R.id.edtLastName);
        edtfirstName = findViewById(R.id.edtFirstName);
        edtEmail = findViewById(R.id.edtEmail);
        edtPassword = findViewById(R.id.edtPassword);
        edtPhoneNumber = findViewById(R.id.edtPhoneNumber);
        btnSignUp = findViewById(R.id.btnSignUp);

        btnSignUp.setOnClickListener(view -> {

        });

    }
}