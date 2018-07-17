package AnAtoi;

public class Atoi
{

    public int myAtoi(String str) {

        if (str.length() == 0)
        {
            return 0;
        }
        else if()

        return 0;

    }

    public String eliminatedWhiteSpace(String aStr)
    {
        if (!aStr.isEmpty()&& !aStr.substring(0, 1).isEmpty())
        {
            return aStr;
        }
        else
        {
            String stringWithoutLeadingWhitespace = aStr.substring(1, aStr.length());
            return eliminatedWhiteSpace(stringWithoutLeadingWhitespace);
        }
    }
}

class AtoiTesters
{
    public static void main(String[] argsgsgs)
    {
        Atoi anAtoi = new Atoi();
    }

}
