package testProxy;

/**
 * 供应商
 */
public class Vender implements Sell{


    @Override
    public void sell() {
        System.out.println("Shop sell goods");

    }

    @Override
    public void ad() {
        System.out.println("Shop advert goods");

    }
}
