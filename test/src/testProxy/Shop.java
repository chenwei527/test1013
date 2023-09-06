package testProxy;

/**
 * 超市，代理类
 */
public class Shop implements Sell{

    private Sell sell;

    public Shop(Sell sell){
        this.sell = sell;
    }

    @Override
    public void sell() {
        System.out.println("代理类Shop，处理sell");
        sell.sell();

    }

    @Override
    public void ad() {
        System.out.println("代理类shop，处理ad");
        sell.ad();

    }
}
