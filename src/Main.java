import javax.swing.*;
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
        JFrame frame = new JFrame("Quiz system");// JFrame 생성
        frame.setSize(400, 300); // 프레임의 크기 설정
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);// 프레임을 화면에 표시
    }
}
