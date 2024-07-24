package Level1.Task8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BattleMap extends JPanel {
    private GameWindow gameWindow;

    static final int MODE_H_VS_AI = 0;
    static final int MODE_H_VS_H = 1;
    static final int XO_SIZE = 4;

    private int mode;
    private int fieldSize;
    private int winningLength;

    private boolean isInit;

    private int userNumber;

    private int cellWidth;
    private int cellHeight;

    private Logic winFlag;

    public void startNewGame(int mode, int fieldSize, int winningLength) {
        this.mode = mode;
        this.fieldSize = fieldSize;
        this.winningLength = winningLength;

        isInit = true;
        repaint();
    }

    public BattleMap(GameWindow gameWindow) {
        this.gameWindow = gameWindow;
        winFlag = new Logic();

        setBackground(Color.ORANGE);

        userNumber = 1;

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                int cellX = e.getX() / cellWidth;
                int cellY = e.getY() / cellHeight;

                if (!Logic.gameFinished) {
                    Logic.humanTurn(cellX, cellY, mode, userNumber);
                    if (winFlag.getWinFlag() >= -1 && winFlag.getWinFlag() <= 3) {
                        gameWindow.winWindow(winFlag.getWinFlag());
                    }
                    // тут можете проверить кто победил и вывести результат графически
                    // например через gameWindow
                }
                if (userNumber == 1) {
                    userNumber = 2;
                } else {
                    userNumber = 1;
                }
                repaint();
            }
        });
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (!isInit) {
            return;
        }

        cellHeight = getHeight() / fieldSize;
        cellWidth = getWidth() / fieldSize;

        for (int i = 1; i < fieldSize; i++) {
            int y = i * cellHeight;
            g.drawLine(0, y, getWidth(), y);
        }

        for (int i = 1; i < fieldSize; i++) {
            int x = i * cellWidth;
            g.drawLine(x, 0, x, getHeight());
        }

        for (int i = 0; i < Logic.SIZE; i++) {
            for (int j = 0; j < Logic.SIZE; j++) {
                if(Logic.map[i][j] == Logic.DOT_X){
                    drawX(g, j, i);
                }
                if(Logic.map[i][j] == Logic.DOT_O){
                    drawO(g, j, i);
                }
            }
        }
    }

    private void drawX(Graphics g, int cellX, int cellY) {
        ((Graphics2D) g).setStroke(new BasicStroke(5));
        g.setColor(Color.RED);
        g.drawLine(cellX * cellWidth  + cellWidth / XO_SIZE, cellY * cellHeight  + cellHeight / XO_SIZE,
                (cellX + 1) * cellWidth  - cellWidth / XO_SIZE, (cellY + 1) * cellHeight  - cellHeight / XO_SIZE);
        g.drawLine((cellX + 1) * cellWidth - cellWidth / XO_SIZE, cellY * cellHeight + cellHeight / XO_SIZE,
                (cellX) * cellWidth + cellWidth / XO_SIZE, (cellY + 1) * cellHeight - cellHeight / XO_SIZE);
    }

    private void drawO(Graphics g, int cellX, int cellY) {
        ((Graphics2D) g).setStroke(new BasicStroke(5));
        g.setColor(Color.BLACK);
        g.drawOval(cellX * cellWidth + cellWidth / (XO_SIZE * 2), cellY * cellHeight + cellHeight / (XO_SIZE * 2), cellWidth - cellWidth / XO_SIZE, cellHeight - cellHeight / XO_SIZE);
    }
}
