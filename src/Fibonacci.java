import java.util.Scanner;

/**
 * This class contains methods
 * for determining a value in
 * the fibonacci sequence.
 *
 * @author James Milgram
 */
public class Fibonacci {
    /**
     * This method calculates the value of
     * the fibonacci sequence at a specified
     * index via looping.
     * @param idx An index in the fibonacci sequence
     * @return The value at the specified index
     */
    public static long fibonacci(int idx) {
        long numIdxMinus2 = 0;
        long numIdxMinus1 = 1;
        long numIdx = 0;

        if (idx == 0) {
            return numIdxMinus2;
        } else if (idx == 1) {
            return numIdxMinus1;
        } else if (idx < 0) {
            return -1;
        } else {
            for (int i = 1; i < idx; ++i) {
                numIdx = numIdxMinus1 + numIdxMinus2;
                numIdxMinus2 = numIdxMinus1;
                numIdxMinus1 = numIdx;
            }
            return numIdx;
        }
    }

    /**
     * This method prints out the value
     * of the fibonacci sequence at the
     * specified index.
     * @param args unused
     */
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);

        int idx;
        long numAtIdx;

        System.out.println("What number (ordinal) in the fibonacci sequence do you desire?");
        System.out.println("This program counts 0 at index 0 as the 0th number in the sequence.");
        System.out.print("Keep in mind, this program ceases to function properly at the 93rd index ");
        System.out.println("due to the 64-bit signed integer limit.");

        if (scnr.hasNextInt()) {
            idx = scnr.nextInt();
        } else {
            idx = -1;
        }

        numAtIdx = fibonacci(idx);

        if (idx >= 0) {
            if ((idx % 100 >= 11) && (idx % 100 <= 13)) {
                System.out.printf("The %dth number of the fibonacci sequence is %d.", idx, numAtIdx);
            }
            else if (idx % 10 == 1) {
                System.out.printf("The %dst number of the fibonacci sequence is %d.", idx, numAtIdx);
            } else if (idx % 10 == 2) {
                System.out.printf("The %dnd number of the fibonacci sequence is %d.", idx, numAtIdx);
            } else if (idx % 10 == 3) {
                System.out.printf("The %drd number of the fibonacci sequence is %d.", idx, numAtIdx);
            } else {
                System.out.printf("The %dth number of the fibonacci sequence is %d.", idx, numAtIdx);
            }
        } else {
            System.out.println("Invalid input! Index must be a non-negative integer.");
        }

        scnr.close();
    }
}
