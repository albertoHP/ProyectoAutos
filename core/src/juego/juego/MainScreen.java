package juego.juego;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MainScreen extends AbstractScreen { // Pantalla del menú principal del juego.
	public SpriteBatch batch; // "Grupo de Sprites (imagenes)" nos permite dibujar rectagulos como referencias a texturas, es necesario para mostrar todo por pantalla.
	private Button exit;
	private Button play;
	private FondoAnimado fondo;
	private Music musica;
	private CocheAbstracto coche, camion, ambulancia;

	public MainScreen(Main main) {
		super(main);
	}
	
	@Override
	public void show() { // Método que se llama cuando se establece esta pantalla como actual
		//batch = main.getBatch();
		batch = new SpriteBatch();
;		Texture texture = new Texture(Gdx.files.internal("BotonExit.png")); // Cogemos la textura del botón para usar su ancho y alto
		int centroY = Gdx.graphics.getHeight() / 2 - texture.getHeight() / 2; // Centro en el eje x de la pantalla centrando el botón
		int centroX = Gdx.graphics.getWidth() / 2 - texture.getWidth() / 2; // Centro en el eje y de la pantalla centrando el botón
		exit = new ButtonExit(centroX, centroY - 50);
		play = new ButtonPlay(centroX, centroY + 50);
		fondo = new FondoAnimado(0,-1650);
		coche = new CocheVerde(50,0);
		camion = new Camion(300,0);
		ambulancia = new Cochepolicia(150,0);
		
		
		 musica = Gdx.audio.newMusic(Gdx.files.internal("music2.mp3"));
	        //La pone en bucle continuo
	        musica.setLooping(true);
	        //La pone en play.
	        musica.play(); 
	}
	
	@Override
	public void render(float delta) { // Método que permite actualizar los valores del juego y dibujar el juego para que lo vea el usuario.
		//Gdx es una clase con la que podemos acceder a variables que hacen referencia a todos los subsitemas, como son graficos, audio, ficheros, entrada y aplicaciones
		// gl es una variable de tipo GL, nos permite acceder a metodos de GL10, GL11 y GL20
		//En este caso glClearColor es un bucle (game loop) que establecera el fondo de la pantalla negro (0,0,0) con transparencia 1
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT); // Despues de la funcion anterior es necesario ejecutar esta, para que se lleve a cabo
		
		if(exit.update()){
			exit.funcionamiento();
		} 
		
		if(play.update()){
			musica.dispose();
			exit.texture.dispose();
			play.texture.dispose();
			fondo.dispose();
			camion.textura.dispose();
			coche.textura.dispose();
			ambulancia.textura.dispose();
			play.funcionamiento();
			
			
		}
		
		coche.update();
		camion.update();
		ambulancia.update();
		
		
		
		batch.begin();
		fondo.render(batch);
		ambulancia.draw(batch, 65, 200);
		coche.draw(batch, 65, 100);
		camion.draw(batch, 80, 700);
		exit.draw(batch); // Dibujamos el botón exit
		play.draw(batch); // Dibujamos el botón play
		batch.end();
	}

}
