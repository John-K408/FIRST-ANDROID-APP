package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView textView = ((TextView) findViewById(R.id.text));

        //User can tap a button to change the text color of the label.
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //change the text color of the label to yellow if white and vice versa
                if(textView.getCurrentTextColor() == getResources().getColor(R.color.yellowish)){
                    textView.setTextColor(getResources().getColor(R.color.black));
                }
                else{
                    textView.setTextColor(getResources().getColor(R.color.yellowish));
                }
            }
        });

        //User can tap background button to change background color

        findViewById(R.id.changeBackgroundButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ColorDrawable background = (ColorDrawable)findViewById(R.id.parent).getBackground();
                if(background.getColor() == getResources().getColor(R.color.light_purple)){
                    ((View)findViewById(R.id.parent)).setBackgroundColor(getResources().getColor(R.color.kindapink));
                }
                else{
                    ((View)findViewById(R.id.parent)).setBackgroundColor(getResources().getColor(R.color.light_purple));
                }
            }
        });
        
        findViewById(R.id.changeTextButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(textView.getText().toString().contains("Hello from John!")){
                    (textView).setText("Android Is Awesome!");
                }
                else{
                    textView.setText("Hello from John!");
                }

            }
        });

        //User can tap on the background view to reset all views to default settings.

        findViewById(R.id.parent).setOnClickListener(new View.OnClickListener() {
            //Reset the text to "Hello from John!"   @+id/text
            @Override
            public void onClick(View view) {
                (textView).setText("Hello from John!");

                //Reset the color of text to original color
                //Original color : #black
                textView.setTextColor(getResources().getColor((R.color.black)));

                //Reset background to original color @+id/parent
                //Original color: : light_purple
                ((View)findViewById(R.id.parent)).setBackgroundColor(getResources().getColor(R.color.light_purple));

            }
        });


        //User can tap the “Change text string” button to update the label with the text from the text field.

        findViewById(R.id.changeCustomTextButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String userInput = ((EditText)findViewById(R.id.editText)).getText().toString();
                //change text view to what's in the editText View as long as something has
                //been typed into it
                if(userInput.isEmpty()){
                    // If the text field is empty, update label with default text string
                    textView.setText("Enter your own text!");

                }
                else{
                    textView.setText(userInput);
                }
            }
        });

    }
}