package plagiarismdetector;

import java.text.DecimalFormat;
import java.util.Formatter;
import static plagiarismdetector.MainPage.AbsoluteName; 
import static plagiarismdetector.MainPage.folderName;

public class PlagiarismResults extends javax.swing.JFrame {
    public static int[] score = new int[150];
    public static int[][] score1 = new int[150][150];
    public static int[] l = new int[150];
    double[][] percentag = new double[150][150];
    int N=0;
    
    
    public PlagiarismResults() {
        initComponents();
    }
    
    public void Check(String[] string,String[] str){
        for(int i=0; i<100; i++){
            if(string[i]!=null){
                N++;
            }
        }
        RabinKarp info = new RabinKarp();
        MianFunctionDitection info1 = new MianFunctionDitection();
        CompleteCodeDitection info2 = new CompleteCodeDitection();
        int temp;
        String MainPattern = "main()";
        for(int T=0; T<N; T++){
            int index = info.RabinKarp(MainPattern,string[T]);
            temp = 0;
            for(int T1=0; T1<N; T1++){
                if(T1 != T){
                    int index1 = info.RabinKarp(MainPattern,string[T1]);
                    temp = info1.CheckMainFuncion(string[T], index, string[T1], index1);
                    score1[T][T1] = temp;
                    //System.out.println(score1[T][T1]);
                }
            } 
        }

        int t=0;
        for(int T=0; T<N; T++){
            int bracket = 0;
            int index = info.RabinKarp(MainPattern,string[T]);
            for(int i=index;i<string[T].length(); i++){
                l[t]++;
                if(string[T].charAt(i) == '{')
                    bracket++;
                else if(string[T].charAt(i) == '}' && bracket !=0){
                    bracket--;
                    if(bracket == 0){
                        string[T] = string[T].replace(string[T].substring(index, i), "");
                        break;
                    }
                }
            }
            t++;
        }
        String[] pat = {"}", "cin", ";}", "{", "cout" };
        
        for(int i=0; i<5; i++)
        {
            for(int j=0; j<N; j++){
                string[j] = string[j].replace(pat[i], "");
            }
        }
        
        int temp2 = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(i!=j){
                    temp2 = info2.CodeDitection(string[i], string[j]);
                    score1[i][j] = score1[i][j] + temp2;
                }
            }
        }
        double[] percentage = new double[150];
        for(int i=0; i<N; i++){
            score[i] = 0;
            percentage[i] = 0;
            for(int j=0; j<N; j++){
                if(i!=j){
                    percentage[i] = percentage[i]+(2*score1[i][j]*100)/(string[i].length()+l[i]+string[j].length()+l[j]);
                    percentag[i][j] = (2*score1[i][j]*100)/(string[i].length()+l[i]+string[j].length()+l[j]);
                }
            }
            percentage[i] = percentage[i]/(N-1);
        }
        DecimalFormat  df = new DecimalFormat("###.###"); 
        for(int i=0; i<N; i++){
            jTextArea1.setText(jTextArea1.getText()+ "\n" +AbsoluteName[i]+"\t\t"+df.format(percentage[i])+"%");
            //jTextArea2.setText(jTextArea2.getText()+ "\n\t" +df.format(percentage[i])+"%");
        }
        
        System.out.println(N);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jOptionPane1 = new javax.swing.JOptionPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Percentage of Plagiarism");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 474, 38));

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Lucida Sans", 0, 18)); // NOI18N
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 780, 380));

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setText("Details");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 10, 107, 38));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Student");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, 100, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Percentage");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 50, 120, 30));

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton2.setText("Create Text file");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 460, 140, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/plagiarismdetector/34249c7b25d4d9b77a25f6838170c73d.png"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 500));
        getContentPane().add(jOptionPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 200, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Detailresult info3 = new Detailresult();
        info3.setVisible(true);
        info3.showresult(percentag,N);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        String fileName = jOptionPane1.showInputDialog("Input Text file name");
        try{
            Formatter fw = new Formatter(folderName+"/"+fileName+".txt");
            String[] details = jTextArea1.getText().split("\\n");
            
            for(int i = 0 ; i< details.length; i++){
                fw.format("%s\r\n",details[i]);
            }
            fw.close();
        }catch(Exception e){
            System.out.println(e);
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PlagiarismResults.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PlagiarismResults.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PlagiarismResults.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PlagiarismResults.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PlagiarismResults().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JOptionPane jOptionPane1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
