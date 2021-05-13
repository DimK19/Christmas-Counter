package application;

public class Calculator
{
    
    // TODO overload getAnswer without parameters, use current date instead

    private static int calcDays(int m, int d, int y)
    {
        int sum = 0;
        switch (m)
        {
            case 1: sum += 31;
            case 2: sum += 28;
            case 3: sum += 31;
            case 4: sum += 30;
            case 5: sum += 31;
            case 6: sum += 30;
            case 7: sum += 31;
            case 8: sum += 31;
            case 9: sum += 30;
            case 10: sum += 31;
            case 11: sum += 30;
            case 12:
                if ((m == 12) && (d > 25)) sum += 390 - d;
                else sum += 25;
                break;
        }

        if ((m == 12) && (d > 25) && ((y + 1) % 4 == 0)) sum++;
        else if ((m < 3) && (y % 4 == 0)) sum++;
        if ((m != 12) || (d <= 25)) sum -= d;

        return sum;
    }
    
    public String getAnswer(int m, int d, int y)
    {
        if (((m == 4) || (m == 6) || (m == 9) || (m == 11)) && (d == 31))
        {
            return "                  Invalid Input!                  ";
        }
        else if (((m == 2) && (y % 4 != 0) && (d > 28)) || ((m == 2) && (y % 4 == 0) && (d > 29)))
        {
            return "                  Invalid Input!                  ";
        }
        else
        {
            int ans = calcDays(m, d, y);
            if (ans == 0)
            {
                return "              Merry Christmas!!!              ";
            }
            else
            {
                return "              Days Until Christmas: " + String.valueOf(ans) + "              ";
            }
        }
    }

}
