package game.speedyArrows;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyBoard implements KeyListener {
    protected GameBoard gameBoard;
    protected Node node;

    public KeyBoard( GameBoard gameBoard ){
        this.gameBoard = gameBoard;
    }


    @Override
	public void keyTyped(KeyEvent e) {}

    @Override
	public void keyReleased(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        node =  gameBoard.getFirst();
        String dir = node.getDirection();
        int x = node.getX();
        if( gameBoard.getGameOver() == false ){
            switch (keyCode) {
                case KeyEvent.VK_UP :
                    gameBoard.setNow("UP");
                    if( dir.equals("UP") && x == 110) gameBoard.updateDir();
                    else gameBoard.setCombo(0);
                    break;
                case KeyEvent.VK_DOWN :
                    gameBoard.setNow("DOWN");
                    if( dir.equals("DOWN") && x == 110) gameBoard.updateDir();
                    else gameBoard.setCombo(0);
                    break; 
                case KeyEvent.VK_LEFT :
                    gameBoard.setNow("LEFT");
                    if( dir.equals("LEFT") && x == 110) gameBoard.updateDir();
                    else gameBoard.setCombo(0);
                    break;
                case KeyEvent.VK_RIGHT :
                    gameBoard.setNow("RIGHT");
                    if( dir.equals("RIGHT") && x == 110) gameBoard.updateDir();
                    else gameBoard.setCombo(0);
                    break;
                default:
                    break;
            }
            gameBoard.repaint();
        }
    }

}
/*
class Player2KeyBoard extends KeyBoard {
    
    Player2KeyBoard( GameBoard gameBoard ){
        super(gameBoard);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        String dir = gameBoard.getSnake().getHead().getDirection();
        switch (keyCode) {
            case KeyEvent.VK_W :
                if( !(dir.equals("DOWN")) ) gameBoard.getSnake().getHead().setDirection("UP");
                break;
            case KeyEvent.VK_S :
                if( !(dir.equals("UP")) ) gameBoard.getSnake().getHead().setDirection("DOWN");
                break;
            case KeyEvent.VK_A :
                if( !(dir.equals("RIGHT")) ) gameBoard.getSnake().getHead().setDirection("LEFT");
                break;
            case KeyEvent.VK_D :
                if( !(dir.equals("LEFT")) ) gameBoard.getSnake().getHead().setDirection("RIGHT");
                break;
            default:
                break;
        }
        gameBoard.repaint();
    }
}
*/