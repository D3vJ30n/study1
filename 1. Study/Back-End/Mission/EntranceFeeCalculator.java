import java.util.Scanner;  // 사용자 입력을 받기 위한 Scanner 클래스 import

public class EntranceFeeCalculator {
  public static void main(String[] args) {
    // Scanner 객체 생성. System.in은 표준 입력(키보드)를 의미합니다.
    Scanner scanner = new Scanner(System.in);

    // 프로그램 시작 메시지 출력
    System.out.println("[입장권 계산]");

    // 나이 입력 받기
    System.out.print("나이를 입력해 주세요. (숫자):");
    int age = scanner.nextInt(); // 정수형으로 나이 입력 받음

    // 입장 시간 입력 받기
    System.out.print("입장시간을 입력해 주세요. (숫자입력):");
    int entryTime = scanner.nextInt(); // 정수형으로 입장 시간 입력 받음

    // 국가유공자 여부 입력 받기
    System.out.print("국가유공자 여부를 입력해 주세요. (y/n):");
    char nationalMerit = scanner.next().charAt(0); // 문자열의 첫 번째 문자만 입력 받음

    // 복지카드 소지 여부 입력 받기
    System.out.print("복지카드 여부를 입력해 주세요. (y/n):");
    char welfareCard = scanner.next().charAt(0); // 문자열의 첫 번째 문자만 입력 받음

    // 입장료를 저장할 변수 선언
    int fee;

    // 다중 조건문을 사용하여 입장료 계산
    if (age < 3) {
      fee = 0; // 3세 미만은 무료 입장
    } else if (age < 13 || entryTime >= 17) {
      fee = 4000; // 13세 미만이거나 17시 이후 입장 시 특별 할인 적용
    } else if (nationalMerit == 'y' || welfareCard == 'y') {
      fee = 8000; // 국가유공자이거나 복지카드 소지자는 일반 할인 적용
    } else {
      fee = 10000; // 위의 모든 조건에 해당하지 않으면 기본 입장료 적용
    }

    // 계산된 입장료 출력
    System.out.println("입장료: " + fee);

    // Scanner 객체 닫기 (리소스 해제)
    scanner.close();
  }
}