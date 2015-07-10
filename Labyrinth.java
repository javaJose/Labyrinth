import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * Class Labyrinth - Drag the mouse to the center
 * of the maze.
 * User draws a path to the center of maze.
 * Square areas used to validate mouse location.
 * 
 * Note: where four lines or four rectangular
 * areas are drawn to bound square areas, the pattern,
 *     g.drawLine(top);
       g.drawLine(bottom);
       g.drawLine(left);
       g.drawLine(right);
   is employed.  This convention is not
   used elsewhere.
   
 * @author JoseF 
 * @version 1.0
 */
public class Labyrinth extends JApplet implements MouseMotionListener, MouseListener, Runnable
{
   Color currentColor;
   int xPos;
   int yPos;
   int cycleColors;
   String greetTheClient;
   String greetTheClient2;
   Thread animator;
   boolean firstTime;
   boolean notHome;
  
   
    public void init()
    {

        firstTime = true;
        notHome = true;
        JRootPane rootPane = this.getRootPane();    
        rootPane.putClientProperty("defeatSystemEventQueueCheck", Boolean.TRUE);
        addMouseListener(this);
        addMouseMotionListener(this);
        greetTheClient = "Find your way to the center...";
        greetTheClient2 = "Congratulations!...";
        
    }
     public void start()
    {
       if (notHome = false) {
        cycleColors = 225;
        animator = new Thread(this);
        animator.start();
       }
     }
    public void paint(Graphics g)
    {
       if (firstTime) 
       {
        firstTime = false;
        // background
        g.setColor(Color.white);
        g.fillRect(0, 0, getWidth(), getHeight());
        setSize(500, 600);
        g.setColor(Color.black);
        g.drawString(greetTheClient, 15, 475); 
        
        //draw area of origin
        g.setColor(Color.green);
        g.fillRect(200, 435, 50, 5);
        g.fillRect(175, 495, 60, 5);
        g.fillRect(175, 435, 5, 75);
        g.fillRect(250, 435, 5, 60);

        //draw center destination
        g.setColor(Color.red);
        g.fillRect(175, 175, 75, 5);
        g.fillRect(175, 250, 60, 5);
        g.fillRect(175, 175, 5, 75);
        g.fillRect(250, 175, 5, 60);
        
        //draw outer walls
        g.setColor(Color.blue);
        g.fillRect(15, 15, 400, 5);
        g.fillRect(15, 15, 5, 400);
        g.fillRect(415, 15, 5, 400);
        g.fillRect(15, 415, 160, 5);
        g.fillRect(200, 415, 220, 5);
     
        //draw inner walls
        
        g.fillRect(15, 390, 260, 5);
        g.fillRect(15, 365, 260, 5);
        g.fillRect(315, 365, 45, 5);
        g.fillRect(375, 365, 45, 5);
        g.fillRect(375, 300, 5, 65);
        g.fillRect(390, 245, 5, 105);
        g.fillRect(110, 250, 5, 100);
        g.fillRect(15, 345, 75, 5);
        g.fillRect(85, 205, 5, 140);
        g.fillRect(70, 205, 5, 125);
        g.fillRect(55, 205, 5, 125);
        g.fillRect(35, 15, 5, 315);
        g.fillRect(355, 15, 5, 340);
        g.fillRect(335, 15, 5, 340);
        g.fillRect(130, 330, 145, 5);
        g.fillRect(115, 310, 145, 5);
        g.fillRect(130, 290, 185, 5);
        g.fillRect(115, 270, 150, 5);
        g.fillRect(290, 55, 5, 215);
        g.fillRect(310, 15, 5, 275);
        g.fillRect(55, 15, 5, 175);
        g.fillRect(70, 15, 5, 175);
        g.fillRect(85, 15, 5, 175);
        
        g.setColor(Color.white);
        //morewalls to come
         
        //draw path from origin to destination in the form
        //area boundariies
        // g.setColor(Color.pink);
        // g.drawLine(175, 435, 250, 435);
        // g.drawLine(175, 510, 250, 510);
        // g.drawLine(174, 435, 175, 510);
        // g.drawLine(250, 435, 250, 510);
        //Area is 75 * 75 = 5625 pixels
        //1st north mouse movement (mmn1)
        // g.drawLine(175, 395, 200, 395);
        // g.drawLine(175, 435, 200, 435);
        // g.drawLine(175, 395, 175, 435);
        // g.drawLine(200, 395, 200, 435);
        //1st west mouse movement (mmw1)
        // g.drawLine(200, 395, 310, 395);
        // g.drawLine(200, 415, 310, 415);
        // g.drawLine(200, 395, 200, 415);
        // g.drawLine(315, 395, 315, 415);
        //2nd north mouse movement mmn2
        // g.drawLine(275, 290, 315, 290);
        // g.drawLine(275, 395, 315, 395);
        // g.drawLine(275, 290, 275, 395);
        // g.drawLine(315, 290, 315, 395);
            
        //1st west mouse movement mmw1
        // g.drawLine(110, 290, 315, 290);
        // g.drawLine(110, 310, 315, 310);
        // g.drawLine(110, 290, 110, 310);
        // g.drawLine(315, 290, 315, 310);
           
        //2nd east mouse movement mme2
        // g.drawLine(110, 275, 295, 275);
        // g.drawLine(110, 290, 295, 290);
        // g.drawLine(110, 275, 110, 290);
        // g.drawLine(295, 275, 295, 295);
           
        //retreat west
        // g.drawLine(235, 250, 295, 250);
        // g.drawLine(235, 275, 295, 275);
        // g.drawLine(235, 250, 235, 275);
        // g.drawLine(295, 250, 295, 275);
           
        //slice of home1
        // g.setColor(Color.black);
        // g.drawLine(235, 210, 255, 210);
        // g.drawLine(235, 250, 255, 250);
        // g.drawLine(235, 210, 235, 250);
        // g.drawLine(255, 210, 255, 250);
          
        //slice of home2 
         //g.drawLine(235, 175, 255, 175);
         //g.drawLine(235, 210, 255, 210);
         //g.drawLine(235, 175, 235, 210);
         //g.drawLine(255, 175, 255, 210);
          
         //slice of home3
         //g.drawLine(175, 175, 235, 175);
         //g.drawLine(175, 255, 235, 255);
         //g.drawLine(175, 175, 175, 255);
         //g.drawLine(235, 175, 235, 255);
    
     
    }
    
        //set drawing to current color and draw the circle
        firstTime = false;
       //re-initialize white so no drawing until click
       g.setColor(currentColor);
        g.fillRect(xPos - 5, yPos - 5, 8, 8);
   
       //cycleColors begins here
       if (notHome)
       {
           notHome = false;
           //greeting
           g.setColor(Color.black);
           g.drawString(greetTheClient2, 160, 160);
           g.setColor(Color.white);
           g.fillRect(15,460,155,20);
           
            //draw outer walls
            Color redGreenCycle = new Color(225, cycleColors, 255); 
            g.setColor(redGreenCycle);
            g.fillRect(15, 15, 400, 5);
            g.fillRect(15, 15, 5, 400);
            g.fillRect(415, 15, 5, 400);
            g.fillRect(15, 415, 160, 5);
            g.fillRect(200, 415, 220, 5);
     
        //draw inner walls
        g.fillRect(15, 390, 260, 5);
        g.fillRect(15, 365, 260, 5);
        g.fillRect(315, 365, 45, 5);
        g.fillRect(375, 365, 45, 5);
        g.fillRect(375, 300, 5, 65);
        g.fillRect(390, 245, 5, 105);
        g.fillRect(110, 250, 5, 100);
        g.fillRect(15, 345, 75, 5);
        g.fillRect(85, 205, 5, 140);
        g.fillRect(70, 205, 5, 125);
        g.fillRect(55, 205, 5, 125);
        g.fillRect(35, 15, 5, 315);
        g.fillRect(355, 15, 5, 340);
        g.fillRect(335, 15, 5, 340);
        g.fillRect(130, 330, 145, 5);
        g.fillRect(115, 310, 145, 5);
        g.fillRect(130, 290, 185, 5);
        g.fillRect(115, 270, 150, 5);
        g.fillRect(290, 55, 5, 215);
        g.fillRect(310, 15, 5, 275);
        g.fillRect(55, 15, 5, 175);
        g.fillRect(70, 15, 5, 175);
        g.fillRect(85, 15, 5, 175);
      }
        //use this whhen user touches the walls or goes
       //off course
       //Color  silverWhite = new Color(225, 225, 255);
       //g.setColor(silverWhite);
       //g.fillRect(0, 200, 400, 20);
        
       //some lines i can use for added design
        //calculations        
        //g.setColor(Color.pink);
        //g.drawLine(175, 175, 75, 5);
        //g.drawLine(175, 250, 60, 5);
        //g.drawLine(175, 175, 5, 75);
        //g.drawLine(250, 175, 5, 60);
     }
public void mouseDragged(MouseEvent me) 
    {
        firstTime = false;
        xPos = me.getX();
        yPos = me.getY();
        greetTheClient = "Go to the center(" + xPos + "," + yPos + ")\n";
       if  (xPos >=235 && xPos <=255 && yPos >=210 && yPos <= 250 ||
            xPos >=235 && xPos <=295 && yPos >=250 && yPos <= 275 ||
            xPos >=110 && xPos <=295 && yPos >=275 && yPos <= 295 ||
            xPos >=110 && xPos <=315 && yPos >=290 && yPos <= 310 ||
            xPos >=275 && xPos <=315 && yPos >=290 && yPos <= 395 ||
            xPos >=200 && xPos <=315 && yPos >=395 && yPos <= 415 ||
            xPos >=175 && xPos <=200 && yPos >=395 && yPos <= 435 ||
            xPos >=175 && xPos <=250 && yPos >=435 && yPos <= 510)
           {
               firstTime = false;
               currentColor = Color.green;
              // greetTheClient = "Go to the center(" + xPos + "," + yPos + ")\n";
               repaint();
            }

        else if (xPos >=175 && xPos <=255 && yPos >=175 && yPos <= 255)
            { 
                    notHome = false;
                 greetTheClient = "Go to the center(" + xPos + "," + yPos + ")\n";
            }
        else if (xPos >=175 && xPos <=255 && yPos >=175 && yPos <= 255)
            { 
                    notHome = false;
            }
      }
        

    public void mouseMoved(MouseEvent me)
    {
       
    }

    public void mouseEntered(MouseEvent me)
    {
        xPos = me.getX();
        yPos = me.getY();
        greetTheClient = "Click inside the green box.";
        currentColor = Color.green;
        repaint();
    }

    public void mouseExited(MouseEvent me)
    {
        xPos = me.getX();
        yPos = me.getY();
        currentColor = Color.white;
        greetTheClient = "You can Start Over.";
        firstTime = true;
        repaint();
    }

    public void mousePressed(MouseEvent me)
    {
       while (notHome = false) {
        xPos = me.getX();
        yPos = me.getY();
        currentColor = Color.red;
        greetTheClient = "Use the left mouse button";
        
        repaint();
      }
    }
    
    public void mouseReleased(MouseEvent me)
    {
       while (notHome = false) { 
        xPos = me.getX();
        yPos = me.getY();
        currentColor = Color.pink;
        greetTheClient = "Please start again";
        firstTime = true;
        repaint();
      }
    }

    public void mouseClicked(MouseEvent me)
    {
        
        xPos = me.getX();
        yPos = me.getY();
        if (xPos >=175 && xPos <=255 && yPos >=175 && yPos <= 255)
           {
                firstTime = false;
                notHome = true;
                repaint();
            }
        if (xPos >= 175 && xPos <= 200 && yPos>= 435 && yPos <= 495)
            {
                firstTime = false;
                notHome = true;
                repaint();
            }
        else
            {
                firstTime = true;
                repaint();
                greetTheClient = "Click inside the green box.";
            }
        
    } 
         public void run()
    {
      while (Thread.currentThread() == animator)
      {
          notHome = true;
          cycleColors = cycleColors - 1;
          repaint();

          if (cycleColors < 1)
          {
              cycleColors = 255;
          }
          try 
          {
              Thread.sleep(10);
          } 
          catch (InterruptedException e) 
          {
              break;
          }
      }
    }
     public void stop()
    {
        animator = null;
     }
} 
