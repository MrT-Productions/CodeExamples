package edu.elon.cs.mobile.game;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.MassData;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;

import edu.elon.cs.mobile.game.R;

public class Ramp1 {

	private float x, y;
	private float angle;
	private Bitmap ramp;

	public Body rampBody;
	
	private Matrix matrix;

	public Ramp1(float x, float y, World world, Context context) {
		ramp = BitmapFactory.decodeResource(context.getResources(), R.drawable.ramp1);

		this.x = x / GameView.SCALE;
		this.y = y / GameView.SCALE;
		this.angle = 0.0f;
		
		// rotation / translation matrix
		matrix = new Matrix();
		
		Vector2 A = new Vector2(2.0f, -2.0f);
		Vector2 B = new Vector2(2.0f, 2.0f);
		Vector2 C = new Vector2(-2.0f, 2.0f);
		Vector2[] vertices = new Vector2[3];
		vertices[0] = A;
		vertices[1] = B;
		vertices[2] = C;
		// box2d
		BodyDef rampDef = new BodyDef();
		rampDef.type = BodyType.DynamicBody;
		rampDef.position.set(this.x, this.y);
		rampDef.linearDamping = 0.5f;
		rampDef.angularDamping = 0.5f;
		rampBody = world.createBody(rampDef);
		PolygonShape rampShape = new PolygonShape();
		rampShape.set(vertices);
		FixtureDef rampFix = new FixtureDef();
		rampFix.shape = rampShape;
		rampFix.density = 1.0f;
		rampFix.friction = 1.0f;
		rampFix.restitution = 0.0f;
		rampBody.createFixture(rampFix);
		MassData rampMass = new MassData();
		rampMass.mass = 1000.0f;
		rampBody.setMassData(rampMass);
	}
	
	public void draw(Canvas canvas) {
		float pixelX = x * GameView.SCALE;
		float pixelY = y * GameView.SCALE;
		matrix.reset();
		matrix.postTranslate(pixelX + ramp.getWidth() / 2.0f, pixelY);
		matrix.postRotate(angle, pixelX + ramp.getWidth() / 2.0f, pixelY + ramp.getHeight() / 2.0f);
		
		canvas.drawBitmap(ramp, matrix, null);
	}
	
	public void update(float dif) {
		x = rampBody.getPosition().x- dif;
		y = rampBody.getPosition().y;
		angle = rampBody.getAngle() * 57.295f;
	}

}
