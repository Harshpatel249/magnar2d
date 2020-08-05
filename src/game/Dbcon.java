
package game;

/**
 *
 * @author HARSH
 */


import java.awt.Graphics;
import java.sql.*;
import javax.swing.JOptionPane;
import java.time.Duration;


public class Dbcon {
    Connection con = null;
    public static Duration ftime;
    private int[] vscore = new int[3];
    private String[] vName = new String[3];

    public int[] getVscore() {
        return vscore;
    }

    public void setVscore(int[] vscore) {
        this.vscore = vscore;
    }

    public String[] getvName() {
        return vName;
    }

    public void setvName(String[] vName) {
        this.vName = vName;
    }
    
    
    
    public void addscore(){
        try {
          
            Class.forName("com.mysql.jdbc.Driver");
          
            String dbURL = "jdbc:mysql://localhost:3306/high";
      
            con = DriverManager.getConnection(dbURL, "root", "");
           
            Statement stmt = con.createStatement();
            ResultSet rs;

            ftime = Duration.between(Game.stime, Game.etime);
            
            JOptionPane.showMessageDialog(null, "Score : "+(int)((ftime.toMillis()/1000)-Game.getLife()*7) + "seconds");
            
            String Name = JOptionPane.showInputDialog(null, "Whats your Name?");
            
            String insertString;
           
            insertString = "INSERT INTO tbl_score VALUES (" + (int)((ftime.toMillis()/1000)-Game.getLife()*10) + ", '" + Name + "')";
            stmt.executeUpdate(insertString);
            
            stmt.close();
            con.close();
              Game.setState(State.Menu);
        } catch (Exception e) {
            System.out.println("Exception caught --> " + e);
        }
    }
    public void viewscore(Graphics g){
        try {
          
            Class.forName("com.mysql.jdbc.Driver");
          
            String dbURL = "jdbc:mysql://localhost:3306/high";
      
            con = DriverManager.getConnection(dbURL, "root", "");
           
            Statement stmt = con.createStatement();
            ResultSet rs;
            
            String selectQuery = "SELECT score, name FROM tbl_score ORDER BY score ASC";
            rs = stmt.executeQuery(selectQuery);
            int i=0;
            while(rs.next()){
                vscore[i] = rs.getInt("score");
                vName[i] = rs.getString("Name");
                i++;
                if(i>2){
                    break;
                }
            }
            
            render(g);
            //System.out.println("Name " + "  " + " customer_name" + " city");
            
            stmt.close();
            con.close();
              Game.setState(State.Menu);
        } catch (Exception e) {
            System.out.println("Exception caught --> " + e);
        }
    }
    public void render(Graphics g){
            JOptionPane.showMessageDialog(null,"1."+"Name : "+vName[0]+" Score : "+vscore[0]+"\n"+"2."+"Name : "+vName[1]+" Score : "+vscore[1]+"\n"+"3."+"Name : "+vName[2]+" Score : "+vscore[2]+"\n","Highcores",1);
            
          /*  g.drawString("Name : "+vName[0]+"Score : "+vscore[0]+"seconds", Game.InitX, Game.InitY);
            g.drawString("Name : "+vName[1]+"Score : "+vscore[1]+"seconds", 400, 450);
            g.drawString("Name : "+vName[2]+"Score : "+vscore[2]+"seconds", 400, 500);*/
    }
}
