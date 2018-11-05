package com.example.sophie.library;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class ListBooksActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_books);
        listBooks();
    }

    Books books = new Books(this);

    public void listBooks(){
        TextView bookList = findViewById(R.id.list_books);
        bookList.setText("");

        List<Book> all_books = books.books();
        for (Book book: all_books){
            String bookData = book.print();
            bookList.append(bookData);
        }
    }
}
