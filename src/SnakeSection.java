import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class SnakeSection {
    private int x;
    private int y;

    private static HashMap<SnakeDirection, String> snakeHeadImgSources;
    private static HashMap<SnakeDirection, String> snakeBodyImgSources;
    private static HashMap<SnakeDirection, String> snakeTailImgSources;

    private SnakeDirection direction;

    static {
        snakeHeadImgSources = new HashMap<>();
        snakeBodyImgSources = new HashMap<>();
        snakeTailImgSources = new HashMap<>();

        snakeHeadImgSources.put(SnakeDirection.UP, "E:\\Java Projects\\GameSnake\\SnakeGame\\images\\snakeHead\\snakeup.png");
        snakeHeadImgSources.put(SnakeDirection.DOWN, "E:\\Java Projects\\GameSnake\\SnakeGame\\images\\snakeHead\\snakedown.png");
        snakeHeadImgSources.put(SnakeDirection.LEFT, "E:\\Java Projects\\GameSnake\\SnakeGame\\images\\snakeHead\\snakeleft.png");
        snakeHeadImgSources.put(SnakeDirection.RIGHT, "E:\\Java Projects\\GameSnake\\SnakeGame\\images\\snakeHead\\snakeright.png");

        snakeBodyImgSources.put(SnakeDirection.UP, "E:\\Java Projects\\GameSnake\\SnakeGame\\images\\snakeBody\\bodyup.png");
        snakeBodyImgSources.put(SnakeDirection.DOWN, "E:\\Java Projects\\GameSnake\\SnakeGame\\images\\snakeBody\\bodydown.png");
        snakeBodyImgSources.put(SnakeDirection.LEFT, "E:\\Java Projects\\GameSnake\\SnakeGame\\images\\snakeBody\\bodyleft.png");
        snakeBodyImgSources.put(SnakeDirection.RIGHT, "E:\\Java Projects\\GameSnake\\SnakeGame\\images\\snakeBody\\bodyright.png");

        snakeTailImgSources.put(SnakeDirection.UP, "E:\\Java Projects\\GameSnake\\SnakeGame\\images\\snakeTail\\tailup.png");
        snakeTailImgSources.put(SnakeDirection.DOWN, "E:\\Java Projects\\GameSnake\\SnakeGame\\images\\snakeTail\\taildown.png");
        snakeTailImgSources.put(SnakeDirection.LEFT, "E:\\Java Projects\\GameSnake\\SnakeGame\\images\\snakeTail\\tailleft.png");
        snakeTailImgSources.put(SnakeDirection.RIGHT, "E:\\Java Projects\\GameSnake\\SnakeGame\\images\\snakeTail\\tailright.png");

    }

    public SnakeSection(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public SnakeDirection getDirection() {
        return direction;
    }

    public void setDirection(SnakeDirection direction) {
        this.direction = direction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SnakeSection that = (SnakeSection) o;

        if (x != that.x) return false;
        if (y != that.y) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }

    public static BufferedImage getHeadImage(SnakeDirection direction) {
        BufferedImage snakeHeadImage = null;
        try {
            snakeHeadImage = ImageIO.read(new File(snakeHeadImgSources.get(direction)));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return snakeHeadImage;
    }

    public static BufferedImage getBodyImage(SnakeDirection direction) {
        BufferedImage snakeBodyImage = null;
        try {
            snakeBodyImage = ImageIO.read(new File(snakeBodyImgSources.get(direction)));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return snakeBodyImage;
    }

    public static BufferedImage getTailImage(SnakeDirection direction) {
        BufferedImage snakeTailImage = null;
        try {
            snakeTailImage = ImageIO.read(new File(snakeTailImgSources.get(direction)));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return snakeTailImage;
    }
}
