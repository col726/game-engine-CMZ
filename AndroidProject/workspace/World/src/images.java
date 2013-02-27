import java.awt.*;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.ImageIcon;

public class images extends JFrame {
	public static void main(String[] args){
		DisplayMode dm = new DisplayMode(800,600, 16, DisplayMode.REFRESH_RATE_UNKNOWN);
//		DisplayMode dm = new DisplayMode(1024,768, 16, DisplayMode.REFRESH_RATE_UNKNOWN);
		images i = new images();
		i.run(dm);
	}

    private Screen s;
    private Image bg;
    private Image pic;
    private boolean loaded;
    private String strimagedir;
    
    
//run method
	private void run(DisplayMode dm) {
		// TODO Auto-generated method stub
		//System.out.println("Running");
		setBackground(Color.PINK);
		setForeground(Color.WHITE);
		setFont(new Font("Arial", Font.PLAIN, 24));
		loaded = false;
		strimagedir = System.getProperty("user.dir");
//		new images().setVisible(true);

//		repaint();
		s = new Screen();
		try{
			s.setFullScreen(dm, this);
			loadpics();
			try{
				//System.out.println("sleeping");
				Thread.sleep(9000);
			}catch(Exception ex){}
		}catch(Exception ex){
			
		}finally{
			s.restoreScreen();
		}
	}
	//load pictures
	public void loadpics(){
		//System.out.println("loadpics() ");
		try{
			bg = Toolkit.getDefaultToolkit().createImage("c:\\images\\800px-TWW_parallax_scrolling_sample_1.gif");
			pic = Toolkit.getDefaultToolkit().createImage("c:\\images\\java1.png");
			loaded = true;
			repaint();
		}catch(Exception ex){
			System.out.println(ex);
		}

	}
	
	public void paint(Graphics g){
//		System.out.println("paint");
		if (g instanceof Graphics2D){
			Graphics2D g2 = (Graphics2D)g;
			g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		}
        if (loaded){
//        	System.out.println("Loaded");
	       g.drawImage((Image)bg, 0, 0, null);
	       g.drawImage((Image)pic, 200, 300, null);
        }
		
	}
}