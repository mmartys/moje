import java.util.regex.*;
public class Rx
{
    public static void main(String[] args)
    {
        String rx = "[aA]\\d.*|.*abd=.*|.*(123{2,3}).*";
        String val = "b2bc123334abd";

        Pattern pattern = Pattern.compile(rx);
        Matcher matcher = pattern.matcher(val);

//Returns false whereas:

//RE re = new RE(regexp);
//re.match(value); // returns true
    System.out.println(matcher.matches());
    System.out.println(matcher.groupCount());
    System.out.println(matcher.group(1));
    //System.out.println(matcher.find()); //must be reset after running matches above!
    //System.out.println(val.matches(rx)); //the same as  java.util.regex.Pattern.matches(regex, str)
    //System.out.println(java.util.regex.Pattern.matches(rx,val));
    }
}
