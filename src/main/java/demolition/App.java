package demolition;

import java.util.ArrayList;
import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PImage;
import processing.data.JSONArray;


public class App extends PApplet {
/**
* Default width of the game window
*/
    public static final int WIDTH = 480;
/**
* Default height of the game window
*/
    public static final int HEIGHT = 480;
/**
* Default FPS of the game
*/
    public static final int FPS = 60;
/**
* keyCode for UP
*/
    public static final int UP = 38;
/**
* keyCode for DOWN
*/
    public static final int DOWN = 40;
    /**
* keyCode for LEFT
*/
    public static final int LEFT = 37;
/**
* keyCode for RIGHT
*/
    public static final int RIGHT = 39;
    /**
* keyCode for SPACE
*/
    public static final int SPACE = 32;
    Player player;
    Clock clock;
    private Playerlife playerlife;
    private Map map;
    private int x;
    private int y;
    int lifecount;
    private ArrayList<Bomb> bomb_list;
    ArrayList<Explode> explode_list;
    ArrayList<Red_Enemy> red_Enemies;
    ArrayList<Yellow_Enemy> yellow_Enemies;
    private ArrayList<Integer> bomb_timing;
    private ArrayList<Integer> exp_timing;
    String[][] mapTable = new String[15][13];
    private String[] map_lines;
    private PImage[] mapsprite;
    private PImage[] leftsprite; 
    private PImage[] downsprite;
    private PImage[] rightsprite; 
    private PImage[] upsprite;
    private PImage[] red_leftsprite; 
    private PImage[] red_downsprite;
    private PImage[] red_rightsprite; 
    private PImage[] red_upsprite;
    private PImage[] yellow_leftsprite; 
    private PImage[] yellow_downsprite;
    private PImage[] yellow_rightsprite; 
    private PImage[] yellow_upsprite;
    private PImage[] bombs;
    PImage[] explodes;
    private int secondslevel;
    JSONArray jsonarray;
    int whichlevel;
    int initial;
    int levels;

    private PFont int_font;

    /**
* Construct Objects used in game
*/
    public App() {
        this.bomb_list = new ArrayList<Bomb>();
        this.explode_list = new ArrayList<Explode>();
        this.red_Enemies = new ArrayList<Red_Enemy>();
        this.yellow_Enemies = new ArrayList<Yellow_Enemy>();
        this.bomb_timing = new ArrayList<Integer>();
        this.exp_timing = new ArrayList<Integer>();
        this.mapsprite = new PImage[4];
        this.leftsprite = new PImage[6]; 
        this.rightsprite = new PImage[6]; 
        this.downsprite = new PImage[6]; 
        this.upsprite = new PImage[6]; 
        this.red_leftsprite = new PImage[6]; 
        this.red_rightsprite = new PImage[6]; 
        this.red_downsprite = new PImage[6]; 
        this.red_upsprite = new PImage[6]; 
        this.yellow_leftsprite = new PImage[6]; 
        this.yellow_rightsprite = new PImage[6]; 
        this.yellow_downsprite = new PImage[6]; 
        this.yellow_upsprite = new PImage[6]; 
        this.bombs = new PImage[8];
        this.explodes = new PImage[7];
    }
   /**
* Set game width and height, Load sprites and call setConfig()
*/
    public void settings() {
        size(WIDTH, HEIGHT);
        this.lifecount = loadJSONObject("config.json").getInt("lives");
        //map images
        this.mapsprite[0] = this.loadImage("src/main/resources/wall/solid.png");
        this.mapsprite[1] = this.loadImage("src/main/resources/broken/broken.png");
        this.mapsprite[2] = this.loadImage("src/main/resources/goal/goal.png");
        this.mapsprite[3] = this.loadImage("src/main/resources/empty/empty.png");
        //player images
        this.leftsprite[0] = this.loadImage("src/main/resources/player/player_left1.png");
        this.leftsprite[1] = this.loadImage("src/main/resources/player/player_left2.png");
        this.leftsprite[2] = this.loadImage("src/main/resources/player/player_left3.png");
        this.leftsprite[3] = this.loadImage("src/main/resources/player/player_left4.png");
        this.leftsprite[4] = this.loadImage("src/main/resources/player/player_left3.png");
        this.leftsprite[5] = this.loadImage("src/main/resources/player/player_left2.png");
        this.rightsprite[0] = this.loadImage("src/main/resources/player/player_right1.png");
        this.rightsprite[1] = this.loadImage("src/main/resources/player/player_right2.png");
        this.rightsprite[2] = this.loadImage("src/main/resources/player/player_right3.png");
        this.rightsprite[3] = this.loadImage("src/main/resources/player/player_right4.png");
        this.rightsprite[4] = this.loadImage("src/main/resources/player/player_right3.png");
        this.rightsprite[5] = this.loadImage("src/main/resources/player/player_right2.png");
        this.upsprite[0] = this.loadImage("src/main/resources/player/player_up1.png");
        this.upsprite[1] = this.loadImage("src/main/resources/player/player_up2.png");
        this.upsprite[2] = this.loadImage("src/main/resources/player/player_up3.png");
        this.upsprite[3] = this.loadImage("src/main/resources/player/player_up4.png");
        this.upsprite[4] = this.loadImage("src/main/resources/player/player_up3.png");
        this.upsprite[5] = this.loadImage("src/main/resources/player/player_up2.png");
        this.downsprite[0] = this.loadImage("src/main/resources/player/player1.png");
        this.downsprite[1] = this.loadImage("src/main/resources/player/player2.png");
        this.downsprite[2] = this.loadImage("src/main/resources/player/player3.png");
        this.downsprite[3] = this.loadImage("src/main/resources/player/player4.png");
        this.downsprite[4] = this.loadImage("src/main/resources/player/player3.png");
        this.downsprite[5] = this.loadImage("src/main/resources/player/player2.png");
        //load red enemy images
        this.red_leftsprite[0] = this.loadImage("src/main/resources/red_enemy/red_left1.png");
        this.red_leftsprite[1] = this.loadImage("src/main/resources/red_enemy/red_left2.png");
        this.red_leftsprite[2] = this.loadImage("src/main/resources/red_enemy/red_left3.png");
        this.red_leftsprite[3] = this.loadImage("src/main/resources/red_enemy/red_left4.png");
        this.red_leftsprite[4] = this.loadImage("src/main/resources/red_enemy/red_left3.png");
        this.red_leftsprite[5] = this.loadImage("src/main/resources/red_enemy/red_left2.png");
        this.red_rightsprite[0] = this.loadImage("src/main/resources/red_enemy/red_right1.png");
        this.red_rightsprite[1] = this.loadImage("src/main/resources/red_enemy/red_right2.png");
        this.red_rightsprite[2] = this.loadImage("src/main/resources/red_enemy/red_right3.png");
        this.red_rightsprite[3] = this.loadImage("src/main/resources/red_enemy/red_right4.png");
        this.red_rightsprite[4] = this.loadImage("src/main/resources/red_enemy/red_right3.png");
        this.red_rightsprite[5] = this.loadImage("src/main/resources/red_enemy/red_right2.png");
        this.red_upsprite[0] = this.loadImage("src/main/resources/red_enemy/red_up1.png");
        this.red_upsprite[1] = this.loadImage("src/main/resources/red_enemy/red_up2.png");
        this.red_upsprite[2] = this.loadImage("src/main/resources/red_enemy/red_up3.png");
        this.red_upsprite[3] = this.loadImage("src/main/resources/red_enemy/red_up4.png");
        this.red_upsprite[4] = this.loadImage("src/main/resources/red_enemy/red_up3.png");
        this.red_upsprite[5] = this.loadImage("src/main/resources/red_enemy/red_up2.png");
        this.red_downsprite[0] = this.loadImage("src/main/resources/red_enemy/red_down1.png");
        this.red_downsprite[1] = this.loadImage("src/main/resources/red_enemy/red_down2.png");
        this.red_downsprite[2] = this.loadImage("src/main/resources/red_enemy/red_down3.png");
        this.red_downsprite[3] = this.loadImage("src/main/resources/red_enemy/red_down4.png");
        this.red_downsprite[4] = this.loadImage("src/main/resources/red_enemy/red_down3.png");
        this.red_downsprite[5] = this.loadImage("src/main/resources/red_enemy/red_down2.png");
        //load yellow enemy images
        this.yellow_leftsprite[0] = this.loadImage("src/main/resources/yellow_enemy/yellow_left1.png");
        this.yellow_leftsprite[1] = this.loadImage("src/main/resources/yellow_enemy/yellow_left2.png");
        this.yellow_leftsprite[2] = this.loadImage("src/main/resources/yellow_enemy/yellow_left3.png");
        this.yellow_leftsprite[3] = this.loadImage("src/main/resources/yellow_enemy/yellow_left4.png");
        this.yellow_leftsprite[4] = this.loadImage("src/main/resources/yellow_enemy/yellow_left3.png");
        this.yellow_leftsprite[5] = this.loadImage("src/main/resources/yellow_enemy/yellow_left2.png");
        this.yellow_rightsprite[0] = this.loadImage("src/main/resources/yellow_enemy/yellow_right1.png");
        this.yellow_rightsprite[1] = this.loadImage("src/main/resources/yellow_enemy/yellow_right2.png");
        this.yellow_rightsprite[2] = this.loadImage("src/main/resources/yellow_enemy/yellow_right3.png");
        this.yellow_rightsprite[3] = this.loadImage("src/main/resources/yellow_enemy/yellow_right4.png");
        this.yellow_rightsprite[4] = this.loadImage("src/main/resources/yellow_enemy/yellow_right3.png");
        this.yellow_rightsprite[5] = this.loadImage("src/main/resources/yellow_enemy/yellow_right2.png");
        this.yellow_upsprite[0] = this.loadImage("src/main/resources/yellow_enemy/yellow_up1.png");
        this.yellow_upsprite[1] = this.loadImage("src/main/resources/yellow_enemy/yellow_up2.png");
        this.yellow_upsprite[2] = this.loadImage("src/main/resources/yellow_enemy/yellow_up3.png");
        this.yellow_upsprite[3] = this.loadImage("src/main/resources/yellow_enemy/yellow_up4.png");
        this.yellow_upsprite[4] = this.loadImage("src/main/resources/yellow_enemy/yellow_up3.png");
        this.yellow_upsprite[5] = this.loadImage("src/main/resources/yellow_enemy/yellow_up2.png");
        this.yellow_downsprite[0] = this.loadImage("src/main/resources/yellow_enemy/yellow_down1.png");
        this.yellow_downsprite[1] = this.loadImage("src/main/resources/yellow_enemy/yellow_down2.png");
        this.yellow_downsprite[2] = this.loadImage("src/main/resources/yellow_enemy/yellow_down3.png");
        this.yellow_downsprite[3] = this.loadImage("src/main/resources/yellow_enemy/yellow_down4.png");
        this.yellow_downsprite[4] = this.loadImage("src/main/resources/yellow_enemy/yellow_down3.png");
        this.yellow_downsprite[5] = this.loadImage("src/main/resources/yellow_enemy/yellow_down2.png");
        //load bomb images
        this.bombs[0] = this.loadImage("src/main/resources/Bomb/bomb1.png");
        this.bombs[1] = this.loadImage("src/main/resources/Bomb/bomb2.png");
        this.bombs[2] = this.loadImage("src/main/resources/Bomb/bomb3.png");
        this.bombs[3] = this.loadImage("src/main/resources/Bomb/bomb4.png");
        this.bombs[4] = this.loadImage("src/main/resources/Bomb/bomb5.png");
        this.bombs[5] = this.loadImage("src/main/resources/Bomb/bomb6.png");
        this.bombs[6] = this.loadImage("src/main/resources/Bomb/bomb7.png");
        this.bombs[7] = this.loadImage("src/main/resources/Bomb/bomb8.png");
        //load explode images
        this.explodes[0] = this.loadImage("src/main/resources/explosion/centre.png");
        this.explodes[1] = this.loadImage("src/main/resources/explosion/end_bottom.png");
        this.explodes[2] = this.loadImage("src/main/resources/explosion/end_left.png");
        this.explodes[3] = this.loadImage("src/main/resources/explosion/end_right.png");
        this.explodes[4] = this.loadImage("src/main/resources/explosion/end_top.png");
        this.explodes[5] = this.loadImage("src/main/resources/explosion/horizontal.png");
        this.explodes[6] = this.loadImage("src/main/resources/explosion/vertical.png");

        setConfig("config.json");

    }
/**
* Load config.json, put JSONArray and amount of levels in app.
* @param filename configuration json file path.
*/
    public void setConfig(String filename){
        this.jsonarray = loadJSONObject(filename).getJSONArray("levels");
        this.levels = loadJSONObject(filename).getJSONArray("levels").size();
    }
    
   /**
* Setup frameRate, load game configuration data from config.json, load font for numerical objects in the game, put data in mapTable and setup the initial map to draw
*/
    public void setup() {
        //set fps
        frameRate(FPS);
        //read map and put in a table
        String pathlevel = this.jsonarray.getJSONObject(this.whichlevel).getString("path");
        this.map_lines = loadStrings(pathlevel);
        this.map = new Map(this.mapsprite,map_lines);
        this.map.putTextinTable();
        this.mapTable = this.map.getMapTable();

        //load player pos
        for (int i= 0; i < this.mapTable.length; i++){
			for (int k = 0; k < this.mapTable[i].length; k++){
                if (this.mapTable[i][k].equals("P")){
					this.y = i;
					this.x = k;
                    this.player = new Player(this.mapTable,this.x,this.y, this.downsprite, this.upsprite,this.rightsprite,this.leftsprite,this.initial);
                }
            }
        }
        //load Red enemy pos
        for (int i= 0; i < this.mapTable.length; i++){
			for (int k = 0; k < this.mapTable[i].length; k++){
				if (this.mapTable[i][k].equals("R")){
					this.y = i;
					this.x = k;
                    this.red_Enemies.add(new Red_Enemy(this.mapTable,this.x,this.y, this.red_downsprite, this.red_upsprite, this.red_rightsprite, this.red_leftsprite,this.initial));
                }
            }
        }
        //load yellow enemy pos
        for (int i= 0; i < this.mapTable.length; i++){
			for (int k = 0; k < this.mapTable[i].length; k++){
				if (this.mapTable[i][k].equals("Y")){
					this.y = i;
					this.x = k;
                    this.yellow_Enemies.add(new Yellow_Enemy(this.mapTable,this.x,this.y, this.yellow_downsprite, this.yellow_upsprite, this.yellow_rightsprite, this.yellow_leftsprite,this.initial));
                }
            }
        }
        //load level time
        secondslevel = loadJSONObject("config.json").getJSONArray("levels").getJSONObject(whichlevel).getInt("time");
        //load font
        int_font = createFont("src/main/resources/PressStart2P-Regular.ttf",17);
        //load lives
        this.playerlife = new Playerlife(WIDTH*4/15,16,this.loadImage("src/main/resources/icons/player.png"),int_font, lifecount);
        this.clock = new Clock(WIDTH*8/15,16,this.loadImage("src/main/resources/icons/clock.png"),int_font, secondslevel);
       
        
    }
    // 
       /**
* draws all game objects, loop till game over or player win
*/
    public void draw() {
        //draw background
        background(255, 165, 0);
        //fill black on font
        fill(0);
        this.playerlife.draw(this);
        //clock ticks per 60 frames
        if (frameCount != 0 && frameCount%60 == 0 && frameCount/60 <= secondslevel){
            this.clock.tick();
        }
        //draw clock sprite
        this.clock.draw(this);
        //draw map
        this.map.draw(this);
        //Game object animation
        if (frameCount%12 == 0){
            for (Red_Enemy red : this.red_Enemies){
                red.tick();
            }
            for (Yellow_Enemy yellow : this.yellow_Enemies){
                yellow.tick();
            }
            this.player.tick(); 
        }
        //Bomb animation
        for (Bomb bomb : this.bomb_list){
            if (frameCount > 0 && (frameCount)%15 == 0){
                bomb.tick();
            }
        }
        //enemy move
        if (frameCount%60 == 0 ){
            for (Red_Enemy red : this.red_Enemies){
                red.dir_check();
            }
            for (Yellow_Enemy yellow : this.yellow_Enemies){
                yellow.dir_check();
            }
        }
        //draw bombs
        for (Bomb bomb : this.bomb_list){
            bomb.draw(this);
        }
        //remove bombs after two seconds
        if (this.bomb_list.size()>0){
            if (frameCount - this.bomb_timing.get(0) == 120){
                this.bomb_list.remove(0);
                this.bomb_timing.remove(0);
                
            }
        }
        //remove explode after 0.5 seconds
        if (this.explode_list.size()>0){
            if (frameCount - this.exp_timing.get(0) == 30){
                this.explode_list.remove(0);
                this.exp_timing.remove(0);
            }
        }
        //kill enemy
        if (this.explode_list.size()>0){
            if (frameCount > this.exp_timing.get(0) && frameCount < this.exp_timing.get(0) + 30){   
                this.explode_list.get(0).draw(this);
                this.explode_list.get(0).getExplodeCoord();
                if (this.explode_list.get(0).getYlist().size()>0){
                    for (int i = 0; i < this.explode_list.get(0).getYlist().size();i++){
                        if (this.red_Enemies.size()>0){
                            for (int r = 0; r <this.red_Enemies.size();r ++){
                                if (this.explode_list.get(0).getYlist().get(i) == this.red_Enemies.get(r).getY()
                                && this.explode_list.get(0).getXlist().get(i) == this.red_Enemies.get(r).getX()){
                                    this.red_Enemies.remove(r);
                                    r--;
                                }
                            }
                        }
                    }
                } 

                if (this.explode_list.get(0).getYlist().size()>0){
                    for (int i = 0; i < this.explode_list.get(0).getYlist().size();i++){
                        if (this.yellow_Enemies.size()>0){
                            for (int r = 0; r <this.yellow_Enemies.size();r ++){
                                if (this.explode_list.get(0).getYlist().get(i) == this.yellow_Enemies.get(r).getY()
                                && this.explode_list.get(0).getXlist().get(i) == this.yellow_Enemies.get(r).getX()){
                                    this.yellow_Enemies.remove(r);
                                    r--;
                                }
                            }
                        }
                    }
                } 
            }   
        }
        //kill player
        if (this.explode_list.size()>0){
            if (frameCount > this.exp_timing.get(0) && frameCount < this.exp_timing.get(0) + 30){   
                //this.explode_list.get(0).draw(this);
                this.explode_list.get(0).getExplodeCoord();
                boolean player_dead = false;
                if (this.explode_list.get(0).getYlist().size()>0){
                    for (int i = 0; i < this.explode_list.get(0).getYlist().size();i++){
                        if (this.explode_list.get(0).getYlist().get(i) == this.player.getY()
                        && this.explode_list.get(0).getXlist().get(i) == this.player.getX()){
                            player_dead = true;
                        }
                    }
                    if (player_dead == true){
                        clearMap();
                        if (this.lifecount > 0){
                            this.lifecount -= 1;
                            setup();
                        }
                    }
                }  
            }
        }
        
        
        //draw red enemies
        for (Red_Enemy red : this.red_Enemies){
            red.draw(this);
        }
        //draw yellow enemies
        for (Yellow_Enemy yellow : this.yellow_Enemies){
            yellow.draw(this);
        }
        //enemy kills player
        if (this.yellow_Enemies.size()>0){
            for (int r = 0; r <this.yellow_Enemies.size();r ++){
                if (this.player.getX()==this.yellow_Enemies.get(r).getX()
                && this.player.getY()==this.yellow_Enemies.get(r).getY()){
                    r--;
                    this.lifecount -= 1;
                    clearMap();
                    setup();
                }
            } 
        }
        if (this.red_Enemies.size()>0){
            for (int r = 0; r <this.red_Enemies.size();r ++){
                if (this.player.getX()==this.red_Enemies.get(r).getX()
                && this.player.getY()==this.red_Enemies.get(r).getY()){
                    r--;
                    this.lifecount -= 1;
                    clearMap();
                    setup();
                }
            } 
        }
        //draw player
        this.player.draw(this);
        //game over
        if (this.clock.getTime() == 0 || this.lifecount == 0){
            clear();
            background(255, 165, 0);
            textFont(this.int_font);
            fill(0);
            text("GAME OVER",WIDTH/3, HEIGHT/2);
            noLoop();
        }
        //find goal
        if (checkNextLevel()){
            this.whichlevel +=1;
            if (this.whichlevel < this.levels){
                clearMap();
                setup();
            } 
        }
        //you win
        if (checkWin()){
            clear();
            background(255, 165, 0);
            textFont(this.int_font);
            fill(0);
            text("YOU WIN",WIDTH*2/5, HEIGHT/2);
            noLoop();
        } 
        
    }
       /**
* Check if player wins, if not win return false;
* @return boolean 
*/
    public boolean checkWin(){
        if (this.player.findgoal()==true && this.whichlevel == this.levels){
            return true;
        }
        else {
            return false;
        }
    }
       /**
* Check if player reaches the next level
* @return boolean 
*/
    public boolean checkNextLevel(){
        if (this.player.findgoal() && this.whichlevel < this.levels){
            return true;
        }
        else {
            return false;
        }
    }
   /**
* Clear all drawings on map
*/
    public void clearMap(){
        this.red_Enemies.clear();
        this.yellow_Enemies.clear();
        this.bomb_list.clear();
        this.explode_list.clear();
        this.exp_timing.clear();
        this.bomb_timing.clear();
    }
   /**
* Check key pressed, if LEFT then player moves to the left for one column, if UP then player moves up for one row etc.
*/
    public void keyPressed(){
        if (keyCode == LEFT){
            this.player.moveleft();
        }
        else if (keyCode == RIGHT){
            this.player.moveright();
        }
        else if (keyCode == UP){
            this.player.moveup();
        }
        else if (keyCode == DOWN){
            this.player.movedown();
        }
        else if (keyCode == SPACE){
            this.bomb_timing.add(frameCount);
            this.exp_timing.add(frameCount+120);
            bomb_list.add(new Bomb(this.mapTable,this.player.getX(),this.player.getY(),this.bombs,this.initial));
            explode_list.add(new Explode(this.mapTable, this.player.getX(), this.player.getY(), this.explodes, this.initial));
            for (int i = 0; i < explode_list.size(); i++){
                this.explode_list.get(i).checkExplodeSpace();
                
            }
        }
    }
       /**
* Main method that runs the program
* @param args default args
*/
    public static void main(String[] args) {
        PApplet.main("demolition.App");
    }
}
