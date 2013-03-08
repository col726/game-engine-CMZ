import java.awt.*;
import java.util.ArrayList;

public class animation{
	private ArrayList scenes;
	private int sceneIndex;
	private long movieTime;
	private long totalTime;
	
	public animation(){
		scenes = new ArrayList();
		totalTime = 0;
		start();
	}

//add scene to arraylist
	public synchronized void addScene(Image i, long t){
		totalTime += t;
		scenes.add(new OneScene(i, totalTime));
	}
//Start animation
	private synchronized void start(){
		movieTime = 0;
		sceneIndex = 0;
	}
//Change animation
	public synchronized void update(long timePassed){
        if (scenes.size()>1){
	       movieTime += timePassed;
	       if (movieTime >= totalTime){
		       movieTime = 0;
		       sceneIndex = 0;
	       }
	       while (movieTime > getScene(sceneIndex).endTime){
	    	   sceneIndex++;
	       }
        }
	}	
//Get Current Scene
	public synchronized Image getImage(){
		if (scenes.size()==0){
			return null;
		}else{
		return getScene(sceneIndex).pic;
        }
	}		
//Get a Scene
	private OneScene getScene(int x){
		return(OneScene)scenes.get(x);
	}
//Inner Class???
	private class OneScene{
		Image pic;
		long endTime;
		
		public OneScene(Image pic, long endTime){
			this.pic = pic;
			this.endTime = endTime;
		}
		
	}
}