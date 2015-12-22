package juego.juego;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class Coche extends CocheAbstracto {
	
	public Coche(float x, float y) {
		super(x,y);
		textura = new Texture(Gdx.files.internal("car5.png"));
		bordes = new Rectangle(x,y, 75, 265);
		
	}
	
	
	public boolean choqueArriba(){
		return bordes.y + Gdx.graphics.getHeight()/3>= 1016;
	}
	
	public boolean choqueAbajo(){
		return bordes.y <= 0;
	}
	
	private boolean choqueIzquierda(){
		return bordes.x  <= 0;
	}
	
	private boolean choqueDerecha(){
		return bordes.x + textura.getWidth()/2 >= 1016;
	}
	
	public void update() {
		if(bordes.y>=1000){
    		bordes.y = 1000;
    	}
		if(bordes.y<=-1000){
			bordes.y=-1000;
		}
		if(Gdx.input.isKeyPressed(Keys.W) && bordes.y!=1000/* && choqueArriba()==false*/){
			bordes.y = bordes.y + 20;
		}
		
		if(Gdx.input.isKeyPressed(Keys.S)   && bordes.y!=-1000/*&& choqueAbajo()==false*/){
			bordes.y = bordes.y - 20;
			
		}
		
		if(Gdx.input.isKeyPressed(Keys.A) && choqueIzquierda()==false){
			bordes.x = bordes.x - 6;
		}
		
		if(Gdx.input.isKeyPressed(Keys.D) && choqueDerecha()==false){
			bordes.x = bordes.x + 6;
		}
		
	}
	
	
	
	
}
