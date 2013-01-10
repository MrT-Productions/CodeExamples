package edu.elon.cs.mobile.game;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class LevelScreen extends Activity{
	private Intent intent;
	/*
	 * Initializes the level button and its listener
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.levelscreen);
		
		Button level1Button = (Button) findViewById(R.id.lev1button);
		level1Button.setOnClickListener(getPlayButtonListener);
		
		Button level2Button = (Button) findViewById(R.id.lev2button);
		level2Button.setOnClickListener(getPlay2ButtonListener);
		
		Button level3Button = (Button) findViewById(R.id.lev3button);
		level3Button.setOnClickListener(getPlay3ButtonListener);
		
		Button optionButton = (Button) findViewById(R.id.optionbutton);
		optionButton.setOnClickListener(getOptionButtonListener);
	}
	
	/* 
	 * Creates the intent
	 */
	public void level1Activity() {
		intent = new Intent(this, GameActivity.class);
		
		startActivityForResult(intent, 9998);
	}
	
	public void level2Activity() {
		intent = new Intent(this, GameActivity2.class);
		
		startActivityForResult(intent, 9998);
	}
	
	public void level3Activity() {
		intent = new Intent(this, GameActivity3.class);
		
		startActivityForResult(intent, 9998);
	}
	
	public void optionActivity(){
		intent = new Intent(this, OptionScreen.class);
		startActivityForResult(intent, 9998);
		System.err.println("finishing levelScreen now");
		finish();
		System.err.println("finished levelScreen now");
	}
	
	private OnClickListener getPlayButtonListener = new OnClickListener(){
		public void onClick(View arg0){
			level1Activity();
		}
	};
	
	private OnClickListener getPlay2ButtonListener = new OnClickListener(){
		public void onClick(View arg0){
			level2Activity();
		}
	};
	
	private OnClickListener getPlay3ButtonListener = new OnClickListener(){
		public void onClick(View arg0){
			level3Activity();
		}
	};
	
	private OnClickListener getOptionButtonListener = new OnClickListener(){
		public void onClick(View arg0){
			optionActivity();
		}
	};

	
}
