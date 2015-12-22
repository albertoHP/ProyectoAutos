package juego.juego;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public class Camion extends CocheAbstracto {

	public Camion(float x, float y) {
		super(x, y);
		textura = new Texture(Gdx.files.internal("spr_truck_0.png"));
		bordes = new Rectangle(x,y,80,700);
		
		// TODO Auto-generated constructor stub
	}
	
	public void update(){
		if(bordes.y==-4000){
			bordes.y = 2000;
		} else {
			bordes.y = bordes.y - 10;
		}
		
		
	}

}
