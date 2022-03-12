package demolition;

import processing.core.PApplet;
import org.junit.jupiter.api.Test;


public class AppTest {
	
    @Test 
    public void basicTest() {
        // Create an instance of your application
        App app = new App();
        // Set the program to not loop automatically
        app.noLoop();
        // Tell PApplet to create the worker threads for the program
        PApplet.runSketch(new String[] {"App"}, app);
		// Set the path of the config file to use
		app.setConfig("src/test/resources/playertest/config.json");
		// Call App.setup() to load in sprites
        app.setup();
		
        // Set a 1 second delay to ensure all resources are loaded
        app.delay(1100);
        // Call draw to update the program.
        // Call keyPressed() or similar
		app.keyCode = 37;
		app.keyPressed();
		//app.draw();
		app.keyCode = 38;
		app.keyPressed();
		//app.draw();
		app.keyCode = 39;
		app.keyPressed();
		//app.draw();
		app.keyCode = 40;
		app.keyPressed();
		//app.draw();
		app.keyCode = 32;
		app.keyPressed();
		//app.draw();
        // Call draw again to move onto the next frame
		app.frameCount = 120;
        app.draw();
		app.keyCode = 32;
		app.draw();
		app.frameCount = 240;
		app.draw();
		app.player.y = 7;
		app.player.x = 7;
		app.draw();
		app.keyCode = 32;
		app.keyPressed();
		app.draw();
		app.player.y = 1;
		app.player.x = 1;
		app.draw();
		app.frameCount = 380;
		app.draw();
		app.player.findgoal = true;
	 	app.whichlevel=app.levels;
	 	app.draw();

        // Verify the new state of the program with assertions
    }
    
}
