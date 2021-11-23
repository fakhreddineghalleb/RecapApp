package tn.esprit.recapapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import tn.esprit.recapapp.fragments.FragOne;
import tn.esprit.recapapp.fragments.FragThree;
import tn.esprit.recapapp.fragments.FragTwo;

public class HomeActivity extends AppCompatActivity {

    private TextView tvLastFirstName, tvEmail, tvPhoneNumber;
    private Button btnFrag1, btnFrag2, btnFrag3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        tvLastFirstName = findViewById(R.id.tvLastFirstName);
        tvEmail = findViewById(R.id.tvEmail);
        tvPhoneNumber = findViewById(R.id.tvPhoneNumber);
        btnFrag1 = findViewById(R.id.btnFrag1);
        btnFrag2 = findViewById(R.id.btnFrag2);
        btnFrag3 = findViewById(R.id.btnFrag3);

        btnFrag1.setOnClickListener(view -> {
            changeFragment(new FragOne(), "");
        });

        btnFrag2.setOnClickListener(view -> {
            Fragment frag = new FragTwo();

            Bundle bundle = new Bundle();
            bundle.putString("NUMBER", tvPhoneNumber.getText().toString());

            frag.setArguments(bundle);

            changeFragment( frag, "");
        });

        btnFrag3.setOnClickListener(view -> {
            changeFragment(new FragThree(), "");
        });

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragment_container, new FragOne())
                .commit();

    }

    private void changeFragment(Fragment fragment, String tag){
        if (tag.isEmpty()){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();
        }else{
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .addToBackStack(tag)
                    .commit();
        }
    }

}