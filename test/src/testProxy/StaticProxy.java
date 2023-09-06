package testProxy;

/**
 * 静态代理类测试方法
 */
public class StaticProxy {

    public static void main(String[] args) {

        Vender vender = new Vender();

        Sell sell = new Shop(vender);

        sell.ad();
        sell.sell();

    }
}
