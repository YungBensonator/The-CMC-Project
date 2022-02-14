import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Angle_Calculator extends PApplet {

PVector origin = new PVector(200,150);
PVector place = new PVector(400,0);
int angle = 0;
public void setup() {
  width = 400;
  height = 300;
  

}



public void draw() {
  background(255, 255, 255);
  
  stroke(0, 0, 0);
  color(0, 0, 0);
  fill(0,0,0);
  place.x = mouseX-200;
  place.y = mouseY-150;
  pushMatrix();
  translate(200,150);
  draw_axes();
  line(0,0,place.x,place.y);
  popMatrix();
  float angle = atan2(-place.y,place.x);
  float l = sqrt(place.x*place.x + place.y*place.y);
  angle = degrees(angle);
  angle = normalize_angle(angle);
  angle = round(angle);
  text("Original Angle\t\t: " + angle, 10, 10);
  text("Reflected Angle: " + normalize_angle((180-angle)),10,20);
  pushMatrix();
  translate(200,150);
  stroke(255,0,0);
  line(0,0,cos(radians(180-angle))*l, -sin(radians(180-angle))*l);
  popMatrix();
  float output = normalize_angle(180-angle);
  float asdf;
  
  asdf = output - angle;
  text("Formula: " + round(angle) + " + " + round(asdf) + " * facing ", 10, 30);

 
}

public void draw_axes(){
  stroke(0,0,0);
  height = 300;
  width = 400;
  //line(0,height/2,width,height/2);   // Horizontal axis
 // line(width/2,0,width/2,height);    // Vertical axis
  line(-200,0,200,0);
  line(0,-120,0,150);
  circle(0, 0, 10);
}

public float normalize_angle(float input){
  
  return ( input - ( floor( input / 360 ) * 360 ) );
  
}
  public void settings() {  size(400,300); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Angle_Calculator" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
