import java.util.ArrayList;
import java.util.List;

public class Snake {
    private List<SnakeSection> sections;
    private boolean isAlive;
    private SnakeDirection direction;

    public Snake(int x, int y) {
        sections = new ArrayList<>();
        sections.add(new SnakeSection(x,y));
        isAlive = true;
    }

    public int getX() {
        return sections.get(0).getX();
    }

    public int getY() {
        return sections.get(0).getY();
    }

    public void move() {
        if (!isAlive)
            return;

        switch (direction) {
            case UP:
                move(0, -1);
                break;
            case DOWN:
                move(0, 1);
                break;
            case LEFT:
                move(-1,0);
                break;
            case RIGHT:
                move(1, 0);
                break;
        }
    }
    public void move(int x, int y) {
        
    }

    public void checkBorders (SnakeSection head) {
        int width = Room.game.getWidth();
        int height = Room.game.getHeight();
        int x = head.getX();
        int y = head.getY();
        if (x >= width || y >= height || x < 0 || y < 0)
            isAlive = false;
    }

    public void checkBody (SnakeSection head) {
        if (sections.contains(head)) {
            isAlive = false;
        }
    }

    public void setDirection(SnakeDirection direction) {
        this.direction = direction;
    }

    public List<SnakeSection> getSections() {
        return sections;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public SnakeDirection getDirection() {
        return direction;
    }
}
