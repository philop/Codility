import java.util.Arrays;

public class MaxSlice {

    public static void main(String[] argv){

        int A[] = {3, 2, 6, -11, 4, 5, -1, 2};
        //int A[] = {5, -7, 3, 5, -2, 4, -1};
        //int A[] = {1, 2, 3, 4, 5};

        MaxSlice maxSlice = new MaxSlice();

        int result = maxSlice.solution(A);

        System.out.println(result);


    }

    public int solution(int[] A) {
        int maxDoubleSlice = 0;
        for (int i = 1; i < A.length - 1; i++) {
            maxDoubleSlice = Math.max(maxDoubleSlice, doubleSlice(A, i));
        }
        return maxDoubleSlice;
    }

    public int doubleSlice(int[] array, int index){
        if (array.length < 4) return 0;
        int[] left = Arrays.copyOfRange(array, 1, index);
        int[] right = Arrays.copyOfRange(array, index + 1, array.length - 1);
        return sliceSum(left) + sliceSum(right);
    }

    public int sliceSum(int A[]){
        int max_ending = 0, max_slice = 0;
        for(int i = 0; i < A.length; i++) {
            max_ending = Math.max(0, max_ending + A[i]);
            max_slice = Math.max(max_slice, max_ending);
        }
        return max_slice;
    }

}
