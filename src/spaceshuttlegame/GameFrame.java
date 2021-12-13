/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceshuttlegame;

import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.springframework.stereotype.Component;

/**
 *
 * @author Hassow099
 */
@Component
public class GameFrame extends JFrame{
//create a panel
    private JPanel gp;
    
    public GameFrame() throws IOException{
     gp=new GamePanel();
     add(gp);
      //System.out.println(""+gp.getX()+" "+gp.getY());
     setVisible(true);
     pack();

    }
 
}
