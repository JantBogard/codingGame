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

        int X = X0;
        int Y = Y0;

        int lastX = X0;
        int lastY = Y0;
        int secondToLastX = lastX;
        int secondToLastY = lastY;
        int count = 1;
        int newH = 0;
        int newW = 0;

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
            System.err.println("New W: " + newW);
            System.err.println("New H: " + newH);
            System.err.println(count);

            switch (bombDir) {
                case "U":
                    if (lastY > secondToLastY) {
                        Y = (secondToLastY + lastY) / 2;
                        newH = secondToLastY;
                    } else if (newH != 0) {
                        Y = (Y + newH) / 2;
                    } else {
                        Y = (H - Y) / 2;
                    }
                    break;
                case "UR":
                    if (secondToLastX > lastX) {
                        X = (secondToLastX + lastX) / 2;
                        newW = secondToLastX;
                    } else if (newW != 0) {
                        X = (X + newW) / 2;
                    } else {
                        X = (W + X) / 2;
                    }
                    if (lastY > secondToLastY) {
                        Y = (secondToLastY + lastY) / 2;
                        newH = secondToLastY;
                    } else if (newH != 0) {
                        Y = (Y + newH) / 2;
                    } else {
                        Y = (H - Y) / 2;
                    }
                    break;
                case "R":
                    if (secondToLastX > lastX) {
                        X = (secondToLastX + lastX) / 2;
                        newW = secondToLastX;
                    } else if (newW != 0) {
                        X = (X + newW) / 2;
                    } else {
                        X = (W + X) / 2;
                    }
                    break;
                case "DR":
                    if (secondToLastY > lastY) {
                        Y = (secondToLastY + lastY) / 2;
                        newH = secondToLastY;
                    } else if (newH != 0) {
                        Y = (Y + newH) / 2;
                    } else {
                        Y = (H + Y) / 2;
                    }
                    if (secondToLastX > lastX) {
                        X = (secondToLastX + lastX) / 2;
                        newW = secondToLastX;
                    } else if (newW != 0) {
                        X = (X + newW) / 2;
                    } else {
                        X = (W + X) / 2;
                    }
                    break;
                case "D":
                    if (secondToLastY > lastY) {
                        Y = (secondToLastY + lastY) / 2;
                        newH = secondToLastY;
                    } else if (newH != 0) {
                        Y = (Y + newH) / 2;
                    } else {
                        Y = (H + Y) / 2;
                    }
                    break;
                case "DL":
                    if (secondToLastY > lastY) {
                        Y = (secondToLastY + lastY) / 2;
                        newH = secondToLastY;
                    } else if (newH != 0) {
                        Y = (Y + newH) / 2;
                    } else {
                        Y = (H + Y) / 2;
                    }
                    if (lastX > secondToLastX) {
                        X = (secondToLastX + lastX) / 2;
                        newW = secondToLastX;
                    } else if (newW != 0) {
                        X = (X + newW) / 2;
                    } else {
                        X = (W - X) / 2;
                    }
                    break;
                case "L":
                    if (lastX > secondToLastX) {
                        X = (secondToLastX + lastX) / 2;
                        newW = secondToLastX;
                    } else if (newW != 0) {
                        X = (X + newW) / 2;
                    } else {
                        X = (W - X) / 2;
                    }
                    break;
                case "UL":
                    if (lastY > secondToLastY) {
                        Y = (secondToLastY + lastY) / 2;
                        newH = secondToLastY;
                    } else if (newH != 0) {
                        Y = (Y + newH) / 2;
                    } else {
                        Y = (H - Y) / 2;
                    }
                    if (lastX > secondToLastX) {
                        X = (secondToLastX + lastX) / 2;
                        newW = secondToLastX;
                    } else if (newW != 0) {
                        X = (X + newW) / 2;
                    } else {
                        X = (W - X) / 2;
                    }
                    break;

                default:
                    break;
            }

            // the location of the next window Batman should jump to.
            System.out.println(X + " " + Y);

            if (count > 1) {
                secondToLastX = lastX;
                secondToLastY = lastY;
            }

            lastX = X;
            lastY = Y;

            count++;
        }
    }
}