package tn.esprit.recapapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import tn.esprit.recapapp.R;
import tn.esprit.recapapp.model.Country;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.CountryViewHolder> {

    private List<Country> countryList;
    private Context mContext;

    public CountryAdapter(List<Country> countryList, Context mContext) {
        this.countryList = countryList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public CountryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(mContext).inflate(R.layout.single_country_row, parent, false);
        return new CountryViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(@NonNull CountryViewHolder holder, int position) {

        Country singleCountry = countryList.get(position);

        holder.countryName.setText(singleCountry.getNom());

        holder.countryImg.setImageResource(singleCountry.getImage());

    }

    @Override
    public int getItemCount() {
        return countryList.size();
    }

    class CountryViewHolder extends RecyclerView.ViewHolder {

        private ImageView countryImg;
        private TextView countryName;

        public CountryViewHolder(@NonNull View itemView) {
            super(itemView);

            countryName = itemView.findViewById(R.id.countryName);
            countryImg = itemView.findViewById(R.id.countryImg);

        }
    }
}
