package tetris.sample;

import javax.swing.*;
import java.awt.*;

public class MovingTetrisBlock extends JPanel implements Runnable {
    private static final int BLOCK_SIZE = 30;
    private static final int WINDOW_WIDTH = 300;
    private static final int WINDOW_HEIGHT = 600;
    private int x, y;

    public MovingTetrisBlock() {
        x = WINDOW_WIDTH / 2 - BLOCK_SIZE / 2;
        y = 0;
        setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
        setBackground(Color.WHITE);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.RED);
        g.fillRect(x, y, BLOCK_SIZE, BLOCK_SIZE);
    }

    @Override
    public void run() {
        while (y + BLOCK_SIZE < WINDOW_HEIGHT) {
            y += 5; // move block down by 5 pixels each time
            repaint();
            try {
                Thread.sleep(50); // pause for 50 milliseconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Tetris Block");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            MovingTetrisBlock block = new MovingTetrisBlock();
            frame.add(block);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
            Thread thread = new Thread(block);
            thread.start();
        });
    }
}
