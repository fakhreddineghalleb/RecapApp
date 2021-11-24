package tn.esprit.recapapp.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import tn.esprit.recapapp.dao.UserDao;
import tn.esprit.recapapp.model.User;

@Database(entities = {User.class}, version = 1, exportSchema = false)
public abstract class AppDataBase extends RoomDatabase {

    public static AppDataBase instance;

    public abstract UserDao userDao();

    public static AppDataBase getInstance(Context context){

        if (instance == null){
            instance = Room
                    .databaseBuilder(context, AppDataBase.class, "recap_db")
                    .allowMainThreadQueries()
                    .build();
        }

        return instance;
    }

}
