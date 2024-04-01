package lab;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Test extends JFrame implements ActionListener {
    private final JButton[][] buttons = new JButton[3][3];
    private boolean player1Turn = true;
    private boolean gameOver = false;

    public Test() {
        setTitle("Tic Tac Toe");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        setLayout(new GridLayout(3, 3));

        initializeButtons();

        setVisible(true);
    }

    private void initializeButtons() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                JButton button = new JButton("");
                button.setFont(new Font("Arial", Font.PLAIN, 40));
                button.addActionListener(this);
                buttons[i][j] = button;
                add(button);
            }
        }
    }

    private void computerMove() {
        int[] bestMove = findBestMove();
        if (bestMove[0] != -1 && bestMove[1] != -1) {
            buttons[bestMove[0]][bestMove[1]].setText("O");
            player1Turn = true;
            checkGameStatus();
        }
    }

    private int evaluate() {
        for (int i = 0; i < 3; i++) {
            if (buttons[i][0].getText().equals(buttons[i][1].getText()) &&
                    buttons[i][1].getText().equals(buttons[i][2].getText())) {
                if (buttons[i][0].getText().equals("X")) return -1;
                else if (buttons[i][0].getText().equals("O")) return 1;
            }
            if (buttons[0][i].getText().equals(buttons[1][i].getText()) &&
                    buttons[1][i].getText().equals(buttons[2][i].getText())) {
                if (buttons[0][i].getText().equals("X")) return -1;
                else if (buttons[0][i].getText().equals("O")) return 1;
            }
        }

        if (buttons[0][0].getText().equals(buttons[1][1].getText()) &&
                buttons[1][1].getText().equals(buttons[2][2].getText())) {
            if (buttons[0][0].getText().equals("X")) return -1;
            else if (buttons[0][0].getText().equals("O")) return 1;
        }

        if (buttons[0][2].getText().equals(buttons[1][1].getText()) &&
                buttons[1][1].getText().equals(buttons[2][0].getText())) {
            if (buttons[0][2].getText().equals("X")) return -1;
            else if (buttons[0][2].getText().equals("O")) return 1;
        }

        return 0;
    }

    private int minimax(int depth, boolean isMax) {
        int score = evaluate();

        if (score == 1 || score == -1) return score;

        if (!isMovesLeft()) return 0;

        if (isMax) {
            int best = Integer.MIN_VALUE;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (buttons[i][j].getText().isEmpty()) {
                        buttons[i][j].setText("O");
                        best = Math.max(best, minimax(depth + 1, !isMax));
                        buttons[i][j].setText("");
                    }
                }
            }
            return best;
        } else {
            int best = Integer.MAX_VALUE;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (buttons[i][j].getText().isEmpty()) {
                        buttons[i][j].setText("X");
                        best = Math.min(best, minimax(depth + 1, !isMax));
                        buttons[i][j].setText("");
                    }
                }
            }
            return best;
        }
    }

    private int[] findBestMove() {
        int bestVal = Integer.MIN_VALUE;
        int[] bestMove = {-1, -1};

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (buttons[i][j].getText().isEmpty()) {
                    buttons[i][j].setText("O");
                    int moveVal = minimax(0, false);
                    buttons[i][j].setText("");
                    if (moveVal > bestVal) {
                        bestMove[0] = i;
                        bestMove[1] = j;
                        bestVal = moveVal;
                    }
                }
            }
        }

        return bestMove;
    }

    private boolean isMovesLeft() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (buttons[i][j].getText().isEmpty()) {
                    return true;
                }
            }
        }
        return false;
    }

    private void checkGameStatus() {
        int score = evaluate();
        if (score == 1) {
            JOptionPane.showMessageDialog(this, "Computer wins!");
            gameOver = true;
        } else if (score == -1) {
            JOptionPane.showMessageDialog(this, "Player wins!");
            gameOver = true;
        } else if (!isMovesLeft()) {
            JOptionPane.showMessageDialog(this, "It's a draw!");
            gameOver = true;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        if (button.getText().isEmpty() && !gameOver) {
            if (player1Turn) {
                button.setText("X");
                player1Turn = false;
                checkGameStatus();
                computerMove();
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Test::new);
    }
}
