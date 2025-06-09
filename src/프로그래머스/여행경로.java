package 프로그래머스;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class 여행경로 {
    static boolean visited[];
    static List<String> answer = new ArrayList<>();
    static String[][] tickets;

    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        this.tickets = tickets;

        dfs("ICN", "ICN", 0);
        answer.sort(Comparator.naturalOrder());
        return answer.get(0).split(" ");
    }

    static void dfs(String start, String route, int cnt){
        if (cnt == tickets.length) {
            answer.add(route);
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (tickets[i][0].equals(start) && !visited[i]){
                visited[i] = true;
                dfs(tickets[i][1], route + " " + tickets[i][1], cnt + 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        String[] solution = new 여행경로().solution(new String[][]{
                {"ICN", "JFK"},
                {"HND", "IAD"},
                {"JFK", "HND"}
        });

        for (String s : solution) {
            System.out.print(s + " ");
        }
    }
}
