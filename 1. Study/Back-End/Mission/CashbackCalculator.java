import java.util.Scanner;

public class CashbackCalculator {
  // ANSI 이스케이프 코드 정의: 콘솔 출력 시 텍스트 색상을 변경하는 데 사용
  public static final String ANSI_GREEN = "\u001B[32m"; // 텍스트를 녹색으로 변경
  public static final String ANSI_RESET = "\u001B[0m";  // 텍스트 색상을 기본값으로 재설정

  public static void main(String[] args) {
    // Scanner 객체 생성: 사용자로부터 입력을 받기 위해 사용
    Scanner scanner = new Scanner(System.in);

    // 프로그램 제목 출력
    System.out.println("[캐시백 계산]");
    
    // 사용자에게 결제 금액 입력 요청
    System.out.print("결제 금액을 입력해 주세요.(금액):");
    
    // 사용자로부터 정수형태의 결제 금액 입력 받기
    int paymentAmount = scanner.nextInt();
    
    // 입력받은 금액을 녹색으로 출력
    System.out.println(ANSI_GREEN + paymentAmount + ANSI_RESET);

    // calculateCashback 메소드를 호출하여 캐시백 금액 계산
    int cashback = calculateCashback(paymentAmount);

    // 결제 금액과 계산된 캐시백 금액 출력
    // %d는 정수 값을 출력하는 형식 지정자
    System.out.printf("결제 금액은 %d원이고, 캐시백은 %d원 입니다.\n", paymentAmount, cashback);

    // Scanner 객체 닫기 (리소스 해제)
    scanner.close();
  }

  // 캐시백 계산 메소드
  // 입력: 결제 금액(정수)
  // 출력: 계산된 캐시백 금액(정수)
  private static int calculateCashback(int paymentAmount) {
    int cashback;

    // 조건문을 사용하여 캐시백 계산
    if (paymentAmount < 1000) {
      // 1000원 미만일 경우 캐시백 없음
      cashback = 0;
    } else if (paymentAmount < 3000) {
      // 1000원 이상 3000원 미만일 경우 100원 캐시백
      cashback = 100;
    } else {
      // 3000원 이상일 경우 결제 금액의 10%를 캐시백으로 계산
      cashback = (int) (paymentAmount * 0.1);
      // 캐시백 금액을 100원 단위로 반올림
      // Math.round()로 반올림 후 100을 곱하여 100원 단위로 조정
      cashback = (int) (Math.round(cashback / 100.0) * 100);
      // 최대 캐시백 금액을 300원으로 제한
      // Math.min()을 사용하여 캐시백과 300 중 작은 값 선택
      cashback = Math.min(cashback, 300);
    }

    return cashback; // 계산된 캐시백 금액 반환
  }
}