package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringTest {

  String abc = "abc";

  @Test
  @DisplayName("1,2를 split한 값이 1과 2를 포함하는지, 순서대로 포함하는지 확인")
  void splitContains() {
    String[] actual = "1,2".split(",");

    assertAll(
        () -> assertThat(actual).contains("1", "2"),
        () -> assertThat(actual).containsExactly("1", "2")
    );
  }

  @Test
  @DisplayName("actual이 1을 포함하는지 테스트")
  void splitContainsOne() {
    String[] actual = "1".split(",");

    assertThat(actual).contains("1");
  }

  @Test
  @DisplayName("(1,2)가 주어졌을 때, ()를 제거하고 1,2 반환")
  void removeBracket() {
    String bracketedString = "(1,2)";

    String actual = bracketedString
        .substring(bracketedString.indexOf("(") + 1, bracketedString.lastIndexOf(")"));

    assertThat(actual).isEqualTo("1,2");
  }

  @Test
  @DisplayName("abc가 주어졌을 때, charAt()으로 특정 위치의 문자를 가져오는지 확인")
  void charAt() {
    assertAll(
        () -> assertThat(abc.charAt(0)).isEqualTo('a'),
        () -> assertThat(abc.charAt(1)).isEqualTo('b'),
        () -> assertThat(abc.charAt(2)).isEqualTo('c')
    );
  }

  @Test
  @DisplayName("abc가 주어졌을 때, charAt()에서 위치 값을 벗어난 경우 예외가 발생하는지 확인")
  void charAtThrowsIndexOutOfBoundsException() {
    assertThatThrownBy(() -> abc.charAt(3))
        .isInstanceOf(StringIndexOutOfBoundsException.class)
        .hasMessageMatching("String index out of range: -?\\d");
  }
}
