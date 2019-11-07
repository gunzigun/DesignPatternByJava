/**
 * Created by Administrator on 2019/5/9.
 */
class PoliceSound
{
    public void alarmSound()
    {
        System.out.println("控制鸣笛（已有）！");
    }
}

class PoliceLamp
{
    public void alarmLamp()
    {
        System.out.println("控制闪烁（已有）！");
    }
}

abstract class CarController
{
    void move(){};
    void phonate(){};
    void twinkle(){};
}


class PoliceCarAdapter extends CarController
{
    PoliceSound sound;
    PoliceLamp lamp;

    public PoliceCarAdapter()
    {
        sound = new PoliceSound();
        lamp = new PoliceLamp();
    }

    void move()
    {
        System.out.println("控制移动（本身）");
    }

    void phonate()
    {
        sound.alarmSound();
    }
    void twinkle()
    {
        lamp.alarmLamp();
    }
}

public class Client
{
    public static void main(String[] args)
    {
        CarController carcontro = new PoliceCarAdapter();
        carcontro.move();
        carcontro.phonate();
        carcontro.twinkle();
    }
}
