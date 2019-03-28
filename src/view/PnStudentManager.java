/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.StudentController;

/**
 *
 * @author qphan
 */
public class PnStudentManager extends javax.swing.JPanel {

    /**
     * Creates new form PnStudentManager
     */
    public PnStudentManager() {
        initComponents();

        final StudentController studentController = new StudentController(tbStudent, tfSearch, btExport, btAdd);
        studentController.loadData();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnStudentTop = new javax.swing.JPanel();
        tfSearch = new javax.swing.JTextField();
        btAdd = new javax.swing.JButton();
        btExport = new javax.swing.JButton();
        pnStudentView = new javax.swing.JPanel();
        scrollStudent = new javax.swing.JScrollPane();
        tbStudent = new javax.swing.JTable();

        setLayout(new java.awt.BorderLayout());

        pnStudentTop.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tfSearch.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tfSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfSearchActionPerformed(evt);
            }
        });

        btAdd.setBackground(new java.awt.Color(76, 175, 80));
        btAdd.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btAdd.setForeground(new java.awt.Color(255, 255, 255));
        btAdd.setText("+ Thêm mới");

        btExport.setBackground(new java.awt.Color(76, 175, 80));
        btExport.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btExport.setForeground(new java.awt.Color(255, 255, 255));
        btExport.setText("Xuất báo cáo");

        javax.swing.GroupLayout pnStudentTopLayout = new javax.swing.GroupLayout(pnStudentTop);
        pnStudentTop.setLayout(pnStudentTopLayout);
        pnStudentTopLayout.setHorizontalGroup(
            pnStudentTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnStudentTopLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 216, Short.MAX_VALUE)
                .addComponent(btExport, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btAdd)
                .addContainerGap())
        );
        pnStudentTopLayout.setVerticalGroup(
            pnStudentTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnStudentTopLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnStudentTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btExport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        add(pnStudentTop, java.awt.BorderLayout.PAGE_START);

        pnStudentView.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 1, 1, 1));
        pnStudentView.setLayout(new java.awt.BorderLayout());

        tbStudent.setAutoCreateRowSorter(true);
        tbStudent.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbStudent.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        scrollStudent.setViewportView(tbStudent);

        pnStudentView.add(scrollStudent, java.awt.BorderLayout.CENTER);

        add(pnStudentView, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void tfSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfSearchActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAdd;
    private javax.swing.JButton btExport;
    private javax.swing.JPanel pnStudentTop;
    private javax.swing.JPanel pnStudentView;
    private javax.swing.JScrollPane scrollStudent;
    private javax.swing.JTable tbStudent;
    private javax.swing.JTextField tfSearch;
    // End of variables declaration//GEN-END:variables
}