package mp3_player;

import java.awt.*;
import javax.swing.*;

public class RoundButton extends JButton {

    public RoundButton() {
        setContentAreaFilled(false);  
        setFocusPainted(false);
        setBorderPainted(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        // Smooth edges
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                            RenderingHints.VALUE_ANTIALIAS_ON);

        // Background color
        g2.setColor(getBackground());
        g2.fillOval(0, 0, getWidth(), getHeight());

        super.paintComponent(g);
    }

    @Override
    public boolean contains(int x, int y) {
        int radius = getWidth() / 2;
        int centerX = radius;
        int centerY = radius;

        // Circle hit detection
        return ((x - centerX) * (x - centerX) + 
                (y - centerY) * (y - centerY)) <= radius * radius;
    }
}