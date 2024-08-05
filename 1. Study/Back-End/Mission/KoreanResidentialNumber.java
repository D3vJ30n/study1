import java.util.Scanner; // 사용자 입력을 받기 위한 Scanner 클래스 import
import java.util.Random;  // 난수 생성을 위한 Random 클래스 import

public class KoreanResidentialNumber {
  public static void main(String[] args) {
    // Scanner 객체 생성. System.in은 표준 입력(키보드)을 의미
    Scanner scanner = new Scanner(System.in);
    // Random 객체 생성. 난수 생성에 사용됨
    Random random = new Random();

    // 프로그램 시작 메시지 출력
    System.out.println("[주민등록번호 계산]");

    // 사용자로부터 출생년도 입력 받기
    System.out.print("출생년도를 입력해 주세요.(yyyy):");
    int year = scanner.nextInt(); // 입력받은 정수를 year 변수에 저장

    // 사용자로부터 출생월 입력 받기
    System.out.print("출생월을 입력해 주세요.(mm):");
    int month = scanner.nextInt(); // 입력받은 정수를 month 변수에 저장

    // 사용자로부터 출생일 입력 받기
    System.out.print("출생일을 입력해 주세요.(dd):");
    int day = scanner.nextInt(); // 입력받은 정수를 day 변수에 저장

    // 사용자로부터 성별 입력 받기
    System.out.print("성별을 입력해 주세요.(m/f):");
    String gender = scanner.next(); // 입력받은 문자열을 gender 변수에 저장

    // 주민등록번호 앞 6자리 생성
    // String.format 메서드를 사용하여 형식화된 문자열 생성
    // %02d: 2자리 정수로 표현, 필요시 앞에 0을 붙임
    // year % 100: 년도의 뒤 두 자리만 사용 (예: 2023 -> 23)
    String frontNumber = String.format("%02d%02d%02d", year % 100, month, day);

    // 성별 번호 결정
    // 삼항 연산자 사용: 조건 ? 참일 때 값 : 거짓일 때 값
    // equalsIgnoreCase: 대소문자 구분 없이 문자열 비교
    int genderNumber = gender.equalsIgnoreCase("m") ? 3 : 4;

    // 임의의 번호 생성 (1 ~ 999999)
    // nextInt(999999): 0 ~ 999998 범위의 난수 생성
    // + 1: 1 ~ 999999 범위로 조정
    int randomNumber = random.nextInt(999999) + 1;

    // 주민등록번호 생성
    // frontNumber: 앞 6자리
    // genderNumber: 성별 번호
    // String.format("%06d", randomNumber): 랜덤 번호를 6자리로 맞추고, 앞에 0 채우기
    String residentNumber = frontNumber + "-" + genderNumber + String.format("%06d", randomNumber);

    // 생성된 주민등록번호 출력
    System.out.println(residentNumber);

    // Scanner 객체 닫기 (리소스 해제)
    scanner.close();
  }
}