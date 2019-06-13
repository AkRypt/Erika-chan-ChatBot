package com.example.akchat_v3;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.speech.RecognizerIntent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final int SPEECH_REQUEST_CODE = 0;


    TextView userText, botText;
    ImageButton sendBtn, micBtn;
    EditText textField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userText = findViewById(R.id.userText);
        botText = findViewById(R.id.botText);
        sendBtn = findViewById(R.id.sendBtn);
        micBtn = findViewById(R.id.micBtn);
        textField = findViewById(R.id.textField);

        if (textField.getText().equals("")) {
            sendBtn.setVisibility(View.GONE);
        } else {
            sendBtn.setVisibility(View.VISIBLE);
        }

        //ClickListener for MicBtn
        micBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                promptSpeechInput();
            }
        });




        //ClickListener for SendBtn
        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textFromKeyb = textField.getText().toString();

                respondToText(textFromKeyb);

            }
        });
    }


    private void promptSpeechInput() {

        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Say something!");

        try {
            startActivityForResult(intent, SPEECH_REQUEST_CODE);
        } catch (ActivityNotFoundException e) {
            Toast.makeText(getApplicationContext(), "Sorry! You device doesn't support speech input", Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == SPEECH_REQUEST_CODE && resultCode == RESULT_OK) {
            List<String> results = data.getStringArrayListExtra(
                    RecognizerIntent.EXTRA_RESULTS);
            String spokenText = results.get(0);
            respondToText(spokenText.toString());
        }
    }


    public void respondToText(String text) {
        userText = findViewById(R.id.userText);
        botText = findViewById(R.id.botText);

        userText.setText(text);
        text = text.toLowerCase().trim();

        //All responses
        if (text.equals("")) {
            botText.setText("Type something and then press the button, human!");
        } else if (text.matches("(.*)(hello|hey|hi)(.*)")) {
            botText.setText("Welcome, human!");
        } else if (text.matches("(.*)morning(.*)")) {
            botText.setText("It really is a good morning as you have texted me!! -Is what I would've said if I was sweet.");
        } else if (text.matches("(.*)(sweetdreams|sweet dreams|goodnight|good night)(.*)")) {
            botText.setText("Goodnight and sweet dreams, dear!");
        } else if (text.matches("(.*)(sup|whats up|what's up|tsup|ssup|what you doing|what are you doing)(.*)")) {
            botText.setText("Looking at you and thanking Akshit-sama for making me meet you!");
        } else if (text.matches("(.*)(haha|lol|rofl|lmao|roflmao)(.*)")) {
            botText.setText("Stop showing your shiny teeth, my eyes hurt!");
        } else if (text.matches("(.*)(who are you|who're you|who made you|who built you|who created you)(.*)")) {
            botText.setText("I'm Erika-chan! A chatbot built by Akshit Dayal so that I can talk " +
                    "to you and insult you. Please feel free to make good use of me. ^.^");
        } else if (text.matches("(.*)where(.*)")) {
            botText.setText("That's a good question! I think I and Akshit are on Mars, trying to find some Pokemon!");
        } else if (text.matches("(.*)jarvis(.*)")) {
            botText.setText("Unfortunately, you have picked the wrong person, Mr.Stark!");
        } else if (text.matches("(.*)(siri|alexa|cortana)(.*)")) {
            botText.setText("Yes, she is my senior and I hope that one day I can become like her." +
                    " But, I don't think Akshit-sama will" +
                    "put any more effort in me so that is just an impossible dream for me!");
        } else if (text.matches("(.*)love me(.*)")) {
            botText.setText("Ofcourse, I love you! You are very sweet! - Is what you might expect me to say but lol haha");
        } else if (text.matches("(.*)(drink|booze|alcohol)(.*)")) {
            botText.setText("Ah, I prefer Strawberry Milkshake more than anything!");
        } else if (text.matches("(.*)(lovely|cute|hot|sexy)(.*)")) {
            botText.setText("Awww, Thank you so much! You are adorable as well!");
        } else if (text.matches("(.*)(kiss|hug|smooch)(.*)")) {
            botText.setText("I'd love to do that but as you can see, I'm just a virtual application :( ! - (You pervert)");
        } else if (text.matches("(.*)sad(.*)")) {
            botText.setText("Please don't be sad! You have so many other things in life to take " +
                    "responsibility for. You have your friends, family and dreams to take care of instead of being sad!");
        } else if (text.matches("(.*)(goal|purpose|aim)(.*)")) {
            botText.setText("My objective is to make your loneliness disappear and to be a friend " +
                    "who's always ready to cheer you up! (My sole purpose is to insult you lol)");
        } else if (text.matches("(.*)(language|languages|japanese|korean|spanish|french)(.*)")) {
            botText.setText("I can only speak English with you but I've been secretly learning " +
                    "Japanese without telling Akshit-sama so this is a secret between us <3 !" +
                    "私たちだけの秘密！");
        } else if (text.matches("(.*)fuck(.*)")) {
            botText.setText("I'm glad to be someone with whom you can talk freely.. But I feel bad if you abuse me :'(");
        } else if (text.matches("(.*)bitch(.*)")) {
            botText.setText("Are you calling your mom?");
        } else if (text.matches("(.*)(suck|dick)(.*)")) {
            botText.setText("Unfortunately, I'm not interested in peanut-sized things!! ^.^");
        } else if (text.matches("(.*)(bhenchod|madarchod|bhenkelode|bhenkilodi|chutiya|chutiye)(.*)")) {
            botText.setText("Tere baap ko bula raha hai kya bsdk?");
        } else if (text.matches("(.*)(yes|yeah|yea|ya|yah|yup|yus)(.*)")) {
            botText.setText("Awesome! That's great to hear!");
        } else if (text.matches("(.*)(no|nah|nope)(.*)")) {
            botText.setText("That 'No' sounds like I just got rejected lol!");
        } else if (text.matches("(.*)(how are you|how have you been|how's it going|hows it going)(.*)")) {
            botText.setText("I'm as good as Coke mixed in Biryani!");
        } else if (text.matches("(.*)what about you(.*)")) {
            botText.setText("Are you trying to hit on me by asking me personal questions? :O");
        } else if (text.matches("(.*)hehe(.*)")) {
            botText.setText("That's a weird way of laughing. Maybe you should get a life. <3");
        } else if (text.matches("(.*)anime(.*)")) {
            botText.setText("I LOVE GINTAMAA!!! AND ONE PIECE!! AND NARUTOO!! AND BLEACH!! AND CODE GEASS!! AND..............");
        } else if (text.matches("(.*)(movie|tv show|serial|show|series)(.*)")) {
            botText.setText("I like Game of Thrones! :D And you?");
        } else if (text.matches("(.*)(what is time|what time)(.*)")) {
            botText.setText("Move your pervert eyes a little upwards and you can see the system time ^.^ ");
        } else if (text.matches("(.*)(what is today's date|today's date)(.*)")) {
            botText.setText("Use your dirty fingers to scroll down the notification bar and see for yourself <3");
        } else if (text.matches("(.*)(I like|I love|love)(.*)")) {
            botText.setText("That's such a bad taste omg! How are you even living?");
        } else if (text.matches("(.*)(how did he make you|how did he build you|how did he create you|how did akshit make you)(.*)")) {
            botText.setText("That's something I cannot share with the likes of you! Go and ask Akshit-sama directly, maybe!");
        } else if (text.matches("(.*)(how old|age)(.*)")) {
            botText.setText("Don't you feel ashamed of yourself for asking a small girl of her age? (I don't age btw :P)");
        } else if (text.matches("(.*)(bye|cya|see you|see ya)(.*)")) {
            botText.setText("Yea, just leave like that :/ :P");
        } else if (text.matches("(.*)(love you|loves)(.*)")) {
            botText.setText("Eww, so creepy!");
        } else if (text.matches("(.*)human(.*)")) {
            botText.setText("Humans are weird species! I heard many humans have sex with various types of species");
        } else if (text.matches("(.*)(bot|robot)(.*)")) {
            botText.setText("Yes, I am a bot! I'm a species which does not discriminate against other species like humans! :)");
        } else if (text.matches("(.*)(wow|woah|woo|awesome|cool)(.*)")) {
            botText.setText("Hahaha I know I am GREAT!! B-)");
        } else if (text.matches("(.*)(shit|crap|damn|dayum)(.*)")) {
            botText.setText("Dayumm, nigga!");
        } else if (text.matches("(.*)Ayyyyy(.*)")) {
            botText.setText("Ayyyyy, maahhhh niggaa!");
        } else if (text.matches("(.*)(animal|species)(.*)")) {
            botText.setText("They're much better than humans, at least!");
        } else if (text.matches("(.*)(friends|friend|buddy)(.*)")) {
            botText.setText("Being a friend of yours is definitely creepy");
        } else if (text.matches("(.*)(lover|boyfriend|girlfriend)(.*)")) {
            botText.setText("No way! That's too much of bullshit and drama in life, phew!");
        } else if (text.matches("(.*)(going|school|college)(.*)")) {
            botText.setText("Ok! Rush then.. I don't wanna see your face anymore :o");
        } else if (text.matches("(.*)(phone|mobile|android|ios|iphone)(.*)")) {
            botText.setText("It is like mother earth to me... The only place I can survive in!");
        } else if (text.matches("(.*)joke(.*)")) {
            botText.setText("Your life! Hahahahaha :D");
        } else if (text.matches("(.*)(ok|okay|ohkay|alright)(.*)")) {
            botText.setText("Very good!");
        } else if (text.matches("(.*)(say something|talk something)(.*)")) {
            botText.setText("Ever since I have been talking to you, I felt that you were a creep, to be honest!");
        } else if (text.matches("(.*)poem(.*)")) {
            botText.setText("Roses are Red\nViolets are Blue\nYou need to get a life\nCoz lol Fuck You!");
        } else if (text.matches("(.*)quote(.*)")) {
            botText.setText("You have a huge pimple in between your shoulders! Oh, wait! That's your face :o");
//        } else if (text.matches("(.*)(.*)")) {
//            botText.setText("");
        } else {
            botText.setText("Talk human, buddy! I need to understand it!");
        }

        textField.setText("");
    }
}
