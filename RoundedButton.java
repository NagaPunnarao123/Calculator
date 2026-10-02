import java.awt.*;
import javax.swing.*;

public class RoundedButton extends JButton {

    private Color backgroundColor;
    private Color hoverColor;
    private boolean hovered = false;

    public RoundedButton(String text, Color bg, Color hover) {
        super(text);
        backgroundColor = bg;
        hoverColor = hover;

        setContentAreaFilled(false);
        setFocusPainted(false);
        setBorderPainted(false);
        setForeground(Color.WHITE);
        setFont(new Font("Segoe UI", Font.BOLD, 20));
        setCursor(new Cursor(Cursor.HAND_CURSOR));

        addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                hovered = true;
                repaint();
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
                hovered = false;
                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {

        Graphics2D g2 = (Graphics2D) g.create();

        g2.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        if (hovered)
            g2.setColor(hoverColor);
        else
            g2.setColor(backgroundColor);

        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 25, 25);

        super.paintComponent(g);

        g2.dispose();
    }
}