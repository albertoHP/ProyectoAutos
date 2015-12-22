package juego.juego;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public class Cochepolicia extends CocheAbstracto {

	public Cochepolicia(float x, float y) {
		super(x, y);
		textura = new Texture(Gdx.files.internal("car6.png"));
		bordes = new Rectangle(x,y, 75, 265);
		// TODO Auto-generated constructor stub
	}
	
	public void update(){
		
		if(bordes.y<=- 2000){
			bordes.y = 2000;
		} else {
			bordes.y = bordes.y - 15;
		}
		
		
	}

}
