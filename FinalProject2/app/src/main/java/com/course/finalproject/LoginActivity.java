package com.course.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    DBHelper openHelper;
    EditText idEt, pwEt;
    SQLiteDatabase db;
    Button loginBtn, registerBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        openHelper = new DBHelper(this);
        db = openHelper.getWritableDatabase();
        idEt = (EditText) findViewById(R.id.editText_ID);
        pwEt = (EditText) findViewById(R.id.editText_PW);
        loginBtn = (Button)findViewById(R.id.login_button);
        registerBtn = (Button) findViewById(R.id.register_button);
        loginBtn.setOnClickListener(listener);
        registerBtn.setOnClickListener(listener);
    }

    View.OnClickListener listener = new View.OnClickListener(){
        public void onClick(View v) {
            switch(v.getId()) {
                case R.id.register_button:
                    startActivity(new Intent(LoginActivity.this, JoinActivity.class));
                    break;
                case R.id.login_button:
                    String id = idEt.getText().toString();
                    String pw = pwEt.getText().toString();
                    Cursor cursor = db.rawQuery("Select * from account where id = ? and password = ?",new String[]{id, pw});
                    while(cursor.moveToNext()) {
                        String no = cursor.getString(0);
                        String rest_id = cursor.getString(1);
                        Log.d("select","no: " + no + "\nrest_id: " + rest_id);
                    }
                    if(cursor.getCount() == 1) {
                        Toast.makeText(LoginActivity.this, id+"님의 방문을 환영합니다", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    }
                    else{
                        Toast.makeText(LoginActivity.this, "가입되지 않은 회원이거나 ID 또는 PW가 잘못되었습니다.", Toast.LENGTH_LONG).show();
                    }
                    cursor.close();
                    break;
            }
        }
    };

}