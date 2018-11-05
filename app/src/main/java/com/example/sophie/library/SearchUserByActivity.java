package com.example.sophie.library;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class SearchUserByActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        String message = intent.getStringExtra(SearchUserActivity.EXTRA_MESSAGE);
        setContentView(R.layout.activity_search_user_by);
        EditText editText = findViewById(R.id.editText_main);
        editText.setHint(message);
    }

    Users users = new Users(this);

    public void displayUser(View view) {
        User user = null;
        List<User> user_matches = null;
        EditText editText = findViewById(R.id.editText_main);
        Intent intent = getIntent();
        String message = intent.getStringExtra(SearchUserActivity.EXTRA_MESSAGE);
        if (editText != null) {
            switch(message){
                case "Please enter a first name":
                    String first_name = editText.getText().toString();
                    user_matches = users.usersearch_by_firstname(first_name);
                    break;
                case "Please enter a last name":
                    String last_name = editText.getText().toString();
                    user_matches = users.usersearch_by_lastname(last_name);
                    break;
                case "Please enter an ID number":
                    Integer id = Integer.parseInt(editText.getText().toString());
                    user = users.usersearch_by_id(id);
                    break;
            }
        }

        if (user_matches!=null && !user_matches.isEmpty()){
            TextView display = findViewById(R.id.display_user_text);
            display.setText("");
            for (User x: user_matches)
                display.append(x.print());
        }

        else if (user!=null && user.getId()>0) {
            String userName = user.print();

            TextView display = findViewById(R.id.display_user_text);
            display.setText(userName);
        }
        else{
            Toast.makeText(this,
                    "No users found",
                    Toast.LENGTH_SHORT).show();
        }

        editText.setText("");
    }
}
