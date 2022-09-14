
package view;

import controller.ServicioController;


public class frmPrincipal extends javax.swing.JFrame {
    
    private ServicioController controller;
    
    public frmPrincipal() {
        initComponents();
        setLocationRelativeTo(null);
        controller = new ServicioController();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnReportes = new javax.swing.JButton();
        btnReportes1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnAltaServicio = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnReportes.setBackground(new java.awt.Color(0, 51, 255));
        btnReportes.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        btnReportes.setForeground(new java.awt.Color(255, 255, 255));
        btnReportes.setText("Reportes");
        btnReportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportesActionPerformed(evt);
            }
        });

        btnReportes1.setBackground(new java.awt.Color(255, 51, 51));
        btnReportes1.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        btnReportes1.setForeground(new java.awt.Color(255, 255, 255));
        btnReportes1.setText("SALIR");
        btnReportes1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportes1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("HOTEL HILTON");

        btnAltaServicio.setBackground(new java.awt.Color(0, 51, 255));
        btnAltaServicio.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        btnAltaServicio.setForeground(new java.awt.Color(255, 255, 255));
        btnAltaServicio.setText("Alta Servicio");
        btnAltaServicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAltaServicioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(141, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnAltaServicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnReportes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnReportes1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel1)))
                .addGap(144, 144, 144))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(btnAltaServicio)
                .addGap(50, 50, 50)
                .addComponent(btnReportes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addComponent(btnReportes1)
                .addGap(50, 50, 50))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnReportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportesActionPerformed
        frmReportes fR = new frmReportes(controller);
        fR.setVisible(true);
    }//GEN-LAST:event_btnReportesActionPerformed

    private void btnReportes1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportes1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnReportes1ActionPerformed

    private void btnAltaServicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAltaServicioActionPerformed
        frmAlta fC = new frmAlta(controller);
        fC.setVisible(true);
    }//GEN-LAST:event_btnAltaServicioActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAltaServicio;
    private javax.swing.JButton btnReportes;
    private javax.swing.JButton btnReportes1;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
