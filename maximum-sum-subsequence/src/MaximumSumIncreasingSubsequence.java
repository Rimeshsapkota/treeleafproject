import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaximumSumIncreasingSubsequence {
    public static List<Integer> findMaxSumIncreasingSubsequence(int[] sequence) {
        int n = sequence.length;

        int[] dp = new int[n];
        System.arraycopy(sequence, 0, dp, 0, n);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (sequence[i] > sequence[j] && dp[j] + sequence[i] > dp[i]) {
                    dp[i] = dp[j] + sequence[i];
                }
            }
        }

        int maxSum = dp[0];
        int maxIndex = 0;
        for (int i = 1; i < n; i++) {
            if (dp[i] > maxSum) {
                maxSum = dp[i];
                maxIndex = i;
            }
        }

        List<Integer> subsequence = new ArrayList<>();
        subsequence.add(sequence[maxIndex]);
        int currentSum = maxSum - sequence[maxIndex];

        for (int i = maxIndex - 1; i >= 0; i--) {
            if (currentSum == dp[i] && sequence[i] < sequence[maxIndex]) {
                subsequence.add(sequence[i]);
                currentSum -= sequence[i];
                maxIndex = i;
            }
        }

        return reverseList(subsequence);
    }

    private static List<Integer> reverseList(List<Integer> list) {
        List<Integer> reversed = new ArrayList<>(list);
        Collections.reverse(reversed);
        return reversed;
    }

    public static void main(String[] args) {
        int[] sequence = {0,8,2,1,7,9};
        List<Integer> subsequence = findMaxSumIncreasingSubsequence(sequence);
        System.out.println("Maximum Sum Increasing Subsequence: " + subsequence);
    }
}
