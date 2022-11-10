import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Layer extends JPanel {
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(java.awt.Color.GREEN); //Задаем цвет элементов зеленый
        g.fillRect(Room.game.getWidth() * 10, 0, 10, (Room.game.getWidth() * 10) + 10);  //Рисуем прямоугольник показывающий край поля справа
        g.fillRect(0, Room.game.getHeight() * 10, (Room.game.getHeight() * 10) + 10, 10); //Рисуем прямоугольник показывающий край поля снизу

        ArrayList<SnakeSection> getsection = Room.game.getSnake().getSections(); //Получаем секции змейки


        BufferedImage mouseImage;
        try {
            mouseImage = ImageIO.read(new File(Mouse.mouseImgDir));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        g.drawImage(mouseImage, Room.game.getMouse().getX()*10, Room.game.getMouse().getY()*10, null );

        for (int i = getsection.size() - 1; i > 0; i--) {
            getsection.get(i).setDirection(getsection.get(i - 1).getDirection());
        }

        for (int i = 0; i < getsection.size(); i++) {
            if (i== 0) {
                BufferedImage snakeHeadImage = SnakeSection.getHeadImage(getsection.get(i).getDirection());
                g.drawImage(snakeHeadImage, getsection.get(i).getX() * 10, getsection.get(i).getY() * 10, null );
            } else if (i == getsection.size() - 1){
                BufferedImage snakeTailImage = SnakeSection.getTailImage(getsection.get(i).getDirection());;
                g.drawImage(snakeTailImage, getsection.get(i).getX() * 10, getsection.get(i).getY() * 10, null );
            } else {
                BufferedImage snakeBodyImage = SnakeSection.getBodyImage(getsection.get(i).getDirection());;
                g.drawImage(snakeBodyImage, getsection.get(i).getX() * 10, getsection.get(i).getY() * 10, null );
            }
        }

    }

}
