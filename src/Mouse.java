public class Mouse {
    private int x;
    private int y;

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
