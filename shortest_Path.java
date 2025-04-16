import java.util.*;

public class shortest_Path {
    public static float get_Shortest_path(String path) {
        int x = 0, y = 0;
        for (int i = 0; i < path.length(); i++) {
            char direction = path.charAt(i);
            // EAST
            if (direction == 'E') {
                x++;

            }
            // WEST
            else if (direction == 'W') {
                x--;
            }
            // SOUTH
            else if (direction == 'S') {
                y--;
            }
            // NORTH
            else if (direction == 'N') {
                y++;
            }

        }
        int x2 = x * x;
        int y2 = y * y;
        return (float) Math.sqrt(x2 + y2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("ENTER THE PATH IS :");
        String path = sc.nextLine();
        System.out.println("SHORTEST PATH :" + get_Shortest_path(path));
        sc.close();
    }

}
