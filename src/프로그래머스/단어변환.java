package 프로그래머스;

import java.util.LinkedList;
import java.util.Queue;

public class 단어변환 {

    public static class Word {
        String word;
        int cnt;

        public Word(String word, int cnt) {
            this.word = word;
            this.cnt = cnt;
        }
    }

    public int solution(String begin, String target, String[] words) {
        boolean[] visited = new boolean[words.length];
        Queue<Word> q = new LinkedList<>();
        q.offer(new Word(begin, 0));

        while (!q.isEmpty()) {
            Word now = q.poll();

            if (now.word.equals(target)) {
                return now.cnt;
            }

            for (int i = 0; i < words.length; i++) {
                int cnt = 0;
                String word = words[i];
                for (int j = 0; j < word.length(); j++) {
                    if (now.word.charAt(j) != word.charAt(j))
                        cnt++;
                }
                if (cnt == 1 && !visited[i]) {
                    visited[i] = true;
                    q.offer(new Word(word, now.cnt + 1));
                }
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        // "hit"	"cog"	["hot", "dot", "dog", "lot", "log", "cog"]
        int solution = new 단어변환().solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log", "cog"});
        System.out.println("solution = " + solution);
    }
}
