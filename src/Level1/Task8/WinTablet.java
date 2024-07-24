package Level1.Task8;

import javax.swing.*;
import java.awt.*;

public class WinTablet extends JFrame {

    static final int WINDOW_X = 750;
    static final int WINDOW_Y = 550;
    static final int WINDOW_WIDTH = 300;
    static final int WINDOW_HEIGHT = 300;

    private GameWindow gameWindow;
    private SettingWindow settingWindow;

    public WinTablet(GameWindow gameWindow) {
        this.gameWindow = gameWindow;
    }

    public void winTablet(int winFlag) {
        setResizable(false);
        JButton btnStartAGame = new JButton("Start new game");
        add(btnStartAGame, BorderLayout.SOUTH);
        settingWindow = new SettingWindow(gameWindow);
        btnStartAGame.addActionListener(e -> {
            settingWindow.setVisible(true);
            setVisible(false);
        });

        setBounds(WINDOW_X, WINDOW_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        Font font = new Font("Arial", Font.BOLD, 36);
        textArea.setFont(font);
        add(textArea, BorderLayout.CENTER);
        if (winFlag == 1) {
            textArea.append("\n");
            textArea.append("\n");
            textArea.append("    You WIN !!!");
        } else if (winFlag == 0) {
            setBounds(WINDOW_X, WINDOW_Y, WINDOW_WIDTH + 20, WINDOW_HEIGHT);
            textArea.append("\n");
            textArea.append("\n");
            textArea.append("Nice try. It's draw");
        } else if (winFlag == -1) {
            textArea.append("\n");
            textArea.append("\n");
            textArea.append("    You LOSE :(");
        } else if (winFlag == 2) {
            textArea.append("\n");
            textArea.append("\n");
            textArea.append("  Выиграли Х !!!");
        } else if (winFlag == 3) {
            textArea.append("\n");
            textArea.append("\n");
            textArea.append("  Выиграли 0 !!!");
        }

        setVisible(false);
    }

}
