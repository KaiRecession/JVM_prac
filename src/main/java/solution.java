import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {
    static int max = 0;
    public static void main(String[] args) {
        int[] position = {2, 3, 4, 5};
        int[] radius = {1, 1, 1, 2};
        int[] values = {50, 10, 40, 70};
        maxvalue(new LinkedList<Integer>(), position, radius, values, 0, 0);
        System.out.println(max);
    }

    public static void maxvalue(List<Integer> plant,int[] position, int[] radius, int[] value, int memo, int index) {
        for (int i = index; i < position.length; i++) {
            boolean contains = false;
            if (plant.contains(position[i]))
                contains = true;
            for (int j = 1; j <= radius[i]; j++) {
                if (plant.contains(position[i] + j))
                    contains = true;
                if (plant.contains(position[i] - j))
                    contains = true;

            }
            if (contains)
                continue;

//            maxvalue(plant, position, radius, value, memo, i + 1);

            plant.add(position[i]);

            memo += value[i];

            maxvalue(plant, position, radius, value, memo, i + 1);

            max = Math.max(max, memo);
            plant.remove((Integer)(position[i]));
            memo -= value[i];
        }
    }


}