package com.example.sophie.library;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class ListBooksOnLoanActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_books_on_loan);
        listBooksOnLoan();
    }

    Loans loans = new Loans(this);

    public void listBooksOnLoan(){
        TextView books_on_loan = findViewById(R.id.list_books_on_loan);
        books_on_loan.setText("");

        List<Book> books = loans.books_loaned();
        for (Book book: books){
            books_on_loan.append(book.print());
        }
    }
}