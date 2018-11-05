package com.example.sophie.library;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import static android.text.TextUtils.isDigitsOnly;

public class BorrowBookActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_borrow_book);
    }

    Users users = new Users(this);
    Books books = new Books(this);
    Loans loans = new Loans(this);
    User user = new User();
    Book book = new Book();

    @SuppressLint("SetTextI18n")
    public void buttonClicked(View view){

        String book_borrowed = "Book successfully borrowed";

        Button borrow_button = findViewById(R.id.borrow_book_button);
        TextView loanData = findViewById(R.id.display_loan_data);
        EditText inputText = findViewById(R.id.borrow_book);
        String hint = inputText.getHint().toString();

        String input = inputText.getText().toString();
        if (input.length()>0 && isDigitsOnly(input)) {
            switch (hint) {
                case "Please enter your user ID":
                    Integer user_id = Integer.parseInt(inputText.getText().toString());
                    user = users.usersearch_by_id(user_id);
                    if (user.getId() != 0) {
                        String userData = user.getFirst_name() + " " + user.getLast_name() + "\n";
                        loanData.setText(userData);
                        inputText.setText("");
                        inputText.setHint("Please enter a book ID");
                        borrow_button.setText(R.string.borrow);
                        break;
                    } else {
                        Toast.makeText(this, "Invalid ID", Toast.LENGTH_SHORT).show();
                        break;
                    }
                case "Please enter a book ID":
                    Integer book_id = Integer.parseInt(inputText.getText().toString());
                    book = books.booksearch_by_id(book_id);
                    if (book.getId() != 0) {
                        loanData.append(book.getTitle() + "\n");
                        inputText.setText("");
                        inputText.setHint("Please enter your user ID");

                        if (loans.is_book_on_loan(book_id)) {
                            Toast.makeText(this, "Book already on loan", Toast.LENGTH_SHORT).show();
                            break;
                        } else {
                            loans.borrow(book, user);
                            Toast.makeText(this, book_borrowed, Toast.LENGTH_SHORT).show();
                            break;
                        }
                    } else {
                        Toast.makeText(this, "Invalid ID", Toast.LENGTH_SHORT).show();
                        break;
                    }
                case "":
                    break;
            }
        }
        else{
            Toast.makeText(this, "Invalid ID", Toast.LENGTH_SHORT).show();
        }
    }

}
