package juego.juego;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public class Limosina extends CocheAbstracto {

	public Limosina(float x, float y) {
		super(x, y);
		// TODO Auto-generated constructor stub
		textura = new Texture(Gdx.files.internal("limo.png"));
		bordes = new Rectangle(x,y,70 , 500);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		if(bordes.y<= -3500){
			bordes.y = 3000;
		} else {
			bordes.y = bordes.y - 15;
		}
	}

}
