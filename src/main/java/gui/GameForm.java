package gui;

import java.util.ArrayList;
import java.util.HashSet;
import javax.swing.JOptionPane;
import model.Data;
import model.Result;

public class GameForm extends javax.swing.JFrame {
    Data data;
    private int score;
    private int number;

    public GameForm(Data data) {
        initComponents();   
        this.data = data;   
        String question = data.getResults().get(0).getQuestion();    
        jLabel1.setText(question);
        this.changeQuestions(0);
    }

    public void changeQuestions(int i){
        Result res = this.data.getResults().get(i);
        ArrayList<String> questions  = new ArrayList<>(res.getIncorrectAnswers());
        questions.add(res.getCorrectAnswer());
        questions.sort(null);
        if(res.getType().equals("multiple")){
            jButton1.setText(questions.get(0));
            jButton2.setText(questions.get(1));
            jButton3.setText(questions.get(2));
            jButton4.setText(questions.get(3));
            jButton3.setVisible(true);
            jButton4.setVisible(true);

        } else{
            jButton1.setText("true");
            jButton2.setText("false");
            jButton3.setVisible(false);
            jButton4.setVisible(false);
        }
        jLabel1.setText(res.getQuestion());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Game", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jButton1.setText("1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("2");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("3");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("4");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 827, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
   
    
    public boolean theEnd(){
        if(this.number == this.data.getResults().size()){
        if(this.score > 0){
            JOptionPane.showMessageDialog(rootPane, "Congratulations, You Won. Your Score: " + this.score, "Result", JOptionPane.INFORMATION_MESSAGE);
        } else
            JOptionPane.showMessageDialog(rootPane, "You Lose. Your Score: " + this.score, "Result", JOptionPane.INFORMATION_MESSAGE);     
            return true;
        }           
        return false;
    }
    
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(jButton1.getText().equals(this.data.getResults().get(this.number).getCorrectAnswer())){
            this.score += 10;
            this.number++;
            JOptionPane.showMessageDialog(rootPane, "This is Correct Answer", "RESULT", JOptionPane.INFORMATION_MESSAGE);
        } else{
            this.score -= 10;
            this.number++;
            JOptionPane.showMessageDialog(rootPane, "This is Incorrect Answer", "RESULT", JOptionPane.INFORMATION_MESSAGE);
        }
        if(this.theEnd())
            return;             
        this.changeQuestions(this.number);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if(jButton2.getText().equals(this.data.getResults().get(this.number).getCorrectAnswer())){
            this.score += 10;
            this.number++;
            JOptionPane.showMessageDialog(rootPane, "This is Correct Answer", "RESULT", JOptionPane.INFORMATION_MESSAGE);            
        } else{
            this.score -= 10;
            this.number++;
            JOptionPane.showMessageDialog(rootPane, "This is Incorrect Answer", "RESULT", JOptionPane.INFORMATION_MESSAGE);            
        }
        if(this.theEnd())
            return;             
        this.changeQuestions(this.number);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if(jButton3.getText().equals(this.data.getResults().get(this.number).getCorrectAnswer())){
            this.score += 10;
            this.number++;
            JOptionPane.showMessageDialog(rootPane, "This is Correct Answer", "RESULT", JOptionPane.INFORMATION_MESSAGE);            
        } else{
            this.score -= 10;
            this.number++;
            JOptionPane.showMessageDialog(rootPane, "This is Incorrect Answer", "RESULT", JOptionPane.INFORMATION_MESSAGE);            
        }
        if(this.theEnd())
            return;             
        this.changeQuestions(this.number);;
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if(jButton4.getText().equals(this.data.getResults().get(this.number).getCorrectAnswer())){
            this.score += 10;
            this.number++;
            JOptionPane.showMessageDialog(rootPane, "This is Correct Answer", "RESULT", JOptionPane.INFORMATION_MESSAGE);            
        } else{
            this.score -= 10;
            this.number++;
            JOptionPane.showMessageDialog(rootPane, "This is Incorrect Answer", "RESULT", JOptionPane.INFORMATION_MESSAGE);            
        }
        if(this.theEnd())
            return;             
        this.changeQuestions(this.number);
    }//GEN-LAST:event_jButton4ActionPerformed


    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
