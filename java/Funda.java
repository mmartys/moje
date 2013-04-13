/**
 * @author mmartys
 *  Java Fundamentals - Chapter 1
 */
public class Funda
{
    private boolean bAccess;
    private static boolean bSAccess;
    /**
     * 
     */
    public Funda()
    {
        // TODO Auto-generated constructor stub
    }
    
    @SuppressWarnings("unused")
    private final byte fin1(final int i)
    {
        final long l = 1;
        return (byte)l;
    }
    
    public static void main(String[] args)
        throws InterruptedException
    {
        System.out.println("Quite OK, run main main");
        //Run.Run2 r2 = new Run.Run2(); //INVALID! see line below
        Run.Run2 r22 = new Run().new Run2();
        R2 r0 = new R2();
    }
    
    private class In1
    {
        //static int is = -1; //INVALID!!! static must be in static or top-level type
    }
    
    private static class Run
    {
        static int is = -1; //INVALID!!! static must be in static or top-level type
        
        /**
         * run it ;-) e.g. with java Funda\$Run frm cmdl or Funda$Run in eclipse
         */
        public static void main(String[] args)
        {
            System.out.println("Good Run run ;-)");
            System.out.println(bSAccess);
        }
        
        class Run2
        {
        }
    }
    
    static class R2
    {
    }

}
