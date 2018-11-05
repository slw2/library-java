package com.example.sophie.library;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import static android.text.TextUtils.isDigitsOnly;

public class RemoveBookActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remove_book);
    }

    Books books = new Books(this);

    public void buttonClicked(View view){
        EditText input_id = findViewById(R.id.remove_book);
        if (isDigitsOnly(input_id.getText().toString())) {
            Integer id = Integer.parseInt(input_id.getText().toString());

            Book book = books.booksearch_by_id(id);
            if (book.getId() > 0) {
                books.remove_book(book);
                Toast.makeText(this,
                        "Book with ID " + id + " has been removed",
                        Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this,
                        "Book with ID " + id + " does not exist",
                        Toast.LENGTH_SHORT).show();
            }

            input_id.setText("");
            input_id.setHint("Please enter an ID");

        }
        else{
            Toast.makeText(this,
                    "Invalid ID",
                    Toast.LENGTH_SHORT).show();
            input_id.setText("");
        }
    }
}
