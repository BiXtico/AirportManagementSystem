/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AMS;

import AMS.Controllers.PassengerController;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author mahmo
 */
public class MainPassengerGUI extends javax.swing.JFrame {

    /**
     * Creates new form MainPassengerGUI
     */
    public MainPassengerGUI() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        Username = new javax.swing.JLabel();
        BookFlightButton = new javax.swing.JButton();
        CancelBookedFlightButton = new javax.swing.JButton();
        EditBookedFlightButton = new javax.swing.JButton();
        ViewBookedFlightButton = new javax.swing.JButton();
        ReviewFlightButton = new javax.swing.JButton();
        SearchField = new javax.swing.JTextField();
        SearchButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        SearchShowArea = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        SearchAirlineRadio = new javax.swing.JRadioButton();
        SearchDestinationRadio = new javax.swing.JRadioButton();
        saveAndExitButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Welcome to AMS, ");

        Username.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Username.setText("Error Loading User Name");

        BookFlightButton.setText("Book Flight");
        BookFlightButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BookFlightButtonActionPerformed(evt);
            }
        });

        CancelBookedFlightButton.setText("Cancel Booked Flight");
        CancelBookedFlightButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelBookedFlightButtonActionPerformed(evt);
            }
        });

        EditBookedFlightButton.setText("Edit Booked Flight");
        EditBookedFlightButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditBookedFlightButtonActionPerformed(evt);
            }
        });

        ViewBookedFlightButton.setText("View Booked Flight");
        ViewBookedFlightButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ViewBookedFlightButtonActionPerformed(evt);
            }
        });

        ReviewFlightButton.setText("Review Flight");

        SearchButton.setText("Search");
        SearchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchButtonActionPerformed(evt);
            }
        });

        SearchShowArea.setColumns(20);
        SearchShowArea.setRows(5);
        jScrollPane1.setViewportView(SearchShowArea);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Search Flights");

        SearchAirlineRadio.setText("Search Airline");

        SearchDestinationRadio.setText("Search Destination");

        saveAndExitButton.setText("Save and Exit");
        saveAndExitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveAndExitButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Username))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(CancelBookedFlightButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(BookFlightButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(EditBookedFlightButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addComponent(ViewBookedFlightButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(ReviewFlightButton, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(114, 114, 114)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel3)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(SearchField, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(SearchButton))
                                    .addComponent(jScrollPane1)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(SearchAirlineRadio)
                                        .addGap(18, 18, 18)
                                        .addComponent(SearchDestinationRadio)))))
                        .addGap(0, 66, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(saveAndExitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(Username, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SearchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SearchButton))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SearchAirlineRadio)
                    .addComponent(SearchDestinationRadio))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(BookFlightButton)
                        .addGap(18, 18, 18)
                        .addComponent(CancelBookedFlightButton)
                        .addGap(18, 18, 18)
                        .addComponent(EditBookedFlightButton)
                        .addGap(18, 18, 18)
                        .addComponent(ViewBookedFlightButton)
                        .addGap(18, 18, 18)
                        .addComponent(ReviewFlightButton))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(saveAndExitButton)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SearchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchButtonActionPerformed
        String searchMaterial = SearchField.getText();
        if (SearchDestinationRadio.isSelected() && SearchAirlineRadio.isSelected()) {
            JOptionPane.showMessageDialog(null, "Alert: please pick one way to search", "Message",
                    JOptionPane.INFORMATION_MESSAGE);
        } else if (SearchDestinationRadio.isSelected()) {
            try {
                SearchShowArea.setText(PassengerController.searchMethod(searchMaterial, 1));
            } catch (RemoteException ex) {
                Logger.getLogger(MainPassengerGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (SearchAirlineRadio.isSelected()) {
            try {
                SearchShowArea.setText(PassengerController.searchMethod(searchMaterial, 2));
            } catch (RemoteException ex) {
                Logger.getLogger(MainPassengerGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_SearchButtonActionPerformed

    private void EditBookedFlightButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditBookedFlightButtonActionPerformed
        PassengerController.editBookedFlight_();
        this.dispose();
    }//GEN-LAST:event_EditBookedFlightButtonActionPerformed

    private void saveAndExitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveAndExitButtonActionPerformed
        PassengerController.SaveAndExit_();
        this.dispose();
    }//GEN-LAST:event_saveAndExitButtonActionPerformed

    private void BookFlightButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BookFlightButtonActionPerformed
        PassengerController.bookFlight_();
        this.dispose();
    }//GEN-LAST:event_BookFlightButtonActionPerformed

    private void CancelBookedFlightButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelBookedFlightButtonActionPerformed
        PassengerController.cancelBookedFlight_();
        this.dispose();
    }//GEN-LAST:event_CancelBookedFlightButtonActionPerformed

    private void ViewBookedFlightButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ViewBookedFlightButtonActionPerformed
        PassengerController.viewFlights_();
        this.dispose();
    }//GEN-LAST:event_ViewBookedFlightButtonActionPerformed

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
            java.util.logging.Logger.getLogger(MainPassengerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainPassengerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainPassengerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainPassengerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainPassengerGUI().setVisible(true);
            }
        });
    }

    public JLabel getUsername() {
        return Username;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BookFlightButton;
    private javax.swing.JButton CancelBookedFlightButton;
    private javax.swing.JButton EditBookedFlightButton;
    private javax.swing.JButton ReviewFlightButton;
    private javax.swing.JRadioButton SearchAirlineRadio;
    private javax.swing.JButton SearchButton;
    private javax.swing.JRadioButton SearchDestinationRadio;
    private javax.swing.JTextField SearchField;
    private javax.swing.JTextArea SearchShowArea;
    private javax.swing.JLabel Username;
    private javax.swing.JButton ViewBookedFlightButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton saveAndExitButton;
    // End of variables declaration//GEN-END:variables
}
