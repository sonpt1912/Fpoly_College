/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import bo.Clock;
import entity.Employee;
import service.impl.EmployeeService;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import bo.DocGhiFile;

/**
 *
 * @author son45
 */
public class Main extends javax.swing.JFrame {

    private int index = 0;
    private DefaultTableModel dtm;
    private List<Employee> listEmployee;
    private EmployeeService service;
    private String path = "assm.txt";
    private DocGhiFile dg;
    private Clock clock;

    /**
     * Creates new form Main
     */
    public Main() {
        initComponents();
        String[] header = {"Mã", "Họ và tên", "Tuổi", "Email", "Lương"};
        tblHienThi.setModel(dtm = new DefaultTableModel());
        dtm.setColumnIdentifiers(header);
        listEmployee = new ArrayList<>();
        dg = new DocGhiFile();
        service = new EmployeeService();
        clock = new Clock();
        service.loadData(listEmployee);
        showData(listEmployee);
        getText(0);
        lblRecord.setText(String.valueOf("Record   " + 1 + " of    " + listEmployee.size()));
        clock.clock(lblClock);
        tblHienThi.setRowSelectionInterval(index, index);
        txtMa.setEnabled(false);
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtMa = new javax.swing.JTextField();
        txtTen = new javax.swing.JTextField();
        txtTuoi = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtLuong = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        btnNew = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnFind = new javax.swing.JButton();
        btnOpen = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHienThi = new javax.swing.JTable();
        btnBack = new javax.swing.JButton();
        btnBachked = new javax.swing.JButton();
        btnNexted = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        lblClock = new javax.swing.JLabel();
        lblRecord = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Sitka Heading", 1, 36)); // NOI18N
        jLabel1.setText("QUẢN LÝ NHÂN VIÊN");

        jLabel2.setText("Mã nhân viên");

        jLabel3.setText("Họ và tên");

        jLabel4.setText("Tuổi");

        jLabel5.setText("Email");

        jLabel6.setText("Lương");

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnNew.setText("New");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnFind.setText("Find");
        btnFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindActionPerformed(evt);
            }
        });

        btnOpen.setText("Open");
        btnOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpenActionPerformed(evt);
            }
        });

        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnOpen, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFind, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNew)
                .addGap(18, 18, 18)
                .addComponent(btnSave)
                .addGap(18, 18, 18)
                .addComponent(btnDelete)
                .addGap(18, 18, 18)
                .addComponent(btnFind)
                .addGap(18, 18, 18)
                .addComponent(btnOpen)
                .addGap(18, 18, 18)
                .addComponent(btnExit)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tblHienThi.setModel(new javax.swing.table.DefaultTableModel(
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
        tblHienThi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHienThiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblHienThi);

        btnBack.setText("|<");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnBachked.setText("<<");
        btnBachked.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBachkedActionPerformed(evt);
            }
        });

        btnNexted.setText(">>");
        btnNexted.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextedActionPerformed(evt);
            }
        });

        btnNext.setText(">|");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        lblClock.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblClock.setForeground(new java.awt.Color(255, 51, 0));
        lblClock.setText("jLabel7");

        lblRecord.setFont(new java.awt.Font("Source Sans Pro Black", 1, 18)); // NOI18N
        lblRecord.setForeground(new java.awt.Color(204, 0, 0));
        lblRecord.setText("jLabel7");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(52, 52, 52)
                                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnBachked, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnNexted, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(lblRecord, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTuoi, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 91, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(151, 151, 151)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblClock, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(lblClock, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtTuoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnBack)
                            .addComponent(btnBachked)
                            .addComponent(btnNexted)
                            .addComponent(btnNext)
                            .addComponent(lblRecord))
                        .addGap(44, 44, 44))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(308, 308, 308))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        // TODO add your handling code here:
        tblHienThi.getSelectedRow();
        txtEmail.setText("");
        txtLuong.setText("");
        txtTen.setText("");
        txtTuoi.setText("");
        txtMa.setText("");
        txtMa.setEnabled(true);
        showData(listEmployee);
    }//GEN-LAST:event_btnNewActionPerformed

    private void tblHienThiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHienThiMouseClicked
        // TODO add your handling code here:
        int index = tblHienThi.getSelectedRow();
        if (index >= 0) {
            txtMa.setEnabled(false);
        }
        getText(index);
    }//GEN-LAST:event_tblHienThiMouseClicked

    private void btnFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindActionPerformed
        // TODO add your handling code here:
        String id = txtMa.getText();
        List<Employee> check = service.findByID(listEmployee, id);
        if (check.size() > 0) {
            JOptionPane.showMessageDialog(rootPane, "tìm kiếm thành công");
            index = checkIndex();
            getText(index);
            showData(check);

        } else {
            JOptionPane.showMessageDialog(rootPane, "tìm kiếm không thành công");
        }


    }//GEN-LAST:event_btnFindActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        String id = txtMa.getText();
        boolean check = service.removeByRow(listEmployee, index);
        if (check) {
            JOptionPane.showMessageDialog(rootPane, "xóa thành công");
            showData(listEmployee);
        } else {
            JOptionPane.showMessageDialog(rootPane, "xóa không thành công");
        }
        btnNewActionPerformed(evt);
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, dg.ghiFile(path, listEmployee));
        System.exit(0);
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        int index = tblHienThi.getSelectedRow();
        boolean checkVali = myValidate();
        int check1 = 0;
        for (int i = 0; i < listEmployee.size(); i++) {
            if (!listEmployee.get(i).getMaNV().equals(txtMa.getText())) {
                check1++;
            }
        }
        if (checkVali) {
            if (index == -1) {
                if (check1 == listEmployee.size()) {
                    listEmployee.add(addList());
                    showData(listEmployee);
                } else {
                    JOptionPane.showMessageDialog(rootPane, "không được nhập trùng id");
                }
            } else {
                boolean check = service.updateByRow(listEmployee, index, addList());
                showData(listEmployee);
            }
        }
        btnNewActionPerformed(evt);

    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpenActionPerformed
        // TODO add your handling code here:

        listEmployee.clear();
        JOptionPane.showMessageDialog(this, dg.docFile(path, listEmployee));
        if (listEmployee.size() > 0) {
            int index = 0;
            getText(index);
            showData(listEmployee);
        } else {
            btnNewActionPerformed(evt);
        }
        lblRecord.setText(String.valueOf("Record   " + 1 + " of    " + listEmployee.size()));
    }//GEN-LAST:event_btnOpenActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        int index = 0;
        getText(index);
        showData(listEmployee);
        lblRecord.setText(String.valueOf("Record   " + 1 + " of    " + listEmployee.size()));
        txtMa.setEnabled(false);
        tblHienThi.setRowSelectionInterval(index, index);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnBachkedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBachkedActionPerformed
        index = checkIndex();
        if (index > 0) {
            index--;
            getText(index);
            txtMa.setEnabled(false);
            lblRecord.setText(String.valueOf("Record   " + (index + 1) + " of    " + listEmployee.size()));
        }
        showData(listEmployee);
        tblHienThi.setRowSelectionInterval(index, index);
    }//GEN-LAST:event_btnBachkedActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        // TODO add your handling code here:
        int index = listEmployee.size() - 1;
        getText(index);
        txtMa.setEnabled(false);
        showData(listEmployee);
        lblRecord.setText(String.valueOf("Record   " + listEmployee.size() + " of    " + listEmployee.size()));
        tblHienThi.setRowSelectionInterval(index, index);
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnNextedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextedActionPerformed
        // TODO add your handling code here:
        index = checkIndex();
        if (index < listEmployee.size() - 1) {
            index++;
            txtMa.setEnabled(false);
            getText(index);
            lblRecord.setText(String.valueOf("Record   " + (index + 1) + " of    " + listEmployee.size()));
        }
        showData(listEmployee);
        tblHienThi.setRowSelectionInterval(index, index);
    }//GEN-LAST:event_btnNextedActionPerformed
    public void showData(List<Employee> list) {
        dtm.setRowCount(0);
        list.forEach(s -> dtm.addRow(s.toDataRow()));
    }

    public void getText(int index) {
        Employee sm = listEmployee.get(index);
        txtEmail.setText(sm.getEmail());
        txtLuong.setText(String.valueOf(sm.getLuong()));
        txtMa.setText(sm.getMaNV());
        txtTen.setText(sm.getName());
        txtTuoi.setText(String.valueOf(sm.getAge()));
    }

    public Employee addList() {
        String id = txtMa.getText();
        String name = txtTen.getText();
        int age = Integer.valueOf(txtTuoi.getText());
        int luong = Integer.valueOf(txtLuong.getText());
        String email = txtEmail.getText();
        Employee em = new Employee(id, name, age, email, luong);
        return em;
    }

    public int checkIndex() {
        for (int i = 0; i < listEmployee.size() - 1; i++) {
            if (listEmployee.get(i).getMaNV().equals(txtMa.getText())) {
                index = i;
            }
        }
        return index;
    }

    public boolean myValidate() {
        boolean check = false;
        if (txtMa.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "không được để mã chống");
        } /*else if (txtMa.getText().equalsIgnoreCase(listEmployee.get(checkSo).getMaNV())) { // check xem mã có trùng với mã trước không
            JOptionPane.showMessageDialog(rootPane, "không được nhập mã trùng nhau");
        }*/ else if (txtTen.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "không được để trống tên");
        } else if (!txtTen.getText().matches("[a-z A-Z]+")) {
            JOptionPane.showMessageDialog(rootPane, "tên phải nhập là chuỗi");
        } else if (!txtTuoi.getText().matches("\\d+")) {
            JOptionPane.showMessageDialog(rootPane, "tuổi phải nhập là số");
        } else if (Integer.valueOf(txtTuoi.getText()) <= 16 || Integer.valueOf(txtTuoi.getText()) >= 55) {
            JOptionPane.showMessageDialog(rootPane, "nhập tuổi trong khoảng 16 - 55");
        } else if (!txtLuong.getText().matches("\\d+")) {
            JOptionPane.showMessageDialog(rootPane, "lương phải nhập là số");
        } else if (Integer.valueOf(txtLuong.getText()) <= 5000000) {
            JOptionPane.showMessageDialog(rootPane, "nhập lương lớn hơn 5 triệu");
        } else if (!txtEmail.getText().matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")) {
            JOptionPane.showMessageDialog(rootPane, "nhập sai định dạng email");
        } else {
            check = true;
        }
        return check;
    }
// chuyển validate sang packet util với điều kiện hàm là static

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBachked;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnFind;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnNexted;
    private javax.swing.JButton btnOpen;
    private javax.swing.JButton btnSave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblClock;
    private javax.swing.JLabel lblRecord;
    private javax.swing.JTable tblHienThi;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtLuong;
    private javax.swing.JTextField txtMa;
    private javax.swing.JTextField txtTen;
    private javax.swing.JTextField txtTuoi;
    // End of variables declaration//GEN-END:variables

}