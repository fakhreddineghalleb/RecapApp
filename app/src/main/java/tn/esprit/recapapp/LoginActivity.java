package tn.esprit.recapapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import tn.esprit.recapapp.database.AppDataBase;
import tn.esprit.recapapp.model.User;

public class LoginActivity extends AppCompatActivity {

    private EditText edtEmail, edtPassword;
    private CheckBox cbRememberMe;
    private Button btnSignIn, btnSignUp;

    private SharedPreferences mSharedPref;

    public static final String sharedPrefFileName = "tn.esprit.recapapp.file1";
    public static final String sharedPrefFileName1 = "tn.esprit.recapapp.file2";
    public static final String sharedPrefFileName2 = "tn.esprit.recapapp.file3";

    private User tempUser = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtEmail = findViewById(R.id.edtEmail);
        edtPassword = findViewById(R.id.edtPassword);
        cbRememberMe = findViewById(R.id.cbRememberMe);
        btnSignIn = findViewById(R.id.btnSignIn);
        btnSignUp = findViewById(R.id.btnSignUp);

        mSharedPref = getSharedPreferences(sharedPrefFileName, MODE_PRIVATE);

        btnSignUp.setOnClickListener(view -> {

            Intent mainIntent = new Intent(LoginActivity.this, SignUpActivity.class);
            startActivity(mainIntent);

        });

        edtEmail.setText(mSharedPref.getString("LOGIN", ""));
        edtPassword.setText(mSharedPref.getString("MDP", ""));
        cbRememberMe.setChecked(mSharedPref.getBoolean("REMEMBERED", false));

        btnSignIn.setOnClickListener(view -> {
            if (validate()){

                if (cbRememberMe.isChecked()){

                    Log.e("user signedIn", tempUser.toString());

                    SharedPreferences.Editor editor = mSharedPref.edit();

                    editor.putString("FIRSTNAME", tempUser.getFirstName());
                    editor.putString("LASTNAME", tempUser.getLastName());
                    editor.putString("LOGIN", edtEmail.getText().toString());
                    editor.putString("MDP", edtPassword.getText().toString());
                    editor.putInt("PHONENUMBER", tempUser.getPhoneNumber());
                    editor.putBoolean("REMEMBERED", cbRememberMe.isChecked());

                    editor.apply();

                }else{
                    mSharedPref.edit().clear().apply();
                }

                Intent mainIntent = new Intent(LoginActivity.this,
                        HomeActivity.class);
                startActivity(mainIntent);
            }
        });

//        if (mSharedPref.getBoolean("REMEMBERED", false)){
//            Intent mainIntent = new Intent(LoginActivity.this,
//                    HomeActivity.class);
//            startActivity(mainIntent);
//        }

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

//        if (!edtEmail.getText().toString().equals("admin")
//                && !edtPassword.getText().toString().equals("admin") ){
//            Toast.makeText(this, "Erreur dans les champs !", Toast.LENGTH_SHORT).show();
//            return false;
//        }

        tempUser = AppDataBase.getInstance(this).userDao()
        .findUserByLoginPassword(edtEmail.getText().toString(), edtPassword.getText().toString());

        if (tempUser == null){
            Toast.makeText(this, "User Not Found !", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }
}