import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import java.awt.Color;

public class DeckNewGUI {
    private JButton btnShuffle;
    private JPanel panelMain;
    private JButton btnDraw;
    private JButton btnSort;
    private JLabel lblOne;
    private JLabel lblTwo;
    private JLabel lblTitle;
    private DeckOfCard deckOfCard;

    public DeckNewGUI() {
        panelMain = new JPanel();
        btnShuffle = new JButton("Shuffle");
        btnDraw = new JButton("Draw");
        btnSort = new JButton("Sort");

        lblTitle = new JLabel("Card Deck");
        lblOne = new JLabel("default");
        lblTwo = new JLabel("default2");

        lblTitle.setFont(lblTitle.getFont().deriveFont(64.0f));
        btnShuffle.setSize(30, 30);

        panelMain.setBackground(new Color(0, 204, 102));
        panelMain.add(btnShuffle);
        panelMain.add(btnDraw);
        panelMain.add(btnSort);
        panelMain.add(lblOne);
        panelMain.add(lblTwo);
        panelMain.add(lblTitle);


        btnShuffle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deckOfCard = new DeckOfCard();

                deckOfCard.shuffling();

                lblOne.setText("Shuffled Cards:");
                lblTwo.setText(deckOfCard.toString());
            }
        });
        btnDraw.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //   deckOfCard.deal();
            }
        });
        btnSort.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deckOfCard.sort();
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Card Deck");
        frame.setContentPane(new DeckNewGUI().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(700, 550));
        //Display the window.
        frame.pack();
        frame.setVisible(true);

    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}