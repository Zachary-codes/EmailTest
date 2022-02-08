package com.example.emailtest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText Recipient;
    private EditText Subject;
    private EditText MessageBody;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Recipient = findViewById(R.id.Recipient);
        Subject = findViewById(R.id.Subject);
        MessageBody = findViewById(R.id.MessageBody);

        Button ComposeEmail = findViewById(R.id.ComposeEmail);
        ComposeEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMail();
            }
        });
    }

    private void sendMail() {
        String recipientList = Recipient.getText().toString();
        String[]recipients = recipientList.split(",");

        String subject = Subject.getText().toString();
        String message = MessageBody.getText().toString();
        
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL, recipients);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, message);

        intent.setType("message/rfc822");
        startActivity(Intent.createChooser(intent,"Choose an email client"));

    }
}