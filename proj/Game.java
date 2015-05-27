import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import java.util.ArrayList;
public class Game extends JPanel
{
    private int xinc;
    private Color c;
    private JButton choose;
    private boolean up;
    private boolean down;
    private boolean upgrade;
    private boolean left;
    private boolean right;
    private Player pikachu;
    private StandardEnemy enemy;
    private StandardEnemy enemy1;
    private StandardEnemy enemy2;
    private StandardEnemy enemy3;
    private StandardEnemy enemy4;
    private StandardEnemy enemy5;
    private StandardEnemy enemy6;
    private Timer timer;
    private int health;
    private int gold;
    private BufferedImage background;
    private ArrayList<Projectile> projectiles;
    Projectile myProjectile;
    private static final int IFW = JComponent.WHEN_IN_FOCUSED_WINDOW;
    private static final String DOWN = "DOWN";
    private static final String UP = "UP";
    private static final String LEFT = "LEFT";
    private static final String RIGHT = "RIGHT";
    private static final String DOWNn = "DOWNn";
    private static final String UPn = "UPn";
    private static final String LEFTn = "LEFTn";
    private static final String RIGHTn = "RIGHTn";
    private static final String SPACE = "SPACE";
    
    private static final String W = "W";
    private static final String A = "A";
    private static final String S = "S";
    private static final String D = "D";
    private static final String Wn = "Wn";
    private static final String An = "An";
    private static final String Sn = "Sn";
    private static final String Dn = "Dn";
    

    public Game(int width, int height)
    {

        health=10;
        gold=1000;

        this.setLayout(new BorderLayout());
        JButton upgrade = new JButton("Upgrade");
        //upgrade.addActionListener(new MoveListener());

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(upgrade);
        buttonPanel.add(new infoPanel(health,gold));
        this.add(buttonPanel, BorderLayout.NORTH);
        JPanel colorPanel=new JPanel();

        //test player
        try {

            //   myProjectile = new Projectile(pikachu.getX(), pikachu.getY(), ImageIO.read(new File("projectile.jpg")));
            pikachu=new Player(100,0,1,ImageIO.read(new File("r1.png")),40,300);
            enemy=new StandardEnemy(100,0,50,ImageIO.read(new File("r3.png")),50,50,Math.random() * (0.06 - 0.03)+.13);
            enemy1=new StandardEnemy(100,0,50,ImageIO.read(new File("r3.png")),5,5,Math.random() * (0.06 - 0.03)+.13);
            enemy2=new StandardEnemy(100,0,50,ImageIO.read(new File("r3.png")),300,300,Math.random() * (0.06 - 0.03)+.13);
            //enemy3=new StandardEnemy(100,0,1,ImageIO.read(new File("r3.png")),5,5,Math.random() * (0.06 - 0.03)+0.03);
            //enemy4=new StandardEnemy(100,0,1,ImageIO.read(new File("r3.png")),300,300,Math.random() * (0.06 - 0.03)+0.03);
            //enemy5=new StandardEnemy(100,0,1,ImageIO.read(new File("r3.png")),5,5,Math.random() * (0.06 - 0.03)+0.03);
            //enemy6=new StandardEnemy(100,0,1,ImageIO.read(new File("r3.png")),300,300,Math.random() * (0.06 - 0.03)+0.03);
        } catch (IOException e) {
            e.printStackTrace();
        }
        buttonPanel.getInputMap(IFW).put(KeyStroke.getKeyStroke("pressed DOWN"), DOWN);
        buttonPanel.getActionMap().put(DOWN, new Move(DOWN));
        buttonPanel.getInputMap(IFW).put(KeyStroke.getKeyStroke("pressed UP"), UP);
        buttonPanel.getActionMap().put(UP, new Move(UP));
        buttonPanel.getInputMap(IFW).put(KeyStroke.getKeyStroke("pressed LEFT"), LEFT);
        buttonPanel.getActionMap().put(LEFT, new Move(LEFT));
        buttonPanel.getInputMap(IFW).put(KeyStroke.getKeyStroke("pressed RIGHT"), RIGHT);
        buttonPanel.getActionMap().put(RIGHT, new Move(RIGHT));
        buttonPanel.getInputMap(IFW).put(KeyStroke.getKeyStroke("released DOWN"), DOWNn);
        buttonPanel.getActionMap().put(DOWNn, new Move(DOWNn));
        buttonPanel.getInputMap(IFW).put(KeyStroke.getKeyStroke("released UP"), UPn);
        buttonPanel.getActionMap().put(UPn, new Move(UPn));
        buttonPanel.getInputMap(IFW).put(KeyStroke.getKeyStroke("released LEFT"), LEFTn);
        buttonPanel.getActionMap().put(LEFTn, new Move(LEFTn));
        buttonPanel.getInputMap(IFW).put(KeyStroke.getKeyStroke("released RIGHT"), RIGHTn);
        buttonPanel.getActionMap().put(RIGHTn, new Move(RIGHTn));
        
        buttonPanel.getInputMap(IFW).put(KeyStroke.getKeyStroke("pressed S"), S);
        buttonPanel.getActionMap().put(S, new Move(S));
        buttonPanel.getInputMap(IFW).put(KeyStroke.getKeyStroke("pressed W"), W);
        buttonPanel.getActionMap().put(W, new Move(W));
        buttonPanel.getInputMap(IFW).put(KeyStroke.getKeyStroke("pressed A"), A);
        buttonPanel.getActionMap().put(A, new Move(A));
        buttonPanel.getInputMap(IFW).put(KeyStroke.getKeyStroke("pressed D"), D);
        buttonPanel.getActionMap().put(D, new Move(D));
        buttonPanel.getInputMap(IFW).put(KeyStroke.getKeyStroke("released S"), Sn);
        buttonPanel.getActionMap().put(Sn, new Move(Sn));
        buttonPanel.getInputMap(IFW).put(KeyStroke.getKeyStroke("released W"), Wn);
        buttonPanel.getActionMap().put(Wn, new Move(Wn));
        buttonPanel.getInputMap(IFW).put(KeyStroke.getKeyStroke("released A"), An);
        buttonPanel.getActionMap().put(An, new Move(An));
        buttonPanel.getInputMap(IFW).put(KeyStroke.getKeyStroke("released D"), Dn);
        buttonPanel.getActionMap().put(Dn, new Move(Dn));
        //buttonPanel.getInputMap(IFW).put(KeyStroke.getKeyStroke("SPACE"), SPACE);
        //buttonPanel.getActionMap().put(SPACE, new Moverun());
        try{
            background=ImageIO.read(new File("stadium.png"));
        }catch (IOException e) {
            e.printStackTrace();
        }
        buttonPanel.getActionMap().put(SPACE, new Shoot());
    }

    //---------------------------------------------------------------
    // Repaint the game
    //---------------------------------------------------------------
    public void paintComponent(Graphics page)
    {
        // super.paintComponent(page);
        //green rect is where info for health, gold, etc. will be placed as text
        page.setColor(Color.green);
        page.fillRect(0,0, 1200,130);
        page.setColor(Color.black);
        page.fillRect(0,130,1200,670);
        page.drawImage(background, 100, 125, this);
        page.drawImage(pikachu.getPic(), pikachu.getX(), pikachu.getY(), this);
        page.drawImage(enemy.getPic(), enemy.getX(pikachu.getX()), enemy.getY(pikachu.getY()), this);
        page.drawImage(enemy1.getPic(), enemy1.getX(pikachu.getX()), enemy1.getY(pikachu.getY()), this);
        page.drawImage(enemy2.getPic(), enemy2.getX(pikachu.getX()), enemy2.getY(pikachu.getY()), this);
        //page.drawImage(enemy3.getPic(), enemy3.getX(pikachu.getX()), enemy3.getY(pikachu.getY()), this);
        //page.drawImage(enemy4.getPic(), enemy4.getX(pikachu.getX()), enemy4.getY(pikachu.getY()), this);
        //page.drawImage(enemy5.getPic(), enemy5.getX(pikachu.getX()), enemy5.getY(pikachu.getY()), this);
        //page.drawImage(enemy6.getPic(), enemy6.getX(pikachu.getX()), enemy6.getY(pikachu.getY()), this);
        //page.drawImage(myProjectile.getPic(), myProjectile.getX(), myProjectile.getY(),this);
        repaint();
    }

    private class Shoot extends AbstractAction
    {
        public void actionPerformed(ActionEvent e)
        {
            myProjectile.setX(pikachu.getX());
            myProjectile.setY(pikachu.getY());
            projectiles.add(myProjectile);
        }
    }
    private class Move extends AbstractAction
    {
        private String com;
        public Move(String command){
            com=command;

        }

            
    

        public void actionPerformed(ActionEvent e)
        {
            if(com.equals(DOWN))
                pikachu.down();
            else if(com.equals(LEFT))
                pikachu.left();
            else if(com.equals(RIGHT))
                pikachu.right();
            else if(com.equals(UP))
                pikachu.up();
            else if(com.equals(DOWNn))
                pikachu.downn();
            else if(com.equals(LEFTn))
                pikachu.leftn();
            else if(com.equals(RIGHTn))
                pikachu.rightn();
            else if(com.equals(UPn))
                pikachu.upn();
                
            else if(com.equals(W))
                pikachu.W();
            else if(com.equals(A))
                pikachu.A();
            else if(com.equals(D))
                pikachu.D();
            else if(com.equals(S))
                pikachu.S();
            else if(com.equals(Wn))
                pikachu.Wn();
            else if(com.equals(An))
                pikachu.An();
            else if(com.equals(Sn))
                pikachu.Sn();
            else if(com.equals(Dn))
                pikachu.Dn();

        }

    }
}

