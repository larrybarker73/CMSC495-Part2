/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videoRentalGUI;

/**
 *
 * @author Larry
 */
public class videoRentalGUI extends javax.swing.JFrame {

    /**
     * Create a GUI FORM
     */
    public videoRentalGUI() {
        initComponents();
    }

    /**
     * 
     * 
     * 
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainTabPanel = new javax.swing.JTabbedPane();
        mainCustomerTab = new javax.swing.JPanel();
        customerSubTabs = new javax.swing.JTabbedPane();
        customerAdd = new javax.swing.JPanel();
        customerDelete = new javax.swing.JPanel();
        customerQuery = new javax.swing.JPanel();
        mainInventoryTab = new javax.swing.JPanel();
        inventorySubTabs = new javax.swing.JTabbedPane();
        movieAdd = new javax.swing.JPanel();
        movieRemove = new javax.swing.JPanel();
        movieQuery = new javax.swing.JPanel();
        mainTransactionsTab = new javax.swing.JPanel();
        checkInButton = new javax.swing.JButton();
        checkOutButton = new javax.swing.JButton();
        customerIDText = new javax.swing.JTextField();
        movieIDText = new javax.swing.JTextField();
        customerIDLabel = new javax.swing.JLabel();
        movieIDLabel = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        menuFile = new javax.swing.JMenu();
        menuEdit = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Video Rental Program Group 5");

        mainTabPanel.setBorder(new javax.swing.border.MatteBorder(null));
        mainTabPanel.setTabPlacement(javax.swing.JTabbedPane.LEFT);

        javax.swing.GroupLayout customerAddLayout = new javax.swing.GroupLayout(customerAdd);
        customerAdd.setLayout(customerAddLayout);
        customerAddLayout.setHorizontalGroup(
            customerAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 551, Short.MAX_VALUE)
        );
        customerAddLayout.setVerticalGroup(
            customerAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 445, Short.MAX_VALUE)
        );

        customerSubTabs.addTab("New Customer", customerAdd);

        javax.swing.GroupLayout customerDeleteLayout = new javax.swing.GroupLayout(customerDelete);
        customerDelete.setLayout(customerDeleteLayout);
        customerDeleteLayout.setHorizontalGroup(
            customerDeleteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 551, Short.MAX_VALUE)
        );
        customerDeleteLayout.setVerticalGroup(
            customerDeleteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 445, Short.MAX_VALUE)
        );

        customerSubTabs.addTab("Remove Customer", customerDelete);

        javax.swing.GroupLayout customerQueryLayout = new javax.swing.GroupLayout(customerQuery);
        customerQuery.setLayout(customerQueryLayout);
        customerQueryLayout.setHorizontalGroup(
            customerQueryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 551, Short.MAX_VALUE)
        );
        customerQueryLayout.setVerticalGroup(
            customerQueryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 445, Short.MAX_VALUE)
        );

        customerSubTabs.addTab("Search Customer", customerQuery);

        javax.swing.GroupLayout mainCustomerTabLayout = new javax.swing.GroupLayout(mainCustomerTab);
        mainCustomerTab.setLayout(mainCustomerTabLayout);
        mainCustomerTabLayout.setHorizontalGroup(
            mainCustomerTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(customerSubTabs, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        mainCustomerTabLayout.setVerticalGroup(
            mainCustomerTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(customerSubTabs, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        mainTabPanel.addTab("Customers", mainCustomerTab);

        javax.swing.GroupLayout movieAddLayout = new javax.swing.GroupLayout(movieAdd);
        movieAdd.setLayout(movieAddLayout);
        movieAddLayout.setHorizontalGroup(
            movieAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 551, Short.MAX_VALUE)
        );
        movieAddLayout.setVerticalGroup(
            movieAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 453, Short.MAX_VALUE)
        );

        inventorySubTabs.addTab("Add Movie", movieAdd);

        javax.swing.GroupLayout movieRemoveLayout = new javax.swing.GroupLayout(movieRemove);
        movieRemove.setLayout(movieRemoveLayout);
        movieRemoveLayout.setHorizontalGroup(
            movieRemoveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 551, Short.MAX_VALUE)
        );
        movieRemoveLayout.setVerticalGroup(
            movieRemoveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 453, Short.MAX_VALUE)
        );

        inventorySubTabs.addTab("Remove Movie", movieRemove);

        javax.swing.GroupLayout movieQueryLayout = new javax.swing.GroupLayout(movieQuery);
        movieQuery.setLayout(movieQueryLayout);
        movieQueryLayout.setHorizontalGroup(
            movieQueryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 551, Short.MAX_VALUE)
        );
        movieQueryLayout.setVerticalGroup(
            movieQueryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 453, Short.MAX_VALUE)
        );

        inventorySubTabs.addTab("Search Movie", movieQuery);

        javax.swing.GroupLayout mainInventoryTabLayout = new javax.swing.GroupLayout(mainInventoryTab);
        mainInventoryTab.setLayout(mainInventoryTabLayout);
        mainInventoryTabLayout.setHorizontalGroup(
            mainInventoryTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(inventorySubTabs)
        );
        mainInventoryTabLayout.setVerticalGroup(
            mainInventoryTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainInventoryTabLayout.createSequentialGroup()
                .addComponent(inventorySubTabs, javax.swing.GroupLayout.PREFERRED_SIZE, 481, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        mainTabPanel.addTab("Inventory", mainInventoryTab);

        checkInButton.setText("Check In");
        checkInButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkInButtonActionPerformed(evt);
            }
        });

        checkOutButton.setText("Check Out");

        customerIDLabel.setText("Customer ID");

        movieIDLabel.setText("Movie ID");

        javax.swing.GroupLayout mainTransactionsTabLayout = new javax.swing.GroupLayout(mainTransactionsTab);
        mainTransactionsTab.setLayout(mainTransactionsTabLayout);
        mainTransactionsTabLayout.setHorizontalGroup(
            mainTransactionsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainTransactionsTabLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(checkInButton, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(checkOutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(mainTransactionsTabLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(mainTransactionsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(movieIDLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(customerIDLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainTransactionsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(customerIDText, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                    .addComponent(movieIDText))
                .addContainerGap(316, Short.MAX_VALUE))
        );
        mainTransactionsTabLayout.setVerticalGroup(
            mainTransactionsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainTransactionsTabLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(mainTransactionsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(customerIDLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(customerIDText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainTransactionsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(movieIDLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(movieIDText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 341, Short.MAX_VALUE)
                .addGroup(mainTransactionsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkOutButton)
                    .addComponent(checkInButton))
                .addContainerGap())
        );

        mainTabPanel.addTab("Transactions", mainTransactionsTab);

        menuFile.setText("File");
        menuBar.add(menuFile);

        menuEdit.setText("Edit");
        menuBar.add(menuEdit);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainTabPanel)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(mainTabPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void checkInButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkInButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkInButtonActionPerformed

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
            java.util.logging.Logger.getLogger(videoRentalGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(videoRentalGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(videoRentalGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(videoRentalGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new videoRentalGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton checkInButton;
    private javax.swing.JButton checkOutButton;
    private javax.swing.JPanel customerAdd;
    private javax.swing.JPanel customerDelete;
    private javax.swing.JLabel customerIDLabel;
    private javax.swing.JTextField customerIDText;
    private javax.swing.JPanel customerQuery;
    private javax.swing.JTabbedPane customerSubTabs;
    private javax.swing.JTabbedPane inventorySubTabs;
    private javax.swing.JPanel mainCustomerTab;
    private javax.swing.JPanel mainInventoryTab;
    private javax.swing.JTabbedPane mainTabPanel;
    private javax.swing.JPanel mainTransactionsTab;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu menuEdit;
    private javax.swing.JMenu menuFile;
    private javax.swing.JPanel movieAdd;
    private javax.swing.JLabel movieIDLabel;
    private javax.swing.JTextField movieIDText;
    private javax.swing.JPanel movieQuery;
    private javax.swing.JPanel movieRemove;
    // End of variables declaration//GEN-END:variables
}
