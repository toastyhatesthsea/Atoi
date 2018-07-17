package AnAtoi;

public class Atoi
{

    public int myAtoi(String str) {

        if (str.length() == 0)
        {
            return 0;
        }

        String stringWithoutSpace = eliminatedWhiteSpace(str);

        if (stringWithoutSpace.isEmpty())
        {
            return 0;
        }
        else
        {
            int firstDigit = (int)stringWithoutSpace.charAt(0);

            if (firstDigit < 48 || firstDigit > 57)
            {
                return 0;
            }




        }

        return 0;

    }

    public int convertToInteger(String aStr)
    {
        return 0;
    }

    public String eliminatedWhiteSpace(String aStr)
    {
        if (!aStr.isEmpty()&& !aStr.substring(0, 1).equals(" "))
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
        String aTest = "       white";
        String num = "891";
        int aChar = (int)num.charAt(0);

        String whiteSpaceGone = anAtoi.eliminatedWhiteSpace(aTest);
    }

}
