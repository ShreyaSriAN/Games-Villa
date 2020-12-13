package ClassicSnake;

import javax.swing.JFrame;

public class GameFrame extends JFrame{ //Inheritance
    private static final long serialVersionUID = 1L;

    public GameFrame(){ //Constructor


        this.add(new GamePanel());
        this.setTitle("CLASSIC SNAKE GAME");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);

    }

}
