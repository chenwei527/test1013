public class LocationTester1 {
    public static void main(String[] args)
    {
        SimpleLocation1 loc1 = new SimpleLocation1(39.9, 116.4);
        SimpleLocation1 loc2 = new SimpleLocation1(55.8, 37.6);
        loc1 = loc2;
        loc1.lat = -8.3;
        System.out.println(loc2.lat + ", " + loc2.lon);

    }

    private int min(int a, int b) {
        return Math.min(a, b);
    }
}

class SimpleLocation1
{
    public double lat;
    public double lon;

    public SimpleLocation1(double latIn, double lonIn)
    {
        this.lat = latIn;
        this.lon = lonIn;
    }
}
