package 프로그래머스;

public class 타겟넘버 {
    static int cnt = 0;

    public int solution(int[] numbers, int target) {
        dfs(numbers, 0, target, 0);
        return cnt;
    }

    void dfs(int[] numbers, int result, int target, int idx) {
        if (idx == numbers.length) { // idx가 벗어나면 끝
            if (target == result)
                cnt++;
            return;
        }

        dfs(numbers, result + numbers[idx], target, idx + 1);
        dfs(numbers, result - numbers[idx], target, idx + 1);
    }

    public static void main(String[] args) {
        타겟넘버 sol = new 타겟넘버();
        int[] numbers = {4, 1, 2, 1};
        int target = 4;
        System.out.println(sol.solution(numbers, target)); // 출력: 2
    }
}
