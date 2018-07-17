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

                if (secondDigit < 48 || secondDigit > 57)
                {
                    return 0;
                } else if (stringWithoutSpace.length() > 2) //More than two digits and negative
                {
                    return convertToInteger(stringWithoutSpace.substring(2, stringWithoutSpace.length()), Character.getNumericValue(secondDigit) * negative);
                }
                else //Just a one digit negative number
                {
                    return (Character.getNumericValue(secondDigit) * negative);
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
            return total;
        } else if (aStr.substring(0, 1).equals(" "))
        {
            return total;
        } else if ((int) aStr.charAt(0) < 48 || (int) aStr.charAt(0) > 57)
        {
            return total;
        }
        else
        {
            boolean isNegative = false;
            if (total < 0)
            {
                isNegative = true;
            }
            //int lastDigitBeforeAdd = total % 10;
            int digit = aStr.charAt(0);
            int digitNumericValue = Character.getNumericValue(digit);
            total = total * 10; //Expand Total to make room to add digit

            if (total < 0)
            {
                total = total - digitNumericValue;
            }
            else
            {
                total = total + digitNumericValue;
            }

            int lastTotalDigit = (total % 10);

            if (isNegative)
            {
                lastTotalDigit = lastTotalDigit * -1;
                digitNumericValue = digitNumericValue * -1;
            }

            if (digitNumericValue != lastTotalDigit)
            {
                if (isNegative)
                {
                    return Integer.MIN_VALUE;
                } else
                {
                    return Integer.MAX_VALUE;
                }
            }

            return convertToInteger(aStr.substring(1, aStr.length()), total);
        }
    }

    public String eliminatedWhiteSpace(String aStr)
    {
        if (!aStr.isEmpty()&& !aStr.substring(0, 1).equals(" "))
        {
            return aStr;
        } else if (aStr.equals(" "))
        {
            return "";
        } else
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
        String blank = " ";
        String justFourtyTwo = "42";
        String aTest = "  -981     white";
        String secondTest = "words and 987";
        String numWithWords = "4193 with words";
        String tooBigNegative = "-91283472332";
        String justOverLimit = "-2147483649";
        String num = "891";
        int aChar = (int)num.charAt(0);

        int total = anAtoi.myAtoi(aTest);
    }

}
