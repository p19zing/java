public class Constants {
    final static double VAT = 0.23;

    public static void main(String[] args) {
        final double REDUCTION;
        REDUCTION = 0.15;

        double price = 60.0;
        double ppv = price + price * VAT;
        double pay = ppv - ppv * REDUCTION;
        System.out.println("net: "+price);
        System.out.println("net + vat: "+ppv);
        System.out.println("final: "+pay);
    }

}
