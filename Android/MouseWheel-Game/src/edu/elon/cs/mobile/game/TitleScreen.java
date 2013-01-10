package edu.elon.cs.mobile.game;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class TitleScreen extends Activity{
	private Intent intent;
	/*
	 * Initializes the play button and its listener
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		Button playButton = (Button) findViewById(R.id.playbutton);
		playButton.setOnClickListener(getPlayButtonListener);
	}
	
	/* 
	 * Creates the intent
	 */
	public void startActivity() {
		intent = new Intent(this, LevelScreen.class);
		
		startActivityForResult(intent, 9999);
	}
	
	private OnClickListener getPlayButtonListener = new OnClickListener(){
		public void onClick(View arg0){
			startActivity();
		}
	};

	
}
