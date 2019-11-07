import com.sun.jndi.cosnaming.IiopUrl;

import java.util.List;

/**
 * Created by Administrator on 2019/4/25.
 */
class Address
{
    private String strRoad;
    public void setStrRoad(String strRoad)
    {
        this.strRoad = strRoad;
    }

    public String getStrRoad()
    {
        return strRoad;
    }
}


class Customer implements Cloneable
{
    private Address address;

    public void setAddress(Address address)
    {
        this.address = address;
    }

    public Address getAddress()
    {
        return address;
    }

    public Customer clone()
    {
        Object obj = null;
        try
        {
            obj = super.clone();
            return (Customer)obj;
        }
        catch(CloneNotSupportedException e)
        {
            System.out.println("不支持复制！");
            return	null;
        }
    }
}


public class Client
{
    public static void main(String[] args)
    {

        Customer customer_previous,	customer_new;
        customer_previous =	new	Customer();
        Address address = new Address();
        address.setStrRoad("aaaaa");
        customer_previous.setAddress(address);
        customer_new = customer_previous.clone();
        Address oldaddress = customer_previous.getAddress();
        Address newaddress = customer_new.getAddress();

        System.out.println("未修改时结果：");
        System.out.println(oldaddress.getStrRoad());
        System.out.println(newaddress.getStrRoad());

        newaddress.setStrRoad("bbbb");
        System.out.println("把克隆对象修改后的结果：");
        System.out.println(oldaddress.getStrRoad());
        System.out.println(newaddress.getStrRoad());
    }
}
