/**
 * @author mmartys
 * Moj maly lokator - lokaty bankowe, aukcje mille, kwoty optymalne
 * resolution: 1pln
 * Loko2 vs Loko - added mille fix
 */
public class Loko2
{
    private static int days;
    private static float per_cent, base, resolution = 1f;
    private static boolean bMille = false;
     
    /**
     * profit and optimal amounts
     * @param base
     * @param percentage
     * @param days
     * @return profit (net), optimal1, optimal2
     */
    private static float[] optimize(final float base, final float percentage, final int days, boolean bMille)
    {
        float[] ret = new float[3];
        final float net = profit(base, percentage, days, bMille);
        float tmp  = net;
        ret[0] = net;
 
        //count optimal
        for (int i = 1; i < 999999; i ++) {
            tmp = profit(base-(i*resolution), percentage, days, bMille);
            if (tmp < net) {
                ret[1] = base-((i-1)*resolution);
                break;
            }
        }
         
        //count optimal for profit + 0,01
        for (int i = 1; i < 99999999; i ++) {
            tmp = profit(i*resolution + base, percentage, days, bMille);
            if (tmp > net) {
                ret[2] = i*resolution + base;
                break;
            }
        }
 
        return ret;
    }
     
    private static float profit(final float base, final float percentage, final int days, boolean bMille)
    {
        float profit = 0;
        if (bMille) {
            profit = ((float)Math.round((base * days * percentage)/YEAR-0.1f))/100;
        } else {
            profit = ((float)Math.round((base * days * percentage)/YEAR))/100;
        }
        float net =  profit - (float)(Math.ceil(profit*TAX*100)/100);
        return net;
    }
     
    @SuppressWarnings("boxing")
    public static void main(String[] args)
    {
        if (args.length < 3) {
            System.out.println("Podaj 3 parametry: orientacyjna kwote, %, dni np: 5234.00 4.65 15" );
            System.out.println("i ew. 4+5. parametr - rozdzielczosc (default: 1) kwota powinna byc jego");
            System.out.println("wielokrotnoscia i mille fix true/false czyli 1020 3.00 2 0.1 true");
            return;
        }
        base = Float.parseFloat(args[0]);
        per_cent = Float.parseFloat(args[1]);
        days = Integer.parseInt(args[2]);
        if (args.length > 3) {
            resolution = Float.parseFloat(args[3]);
        }
        if (args.length > 4) {
            bMille = Boolean.parseBoolean(args[4]);
        }
        //System.out.println("dane OK");
        //System.out.println("Profit: " + profit);
        //System.out.println("Tax: " + tax);
        float[] res = optimize(base, per_cent, days, bMille);
        //System.out.println(((float)Math.round((base * days * per_cent)/YEAR))/100);
        System.out.println("Profit net: " + res[0]);
        System.out.printf("Optimal1/profit1: %.2f / %.2f %n",res[1], res[0]);
        System.out.printf("Optimal2/profit2: %.2f / %.2f %n",res[2], res[0] + 0.01f);
    }
     
    public static final int YEAR = 365; //percentage is xx,yy% so must be balance/36500
    public static final float TAX = 0.19f; //%
     
}
