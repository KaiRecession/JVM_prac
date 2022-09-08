import java.util.LinkedList;
import java.util.List;

public class solution {
    int result = 0;
    public static void main(String[] args) {
        solution solution = new solution();
        solution.find(4, 0);
        System.out.println(solution.result);

    }

    public void find(int n, int path) {
        if (path == n) {
            result++;
            return;
        }
        find (n, path + 1);
        if (path + 2 <= n)
            find (n, path + 2);
        LinkedList<Integer> integers = new LinkedList<>();
    }

}
