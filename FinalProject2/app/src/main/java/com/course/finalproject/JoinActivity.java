package com.course.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class JoinActivity extends AppCompatActivity {
    DBHelper openHelper;
    SQLiteDatabase db;
    EditText idEt, pwEt;
    Button joinBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);
        openHelper = new DBHelper(this);
        db = openHelper.getWritableDatabase();
        idEt = (EditText) findViewById(R.id.editTextTextPersonName);
        pwEt = (EditText) findViewById(R.id.editTextTextPersonName2);
        joinBtn = (Button) findViewById(R.id.button);
        joinBtn.setOnClickListener(listener);
    }

    View.OnClickListener listener = new View.OnClickListener(){
        public void onClick(View v) {
            switch(v.getId()) {
                case R.id.button:
                    String id = idEt.getText().toString();
                    String pw = pwEt.getText().toString();
                    Cursor cursor = db.rawQuery("select * from account where id = ?", new String[] {id});

                    if(cursor.getCount() == 1) {
                        Toast.makeText(JoinActivity.this, "이미 존재하는 아이디입니다. 다른 아이디를 입력하세요!", Toast.LENGTH_LONG).show();
                        idEt.setText("");
                        pwEt.setText("");
                    }
                    else{
                        db.execSQL("insert into account(id, password) values(?,?)", new String[]{id,pw});
                        Toast.makeText(JoinActivity.this, "회원가입을 축하합니다! 로그인을 해주세요", Toast.LENGTH_LONG).show();
                        startActivity(new Intent(JoinActivity.this, LoginActivity.class));
                    }
                    cursor.close();
                    break;
            }
        }
    };
}