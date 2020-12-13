package TicTacToe;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
public class TicTacToe implements ActionListener{
	 Random random=new Random();
	 JFrame frame=new JFrame();
	 JPanel title_panel=new JPanel();
	 JPanel button_panel=new JPanel();
	 JLabel textfield=new JLabel();
	 JButton[] button=new JButton[9];
	 Boolean player1_turn;
	 public TicTacToe(){
		 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setSize(600,700);
			frame.setTitle("TIC TAC TOE");
			frame.setResizable(true);
			frame.getContentPane().setBackground( new Color(50,50,50) );
			frame.setLayout(new BorderLayout());
			frame.setVisible(true);
			textfield.setBackground(new Color(200,25,25));
			textfield.setForeground(new Color(225,225,0));
		textfield.setFont(new Font("Ink Free",Font.BOLD,75));
		textfield.setHorizontalAlignment(JLabel.CENTER);
		textfield.setText("TIC TAC TOE");
		textfield.setOpaque(true);
		
		title_panel.setLayout(new BorderLayout());
		title_panel.setBounds(0,0,800,800);
		title_panel.add(textfield);
		 
		button_panel.setLayout(new GridLayout(3,3));
		button_panel.setBackground(new Color(100,60,50));
		for(int i=0;i<9;i++)
		{
			button[i]=new JButton();
			button_panel.add(button[i]);
			button[i].setFont(new Font("MV Boli",Font.BOLD,120));
			button[i].setFocusable(false);
			button[i].addActionListener(this);
		}
			
		frame.add(title_panel,BorderLayout.NORTH);
		frame.add(button_panel);
		firstturn();
	 }
	 int count=0;
	    int check_tie=0;

	@Override
	public void actionPerformed(ActionEvent e) {
		for(int i=0;i<9;i++) {
			if(e.getSource()==button[i]) {
				count++;
				if(player1_turn) {
				if(button[i].getText()=="") {
					button[i].setForeground(new Color(255,0,0));
				    button[i].setText("X");
				    player1_turn=false;
				    textfield.setText("O turn");
					check();
					 if (count==9 && check_tie==0)
                         no_win(0, 1, 2, 3, 4, 5, 6, 7, 8);
				}
					
				}
			
				else {
					if(button[i].getText()=="") {
						button[i].setForeground(new Color(0,255,0));
					    button[i].setText("O");
					    player1_turn=true;
					    textfield.setText("X turn");
					   check();
					   if (count==9 && check_tie==0)
	                         no_win(0, 1, 2, 3, 4, 5, 6, 7, 8);
					
					
				
					}
			}
			}
		}
			
		
	}
	public void firstturn() {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(random.nextInt(2)==0) {
		player1_turn=true;
		textfield.setText("xturn");
		}
		else {
			player1_turn=false;

			textfield.setText("oturn");
			
		}
	}
	
	public void check() {
		if((button[0].getText()=="X") &&(button[1].getText()=="X") &&(button[2].getText()=="X") ){
			xWins(0,1,2);
			
		}
		else if((button[3].getText()=="X") &&(button[4].getText()=="X") &&(button[5].getText()=="X") ){
			xWins(3,4,5);
			
		}
		
		else if((button[6].getText()=="X") &&(button[7].getText()=="X") &&(button[8].getText()=="X") ){
			xWins(6,7,8);
			
		}
		else if((button[0].getText()=="X") &&(button[3].getText()=="X") &&(button[6].getText()=="X") ){
			xWins(0,3,6);
			
		}
		else if((button[1].getText()=="X") &&(button[4].getText()=="X") &&(button[7].getText()=="X") ){
			xWins(1,4,7);
			
		}
		else if((button[2].getText()=="X") &&(button[5].getText()=="X") &&(button[8].getText()=="X") ){
			xWins(2,5,8);
			
		}
		else  if((button[0].getText()=="X") &&(button[4].getText()=="X") &&(button[8].getText()=="X") ){
				xWins(0,4,8);
				
			}
		else	if((button[2].getText()=="X") &&(button[4].getText()=="X") &&(button[6].getText()=="X") ){
					xWins(2,4,6);
					
				}
				
				
		else if((button[0].getText()=="O") &&(button[1].getText()=="O") &&(button[2].getText()=="O") ){
					oWins(0,1,2);
					
				}
		else if((button[3].getText()=="O") &&(button[4].getText()=="O") &&(button[5].getText()=="O") ){
					oWins(3,4,5);
				
				}
				
		else if((button[6].getText()=="O") &&(button[7].getText()=="O") &&(button[8].getText()=="O") ){
					oWins(6,7,8);
					
				}
		else if((button[0].getText()=="O") &&(button[3].getText()=="O") &&(button[6].getText()=="O") ){
					oWins(0,3,6);
					
				}
		else if((button[1].getText()=="O") &&(button[4].getText()=="O") &&(button[7].getText()=="O") ){
					oWins(1,4,7);
					
				}
		else if((button[2].getText()=="O") &&(button[5].getText()=="O") &&(button[8].getText()=="O") ){
					oWins(2,5,8);
					
				}
		else if((button[0].getText()=="O") &&(button[4].getText()=="O") &&(button[8].getText()=="O") ){
						oWins(0,4,8);
						
					}
		else if((button[2].getText()=="O") &&(button[4].getText()=="O") &&(button[6].getText()=="O") ){
							oWins(2,4,6);
							
					 }
					
	
		
	}
	public void xWins(int a,int b, int c) {
		button[a].setBackground(Color.GREEN);
		button[b].setBackground(Color.GREEN);
		button[c].setBackground(Color.GREEN);
		for(int i=0;i<9;i++) {
			button[i].setEnabled(false);
			
		}
		textfield.setText("Xwins");
		check_tie=1;
	}
	
	public void oWins(int a,int b, int c) {
		
		
		button[a].setBackground(Color.GREEN);
		button[b].setBackground(Color.GREEN);
		button[c].setBackground(Color.GREEN);
		for(int i=0;i<9;i++) {
			button[i].setEnabled(false);
			
		}
		textfield.setText("Owins");
		check_tie=1;
	}
	

    public void no_win(int a, int b, int c, int d, int e, int f, int g, int h, int i){
        button[a].setBackground(Color.blue);
        button[b].setBackground(Color.blue);
        button[c].setBackground(Color.blue);
        button[d].setBackground(Color.blue);
        button[e].setBackground(Color.blue);
        button[f].setBackground(Color.blue);
        button[g].setBackground(Color.blue);
        button[h].setBackground(Color.blue);
        button[i].setBackground(Color.blue);
        for (int j=0; j<9;j++){
            button[j].setEnabled(false);
        }
        textfield.setText("TIE!!");
    }
}

    


