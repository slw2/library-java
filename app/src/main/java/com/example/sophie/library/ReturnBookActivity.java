package com.example.sophie.library;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import static android.text.TextUtils.isDigitsOnly;

public class ReturnBookActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_return_book);
    }

    Loans loans = new Loans(this);
    Books books = new Books(this);

    public void buttonClicked(View view) {
        EditText input = findViewById(R.id.return_book);

        if (isDigitsOnly(input.getText().toString())) {
            Integer book_id = Integer.parseInt(input.getText().toString());
            Book book = books.booksearch_by_id(book_id);
            if (book.getId() > 0) {
                loans.return_book(book);
                Toast.makeText(this, "This book has been returned",
                        Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Book with ID " + book_id + " does not exist",
                        Toast.LENGTH_SHORT).show();
            }
            input.setText("");
        }
        else {
            Toast.makeText(this, "Invalid ID",
                    Toast.LENGTH_SHORT).show();
            input.setText("");
        }
    }
}