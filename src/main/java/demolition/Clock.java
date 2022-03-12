package demolition;

import processing.core.PImage;
import processing.core.PApplet;
import processing.core.PFont;

public class Clock {
	private int x;
	private int y;
	private PImage sprite;
	private PFont font;
	private int seconds;
	private int tick;
/**
* Construct a Clock object.
* @param x Column number for the clock.
* @param y Row number for the clock.
* @param sprite Clock sprite.
* @param font PFont used for seconds remaining text on map.
* @param seconds Maximum seconds of a game.
*/
	public Clock(int x, int y, PImage sprite, PFont font, int seconds){
		this.x = x;
		this.y = y;
		this.sprite = sprite;
		this.font = font;
		this.seconds = seconds;
		this.tick = 1;
	}
/**
* Method to form animation of time passing.
*/
	public void tick(){
		if (this.seconds > 0 ){
			this.seconds -= this.tick;
		}
	}
/**
* Draw clock and remaining seconds on map.
* @param app the main PApplet object.
*/
	public void draw(PApplet app){
		app.image(this.sprite, this.x, this.y);
		app.textFont(this.font);
		app.fill(0);
		app.text(seconds,this.x+40, this.y+25);
	}
/**
* Get the time remaining for a game.
* @return Returns an Integer for seconds remaining.
*/
	public Integer getTime(){
		return this.seconds;
	}
}
