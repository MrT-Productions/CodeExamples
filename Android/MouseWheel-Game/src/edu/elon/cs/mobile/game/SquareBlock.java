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
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;

import edu.elon.cs.mobile.game.R;

public class SquareBlock {

	private float x, y;
	private float angle;
	private Bitmap SB;

	public Body SBBody;
	
	private Matrix matrix;

	public SquareBlock(float x, float y, World world, Context context) {
		SB = BitmapFactory.decodeResource(context.getResources(), R.drawable.square);

		this.x = x / GameView.SCALE;
		this.y = y / GameView.SCALE;
		this.angle = 0.0f;
		
		// rotation / translation matrix
		matrix = new Matrix();
		
		// box2d
		BodyDef SBDef = new BodyDef();
		SBDef.type = BodyType.DynamicBody;
		SBDef.position.set(this.x, this.y);
		SBDef.linearDamping = 0.5f;
		SBDef.angularDamping = 0.5f;
		SBBody = world.createBody(SBDef);
		PolygonShape SBShape = new PolygonShape();
		SBShape.setAsBox(1.0f, 1.0f);
		FixtureDef SBFix = new FixtureDef();
		SBFix.shape = SBShape;
		SBFix.density = 1.0f;
		SBFix.friction = 1.0f;
		SBFix.restitution = 0.0f;
		SBBody.createFixture(SBFix);
		MassData SBMass = new MassData();
		SBMass.mass = 1000.0f;
		SBBody.setMassData(SBMass);
	}
	
	public void draw(Canvas canvas) {
		float pixelX = x * GameView.SCALE;
		float pixelY = y * GameView.SCALE;
		matrix.reset();
		matrix.postTranslate(pixelX, pixelY);
		matrix.postRotate(angle, pixelX + SB.getWidth() / 2.0f, pixelY + SB.getHeight() / 2.0f);
		
		canvas.drawBitmap(SB, matrix, null);
	}
	
	public void update() {
		x = SBBody.getPosition().x;
		y = SBBody.getPosition().y;
		angle = SBBody.getAngle() * 57.295f;
	}

}
