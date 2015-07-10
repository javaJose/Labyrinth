import java.awt.*;
import javax.swing.*;
/**
 * Class LabyrinthAnimator - runs when
 * client gets to the center of the maze
 * 
 * JoseF
 * 1.0.1
 */
public class LabyrinthAnimator extends JApplet implements Runnable
{
   Color currentColor;
   String greetTheClient2;
   Thread animator;
   int yPos;
   int xPos;
   int cycleColors;
   boolean finishedMaze;
   
    public void init()
    {
        JRootPane rootPane = this.getRootPane();    
        rootPane.putClientProperty("defeatSystemEventQueueCheck", Boolean.TRUE);
        finishedMaze = true;
        greetTheClient2 = "Congratulations!...";
    }

    public void start()
    {
        cycleColors = 225;
        animator = new Thread(this);
        animator.start();
     }
   public void paint(Graphics g)
    {
        // background
        g.setColor(Color.white);
        g.fillRect(0, 0, getWidth(), getHeight());
        setSize(500, 600);
        g.setColor(Color.black);
        g.drawString(greetTheClient2, 160, 160); 
        
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
        
        //Color  silverWhite = new Color(225, 225, 255);
        //g.setColor(silverWhite);
        
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
     public void run()
    {
      while (Thread.currentThread() == animator)
      {
          cycleColors = cycleColors - 10;
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
