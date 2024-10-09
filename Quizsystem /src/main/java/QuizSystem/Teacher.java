
package QuizSystem;




import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;
public class Teacher extends javax.swing.JFrame {
         private final JButton createQuestionBankButton;
    private final JButton SetTimerButton;
    private final JButton markQuizButton;
     private final String timerFile = "timer.txt";
    public Teacher() {
        setTitle("Teacher Dashboard");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        createQuestionBankButton = new JButton("Create Question Bank");
        SetTimerButton = new JButton("Set Timer");
        markQuizButton = new JButton("Mark Quiz");

        setLayout(new GridLayout(3, 1));
        add(createQuestionBankButton);
        add(SetTimerButton);
        add(markQuizButton);

        createQuestionBankButton.addActionListener((ActionEvent e) -> {
            createQuestionBank();
        });

        SetTimerButton.addActionListener((ActionEvent e) -> {
            SetTimer();
        });

        markQuizButton.addActionListener((ActionEvent e) -> {
            markQuiz();
        });
    }

    private void createQuestionBank() {
        String question = JOptionPane.showInputDialog(this, "Enter the question:");
        String optionA = JOptionPane.showInputDialog(this, "Enter option A:");
        String optionB = JOptionPane.showInputDialog(this, "Enter option B:");
        String optionC = JOptionPane.showInputDialog(this, "Enter option C:");
        String optionD = JOptionPane.showInputDialog(this, "Enter option D:");
        String correctAnswer = JOptionPane.showInputDialog(this, "Enter the correct answer (A, B, C, or D):");
        // Save the question and options to a file or a data structure of your choice
        // For simplicity, let's assume we are writing to a file

         try {
            FileWriter writer = new FileWriter("question_bank.txt", true);
            writer.write(question + "\n");
            writer.write(optionA + "\n");
            writer.write(optionB + "\n");
            writer.write(optionC + "\n");
            writer.write(optionD + "\n");
            writer.write(correctAnswer + "\n");
            writer.close();
            JOptionPane.showMessageDialog(this, "Question bank created successfully!");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "An error occurred while creating the question bank.", "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }

     public void SetTimer() {
        String timeLimitString = JOptionPane.showInputDialog(this, "Set the time limit for the quiz (in seconds):");
        int timeLimitInSeconds = Integer.parseInt(timeLimitString);

        Timer timer = new Timer(timeLimitInSeconds * 1000, (ActionEvent e) -> {
            
        });
        timer.setRepeats(false); // Set the timer to fire only once

        timer.start(); // Start the timer

        JOptionPane.showMessageDialog(this, "Quiz created successfully! You have " + timeLimitInSeconds + " seconds to complete the quiz.");
    }

    private void markQuiz() {
        // Implement logic to mark the quiz
        JOptionPane.showMessageDialog(this, "Quiz marked successfully!");
    }
    
    public static void main(String[] args) {
        Teacher dashboard = new Teacher();
        dashboard.setVisible(true);
    }
}