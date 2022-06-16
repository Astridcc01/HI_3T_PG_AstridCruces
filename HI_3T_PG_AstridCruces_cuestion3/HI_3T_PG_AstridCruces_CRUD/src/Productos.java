import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.*;

public class Productos {
    private JPanel Main;
    private JTextField txtId;
    private JTextField txtNombre;
    private JTextField txtFecha;
    private JTextField txtPrecio;
    private JCheckBox checkBoxDisponible;
    private JTable table1;
    private JButton añadirButton;
    private JButton eliminarButton;
    private JButton actualizarButton;
    private JButton buscarButton;
    private JSpinner spinnerUnidades;
    private JSpinner spinnerProducto;
    private JScrollPane table_1;
    private JTextField txtBuscar;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Productos");
        frame.setContentPane(new Productos().Main);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }

    Connection con;
    PreparedStatement pst;

    public void connect(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/hi_3t_pg_astridcruces", "root", "" );
            System.out.println("Conexión realizada");
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
        txtFecha.setText("dd/mm/aaaa");
    }


    void table_load(){
        try
        {
            pst = con.prepareStatement("select * from productos");
            ResultSet rs = pst.executeQuery();
            table1.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }


    public Productos() {
        connect();
        table_load();

        añadirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int idProducto, unidades;
                String nombre, fechaEnvasado, precio;
                Boolean disponible;

                idProducto=(Integer)spinnerProducto.getValue();
                nombre= txtNombre.getText();
                fechaEnvasado= txtFecha.getText();
                unidades=(Integer)spinnerUnidades.getValue();
                precio=txtPrecio.getText();
                disponible=checkBoxDisponible.isSelected();

                try {
                    pst = con.prepareStatement("insert into productos(idProducto,nombre,fechaEnvasado,unidades,precio,disponible)values(?,?,?,?,?,?)");
                    pst.setInt(1, idProducto);
                    pst.setString(2, nombre);
                    pst.setString(3, fechaEnvasado);
                    pst.setInt(4, unidades);
                    pst.setString(5, precio);
                    pst.setBoolean(6, disponible);
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, "¡Producto registrado!");
                    table_load();
                    spinnerProducto.setValue(0);
                    txtNombre.setText("");
                    txtFecha.setText("dd/mm/aaaa");
                    spinnerUnidades.setValue(0);
                    txtPrecio.setText("");
                    checkBoxDisponible.setSelected(false);
                    txtNombre.requestFocus();
                }

                catch (SQLException e1)
                {
                    e1.printStackTrace();
                }
            }
        });

        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {

                    String idProductoBuscado = txtBuscar.getText();

                    pst = con.prepareStatement("select idProducto,nombre,fechaEnvasado,unidades,precio,disponible from productos where idProducto = ?");
                    pst.setString(1, idProductoBuscado);
                    ResultSet rs = pst.executeQuery();

                    if(rs.next()==true)
                    {
                        int idProducto = rs.getInt(1);
                        String nombre = rs.getString(2);
                        String fechaEnvasado = rs.getString(3);
                        int unidades = rs.getInt(4);
                        String precio = rs.getString(5);
                        Boolean disponible = rs.getBoolean(6);

                        spinnerProducto.setValue(idProducto);
                        txtNombre.setText(nombre);
                        txtFecha.setText(fechaEnvasado);
                        spinnerUnidades.setValue(unidades);
                        txtPrecio.setText(precio);
                        checkBoxDisponible.setSelected(disponible);

                    }
                    else
                    {
                        spinnerProducto.setValue(0);
                        txtNombre.setText("");
                        txtFecha.setText("dd/mm/aaaa");
                        spinnerUnidades.setValue(0);
                        txtPrecio.setText("");
                        checkBoxDisponible.setSelected(false);
                        JOptionPane.showMessageDialog(null,"ID de producto no válido");

                    }
                }
                catch (SQLException ex)
                {
                    ex.printStackTrace();
                }
            }
        });

        actualizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int unidades;
                String nombre, fechaEnvasado, precio, idProductoBuscado;
                Boolean disponible;

                nombre = txtNombre.getText();
                fechaEnvasado = txtFecha.getText();
                unidades = (Integer)spinnerUnidades.getValue();
                precio = txtPrecio.getText();
                disponible = checkBoxDisponible.isSelected();
                idProductoBuscado = txtBuscar.getText();;

                try {
                    pst = con.prepareStatement("update `productos` set nombre = ?,fechaEnvasado = ?,unidades = ?, precio = ?, disponible = ? where idProducto = ?");

                    pst.setString(1, nombre);
                    pst.setString(2, fechaEnvasado);
                    pst.setInt(3, unidades);
                    pst.setString(4, precio);
                    pst.setBoolean(5, disponible);
                    pst.setString(6,idProductoBuscado);

                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, "¡Producto actualizado!");
                    table_load();
                    spinnerProducto.setValue(0);
                    txtNombre.setText("");
                    txtFecha.setText("dd/mm/aaaa");
                    spinnerUnidades.setValue(0);
                    txtPrecio.setText("");
                    checkBoxDisponible.setSelected(false);
                    txtNombre.requestFocus();
                }

                catch (SQLException e1)
                {
                    e1.printStackTrace();
                }
            }
        });

        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String idProductoBuscado;
                idProductoBuscado = txtBuscar.getText();

                try {
                    pst = con.prepareStatement("delete from productos  where idProducto = ?");

                    pst.setString(1, idProductoBuscado);

                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, "¡Producto eliminado!");
                    table_load();
                    spinnerProducto.setValue(0);
                    txtNombre.setText("");
                    txtFecha.setText("dd/mm/aaaa");
                    spinnerUnidades.setValue(0);
                    txtPrecio.setText("");
                    checkBoxDisponible.setSelected(false);
                    txtNombre.requestFocus();
                }

                catch (SQLException e1)
                {
                    e1.printStackTrace();
                }
            }
        });
    }
}
