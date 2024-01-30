import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class javaSwingTest {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowGUI();
            }
        });
    }

    private static void createAndShowGUI() {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(1920, 1080);

        int midWidth = f.getSize().width / 2;
        int midHeight = f.getSize().height / 2;

        gamelooptest gameLoop = new gamelooptest();
        Car volvo = new Volvo240(); // Create a Volvo240 instance
        volvo.setPosition(new Point(midWidth, midHeight));
        gameLoop.setCar(volvo);
        GamePanel panel = new GamePanel(gameLoop, volvo); // Pass the Volvo240 to the panel
        f.add(panel);

        f.setVisible(true);
        gameLoop.start();
    }
}


class GamePanel extends JPanel {
    private Car car;

    public GamePanel(gamelooptest gameLoop, Car car) {
        this.car = car;
        gameLoop.setGamePanel(this);
        setFocusable(true);
        addKeyBindings();
    }

    private void addKeyBindings() {
        getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("W"), "accelerate");
        getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("S"), "brake");
        getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("D"), "turnLeft");
        getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("A"), "turnRight");
        getActionMap().put("accelerate", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                car.gas(1.0); // Full acceleration
            }
        });
        getActionMap().put("brake", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                car.brake(1.0); // Full acceleration
            }
        });

        getActionMap().put("turnLeft", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                car.turnLeft(); // Full acceleration
            }
        });
        getActionMap().put("turnRight", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                car.turnRight(); // Full acceleration
            }
        });
        // Repeat for A, S, D with appropriate actions
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawCar(g, car);
        drawSpeed(g, car);
    }

    private void drawCar(Graphics g, Car car) {
        if (car != null) {
            Point position = car.getPosition();
            g.setColor(car.getColor());
            g.fillRect(position.x, position.y, 50, 30); // Drawing the car as a rectangle for now
        }
    }
    private void drawSpeed(Graphics g, Car car) {
        if (car != null) {
            g.setColor(Color.BLACK); // Set the text color
            g.setFont(new Font("Arial", Font.BOLD, 14)); // Set the font

            // Get the current speed
            String speedText = String.format("Speed: %.2f", car.getCurrentSpeed());

            // Calculate position to draw (top right corner)
            int x = getWidth() - g.getFontMetrics().stringWidth(speedText) - 10;
            int y = g.getFontMetrics().getAscent() + 10;

            g.drawString(speedText, x, y);
        }
    }
}
