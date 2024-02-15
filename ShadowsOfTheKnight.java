import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Player {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int W = in.nextInt(); // width of the building.
        int H = in.nextInt(); // height of the building.
        int N = in.nextInt(); // maximum number of turns before game over.
        int X0 = in.nextInt();
        int Y0 = in.nextInt();

        int lastX = X0;
        int lastY = Y0;
        int secondToLastX = lastX;
        int secondToLastY = lastY;
        int count = 1;

        // game loop
        while (true) {
            String bombDir = in.next(); // the direction of the bombs from batman's current location (U, UR, R, DR, D,
                                        // DL, L or UL)

            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");
            System.err.println(W + " " + H);
            System.err.println("Move: " + bombDir);
            System.err.println("Second To last: " + secondToLastX + " " + secondToLastY);
            System.err.println("Last: " + lastX + " " + lastY);
            System.err.println(count);

            switch (bombDir) {
                case "U":
                    Y0 = count <= 1 ? (H - Y0) / 2 : (secondToLastY - lastY) / 2;
                    break;
                case "UR":
                    X0 = (W + X0) / 2;
                    Y0 = count <= 1 ? (H - Y0) / 2 : (secondToLastX + lastX) / 2;
                    break;
                case "R":
                    X0 = (W + X0) / 2;
                    break;
                case "DR":
                    Y0 = (H + Y0) / 2;
                    X0 = (W + X0) / 2;
                    break;
                case "D":
                    Y0 = (H + Y0) / 2;
                    break;
                case "DL":
                    Y0 = (H + Y0) / 2;
                    X0 = count <= 1 ? (W - X0) / 2 : (secondToLastX - lastX) / 2;
                    break;
                case "L":
                    X0 = count <= 1 ? (W - X0) / 2 : (secondToLastX - lastX) / 2;
                    break;
                case "UL":
                    if (count <= 1) {
                        Y0 = (H - Y0) / 2;
                        X0 = (W - X0) / 2;
                    } else {
                        Y0 = (secondToLastY - lastY) / 2;
                        X0 = (secondToLastX - lastX) / 2;
                    }
                    break;

                default:
                    break;
            }

            // the location of the next window Batman should jump to.
            System.out.println(X0 + " " + Y0);

            if (count > 1) {
                secondToLastX = lastX;
                secondToLastY = lastY;
            }

            lastX = X0;
            lastY = Y0;

            count++;
        }
    }
}