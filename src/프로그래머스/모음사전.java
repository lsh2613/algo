package 프로그래머스;

import java.util.HashMap;
import java.util.Map;

public class 모음사전 {
    static String[] AEIOU = {"A", "E", "I", "O", "U"};
    static Map<String, Integer> map = new HashMap<>();
    static int cnt = 0;

    public int solution(String word) {
        dfs("");

        return map.get(word);
    }

    private void dfs(String word) {
        map.put(word, cnt);
        if (word.length() == AEIOU.length) {
            return;
        }

        for (int i = 0; i < AEIOU.length; i++) {
            cnt++;
            dfs(word + AEIOU[i]);
        }
    }

    public static void main(String[] args) {
        모음사전 모음사전 = new 모음사전();
        int solution = 모음사전.solution("UUUUU");
    }
}
