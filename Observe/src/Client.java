/**
 * Created by Administrator on 2019/5/23.
 */

import java.util.ArrayList;

interface Observer
{
    //抽象观察者
    public void response();
}

interface Subject
{
    //抽象主题
    public void addObserver(Observer obs);
}

class TempSensor implements Subject
{
    //具体主题（温度传感器）
    private int nTemperature = 0;
    private ArrayList<Observer>list=new ArrayList<Observer>();
    public void addObserver(Observer obs)
    {
        list.add(obs);
    }
    public void nSetTemperature(int nTemperature)
    {
        this.nTemperature = nTemperature;
        System.out.println("温度变化为："+nTemperature);
        if (nTemperature > 100)
        {
            System.out.println("温度过高！已达到："+nTemperature);
            for(Object obj:list)
            {
                ((Observer)obj).response();
            }
        }
    }
}

class AlertLight implements Observer
{
    //具体观察者（警示灯）
    private String name;
    public AlertLight(String name,Subject subject)
    {
        this.name=name;
        subject.addObserver(this);
    }
    public void response()
    {
        System.out.println("警示灯【"+this.name+"】：闪烁！");
    }
}

class AlertSound implements Observer
{
    //具体观察者（警报器）
    private String name;
    public AlertSound(String name,Subject subject)
    {
        this.name=name;
        subject.addObserver(this);
    }
    public void response()
    {
        System.out.println("警报器【"+this.name+"】：鸣笛！");
    }
}

class SafeDoor implements Observer
{
    //具体观察者（安全逃生门）
    private String name;
    public SafeDoor(String name,Subject subject)
    {
        this.name=name;
        subject.addObserver(this);
    }
    public void response()
    {
        System.out.println("安全逃生门【"+this.name+"】：开启！");
    }
}

class DefentHotDoor implements Observer
{
    //具体观察者（隔热门）
    private String name;
    public DefentHotDoor(String name,Subject subject)
    {
        this.name=name;
        subject.addObserver(this);
    }
    public void response()
    {
        System.out.println("隔热门【"+this.name+"】：关闭！");
    }
}

public class Client
{
    public static void main(String[] args)
    {
        Subject tempsensor=new TempSensor();
        Observer alertlight1,alertlight2,alertsound1,alertsound2,safedoor,defenthotdoor;
        alertlight1 = new AlertLight("警示灯-绿色",tempsensor);
        alertlight2 = new AlertLight("警示灯-红色",tempsensor);
        alertsound1 = new AlertSound("警报器-长声",tempsensor);
        alertsound2 = new AlertSound("警报器-短声",tempsensor);
        safedoor = new SafeDoor("安全门-1",tempsensor);
        defenthotdoor = new DefentHotDoor("隔热门-1",tempsensor);

        ((TempSensor) tempsensor).nSetTemperature(10);
        ((TempSensor) tempsensor).nSetTemperature(101);
    }
}


