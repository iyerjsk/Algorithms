package general;

import java.util.ArrayList;
import java.util.List;

public class GenerateParanthesis {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateParanthesis(result, "", n,n);
        return result;
    }

    private void generateParanthesis(List<String> result, String current, int open, int close) {
        // There is nothing to open and close. Hence we are adding it to list of strings
        if(open == 0 && close == 0) {
            result.add(current);
            return;
        }

        if(open > 0) {
            generateParanthesis(result, current + '(', open - 1, close);
        }

        if(open < close) {
            generateParanthesis(result, current + ')', open, close - 1);
        }

    }

    public static void main(String[] args) {
        System.out.println(new GenerateParanthesis().generateParenthesis(3));
    }
}
