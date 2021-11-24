package tn.esprit.recapapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import tn.esprit.recapapp.R;
import tn.esprit.recapapp.adapters.CountryAdapter;
import tn.esprit.recapapp.adapters.UserAdapter;
import tn.esprit.recapapp.database.AppDataBase;
import tn.esprit.recapapp.model.User;

public class FragThree extends Fragment {

    private RecyclerView recyclerView;
    private UserAdapter userAdapter;

    private List<User> users;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_three, container, false);

        recyclerView = root.findViewById(R.id.recyclerUser);

        users = AppDataBase.getInstance(getActivity()).userDao().selectAllUsers();

        userAdapter = new UserAdapter(users, getActivity());

        recyclerView.setAdapter(userAdapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));

        return root;
    }
}
