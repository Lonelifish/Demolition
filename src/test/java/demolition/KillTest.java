package demolition;
import processing.core.PApplet;
import org.junit.jupiter.api.Test;
public class KillTest {

	@Test 
	public void killtest() {
	 // Create an instance of your application
	 App app = new App();
	 // Set the program to not loop automatically
	 app.noLoop();
	 // Tell PApplet to create the worker threads for the program
	 PApplet.runSketch(new String[] {"App"}, app);
	 // Set the path of the config file to use
	 app.setConfig("src/test/resources/killtest/config.json");
	 // Call App.setup() to load in sprites
	 app.setup();
	 // Set a 1 second delay to ensure all resources are loaded
	 app.delay(1000);
	 // Call draw to update the program.
	 app.draw();
	 // check player kill by near by yellow enemy
	 app.frameCount = 60;
	 app.draw();
	 // put player back to 1,1
	 app.player.y = 1;
	 app.player.x = 1;
	 // place bomb
	 app.keyCode = 32;
	 app.keyPressed();
	 // put player to 9,1
	 app.player.y = 9;
	 app.player.x = 1;
	 // bomb disappear
	 app.frameCount = 180;
	 app.draw();
	 // explode
	 app.frameCount = 190;
	 app.draw();
	 // explode disappear
	 app.frameCount = 210;
	 app.draw();
	 // check red enemy kills player
	 app.player.y = 1;
	 app.player.x = 10;
	 app.draw();
	 app.frameCount = 240;
	 app.draw();
	 // check game over
	 app.lifecount = 0;
	 app.frameCount = 250;
	 app.draw();
	 
	 
	}
}
