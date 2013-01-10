package edu.elon.cs.mobile.game;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;

public class Cheese {

	private float x, y;
	private float angle;
	private Bitmap cheese;

	public Body cheeseBody;
	public CircleShape cheeseShape;
	
	private Matrix matrix;

	public Cheese(float x, float y, World world, Context context) {
		cheese = BitmapFactory.decodeResource(context.getResources(), R.drawable.cheese);

		this.x = x / GameView.SCALE;
		this.y = y / GameView.SCALE;
		this.angle = 0.0f;
		
		// rotation / translation matrix
		matrix = new Matrix();
		
		// box2d
		BodyDef cheeseDef = new BodyDef();
		//cheeseDef.type = BodyType.DynamicBody;
		cheeseDef.type = BodyType.StaticBody;
		cheeseDef.position.set(this.x, this.y);
		cheeseDef.linearDamping = 0.5f;
		cheeseDef.angularDamping = 0.5f;
		cheeseBody = world.createBody(cheeseDef);
		cheeseShape = new CircleShape();
		float r = (35.0f/GameView.SCALE)/2.0f;
		cheeseShape.setRadius(r);
		FixtureDef cheeseFix = new FixtureDef();
		cheeseFix.shape = cheeseShape;
		cheeseFix.density = 1.0f;
		cheeseFix.friction = 1.0f;
		cheeseFix.restitution = 0.5f;
		cheeseBody.createFixture(cheeseFix);
	}
	
	public void draw(Canvas canvas) {
		float pixelX = x * GameView.SCALE;
		float pixelY = y * GameView.SCALE;			
		matrix.reset();
		matrix.postTranslate(pixelX, pixelY);
		matrix.postRotate(angle, pixelX + cheese.getWidth() / 2.0f, pixelY + cheese.getHeight() / 2.0f);
		
		canvas.drawBitmap(cheese, matrix, null);
	}
	
	public void update(float dif) {
		x = cheeseBody.getPosition().x - dif;
		y = cheeseBody.getPosition().y;
		angle = cheeseBody.getAngle() * 57.295f;
	}

}
