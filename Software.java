package five;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

import javax.swing.*;

public class Software extends JFrame {
    private JTextArea resultTextArea;

    public Software() {
        setTitle("经典软件体系结构教学软件");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLayout(new BorderLayout());

        // 创建选择处理方法的下拉框
        String[] methods = {"主程序-子程序", "面向对象", "事件系统", "管道-过滤器"};
        JComboBox<String> methodComboBox = new JComboBox<>(methods);
        methodComboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedMethod = (String) methodComboBox.getSelectedItem();
                processFile(selectedMethod);
            }
        });

        // 创建结果显示文本区域
        resultTextArea = new JTextArea();
        resultTextArea.setEditable(false);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 4));
        buttonPanel.add(methodComboBox);
        add(buttonPanel, BorderLayout.NORTH);
        add(new JScrollPane(resultTextArea), BorderLayout.CENTER);

    }


    private void processFile(String method) {
        // 根据选择的处理方法对指定的输入文件进行处理，并将结果显示在界面上
        String result = "";
        String filePath = "D:\\Program Files\\input.txt"; // 用户指定的文件路径
        File file = new File(filePath);
        if (file.exists()) {
            try {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                StringBuilder content = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    content.append(line);
                    content.append("\n");
                }
                reader.close();
                JPanel mainPanel = new JPanel();
                mainPanel.setLayout(new BorderLayout());
                JPanel buttonPanel = new JPanel();
                buttonPanel.setLayout(new GridLayout(1, 4));
                JButton method1Button = new JButton("主程序-子程序");
                method1Button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // 调用主程序-子程序的处理方法
                        resultTextArea.setText("使用主程序-子程序的方法处理文件");
                    }
                });
                buttonPanel.add(method1Button);

                JButton method2Button = new JButton("面向对象");
                method2Button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // 调用面向对象的处理方法
                        resultTextArea.setText("使用面向对象的方法处理文件");
                    }
                });
                buttonPanel.add(method2Button);

                JButton method3Button = new JButton("事件系统");
                method3Button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // 调用事件系统的处理方法
                        resultTextArea.setText("使用事件系统的方法处理文件");
                    }
                });
                buttonPanel.add(method3Button);

                JButton method4Button = new JButton("管道-过滤器");
                method4Button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // 调用管道-过滤器的处理方法
                        resultTextArea.setText("使用管道-过滤器的方法处理文件");
                    }
                });
                buttonPanel.add(method4Button);
                mainPanel.add(buttonPanel, BorderLayout.SOUTH);

                add(mainPanel);

                        // Assuming 'content' is a StringBuilder instance with the input content
                        StringBuilder content2 = new StringBuilder("zhang fen fang\n" +
                                "The sun is rising in the east\n" +
                                "Flowers are blooming");

                        String[] lines = content2.toString().split("\n");
                        StringBuilder shiftedContent = new StringBuilder();

                        // Process each line
                        for (String line2 : lines) {
                            String[] words = line2.split(" ");

                            // Sort the words alphabetically
                            Arrays.sort(words, Comparator.naturalOrder());

                            // Construct shifted lines
                            for (int i = 0; i < words.length; i++) {
                                StringBuilder shiftedLine = new StringBuilder();
                                for (int j = i; j < words.length; j++) {
                                    shiftedLine.append(words[j]);
                                    shiftedLine.append(" ");
                                }
                                for (int j = 0; j < i; j++) {
                                    shiftedLine.append(words[j]);
                                    shiftedLine.append(" ");
                                }
                                shiftedContent.append(shiftedLine.toString().trim());
                                shiftedContent.append("\n");
                            }
                        }

                        // Assuming 'resultTextArea' is your text area to display the result
                        resultTextArea.setText(result + "\n结果：\n" + shiftedContent.toString());

            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            result = "文件不存在";
            resultTextArea.setText(result);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Software tutorial = new Software();
                tutorial.setVisible(true);
            }
        });
    }
}