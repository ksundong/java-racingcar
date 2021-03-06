# 문자열 계산기 요구사항 분석

- 사용자가 문자열을 입력한다.
- 문자열은 사칙연산의 형태이나, 입력순서대로 연산한다.
- 문자열의 숫자와 연산자 사이에는 빈 공백이 **반드시** 존재한다.
- 나눗셈의 경우에는 결과 값이 정수로 떨어지는 경우만 한정한다.

## 기능 분리

- 덧셈
- 뺄셈
- 곱셈
- 나눗셈
- 입력값 예외 처리(null 또는 빈 문자열)
- 사칙연산 기호가 아닌경우 예외처리
- 사칙연산 모두 사용하는 기능 구현

## 학습한 내용

- [ParameterizedTest에서 null 값 넣는 법](https://blog.oio.de/2018/10/26/use-null-values-in-junit-5-parameterized-tests/)
- [blank, empty String 검증하는 코드](https://www.baeldung.com/java-blank-empty-strings)
- [ParameterizedTest에서 여러 Value를 MethodSource로 넣는 법](https://www.arhohuttunen.com/junit-5-parameterized-tests/)
