/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceshuttlegame;

import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author Hassow099
 */
public class SpaceShuttleGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            public void run() {
               ApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);    

                GameFrame obj=context.getBean(GameFrame.class);
                obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                obj.setLayout(new FlowLayout());
                obj.setResizable(false); 
            }
        });
   
    }
    
}
