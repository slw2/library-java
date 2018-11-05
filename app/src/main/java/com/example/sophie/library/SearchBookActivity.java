package com.example.sophie.library;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

public class SearchBookActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE =
            "com.example.sophie.library.extra.MESSAGE";

    private String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_book);
    }

    public void onRadioSearchBookClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.book_search_by_title:
                if (checked)
                    message = "Please enter a title";
                search();
                break;
            case R.id.book_search_by_author:
                if (checked)
                    message = "Please enter an author";
                search();
                break;
            case R.id.book_search_by_id:
                if (checked)
                    message = "Please enter an ID number";
                search();
            default:
                //
                break;
        }
    }

    public void search() {
        Intent intent = new Intent(this, SearchBookByActivity.class);
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
}
