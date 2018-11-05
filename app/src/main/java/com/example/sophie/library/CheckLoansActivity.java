package com.example.sophie.library;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import static android.text.TextUtils.isDigitsOnly;

public class CheckLoansActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_loans);
    }

    Loans loans = new Loans(this);
    Users users = new Users(this);

    public void buttonClicked(View view){
        EditText user_id = findViewById(R.id.check_loans);
        TextView display_loans = findViewById(R.id.display_loan_text);

        String input = user_id.getText().toString();
        if (input.length()>0 && isDigitsOnly(input)) {
            Integer id = Integer.parseInt(user_id.getText().toString());

            User user = users.usersearch_by_id(id);
            if (user.getId()>0) {
                List<Book> books = loans.loans(user);
                display_loans.setText("");
                for (Book book : books)
                    display_loans.append(book.print() + "\n");
                user_id.setText("");
            }else{
                Toast.makeText(this,"Invalid ID",
                        Toast.LENGTH_SHORT).show();
                user_id.setText("");
            }

        }else{
            Toast.makeText(this,"Invalid ID",
                    Toast.LENGTH_SHORT).show();
            user_id.setText("");
        }
    }
}
