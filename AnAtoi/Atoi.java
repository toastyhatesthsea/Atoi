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

            //Larger than one digit and negative
            if (stringWithoutSpace.length() >= 2 && negative == -1)
            {
                int secondDigit = stringWithoutSpace.charAt(1);
                secondDigit = Character.getNumericValue(secondDigit);

                if (secondDigit < 48 || secondDigit > 57)
                {
                    return 0;
                } else if (stringWithoutSpace.length() > 2) //More than two digits and negative
                {
                    return convertToInteger(stringWithoutSpace.substring(2, stringWithoutSpace.length()), secondDigit * negative);
                }
                else //Just a one digit negative number
                {
                    return (secondDigit * negative);
                }

            } else if (stringWithoutSpace.length() == 1)
            {
                return Character.getNumericValue(firstDigit);
            } else //Larger than one digit and not negative
            {
                return convertToInteger(stringWithoutSpace.substring(1, stringWithoutSpace.length()), Character.getNumericValue(firstDigit));
            }
        }
    }

    public int convertToInteger(String aStr, int total)
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
            total = total * 10; //Expand Total to make room to add digit
            total = total + digit;

            convertToInteger(aStr.substring(1, aStr.length()), total);

            return total;
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
