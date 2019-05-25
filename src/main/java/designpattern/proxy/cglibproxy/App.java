package designpattern.proxy.cglibproxy;

public class App {

    public static void main() {
        //目标对象
        UserDao target = new UserDao();

        //代理对象
        UserDao proxy = (UserDao) new ProxyFactory(target).getProxyInstance();

        //执行代理对象的方法
        proxy.save();
    }
}