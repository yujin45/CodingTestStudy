import java.util.Scanner;

class Solution {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            // 각 테스트 케이스에 N이 주어짐
            int num = sc.nextInt();
            int arr[][] = new int[num][num]; // nxn으로 생성
            int index[][] = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // 이동 규칙 우 > 하 > 좌> 상
            // index[0] 오른쪽으로 초기화
            int x = index[0][0];
            int y = index[0][1];
            // 달팽이 위치 초기화
            int nx = 0;
            int ny = 0;

            int n = 1; // 1부터 차례대로 증가하여 넣어줄 것임
            int change = 0; // 방향 전환 타이밍 확인용

            while (n <= num * num) {
                // 비어 있으면 채우기
                arr[nx][ny] = n; //숫자 넣기
                n++; // 숫자 증가
                int nextX = nx + x; // 다음 위치로 예상 이동
                int nextY = ny + y; // 다음 위치로 예상 이동

                // 다음 위치가 배열 범위를 벗어나거나 이미 값이 채워진 경우 방향 전환
                if (nextX >= num || nextX < 0 || nextY >= num || nextY < 0 || arr[nextX][nextY] != 0) {
                    change = (change + 1) % 4; // 방향 전환
                    // 방향 벡터 전환
                    x = index[change][0];
                    y = index[change][1];
                }
                // 바뀐 방향으로 이동
                nx = nx + x;
                ny = ny + y;
            }

            // 출력
            System.out.printf("#%d\n", test_case);
            for (int i = 0; i < num; i++) {
                for (int j = 0; j < num; j++) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
