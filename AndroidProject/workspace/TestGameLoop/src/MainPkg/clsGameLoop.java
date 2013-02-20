package MainPkg;
import javax.swing.JOptionPane;

public class clsGameLoop {
	public void MainGameLoop() {
    System.out.println("Class - clsGameLoop -- function - PlayGame");
    JOptionPane.showMessageDialog(null, "Class -  clsGameLoop -- function - MainGameLoop()");
    PlayGameLoop();
}
	public void PlayGameLoop(){
	boolean lFinished;
	lFinished = false;
	int intCounter;
	intCounter=0;
	
	while (!lFinished){
		System.out.println("***In the PLayGameLoop");
		JOptionPane.showMessageDialog(null, "In the Game Loop - Counter = " + intCounter);

	switch (intCounter) {
	  case 0: 
		  GetUserInput();
		  GetAIInput();
		  TriggerSound();
	    break;
	  case 1: 
	    MoveObjects();
	    break;
	  case 2: 
	    DetectCollisions();
	    break;
	  case 3: 
		  ScanBackground();
	    break;
	  case 4: 
		  DrawObjects();
	    break;
	  case 5: 
	    SoundEffects();
	    SpecialEffects();
	  default: 
	    doSomethingElse();
	} //end switch
	intCounter++;
	if (intCounter > 9){
		lFinished = true;
	    } //end if
	} //end while
	
	} //end loop

		public void GetUserInput(){
		System.out.println("<---GetUserInput--->");
		JOptionPane.showMessageDialog(null, "GetUserInput()");
    }
	public void GetAIInput(){
		System.out.println("<---GetAIInput--->");
		JOptionPane.showMessageDialog(null, "GetUserInput()");
    }	
	public void TriggerSound(){
		System.out.println("<---TriggerSound--->");
		JOptionPane.showMessageDialog(null, "GetAIInput()");
    }	
	public void  MoveObjects(){
		System.out.println("<---MoveObjects--->");
		JOptionPane.showMessageDialog(null, "MoveObjects()");
    }	
	public void DetectCollisions(){
		System.out.println("<---DetectCollisions--->");
		JOptionPane.showMessageDialog(null, "DetectCollisions()");
    }	
	public void ScanBackground(){
		System.out.println("<---ScanBackground--->");
		JOptionPane.showMessageDialog(null, "ScanBackground()");
    }	
	public void DrawObjects(){
		System.out.println("<---DrawObjects--->");
		JOptionPane.showMessageDialog(null, "DrawObjects()");
    }
	public void  SpecialEffects(){
		System.out.println("<---DoSpecialEffects--->");
		JOptionPane.showMessageDialog(null, "SpecialEffects()");
    	//Call Visual effects
		//Call Sound effects
    }
	public void  SoundEffects(){
		System.out.println("<---DoSpecialEffects--->");
		JOptionPane.showMessageDialog(null, "SoundEffects()");
    	//Call Visual effects
		//Call Sound effects
    }
	public void doSomethingElse(){
		System.out.println("<---doSomethingElse--->");
		JOptionPane.showMessageDialog(null, "What did I forget?");
    }
}