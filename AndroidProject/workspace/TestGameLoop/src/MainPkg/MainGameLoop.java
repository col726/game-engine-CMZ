package MainPkg;
import javax.swing.JOptionPane;
public class MainGameLoop {
	  public static void main(String[] args) {
		    System.out.println("MainGameLoop - Main Function");
		    JOptionPane.showMessageDialog(null, "Class -  MainGameLoop -- function - main()");
		    clsInitialization initmethod = new clsInitialization();
		    initmethod.InitializeObjects();
     	    clsGameLoop maingameloop = new clsGameLoop();
     	    maingameloop.MainGameLoop();
	  }

}
