import processing.core.PApplet;
import processing.core.PImage; // Import Image Library

public class Sketch extends PApplet {
	PImage imgBackground;
  PImage imgIronman;
  PImage imgCir;

  float fltIronmanX = 170;
  float fltIronmanY = 350;
  
  float fltCirX = 250;
  float fltCirY = 200;

  float fltCirSpeedX = 5;
  float fltCirSpeedY = 5;

  float fltIronmanSpeedX = 5;
  float fltIronmanSpeedY = 5;

  float fltInverseX;
	
  /**
   * Called once at the beginning of execution, put your size all in this method
   */
  public void settings() {
size(400, 400);
  }

  /** 
   * Called once at the beginning of execution.  Add initial set up
   * values here i.e background, stroke, fill etc.
   */
  public void setup() {
    
    imgBackground = loadImage("buildings.jpeg");
    imgBackground.resize(imgBackground.width*1,imgBackground.height*1);

    imgIronman = loadImage("ironman.png");
    imgIronman.resize(imgIronman.width/15, imgIronman.height/15);
    
  }

  /**
   * Called repeatedly, anything drawn to the screen goes here
   */
 public void draw() {
    // drawing background
    image(imgBackground, 0, 0);

    // drawing and animating Ironman
    image(imgIronman, fltIronmanX, fltIronmanY);
    fltIronmanX += fltIronmanSpeedX;

   // edge detection
   if(fltIronmanX < 20 || fltIronmanX > height){
      fltIronmanSpeedX *= -1; 
    }
    if(fltIronmanX > 20 || fltIronmanX < height){
      fltIronmanSpeedX *= 1;
    }
    if(fltIronmanY < 20 || fltIronmanY > height){
      fltIronmanSpeedY *= -1; 
    }
    if(fltIronmanY > 20 || fltIronmanY < height){
      fltIronmanSpeedY *= 1;
    }

    // Parabolic animation for Ironman
    fltIronmanY = ((float) 0.01 * ((float) Math.pow(fltIronmanX - width / (float) 2, (float) 2))) + (float) 50;
    fltInverseX = width - (float) fltIronmanX;
      
    // drawing and animating shape (circle)
    fill(255, 102, 102);
    ellipse(fltCirX, fltCirY, 50, 50);
    
    fltCirX += fltCirSpeedX;
    fltCirY += fltCirSpeedY;

    // Edge Detection
    if(fltCirX < 30 || fltCirX > width){
      fltCirSpeedX *= -1;
    }
    if(fltCirY < 20 || fltCirY > height){
      fltCirSpeedY *= -1;
    }
  }
   }
