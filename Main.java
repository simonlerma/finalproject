import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {

    // -------------------------------------
    // Scene class
    // -------------------------------------
static class Scene {
        private String imagePath;
        private String sceneText;
        private String buttonOneText;
        private String buttonTwoText;
        private int nextSceneOne;
        private int nextSceneTwo;
        private int karmaChangeOne;
        private int karmaChangeTwo;

        public Scene(String imagePath, String sceneText, String buttonOneText, String buttonTwoText,
                int nextSceneOne, int nextSceneTwo, int karmaChangeOne, int karmaChangeTwo) {
        this.imagePath = imagePath;
        this.sceneText = sceneText;
        this.buttonOneText = buttonOneText;
        this.buttonTwoText = buttonTwoText;
        this.nextSceneOne = nextSceneOne;
        this.nextSceneTwo = nextSceneTwo;
        this.karmaChangeOne = karmaChangeOne;
        this.karmaChangeTwo = karmaChangeTwo;
        }

        public String getImagePath() { return imagePath; }
        public String getSceneText() { return sceneText; }
        public String getButtonOneText() { return buttonOneText; }
        public String getButtonTwoText() { return buttonTwoText; }
        public int getNextSceneOne() { return nextSceneOne; }
        public int getNextSceneTwo() { return nextSceneTwo; }
        public int getKarmaChangeOne() { return karmaChangeOne; }
        public int getKarmaChangeTwo() { return karmaChangeTwo; }
}

    // -------------------------------------
    // Game fields
    // -------------------------------------
private Scene[] scenes;
private int currentScene = 0;
private int karma = 0;

private JLabel imageLabel;
private JTextArea textArea;
private JButton button1;
private JButton button2;

    // -------------------------------------
    // Constructor
    // -------------------------------------
public Main() {
        setTitle("Flicker");
        setSize(900, 650);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        // Image label
        imageLabel = new JLabel();
        imageLabel.setHorizontalAlignment(JLabel.CENTER);
        imageLabel.setPreferredSize(new Dimension(900, 300));
        add(imageLabel, BorderLayout.NORTH);

        // Text area
        textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setFont(new Font("Arial", Font.PLAIN, 18));
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(900, 200));
        add(scrollPane, BorderLayout.CENTER);

        // Buttons
        JPanel buttonPanel = new JPanel(new GridLayout(1,2));
        button1 = new JButton("Choice 1");
        button2 = new JButton("Choice 2");
        buttonPanel.add(button1);
        buttonPanel.add(button2);
        add(buttonPanel, BorderLayout.SOUTH);

        // Button actions
        button1.addActionListener(e -> processChoice(1));
        button2.addActionListener(e -> processChoice(2));

        // Load scenes
        loadScenes();

        // Show first scene
        displayScene(currentScene);

        setVisible(true);
}

    // -------------------------------------
    // Load all 18 scenes
    // -------------------------------------
private void loadScenes() {
        scenes = new Scene[] {
        new Scene("images/scene1.png", "6:30 AM alarm goes off. Important presentation today.",
                "Hit Snooze", "Get Up", 1, 2, 2, 1),

        new Scene("images/scene2.png", "You wake up late, panicking on your commute.",
                "Rush Out", "Take Time", 3, 4, 2, 1),

        new Scene("images/scene3.png", "You see an elderly neighbor struggling with groceries.",
                "Help them", "Ignore them", 5, 6, 1, 2),

        new Scene("images/scene4.png", "Someone spills coffee on your shirt at the coffee shop.",
                "Accept apology", "Get angry", 7, 8, 1, 2),

        new Scene("images/scene5.png", "A homeless person asks for spare change.",
                "Give money", "Walk past", 9, 10, 1, 2),

        new Scene("images/scene6.png", "Traffic is heavy; someone tries to merge into your lane.",
                "Let them merge", "Block them", 11, 12, 1, 2),

        new Scene("images/scene7.png", "Coworker asks for help finishing a report.",
                "Help them", "Too busy", 13, 14, 1, 2),

        new Scene("images/scene8.png", "Sensitive documents left on the printer.",
                "Turn them in", "Ignore", 15, 16, 1, 2),

        new Scene("images/scene9.png", "Your boss asks for honest thoughts about a project.",
                "Tell truth respectfully", "Tell them what they want", 17, 18, 1, 2),

        new Scene("images/scene10.png", "You notice someone can't afford lunch.",
                "Pay for meal", "Walk away", 17, 18, 1, 2),

        new Scene("images/scene11.png", "You witness a minor car accident on the way home.",
                "Stop to help", "Keep driving", 17, 18, 1, 2),

        new Scene("images/scene12.png", "Team needs help after hours.",
                "Stay to help", "Ignore", 17, 18, 1, 2),

        new Scene("images/scene13.png", "A lost wallet weighs on your conscience.",
                "Return it", "Keep it", 17, 18, 1, 2),

        new Scene("images/scene14.png", "Offered to lead charity initiative.",
                "Accept", "Decline", 17, 18, 1, 2),

        new Scene("images/scene15.png", "Someone drops belongings at the train station.",
                "Help", "Ignore", 17, 18, 1, 2),

        new Scene("images/scene16.png", "Reflecting on the day's choices.",
                "Grateful", "Ignore behavior", 17, 18, 1, 2),

        new Scene("images/scene17.png", "Drive home feels heavy; fate awaits.",
                "Accept fate", "Reject responsibility", 17, 18, 1, 2),

        new Scene("images/scene18.png", "Final moral crossroads of the day.",
                    "Choose compassion", "Choose selfishness", -1, -1, 1, 2) // endings
        };
}

    // -------------------------------------
    // Display a scene
    // -------------------------------------
private void displayScene(int index) {
        Scene s = scenes[index];
        textArea.setText(s.getSceneText());
        button1.setText(s.getButtonOneText());
        button2.setText(s.getButtonTwoText());

        ImageIcon icon = new ImageIcon(s.getImagePath());
        Image scaled = icon.getImage().getScaledInstance(900, 300, Image.SCALE_SMOOTH);
        imageLabel.setIcon(new ImageIcon(scaled));
}

    // -------------------------------------
    // Process choice and update karma
    // -------------------------------------
private void processChoice(int choice) {
        Scene s = scenes[currentScene];
        if (choice == 1) karma += s.getKarmaChangeOne();
        else karma += s.getKarmaChangeTwo();

        int next = (choice == 1) ? s.getNextSceneOne() : s.getNextSceneTwo();

        if (next == -1) {
        String ending;
        if (karma <= 10) ending = "HELL ENDING 🔥\nSelfish choices lead to darkness.";
        else if (karma <= 20) ending = "PURGATORY ENDING ☁️\nNeither good nor bad.";
        else ending = "HEAVEN ENDING 🕊️\nYour selfless choices lead to peace.";

        JOptionPane.showMessageDialog(this, ending + "\nTotal karma: " + karma);
        System.exit(0);
        }

        currentScene = next;
        displayScene(currentScene);
}

    // -------------------------------------
    // Main
    // -------------------------------------
public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::new);
}
}
