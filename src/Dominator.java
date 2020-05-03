import java.util.Stack;

public class Dominator {

    public static void main(String[] argv){

        int A[] = {3, 4 , 3, 2, 3, -1, 3, 3};

        Dominator dominator = new Dominator();

        int result = dominator.solution(A);

        System.out.println(result);

        A = new int[]{4, 3};

        dominator = new Dominator();

        result = dominator.solution(A);

        System.out.println(result);

    }

    public int solution(int[] A) {
        return dominator(A);
    }

    private int dominator(int[] A) {
        int result = 0;

        Stack<Integer> leaderStorage = new Stack();

        for (int i = 0; i < A.length; i++) {
            if (leaderStorage.size() > 0 && leaderStorage.peek().equals(A[i])) {
                leaderStorage.push(A[i]);
            } else if(leaderStorage.size() > 0) {
                leaderStorage.pop();
            } else {
                leaderStorage.push(A[i]);
            }
        }

        Integer candidate = leaderStorage.empty() ? null : leaderStorage.peek();
        int count = 0;

        for(int i = 0; i < A.length; i++){
            if(candidate != null && A[i] == candidate){
                count++;
            }
        }

        boolean isDominator = isDominator(count, A.length);

        if(isDominator) {
            for (int i = 0; i < A.length; i++) {
                if (A[i] == candidate) {
                    return i;
                }
            }
        }
        return -1;
    }

    private boolean isDominator(int count, int size) {
        return count > Math.floor(size / 2d);
    }


}
