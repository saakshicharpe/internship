import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class QuizApplication extends JFrame {

    private int questionIndex = 0;
    private int score = 0;
    private int timeLeft = 30; // 30 seconds
    private Timer timer;
    private JLabel questionLabel;
    private JRadioButton[] answerButtons;
    private JButton submitButton;
    private JLabel timeLabel;
    private JLabel scoreLabel;

    private String[] questions = {
            "What is the capital of France?",
            "What is the largest planet in our solar system?",
            "Who painted the Mona Lisa?",
            "What is the chemical symbol for gold?",
            "Who wrote Romeo and Juliet?",
            "What is the smallest country in the world?",
            "What is the largest living species of lizard?",
            "Who was the first president of the United States?",
            "What is the deepest part of the ocean?",
            "What is the highest mountain peak in the solar system?"
    };

    private String[][] answers = {
            {"Paris", "London", "Berlin", "Rome"},
            {"Jupiter", "Saturn", "Uranus", "Neptune"},
            {"Leonardo da Vinci", "Michelangelo", "Raphael", "Caravaggio"},
            {"Ag", "Au", "Hg", "Pb"},
            {"William Shakespeare", "Jane Austen", "Charles Dickens", "J.K. Rowling"},
            {"Vatican City", "Monaco", "Nauru", "Tuvalu"},
            {"Komodo dragon", "Saltwater crocodile", "Black mamba", "African elephant"},
            {"George Washington", "Thomas Jefferson", "Abraham Lincoln", "Franklin D. Roosevelt"},
            {"Mariana Trench", "Grand Canyon", "Great Barrier Reef", "Mount Everest"},
            {"Olympus Mons", "Mauna Kea", "Denali", "Kilimanjaro"}
    };

    private int[] correctAnswers = {0, 0, 0, 1, 0, 0, 0, 0, 0, 0};
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new QuizApplication();
            }
        });
    }

    
          public QuizApplication() {
        setLayout(new BorderLayout());

        timer = new  javax.swing.Timer(1000, new TimerListener());
        timer.start();
                    // Create banner panel
        JPanel bannerPanel = new JPanel();
        bannerPanel.setLayout(new FlowLayout());
        JLabel bannerLabel = new JLabel("Quiz Application");
        bannerLabel.setFont(new Font("Arial", Font.BOLD, 24));
        bannerPanel.add(bannerLabel);
        add(bannerPanel, BorderLayout.NORTH);

        // Create question panel
        JPanel questionPanel = new JPanel();
        questionPanel.setLayout(new BorderLayout());
        questionLabel = new JLabel(questions[questionIndex]);
        questionLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        questionPanel.add(questionLabel, BorderLayout.NORTH);

        // Create answer panel
        JPanel answerPanel = new JPanel();
        answerPanel.setLayout(new GridLayout(4, 1));
        answerButtons = new JRadioButton[4];
        for (int i = 0; i < 4; i++) {
            answerButtons[i] = new JRadioButton(answers[questionIndex][i]);
            answerButtons[i].setFont(new Font("Arial", Font.PLAIN, 18));
            answerPanel.add(answerButtons[i]);
        }
        answerButtons[0].setSelected(true);//Set the Frist radio button as selected
        questionPanel.add(answerPanel, BorderLayout.CENTER);
       
                            
                  
        // Create submit panel
       class SubmitButtonListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < 4; i++) {
                    if (answerButtons[i].isSelected()) {
                        if (i == correctAnswers[questionIndex]) {
                            score++;
                            scoreLabel.setText("Score: " + score);
                        }
                        questionIndex++;
                        if (questionIndex < questions.length) {
                            questionLabel.setText(questions[questionIndex]);
                            for (int j = 0; j < 4; j++) {
                                answerButtons[j].setText(answers[questionIndex][j]);
                            }
                            answerButtons[0].setSelected(true);
                        } else {
                            timer.stop();
                            // Handle quiz completion situation
                            JOptionPane.showMessageDialog(QuizApplication.this, "Quiz completed! Your score is " + score);
                            System.exit(0);
                        }
                        break;
                    }
                }
            }
        }
        JPanel submitPanel = new JPanel();
        submitPanel.setLayout(new FlowLayout());
        submitButton = new JButton("Submit");
        submitButton.addActionListener(new SubmitButtonListener());
        submitPanel.add(submitButton);
        questionPanel.add(submitPanel, BorderLayout.SOUTH);

        // Create time panel
    
        JPanel timePanel = new JPanel();
        timePanel.setLayout(new FlowLayout());
        timeLabel = new JLabel("Time left: " + timeLeft + " seconds");
        timeLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        timePanel.add(timeLabel);

        // Create score panel
        JPanel scorePanel = new JPanel();
        scorePanel.setLayout(new FlowLayout());
        scoreLabel = new JLabel("Score: " + score);
        scoreLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        scorePanel.add(scoreLabel);

        // Add panels to frame
        add(questionPanel, BorderLayout.CENTER);
        add(timePanel, BorderLayout.EAST);
        add(scorePanel, BorderLayout.WEST);

             // Set up radio buttons
        ButtonGroup group = new ButtonGroup();
        for (JRadioButton button : answerButtons) {
            group.add(button);
        }

        // Set up frame
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    private class TimerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            timeLeft--;
            timeLabel.setText("Time left: " + timeLeft + " seconds");
        }
    }
}