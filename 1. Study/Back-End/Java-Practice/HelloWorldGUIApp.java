import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class HelloWorldGUIApp {
    public static void main(String[] args) {
        // Swing 컴포넌트들은 Event Dispatch Thread에서 생성 및 업데이트되어야 합니다.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    private static void createAndShowGUI() {
        // 프레임 생성
        JFrame frame = new JFrame("Hello, World GUI!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 프레임 크기 설정
        frame.setPreferredSize(new Dimension(800, 300));

        // 레이블 생성 및 추가
        JLabel label = new JLabel("Hello, World!", SwingConstants.CENTER);
        frame
            .getContentPane()
            .add(label);

        // 화면 중앙에 프레임 위치 설정
        Dimension screenSize = Toolkit
            .getDefaultToolkit()
            .getScreenSize();
        int x = (screenSize.width - 800) / 2;
        int y = (screenSize.height - 300) / 2;
        frame.setLocation(x, y);

        // 프레임 표시
        frame.pack();
        frame.setVisible(true);
    }
}