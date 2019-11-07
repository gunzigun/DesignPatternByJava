/**
 * Created by Administrator on 2019/5/30.
 */
abstract class SortStrategy
{
    public abstract void sort(); //声明抽象算法
}

class PaopaoSort extends SortStrategy
{
    @Override
    public void sort()
    {
        System.out.println("进行冒泡排序！");
    }
}

class SelectSort extends SortStrategy
{
    @Override
    public void sort()
    {
        System.out.println("进行选择排序！");
    }
}

class InsertSort extends SortStrategy
{
    @Override
    public void sort()
    {
        System.out.println("进行插入排序！");
    }
}

class SortContext
{
    private SortStrategy strategy;
    public void setStrategy(SortStrategy strategy)
    {
        this.strategy= strategy;
    }
    //调用策略类中的算法
    public void sort()
    {
        strategy.sort();
    }
}

class Array
{
    private SortContext sortcontext = new SortContext();
    public void find()
    {
        System.out.println("我是查找方法！");
    }
    public void sort(SortStrategy strategy)
    {
        System.out.println("我是排序方法！");
        sortcontext.setStrategy(strategy);
        sortcontext.sort();
    }
}


public class Client
{
    public static void main(String[] args)
    {
        Array array = new Array();
        array.find();

        SortStrategy sortstrategy1 = new PaopaoSort();
        array.sort(sortstrategy1);

        SortStrategy sortstrategy2 = new SelectSort();
        array.sort(sortstrategy2);
    }
}
