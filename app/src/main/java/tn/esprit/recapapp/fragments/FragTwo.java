package tn.esprit.recapapp.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import tn.esprit.recapapp.R;

public class FragTwo extends Fragment {

    private Button btnCall, btnCamera;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_two, container, false);

        btnCall = root.findViewById(R.id.btnCall);

        btnCamera = root.findViewById(R.id.btnCamera);

        btnCall.setOnClickListener(view -> {
            Intent mainIntent = new Intent(Intent.ACTION_DIAL);
            mainIntent.setData(Uri.parse("tel:"+getArguments().getString("NUMBER")));
            startActivity(mainIntent);
        });

        btnCamera.setOnClickListener(view -> {
            Intent mainIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivity(mainIntent);
        });

        return root;
    }
}
