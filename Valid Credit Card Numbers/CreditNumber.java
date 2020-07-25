import java.util.Scanner;
/**
 *
 * @author Nicole Wong
 * @classname CreditNumber
 * @assignmentnumber 1
 */
public class CreditNumber {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //user input assuming long is between 13-16 digits
        long creditCard;
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a credit card number: ");
        creditCard = scan.nextLong();
        // print out message 
        if (isValid(creditCard))
        {
            System.out.println(creditCard + " is valid.");
        }
        else
        {
            System.out.println(creditCard + " is invalid.");
        }
    }
    
    /**
     * @param creditNumber Credit Card Number input
     * @return Checks if credit card is valid.
     */
    public static boolean isValid(long creditNumber) 
    {
      //count number of digits 
        int count = 0;
        long n = creditNumber;
        while (n != 0)
        {
            n /= 10;
            count++;
        }
       //create array of digits from right to left 
        long[] tempArray = new long[count];
        long number = creditNumber;
        for (int x=0; x<count; x++)
        {
            tempArray[x] = number % 10;
            number /= 10;
        }
        
        //double every second digit 
        long evenTotal = 0;
        long doubled = 0;
        for (int x=1; x<count; x+=2)
        {
            doubled = tempArray[x] * 2;
            if (doubled < 10)
            {
                evenTotal += doubled;
            }
            else
            {
                evenTotal += (doubled % 10);
                doubled /= 10;
                evenTotal += doubled;
            }
        }
        
        //add all digits in odd places from right to left 
        long oddTotal = 0;
        for (int x=0; x<count; x+=2)
        {
            oddTotal += tempArray[x];
        }
        long sum = evenTotal + oddTotal;
        if (sum % 10 == 0) 
        {
            return true;
        }
        else 
        {
            return false;
        }
    }
}
