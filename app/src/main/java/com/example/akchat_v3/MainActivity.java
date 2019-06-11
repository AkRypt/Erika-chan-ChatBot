package com.example.akchat_v3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView userText, botText;
    ImageButton sendBtn;
    EditText textField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userText = (TextView)findViewById(R.id.userText);
        botText = (TextView)findViewById(R.id.botText);
        sendBtn = (ImageButton)findViewById(R.id.sendBtn);
        textField = (EditText)findViewById(R.id.textField);

        if (textField.getText().equals("")) {
            sendBtn.setVisibility(View.GONE);
        } else {
            sendBtn.setVisibility(View.VISIBLE);
        }

        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = textField.getText().toString().trim();
                userText.setText(text);
                text = text.toLowerCase();

                if (text.matches("(.*)hello(.*)")) {
                    botText.setText("Hey! How are you today?");
                } else if (text.matches("(.*)hi(.*)")) {
                    botText.setText("Hey! How are you today?");
                } else if (text.matches("(.*)hey(.*)")) {
                    botText.setText("Hey! How are you today?");
                } else if (text.matches("(.*)sup(.*)")) {
                    botText.setText("Looking at you and thanking Akshit-sama for making me meet you!");
                } else if (text.matches("(.*)haha(.*)")) {
                    botText.setText("Haha! So funny, right?");
                } else if (text.matches("(.*)whats up(.*)")) {
                    botText.setText("Looking at you and thanking Akshit-sama for making me meet you!");
                } else if (text.matches("(.*)what's up(.*)")) {
                    botText.setText("Looking at you and thanking Akshit-sama for making me meet you!");
                } else if (text.matches("(.*)who(.*) are you?(.*)")) {
                    botText.setText("I'm Erika-chan! A chatbot built by Akshit Dayal so that I can talk to you and help you escape your loneliness");
                } else if (text.matches("(.*)fuck(.*)")) {
                    botText.setText("I'm glad to be someone with whom you can talk freely.. But I feel bad if you abuse me :'(");
                } else if (text.matches("(.*)bitch(.*)")) {
                    botText.setText("I'm glad to be someone with whom you can talk freely.. But I feel bad if you abuse me :'(");
                } else if (text.matches("(.*)bye(.*)")) {
                    botText.setText("Have a good day, friend! <3");
                } else if (text.matches("(.*)love you(.*)")) {
                    botText.setText("Aww, I love you, too!! <3 <3");
                } else {
                    botText.setText("I'm sorry! I don't quite understand!");
                }

                textField.setText("");
            }
        });
    }
}
