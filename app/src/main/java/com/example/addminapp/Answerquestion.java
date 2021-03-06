package com.example.addminapp;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Answerquestion extends AppCompatActivity {

    FirebaseDatabase database;
    DatabaseReference reference;
    TextView answercontents;
    TextView title;  //제목
    TextView writer;  //작성자
    TextView contents;   //내용
    String existingtitle;    // 기존제목
    String existingwriter;   //기존작성자
    String existingcontents; //기존내용
    String existinganswercontents; //답변내용


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answerquestion);

        title = (TextView) findViewById(R.id.title1);
        writer = (TextView) findViewById(R.id.writer);
        contents = (TextView) findViewById(R.id.contents);
        answercontents = (TextView) findViewById(R.id.answercontents);
        database=  FirebaseDatabase.getInstance(); // Firebase database 연동
        reference =database.getReference("users");// DB 테이블 연결

        Bundle extras = getIntent().getExtras(); //QuestionList에서 받아온 정보를 가져옴
        if(extras != null){
            existingtitle = extras.getString("title");
            existingwriter = extras.getString("writer");
            existingcontents = extras.getString("contents");
            existinganswercontents=extras.getString("answercontents");

            title.setText(existingtitle);
            writer.setText(existingwriter);
            contents.setText(existingcontents);
            answercontents.setText(existinganswercontents);

        }



    }
}
