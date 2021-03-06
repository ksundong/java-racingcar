package stringcalculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static stringcalculator.StringUtils.DELIMITER;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class StringUtilsTest {

  static Stream<Arguments> strings() {
    return Stream.of(
        arguments("", true),
        arguments("   ", true),
        arguments(null, true),
        arguments("1 * 3", false));
  }

  @ParameterizedTest
  @DisplayName("빈 문자열 확인")
  @MethodSource("strings")
  void blankString(String input, boolean expected) {
    assertThat(StringUtils.isBlank(input)).isEqualTo(expected);
  }

  @ParameterizedTest
  @DisplayName("문자열이 공백문자로 분리되는지 확인")
  @ValueSource(strings = {
      "1 * 3",
      "1 / 3",
      "1 + 2 * 3"})
  void split(String expression) {
    String[] expected = expression.split(DELIMITER);

    assertThat(StringUtils.split(expression))
        .usingFieldByFieldElementComparator()
        .isEqualTo(expected);
  }

}
