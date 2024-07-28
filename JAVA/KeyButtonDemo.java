import java.awt.*;
import java.awt.event.*;
public class KeyButtonDemo extends Frame implements KeyListener, ActionListener {
    Button yesButton, noButton, exitButton;
    String message = "";

    public KeyButtonDemo() {
        // Frame setup
        setLayout(new FlowLayout());
        setSize(300, 200);
        setTitle("Key Button Demo");
        setVisible(true);

        // Initialize buttons
        yesButton = new Button("Yes");
        noButton = new Button("No");
        exitButton = new Button("Exit");

        // Add buttons to the frame
        add(yesButton);
        add(noButton);
        add(exitButton);

        // Add action listeners to buttons
        yesButton.addActionListener(this);
        noButton.addActionListener(this);
        exitButton.addActionListener(this);

        // Add key listener to the frame
        addKeyListener(this);
        setFocusable(true);

        // Window listener to close the frame
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }

    public void paint(Graphics g) {
        g.drawString(message, 10, 100);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == yesButton) {
            message = "You pressed Yes";
        } else if (e.getSource() == noButton) {
            message = "You pressed No";
        } else if (e.getSource() == exitButton) {
            message = "Exiting...";
            System.exit(0);
        }
        repaint();
    }

    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        String keyText = KeyEvent.getKeyText(keyCode);
        message = "Key Pressed: " + keyText;
        repaint();
    }

    public void keyReleased(KeyEvent e) {
        // Not used in this example, but can be implemented for specific actions
    }

    public void keyTyped(KeyEvent e) {
        // Not used in this example, but can be implemented for specific key input
    }

    public static void main(String[] args) {
        new KeyButtonDemo();
    }
}