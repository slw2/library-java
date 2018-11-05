package com.example.sophie.library;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import static android.text.TextUtils.isDigitsOnly;

public class RemoveUserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remove_user);
    }

    Users users = new Users(this);

    public void buttonClicked(View view){
        EditText input_id = findViewById(R.id.remove_user);
        if (isDigitsOnly(input_id.getText().toString())) {
            Integer id = Integer.parseInt(input_id.getText().toString());

            User user = users.usersearch_by_id(id);
            if (user.getId() > 0) {
                users.remove_user(user);
                Toast.makeText(this,
                        "User with ID " + id + " has been removed",
                        Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this,
                        "User with ID " + id + " does not exist",
                        Toast.LENGTH_SHORT).show();
            }

            input_id.setText("");
            input_id.setHint("Please enter another ID");

        }
        else{
            Toast.makeText(this,
                    "Invalid ID",
                    Toast.LENGTH_SHORT).show();
            input_id.setText("");
        }
    }
}
