package ClassicSnake;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class GamePanel extends JPanel implements ActionListener{
    private static final long serialVersionUID = 1L;
    static final int SCREEN_WIDTH = 500;
    static final int SCREEN_HEIGHT = 550;
    static final int UNIT_SIZE = 23;
    static final int GAME_UNITS = (SCREEN_WIDTH*SCREEN_HEIGHT)/UNIT_SIZE;
    static final int DELAY=75;
    final int x[]=new int[GAME_UNITS];
    final int y[]=new int[GAME_UNITS];
    int bodyParts=3;
    int applesEaten;
    int appleX;
    int appleY; 
    char direction='R';
    boolean running=false;
    Timer timer;
    Random random;

    GamePanel(){
        random=new Random();
        this.setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT));
        this.setBackground(new Color(222,238,191));
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());
        startGame();
    }
    public void startGame() {
        newApple();
        running=true;
        timer=new Timer(DELAY,this);
        timer.start();


    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);


    }
    public void draw(Graphics g) {
        if(running) {
            g.setColor(new Color(48,255,48));
            g.fillOval(appleX, appleY, UNIT_SIZE, UNIT_SIZE);

            for(int i=0;i<bodyParts;i++) {
                if(i==0) {
                    g.setColor(new Color(0,0,0));
                    g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
                }
                else {
                    //g.setColor(new Color(129,127,127));
                    g.setColor(new Color(100,111,101));

                    g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
                }
            }
            g.setColor(new Color(28,84,101));
            g.setFont(new Font("Kristen ITC",Font.BOLD,30));
            FontMetrics metrics=getFontMetrics(g.getFont());
            g.drawString("Score: "+applesEaten,(SCREEN_WIDTH-metrics.stringWidth("Score: "+applesEaten))/2,g.getFont().getSize());
        }

        else
            gameOver(g);
    }
    public void newApple() {
        appleX=random.nextInt((int)(SCREEN_WIDTH/UNIT_SIZE))*UNIT_SIZE;
        appleY=random.nextInt((int)(SCREEN_HEIGHT/UNIT_SIZE))*UNIT_SIZE;

    }
    public void move() {
        for(int i=bodyParts; i>0;i--)
        {
            x[i]=x[i-1];
            y[i]=y[i-1];

        }
        switch(direction)
        {
            case 'U':
                y[0]=y[0]-UNIT_SIZE;
                break;
            case 'D':
                y[0]=y[0]+UNIT_SIZE;
                break;
            case 'L':
                x[0]=x[0]-UNIT_SIZE;
                break;
            case 'R':
                x[0]=x[0]+UNIT_SIZE;
                break;
        }
    }
    public void checkApple() {
        if((x[0]==appleX)&& (y[0]==appleY)) {
            bodyParts++;
            applesEaten++;
            newApple();
        }

    }
    public void checkCollisions()
    {
        //checks if head collides with body
        for(int i=bodyParts;i>0;i--)
        {
            if((x[0] == x[i])&&(y[0]==y[i]))
            {
                running=false;

            }
        }
        //checks if head touches left border
        if(x[0]<0)
        {
            running=false;

        }
        //checks if head touches right border
        if(x[0]>SCREEN_WIDTH) {
            running=false;
        }
        //checks if head touches top border
        if(y[0]<0) {
            running=false;

        }
        //check if head touches bottom border
        if(y[0]>SCREEN_HEIGHT)
        {
            running=false;
        }
        if(!running)
        {
            timer.stop();

        }

    }
    public void gameOver(Graphics g) {
        //Game Over Text
        g.setColor(Color.red);
        g.setFont(new Font("Chiller",Font.BOLD,80));
        FontMetrics metrics1=getFontMetrics(g.getFont());
        g.drawString("GAME OVER!!",(SCREEN_WIDTH-metrics1.stringWidth("GAME OVER"))/2,SCREEN_HEIGHT/2);
        

        //Displaying score on game over screen
        g.setColor(new Color(76,23,98));
        g.setFont(new Font("Kristen ITC",Font.BOLD,40));
        FontMetrics metrics2=getFontMetrics(g.getFont());
        g.drawString("Score: "+applesEaten,(SCREEN_WIDTH-metrics2.stringWidth("Score: "+applesEaten))/2,g.getFont().getSize());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (running) {
            move();
            checkApple();
            checkCollisions();

        }
        repaint();

    }

    public class MyKeyAdapter extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e) {
            switch(e.getKeyCode())
            {
                case KeyEvent.VK_LEFT:
                    if(direction !='R') {
                        direction='L';
                    }
                    break;
                case KeyEvent.VK_RIGHT:
                    if(direction !='L') {
                        direction='R';
                    }
                    break;
                case KeyEvent.VK_UP:
                    if(direction !='D') {
                        direction='U';
                    }
                    break;
                case KeyEvent.VK_DOWN:
                    if(direction !='U') {
                        direction='D';
                    }
                    break;

            }
        }
    }

}
