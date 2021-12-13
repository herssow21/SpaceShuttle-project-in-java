

package spaceshuttlegame;


import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JButton;

import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * This class implements a <code>Speedometer</code> view by implementing the
 * <code>ISpeedView</code> interface.
 * 
 * @author Clemens Krainer
 */
public class GamePanel extends JPanel implements MouseListener
{

	/**
	 * Some geometric constants.
	 */
    private Timer timer;
    private int rocketH;
    private int startingPosReader;
    private int changey;
    private int altitude;
    private BufferedImage rocket;
    private JButton btn;
    private JButton pause;
    
        
        
	private static final int size = 150;
	private static final double f1 = 0.2777777;
	private static final double f2 = 0.3888888;
	private static final double f3 = 0.05;
	private static final double f4 = 0.0888888;
	private static final int r1 = (int)(size * f1);
	private static final int r2 = (int)(size * f2);
	private static final int l3 = (int)(size * f3);
	private static final int l4 = (int)(size * f4);
	private static final int x_origin = 75;
	private static final int y_origin = 595;
	private static final double startAngle = 225;
	private static final double endAngle = -45;
	private static final double max_speed = 100;
	private static final double main_interval = (startAngle-endAngle) / 5;
	private static final double sub_interval = (startAngle-endAngle) / 25;
	private static final int needleDiameter = (int)(size * 0.1);
	private static final int needleLength = r1 + l3;
	

	public GamePanel () throws IOException
	{
            //for spaceCraft
   timer=new Timer(60,new MyActionListener());
   altitude=-(rocketH-340)/12;
    rocketH=340;
//    startingPosReader=0;
    changey=3;
    rocket=ImageIO.read(new File("ship2.jpg")); 
     btn=new JButton("Press to Fire");
     Dimension size= btn.getPreferredSize();
     btn.setBackground(Color.BLACK);
         // btn.setLocation(200,300);
          btn.setBounds(20, 20, 500,500);
     MyActionListener mover=new MyActionListener();
   btn.addActionListener(mover);
   add(btn);
   

//=========keyListener class============
btn.addKeyListener(new KeyAdapter(){
       @Override
       public void keyPressed(KeyEvent e) {
    int key=e.getKeyCode();
    
    if(key==KeyEvent.VK_UP){
        if( rocketH>340)
       changey=-changey;
      rocketH-=changey++;
      
      timer.start();
 
      repaint();
    }
    else if(key==KeyEvent.VK_ENTER){
       timer.stop();
       }
    else if(key==KeyEvent.VK_DOWN){
             if(rocketH !=340)
               {
                   rocketH+=changey;
                   changey=-changey;
               }
//            else if(rocketH==340){
//                    changey=0;
//}
//    if(rocketH !=340)
//               {
//                   rocketH+=changey;
//                   changey=-changey;
//               }
//             if(rocketH==340){
////             timer.stop();
//             changey=0;
//             }
    repaint();

    }
    }
       
   });

//============mouse Listener class=======
btn.addMouseListener(new MouseAdapter(){        
       
        @Override
        public void mousePressed(MouseEvent e) {
            //hold press to stop
            timer.stop();
        }
   
   });
    btn.addMouseListener(new MouseAdapter(){        
       
        @Override
        public void mouseExited(MouseEvent e) {
         //when stoped pressing should come back slowly
                 
                if(rocketH !=340)
               {
                   rocketH+=changey;
                   changey=-changey;
               }
                if(altitude<0){
                timer.stop();
                }
    
           }
   
   });
    
    setPreferredSize(new Dimension(680,700));
    setBackground(Color.white);
   
	}

    @Override
    public void mousePressed(MouseEvent e) {
int x=getX();
int y=getY();
System.out.println(x +""+y);
        }

   @Override
    public void mouseClicked(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
// =========ActionListener class============
	//spacecraft action implementation
        private class MyActionListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
        //fire up code
        if( rocketH>340)
       changey=-changey;
      rocketH-=changey;
      
      timer.start();
 
      repaint();

        }
 
        
    }

    @Override
    public void repaint() {
        super.repaint(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
         g.setColor(Color.white);
    //draw the ship here
        g.drawImage(rocket, 160, rocketH,rocket.getWidth()/5,rocket.getHeight()/3,this);
         btn=new JButton("PRESS");
      g.setColor(Color.red);
      g.drawArc(200, 80, 230, 200, 0, 180);
      g.fillArc(200, 80, 230, 200, 0, 180); 
        g.setColor(Color.white);
      g.drawString("Cybrogs" ,290, 150);
      g.setFont(new Font("Courier New", Font.BOLD, 30));
      g.drawString("Herssow" ,265, 120);
      g.setColor(Color.red);
          g.setFont(new Font("Courier New", Font.BOLD, 60));
      g.drawString("SpaceShip program", 20, 250);
       g.setColor(Color.black);
       g.setFont(new Font("Courier New", Font.BOLD, 40));
      g.drawString("Press/[UP] the button above" ,22, 300);
      g.drawString("to fire,Release/[DOWN] to" ,45, 350);
      g.drawString("return& Hold/[ENTER] to " ,60, 400);
      g.drawString("stop at any Altitude. " ,100, 450);


}
        	
	
	public void paintComponent (Graphics g)
	{
		super.paintComponent (g);
		Graphics2D ga = (Graphics2D)g;

		ga.setColor (Color.black);
           //.fillArc(15,450,500,700,20,30);

              	ga.fillOval(10, 510, size-1, size-1);//x axis is 68&140
            	ga.fillOval(420, 510, size-1, size-1);//x axis is 68&140
		ga.setColor (Color.white);
		ga.drawOval (420, 510, size-1, size-1); // draw border 
                g.setFont(new Font("Courier New", Font.BOLD, 20));
                g.drawString ("SPEED", 50, 560);
                g.drawString ("ALTITUDE",450, 565);
                ga.drawString ("m/s",55, 635);
                ga.drawString ("feet",470, 645);
             	ga.setColor (Color.green);
              
                g.setFont(new Font("Courier New", Font.BOLD, 30));
                g.drawString(" "+-(rocketH-340)/12, 39, 605);
                g.drawString(" "+-(rocketH-340)/17, 447, 600);
              // ga.setColor (Color.red);
               g.setFont(new Font("Courier New", Font.PLAIN, 20));
                  btn.setBackground(Color.WHITE);
//                  g.setBounds(10,2,200,300);
	   
        }
}