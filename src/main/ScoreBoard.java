package main;

import javax.swing.BorderFactory;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ScoreBoard extends Panel{
    private Frame frame;
    private Font font = new Font("Arial" , Font.BOLD , 40);
    private Font numFont = new Font("Arial" , Font.BOLD , 55);
    private JButton nextButton;
    private int player1;
    private int player2;

    final private int player1X = 200;
    final private int player2X = 840;

    ScoreBoard(Frame frame){
        super();
        this.frame = frame;
        initNextButton();
    }

    public void setPlayer1( int player1 ){
        this.player1 = player1;
    }

    public void setPlayer2( int player2 ){
        this.player2 = player2;
    }

    public void updateScore( String winner ){
        update(winner);
    }

    private void update( String winner ){
        if( winner.equals("Player1") ) player1 ++ ;
        else if ( winner.equals("Player2") ) player2 ++;
        else{
            player1 ++ ;
            player2 ++ ;
        }
        repaint();
    }

    private void initNextButton(){
        nextButton = new JButton("next");
        nextButton.setFont( new Font("Arial" , Font.BOLD , 25) );
        nextButton.setForeground(Color.WHITE);
        nextButton.setBackground(Color.GRAY);
        nextButton.setBounds(490, 500, 300, 120);
        nextButton.setFocusPainted(false);
        nextButton.setBorder(BorderFactory.createEmptyBorder());
        nextButton.setOpaque(true);
        this.setLayout(null);
        this.add(nextButton);

        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if( frame.getCurrentGameIndex() < frame.getVersion() ) frame.switchToInstruction();
                else {
                    String winner = "";
                    if( player1 > player2 ) winner = "Player1";
                    else if( player1 < player2 ) winner = "Player2";
                    else winner = "Tie";
                    frame.switchToGameOver( winner );
                }
            }
        });
    }


    public void paintComponent(Graphics g2) {
		super.paintComponent(g2);

		Graphics2D g = ((Graphics2D) g2); 

		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_NORMALIZE);

        drawPlayer1Text(g);
        drawPlayer1Score(g);

        drawPlayer2Text(g);
        drawPlayer2Score(g);

        g.dispose();
	}
    
    private void drawPlayer1Text(Graphics g){
        String text = "Player 1   Score" ;
        g.setFont(font);
        g.setColor(Color.BLACK);
        g.drawString(text , player1X + 350/2 - (int)(g.getFontMetrics().stringWidth(text)/2) , 300 );
    }

    private void drawPlayer1Score(Graphics g){
        String text = String.valueOf(player1);
        g.setFont(numFont);
        g.setColor(Color.BLACK);
        g.drawString(text , player1X + 350/2 - (int)(g.getFontMetrics().stringWidth(text)/2) , 400 );
    }
    
    private void drawPlayer2Text(Graphics g){
        String text = "Player 2   Score" ;
        g.setFont(font);
        g.setColor(Color.BLACK);
        g.drawString(text , player2X + 350/2 - (int)(g.getFontMetrics().stringWidth(text)/2) , 300 );
    }

    private void drawPlayer2Score(Graphics g){
        String text = String.valueOf(player2);
        g.setFont(numFont);
        g.setColor(Color.BLACK);
        g.drawString(text , player2X + 350/2 - (int)(g.getFontMetrics().stringWidth(text)/2) , 400 );
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);

        drawPlayer1Score(g);
        drawPlayer2Score(g);
        nextButton.repaint();
    }
}
