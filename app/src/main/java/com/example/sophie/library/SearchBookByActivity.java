package com.example.sophie.library;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class SearchBookByActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        String message = intent.getStringExtra(SearchBookActivity.EXTRA_MESSAGE);
        setContentView(R.layout.activity_search_book_by);
        EditText editText = findViewById(R.id.enter_book);
        editText.setHint(message);
    }

    Books books = new Books(this);

    public void displayBook(View view) {
        Book book = null;
        List<Book> book_matches = null;
        EditText editText = findViewById(R.id.enter_book);
        Intent intent = getIntent();
        String message = intent.getStringExtra(SearchBookActivity.EXTRA_MESSAGE);
        if (editText != null) {
            switch(message){
                case "Please enter a title":
                    String title = editText.getText().toString();
                    book_matches = books.booksearch_by_title(title);
                    break;
                case "Please enter an author":
                    String author = editText.getText().toString();
                    book_matches = books.booksearch_by_author(author);
                    break;
                case "Please enter an ID number":
                    Integer id = Integer.parseInt(editText.getText().toString());
                    book = books.booksearch_by_id(id);
                    break;
            }
        }

        if (book_matches!=null && !book_matches.isEmpty()){
            TextView display = findViewById(R.id.display_book_text);
            display.setText("");
            for (Book x: book_matches)
                display.append(x.print());
        }

        else if (book!=null && book.getId()>0) {
            String bookData = book.print();

            TextView display = findViewById(R.id.display_book_text);
            display.setText(bookData);
        }
        else{
            Toast.makeText(this,
                    "No books found",
                    Toast.LENGTH_SHORT).show();
        }

        editText.setText("");
    }
}
