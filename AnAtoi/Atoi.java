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
            int negative = 1;

            if (firstDigit == 45)
            {
                negative = -1;
            }
            else if (firstDigit < 48 || firstDigit > 57)
            {
                return 0;
            }

                if (stringWithoutSpace.length() >= 2 && negative == -1)
                {
                    int secondDigit = stringWithoutSpace.charAt(1);
                    secondDigit = Character.getNumericValue(secondDigit);

                    if (secondDigit < 48 || secondDigit > 57)
                    {
                        return 0;
                    }
                    return convertToInteger(stringWithoutSpace, secondDigit * -1);
                }

                int total = convertToInteger(stringWithoutSpace, negative);

        }

        return 0;

    }

    public int convertToInteger(String aStr, int negative)
    {
        if (aStr.isEmpty())
        {
            return 0;
        } else if (aStr.substring(0, 1).equals(" "))
        {
            return 0;
        } else if ((int) aStr.charAt(0) < 48 || (int) aStr.charAt(0) > 57)
        {
            return 0;
        }
        else
        {
            int digit = aStr.charAt(0);
            digit = Character.getNumericValue(digit);




            return 0;
        }
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
        String aTest = "  981     white";
        String num = "891";
        int aChar = (int)num.charAt(0);

        int total = anAtoi.myAtoi(aTest);
    }

}
