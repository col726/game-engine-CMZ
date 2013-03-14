package main.Sound;

import java.io.File;
import java.net.URL;

import javax.sound.*;
import javax.sound.sampled.*;

import org.jbox2d.collision.shapes.CircleShape;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.FixtureDef;

public class GameSound {

	AudioInputStream ai;
	private Clip c;
	URL url;
	public boolean isPlaying;
	AudioFormat format;
	boolean show;
	
	//jBox stuff
	private BodyDef bodyDef; 
	private Body soundBody;
	private FixtureDef fixture;
	private CircleShape bb;
	
	public GameSound(File soundFile) throws Exception
	{
		
		ai = AudioSystem.getAudioInputStream(soundFile);
		
		DataLine.Info info = new DataLine.Info(Clip.class, ai.getFormat());
	    c = (Clip) AudioSystem.getLine(info);
	    c.open(ai);
	}
	
	public GameSound(){
		
	}
	
	public GameSound(File soundFile, boolean isVisible, Vec2 center, int w) throws Exception {
		this(soundFile);
		
		if(isVisible)
		{
			show = true;
			
			bodyDef = new BodyDef();
			
			bodyDef.position.set(center.x, center.y);
			bodyDef.type = BodyType.DYNAMIC;
			
			bb = new CircleShape();
			fixture = new FixtureDef();
			bb.m_p.set(center);
			bb.m_radius = w/4; //divide by 4 so that sound circle is contained within object
			
			fixture.shape = bb;
		    fixture.density = 1.0f;
		    fixture.friction = 0.8f;
		}
	}

	public void play()
	{
		if(c != null)
		{
			c.setFramePosition(0);
			c.start();
			isPlaying = true;
		}
	}
	
	public void stop()
	{
		c.stop();
		isPlaying = false;
	}
	
	public void setSoundBody(Body soundBody) {
		this.soundBody = soundBody;
		soundBody.createFixture(fixture);
	}

	public void setLoop(int i) {
		
		c.loop(i);
	}

	public BodyDef getBodyDef() {
		// TODO Auto-generated method stub
		return this.bodyDef;
	}

	public Body getSoundBody() {
		return this.soundBody;
		
	}
	
}
