/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import conexion.Conexion;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Usuario
 */
public class panelListarAutos extends javax.swing.JPanel {

    /**
     * Creates new form panelUsuarios
     */
    public panelListarAutos() {
        initComponents();
        crearModeloTabla();
        cargarTablaVehiculos(sqlListarTodo, null);
        personalizarTabla();
        centrarTabla();
        ocultarElementos();
        this.setSize(960, 600);

        txtBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBusquedaKeyPressed(evt);
            }
        });

    }
    DefaultTableModel modeloTabla = new DefaultTableModel();
    String sqlListarTodo = "SELECT dniDueno,patente,tipoVehiculo,ubicacion FROM tb_vehiculo";
    String sqlListarPatente = "SELECT dniDueno,patente,tipoVehiculo,ubicacion FROM tb_vehiculo WHERE patente like ?  ";
    String sqlListarDni = "SELECT dniDueno,patente,tipoVehiculo,ubicacion FROM tb_vehiculo WHERE dniDueno like ?";

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaVehiculos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        cmbBusqueda = new javax.swing.JComboBox<>();
        txtBusqueda = new javax.swing.JTextField();
        separator = new javax.swing.JSeparator();

        jPanel1.setBackground(new java.awt.Color(0, 51, 102));

        tablaVehiculos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tablaVehiculos);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/lupa logo.png"))); // NOI18N
        jLabel1.setText("Buscar autos por un criterio : ");

        cmbBusqueda.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        cmbBusqueda.setForeground(new java.awt.Color(153, 153, 153));
        cmbBusqueda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mostrar Todos", "Mostrar Por Dni", "Mostrar Por Patente" }));
        cmbBusqueda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cmbBusquedaMouseClicked(evt);
            }
        });
        cmbBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbBusquedaActionPerformed(evt);
            }
        });

        txtBusqueda.setBackground(new java.awt.Color(0, 51, 102));
        txtBusqueda.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txtBusqueda.setForeground(new java.awt.Color(255, 255, 255));
        txtBusqueda.setBorder(null);
        txtBusqueda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtBusquedaMouseClicked(evt);
            }
        });
        txtBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBusquedaActionPerformed(evt);
            }
        });
        txtBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBusquedaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBusquedaKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 960, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(separator, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cmbBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(separator, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    private void txtBusquedaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtBusquedaMouseClicked
        txtBusqueda.setText("");
    }//GEN-LAST:event_txtBusquedaMouseClicked

    private void cmbBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbBusquedaActionPerformed
        if (cmbBusqueda.getSelectedIndex() == 1) {
            mostrarElementos();
            txtBusqueda.setText("Ingrese el dni del dueño aqui....");
        } else if (cmbBusqueda.getSelectedIndex() == 2) {
            mostrarElementos();
            txtBusqueda.setText("Ingrese la patente del vehiculo aqui...");

        } else {
            ocultarElementos();
        }
        cargarTablaSegunSeleccion();
    }//GEN-LAST:event_cmbBusquedaActionPerformed

    private void cmbBusquedaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmbBusquedaMouseClicked

    }//GEN-LAST:event_cmbBusquedaMouseClicked

    private void txtBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBusquedaActionPerformed

    }//GEN-LAST:event_txtBusquedaActionPerformed

    private void txtBusquedaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBusquedaKeyPressed
      /*
                String parametro = "%" + txtBusqueda.getText() + "%";
        if (cmbBusqueda.getSelectedIndex() == 1) {
            cargarTablaVehiculos(sqlListarDni, parametro);
        } else if (cmbBusqueda.getSelectedIndex() == 2) {
            cargarTablaVehiculos(sqlListarPatente, parametro);
        }
        */

    }//GEN-LAST:event_txtBusquedaKeyPressed

    private void txtBusquedaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBusquedaKeyReleased
        String parametro = "%" + txtBusqueda.getText() + "%";
        if (cmbBusqueda.getSelectedIndex() == 1) {
            cargarTablaVehiculos(sqlListarDni, parametro);
        } else if (cmbBusqueda.getSelectedIndex() == 2) {
            cargarTablaVehiculos(sqlListarPatente, parametro);
        }
    }//GEN-LAST:event_txtBusquedaKeyReleased

    private void cargarTablaVehiculos(String sql, String parametro) {
        Connection cn = Conexion.conectar();
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            if (parametro != null) {
                ps.setString(1, parametro);
            }
            ResultSet rs = ps.executeQuery();
            limpiarModeloTabla();

            // cargamos la tabla
            while (rs.next()) {
                Object[] fila = new Object[4];
                fila[0] = rs.getString("dniDueno");
                fila[1] = rs.getString("patente");
                fila[2] = rs.getString("tipoVehiculo");
                fila[3] = rs.getString("ubicacion");

                modeloTabla.addRow(fila);
            }
            ps.close();
            rs.close();

        } catch (SQLException e) {
            System.out.println("Error al cargar la tabla de vehiculos. Error " + e);
        }
    }

    private void cargarTablaSegunSeleccion() {
        if (cmbBusqueda.getSelectedIndex() == 1) {
            cargarTablaVehiculos(sqlListarDni, txtBusqueda.getText());
        } else if (cmbBusqueda.getSelectedIndex() == 2) {
            cargarTablaVehiculos(sqlListarPatente, txtBusqueda.getText());
        } else {
            // Si no es una búsqueda específica, cargar todos los vehículos
            cargarTablaVehiculos(sqlListarTodo, null);
        }
    }

    private void limpiarModeloTabla() {
        modeloTabla.setRowCount(0); // Elimina todas las filas del modelo de la tabla
    }

    private void personalizarTabla() {
        Font font = new Font("Ebrima", Font.BOLD, 16);
        tablaVehiculos.setFont(font);
        tablaVehiculos.setModel(modeloTabla);
        tablaVehiculos.setDefaultEditor(Object.class, null); // que no sea editable
        tablaVehiculos.setBackground(Color.CYAN);
    }

    private void crearModeloTabla() {
        modeloTabla.addColumn("Dni Dueño");
        modeloTabla.addColumn("Patente");
        modeloTabla.addColumn("Tipo de Vehiculo");
        modeloTabla.addColumn("Ubicacion");
    }

    private void centrarTabla() {
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < tablaVehiculos.getColumnCount(); i++) {
            tablaVehiculos.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
    }

    private void ocultarElementos() {
        txtBusqueda.setVisible(false);
        separator.setVisible(false);
    }

    private void mostrarElementos() {
        txtBusqueda.setVisible(true);
        separator.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmbBusqueda;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator separator;
    private javax.swing.JTable tablaVehiculos;
    private javax.swing.JTextField txtBusqueda;
    // End of variables declaration//GEN-END:variables
}
