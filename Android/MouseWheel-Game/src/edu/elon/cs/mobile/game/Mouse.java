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
import com.badlogic.gdx.physics.box2d.MassData;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;

public class Mouse {

	private float x, y;
	private float angle;
	private Bitmap mouse;

	public Body mouseBody;
	
	private Matrix matrix;

	public Mouse(float x, float y, World world, Context context) {
		mouse = BitmapFactory.decodeResource(context.getResources(), R.drawable.gamemouse);

		this.x = x / GameView.SCALE;
		this.y = y / GameView.SCALE;
		this.angle = 0.0f;
		
		// rotation / translation matrix
		matrix = new Matrix();
		
		// box2d
		BodyDef mouseDef = new BodyDef();
		mouseDef.type = BodyType.DynamicBody;
		mouseDef.position.set(this.x, this.y);
		mouseDef.linearDamping = 0.5f;
		mouseDef.angularDamping = 0.5f;
		mouseBody = world.createBody(mouseDef);
		CircleShape mouseShape = new CircleShape();
		float r = (35.0f/GameView.SCALE)/2.0f;
		mouseShape.setRadius(r);
		FixtureDef mouseFix = new FixtureDef();
		mouseFix.shape = mouseShape;
		mouseFix.density = 1.0f;
		mouseFix.friction = 1.0f;
		mouseFix.restitution = 0.5f;
		mouseBody.createFixture(mouseFix);
	}
	
	public void draw(Canvas canvas) {
		float pixelX = x * GameView.SCALE;
		float pixelY = y * GameView.SCALE;			
		matrix.reset();
		matrix.postTranslate(pixelX, pixelY);
		matrix.postRotate(angle, pixelX + mouse.getWidth() / 2.0f, pixelY + mouse.getHeight() / 2.0f);
		
		canvas.drawBitmap(mouse, matrix, null);
	}
	
	public void update(float dif) {
		x = mouseBody.getPosition().x - dif;
		y = mouseBody.getPosition().y;
		angle = mouseBody.getAngle() * 57.295f;
	}
	
	public void update2() {
		x = 13;
		y = mouseBody.getPosition().y;
		angle = mouseBody.getAngle() * 57.295f;
	}

}
