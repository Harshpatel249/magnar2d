/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.Graphics;

/**
 *
 * @author HARSH
 */
public class Highscore {
    Dbcon db = new Dbcon();
    public void getscore(){
        db.addscore();
    }
    public void viewscore(Graphics g){
        db.viewscore(g);
    }
    
}
