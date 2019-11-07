/**
 * Created by Administrator on 2019/5/23.
 */
abstract class Command
{
    public abstract void ExecuteOn();
    public abstract void ExecuteOff();
}

abstract class Receiver
{
    public abstract void Open();
    public abstract void Close();
}

class Ligth extends Receiver
{
    @Override
    public void Open()
    {
        System.out.println("灯：好的，我开！");
    }
    @Override
    public void Close()
    {
        System.out.println("灯：好的，我关！");
    }
}

class Fan extends Receiver
{
    @Override
    public void Open()
    {
        System.out.println("风扇：好的，我开！");
    }
    @Override
    public void Close()
    {
        System.out.println("风扇：好的，我关！");
    }
}

class LightCommand extends Command
{
    //维持一个对请求接收者对象的引用
    private Receiver receiver;
    public LightCommand(Receiver receiver)
    {
        this.receiver = receiver;
    }
    @Override
    public void ExecuteOn()
    {
        System.out.println("命令：请开灯");
        receiver.Open();
    }
    @Override
    public void ExecuteOff()
    {
        System.out.println("命令：请关灯");
        receiver.Close();
    }
}

class FanCommand extends Command
{
    //维持一个对请求接收者对象的引用
    private Receiver receiver;
    public FanCommand(Receiver receiver)
    {
        this.receiver = receiver;
    }
    @Override
    public void ExecuteOn()
    {
        System.out.println("命令：请开风扇");
        receiver.Open();
    }
    @Override
    public void ExecuteOff()
    {
        System.out.println("命令：请关风扇");
        receiver.Close();
    }
}

class Switch
{
    private Command command;
    public Switch(Command command) //构造注入
    {
        this.command=command;
    }

    public void on()
    {
        command.ExecuteOn();
    }

    public void off()
    {
        command.ExecuteOff();
    }
}

public class Client
{
    public static void main(String[] args)
    {
        Receiver fan = new Fan();
        Command fancommond = new FanCommand(fan);
        Switch switch1 = new Switch(fancommond);
        switch1.on();
        switch1.off();
    }
}
