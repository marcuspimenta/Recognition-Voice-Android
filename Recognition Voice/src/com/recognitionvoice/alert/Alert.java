package com.recognitionvoice.alert;

import android.content.Context;
import android.widget.Toast;

/**
 * 
 * @author Marcus Pimenta
 * @email mvinicius.pimenta@gmail.com
 * @date 08:31:08 03/11/2012
 */
public class Alert {
	
	private Toast toast;
	private Context context;
	
	public Alert(Context context){
		this.context = context;
		this.toast = null;
	}
	
	public void show(String mensagem){
		if(toast != null){
			toast.setText(mensagem);
		}else
			toast = Toast.makeText(context, mensagem, Toast.LENGTH_LONG);
		toast.show();
	}
	
	public void close(){
		if(toast != null)
			toast.cancel();
	}

}