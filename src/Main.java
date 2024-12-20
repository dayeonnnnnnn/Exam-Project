import javax.swing.*;
import java.awt.*;

public class Main {
    /**
     * @author Baek Da Yeon
     *
     * @created 2024-12-21
     * @lastModified 2024-12-21
     *
     * @changelog
     * <ul>
     *   <li>2024-12-21: 최초 생성 (Baek Da Yeon)</li>
     *   <li>22024-12-21: 연결 풀링 기능 추가 (Baek Da Yeon)</li>
     * </ul>
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame("Quiz system"); // JFrame 생성
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2, 10, 10));

        JTextField nameField = new JTextField(20);
        JTextField studentIdField = new JTextField(20);
        JButton confirmButton = new JButton("확인");

        panel.add(new JLabel("이름:")); // 레이블 추가
        panel.add(nameField); // 이름 입력 필드 추가
        panel.add(new JLabel("학번:")); // 레이블 추가
        panel.add(studentIdField); // 학번 입력 필드 추가
        panel.add(confirmButton); // 확인 버튼 추가

        /**
         * @author Baek Da Yeon
         *
         * @created 2024-12-21
         * @lastModified 2024-12-21
         *
         * @changelog
         * <ul>
         *   <li>2024-12-21: 패널에 컴포넌트 추가 (Baek Da Yeon)</li>
         *   <li>22024-12-21: GridLayoutd으로 배치 (Baek Da Yeon)</li>
         * </ul>
         */

        frame.setSize(400, 300); // 프레임의 크기 설정
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel); // 패널을 프레임에 추가
        frame.setVisible(true); // 프레임을 화면에 표시
    }
}
