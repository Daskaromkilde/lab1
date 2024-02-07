package oscarSkit;

import java.awt.*;

public class gamelooptest implements Runnable {
    private GamePanel gamePanel;
    private Car car;
    private final int FPS = 60; // Target frames per second
    private boolean running = false;

    public synchronized void start() {
        running = true;
        new Thread(this).start();
    }
    public void setCar(Car car) {
        this.car = car;
    }


    public synchronized void stop() {
        running = false;
    }
    public void setGamePanel(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    private void render() {
        if (gamePanel != null) {
            gamePanel.repaint();
        }
    }
    @Override
    public void run() {
        long lastTime = System.nanoTime();
        double nsPerTick = 1000000000.0 / FPS;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;

        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / nsPerTick;
            lastTime = now;

            while (delta >= 1) {
                tick(); // Update game state
                delta--;
            }

            render(); // Render the game
            frames++;

            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                System.out.println(frames + " frames per second");
                frames = 0;
            }
        }
    }

    private void tick() {
        // Assuming you have a car object and a reference to the oscarSkit.GamePanel or its dimensions
        car.move(car.getDirection());

        // Get car's current position
        Point pos = car.getPosition();

        // Get dimensions of the game panel
        int panelWidth = gamePanel.getWidth();
        int panelHeight = gamePanel.getHeight();

        // Check for horizontal wraparound
        if (pos.x > panelWidth) {
            car.setPosition(new Point(0, pos.y)); // Wrap to left side
        } else if (pos.x < 0) {
            car.setPosition(new Point(panelWidth, pos.y)); // Wrap to right side
        }

        // Check for vertical wraparound
        if (pos.y > panelHeight) {
            car.setPosition(new Point(pos.x, 0)); // Wrap to top
        } else if (pos.y < 0) {
            car.setPosition(new Point(pos.x, panelHeight)); // Wrap to bottom
        }
    }



    public static void main(String[] args) {
        new gamelooptest().start();
    }
}
