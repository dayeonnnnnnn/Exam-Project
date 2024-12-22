import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
     * @lastModified 2024-12-21
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
        frame = new JFrame("Quiz System");
        panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2, 10, 10));

        nameField = new JTextField(20);
        studentIdField = new JTextField(20);
        JButton confirmButton = new JButton("확인");
        String[] subjects = {"Java", "GUI", "알고리즘 설계"};
        subjectComboBox = new JComboBox<>(subjects);

        panel.add(new JLabel("이름:")); // 레이블 추가
        panel.add(nameField); // 이름 입력 필드 추가
        panel.add(new JLabel("학번:")); // 레이블 추가
        panel.add(studentIdField); // 학번 입력 필드 추가
        panel.add(new JLabel("과목:")); // 과목 레이블 추가
        panel.add(subjectComboBox); // 콤보박스 추가
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

        frame.setSize(400, 300); // 프레임의 크기 설정
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel); // 패널을 프레임에 추가
        frame.setVisible(true); // 프레임을 화면에 표시
        frame.setLocationRelativeTo(null);
    }

    private static void startQuiz(String subject) {
        // 각 과목에 대한 문제와 정답을 저장
        JOptionPane.showMessageDialog(null, "Starting the quiz for: " + subject); // 선택한 과목으로 퀴즈 시작

        Map<String, String[]> questions = new HashMap<>();
        Map<String, String[]> answers = new HashMap<>();

        questions.put("Java", new String[]{
                "Java의 창시자는 누구인가?",
                "Java의 기본 데이터 타입이 아닌 것은?",
                "Java에서 배열의 인덱스는 몇부터 시작하는가?"
        });

        answers.put("Java", new String[]{
                "James Gosling",
                "String",
                "0"
        });

        questions.put("GUI", new String[]{
                "Swing은 어떤 언어의 GUI 라이브러리인가?",
                "JFrame은 무엇을 나타내는가?",
                "Event Dispatch Thread는 무엇을 담당하는가?"
        });

        answers.put("GUI", new String[]{
                "Java",
                "윈도우",
                "이벤트 처리"
        });
        questions.put("알고리즘 설계", new String[]{
                "최악의 경우 시간 복잡도가 O(n^2)인 정렬 알고리즘은?",
                "다익스트라 알고리즘은 어떤 문제를 해결하는가?",
                "동적 프로그래밍의 기본 아이디어는 무엇인가?"
        });

        answers.put("알고리즘 설계", new String[]{
                "버블 정렬",
                "최단 경로",
                "최적 부분 구조"
        }); //see
        /**
         * @author Baek Da Yeon
         * @created 2024-12-21
         * @lastModified 2024-12-21
         *
         * @changelog
         * <ul>
         *   <li>2024-12-21: 자바 퀴즈 추가 (Baek Da Yeon)</li>
         *   <li>2024-12-21: Gui 퀴즈 추가 (Baek Da Yeon)</li>
         *   <li>2024-12-21: 알고리즘 설계 퀴즈 추가 (Baek Da Yeon)</li>
         *   <li>2024-12-22: 점수 결과 추가 (Baek Da Yeon)</li>
         * </ul>
         */

        // 퀴즈 시작
        int score = 0;
        for (int i = 0; i < 3; i++) {
            String question = questions.get(subject)[i];
            String correctAnswer = answers.get(subject)[i];

            String userAnswer = JOptionPane.showInputDialog(null, question);
            if (userAnswer != null && userAnswer.equalsIgnoreCase(correctAnswer)) {
                score++;
            }
        }

        JOptionPane.showMessageDialog(null, " 맞힌 개수: " + score + " / 3"); // 결과 표시
    }
}
