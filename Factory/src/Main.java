/**
 * Created by Administrator on 2019/4/4.
 */

// 抽象产品
interface Shape
{
    public void Draw();
}

class Circle implements Shape
{
    Circle()
    {
        System.out.println("初始化圆形");
    }
    @Override
    public void Draw()
    {
        System.out.println("显示圆形");
    }
}

class Rectangle implements Shape
{
    Rectangle()
    {
        System.out.println("初始化矩形");
    }
    @Override
    public void Draw()
    {
        System.out.println("显示矩形");
    }
}

class ShapeFactory
{
    static Shape getShape(String type)
    {
        Shape shape = null;
        if (type.equals("圆形"))
        {
            shape = new Circle();
        }
        else if(type.equals("矩形"))
        {
            shape = new Rectangle();
        }
        return shape;
    }

}

public class Main
{
    public static void main(String[] args)
    {
        Shape circle = ShapeFactory.getShape("圆形");
        circle.Draw();

        Shape rectangle = ShapeFactory.getShape("矩形");
        rectangle.Draw();
    }
}
