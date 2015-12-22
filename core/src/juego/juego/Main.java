package juego.juego;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Main extends Game {
	private SpriteBatch batch; // "Grupo de Sprites (imagenes)" nos permite dibujar rectagulos como referencias a texturas, es necesario para mostrar todo por pantalla.

	@Override
	public void create () { // Método que se llama cuando se ejecuta el juego
		batch = new SpriteBatch();
		Gdx.input.setCatchBackKey(true); // Bloquea el boton "Back" de android para que se tenga que salir del juego usando el boton "Exit"
		Screens.juego = this;
		Screens.GAMESCREEN = new GameScreen(this); // Se inicializan las pantallas
		Screens.MAINSCREEN = new MainScreen(this);
		setScreen(Screens.MAINSCREEN); // Establecemos MAINSCREEN como nuestra pantalla principal
	}
	
	@Override
	public void dispose() { // Método para eliminar recursos.
		batch.dispose();
		Screens.GAMESCREEN.dispose();
	}
	
	public SpriteBatch getBatch() {
		return batch;
	}
}
