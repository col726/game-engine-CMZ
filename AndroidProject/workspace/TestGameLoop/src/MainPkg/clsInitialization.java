package MainPkg;

import javax.swing.JOptionPane;

public class clsInitialization {
	  public void InitializeObjects() {
		    System.out.println("Class - clsInitialization -- function - InitializeObjects");
		    JOptionPane.showMessageDialog(null, "Class clsInitialization - InitializeObjects()");
		    InitSpriteControl(); 
		    InitSprite();  
		    InitAI();
		    InitAudio();
		    InitCollisionDT();
		    InitSpecialFX();
	  }
	  public void InitSpriteControl() {
		  //Setup Keystroke/control cross reference ?.xml
		    System.out.println("function - InitSpriteControl");
		    JOptionPane.showMessageDialog(null, "InitSpriteControl()");
		  }
	  public void InitSprite() {
		  //Setup Keystroke/control cross reference ?.xml
		    System.out.println("function - InitSprite");
		    JOptionPane.showMessageDialog(null, "InitSprite()");
		  }
	  public void InitGamePanel() {
		    System.out.println("function - InitGamePanel");
		    JOptionPane.showMessageDialog(null, "InitGamePanel()");
		  }
	  public void InitAI() {
		    System.out.println("function - InitAI");
		    JOptionPane.showMessageDialog(null, "InitAI()");
		  }
	  public void InitAudio() {
		    System.out.println("function - InitAudio");
		    JOptionPane.showMessageDialog(null, "InitAudio()");
		  }
	  public void InitCollisionDT() {
		    System.out.println("function - InitCollisionDT");
		    JOptionPane.showMessageDialog(null, "InitCollisionDT()");
		  }
	  public void InitSpecialFX() {
		    System.out.println("function - InitSpecialFX");
		    JOptionPane.showMessageDialog(null, "InitSpecialFX()");
		  }
}

