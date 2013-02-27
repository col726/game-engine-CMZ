package TestJavaGamePkg;
/*
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
*/
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.imageio.ImageIO;
import javax.swing.*;
//import javax.swing.JFrame;
//import javax.swing.JOptionPane;
//import javax.swing.JPanel;
//import javax.swing.Timer;

public class clsSetUpGame extends JPanel implements ActionListener{
//	public class clsSetUpGame extends JPanel {
    int x, y;
    private Image dbImage;
    private Graphics dbg;
    Image ghost;
    Image bg;


public void SetupGame() throws Exception {
	System.out.println("Class - clsJavaGame");
    JOptionPane.showMessageDialog(null, "SetupGame()");

	ImageIcon j = new ImageIcon("images/bg.png");
	bg = j.getImage();
	ImageIcon i = new ImageIcon("images/java1.png");
	ghost = i.getImage(); 
	JOptionPane.showMessageDialog(null, "2-SetupGame()");
    JFrame f = new JFrame("Java Game");
    
//	f.setSize(1275, 725);
	f.setSize(300, 300);
	f.setResizable(false);

	f.setIconImage(bg);
	
	 
	JOptionPane.showMessageDialog(null, "3-SetupGame()");
	f.setVisible(true);
	f.setBackground(Color.GRAY);
	
//	f.add(ghost, BorderLayout.CENTER);
	
	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	setFocusable(true);

 
}

@Override
public void paint(Graphics g){
	super.paint(g);

    System.out.println("paint(Graphics g)");
    JOptionPane.showMessageDialog(null, "paint()");
    try
    {
    Image img = ImageIO.read(new File("images\bg.png"));
    g.drawImage(bg, 0, 0, null);
    x=1275;
    y=725;
    dbImage = createImage(getWidth(), getHeight());
    dbg = dbImage.getGraphics();
    paintComponent(dbg);
    g.drawImage(dbImage, x, y, this);
    } 
    catch (IOException ex) 
    {
    	System.out.println("Houston We Have A Problem");
        JOptionPane.showMessageDialog(null, "Houston We Have A Problem");
   }
}
@Override
public void paintComponent(Graphics g){
	System.out.println("paintComponent(Graphics g)");
	JOptionPane.showMessageDialog(null, "paint()");
    g.setColor(Color.WHITE);
    g.drawImage(ghost, x, y, this);
    paint(g);
}
@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	JOptionPane.showMessageDialog(null, "actionPerformed");
}

} //end class
