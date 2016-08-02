package com.jacky.jacky.sendsmsmessage;

 import android.app.PendingIntent;
 import android.content.Intent;
 import android.support.v7.app.AppCompatActivity;
 import android.os.Bundle;
 import android.telephony.SmsManager;
 import android.view.View;
 import android.widget.Button;
 import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText editTextReceiver;
    private EditText editTextContent;
    private Button buttonSend;
    private Button buttonCancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextReceiver = (EditText)findViewById(R.id.EditTextReceiver);
        editTextContent = (EditText)findViewById(R.id.EditTextContent);
        buttonSend = (Button)findViewById(R.id.ButtonSend);
        buttonCancel = (Button)findViewById(R.id.ButtonCancel);

        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SmsManager smsManager = SmsManager.getDefault();
                try{
                    smsManager.sendTextMessage(editTextReceiver.getText().toString(),
                            null, editTextContent.getText().toString(),
                            PendingIntent.getBroadcast(getApplicationContext(), 0, new Intent(), 0),
                            null);
                }catch(Exception e){
                    e.printStackTrace();
                };


            }
        });


    }







}

