package vista;

import controlador.Controlador;
import dto.dtoVisitas;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Empleado;
import modelo.Paciente;
import modelo.Visita;

public class frmAlta extends javax.swing.JFrame {

    private Controlador controlador;

    public frmAlta(Controlador controlador) {
        initComponents();
        this.controlador = controlador;
        cargarComboPacientes();
        cargarComboEmpleados();
        cboPaciente.setSelectedIndex(-1);
        cboRecepcionista.setSelectedIndex(-1);
        setLocationRelativeTo(null);
        loadInfo();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCancelar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnAceptar = new javax.swing.JButton();
        txtNombre = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tVisitas = new javax.swing.JTable();
        cboRecepcionista = new javax.swing.JComboBox<>();
        cboPaciente = new javax.swing.JComboBox<>();
        txtDuracion = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnCancelar.setBackground(new java.awt.Color(255, 153, 0));
        btnCancelar.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setText("Cancelar");
        btnCancelar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnSalir.setBackground(new java.awt.Color(255, 51, 51));
        btnSalir.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        btnSalir.setForeground(new java.awt.Color(255, 255, 255));
        btnSalir.setText("Salir");
        btnSalir.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnAceptar.setBackground(java.awt.Color.green);
        btnAceptar.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        btnAceptar.setForeground(new java.awt.Color(255, 255, 255));
        btnAceptar.setText("Aceptar");
        btnAceptar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        txtNombre.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jLabel1.setText("Paciente:");

        jLabel2.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jLabel2.setText("Recepcionista:");

        jLabel3.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jLabel3.setText("Nombre:");

        jLabel4.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jLabel4.setText("Duracion:");

        tVisitas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tVisitas);

        cboRecepcionista.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N

        cboPaciente.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N

        txtDuracion.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        txtDuracion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDuracionKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(84, 84, 84)
                                .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(21, 21, 21)
                                            .addComponent(jLabel2))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addContainerGap()
                                            .addComponent(jLabel1)))
                                    .addComponent(jLabel4))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cboPaciente, 0, 193, Short.MAX_VALUE)
                                    .addComponent(cboRecepcionista, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtNombre)
                                    .addComponent(txtDuracion))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(124, 124, 124)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(74, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(cboPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(cboRecepcionista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtDuracion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAceptar)
                            .addComponent(btnCancelar))
                        .addGap(18, 18, 18)
                        .addComponent(btnSalir)
                        .addGap(71, 71, 71))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cargarComboPacientes() {

        ArrayList<Paciente> lista = controlador.obtenerPacientes();

        for (Paciente p : lista) {
            cboPaciente.addItem(p);
        }

    }

    private void cargarComboEmpleados() {

        ArrayList<Empleado> lista = controlador.obtenerEmpleados();

        for (Empleado e : lista) {
            cboRecepcionista.addItem(e);
        }

    }

    private void loadInfo() {
        DefaultTableModel model = new DefaultTableModel();
        ArrayList<dtoVisitas> todos = controlador.obtenerVisitas();
        model.setColumnIdentifiers(new String[]{"Nombre Paciente", "Nombre Visita", "Recep", "Duracion"});
        for (dtoVisitas v : todos) {
            model.addRow(v.toArray());
        }

        tVisitas.setModel(model);

    }
    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        int respuesta = 0;
        if (txtDuracion.getText() != "" || txtNombre.getText() != "" || cboPaciente.getSelectedIndex() > 1 || cboRecepcionista.getSelectedIndex() > 1) {
            respuesta = JOptionPane.showConfirmDialog(this, "Desea borrar los datos ingresados?", "Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (respuesta == JOptionPane.YES_OPTION) {
                limpiarCampos();
            }
            else if(respuesta == JOptionPane.NO_OPTION){
            return;
            }
        }
        limpiarCampos();

    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed

        if (validarCampos()) {
            try {
                Paciente p = (Paciente) cboPaciente.getSelectedItem();
                Empleado e = (Empleado) cboRecepcionista.getSelectedItem();
                String nombre = txtNombre.getText();
                int duracion = Integer.parseInt(txtDuracion.getText());
                Visita nueva = new Visita(p, e, nombre, duracion);
                controlador.agregarVisita(nueva);
                JOptionPane.showMessageDialog(this, "Visita registrada con éxito!", "Success", JOptionPane.INFORMATION_MESSAGE);
                loadInfo();
                limpiarCampos();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.toString(), "Catch", JOptionPane.ERROR_MESSAGE);
            }
        }


    }//GEN-LAST:event_btnAceptarActionPerformed

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
          //VALIDACION SOLO LETRAS
        char c = evt.getKeyChar();

        if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z')) {
            evt.consume();
        }
    }//GEN-LAST:event_txtNombreKeyTyped

    private void txtDuracionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDuracionKeyTyped
                //VALIDACION SOLO NUMEROS Y PUNTO DECIMAL
        char c = evt.getKeyChar();

        if (((c < '0') || (c > '9'))
                && (c != KeyEvent.VK_BACK_SPACE)
                && (c != '.' || txtDuracion.getText().contains("."))) {
           evt.consume();
        }
    }//GEN-LAST:event_txtDuracionKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<Object> cboPaciente;
    private javax.swing.JComboBox<Object> cboRecepcionista;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tVisitas;
    private javax.swing.JTextField txtDuracion;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables

    private void limpiarCampos() {
        txtDuracion.setText("");
        txtNombre.setText("");
        cboPaciente.setSelectedIndex(-1);
        cboRecepcionista.setSelectedIndex(-1);
    }

    private boolean validarCampos() {
        boolean bandera = true;
        if (cboPaciente.getSelectedIndex() < 1) {
            JOptionPane.showMessageDialog(this, "Debe Seleccionar un paciente...", "Validación", JOptionPane.ERROR_MESSAGE);
            cboPaciente.requestFocus();
            bandera = false;
            return bandera;
        }
        if (cboRecepcionista.getSelectedIndex() < 1) {
            JOptionPane.showMessageDialog(this, "Debe Seleccionar un recepcionista...", "Validación", JOptionPane.ERROR_MESSAGE);
            cboPaciente.requestFocus();
            bandera = false;
            return bandera;
        }
        if (txtNombre.getText() == "") {
            JOptionPane.showMessageDialog(this, "Debe Ingresar un nombre...", "Validación", JOptionPane.ERROR_MESSAGE);
            cboPaciente.requestFocus();
            bandera = false;
            return bandera;
        }
        if (txtDuracion.getText() == "") {
            JOptionPane.showMessageDialog(this, "Debe Ingresar una duración...", "Validación", JOptionPane.ERROR_MESSAGE);
            cboPaciente.requestFocus();
            bandera = false;
            return bandera;
        }
        return bandera;
    }
}
