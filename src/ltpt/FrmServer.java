/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ltpt;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class FrmServer extends javax.swing.JFrame {

    /**
     * Creates new form FrmServer
     */
    public FrmServer() {
        initComponents();
    }
    
    
    
    
    public class TuyenNhan extends Thread{
        
        public int tinhGiaithua(int n) {
            if (n > 0) {
                return n * tinhGiaithua(n - 1);
            } else {
                return 1;
            }
        }
        public void run(){
            while (true) {                
                try {
                    String st = gn.nhan();
                    String[] ds = st.split("[:]");
                    String ip = ds[0];
                    String cp = ds[1];
                    if(cp.equals("/tm")){
                        String sv = InetAddress.getLocalHost().getHostName();
                        gn.Gui(sv, ip, 1262);
                    }
                    else if(cp.equals("note")) {
                        Runtime.getRuntime().equals("notepad");
                    } 
                    else if(cp.equals("/ht")) {
                        gn.Gui("Truong Viet Luy", ip, 1262);
                    }
                    else if(cp.contains("/+")) {
                        int d=0;
                        int l = cp.length();
                        for(int i=0;i<l;i++) {
                            if(cp.charAt(i) == ';') {
                                d++;
                            }
                        }
                        int tong =0;
                        String[] ds1 = cp.split("[;]");
                        for(int i=1;i<=d;i++) {
                            tong+= Integer.parseInt(ds1[i]);
                        }
                        
                        int max = Integer.parseInt(ds1[1]);
                        for(int i=2;i<=d;i++) {
                            int t = Integer.parseInt(ds1[i]);
                            if(max<t) {
                                max=t;
                            }
                        }
                        int min = Integer.parseInt(ds1[1]);
                        for(int i=2;i<=d;i++) {
                            int t = Integer.parseInt(ds1[i]);
                            if(min>t) {
                                min=t;
                            }
                        }
                        gn.Gui("Tong: "+ tong +" || So lon nhat: "+ max+ " || So be nhat: "+min + " || So chu so client gui len: "+d, ip, 1262);                  
                    }
                    else if(cp.contains("/ck")) {
                        String[] ds2 = cp.split("[;]");
                        int k = Integer.parseInt(ds2[1]);
                        int n = Integer.parseInt(ds2[2]);
                        int ck = tinhGiaithua(n) / (tinhGiaithua(k) * tinhGiaithua(n-k));
                        gn.Gui("To hop chap k cua n: "+ck, ip, 1262);
                    }
                    list1.add(st);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
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

        list1 = new java.awt.List();
        txtgui = new java.awt.TextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Server");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        list1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                list1ActionPerformed(evt);
            }
        });

        txtgui.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtguiActionPerformed(evt);
            }
        });
        txtgui.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtguiKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(list1, javax.swing.GroupLayout.DEFAULT_SIZE, 454, Short.MAX_VALUE)
                    .addComponent(txtgui, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(71, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(list1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(txtgui, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    GuiNhan gn=new GuiNhan();
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
                // TODO add your handling code here:
        try {
            gn.MoCong(1260);
            TuyenNhan td= new TuyenNhan();
            td.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_formWindowOpened

    private void list1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_list1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_list1ActionPerformed

    private void txtguiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtguiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtguiActionPerformed

    GuiNhan gn1 = new GuiNhan();
    private void txtguiKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtguiKeyPressed
        try {
            if(evt.getKeyCode()==10){
            String data=InetAddress.getLocalHost().getHostAddress()+":";
            data=data+txtgui.getText();
            gn1.Gui(data, "127.0.0.1", 1262);
        }
        } catch (Exception e) {
            e.printStackTrace();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_txtguiKeyPressed

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
            java.util.logging.Logger.getLogger(FrmServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmServer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.List list1;
    private java.awt.TextField txtgui;
    // End of variables declaration//GEN-END:variables
}