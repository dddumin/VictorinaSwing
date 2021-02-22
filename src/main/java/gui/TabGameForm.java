package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.prefs.BackingStoreException;
import java.util.prefs.InvalidPreferencesFormatException;
import java.util.prefs.Preferences;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import model.Data;

public class TabGameForm extends javax.swing.JFrame {
    private Data data;    

    public TabGameForm(Data data) throws InvalidPreferencesFormatException, IOException {
        initComponents();        
        this.data = data;
        try{
            Preferences.importPreferences(new FileInputStream("Statistics.xml"));        
        } catch (FileNotFoundException ex){            
        }
        LinkedHashMap<JPanel, ButtonGroup> map = new LinkedHashMap<>();
        for (int i = 0; i < this.data.getResults().size(); i++) {
            JPanel jPanel = new JPanel();
            jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.Y_AXIS));
            jPanel.add(new JLabel(this.data.getResults().get(i).getQuestion()));
            jTabbedPane1.addTab("Question " + (i + 1), jPanel);
            int n = 4;
            if(this.data.getResults().get(i).getType().equals("boolean"))
                n = 2;
            ArrayList<String> answers = new ArrayList<>(this.data.getResults().get(i).getIncorrectAnswers());
            answers.add(this.data.getResults().get(i).getCorrectAnswer());
            answers.sort(null);
            ButtonGroup buttonGroup = new ButtonGroup();
            for (int j = 0; j < n; j++) {
                JRadioButton radioButton = new JRadioButton(answers.get(j)); 
                radioButton.setActionCommand(radioButton.getText());
                jPanel.add(radioButton);
                buttonGroup.add(radioButton);                
            } 
            map.put(jPanel, buttonGroup);
        }
        JPanel jPanel = new JPanel();       
        jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.Y_AXIS));
        JButton button = new JButton("CHECK");   
        jPanel.add(button); 
        ArrayList<JLabel> jLabels = new ArrayList<>();
        JLabel jLabel = new JLabel();
        jPanel.add(jLabel);
        for (int i = 0; i < map.size(); i++) { 
            jLabels.add(new JLabel());
            jPanel.add(jLabels.get(i));
        }
        JLabel jLabel1 = new JLabel();
        JLabel jLabel2 = new JLabel();
        jPanel.add(jLabel1);
        jPanel.add(jLabel2);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { 
                int a = 0;
                int correctAnswer = 0;
                int inCorrectAnswer = 0;
                ArrayList<String> answers = new ArrayList<>();
                for (Map.Entry<JPanel, ButtonGroup> entry : map.entrySet()) {
                    if(entry.getValue().getSelection() == null){
                        JOptionPane.showMessageDialog(rootPane, "Answer All Questions!!!", "ERROR", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    if(entry.getValue().getSelection().getActionCommand().equals(data.getResults().get(a).getCorrectAnswer())){
                        answers.add("+");
                        correctAnswer += 1;
                    }
                    else{
                        answers.add("-");
                        inCorrectAnswer += 1;
                    }
                    a++;
                }
                String stat = "Statistics: " + Preferences.userRoot().get("number", "def") + "\r\n";
                for (int i = 0; i < jLabels.size(); i++) {
                    if(Preferences.userRoot().get("show", "defaultValue").equals("yes") && answers.get(i).equals("-")){
                        jLabels.get(i).setText("Question " + (i+1) + ": " + answers.get(i) + " (" + data.getResults().get(i).getCorrectAnswer() + ")");
                        stat += "Question " + (i+1) + ": " + answers.get(i) + " (" + data.getResults().get(i).getCorrectAnswer() + ") \r\n";
                    } else {
                        jLabels.get(i).setText("Question " + (i+1) + ": " + answers.get(i));
                        stat += "Question " + (i+1) + ": " + answers.get(i) + "\r\n";
                    }                                
                }
                jLabel.setText("Statistics: " + Preferences.userRoot().get("number", "def"));
                Preferences.userRoot().put("number", (Integer.parseInt(Preferences.userRoot().get("number", "def"))+ 1) + "");               
                try {
                    Preferences.userRoot().exportSubtree(new FileOutputStream("Statistics.xml"));
                } catch (IOException | BackingStoreException ex) {
                    Logger.getLogger(TabGameForm.class.getName()).log(Level.SEVERE, null, ex);
                }
                jLabel1.setText("Count Correct/Incorrect Answer: " + correctAnswer + "/" + inCorrectAnswer);
                stat += "Count Correct/Incorrect Answer: " + correctAnswer + "/" + inCorrectAnswer + "\r\n";
                jLabel2.setText("Percent Correct Answer: " + correctAnswer*100/(correctAnswer + inCorrectAnswer) + "%"); 
                stat += "Percent Correct Answer: " + correctAnswer*100/(correctAnswer + inCorrectAnswer) + "%" + "\r\n";
                stat += "------------------------------------------- \r\n"; 
                jPanel.updateUI();
                try(BufferedWriter writer = new BufferedWriter(new FileWriter("Statistics.txt", true))){
                    writer.write(stat);
                } catch (IOException ex) {
                    Logger.getLogger(TabGameForm.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        });
        jTabbedPane1.addTab("CHECK", jPanel);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        jPanel3 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 650, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

        
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}
