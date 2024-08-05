// MultiplicationTable 클래스: 구구단을 가로 레이아웃으로 출력하는 프로그램
public class MultiplicationTable {
    // main 메소드: 프로그램의 진입점
    public static void main(String[] args) {
        // 프로그램 제목 출력
        System.out.println("구구단 출력");

        // 외부 반복문: 1부터 9까지 반복 (곱해지는 수)
        for (int i = 1; i <= 9; i++) {
            // 내부 반복문: 1부터 9까지 반복 (곱하는 수, 즉 각 단)
            for (int j = 1; j <= 9; j++) {
                // format 메소드를 사용하여 구구단 각 항목 출력
                // %02d: 정수를 최소 2자리로 출력, 필요시 앞에 0을 붙임
                // 예: 1 -> 01, 12 -> 12
                System.out.format("%02d x %02d = %02d  ", j, i, i * j);
                // 출력 형식: "곱하는 수 x 곱해지는 수 = 결과  "
                // 끝에 두 칸 공백을 추가하여 각 항목 사이에 간격을 줌
            }
            // 한 행(1부터 9까지의 특정 수에 대한 곱셈)이 끝나면 줄바꿈
            System.out.println();
        }
    }
}