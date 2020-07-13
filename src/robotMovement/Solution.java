package robotMovement;

/**
 *  F, G -> 1 step forward
 *  R -> Turn clockwise
 *  L -> Turn Anti-clockwise
 *
 *  Question is to find if the string makes a round trip or not
 *
 *  Assumption is if it is an empty string then roundtrip is true
 */
public class Solution {

    public static boolean isRoundTrip (String input) {

        if (input == null || input.length() == 0) {
            return true;
        }

        int dir = 0; // possible values are 0, 1, 2, 3

        int x = 0;
        int y = 0;

        char[] tmp = input.toCharArray();

        for(char c: tmp) {

            // switch dir if need be
            switch(c) {
                case 'L': {
                    dir  = (dir + 3) % 4;
                    break;
                }

                case 'R': {
                    dir = (dir + 1) % 4;
                    break;
                }

                case 'F':
                case 'G' : {
                    switch (dir) {
                        case 0: {
                            x++;
                            break;
                        }

                        case 1: {
                            y--;
                            break;
                        }

                        case 2: {
                            x--;
                            break;
                        }

                        case 3: {
                            y++;
                            break;
                        }
                    }
                    break;
                }
            }
        }

        System.out.println("Output: (" + x + ", "  + y + ")" );
        return x == 0 & y == 0;

    }

    public static void main (String[] args) {
        String input = "FFRRRFFLFFLFF";
        System.out.println(isRoundTrip(input));

        input = "FFRRRFFLFFLFFLF";
        System.out.println(isRoundTrip(input));

        input = "GLGLGLG";
        System.out.println(isRoundTrip(input));

        input = "GLLG";
        System.out.println(isRoundTrip(input));

    }
}
