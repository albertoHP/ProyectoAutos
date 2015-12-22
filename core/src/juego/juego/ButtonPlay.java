package juego.juego;

import javax.swing.JOptionPane;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class ButtonPlay extends Button { // Botón que permitira iniciar el Pong

	public ButtonPlay(int x, int y) {
		super(x, y);
		texture = new Texture(Gdx.files.internal("BotonPlay.png")); // Se asigna textura. Muy importante!!
	}

	@Override
	public void funcionamiento() {
		JOptionPane.showMessageDialog(null, "¡Toma el control!", "¡LET'S PLAY!", JOptionPane.DEFAULT_OPTION,null);
		Screens.juego.setScreen(Screens.GAMESCREEN); // Se asigna la pantalla de juego
	}
}
