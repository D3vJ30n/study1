import java.time.LocalDate;
import java.util.Scanner;

public class SimpleCalendar {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("[달력 출력 프로그램]");

    System.out.print("년도를 입력하세요: ");
    int year = scanner.nextInt();

    System.out.print("월을 입력하세요: ");
    int month = scanner.nextInt();

    System.out.println();

    // 이전 달, 입력한 달, 다음 달 출력
    for (int i = -1; i <= 1; i++) {
      LocalDate date = LocalDate.of(year, month, 1).plusMonths(i);
      printCalendar(date.getYear(), date.getMonthValue());
      System.out.println();
    }

    scanner.close();
  }

  public static void printCalendar(int year, int month) {
    LocalDate date = LocalDate.of(year, month, 1);
    
    System.out.println(year + "년 " + month + "월");
    System.out.println("일 월 화 수 목 금 토");

    // 첫 날의 요일만큼 공백 출력
    int dayOfWeek = date.getDayOfWeek().getValue() % 7;
    for (int i = 0; i < dayOfWeek; i++) {
      System.out.print("   ");
    }

    while (date.getMonthValue() == month) {
      System.out.printf("%2d ", date.getDayOfMonth());

      // 토요일이면 줄바꿈
      if (date.getDayOfWeek().getValue() % 7 == 6) {
        System.out.println();
      }

      date = date.plusDays(1);
    }

    System.out.println();
  }
}