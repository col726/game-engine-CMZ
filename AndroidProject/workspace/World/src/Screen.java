import java.awt.*;
import javax.swing.JFrame;

public class Screen {
	
	private GraphicsDevice vc;
	
	public Screen() {
		GraphicsEnvironment env =  GraphicsEnvironment.getLocalGraphicsEnvironment();
		vc = env.getDefaultScreenDevice();
		//System.out.println("Screen");
	}

	public void setFullScreen(DisplayMode dm, JFrame window){
		//System.out.println("setFullScreen");
       window.setUndecorated(true);
       window.setResizable(false);
       vc.setFullScreenWindow(window);
       if (dm !=null && vc.isDisplayChangeSupported()) {
    	   try {
    		   vc.setDisplayMode(dm);
    	   } catch(Exception ex){
    		   //System.out.println(ex);
    	   }
       }
    }
    public Window getFullScreenWindow() {
    	//System.out.println("getFullScreenWindow");
       return vc.getFullScreenWindow();
    }
       
	   
    public void restoreScreen() {
      Window w = vc.getFullScreenWindow();
      //System.out.println("restoreScreen()");
      if (w != null){
    	  w.dispose();
      }
      vc.setFullScreenWindow(null);
    }
   
 }   

