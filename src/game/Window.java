/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;


import java.awt.Dimension;
import javax.swing.JFrame;

public class Window {
    
    public Window (int w, int h, String title, Game game)
    {
       
        game.setPreferredSize(new Dimension(w,h));
        game.setMaximumSize(new Dimension(w,h));
        game.setMinimumSize(new Dimension(w,h));
        
        JFrame frame = new JFrame(title);
        frame.add(game);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
        game.start();
    }
}
