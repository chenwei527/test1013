package testInvHandler;


import testProxy.Sell;
import testProxy.Vender;

import java.lang.reflect.Proxy;

/**
 * 动态代理测试
 */
public class DynamicProxyMain {

    public static void main(String[] args) {

        //创建中介类实例
        LogHandler logHandler = new LogHandler(new Vender());

        //设置该变量可以保存动态代理类，默认名称$Proxy0.class
        System.getProperties().put("sum.misc.ProxyGenerator.saveGeneratedFiles","true");


        //获取代理类实例Sell
        Sell sell = (Sell)(Proxy.newProxyInstance(Sell.class.getClassLoader(),new Class[]{Sell.class},logHandler));

        //通过代理类对象调用代理类方法，实际上会转到invoke方法调用
        sell.sell();
        sell.ad();

    }

}
