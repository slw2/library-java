package com.example.sophie.library;

import android.os.Bundle;
import android.app.Activity;
import android.widget.TextView;

import java.util.List;

public class ListUsersActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_users);
        listUsers();
    }

    Users users = new Users(this);

    public void listUsers(){
        TextView userList = findViewById(R.id.list_users);
        userList.setText("");

        List<User> all_users = users.users();
        for (User user: all_users){
            String userData = user.print();
            userList.append(userData);
        }
    }
}
