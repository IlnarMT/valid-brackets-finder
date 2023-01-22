package tm.ilnar.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ValidBracketsFinderService {

  public static List<String> compute(String input) {
    List<String> result = new ArrayList<>();
    Stack<Integer> openingBrackets = new Stack<>();
    Stack<Integer> invalidClosingBrackets = new Stack<>();

    String[] inputArray = input.split("");

    for (int i = 0; i < inputArray.length; i++) {
      if (inputArray[i].equals("(")) {
        openingBrackets.push(i);
      }
      else {
        if (openingBrackets.empty()) {
          invalidClosingBrackets.add(i);
        }
        else {
          openingBrackets.pop();
        }
      }
    }

    for (int i = 0; i < inputArray.length; i++) {
      if (openingBrackets.contains(i) || invalidClosingBrackets.contains(i)) {
        continue;
      }
      result.add(inputArray[i]);
    }

    return result;
  }
}
