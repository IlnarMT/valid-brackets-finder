package tm.ilnar;

import tm.ilnar.service.ValidBracketsFinderService;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author Mukhametzanov IT
 */
public class ValidParenthesesFinderApplication {

    public static void main(String[] args) {

        while (true) {
            Scanner in = new Scanner(System.in);
            String brackets = in.nextLine();

            List<String> result = ValidBracketsFinderService.compute(brackets);
            System.out.println(result.size() + " - " + result.stream().collect(Collectors.joining("")));
        }
    }
}
