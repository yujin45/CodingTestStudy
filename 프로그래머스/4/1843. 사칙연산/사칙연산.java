/*
2025-06-26
다시 보기 이해X
*/

public class Solution {
    public int solution(String[] arr) {
        // arr 내의 숫자와 연산자 중 숫자만 n개
        int n = (arr.length + 1) / 2;
        int[][] dpMax = new int[n][n];
        int[][] dpMin = new int[n][n];
        int[] nums = new int[n];
        String[] ops = new String[n - 1];

        // 숫자와 연산자 분리
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) {
                nums[i / 2] = Integer.parseInt(arr[i]);
            } else {
                ops[i / 2] = arr[i];
            }
        }

        // 초기값 (자기 자신 구간)
        for (int i = 0; i < n; i++) {
            dpMax[i][i] = nums[i];
            dpMin[i][i] = nums[i];
        }

        // 구간 길이 2부터 시작
        for (int length = 2; length <= n; length++) {
            for (int i = 0; i <= n - length; i++) {
                int j = i + length - 1;
                dpMax[i][j] = Integer.MIN_VALUE;
                dpMin[i][j] = Integer.MAX_VALUE;

                // 중간 연산자 기준으로 분할
                for (int k = i; k < j; k++) {
                    String op = ops[k];

                    int a = dpMax[i][k];
                    int b = dpMax[k + 1][j];
                    int c = dpMin[i][k];
                    int d = dpMin[k + 1][j];

                    if (op.equals("+")) {
                        dpMax[i][j] = Math.max(dpMax[i][j], a + b);
                        dpMin[i][j] = Math.min(dpMin[i][j], c + d);
                    } else if (op.equals("-")) {
                        dpMax[i][j] = Math.max(dpMax[i][j], a - d);
                        dpMin[i][j] = Math.min(dpMin[i][j], c - b);
                    }
                }
            }
        }

        return dpMax[0][n - 1];
    }
}
