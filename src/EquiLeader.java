import java.util.Stack;

public class EquiLeader {

    public static void main(String[] argv){

        int A[] = {4, 3 ,4, 4, 4, 2};

        EquiLeader leader = new EquiLeader();

        int result = leader.solution(A);

        System.out.println(result);

        A = new int[]{4, 3};

        leader = new EquiLeader();

        result = leader.solution(A);

        System.out.println(result);

    }

    public int solution(int[] A) {
        return equiLeader(A);
    }

    private int equiLeader(int[] A) {
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

        int countMax = count;

        boolean isLeader = isLeader(count, A.length - 1);

        if(isLeader) {
            for (int i = 0; i < A.length; i++) {
                if (A[i] == candidate) {
                    count--;
                }
                if (isLeader(count, A.length - 1 - i) && isLeader(countMax - count, i + 1)) {
                    result++;
                }

            }
        }
        return result;
    }

    private boolean isLeader(int count, int size) {
        return count > Math.floor(size / 2d);
    }


}
