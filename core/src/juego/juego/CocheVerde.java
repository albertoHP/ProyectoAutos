package juego.juego;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public class CocheVerde extends CocheAbstracto {

	public CocheVerde(float x, float y) {
		super(x, y);
		// TODO Auto-generated constructor stub
		textura = new Texture(Gdx.files.internal("car2.png"));
		bordes = new Rectangle(x,y, 75, 265);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
		if(bordes.y<=- 2500){
			bordes.y = 4000;
		} else {
			bordes.y = bordes.y - 20;
		}
		

	}

}
