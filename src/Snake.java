import java.util.ArrayList;

/**
 * Класс змея
 */
public class Snake {
    public static String snakeHeadImgDir;
    public static String snakeTailImgDir;
    public static String snakeBodyImgDir;
    // Направление движения змеи
    private SnakeDirection direction;
    // Состояние - жива змея или нет.
    private boolean isAlive;
    // Список кусочков змеи.
    private ArrayList<SnakeSection> sections;


    public Snake(int x, int y) {
        sections = new ArrayList<SnakeSection>();
        sections.add(new SnakeSection(x, y));
        isAlive = true;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public int getX() {
        return sections.get(0).getX();
    }

    public int getY() {
        return sections.get(0).getY();
    }

    public SnakeDirection getDirection() {
        return direction;
    }

    public void setDirection(SnakeDirection direction) {
        this.direction = direction;
    }

    public ArrayList<SnakeSection> getSections() {
        return sections;
    }

    /**
     * Метод перемещает змею на один ход.
     * Направление перемещения задано переменной direction.
     */
    public void move() {
        if (!isAlive) return;

        if (direction == SnakeDirection.UP)
            move(0, -2);
        else if (direction == SnakeDirection.RIGHT)
            move(2, 0);
        else if (direction == SnakeDirection.DOWN)
            move(0, 2);
        else if (direction == SnakeDirection.LEFT)
            move(-2, 0);
    }

    /**
     * Метод перемещает змею в соседнюю клетку.
     * Координаты клетки заданы относительно текущей головы с помощью переменных (dx, dy).
     */
    private void move(int dx, int dy) {
        // Создаем новую голову - новый "кусочек змеи".
        SnakeSection head = sections.get(0);
        head = new SnakeSection(head.getX() + dx, head.getY() + dy);
        head.setDirection(direction);
        // Проверяем - не вылезла ли голова за границу комнаты
        checkBorders(head);
        if (!isAlive) return;

        // Проверяем - не пересекает ли змея  саму себя
        checkBody(head);
        if (!isAlive) return;

        // Проверяем - не съела ли змея мышь.
        Mouse mouse = Room.game.getMouse();
        if (head.getX() == mouse.getX() && head.getY() == mouse.getY()) // съела
        {
            sections.add(0, head);                  // Добавили новую голову
            Room.game.eatMouse();                   // Хвост не удаляем, но создаем новую мышь.
        } else // просто движется
        {
            sections.add(0, head);                  // добавили новую голову
            sections.remove(sections.size() - 1);   // удалили последний элемент с хвоста
        }
    }

    /**
     * Метод проверяет - находится ли новая голова в пределах комнаты
     */
    private void checkBorders(SnakeSection head) {
        if ((head.getX() < 0 || head.getX() >= Room.game.getWidth()) || head.getY() < 0 || head.getY() >= Room.game.getHeight()) {
            isAlive = false;
        }
    }

    /**
     * Метод проверяет - не совпадает ли голова с каким-нибудь участком тела змеи.
     */
    private void checkBody(SnakeSection head) {
        if (sections.contains(head)) {
            isAlive = false;
        }
    }

    public void changeSnakeHeadDir() {
        switch (direction) {
            case UP:
                snakeHeadImgDir = "E:\\Java Projects\\GameSnake\\SnakeGame\\images\\snakeHead\\snakeup.png";
                break;
            case DOWN:
                snakeHeadImgDir = "E:\\Java Projects\\GameSnake\\SnakeGame\\images\\snakeHead\\snakedown.png";
                break;
            case LEFT:
                snakeHeadImgDir = "E:\\Java Projects\\GameSnake\\SnakeGame\\images\\snakeHead\\snakeleft.png";
                break;
            case RIGHT:
                snakeHeadImgDir = "E:\\Java Projects\\GameSnake\\SnakeGame\\images\\snakeHead\\snakeright.png";
                break;
        }
    }

//    public void changeSnakeBodyDir() {
//        switch (direction) {
//            case UP:
//                snakeBodyImgDir = "E:\\Java Projects\\GameSnake\\SnakeGame\\images\\snakeBody\\bodyup.png";
//                break;
//            case DOWN:
//                snakeBodyImgDir = "E:\\Java Projects\\GameSnake\\SnakeGame\\images\\snakeBody\\bodydown.png";
//                break;
//            case LEFT:
//                snakeBodyImgDir = "E:\\Java Projects\\GameSnake\\SnakeGame\\images\\snakeBody\\bodyleft.png";
//                break;
//            case RIGHT:
//                snakeBodyImgDir = "E:\\Java Projects\\GameSnake\\SnakeGame\\images\\snakeBody\\bodyright.png";
//                break;
//        }
//    }
//
//    public void changeSnakeTailDir() {
//        switch (direction) {
//            case UP:
//                snakeTailImgDir = "E:\\Java Projects\\GameSnake\\SnakeGame\\images\\snakeTail\\tailup.png";
//                break;
//            case DOWN:
//                snakeTailImgDir = "E:\\Java Projects\\GameSnake\\SnakeGame\\images\\snakeTail\\taildown.png";
//                break;
//            case LEFT:
//                snakeTailImgDir = "E:\\Java Projects\\GameSnake\\SnakeGame\\images\\snakeTail\\tailleft.png";
//                break;
//            case RIGHT:
//                snakeTailImgDir = "E:\\Java Projects\\GameSnake\\SnakeGame\\images\\snakeTail\\tailright.png";
//                break;
//        }
//    }
}
