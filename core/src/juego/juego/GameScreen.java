package juego.juego;

import java.util.Calendar;

import javax.swing.JOptionPane;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameScreen extends AbstractScreen {
	SpriteBatch batch;
	
	//CAMARA DE TIPO ORTHOGRAPIC
	private OrthographicCamera camera;
	private FondoAnimado fondo;
	private Music musica;
    public CocheAbstracto coche1, coche2,coche3, camion, camion2, camion3, limosina;
    private Music frenar;
    private Music acelerar;
    private BitmapFont font;
    
    int vidas =3;
    //Calendar fecha = Calendar.getInstance();
    

    
    
    
	public GameScreen(Main main) {
		super(main);
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		batch = new SpriteBatch(); //agrupacion de sprites, u objetos que se van a dibujar

		//img = new Texture("FONDOCARRETERA.jpg");
		camera = new OrthographicCamera();
		//DEFINIMOS LA RESOLUCION QUE ABARCA NUESTRA CAMARA
		camera.setToOrtho(false,1024,1016); // Y apunta hacia arriba,
		camera.update(); 
		fondo = new FondoAnimado(0,-1650);
		coche1 = new Coche(300,300);
		coche2= new Cochepolicia(40,1000);
		coche3 = new CocheVerde(400,0);
		camion = new Camion(550,0);
		camion2 = new Camion(800,1000);
		limosina= new Limosina(700, 500);
		frenar = Gdx.audio.newMusic(Gdx.files.internal("frenar.mp3"));
		acelerar  = Gdx.audio.newMusic(Gdx.files.internal("acelerar.mp3"));
		font = new BitmapFont(Gdx.files.internal("juegoautos.fnt"), Gdx.files.internal("juegoautos.png"), false);
		
		//Instancia la música.
        musica = Gdx.audio.newMusic(Gdx.files.internal("music.mp3"));
        //La pone en bucle continuo
        musica.setLooping(true);
        //La pone en play.
        musica.play(); 
	}

	
	
	
	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		
		//limpiar el buffer de dibujo
		Gdx.gl.glClearColor(1, 1, 1, 1); //1,1,1,1 pone fondo blanco
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
		
		
		
        updatejuego();
		camera.update();
		coche1.update();
		coche2.update();
		coche3.update();
		camion.update();
		camion2.update();
		limosina.update();
		batch.setProjectionMatrix(camera.combined);
		
		if(coche1.bordes.overlaps(coche2.bordes) || coche1.bordes.overlaps(coche3.bordes)
				   || coche1.bordes.overlaps(camion.bordes) || coche1.bordes.overlaps(camion2.bordes)
				   || coche1.bordes.overlaps(limosina.bordes)){
			vidas--;
			coche1.bordes.set(camera.position.x-300, camera.position.y,coche1.bordes.getWidth() , coche1.bordes.getHeight());
		}
		
		salirMenu();
		perder();
		
		batch.begin();
       fondo.render(batch);
       coche1.draw(batch,75,265);
       coche2.draw(batch,75,265);
       coche3.draw(batch, 75, 265);
       camion.draw(batch,80,700);
       camion2.draw(batch, 80, 700);
       limosina.draw(batch, 70 , 500);
       font.draw(batch,  "Vidas:"+Integer.toString(vidas) , coche1.getBordes().x , coche1.getBordes().y);
		//dibujar mas objetos en nuestro mundo
		batch.end(); //finalizar
	}
	
	
	
	
    

        
	
    
	
	
	private void salirMenu()
	{
		if(Gdx.input.isKeyJustPressed(Keys.ESCAPE)){
			coche1.update();
		    updatejuego();
			switch(JOptionPane.showOptionDialog(null, "¿Esta seguro?", "¡Advertencia!", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{" SI "," NO "},"0"))
			 {
			 case 0:
				 Screens.juego.setScreen(Screens.MAINSCREEN);
				    
					musica.dispose();
					Screens.juego.dispose();

			
			 }
		}
	}
	
	public void perder(){
		if(vidas==0){
					coche1.update();
					updatejuego();
					
					JOptionPane.showMessageDialog(null, "¡Ha colisionado!", "¡PERDEDOR!", JOptionPane.DEFAULT_OPTION,null);
					Screens.juego.setScreen(Screens.MAINSCREEN);
					this.vidas=3;
					
					musica.dispose();
					this.dispose();
					
					
				}
	}
	
	private void updatejuego(){
	
		
		
		  if(Gdx.input.isKeyPressed(Keys.W) && coche1.getBordes().y<1000){
		        camera.translate(0, 20, 0);
		        } 
		        
		        if(Gdx.input.isKeyPressed(Keys.S) && coche1.getBordes().y >-1000){
		            camera.translate(0, -20, 0);
		            }
		        
				
		        if(Gdx.input.isKeyPressed(Keys.S) && frenar.isLooping()==false){
		        	frenar.play();
		        	acelerar.stop();
		        	
		        }  else {
		        if(Gdx.input.isKeyPressed(Keys.W) &&  acelerar.isLooping()==false){
		        	frenar.stop();
		        	acelerar.play();;
		        }else{
		        	if(acelerar.isPlaying() || frenar.isPlaying()){
			        	acelerar.stop();
			        	frenar.stop();
			        }
		        }
		            
		        
		        }
		        
		        if(Gdx.input.isKeyJustPressed(Keys.X) && musica.isPlaying()){
		        	musica.pause();
		        	
		        }else{
		        if(Gdx.input.isKeyJustPressed(Keys.X) && musica.isPlaying()==false){
		    		musica.play();
		    	}
		        }
	}
	
	
	

}
