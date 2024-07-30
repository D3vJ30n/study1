import javax.swing. *;
import java.awt. *;
import java.awt.event. *;
import java.util.ArrayList;
import java.io. *;

public class PracticeProject extends JFrame {
    private JTextField taskInput;
    private DefaultListModel<String> listModel;
    private JList<String> taskList;
    private ArrayList<String> tasks;
    private final String FILE_NAME = "tasks.txt";

    public PracticeProject() {
        super("Practice Project: To-Do List App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLayout(new BorderLayout());

        // 입력 패널
        JPanel inputPanel = new JPanel();
        taskInput = new JTextField(20);
        JButton addButton = new JButton("Add");
        inputPanel.add(taskInput);
        inputPanel.add(addButton);

        // 할 일 목록
        tasks = new ArrayList<>();
        listModel = new DefaultListModel<>();
        taskList = new JList<>(listModel);

        // 버튼 패널
        JPanel buttonPanel = new JPanel();
        JButton deleteButton = new JButton("Delete");
        JButton completeButton = new JButton("Mark Complete");
        buttonPanel.add(deleteButton);
        buttonPanel.add(completeButton);

        // 컴포넌트 배치
        add(inputPanel, BorderLayout.NORTH);
        add(new JScrollPane(taskList), BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        // 이벤트 리스너 추가
        addButton.addActionListener(e - >addTask());
        deleteButton.addActionListener(e - >deleteTask());
        completeButton.addActionListener(e - >markTaskComplete());

        // 프로그램 종료 시 데이터 저장
        addWindowListener(new WindowAdapter() {
            @Override public void windowClosing(WindowEvent e) {
                saveTasks();
            }
        });

        // 저장된 데이터 불러오기
        loadTasks();

        setVisible(true);
    }

    private void addTask() {
        String task = taskInput
            .getText()
            .trim();
        if (!task.isEmpty()) {
            tasks.add(task);
            updateTaskList();
            taskInput.setText("");
        }
    }

    private void deleteTask() {
        int selectedIndex = taskList.getSelectedIndex();
        if (selectedIndex != -1) {
            tasks.remove(selectedIndex);
            updateTaskList();
        }
    }

    private void markTaskComplete() {
        int selectedIndex = taskList.getSelectedIndex();
        if (selectedIndex != -1) {
            String task = tasks.get(selectedIndex);
            tasks.set(selectedIndex, "[완료] " + task);
            updateTaskList();
        }
    }

    private void updateTaskList() {
        listModel.clear();
        for (String task : tasks) {
            listModel.addElement(task);
        }
    }

    private void saveTasks() {
        try(PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (String task : tasks) {
                writer.println(task);
            }
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error saving tasks: " + e.getMessage());
        }
    }

    private void loadTasks() {
        tasks.clear();
        try(BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                tasks.add(line);
            }
            updateTaskList();
        } catch (IOException e) {
            // 파일이 없는 경우 무시 (첫 실행 시)
            if (!(e instanceof FileNotFoundException)) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error loading tasks: " + e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new PracticeProject());
    }
}