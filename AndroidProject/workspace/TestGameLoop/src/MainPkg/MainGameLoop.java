package MainPkg;
import java.io.IOException;

import javax.swing.JOptionPane;
public class MainGameLoop {
	  public static void main(String[] args) throws IOException {
		    System.out.println("MainGameLoop - Main Function");
		    JOptionPane.showMessageDialog(null, "Class -  MainGameLoop -- function - main()");
		    clsCanvas MyCanvas = new clsCanvas();
		    MyCanvas.MyCanvas();
		    clsInitialization initmethod = new clsInitialization();
		    initmethod.InitializeObjects();
     	    clsGameLoop maingameloop = new clsGameLoop();
     	    maingameloop.MainGameLoop();
	  }

}