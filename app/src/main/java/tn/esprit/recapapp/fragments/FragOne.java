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

import java.util.ArrayList;
import java.util.List;

import tn.esprit.recapapp.R;
import tn.esprit.recapapp.adapters.CountryAdapter;
import tn.esprit.recapapp.model.Country;

public class FragOne extends Fragment {

    private RecyclerView recyclerView;
    private CountryAdapter countryAdapter;

    private List<Country> countries = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_one, container, false);

        recyclerView = root.findViewById(R.id.recylerCountry);

        countries.add(new Country(1, "Algeria", R.drawable.ic_algeria));
        countries.add(new Country(2, "Argentina", R.drawable.ic_argentina));
        countries.add(new Country(3, "Australia", R.drawable.ic_australia));
        countries.add(new Country(4, "Belgium", R.drawable.ic_belgium));
        countries.add(new Country(5, "Brazil", R.drawable.ic_brazil));
        countries.add(new Country(6, "Cameroon", R.drawable.ic_cameroon));
        countries.add(new Country(7, "Canada", R.drawable.ic_canada));
        countries.add(new Country(8, "China", R.drawable.ic_china));
        countries.add(new Country(9, "Colombia", R.drawable.ic_colombia));
        countries.add(new Country(10, "Tunisia", R.drawable.ic_tunisia));

        countryAdapter = new CountryAdapter(countries, getActivity());

        recyclerView.setAdapter(countryAdapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));

        return root;
    }
}
