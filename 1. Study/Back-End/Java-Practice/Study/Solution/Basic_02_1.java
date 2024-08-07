// Java 프로그래밍 - 변수와 자료형_1

public class Basic_02_1 {
  public static void main(String[] args) {

    // 1. 변수 사용하기
    System.out.println("== 변수 사용하기 ==");
    // 정수형 변수 'age'를 선언하고 값 10을 할당합니다.
    int age = 10;
    // 문자열 변수 'country'를 선언하고 값 "Korea"를 할당합니다.
    String country = "Korea";

    // 변수의 값을 출력합니다.
    System.out.println("age = " + age);        // 'age'의 값인 10이 출력됩니다.
    System.out.println("country = " + country); // 'country'의 값인 "Korea"가 출력됩니다.
    System.out.println();  // 빈 줄을 출력하여 가독성을 높입니다.

    // 2. 변수 이름 규칙
    System.out.println("== 변수 이름 규칙 ==");
    // 2-1. 문자, 숫자, _(underscore), $ 사용 가능
    int apple = 2000;    // 일반적인 변수명
    int apple3 = 2000;   // 숫자를 포함한 변수명
    int _apple = 2000;   // underscore로 시작하는 변수명
    int $apple = 2000;   // $로 시작하는 변수명

    // 각 변수의 값을 출력합니다.
    System.out.println("apple = " + apple);
    System.out.println("apple3 = " + apple3);
    System.out.println("_apple = " + _apple);
    System.out.println("$apple = " + $apple);
    System.out.println();

    // 2-2. 숫자로 시작 X
    // int 3apple = 2000;  // 오류: 변수명은 숫자로 시작할 수 없습니다.

    // 2-3. 대소문자 구분
    int apple1 = 2000;  // 소문자 'a'로 시작하는 변수
    int Apple1 = 3000;  // 대문자 'A'로 시작하는 변수 (apple1과 다른 변수입니다)

    System.out.println("apple1 = " + apple1);
    System.out.println("Apple1 = " + Apple1);
    System.out.println();

    // 2-4. 공백 사용 X
    // int one apple = 2000;  // 오류: 변수명에 공백을 사용할 수 없습니다.
    int one_apple = 2000;   // underscore를 사용하여 단어를 구분합니다.
    int oneApple = 2000;    // camelCase를 사용하여 단어를 구분합니다.

    // 2-5. 예약어 사용 X
    // 예약어 예시: true, false, if, switch, for, continue, break, ...
    // int true = 1;       // 오류: 'true'는 예약어입니다.
    // int false = 0;      // 오류: 'false'는 예약어입니다.
    // int if = 1;         // 오류: 'if'는 예약어입니다.
    // int continue = 10;  // 오류: 'continue'는 예약어입니다.

    // 참고) 한글 사용 가능
    int 나이 = 20;  // 한글로 변수명을 지을 수 있지만, 일반적으로 권장되지 않습니다.
    System.out.println("나이 = " + 나이);

    // 3. 표기법
    System.out.println("== 표기법 ==");
    // 3-1. 카멜 표기법 (camelCase)
    // 변수, 함수명에 주로 사용됩니다. 
    // 두 번째 단어부터 첫 글자를 대문자로 씁니다.
    int myAge = 10;
    int oneApplePrice = 1000;

    // 3-2. 파스칼 표기법 (PascalCase)
    // 클래스명에 주로 사용됩니다.
    // 모든 단어의 첫 글자를 대문자로 씁니다.
    int MyAge = 10;
    int OneApplePrice = 1000;

    // 참고) 스네이크 표기법 (snake_case)
    // Java에서는 일반적으로 사용되지 않습니다.
    // 다른 언어(예: Python)에서 주로 사용됩니다.
    int my_age = 10;
    int one_apple_price = 1000;
  }
}