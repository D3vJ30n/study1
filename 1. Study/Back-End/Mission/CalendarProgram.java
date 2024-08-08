import java.time.LocalDate;
import java.time.YearMonth;
import java.util.Scanner;

public class CalendarProgram {
  public static void main(String[] args) {
    // 프로그램 제목 출력
    System.out.println("[달력 출력 프로그램]");

    // 사용자 입력을 받기 위한 Scanner 객체 생성
    Scanner scanner = new Scanner(System.in);

    // 사용자로부터 년도 입력 받기
    System.out.print("달력의 년도를 입력해 주세요(yyyy): ");
    int year = scanner.nextInt();

    // 사용자로부터 월 입력 받기
    System.out.print("달력의 월을 입력해 주세요(mm): ");
    int month = scanner.nextInt();

    System.out.println();

    // 3개월의 달력을 저장할 배열 생성 (이전 달, 현재 달, 다음 달)
    String[] calendars = new String[3];

    // 입력받은 월을 기준으로 이전 달, 현재 달, 다음 달의 달력 생성
    for (int i = -1; i <= 1; i++) {
      YearMonth yearMonth = YearMonth.of(year, month).plusMonths(i);
      calendars[i + 1] = generateCalendar(yearMonth);
    }

    // 생성된 3개월 달력을 가로로 출력
    printCalendarsHorizontally(calendars);

    // Scanner 객체 닫기
    scanner.close();
  }

  public static String generateCalendar(YearMonth yearMonth) {
    StringBuilder calendar = new StringBuilder();

		// 달력 제목 (년도와 월) 추가
		// [] 앞에 공백을 1칸 추가하여 년도와 월 출력
    calendar.append(String.format(" [%d년 %02d월]              \n", yearMonth.getYear(), yearMonth.getMonthValue()));
    // 요일 헤더 추가
    calendar.append("일 월 화 수 목 금 토        \n");

    // 해당 월의 1일 날짜 객체 생성
    LocalDate date = yearMonth.atDay(1);
    // 1일의 요일 계산 (0: 일요일, 1: 월요일, ..., 6: 토요일)
    int firstDayOfWeek = date.getDayOfWeek().getValue() % 7;

    // 한 주를 나타내는 문자열 빌더 초기화 (7일 * 3칸 = 21칸)
    StringBuilder weekBuilder = new StringBuilder("   ".repeat(7));
    // 첫 주의 시작 전 빈 칸 채우기
    for (int i = 0; i < firstDayOfWeek; i++) {
      weekBuilder.replace(i * 3, i * 3 + 2, "  ");
    }

    // 날짜 채우기
    while (date.getMonthValue() == yearMonth.getMonthValue()) {
      int dayOfWeek = date.getDayOfWeek().getValue() % 7;
      // 해당 요일 위치에 날짜 삽입
      weekBuilder.replace(dayOfWeek * 3, dayOfWeek * 3 + 2, String.format("%02d", date.getDayOfMonth()));

      // 토요일이거나 월의 마지막 날이면 한 주 완성
      if (dayOfWeek == 6 || date.plusDays(1).getMonthValue() != yearMonth.getMonthValue()) {
        calendar.append(weekBuilder).append("       \n");
        // 다음 주를 위해 weekBuilder 초기화
        weekBuilder = new StringBuilder("   ".repeat(7));
      }

      // 다음 날짜로 이동
      date = date.plusDays(1);
    }

    // 달력의 높이를 일정하게 맞추기 위해 빈 줄 추가
    while (calendar.toString().split("\n").length < 8) {
      calendar.append("                      \n");
    }

    return calendar.toString();
  }

  public static void printCalendarsHorizontally(String[] calendars) {
    // 각 달력을 줄 단위로 분리
    String[][] calendarLines = new String[3][];
    for (int i = 0; i < 3; i++) {
      calendarLines[i] = calendars[i].split("\n");
    }

    // 3개의 달력을 가로로 나란히 출력
    for (int i = 0; i < 8; i++) {  // 각 달력은 8줄로 구성
      for (int j = 0; j < 3; j++) {  // 3개의 달력 출력
        System.out.print(calendarLines[j][i]);
        // 마지막 달력이 아니면 간격 추가
        if (j < 2) {
          System.out.print("  "); // 달력 사이 간격 조정
        }
      }
      System.out.println();  // 한 줄 출력 후 줄바꿈
    }
  }
}