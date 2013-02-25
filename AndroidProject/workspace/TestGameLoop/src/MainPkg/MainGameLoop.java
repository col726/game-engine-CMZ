package MainPkg;
<<<<<<< HEAD
import javax.swing.JOptionPane;
public class MainGameLoop {
	  public static void main(String[] args) {
		    System.out.println("MainGameLoop - Main Function");
		    JOptionPane.showMessageDialog(null, "Class -  MainGameLoop -- function - main()");
=======
import java.io.IOException;

import javax.swing.JOptionPane;
public class MainGameLoop {
	  public static void main(String[] args) throws IOException {
		    System.out.println("MainGameLoop - Main Function");
		    JOptionPane.showMessageDialog(null, "Class -  MainGameLoop -- function - main()");
		    clsCanvas MyCanvas = new clsCanvas();
		    MyCanvas.MyCanvas();
>>>>>>> b92d6ed331ca87f8a485021ea4fd6565a06564da
		    clsInitialization initmethod = new clsInitialization();
		    initmethod.InitializeObjects();
     	    clsGameLoop maingameloop = new clsGameLoop();
     	    maingameloop.MainGameLoop();
	  }

}
