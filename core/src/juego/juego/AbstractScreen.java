package juego.juego;

import com.badlogic.gdx.Screen;

//Implementa la interfaz de Screen, es decir, se comportara con las caracteristicas de una pantalla
//sus funciones se llaman automaticamente cuando ocurre el evento al que estan asociadas (renderizar,
//reescalar, pausar, resumir...) menos con dispose, para liberar los recursos hay que llamar a dispose manualmente

public class AbstractScreen implements Screen { // Pantalla abstracta de la cual heredan las demas pantallas.
	protected Main main; // Necesario en el futuro para pasar de una pantalla a otra.

	public AbstractScreen(Main main) {
		this.main = main;
	}

	@Override
	public void render(float delta) { // // M�todo que permite actualizar los valores del juego y dibujar el juego para que lo vea el usuario.
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resize(int width, int height) { // M�todo que sirve para redimensionar la pantalla del juego.
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() { // M�todo que se llama cuando se establece esta pantalla como actual
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() { // M�todo que se llama cuando se deja de usar esta pantalla.
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() { // M�todo que se llama cuando en un dispositivo m�vil perdemos el foco
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() { // M�todo que se llama cuando el juego vuelve a coger el foco en un dispositivo movil
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() { // Metodo que se encarga de destruir los valores del juego y liberar recursos.
		// TODO Auto-generated method stub
		
	}

}
