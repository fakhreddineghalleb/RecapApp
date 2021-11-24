package tn.esprit.recapapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import tn.esprit.recapapp.database.AppDataBase;
import tn.esprit.recapapp.model.User;

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
            if (validate()){
                User user = new User();
                user.setLastName(edtLastName.getText().toString());
                user.setFirstName(edtfirstName.getText().toString());
                user.setEmail(edtEmail.getText().toString());
                user.setPassword(edtPassword.getText().toString());
                user.setPhoneNumber(Integer.parseInt(edtPhoneNumber.getText().toString()));

                AppDataBase.getInstance(SignUpActivity.this)
                        .userDao().insertUser(user);

                Log.e("user signedUp", user.toString());

                finish();
            }
        });

    }

    private boolean validate(){

        if (edtLastName.getText().toString().isEmpty()){
            Toast.makeText(this, "Donner Votre Nom !", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (edtfirstName.getText().toString().isEmpty()){
            Toast.makeText(this, "Donner Votre Prenom !", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (edtEmail.getText().toString().isEmpty()){
            Toast.makeText(this, "Donner Votre Email !", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (edtPassword.getText().toString().isEmpty()){
            Toast.makeText(this, "Donner Votre Password !", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (edtPhoneNumber.getText().toString().isEmpty()){
            Toast.makeText(this, "Donner Votre Telephone !", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }
}