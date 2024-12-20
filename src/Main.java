import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
     * </ul>
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame("Quiz system"); // JFrame 생성
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2, 10, 10));

        JTextField nameField = new JTextField(20);
        JTextField studentIdField = new JTextField(20);
        JButton confirmButton = new JButton("확인");
        String[] subjects = {"Java", "GUI", "알고리즘 설계", "빅데이터 처리", "운영체제"};
        JComboBox<String> subjectComboBox = new JComboBox<>(subjects);

        panel.add(new JLabel("이름:")); // 레이블 추가
        panel.add(nameField); // 이름 입력 필드 추가
        panel.add(new JLabel("학번:")); // 레이블 추가
        panel.add(studentIdField); // 학번 입력 필드 추가
        panel.add(new JLabel("과목:")); // 과목 레이블 추가
        panel.add(subjectComboBox); //콤보박스 추가
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
         *   <li>2024-12-21: GridLayout으로 배치 (Baek Da Yeon)</li>
         *   <li>2024-12-21: 콤보박스 추가 (Baek Da Yeon)</li>
         * </ul>
         */

        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String studentId = studentIdField.getText();
                String selectedSubject = (String) subjectComboBox.getSelectedItem();

                int result = JOptionPane.showConfirmDialog(frame,
                        "이름: " + name + "\n학번: " + studentId + "\n과목: " + selectedSubject,
                        "확인",
                        JOptionPane.OK_CANCEL_OPTION,
                        JOptionPane.PLAIN_MESSAGE); // 아이콘을 없애기 위해 PLAIN_MESSAGE 사용


                if (result == JOptionPane.OK_OPTION) {
                    startQuiz();// OK를 클릭한 경우에만 메시지 표시
                }
            }
        }); //see
        /**
         * @author Baek Da Yeon
         * @created 2024-12-21
         * @lastModified 2024-12-21
         *
         * @changelog
         * <ul>
         *   <li>2024-12-21: 버튼 클릭 이벤트 추가 (Baek Da Yeon)</li>
         *   <li>2024-12-21: 퀴즈 로딩 화면 추가 (Baek Da Yeon)</li>
         *   <li>2024-12-21: 퀴즈 로딩 화면 수정 (Baek Da Yeon)</li>
         * </ul>
         */

        frame.setSize(400, 300); // 프레임의 크기 설정
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel); // 패널을 프레임에 추가
        frame.setVisible(true); // 프레임을 화면에 표시
        frame.setLocationRelativeTo(null);
    }

        private static void startQuiz() {

            JOptionPane.showMessageDialog(null, "Starting the quiz...");// 퀴즈 시작 추가
        }
    } //see
