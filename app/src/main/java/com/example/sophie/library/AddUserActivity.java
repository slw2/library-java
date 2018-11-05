package com.example.sophie.library;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class AddUserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);
    }

    Users users = new Users(this);

    String first_name;
    String last_name;

    public void buttonClicked(View view){

        String user_added = "This user has been added!";

        TextView userData = findViewById(R.id.display_user_data);
        EditText inputText = findViewById(R.id.add_user);
        String hint = inputText.getHint().toString();

        switch(hint){
            case "Please enter a first name":
                first_name = inputText.getText().toString();
                userData.setText("First name: " + first_name + "\n");
                inputText.setText("");
                inputText.setHint("Please enter a last name");
                break;
            case "Please enter a last name":
                last_name = inputText.getText().toString();
                userData.append("Last name: " + last_name + "\n");
                inputText.setText("");
                inputText.setHint("");

                users.add_user(first_name, last_name);
                Toast.makeText(this, user_added, Toast.LENGTH_SHORT).show();
                break;
            case "":
                Toast.makeText(this, user_added, Toast.LENGTH_SHORT).show();
        }
    }

}
