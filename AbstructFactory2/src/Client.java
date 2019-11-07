/**
 * Created by Administrator on 2019/4/25.
 */

interface Connection
{
    void connect();
}

interface Statement
{
    void print();
}

class MySQLConnection implements Connection
{

    @Override
    public void connect()
    {
        System.out.println("MySQL数据库连接！");
    }
}

class MySQLStatement implements Statement
{

    @Override
    public void print()
    {
        System.out.println("MySQL数据库输出语句！");
    }
}

class OracleConnection implements Connection
{

    @Override
    public void connect()
    {
        System.out.println("Oracle数据库连接！");
    }
}

class OracleStatement implements Statement
{

    @Override
    public void print()
    {
        System.out.println("Oracle数据库输出语句！");
    }
}

interface  EDataBaseFactory
{
    Connection productConnection();
    Statement productStatement();
}

class MySQLFactory implements EDataBaseFactory
{
    @Override
    public Connection productConnection()
    {
        return new MySQLConnection();
    }

    @Override
    public Statement productStatement()
    {
        return new MySQLStatement();
    }
}

class OracleFactory implements EDataBaseFactory
{
    @Override
    public Connection productConnection()
    {
        return new OracleConnection();
    }

    @Override
    public Statement productStatement()
    {
        return new OracleStatement();
    }
}

public class Client
{
    public static void main(String[] args)
    {
        EDataBaseFactory Oraclefactory = new OracleFactory();
        Statement statement = Oraclefactory.productStatement();
        statement.print();

        EDataBaseFactory MySQLfacroty = new MySQLFactory();
        Connection connection = MySQLfacroty.productConnection();
        connection.connect();
    }
}
