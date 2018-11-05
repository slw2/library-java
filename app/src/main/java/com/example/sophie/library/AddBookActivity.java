package com.example.sophie.library;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AddBookActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_book);
    }

    Books books = new Books(this);

    String title;
    String author;

    public void buttonClicked(View view){

        String book_added = "This book has been added!";

        TextView bookData = findViewById(R.id.display_book_data);
        EditText inputText = findViewById(R.id.add_book);
        String hint = inputText.getHint().toString();

        switch(hint){
            case "Please enter a title":
                title = inputText.getText().toString();
                bookData.setText("Title: " + title + "\n");
                inputText.setText("");
                inputText.setHint("Please enter an author");
                break;
            case "Please enter an author":
                author = inputText.getText().toString();
                bookData.append("Author: " + author + "\n");
                inputText.setText("");
                inputText.setHint("");

                books.add_book(title, author);
                Toast.makeText(this, book_added, Toast.LENGTH_SHORT).show();
                break;
            case "":
                Toast.makeText(this, book_added, Toast.LENGTH_SHORT).show();
        }
    }

}
