import java.util.Arrays;

public class MaxSliceBis {

    public static void main(String[] argv){

        //int A[] = {3, 2, 6, -11, 4, 5, -1, 2};
        //int A[] = {5, -7, 3, 5, -2, 4, -1};
        //int A[] = {1, 2, 3, 4, 5};
        int A[] = {5, 17, 0, 3};

        MaxSliceBis maxSlice = new MaxSliceBis();

        int result = maxSlice.solution(A);

        System.out.println(result);


    }

    public int solution(int[] A) {
        int maxDoubleSlice = 0;
        int[] lefts = sliceSum(A);
        int[] rights = sliceSumReverted(A);
        for (int i = 1; i < A.length - 1; i++) {
            maxDoubleSlice = Math.max(maxDoubleSlice, lefts[i - 1] + rights[i + 1]);
        }
        return maxDoubleSlice;
    }

    public int[] sliceSum(int A[]){
        int[] memo = new int[A.length];
        int max_ending = 0, max_slice = 0;
        for(int i = 0; i < A.length - 1; i++) {

            if(i == 0 || i == A.length - 1) memo[i] = 0;
            else {
                max_ending = Math.max(0, max_ending + A[i]);
                max_slice = Math.max(max_slice, max_ending);
                memo[i] = max_slice;
            }
        }
        return memo;
    }

    public int[] sliceSumReverted(int A[]){
        int[] memo = new int[A.length];
        int max_ending = 0, max_slice = 0;
        for(int i = A.length - 1; i >= 0; i--) {

            if(i == 0 || i == A.length - 1) memo[i] = 0;
            else {
                max_ending = Math.max(0, max_ending + A[i]);
                max_slice = Math.max(max_slice, max_ending);
                memo[i] = max_slice;
            }
        }
        return memo;
    }

}
