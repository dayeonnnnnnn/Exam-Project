import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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

public class Main {
    private static JFrame frame;
    private static JPanel panel;
    private static JTextField nameField;
    private static JTextField studentIdField;
    private static JComboBox<String> subjectComboBox;
    private static final Map<String, String[]> questions = new HashMap<>();
    private static final Map<String, String[]> answers = new HashMap<>();

    /**
     * @author Baek Da Yeon
     *
     * @created 2024-12-21
     * @lastModified 2024-12-23
     *
     * @changelog
     * <ul>
     *   <li>2024-12-23:gui로 수정(Baek Da Yeon)</li>
     * </ul>
     */

    public static void main(String[] args) {
        initializeQuizSystem();
    }

    private static void initializeQuizSystem() {
        UIManager.put("OptionPane.minimumSize", new Dimension(300, 150));
        frame = new JFrame("Quiz System");
        panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        panel.setBackground(new Color(240, 240, 240)); //see

        /**
         * @author Baek Da Yeon
         *
         * @created 2024-12-21
         * @lastModified 2024-12-24
         *
         * @changelog
         * <ul>
         *   <li>2024-12-21: 퀴즈 창 변경 (Baek Da Yeon)</li>
         * </ul>
         */

        nameField = new JTextField(20);
        studentIdField = new JTextField(20);

        JButton confirmButton = new JButton("확인");
        confirmButton.setBackground(new Color(0, 102, 204));
        confirmButton.setForeground(Color.WHITE);
        confirmButton.setFocusPainted(false);
        confirmButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        confirmButton.setFont(new Font("", Font.BOLD, 14));

        /**
         * @author Baek Da Yeon
         *
         * @created 2024-12-21
         * @lastModified 2024-12-24
         *
         * @changelog
         * <ul>
         *   <li>2024-12-24: 버튼 색 변경 (Baek Da Yeon)</li>
         * </ul>
         */

        String[] subjects = {"Java", "GUI", "알고리즘 설계"};
        subjectComboBox = new JComboBox<>(subjects);
        JLabel departmentLabel = new JLabel();
        departmentLabel.setFont(new Font("Arial", Font.BOLD, 14));
        departmentLabel.setForeground(new Color(0, 102, 204));


        panel.add(subjectComboBox); // 콤보박스 추가
        panel.add(confirmButton); // 확인 버튼 추가

        gbc.gridx = 0; gbc.gridy = 0; panel.add(new JLabel("이름:"), gbc);
        gbc.gridx = 1; gbc.gridy = 0; panel.add(nameField, gbc);
        gbc.gridx = 0; gbc.gridy = 1; panel.add(new JLabel("학번:"), gbc);
        gbc.gridx = 1; gbc.gridy = 1; panel.add(studentIdField, gbc);
        gbc.gridx = 0; gbc.gridy = 2; panel.add(new JLabel("과목:"), gbc);
        gbc.gridx = 1; gbc.gridy = 2; panel.add(subjectComboBox, gbc);
        gbc.gridx = 1; gbc.gridy = 3; panel.add(confirmButton, gbc);
        gbc.gridx = 0; gbc.gridy = 4; gbc.gridwidth = 2; panel.add(departmentLabel, gbc); //see

        /**
         * @author Baek Da Yeon
         *
         * @created 2024-12-21
         * @lastModified 2024-12-24
         *
         * @changelog
         * <ul>
         *   <li>2024-12-21: 패널에 컴포넌트 추가 (Baek Da Yeon)</li>
         *   <li>2024-12-21: GridLayout으로 배치 (Baek Da Yeon)</li>
         *   <li>2024-12-21: 콤보박스 추가 (Baek Da Yeon)</li>
         *   <li>2024-12-24: GridBagLayout으로 수정 (Baek Da Yeon)</li>
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
                    startQuiz(selectedSubject); // 선택한 과목을 인자로 전달
                }
            }
        });//see

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

        frame.setSize(500, 400); // 프레임의 크기 설정
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel); // 패널을 프레임에 추가
        frame.setVisible(true); // 프레임을 화면에 표시
        frame.setLocationRelativeTo(null);
    }

    private static void loadQuestionsFromFile(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(","); // CSV 파일의 각 줄을 쉼표로 분리
                if (parts.length >= 3) {
                    String subject = parts[0].trim();
                    String question = parts[1].trim();
                    String answer = parts[2].trim();

                    questions.putIfAbsent(subject, new String[3]); // 질문과 답변 csv에 추가
                    answers.putIfAbsent(subject, new String[3]);

                    for (int i = 0; i < 3; i++) {
                        if (questions.get(subject)[i] == null) {
                            questions.get(subject)[i] = question;
                            answers.get(subject)[i] = answer;
                            break;
                        }
                    }
                }
            }
        }//see

        /**
         * @author Baek Da Yeon
         * @created 2024-12-21
         * @lastModified 2024-12-22
         *
         * @changelog
         * <ul>
         *   <li>2024-12-23: 문제와 정답 추가 (Baek Da Yeon)</li>
         * </ul>
         */

        catch (IOException e) {
            e.printStackTrace();
        }
    } //see

    private static void startQuiz(String subject) {
        loadQuestionsFromFile("questions.csv"); // CSV 파일에서 문제 로드
        JOptionPane.showMessageDialog(null, "Starting the quiz for: " + subject); // 선택한 과목으로 퀴즈 시작
        //see
        /**
         * @author Baek Da Yeon
         * @created 2024-12-21
         * @lastModified 2024-12-22
         *
         * @changelog
         * <ul>
         *   <li>2024-12-21: 자바 퀴즈 추가 (Baek Da Yeon)</li>
         *   <li>2024-12-21: Gui 퀴즈 추가 (Baek Da Yeon)</li>
         *   <li>2024-12-21: 알고리즘 설계 퀴즈 추가 (Baek Da Yeon)</li>
         *   <li>2024-12-22: 점수 결과 추가 (Baek Da Yeon)</li>
         *   <li>2024-12-22: csv 파일 생성 후 추가 (Baek Da Yeon)</li>
         * </ul>
         */

        // 퀴즈 시작
        int score = 0;
        for (int i = 0; i < 3; i++) {
            String question = questions.get(subject)[i];
            String correctAnswer = answers.get(subject)[i];

            String userAnswer = JOptionPane.showInputDialog(null, question);

            if (userAnswer == null) {
                JOptionPane.showMessageDialog(null, "퀴즈가 취소되었습니다.");
                return; // 퀴즈 종료
            } //see

            /**
             * @author Baek Da Yeon
             * @created 2024-12-21
             * @lastModified 2024-12-24
             *
             * @changelog
             * <ul>
             *   <li>2024-12-24: cancel 버튼 클릭 시 퀴즈 취소 (Baek Da Yeon)</li>
             * </ul>
             */

            if (userAnswer.equalsIgnoreCase(correctAnswer)) {
                score++;
            }
        }
        JOptionPane.showMessageDialog(null, " 맞힌 개수: " + score + " / 3"); // 결과 표시
    }
}
