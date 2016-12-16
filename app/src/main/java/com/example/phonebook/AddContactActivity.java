package com.example.phonebook;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.phonebook.DB.DatabaseHelper;

public class AddContactActivity extends AppCompatActivity {

    private EditText mNameEditText,mPhoneEditText;
    private Button mSaveButton;
    private DatabaseHelper mHelper;
    private SQLiteDatabase mDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);

        mHelper = new DatabaseHelper(this);
        mDb = mHelper.getWritableDatabase();

        mNameEditText = (EditText)findViewById(R.id.name_edit_text);
        mPhoneEditText = (EditText)findViewById(R.id.phone_edit_text);
        mSaveButton = (Button)findViewById(R.id.save_button);

        mSaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = mNameEditText.getText().toString();
                String phone = mPhoneEditText.getText().toString();

                ContentValues cv = new ContentValues();
                cv.put(DatabaseHelper.COL_NAME, name);
                cv.put(DatabaseHelper.COL_PHONE, phone);
                cv.put(DatabaseHelper.COL_IMAGE, "ic_ios.jpg");

                mDb.insert(DatabaseHelper.TABLE_NAME, null, cv);
                finish();
            }
        });
    }
}
