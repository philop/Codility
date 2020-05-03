import java.util.Stack;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class MaxSlice {

    public static void main(String[] argv){

        int A[] = {3, 2, 6, -1, 4, 5, -1, 2};

        MaxSlice maxSlice = new MaxSlice();

        int result = maxSlice.solution(A);

        System.out.println(result);

        /*A = new int[]{4, -3};

        maxSlice = new MaxSlice();

        result = maxSlice.solution(A);

        System.out.println(result);*/

    }

    public int solution(int[] A) {
        return maxSlice(A);
    }

    private int maxSlice(int[] A) {
        int max_ending = 0, max_slice = 0, min = 0;
        for (int a : A) {
            max_ending = max(0, max_ending + a);
            min = min(min, a);
            max_slice = max(max_slice, max_ending);
        }
        return max_slice;
    }

}
