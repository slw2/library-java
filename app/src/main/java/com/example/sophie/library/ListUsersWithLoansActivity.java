package com.example.sophie.library;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class ListUsersWithLoansActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_users_with_loans);
        listUsersWithLoans();
    }

    Loans loans = new Loans(this);

    public void listUsersWithLoans(){
        TextView users_with_loans = findViewById(R.id.list_users_with_loans);
        users_with_loans.setText("");

        List<User> users = loans.users_with_loans();
        for (User user: users){
            users_with_loans.append(user.print());
        }
    }
}