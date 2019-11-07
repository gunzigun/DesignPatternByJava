import java.util.ArrayList;

/**
 * Created by Administrator on 2019/5/16.
 */
abstract class AbstractOA
{
    public abstract void add(AbstractOA oa);
    public abstract void remove(AbstractOA oa);
    public abstract AbstractOA get(int i);
    public abstract void PublishNote();
}

class OfficeRoom extends AbstractOA
{
    private String name;
    public OfficeRoom(String name)
    {
        this.name = name;
    }

    @Override
    public void add(AbstractOA oa)
    {
        System.out.println("---不支持该方法");
    }

    @Override
    public void remove(AbstractOA oa)
    {
        System.out.println("---不支持该方法");
    }

    @Override
    public AbstractOA get(int i)
    {
        System.out.println("---不支持该方法");
        return null;
    }

    @Override
    public void PublishNote()
    {
        System.out.println("办公室："+name+"，发布公告");
    }
}

class SubOA extends AbstractOA
{
    private String name;
    private ArrayList<AbstractOA> oalist = new ArrayList<AbstractOA>();
    public SubOA(String name)
    {
        this.name = name;
    }

    @Override
    public void add(AbstractOA oa)
    {
        oalist.add(oa);
    }

    @Override
    public void remove(AbstractOA oa)
    {
        oalist.remove(oa);
    }

    @Override
    public AbstractOA get(int i)
    {
        return (AbstractOA)oalist.get(i);
    }

    @Override
    public void PublishNote()
    {
        System.out.println("OA系统："+name+"，发布公告");
        for(Object obj:oalist)
        {
            ((AbstractOA)obj).PublishNote();
        }
    }
}


public class Client
{
    public static void main(String[] args)
    {
        AbstractOA officeroom1,officeroom2,officeroom3,officeroom4,officeroom5,officeroom6;
        officeroom1 = new OfficeRoom("北京教务办公室");
        officeroom2 = new OfficeRoom("北京行政办公室");
        officeroom3 = new OfficeRoom("湖南教务办公室");
        officeroom4 = new OfficeRoom("湖南行政办公室");
        officeroom5 = new OfficeRoom("长沙教务办公室");
        officeroom6 = new OfficeRoom("长沙行政办公室");

        AbstractOA suboa1,suboa2,suboa3;
        suboa1 = new SubOA("北京总部");
        suboa2 = new SubOA("湖南分校");
        suboa3 = new SubOA("长沙教学点");

        suboa3.add(officeroom5);
        suboa3.add(officeroom6);
        suboa2.add(officeroom3);
        suboa2.add(suboa3);
        suboa2.add(officeroom4);
        suboa1.add(officeroom1);
        suboa1.add(suboa2);
        suboa1.add(officeroom2);

        suboa1.PublishNote();
    }
}
