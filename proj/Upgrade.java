// ******************************************************************
//   CirclePanel.java
//
//   A panel with a circle drawn in the center and buttons on the 
//   bottom that move the circle.
// ******************************************************************
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class Upgrade extends JPanel
{
    private final int CIRCLE_SIZE = 50;
    private int x,y;
    private Color c;
    private JButton choose;
    private boolean up;
    private boolean down;
    private boolean upgrade;
    private boolean right;
    //---------------------------------------------------------------
    // Set up circle and buttons to move it.
    //---------------------------------------------------------------
    public Upgrade(int width, int height)
    {
        // Set coordinates so circle starts in middle
        //x = (width/2)-(CIRCLE_SIZE/2);
        //y = (height/2)-(CIRCLE_SIZE/2); 

        //c = Color.white;

        // Need a border layout to get the buttons on the bottom
        //this.setLayout(new BorderLayout());

        // Create buttons to move the circle
        //JButton upgrade = new JButton("Upgrade");

        // Add listeners to the buttons
        //upgrade.addActionListener(new MoveListener());

        // Need a panel to put the buttons on or they'll be on
        // top of each other.
        //JPanel buttonPanel = new JPanel();
        //buttonPanel.add(upgrade);

        // Add the button panel to the bottom of the main panel
        //this.add(buttonPanel, BorderLayout.NORTH);

        //JPanel colorPanel=new JPanel();
        /*
        JButton red = new JButton("Red");
        red.setForeground(Color.red);
        JButton blue = new JButton("Blue");
        blue.setForeground(Color.blue);
        JButton green = new JButton("Green");
        green.setForeground(Color.green);
        JButton yellow = new JButton("Yellow");
        yellow.setForeground(Color.yellow);

        choose=new JButton("Choose Color");

        red.addActionListener(new ColorListener(Color.red));
        blue.addActionListener(new ColorListener(Color.blue));
        choose.addActionListener(new ColorListener(null));
        green.addActionListener(new ColorListener(Color.green));
        yellow.addActionListener(new ColorListener(Color.yellow));

        colorPanel.add(red);
        colorPanel.add(blue);
        colorPanel.add(choose);
        colorPanel.add(green);
        colorPanel.add(yellow);
        this.add(colorPanel, BorderLayout.SOUTH);*/
    }

    //---------------------------------------------------------------
    // Draw circle on CirclePanel
    //---------------------------------------------------------------
    public void paintComponent(Graphics page)
    {
        super.paintComponent(page);

        page.setColor(Color.red);
        //page.fillOval(x,y,CIRCLE_SIZE,CIRCLE_SIZE);
    }

    //---------------------------------------------------------------
    // Class to listen for button clicks that move circle.
    //---------------------------------------------------------------
    private class MoveListener implements ActionListener, KeyListener
    {

        //---------------------------------------------------------------
        // Parameters tell how to move circle at click.
        //---------------------------------------------------------------
        public MoveListener()
        {

        }

        //---------------------------------------------------------------
        // Change x and y coordinates and repaint.
        //---------------------------------------------------------------
        public void actionPerformed(ActionEvent e)
        {
        }

        public void keyPressed(KeyEvent evt) {
            int z = evt.getKeyCode();
            switch (z) {
                case (KeyEvent.VK_DOWN):
                down=true;
                break;
                case(KeyEvent.VK_LEFT):
                upgrade=true;
                //xinc= -1;
                // xPos+= 5*xinc;
                break;
                case(KeyEvent.VK_RIGHT):
                right=true;
                //xinc = 1;
                // xPos+= 5*xinc;
                break;
                case(KeyEvent.VK_UP):
                up=true;
                //xinc = 1;
                // xPos+= 5*xinc;
                break;
            }

        }

        public void keyReleased(KeyEvent evt) {
            int zz = evt.getKeyCode();
            switch (zz) {
                case(KeyEvent.VK_UP):     
                up=false;
                //xinc= 0;
                break;
                case(KeyEvent.VK_DOWN):
                down=false;
                //xinc = 0;
                break;
                case(KeyEvent.VK_LEFT):     
                upgrade=false;
                //xinc= 0;
                break;
                case(KeyEvent.VK_RIGHT):
                right=false;
                //xinc = 0;
                break;
            }

        }

        public void keyTyped(KeyEvent evt) {
        }
    }

    private class ColorListener implements ActionListener
    {
        private Color a;
        private JColorChooser g;
        public ColorListener(Color a){
            this.a=a;
            g=new JColorChooser();
        }

        public void actionPerformed(ActionEvent e)
        {
            if (a==null){
                c=g.showDialog(choose, "Colors", c);
            }
            else
                c=a;
            repaint();

        }

    }
}
