import java.util.Random;

public class PuzzleList {
    int[][] temp = {{1, 5, 2, 3, 4, 6, 10, 7, 8, 9, 11, 15, 12, 13, 14, 0},
                    {4, 1, 2, 3, 8, 5, 7, 11, 12, 10, 6, 15, 13, 9, 0, 14},
                    {8, 4, 1, 3, 9, 6, 2, 7, 12, 5, 11, 0, 13, 14, 10, 15},
                    {1, 5, 2, 3, 8, 4, 6, 0, 9, 14, 11, 7, 12, 10, 13, 15},
                    {1, 2, 3, 7, 8, 4, 5, 6, 9, 10, 11, 15, 0, 12, 13, 14},
                    {1, 6, 3, 7, 4, 2, 5, 11, 12, 9, 14, 10, 13, 8, 15, 0},
                    {4, 9, 1, 3, 5, 2, 7, 15, 8, 13, 0, 6, 12, 14, 11, 10},
                    {1, 2, 3, 7, 4, 5, 6, 11, 12, 0, 9, 10, 13, 8, 14, 15},
                    {1, 2, 3, 7, 4, 5, 6, 11, 12, 9, 0, 10, 13, 8, 14, 15},
                    {1, 6, 3, 7, 4, 2, 5, 11, 12, 9, 14, 10, 13, 8, 15, 0}};

    public int[] getPuzzle() {
        Random rand = new Random();
        int random = rand.nextInt(10);
        return temp[random];  // for easy setup and debugging
    }

    public int[] getPuzzle(int i) {
        return temp[i];  // for easy setup and debugging
    }

}
