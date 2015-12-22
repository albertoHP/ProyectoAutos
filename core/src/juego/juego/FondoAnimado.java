package juego.juego;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class FondoAnimado {
	   public int x,y;
	    private Animation animation;
	    private float tiempo;
	    private TextureRegion [] regionsMovimiento;
	    private Texture imagen;
	    private TextureRegion frameActual;

	    public FondoAnimado(int x, int y) {
	        this.x = x;
	        this.y = y;
	        //cargar la imagen
	        imagen = new Texture(Gdx.files.internal("FONDOCARRETERA.jpg"));
	        TextureRegion [][] tmp = TextureRegion.split(imagen,
	                imagen.getWidth()/4,imagen.getHeight());

	        regionsMovimiento = new TextureRegion[4];
	        for (int i = 0; i < 4; i++) regionsMovimiento[i] = tmp[0][i];
	        animation = new Animation(1/30f,regionsMovimiento);
	        tiempo = 0f;

	    }

 
	    public void dispose(){
	    	imagen.dispose();
	        
	    }
	    
	    public void render(final SpriteBatch batch) {
	    	
	        tiempo += Gdx.graphics.getDeltaTime(); //es el tiempo que paso desde el ultimo render
	        frameActual = animation.getKeyFrame(tiempo,true);
	        batch.draw(frameActual,x,y);
	        
	    }
}
