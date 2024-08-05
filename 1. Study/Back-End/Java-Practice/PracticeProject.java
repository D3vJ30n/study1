import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.io.*;

/**
 * PracticeProject 클래스: To-Do List 애플리케이션의 메인 클래스
 * JFrame을 상속받아 GUI 윈도우를 생성합니다.
 */
public class PracticeProject extends JFrame {
    // GUI 컴포넌트 선언
    private JTextField taskInput;  // 새 할 일을 입력받는 텍스트 필드
    private DefaultListModel<String> listModel;  // JList에 데이터를 제공하는 모델
    private JList<String> taskList;  // 할 일 목록을 표시하는 리스트
    private ArrayList<String> tasks;  // 할 일 항목을 저장하는 ArrayList
    private static final String FILE_NAME = "tasks.txt";  // 할 일 목록을 저장할 파일 이름

    /**
     * 생성자: GUI 초기화 및 설정
     */
    public PracticeProject() {
        super("Practice Project: To-Do List App");  // 윈도우 제목 설정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // 창 닫기 버튼 동작 설정
        setSize(400, 300);  // 윈도우 크기 설정
        setLayout(new BorderLayout());  // 레이아웃 관리자 설정

        initComponents();  // GUI 컴포넌트 초기화
        addListeners();  // 이벤트 리스너 추가
        loadTasks();  // 저장된 할 일 목록 불러오기

        setVisible(true);  // 윈도우 표시
    }

    /**
     * GUI 컴포넌트 초기화 및 배치
     */
    private void initComponents() {
        // 입력 패널: 새 할 일 입력을 위한 텍스트 필드와 추가 버튼
        JPanel inputPanel = new JPanel();
        taskInput = new JTextField(20);
        JButton addButton = new JButton("Add");
        inputPanel.add(taskInput);
        inputPanel.add(addButton);

        // 할 일 목록: ArrayList와 DefaultListModel을 사용하여 JList 구성
        tasks = new ArrayList<>();
        listModel = new DefaultListModel<>();
        taskList = new JList<>(listModel);

        // 버튼 패널: 삭제와 완료 표시 버튼
        JPanel buttonPanel = new JPanel();
        JButton deleteButton = new JButton("Delete");
        JButton completeButton = new JButton("Mark Complete");
        buttonPanel.add(deleteButton);
        buttonPanel.add(completeButton);

        // 컴포넌트 배치: BorderLayout을 사용하여 패널들을 배치
        add(inputPanel, BorderLayout.NORTH);
        add(new JScrollPane(taskList), BorderLayout.CENTER);  // JScrollPane으로 JList 감싸기
        add(buttonPanel, BorderLayout.SOUTH);
    }

    /**
     * 이벤트 리스너 추가
     */
    private void addListeners() {
        // Add 버튼에 리스너 추가
        ((JButton)((JPanel)getContentPane().getComponent(0)).getComponent(1)).addActionListener(e -> addTask());
        // Delete 버튼에 리스너 추가
        ((JButton)((JPanel)getContentPane().getComponent(2)).getComponent(0)).addActionListener(e -> deleteTask());
        // Mark Complete 버튼에 리스너 추가
        ((JButton)((JPanel)getContentPane().getComponent(2)).getComponent(1)).addActionListener(e -> markTaskComplete());

        // 윈도우 종료 시 할 일 목록 저장
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                saveTasks();
            }
        });
    }

    /**
     * 새 할 일 추가
     */
    private void addTask() {
        String task = taskInput.getText().trim();  // 입력된 텍스트 가져오기 및 앞뒤 공백 제거
        if (!task.isEmpty()) {  // 입력이 비어있지 않은 경우에만 처리
            tasks.add(task);  // ArrayList에 할 일 추가
            updateTaskList();  // JList 업데이트
            taskInput.setText("");  // 입력 필드 초기화
        }
    }

    /**
     * 선택된 할 일 삭제
     */
    private void deleteTask() {
        int selectedIndex = taskList.getSelectedIndex();  // 선택된 항목의 인덱스 가져오기
        if (selectedIndex != -1) {  // 항목이 선택된 경우에만 처리
            tasks.remove(selectedIndex);  // ArrayList에서 해당 항목 제거
            updateTaskList();  // JList 업데이트
        }
    }

    /**
     * 선택된 할 일을 완료 표시
     */
    private void markTaskComplete() {
        int selectedIndex = taskList.getSelectedIndex();  // 선택된 항목의 인덱스 가져오기
        if (selectedIndex != -1) {  // 항목이 선택된 경우에만 처리
            String task = tasks.get(selectedIndex);
            // 이미 완료 표시가 되어 있지 않은 경우에만 "[완료]" 추가
            tasks.set(selectedIndex, "[완료] " + task.replaceFirst("^\\[완료\\] ", ""));
            updateTaskList();  // JList 업데이트
        }
    }

    /**
     * JList 업데이트: ArrayList의 내용을 DefaultListModel에 반영
     */
    private void updateTaskList() {
        listModel.clear();  // 기존 목록 초기화
        listModel.addAll(tasks);  // ArrayList의 모든 항목을 DefaultListModel에 추가
    }

    /**
     * 할 일 목록을 파일에 저장
     */
    private void saveTasks() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
            tasks.forEach(writer::println);  // 각 할 일을 한 줄씩 파일에 쓰기
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error saving tasks: " + e.getMessage());
        }
    }

    /**
     * 파일에서 할 일 목록 불러오기
     */
    private void loadTasks() {
        tasks.clear();  // 기존 목록 초기화
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            reader.lines().forEach(tasks::add);  // 파일의 각 줄을 ArrayList에 추가
            updateTaskList();  // JList 업데이트
        } catch (IOException e) {
            // 파일이 없는 경우(첫 실행 시)는 무시하고, 다른 IO 오류의 경우 메시지 표시
            if (!(e instanceof FileNotFoundException)) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error loading tasks: " + e.getMessage());
            }
        }
    }

    /**
     * 메인 메소드: 애플리케이션 실행
     */
    public static void main(String[] args) {
        // Event Dispatch Thread에서 GUI 생성 및 표시
        SwingUtilities.invokeLater(PracticeProject::new);
    }
}