package juego.juego;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public abstract class CocheAbstracto {
	protected Texture textura;
	protected Rectangle bordes;
	
	
	public CocheAbstracto(float x, float y) {
		textura = new Texture(Gdx.files.internal("car5.png"));
		bordes = new Rectangle(x,y,textura.getWidth(),textura.getHeight());
		
	}
	
	
	
	public Rectangle getBordes(){
		return bordes;
	}
	
	public void draw(SpriteBatch batch, int a, int b){
		batch.draw(textura, bordes.x, bordes.y, a, b);
	}
	
	public abstract void update();
	
}
