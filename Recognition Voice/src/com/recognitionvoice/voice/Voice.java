package com.recognitionvoice.voice;

import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.speech.RecognizerIntent;

/**
 * 
 * @author Marcus Pimenta
 * @email mvinicius.pimenta@gmail.com
 * @date 08:30:52 03/11/2012
 */
public class Voice {
	
	private Intent it;   
	private PackageManager pm;
	  
	public Voice(Context context){
		pm = context.getPackageManager();
		it = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
	}
	
	public boolean recognitionVoice(){
		List<ResolveInfo> activities = pm.queryIntentActivities(it, 0);  
		  
		if (activities.size() != 0) {  
		  return true;
		} else {  
		  return false;
		} 
	}

}