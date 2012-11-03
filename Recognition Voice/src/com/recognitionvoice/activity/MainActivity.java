package com.recognitionvoice.activity;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.View;

import com.recognitionvoice.R;
import com.recognitionvoice.alert.Alert;
import com.recognitionvoice.voice.Voice;

/**
 * 
 * @author Marcus Pimenta
 * @email mvinicius.pimenta@gmail.com
 * @date 08:28:34 03/11/2012
 */
public class MainActivity extends Activity {

	private final int REQUEST_CODE = 1;
    
	private Voice voice;
	private Alert alert;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        alert = new Alert(MainActivity.this);
        voice = new Voice(MainActivity.this);
    }
    
    public void clickButton(View view){
    	switch (view.getId()) {
			case R.id.button:
					startRecognitionVoice();
				break;
		}
    }
    
    public void startRecognitionVoice(){
    	
    	if(voice.recognitionVoice()){
	    	Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);  
	    			  
			intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,  
							RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);  
			  
			intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Speak");  
			  
			startActivityForResult(intent, REQUEST_CODE);
    	}
    }
    
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {  
    	super.onActivityResult(requestCode, resultCode, data);  
	  
    	if (requestCode == REQUEST_CODE && resultCode == RESULT_OK) {  
    		String resultRecognitionVoice = "";
    		
    		ArrayList<String> matches =  data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
    	
    		for (String string : matches) {
    			resultRecognitionVoice += string;
			}
    		
    		alert.show(resultRecognitionVoice);
    	}  
	}  

}