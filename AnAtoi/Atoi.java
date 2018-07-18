package AnAtoi;

public class Atoi
{

    public int myAtoi(String str) {

        if (str.length() == 0)
        {
            return 0;
        }

        String stringWithoutSpace = eliminatedWhiteSpace(str);
        boolean toomanySymbols = tooManyOperands(stringWithoutSpace);

        if (stringWithoutSpace.isEmpty())
        {
            return 0;
        } else if (toomanySymbols)
        {
            return 0;
        } else
        {
            int firstDigit = (int) stringWithoutSpace.charAt(0);
            int negative = 1;

            if (firstDigit == 45)
            {
                negative = -1;
                if (stringWithoutSpace.length() < 2)
                {
                    return 0;
                }
                    stringWithoutSpace = getRidOfLeadingZeroes(stringWithoutSpace.substring(1, stringWithoutSpace.length()));
            } else if (firstDigit == 43)
            {
                if (stringWithoutSpace.length() < 2)
                {
                    return 0;
                }
                stringWithoutSpace = getRidOfLeadingZeroes(stringWithoutSpace.substring(1, stringWithoutSpace.length()));
            } else if (firstDigit < 48 || firstDigit > 57)
            {
                return 0;
            }

            //Larger than one digit and negative
            if (stringWithoutSpace.length() >= 2 && negative == -1)
            {
                firstDigit = stringWithoutSpace.charAt(0);

                if (firstDigit < 48 || firstDigit > 57)
                {
                    return 0;
                } else //More than two digits and negative
                {
                    return convertToInteger(stringWithoutSpace.substring(1, stringWithoutSpace.length()), Character.getNumericValue(firstDigit) * negative);
                }
            } else if (stringWithoutSpace.length() == 1)
            {
                if (negative == -1)
                {
                    return Character.getNumericValue(stringWithoutSpace.charAt(0)) * negative;
                } else
                {
                    return Character.getNumericValue(stringWithoutSpace.charAt(0));
                }
            } else //Larger than one digit and not negative
            {
                firstDigit = stringWithoutSpace.charAt(0);
                if (firstDigit < 48 || firstDigit > 57)
                {
                    return 0;
                }
                return convertToInteger(stringWithoutSpace.substring(1, stringWithoutSpace.length()), Character.getNumericValue(firstDigit));
            }
        }
    }

    public String getRidOfLeadingZeroes(String s)
    {
        if (!s.isEmpty() && !s.substring(0, 1).equals("0"))
        {
            return s;
        }
        else if(s.isEmpty())
        {
            return s;
        }
        else
        {
            String aSubString = s.substring(1, s.length());
            return getRidOfLeadingZeroes(aSubString);
        }
    }

    public boolean tooManyOperands(String s)
    {
        if (s.isEmpty())
        {
            return false;
        } else if (s.length() < 2)
        {
            return false;
        }
        else
        {
            int firstDigit = s.charAt(0);
            int secondDigit = s.charAt(1);

            if ((firstDigit == 45 || firstDigit == 43) && (secondDigit == 45 || secondDigit == 43))
            {
                return true;
            }
            else
            {
                return false;
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
        } else if (((int) aStr.charAt(0) < 48 || (int) aStr.charAt(0) > 57))
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
            int original = total;
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

            if (original != total / 10)
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

        if (!aStr.isEmpty()&& (!aStr.substring(0, 1).equals(" ")))
        {
            return aStr;
        } else if (aStr.equals(" "))
        {
            return "";
        } else if (aStr.isEmpty())
        {
            return aStr;
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
        String negativeFourtyTwo = "         -42";
        String num = "891";
        String justNegative = "-";
        String positiveNumber = "+1";
        String justPositive = "+";
        String negativeOneWithLeadingZeroes = "-00000000001";
        String plusAndNegativeLeading = "+-12";
        String blankPlusLeadingZeroesAndPlus = "          +004500";
        String crapola = "    +0a32";
        String largeNumber = "20000000000000000000";
        int aChar = (int)num.charAt(0);

        int total = anAtoi.myAtoi(largeNumber);
    }

}
