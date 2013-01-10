/**
 *  A simple game engine using the Canvas.
 *  
 *  @author J. Hollingsworth
 */

package edu.elon.cs.mobile.game;

import edu.elon.cs.mobile.game.R;
import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.TextView;

public class GameActivity extends Activity {
	private GameView gv;
	private MediaPlayer ourSongs;
	public static boolean musicOn = true;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gameview);
        ourSongs = MediaPlayer.create(GameActivity.this, R.raw.howdoyouwantit);
        gv = (GameView) findViewById(R.id.gameview);
        TextView tv = (TextView) findViewById(R.id.textview);
        
        gv.setTextView(tv);
        if(isMusicOn()) {
        	ourSongs.start();
        }
    }
    
    @Override
    public void onDestroy() {
    	super.onDestroy();
    	gv.onDestroy();
    }
    
    /**
     * Stops the music for level one when the user exits the level
     */
	@Override
	protected void onPause() {
		super.onPause();
		ourSongs.release();
	}
	
	public static void setMusicOn(boolean isMusic) {
		musicOn = isMusic;
	}
	
    public static boolean isMusicOn() {
		return musicOn;
    }
}