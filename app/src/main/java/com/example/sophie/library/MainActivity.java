package com.example.sophie.library;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.list_all_users:
                if (checked)
                    listUsers();
                break;
            case R.id.list_all_books:
                if (checked)
                    listBooks();
                break;
            case R.id.user_search:
                if(checked)
                    searchForUser();
                break;
            case R.id.book_search:
                if(checked)
                    searchForBook();
                break;
            case R.id.borrow_book:
                if(checked)
                    borrowBook();
                break;
            case R.id.return_book:
                if(checked)
                    returnBook();
                break;
            case R.id.check_loans:
                if(checked)
                    checkLoans();
                break;
            case R.id.add_user:
                if(checked)
                    addUser();
                break;
            case R.id.remove_user:
                if(checked)
                    removeUser();
                break;
            case R.id.add_book:
                if(checked)
                    addBook();
                break;
            case R.id.remove_book:
                if(checked)
                    removeBook();
                break;
            case R.id.list_books_on_loan:
                if(checked)
                    listBooksOnLoan();
                break;
            case R.id.list_books_not_loaned:
                if(checked)
                    listBooksNotOnLoan();
                break;
            case R.id.list_users_with_loans:
                if(checked)
                    listUsersWithLoans();
                break;
            default:
                //
                break;
        }
    }


    public void listUsers(){
        Intent intent = new Intent(this, ListUsersActivity.class);
        startActivity(intent);
    }

    public void listBooks(){
        Intent intent = new Intent(this, ListBooksActivity.class);
        startActivity(intent);
    }

    public void searchForUser() {
        Intent intent = new Intent(this, SearchUserActivity.class);
        startActivity(intent);
    }

    public void searchForBook() {
        Intent intent = new Intent(this, SearchBookActivity.class);
        startActivity(intent);
    }

    public void borrowBook(){
        Intent intent = new Intent(this, BorrowBookActivity.class);
        startActivity(intent);
    }

    public void returnBook(){
        Intent intent = new Intent(this, ReturnBookActivity.class);
        startActivity(intent);
    }

    public void checkLoans(){
        Intent intent = new Intent(this, CheckLoansActivity.class);
        startActivity(intent);
    }

    public void addUser(){
        Intent intent = new Intent(this, AddUserActivity.class);
        startActivity(intent);
    }

    public void removeUser(){
        Intent intent = new Intent(this, RemoveUserActivity.class);
        startActivity(intent);
    }

    public void addBook(){
        Intent intent = new Intent(this, AddBookActivity.class);
        startActivity(intent);
    }

    public void removeBook(){
        Intent intent = new Intent(this, RemoveBookActivity.class);
        startActivity(intent);
    }

    public void listBooksOnLoan(){
        Intent intent = new Intent(this, ListBooksOnLoanActivity.class);
        startActivity(intent);
    }

    public void listBooksNotOnLoan(){
        Intent intent = new Intent(this, ListBooksNotLoanedActivity.class);
        startActivity(intent);
    }

    public void listUsersWithLoans(){
        Intent intent = new Intent(this, ListUsersWithLoansActivity.class);
        startActivity(intent);
    }

}
