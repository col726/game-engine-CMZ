package main.Sound;

import java.io.File;
import java.net.URL;

import javax.sound.*;
import javax.sound.sampled.*;

public class GameSound {

	AudioInputStream ai;
	private Clip c;
	URL url;
	public boolean isPlaying;
	AudioFormat format;
	
	public GameSound(File soundFile) throws Exception
	{
		// AudioInputStream sound = AudioSystem.getAudioInputStream(soundFile);
		
		ai = AudioSystem.getAudioInputStream(soundFile);
		
		DataLine.Info info = new DataLine.Info(Clip.class, ai.getFormat());
	    c = (Clip) AudioSystem.getLine(info);
	    c.open(ai);
        
        
        
	}
	
	public GameSound() {
		// TODO Auto-generated constructor stub
	}

	public void play()
	{
		if(c != null)
		{
			c.setFramePosition(0);
			c.loop(20);
			c.start();
			isPlaying = true;
		}
	}
	
	public void stop()
	{
		c.stop();
		isPlaying = false;
	}
	
}
