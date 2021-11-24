package tn.esprit.recapapp.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import tn.esprit.recapapp.model.User;

@Dao
public interface UserDao {

    @Insert
    void insertUser(User u);

    @Update
    void updateUser(User u);

    @Delete
    void deleteUser(User u);

    @Query("SELECT * FROM user_table")
    List<User> selectAllUsers();

    @Query("SELECT * FROM user_table WHERE email = :email AND password = :pwd Limit 1")
    User findUserByLoginPassword(String email, String pwd);

}
