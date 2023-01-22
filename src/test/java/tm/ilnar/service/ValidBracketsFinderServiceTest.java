package tm.ilnar.service;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ValidBracketsFinderServiceTest {

  @ParameterizedTest
  @MethodSource("provideStringsForCompute")
  public void compute_ShouldGenerateValidParenthesis(String input, String expected) {
    String actualValue = ValidBracketsFinderService.compute(input)
        .stream()
        .collect(Collectors.joining(""));
    assertEquals(expected, actualValue);
  }

  @ParameterizedTest
  @MethodSource("provideStringsForComputeValidParenthesisCount")
  public void compute_ShouldGenerateValidParenthesisCount(String input, int expected) {
    int actualValue = ValidBracketsFinderService.compute(input).size();
    assertEquals(expected, actualValue);
  }

  private static Stream<Arguments> provideStringsForCompute() {
    return Stream.of(
        Arguments.of("(()", "()"),
        Arguments.of(")()())", "()()"),
        Arguments.of(")(()())", "(()())"),
        Arguments.of(")(", ""),
        Arguments.of("())(()())(()", "()(()())()")
    );
  }

  private static Stream<Arguments> provideStringsForComputeValidParenthesisCount() {
    return Stream.of(
        Arguments.of("(()", 2),
        Arguments.of(")()())", 4),
        Arguments.of(")(()())", 6),
        Arguments.of(")(", 0),
        Arguments.of("())(()())(()", 10)
    );
  }

}
