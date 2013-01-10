/**
 *  A simple game engine using the Canvas.
 *  
 *  @author J. Hollingsworth
 */

package edu.elon.cs.mobile.game;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Contact;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Display;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class GameView3 extends SurfaceView implements SurfaceHolder.Callback, ContactListener {

	private SurfaceHolder surfaceHolder;
	private TextView text;

	private GameThread thread;
	private float xaxis;
	private float yaxis;

	private World world;
	public static final float SCALE = 32.0f;
	public Mouse mouse;
	public Cheese cheese;
	public SquareBlock roadBlock;
	public Ramp1 ramp;
	private int sWidth;
	private int sHeight;
	private SensorManager sensorMgr;
	private boolean ableToJump = false;
	private Bitmap fullBackground;
	private Matrix backMatrix;
	private boolean levelComplete;
	//private Rect src;
	//private Rect dst;
	Toast LevelCompleteToast;
	Toast CompleteTextToast;
	LevelScreen levels;
	private float newx=0;
	private float newy=0;
	private BodyDef wall1BodyDef = new BodyDef();
	private BodyDef wall2BodyDef = new BodyDef();
	
	private CopyOnWriteArrayList<Mouse> mice;

	
	public GameView3(Context context, AttributeSet attrs) {
		super(context, attrs);
		sensorMgr = (SensorManager) getContext().getSystemService(Context.SENSOR_SERVICE);
		sensorMgr.registerListener(accelListener, 
				sensorMgr.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
				SensorManager.SENSOR_DELAY_FASTEST);
		
		fullBackground = BitmapFactory.decodeResource(context.getResources(), R.drawable.level2temp);
		backMatrix = new Matrix();
		
		//creates levelscreen to be moved to
		levels = new LevelScreen();

		//Creates the Level Completion Toast
		LevelCompleteToast = new Toast(getContext());
		CompleteTextToast = new Toast(getContext());
		LinearLayout toastLayout = new LinearLayout(getContext());
		LinearLayout toastLayout2 = new LinearLayout(getContext());
		toastLayout.setOrientation(LinearLayout.HORIZONTAL);
		toastLayout2.setOrientation(LinearLayout.HORIZONTAL);
		ImageView image = new ImageView(getContext());
		TextView toastText = new TextView(getContext());
		image.setImageResource(R.drawable.mouseandcheese);
		toastText.setText("Level 3 Complete ");
		toastLayout.addView(image);
		toastLayout2.addView(toastText);
		LevelCompleteToast.setView(toastLayout);
		CompleteTextToast.setView(toastLayout2);
		LevelCompleteToast.setDuration(2000);
		CompleteTextToast.setDuration(2000);
		
		// want to hear about changes to our surface
		surfaceHolder = getHolder();
		surfaceHolder.addCallback(this);
		
		WindowManager wm = (WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE);
		Display display = wm.getDefaultDisplay();
		sHeight=display.getHeight();
		sWidth=display.getWidth();
		//src = new Rect(0, 0, sWidth, sHeight - 1);
		//dst = new Rect(0, 1, sWidth, sHeight);
//		fullBackground = Bitmap.createScaledBitmap(fullBackground, sWidth, sHeight, false);
		
		// sprites
		mice = new CopyOnWriteArrayList<Mouse>();
		
		// box2d
		Vector2 gravity = new Vector2(0.0f, 20.0f);
		world = new World(gravity, true);
		world.setContactListener(this);
		
		// this sets the ground
		BodyDef groundBodyDef = new BodyDef();
		groundBodyDef.position.set(new Vector2(0.0f, display.getHeight() / (SCALE + 3.0f)));
		Body groundBody = world.createBody(groundBodyDef);
		PolygonShape groundShapeDef = new PolygonShape();
		groundShapeDef.setAsBox(display.getWidth() / SCALE, 0.0f);
		FixtureDef groundFix = new FixtureDef();
		groundFix.shape = groundShapeDef;
		//make ground non-bouncy
		groundFix.restitution = 0.0f;
		groundBody.createFixture(groundShapeDef, 0.0f);
		
		// this sets the ceiling
				BodyDef ceilingBodyDef = new BodyDef();
				ceilingBodyDef.position.set(new Vector2(0.0f, 0.0f));
				Body ceilingBody = world.createBody(ceilingBodyDef);
				PolygonShape ceilingShapeDef = new PolygonShape();
				ceilingShapeDef.setAsBox(display.getWidth() / SCALE, 0.0f);
				FixtureDef ceilingFix = new FixtureDef();
				ceilingFix.shape = ceilingShapeDef;
				//make ceiling non-bouncy
				ceilingFix.restitution = 0.0f;
				ceilingBody.createFixture(ceilingShapeDef, 0.0f);
		
		//left wall
		
		wall1BodyDef.position.set(new Vector2(0.0f, 0.0f));
		Body wall1Body = world.createBody(wall1BodyDef);
		PolygonShape wall1ShapeDef = new PolygonShape();
		wall1ShapeDef.setAsBox(0.0f, display.getHeight() / SCALE);
		FixtureDef wall1Fix = new FixtureDef();
		wall1Fix.shape = wall1ShapeDef;
		//make wall1 non-bouncy
		wall1Fix.restitution = 0.0f;
		wall1Body.createFixture(wall1ShapeDef, 0.0f);
		
		//right wall
				
				wall2BodyDef.position.set(new Vector2(display.getWidth() / SCALE, 0.0f));
				Body wall2Body = world.createBody(wall2BodyDef);
				PolygonShape wall2ShapeDef = new PolygonShape();
				wall2ShapeDef.setAsBox(0.0f, display.getHeight() / SCALE);
				FixtureDef wall2Fix = new FixtureDef();
				wall2Fix.shape = wall2ShapeDef;
				//make wall2 non-bouncy
				wall2Fix.restitution = 0.0f;
				wall2Body.createFixture(wall2ShapeDef, 0.0f);
		
		mouse = new Mouse(50,sHeight-150, world, getContext());
		cheese = new Cheese(sWidth - 50, sHeight - 50 , world, getContext());
		//box, currently disabled
		//roadBlock = new SquareBlock(500,sHeight/SCALE,world,getContext());
		//ramp = new Ramp1(500,100,world,getContext());

		// thread
		thread = new GameThread(new Handler() {
			public void handleMessage(Message m) {
				text.setText(m.getData().getString("text"));
			}
		});
		
	}
	
	public void onDestroy() {
		fullBackground = null;
		sensorMgr.unregisterListener(accelListener);
		world.dispose();
	}
	
	
	SensorEventListener accelListener = new SensorEventListener(){

		public void onAccuracyChanged(Sensor sensor, int accuracy) {
			
		}

		public void onSensorChanged(SensorEvent event) {
			if(event.sensor.getType() == Sensor.TYPE_ACCELEROMETER){
				xaxis=event.values[1];
				if(xaxis<0.25f && xaxis>-0.25f){
					xaxis=0;
				}
				if(xaxis>5.0f){
					xaxis=5.0f;
				}
				else if(xaxis<-5.0f){
					xaxis=-5.0f;
				}
				xaxis*=50;
				Vector2 move = new Vector2(xaxis/15.0f, 0.0f);
				Vector2 pushPoint = mouse.mouseBody.getPosition();
				pushPoint.y = pushPoint.y-((35.0f/GameView3.SCALE)/4.0f);
				mouse.mouseBody.applyForce(move, pushPoint);
			}
		}
    };
	

	public void setTextView(TextView tv) {
		this.text = tv;
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		//applyForce is used to apply force
		
		
		if (event.getAction() == MotionEvent.ACTION_UP) {
			if(ableToJump==true){
				Vector2 jump = new Vector2(0.0f, -800.0f);
				mouse.mouseBody.applyForce(jump, mouse.mouseBody.getPosition());
			}
		}
		/*
		if (event.getAction() == MotionEvent.ACTION_DOWN) {
			Vector2 move = null;
			if(event.getX()>sWidth/2){
				move = new Vector2(1000.0f, 0.0f);
			}
			if(event.getX()<sWidth/2){
				move = new Vector2(-1000.0f, 0.0f);
			}
			Vector2 pushPoint = lume.lumaBody.getPosition();
			pushPoint.y = pushPoint.y-.8f;
			lume.lumaBody.applyForce(move, pushPoint);
		}
		*/
		
		return true;
	}

	//IGNORE, keys don't work
	/*
	public boolean onKey(View v, int keyCode, KeyEvent event){
		if(keyCode == KeyEvent.KEYCODE_D){
			Vector2 move = new Vector2(1000.0f, 0.0f);
			Vector2 pushPoint = lume.lumaBody.getPosition();
			pushPoint.y = pushPoint.y-.8f;
			lume.lumaBody.applyForce(move, pushPoint);
		}
		if(keyCode == KeyEvent.KEYCODE_S){
			Vector2 move = new Vector2(-1000.0f, 0.0f);
			Vector2 pushPoint = lume.lumaBody.getPosition();
			pushPoint.y = pushPoint.y-.8f;
			lume.lumaBody.applyForce(move, pushPoint);
		}
		
		return true;
		
	}*/

	/** GameView.GameThread **/
	private class GameThread extends Thread {

		private Handler msgHandler;

		private boolean isRunning;
		private long lastTime;

		// computing FPS
		private long nextUpdate;
		private int frames;

		public GameThread(Handler handler) {

			
			isRunning = false;

			// message handler
			msgHandler = handler;

			// computing FPS
			nextUpdate = System.currentTimeMillis() + 1000;
			frames = 0;
		}

		@Override
		public void run() {

			// 100ms lead-in time
			lastTime = System.currentTimeMillis() + 100;

			// main loop
			while (isRunning) {
				Canvas canvas = null;
				try {
					canvas = surfaceHolder.lockCanvas();
					synchronized (surfaceHolder) {
						// get the time
						long now = System.currentTimeMillis();
						double elapsed = (now - lastTime) / 1000.0;
						lastTime = now;

						// update the objects
						updatePhysics(elapsed);
						updateFPS(now);

						// draw the screen
						doDraw(canvas);
//						checkWin();
					}
				} finally {
					if (canvas != null) {
						surfaceHolder.unlockCanvasAndPost(canvas);
					}
				}
			}
		}

		//added new items to update and draw
		private void doDraw(Canvas canvas) {
//			background.prepareToDraw();
			backMatrix.reset();
			System.err.println("Mouse Pos: "+mouse.mouseBody.getPosition().x);
			System.err.println("Mouse velocity: "+mouse.mouseBody.getLinearVelocity().x);
			System.err.println("Cheese Pos: "+cheese.cheeseBody.getPosition().x);
			//System.err.println("sWidth Pos: "+sWidth/2);
			if(mouse.mouseBody.getPosition().x > 13){
				System.err.println("DOING IT");
				//System.err.println("Mouse Pos: "+mouse.mouseBody.getPosition().x);
				//System.err.println("sWidth Pos: "+sWidth/2);
				newx = newx - mouse.mouseBody.getLinearVelocity().x;				
			}
			backMatrix.setTranslate(newx, 1);
			//backMatrix.preTranslate((newx * SCALE), (newy * SCALE));
			
			//backMatrix.postTranslate((newx) * SCALE , (newy) * SCALE);
			//src = dst;
			//dst = new Rect(src.left + 1, src.top, src.right + 1, src.bottom);
			//backMatrix.mapRect(dst, src);
			//canvas.drawBitmap(background, src, dst, null);
			canvas.drawBitmap(fullBackground, backMatrix, null);
			for (Mouse m : mice) {
				m.draw(canvas);
			}
			mouse.draw(canvas);
			cheese.draw(canvas);
			//roadBlock.draw(canvas);
			//ramp.draw(canvas);
		}

		private void updatePhysics(double elapsed) {
			
			world.step((float)elapsed, 6, 2);
			/*for (Mouse m : mice) {
				m.update(mouse.mouseBody.getLinearVelocity().x);
			}*/
			
			//roadBlock.update();
			if(mouse.mouseBody.getPosition().x > 13){
				cheese.update(mouse.mouseBody.getLinearVelocity().x);
				mouse.update2();
//				mouse.update(mouse.mouseBody.getLinearVelocity().x);
//				ramp.update(mouse.mouseBody.getLinearVelocity().x);
//				wall1BodyDef.position.set(wall1BodyDef.position.x-mouse.mouseBody.getLinearVelocity().x, wall1BodyDef.position.y);
//				wall2BodyDef.position.set(wall2BodyDef.position.x-mouse.mouseBody.getLinearVelocity().x, wall2BodyDef.position.y);
			}
			else{
				mouse.update(0);
				//ramp.update(0);
				cheese.update(0);
			}
		}

		private void updateFPS(long now) {
			// update FPS
			float fps = 0.0f;
			++frames;
			float overtime = now - nextUpdate;
			if (overtime > 0) {
				fps = frames / (1 + overtime/1000.0f);
				frames = 0;
				nextUpdate = System.currentTimeMillis() + 1000;

				Message msg = msgHandler.obtainMessage();
				Bundle b = new Bundle();
				b.putString("text", "fps: " + (int)fps);
				msg.setData(b);
				//msgHandler.sendMessage(msg);
			}
		}
		
		/*public void checkWin(){
			if(mouse.mouseBody.getPosition().x>cheese.cheeseBody.getPosition().x-cheese.cheeseShape.getRadius() && mouse.mouseBody.getPosition().x<cheese.cheeseBody.getPosition().x+cheese.cheeseShape.getRadius() && 
				mouse.mouseBody.getPosition().y>cheese.cheeseBody.getPosition().y-cheese.cheeseShape.getRadius() && mouse.mouseBody.getPosition().y<cheese.cheeseBody.getPosition().y+cheese.cheeseShape.getRadius()){
			System.err.println("LOL");
			}
		}*/

		public void setRunning(boolean b) {
			isRunning = b;
		}

	}


	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		thread.setRunning(true);
		thread.start();
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		boolean retry = true;
		thread.setRunning(false);
		while (retry) {
			try {
				thread.join();
				retry = false;
			}
			catch (InterruptedException ex) { 
			}
		}
	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {}

	
	@Override
	public void beginContact(Contact contact) {
		//System.out.println("It ran");
		ableToJump = false;
		if(contact.isTouching()==true){
			ArrayList<Fixture> mouseFix = mouse.mouseBody.getFixtureList();
			ArrayList<Fixture> cheeseFix = cheese.cheeseBody.getFixtureList();
			for(int i =0 ; i < mouseFix.size(); i++){
				for(int j=0; j<cheeseFix.size(); j++){
					if(contact.getFixtureA() == mouseFix.get(i)){
						ableToJump = true;
						if(contact.getFixtureB() == cheeseFix.get(j)) {
							sensorMgr.unregisterListener(accelListener);
							LevelCompleteToast.show();
							CompleteTextToast.show();
							//System.err.println("A to B");
							levelComplete = true;
							ableToJump = false;
							try {
								thread.sleep(4000);
							} catch (Exception e) {
								System.err.println("error waiting");
								e.printStackTrace();
							}
							LevelCompleteToast.cancel();
							CompleteTextToast.cancel();
						    ((GameActivity3)getContext()).finish();
						}
					} else if(contact.getFixtureB() == mouseFix.get(i)){
						ableToJump = true;
						if(contact.getFixtureA() == cheeseFix.get(j)) {
							sensorMgr.unregisterListener(accelListener);
							LevelCompleteToast.show();
							CompleteTextToast.show();
							//System.err.println("B to A");
							levelComplete = true;
							ableToJump = false;
							try {
								thread.sleep(4000);
							} catch (Exception e) {
								System.err.println("error waiting");
								e.printStackTrace();
							}
							LevelCompleteToast.cancel();
							CompleteTextToast.cancel();
						    ((GameActivity3)getContext()).finish();
						}
					}
				}
			}
		}
	}

	@Override
	public void endContact(Contact contact) {
		ableToJump = false;
		
	}


}




