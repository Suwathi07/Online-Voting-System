package voting; 
 
import javax.swing.*; 
import java.awt.*; 
import java.util.*; 
 
public class VotingSystemGUI { 
 
   
 
    private static final Map<String, Election> elections = new HashMap<>(); 
    private static final Map<String, Voter> voters = new HashMap<>(); 
    private static final Set<String> votedVoters = new HashSet<>(); 
 
    private static final String ADMIN_PASSWORD = "admin123"; 
 
    private JFrame frame; 
    private JPanel mainPanel; 
 
     
    public static void main(String[] args) { 
 
    // Make all Swing components use larger fonts 
    UIManager.put("Button.font", 
            new Font("Arial", Font.BOLD, 28)); 
 
    UIManager.put("Label.font", 
            new Font("Arial", Font.BOLD, 28)); 
 
    UIManager.put("TextField.font", 
            new Font("Arial", Font.PLAIN, 28)); 
 
    UIManager.put("PasswordField.font", 
            new Font("Arial", Font.PLAIN, 28)); 
 
    UIManager.put("ComboBox.font", 
            new Font("Arial", Font.PLAIN, 28)); 
 
    UIManager.put("TextArea.font", 
            new Font("Arial", Font.PLAIN, 28)); 
 
    elections.put("Governmental", 
            new Election("Governmental")); 
 
    elections.put("Organizational", 
            new Election("Organizational")); 
 
    elections.put("Educational", 
            new Election("Educational")); 
 
    SwingUtilities.invokeLater(() -> 
            new VotingSystemGUI().createMainWindow() 
    ); 
} 
 
    // ================= MAIN WINDOW ================= 
 
    private void createMainWindow() { 
 
        frame = new JFrame("Online Voting System"); 
 
        frame.setSize(1550, 800); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        frame.setLocationRelativeTo(null); 
        frame.setResizable(true); 
 
        showMainMenu(); 
 
        frame.setVisible(true); 
    } 
 
    // ================= MAIN MENU ================= 
 
    private void showMainMenu() { 
 
        mainPanel = new JPanel(); 
        mainPanel.setBackground(new Color(128, 0, 128)); 
 
        mainPanel.setLayout( 
                new GridLayout(6, 1, 15, 15) 
        ); 
 
        mainPanel.setBorder( 
                BorderFactory.createEmptyBorder( 
                        40, 100, 40, 100 
                ) 
        ); 
 
        JLabel title = new JLabel( 
                "ONLINE VOTING SYSTEM", 
                SwingConstants.CENTER 
        ); 
 
        title.setFont( 
                new Font("Arial", Font.BOLD, 40) 
        ); 
 
        title.setForeground(Color.WHITE); 
 
        JButton adminButton = 
                new JButton("Admin Login"); 
 
        JButton registerButton = 
                new JButton("Register as Voter"); 
 
        JButton voterButton = 
                new JButton("Voter Panel"); 
 
        JButton resultButton = 
                new JButton("View Results"); 
 
        JButton exitButton = 
                new JButton("Exit"); 
 
        adminButton.addActionListener(e -> 
                showAdminLogin() 
        ); 
 
        registerButton.addActionListener(e -> 
                showRegisterVoter() 
        ); 
 
        voterButton.addActionListener(e -> 
                showVoterPanel() 
        ); 
 
        resultButton.addActionListener(e -> 
                showResultLogin() 
        ); 
 
        exitButton.addActionListener(e -> { 
 
            int choice = JOptionPane.showConfirmDialog( 
                    frame, 
                    "Are you sure you want to exit?", 
                    "Exit", 
                    JOptionPane.YES_NO_OPTION 
            ); 
 
            if (choice == JOptionPane.YES_OPTION) { 
                System.exit(0); 
            } 
        }); 
 
        mainPanel.add(title); 
        mainPanel.add(adminButton); 
        mainPanel.add(registerButton); 
        mainPanel.add(voterButton); 
        mainPanel.add(resultButton); 
        mainPanel.add(exitButton); 
 
        frame.setContentPane(mainPanel); 
        frame.revalidate(); 
        frame.repaint(); 
    } 
 // ================= ADMIN LOGIN =================

private void showAdminLogin() {

    JPanel panel = createScreenPanel();

    JLabel title =
            createTitle("ADMIN LOGIN");

    JLabel passwordLabel =
            new JLabel(
                    "Admin Password:",
                    SwingConstants.CENTER
            );

    passwordLabel.setFont(
            new Font("Arial", Font.BOLD, 28)
    );

    JPasswordField passwordField =
            new JPasswordField();

    passwordField.setFont(
            new Font("Arial", Font.PLAIN, 26)
    );

    passwordField.setPreferredSize(
            new Dimension(500, 60)
    );

    passwordField.setMaximumSize(
            new Dimension(500, 60)
    );

    JButton loginButton =
            new JButton("Login");

    loginButton.setFont(
            new Font("Arial", Font.BOLD, 28)
    );

    loginButton.setPreferredSize(
            new Dimension(500, 65)
    );

    loginButton.setMaximumSize(
            new Dimension(500, 65)
    );

    JButton backButton =
            new JButton("Back");

    backButton.setFont(
            new Font("Arial", Font.BOLD, 28)
    );

    backButton.setPreferredSize(
            new Dimension(500, 65)
    );

    backButton.setMaximumSize(
            new Dimension(500, 65)
    );


    // ===== LOGIN ACTION =====

    loginButton.addActionListener(e -> {

        String password =
                new String(
                        passwordField.getPassword()
                );

        if (password.equals(ADMIN_PASSWORD)) {

            showAdminPanel();

        } else {

            showMessage(
                    "Wrong Password!",
                    "Login Error"
            );
        }
    });


    // ===== BACK ACTION =====

    backButton.addActionListener(e ->
            showMainMenu()
    );


    // ===== ADD COMPONENTS =====
addCentered(panel, title, 0);
addCentered(panel, passwordLabel, 1);
addCentered(panel, passwordField, 2);
addCentered(panel, loginButton, 3);
addCentered(panel, backButton, 4);
    setScreen(panel);
}
 
    // ================= ADMIN PANEL ================= 
 
    private void showAdminPanel() { 
 
    JPanel panel = createScreenPanel(); 
 
    JLabel title = 
            createTitle("ADMIN PANEL"); 
 
    JButton addButton = 
            new JButton("Add Candidate"); 
 
    JButton resultsButton = 
            new JButton("View Results"); 
 
    JButton logoutButton = 
            new JButton("Logout"); 
 
    // Font size for buttons 
    Font buttonFont = 
            new Font("Arial", Font.BOLD, 24); 
 
    addButton.setFont(buttonFont); 
    resultsButton.setFont(buttonFont); 
    logoutButton.setFont(buttonFont); 
 
    addButton.addActionListener(e -> 
            showAddCandidate() 
    ); 
 
    resultsButton.addActionListener(e -> 
            showResults() 
    ); 
 
    logoutButton.addActionListener(e -> 
            showMainMenu() 
    ); 
 
    addButton.setPreferredSize(
        new Dimension(500, 65)
);

resultsButton.setPreferredSize(
        new Dimension(500, 65)
);

logoutButton.setPreferredSize(
        new Dimension(500, 65)
);
    addCentered(panel, title, 0);
addCentered(panel, addButton, 1);
addCentered(panel, resultsButton, 2);
addCentered(panel, logoutButton, 3);
    setScreen(panel); 
} 
 
    // ================= ADD CANDIDATE ================= 
 
    private void showAddCandidate() { 
 
        JPanel panel = createScreenPanel(); 
 
        JLabel title = 
                createTitle("ADD CANDIDATE"); 
 
        JLabel electionLabel = 
                new JLabel("Election Type:"); 
 
        String[] electionTypes = { 
                "Governmental", 
                "Organizational", 
                "Educational" 
        }; 
 
        JComboBox<String> electionBox = 
                new JComboBox<>(electionTypes); 
 
        JLabel nameLabel = 
                new JLabel("Candidate Name:"); 
 
        JTextField nameField = 
                new JTextField(15); 
 
        JButton addButton = 
                new JButton("Add Candidate"); 
 
        JButton backButton = 
                new JButton("Back"); 
 
        addButton.addActionListener(e -> { 
 
            String name = 
                    nameField.getText().trim(); 
 
            if (name.isEmpty()) { 
 
                showMessage( 
                        "Please enter candidate name!", 
                        "Input Error" 
                ); 
 
                return; 
            } 
 
            String type = 
                    (String) electionBox.getSelectedItem(); 
 
            elections.get(type).addCandidate(name); 
 
            showMessage( 
                    "Candidate added successfully!", 
                    "Success" 
            ); 
 
            nameField.setText(""); 
        }); 
 
        backButton.addActionListener(e -> 
                showAdminPanel() 
        ); 
 
        electionBox.setPreferredSize(
        new Dimension(500, 60)
);

nameField.setPreferredSize(
        new Dimension(500, 60)
);

addButton.setPreferredSize(
        new Dimension(500, 65)
);

backButton.setPreferredSize(
        new Dimension(500, 65)
);

addCentered(panel, title, 0);
addCentered(panel, electionLabel, 1);
addCentered(panel, electionBox, 2);
addCentered(panel, nameLabel, 3);
addCentered(panel, nameField, 4);
addCentered(panel, addButton, 5);
addCentered(panel, backButton, 6);
        setScreen(panel); 
    } 
 
    // ================= REGISTER VOTER ================= 
 
    private void showRegisterVoter() { 
 
        JPanel panel = createScreenPanel(); 
 
        JLabel title = 
                createTitle("VOTER REGISTRATION"); 
 
        JLabel idLabel = 
                new JLabel("Voter ID:"); 
 
        JTextField idField = 
                new JTextField(15); 
 
        JLabel nameLabel = 
                new JLabel("Voter Name:"); 
 
        JTextField nameField = 
                new JTextField(15); 
 
        JButton registerButton = 
                new JButton("Register"); 
 
        JButton backButton = 
                new JButton("Back"); 
 
        registerButton.addActionListener(e -> { 
 
            String id = 
                    idField.getText().trim(); 
 
            String name = 
                    nameField.getText().trim(); 
 
            if (id.isEmpty() || name.isEmpty()) { 
 
                showMessage( 
                        "Please enter all details!", 
                        "Input Error" 
                ); 
 
                return; 
            } 
 
            if (voters.containsKey(id)) { 
 
                showMessage( 
                        "Voter ID already registered!", 
                        "Registration Error" 
                ); 
 
                return; 
            } 
 
            voters.put( 
                    id, 
                    new Voter(id, name) 
            ); 
 
            showMessage( 
                    "Voter Registered Successfully!", 
                    "Success" 
            ); 
 
            idField.setText(""); 
            nameField.setText(""); 
        }); 
 
        backButton.addActionListener(e -> 
                showMainMenu() 
        ); 
 
        idField.setPreferredSize(
        new Dimension(500, 60)
);

nameField.setPreferredSize(
        new Dimension(500, 60)
);

registerButton.setPreferredSize(
        new Dimension(500, 65)
);

backButton.setPreferredSize(
        new Dimension(500, 65)
);

addCentered(panel, title, 0);
addCentered(panel, idLabel, 1);
addCentered(panel, idField, 2);
addCentered(panel, nameLabel, 3);
addCentered(panel, nameField, 4);
addCentered(panel, registerButton, 5);
addCentered(panel, backButton, 6);
        setScreen(panel); 
    } 
 
    // ================= VOTER PANEL ================= 
 
    private void showVoterPanel() { 
 
        JPanel panel = createScreenPanel(); 
 
        JLabel title = 
                createTitle("VOTER PANEL"); 
 
        JLabel idLabel = 
                new JLabel("Voter ID:"); 
 
        JTextField idField = 
                new JTextField(15); 
 
        JLabel electionLabel = 
                new JLabel("Election Type:"); 
 
        String[] electionTypes = { 
                "Governmental", 
                "Organizational", 
                "Educational" 
        }; 
 
        JComboBox<String> electionBox = 
                new JComboBox<>(electionTypes); 
 
        JLabel candidateLabel = 
                new JLabel("Candidate:"); 
 
        JComboBox<String> candidateBox = 
                new JComboBox<>(); 
 
        JButton loadButton = 
                new JButton("Load Candidates"); 
 
        JButton voteButton = 
                new JButton("Cast Vote"); 
 
        JButton backButton = 
                new JButton("Back"); 
 
        loadButton.addActionListener(e -> { 
 
            candidateBox.removeAllItems(); 
 
            String type = 
                    (String) electionBox.getSelectedItem(); 
 
            Election election = 
                    elections.get(type); 
 
            if (election.candidates.isEmpty()) { 
 
                showMessage( 
                        "No candidates available!", 
                        "Voting" 
                ); 
 
                return; 
            } 
 
            for (Candidate candidate : 
                    election.candidates) { 
 
                candidateBox.addItem( 
                        candidate.name 
                ); 
            } 
        }); 
 
        voteButton.addActionListener(e -> { 
 
            String id = 
                    idField.getText().trim(); 
 
            if (!voters.containsKey(id)) { 
 
                showMessage( 
                        "Voter not registered!", 
                        "Voting Error" 
                ); 
 
                return; 
            } 
 
            if (votedVoters.contains(id)) { 
 
                showMessage( 
                        "You have already voted!", 
                        "Voting Error" 
                ); 
 
                return; 
            } 
 
            if (candidateBox.getSelectedItem() == null) { 
 
                showMessage( 
                        "Please select a candidate!", 
                        "Voting Error" 
                ); 
 
                return; 
            } 
 
            String type = 
                    (String) electionBox.getSelectedItem(); 
 
            String candidateName = 
                    (String) candidateBox.getSelectedItem(); 
 
            Election election = 
                    elections.get(type); 
 
            for (int i = 0; 
                 i < election.candidates.size(); 
                 i++) { 
 
                if (election.candidates 
                        .get(i) 
                        .name 
                        .equals(candidateName)) { 
 
                    election.castVote(i); 
 
                    votedVoters.add(id); 
 
                    showMessage( 
                            "Your vote has been recorded!", 
                            "Success" 
                    ); 
 
                    return; 
                } 
            } 
        }); 
 
        backButton.addActionListener(e -> 
                showMainMenu() 
        ); 
 // ================= COMPONENT SIZES =================

idField.setPreferredSize(
        new Dimension(500, 60)
);

electionBox.setPreferredSize(
        new Dimension(500, 60)
);

candidateBox.setPreferredSize(
        new Dimension(500, 60)
);

loadButton.setPreferredSize(
        new Dimension(500, 65)
);

voteButton.setPreferredSize(
        new Dimension(500, 65)
);

backButton.setPreferredSize(
        new Dimension(500, 65)
);


// ================= CENTER ALL COMPONENTS =================

addCentered(panel, title, 0);
addCentered(panel, idLabel, 1);
addCentered(panel, idField, 2);
addCentered(panel, electionLabel, 3);
addCentered(panel, electionBox, 4);
addCentered(panel, loadButton, 5);
addCentered(panel, candidateLabel, 6);
addCentered(panel, candidateBox, 7);
addCentered(panel, voteButton, 8);
addCentered(panel, backButton, 9);

setScreen(panel);
    }
   // ================= RESULT LOGIN =================

private void showResultLogin() {

    JPanel panel = createScreenPanel();

    JLabel title =
            createTitle("ADMIN VERIFICATION");

    JLabel passwordLabel =
            new JLabel(
                    "Admin Password:",
                    SwingConstants.CENTER
            );

    passwordLabel.setFont(
            new Font("Arial", Font.BOLD, 28)
    );

    JPasswordField passwordField =
            new JPasswordField();

    passwordField.setFont(
            new Font("Arial", Font.PLAIN, 26)
    );

    passwordField.setPreferredSize(
            new Dimension(500, 60)
    );

    passwordField.setMaximumSize(
            new Dimension(500, 60)
    );

    JButton loginButton =
            new JButton("View Results");

    loginButton.setFont(
            new Font("Arial", Font.BOLD, 28)
    );

    loginButton.setPreferredSize(
            new Dimension(500, 65)
    );

    loginButton.setMaximumSize(
            new Dimension(500, 65)
    );

    JButton backButton =
            new JButton("Back");

    backButton.setFont(
            new Font("Arial", Font.BOLD, 28)
    );

    backButton.setPreferredSize(
            new Dimension(500, 65)
    );

    backButton.setMaximumSize(
            new Dimension(500, 65)
    );


    // ===== LOGIN ACTION =====

    loginButton.addActionListener(e -> {

        String password =
                new String(
                        passwordField.getPassword()
                );

        if (password.equals(ADMIN_PASSWORD)) {

            showResults();

        } else {

            showMessage(
                    "Access Denied!",
                    "Error"
            );
        }
    });


    // ===== BACK ACTION =====

    backButton.addActionListener(e ->
            showMainMenu()
    );


    // ===== ADD COMPONENTS =====

  addCentered(panel, title, 0);
addCentered(panel, passwordLabel, 1);
addCentered(panel, passwordField, 2);
addCentered(panel, loginButton, 3);
addCentered(panel, backButton, 4);

    setScreen(panel);
}
 
    // ================= RESULTS ================= 
private void showResults() { 
 
    JPanel panel = new JPanel(new BorderLayout()); 
 
    panel.setBackground(new Color(235, 235, 235)); 
 
    panel.setBorder( 
            BorderFactory.createEmptyBorder( 
                    40, 80, 40, 80 
            ) 
    ); 
 
    // Title 
    JLabel title = new JLabel( 
            "ELECTION RESULTS", 
            SwingConstants.CENTER 
    ); 
 
    title.setFont( 
            new Font("Arial", Font.BOLD, 40) 
    ); 
 
    // Result area 
    JPanel resultPanel = new JPanel(); 
 
    resultPanel.setBackground( 
            new Color(235, 235, 235) 
    ); 
 
    resultPanel.setLayout( 
            new BoxLayout( 
                    resultPanel, 
                    BoxLayout.Y_AXIS 
            ) 
    ); 
 
    for (Election election : elections.values()) { 
 
        JLabel electionTitle = new JLabel( 
                "=== " + election.type + " Election ===" 
        ); 
 
        electionTitle.setFont( 
                new Font("Arial", Font.BOLD, 30) 
        ); 
 
        electionTitle.setAlignmentX( 
                Component.CENTER_ALIGNMENT 
        ); 
 
        resultPanel.add(electionTitle); 
 
        if (election.candidates.isEmpty()) { 
 
            JLabel noCandidate = new JLabel( 
                    "No candidates" 
            ); 
 
            noCandidate.setFont( 
                    new Font("Arial", Font.PLAIN, 26) 
            ); 
 
            noCandidate.setAlignmentX( 
                    Component.CENTER_ALIGNMENT 
            ); 
 
            resultPanel.add(noCandidate); 
 
        } else { 
 
            for (Candidate candidate : 
                    election.candidates) { 
 
                JLabel candidateResult = 
                        new JLabel( 
                                candidate.name 
                                + "  →  " 
                                + candidate.votes 
                                + " votes" 
                        ); 
 
                candidateResult.setFont( 
                        new Font("Arial", Font.BOLD, 28) 
                ); 
 
                candidateResult.setAlignmentX( 
                        Component.CENTER_ALIGNMENT 
                ); 
 
                resultPanel.add(candidateResult); 
            } 
        } 
 
        // Space between elections 
        resultPanel.add( 
                Box.createVerticalStrut(30) 
        ); 
    } 
 
    // Put result panel in the CENTER 
    JPanel centerPanel = new JPanel( 
            new GridBagLayout() 
    ); 
 
    centerPanel.setBackground( 
            new Color(235, 235, 235) 
    ); 
 
    centerPanel.add(resultPanel); 
 
    // Back button 
    JButton backButton = 
            new JButton("Back"); 
 
    backButton.setFont( 
            new Font("Arial", Font.BOLD, 28) 
    ); 
 
    backButton.addActionListener(e -> 
            showMainMenu() 
    ); 
 
    JPanel bottomPanel = 
            new JPanel(); 
 
    bottomPanel.setBackground( 
            new Color(235, 235, 235) 
    ); 
 
    bottomPanel.add(backButton); 
 
    panel.add( 
            title, 
            BorderLayout.NORTH 
    ); 
 
    panel.add( 
            centerPanel, 
            BorderLayout.CENTER 
    ); 
 
    panel.add( 
            bottomPanel, 
            BorderLayout.SOUTH 
    ); 
 
    setScreen(panel); 
} // ================= COMMON METHODS =================

private JPanel createScreenPanel() {

    JPanel panel = new JPanel(new GridBagLayout());

    panel.setBackground(
            new Color(235, 235, 235)
    );

    return panel;
}

private void addCentered(
        JPanel panel,
        Component component,
        int row) {

    GridBagConstraints gbc =
            new GridBagConstraints();

    gbc.gridx = 0;
    gbc.gridy = row;

    gbc.weightx = 1.0;
    gbc.weighty = 0.0;

    gbc.fill = GridBagConstraints.NONE;
    gbc.anchor = GridBagConstraints.CENTER;

    // Small vertical spacing
    gbc.insets =
            new Insets(5, 8, 5, 8);

    panel.add(component, gbc);
}
 
 private JLabel createTitle(String text) { 
 
    JLabel title = 
            new JLabel( 
                    text, 
                    SwingConstants.CENTER 
            ); 
 
    title.setFont( 
            new Font("Arial", Font.BOLD, 40) 
    ); 
 
    return title; 
} 
 
    private void setScreen(JPanel panel) { 
 
        frame.setContentPane(panel); 
 
        frame.revalidate(); 
        frame.repaint(); 
    } 
 
    private void showMessage( 
            String message, 
            String title) { 
 
        JOptionPane.showMessageDialog( 
                frame, 
                message, 
                title, 
                JOptionPane.INFORMATION_MESSAGE 
        ); 
    } 
    
} 