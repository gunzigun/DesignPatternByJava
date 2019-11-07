/**
 * Created by Administrator on 2019/4/8.
 */

// 执行接口
interface Excutive
{
    public void approve();
}

class HealthOffice implements Excutive
{
    @Override
    public void approve()
    {
        System.out.println("卫生局通过审批");
    }
}

class RevenueOffice implements Excutive
{
    @Override
    public void approve()
    {
        System.out.println("税务局完成登记，定时会去收税");
    }
}

class SaicOffice implements Excutive
{
    @Override
    public void approve()
    {
        System.out.println("工商局完成审核，办理营业执照");
    }
}

// 外观模式用一个类把动作全部包含进去，展示给用户
class ApproveFacade
{
    private HealthOffice healthOffice;
    public ApproveFacade()
    {
        healthOffice = new HealthOffice();
    }
    public void wholeApprove()
    {
        System.out.println("我是你的门面，全都交给我吧！");
        healthOffice.approve();
        new RevenueOffice().approve();
        new SaicOffice().approve();
    }
}

public class Facade
{
    public static void main(String[] args)
    {
        System.out.println("开始办理行政手续...");

        /*
        Excutive ho = new HealthOffice();
        ho.approve();
        Excutive ro = new RevenueOffice();
        ro.approve();
        Excutive so = new SaicOffice();
        so.approve();
        */

        ApproveFacade af = new ApproveFacade();
        af.wholeApprove();

        System.out.println("行政手续终于办完了");
    }
}


