
package vista;

import controlador.Controlador;


public class frmPrincipal extends javax.swing.JFrame {

    private Controlador controlador;
    
    public frmPrincipal() {
        initComponents();
        controlador = new Controlador();
        this.setLocationRelativeTo(null);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnReportes1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnCargar = new javax.swing.JButton();
        btnReportes2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnReportes1.setBackground(new java.awt.Color(255, 51, 51));
        btnReportes1.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        btnReportes1.setForeground(new java.awt.Color(255, 255, 255));
        btnReportes1.setText("SALIR");
        btnReportes1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportes1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        jLabel1.setText("Hospital");

        btnCargar.setBackground(new java.awt.Color(0, 51, 255));
        btnCargar.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        btnCargar.setForeground(new java.awt.Color(255, 255, 255));
        btnCargar.setText("Alta Visita");
        btnCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarActionPerformed(evt);
            }
        });

        btnReportes2.setBackground(new java.awt.Color(0, 51, 255));
        btnReportes2.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        btnReportes2.setForeground(new java.awt.Color(255, 255, 255));
        btnReportes2.setText("Reportes");
        btnReportes2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportes2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnCargar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btnReportes2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnReportes1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(178, 178, 178)
                        .addComponent(jLabel1)))
                .addContainerGap(146, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jLabel1)
                .addGap(43, 43, 43)
                .addComponent(btnCargar)
                .addGap(42, 42, 42)
                .addComponent(btnReportes2)
                .addGap(42, 42, 42)
                .addComponent(btnReportes1)
                .addContainerGap(80, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnReportes1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportes1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnReportes1ActionPerformed

    private void btnCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarActionPerformed
        frmAlta fC = new frmAlta(controlador);
        fC.setVisible(true);
    }//GEN-LAST:event_btnCargarActionPerformed

    private void btnReportes2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportes2ActionPerformed
        frmReportes listado = new frmReportes();
        listado.setVisible(true);
    }//GEN-LAST:event_btnReportes2ActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCargar;
    private javax.swing.JButton btnReportes1;
    private javax.swing.JButton btnReportes2;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
