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

public class Luma {

	private float x, y;
	private float angle;
	private Bitmap luma;

	public Body lumaBody;
	
	private Matrix matrix;

	public Luma(float x, float y, World world, Context context) {
		luma = BitmapFactory.decodeResource(context.getResources(), R.drawable.gamemouse);

		this.x = x / GameView.SCALE;
		this.y = y / GameView.SCALE;
		this.angle = 0.0f;
		
		// rotation / translation matrix
		matrix = new Matrix();
		
		// box2d
		BodyDef lumaDef = new BodyDef();
		lumaDef.type = BodyType.DynamicBody;
		lumaDef.position.set(this.x, this.y);
		lumaDef.linearDamping = 0.5f;
		lumaDef.angularDamping = 0.5f;
		lumaBody = world.createBody(lumaDef);
		CircleShape lumaShape = new CircleShape();
		float r = (35.0f/GameView.SCALE)/2.0f;
		lumaShape.setRadius(r);
		FixtureDef lumaFix = new FixtureDef();
		lumaFix.shape = lumaShape;
		lumaFix.density = 1.0f;
		lumaFix.friction = 1.0f;
		lumaFix.restitution = 0.5f;
		lumaBody.createFixture(lumaFix);
	}
	
	public void draw(Canvas canvas) {
		float pixelX = x * GameView.SCALE;
		float pixelY = y * GameView.SCALE;			
		matrix.reset();
		matrix.postTranslate(pixelX, pixelY);
		matrix.postRotate(angle, pixelX + luma.getWidth() / 2.0f, pixelY + luma.getHeight() / 2.0f);
		
		canvas.drawBitmap(luma, matrix, null);
	}
	
	public void update() {
		x = lumaBody.getPosition().x;
		y = lumaBody.getPosition().y;
		angle = lumaBody.getAngle() * 57.295f;
	}

}
