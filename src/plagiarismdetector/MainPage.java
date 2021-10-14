
package plagiarismdetector;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;


public class MainPage extends javax.swing.JFrame {

    private final JFileChooser openFile;
    String[] string = new String[150];
    String[] str = new String[150];
    public static String[] AbsoluteName = new String[150];
    public static String absolutePath;
    public static String folderName;
    public MainPage() {
        initComponents();
        
        openFile = new JFileChooser();
        openFile.setMultiSelectionEnabled(true);
        openFile.setCurrentDirectory(new File("C:/Users/hp/Desktop"));
       // openFile.setFileFilter(new FileNameExtensionFilter("Text File", "txt"));
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        browse = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CodeChecker");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        browse.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        browse.setText("Browse");
        browse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseActionPerformed(evt);
            }
        });
        getContentPane().add(browse, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 40, 129, 40));

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, 590, 344));

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setText("Check Plagiarism");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 410, 185, 50));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/plagiarismdetector/34249c7b25d4d9b77a25f6838170c73d.png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void browseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseActionPerformed

        int i=0;
        int selection = openFile.showOpenDialog(this);
        jTextArea1.setEditable(false);
        jTextArea1.setLineWrap(true);
        jTextArea1.setOpaque(false);
            try{
            if(selection == JFileChooser.APPROVE_OPTION){
                
                File [] selectedFile = openFile.getSelectedFiles();
                
                for(File file : selectedFile) { 
                    String a = "";
                    String s = "";
                    absolutePath = file.getAbsolutePath();
                    folderName = file.getParent();
                    AbsoluteName[i] = file.getName();
                    AbsoluteName[i] = AbsoluteName[i].replace(".txt", "");
                    Scanner input = new Scanner(file);
                    while(input.hasNext()){
                        a = input.next();
               
                        if(a.equals("using") || a.equals("namespace") || a.equals("std;") || a.equals("std") || a.equals("<<") ||a.equals(";") || a.equals(">>")) 
                            continue;
                        else if(a.charAt(0) == '#' || a.charAt(0) == '<')
                            continue;
                        else s = s.concat(a);
                        }
                    string[i] = s;
                    str[i] = s;
                    jTextArea1.setText(jTextArea1.getText()+"\n"+absolutePath);
                    i++;
                }
            }
             
            }catch(Exception e){
                jTextArea1.setText("No File choosen");
            }
            /*for(i=0; i<10; i++)
                System.out.println(string[i]);*/
        
    }//GEN-LAST:event_browseActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        PlagiarismResults info = new PlagiarismResults();
        info.setVisible(true);

        info.Check(string, str); 
        
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton browse;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}