package INTRO;
import java.awt.EventQueue;
import TicTacToe.*;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import ClassicSnake.GameFrame;
import Ludo.PanelLudo;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowEvent;


public class IntroPage {

    private JFrame frame;
    //private final Action action = new SwingAction();

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    IntroPage window = new IntroPage();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public IntroPage() {
        initialize();
        
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(new Color(253, 245, 230));
        frame.addWindowFocusListener(new WindowFocusListener() {
            public void windowGainedFocus(WindowEvent arg0) {
            }
            public void windowLostFocus(WindowEvent arg0) {
            }
        });
        frame.getContentPane().setForeground(new Color(128, 0, 0));
        frame.setForeground(new Color(128, 0, 0));
        frame.setBounds(100, 100, 718, 528);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JTextField textArea = new JTextField();
        textArea.setBorder(null);
        textArea.setCaretColor(new Color(253, 245, 230));
        textArea.setBackground(new Color(253, 245, 230));
        textArea.setDisabledTextColor(new Color(192, 192, 192));
        textArea.setSelectionColor(new Color(0, 0, 153));
        textArea.setSelectedTextColor(new Color(204, 204, 204));
        textArea.setHorizontalAlignment(SwingConstants.CENTER);
        textArea.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
        textArea.setForeground(new Color(51, 0, 0));
        textArea.setText("GAMES VILLA");
        textArea.setBounds(114, 41, 460, 64);
        frame.getContentPane().add(textArea);

        JButton btnNewButton = new JButton("CLASSIC SNAKE GAME");
        btnNewButton.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 12));
        btnNewButton.setBounds(51, 314, 185, 107);
        btnNewButton.setIcon(new ImageIcon("snake logo1.png"));
        btnNewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GameFrame();
            }
        });
        frame.getContentPane().add(btnNewButton);

        JButton btnLudo = new JButton("LUDO");
        btnLudo.setBounds(480, 302, 185, 107);
        btnLudo.setIcon(new ImageIcon("ludo.png"));
        btnLudo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               new PanelLudo("Ludo");
            }
        });
        frame.getContentPane().add(btnLudo);

        JButton btnTicTacToe = new JButton("TIC TAC TOE");
        btnTicTacToe.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 12));
        btnTicTacToe.setBounds(253, 163, 185, 107);
        btnTicTacToe.setIcon(new ImageIcon("tic tac toe.png"));
        btnTicTacToe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TicTacToe();
            }
        });
        frame.getContentPane().add(btnTicTacToe);
    }


}