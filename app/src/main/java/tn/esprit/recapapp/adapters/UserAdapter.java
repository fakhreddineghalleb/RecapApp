package tn.esprit.recapapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import tn.esprit.recapapp.R;
import tn.esprit.recapapp.model.User;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {

    private List<User> userList;
    private Context mContext;

    public UserAdapter(List<User> countryList, Context mContext) {
        this.userList = countryList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(mContext).inflate(R.layout.single_user_row, parent, false);
        return new UserViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {

        User singleUser = userList.get(position);

        holder.userFirstName.setText(singleUser.getFirstName());
        holder.userLastName.setText(singleUser.getLastName());

    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    class UserViewHolder extends RecyclerView.ViewHolder {

        private TextView userFirstName, userLastName;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);

            userFirstName = itemView.findViewById(R.id.userFirstName);
            userLastName = itemView.findViewById(R.id.userLastName);

        }
    }
}
