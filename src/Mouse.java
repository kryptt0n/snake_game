public class Mouse {

    public static String mouseImgDir;
    private int x;
    private int y;

    static {
        mouseImgDir = "E:\\Java Projects\\GameSnake\\SnakeGame\\images\\mouse\\myshka-sosiska.png";
    }

    public Mouse(int x, int y) {
        this.x = x % 2 == 0 ? x : x + 1;
        this.y = y % 2 == 0 ? y : y + 1;;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
