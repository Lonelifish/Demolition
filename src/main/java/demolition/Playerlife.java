package demolition;

import processing.core.PImage;
import processing.core.PApplet;
import processing.core.PFont;

public class Playerlife {
	private int x;
	private int y;
	private PImage sprite;
	private PFont font;
	private int lifecount;
/**
* Construct a Playerlife object.
* @param x Column number for the player icon.
* @param y Column number for the player icon.
* @param sprite Player icon sprite.
* @param font PFont used for player life count.
* @param lifecount Player lives remaining in this game.
*/
	public Playerlife(int x, int y, PImage sprite, PFont font, int lifecount){
		this.x = x;
		this.y = y;
		this.sprite = sprite;
		this.font = font;
		this.lifecount = lifecount;
	}
/**
* Draw player icon and player lives remaining on map.
* @param app the main PApplet object.
*/
	public void draw(PApplet app){
		app.image(this.sprite, this.x, this.y);
		app.textFont(this.font);
		app.text(lifecount,this.x+40, this.y+25);
	}
}