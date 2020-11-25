
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author surya
 */
public class Department extends javax.swing.JInternalFrame {

    /**
     * Creates new form if1
     */
    Connection x;
    String DeptId;
    public Department(Connection x) {
        initComponents();
        this.x=x;
        showdata();
    }
    void showdata()
    {
    try
    {
    Vector heading=new Vector();
    heading.add("DeptId");
    heading.add("DeptName");
   
String query="select * from department";
PreparedStatement ps=x.prepareStatement(query);
ResultSet rs=ps.executeQuery();
Vector data=new Vector();     
while(rs.next())
{
  
Vector row=new Vector();
row.add(rs.getString("dept_id"));
row.add(rs.getString("dept_name"));
data.add(row);

}
DefaultTableModel d=new DefaultTableModel(data,heading);
jTable1.setModel(d);

}
    catch(Exception e)
    {
    e.printStackTrace();
    }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        InsertButton = new javax.swing.JButton();
        text_DeptName = new javax.swing.JTextField();
        UpdateButton = new javax.swing.JButton();
        DeleteButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jLabel2.setText("DeptName");

        InsertButton.setText("Insert");
        InsertButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InsertButtonActionPerformed(evt);
            }
        });

        UpdateButton.setText("Update");
        UpdateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateButtonActionPerformed(evt);
            }
        });

        DeleteButton.setText("Delete");
        DeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteButtonActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "DeptId", "DeptName"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel3.setText("Department");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(305, 305, 305)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel2)
                        .addGap(43, 43, 43)
                        .addComponent(text_DeptName, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(UpdateButton)
                        .addGap(18, 18, 18)
                        .addComponent(DeleteButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(InsertButton)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 203, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(99, 99, 99))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(text_DeptName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(InsertButton)
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(UpdateButton)
                            .addComponent(DeleteButton))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void InsertButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InsertButtonActionPerformed
        // TODO add your handling code here:
        try
        {
          
        String DeptName=text_DeptName.getText();
        String query="insert into department(dept_name)values(?)";
        PreparedStatement ps=x.prepareStatement(query);
        ps.setString(1,DeptName);
        int chk=ps.executeUpdate();
        JOptionPane.showMessageDialog(this,"data inserted");
        showdata();
        
        }
        
        catch(Exception e)
        {
        e.printStackTrace();
       // JOptionPane.showMessageDialog(this,"data can't be inserted. "+e.getMessage());
        
        }
    }//GEN-LAST:event_InsertButtonActionPerformed

    private void UpdateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateButtonActionPerformed
        // TODO add your handling code here:
         try
        {
           
        String DeptName=text_DeptName.getText();
       String query="update department set dept_name=? where dept_id=?";
        PreparedStatement ps=x.prepareStatement(query);
        ps.setString(1,DeptName);
        ps.setString(2,DeptId);
        int chk=ps.executeUpdate();
        JOptionPane.showMessageDialog(this,"Data modified");
        showdata();
        
        
        
        }
        catch(Exception e)
        {
        e.printStackTrace();
        }
        
    }//GEN-LAST:event_UpdateButtonActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        int index=jTable1.getSelectedRow();
        TableModel tm = jTable1.getModel();
         DeptId= (String)tm.getValueAt(index,0);
        
        String DeptName = (String)tm.getValueAt(index,1);
        text_DeptName.setText(DeptName);
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void DeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteButtonActionPerformed
        // TODO add your handling code here:
        try
        {
       
        String query="delete from department where dept_id=?";
        PreparedStatement ps=x.prepareStatement(query);
        ps.setString(1,DeptId);
        int chk=ps.executeUpdate();
        JOptionPane.showMessageDialog(this,"Data deleted");
        showdata();
        }
        catch(Exception e)
        {
        e.printStackTrace();
        }
    }//GEN-LAST:event_DeleteButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DeleteButton;
    private javax.swing.JButton InsertButton;
    private javax.swing.JButton UpdateButton;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField text_DeptName;
    // End of variables declaration//GEN-END:variables
}