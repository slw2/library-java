package com.example.sophie.library;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

public class SearchUserActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE =
            "com.example.sophie.library.extra.MESSAGE";

    private String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_user);
    }

    public void onRadioSearchUserClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.user_search_by_firstname:
                if (checked)
                    message = "Please enter a first name";
                    search();
                break;
            case R.id.user_search_by_lastname:
                if(checked)
                    message = "Please enter a last name";
                    search();
                break;
            case R.id.user_search_by_id:
                if(checked)
                    message = "Please enter an ID number";
                    search();
            default:
                //
                break;
        }
    }

    public void search() {
        Intent intent = new Intent(this, SearchUserByActivity.class);
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

}
