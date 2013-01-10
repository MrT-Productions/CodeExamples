package edu.elon.cs.mobile.game;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
import android.widget.ToggleButton;

public class OptionScreen extends Activity {
	private Intent intent;
	//private Button toggleButton;
	public boolean musicOn;

	// private GameActivity2 ga2 = new GameActivity2();
	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.optionscreen);

		//toggleButton = (Button) findViewById(R.id.toggleButton);
		//toggleButton.setOnClickListener(getToggleButtonListener);
		final ToggleButton toggleMusic = (ToggleButton) findViewById(R.id.toggleButton);
		toggleMusic.toggle();
		GameActivity.setMusicOn(true);
		GameActivity2.setMusicOn(true);
		GameActivity3.setMusicOn(true);
		toggleMusic.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if(toggleMusic.isChecked()) {
					//Toast.makeText(OptionScreen.this, "Music ON", Toast.LENGTH_SHORT).show();
					GameActivity.setMusicOn(true);
					GameActivity2.setMusicOn(true);
					GameActivity3.setMusicOn(true);
				} else {
					//Toast.makeText(OptionScreen.this, "Music OFF", Toast.LENGTH_SHORT).show();
					GameActivity.setMusicOn(false);
					GameActivity2.setMusicOn(false);
					GameActivity3.setMusicOn(false);
				}	
			}
		});
		
		
		Button save = (Button)findViewById(R.id.saveSettings);
		save.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent levelScreen = new Intent(OptionScreen.this, LevelScreen.class);
				startActivity(levelScreen);
				Toast.makeText(OptionScreen.this, "Options Saved", Toast.LENGTH_SHORT).show();
				finish();
				System.err.println("finished option screen");
			}
			
		});
	}

	/*
	 * Creates the intent
	 */
	public void levelscreenActivity() {
		intent = new Intent(this, LevelScreen.class);

		startActivityForResult(intent, 9998);
	}

	//private OnClickListener getToggleButtonListener = new OnClickListener() {
	//	public void onClick(View arg0) {
			// work with turning music playback on or off
	//		System.err.println("tg button value: "
	//				+ toggleButton.getText().toString());
	//		if (toggleButton.getText().toString().equals("ON")) {
	//			musicOn = true;
	//		} else {
	//			musicOn = false;
	//		}
	//	}
	//};

	@Override
	protected void onPause() {
		super.onPause();
		//if (toggleButton.getText().toString().equals("ON")) {
		//	musicOn = true;
		//} else {
		//	musicOn = false;

	}
}
