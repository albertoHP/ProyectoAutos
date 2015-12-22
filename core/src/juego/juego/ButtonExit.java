package juego.juego;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class ButtonExit extends Button { // Bot�n que permitir� salir del juego

	public ButtonExit(int x, int y) {
		super(x, y);
		texture = new Texture(Gdx.files.internal("BotonExit.png")); // Se asigna textura. Muy importante!!
	}

	@Override
	public void funcionamiento() {
		Gdx.app.exit(); // Cierra la aplicaci�n
	}
}
