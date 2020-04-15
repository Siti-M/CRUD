
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ASUS
 */
public class EditData extends JFrame{
    JLabel lNim,lNama,lAlamat, lJudul;
    JTextField tfNim,tfNama,tfAlamat;
    JButton btnUpdate, btnKembali;
    Statement statement;
    ResultSet resultset;
    
    public void EditData(){
        
        setTitle("Update Data Pegawai");
        lJudul = new JLabel("MASUKAN NIM YANG AKAN DIUPDATE");
        lNim = new JLabel("NIM ");
        lNama = new JLabel("Nama ");  
        lAlamat = new JLabel("Alamat ");
        
        tfNim = new JTextField();
        tfNama = new JTextField();
        tfAlamat = new JTextField();
        
        btnUpdate = new JButton("Update");
        btnKembali = new JButton("Kembali");
        
        setSize(300,370);
        lJudul.setHorizontalAlignment(SwingConstants.CENTER);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        setLayout(null);
        add(lNim);
        add(lNama);
        add(lAlamat);
        add(tfNim);
        add(tfNama);
        add(tfAlamat);
        add(btnUpdate);
        add(btnKembali);
        
        lJudul.setBounds(0, 10, 300, 25);
        lNim.setBounds(50, 50, 100, 25);
        tfNim.setBounds(100, 50, 100, 25);
        lNama.setBounds(50, 90, 100, 25);
        tfNama.setBounds(100, 90, 100, 25);
        lAlamat.setBounds(50, 210, 100, 25);
        tfAlamat.setBounds(100, 210, 100, 25);
        btnKembali.setBounds(30, 290, 100, 25);
        btnUpdate.setBounds(140, 290, 100, 25);
        
        btnKembali.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new formmhs();
            }
        });
        
         btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnUpdateactionListener();
            }
        });
    }
    
    private void btnUpdateactionListener() {
        KoneksiDB koneksi = new KoneksiDB();
        try {
            statement = koneksi.getKoneksi().createStatement();
            statement.executeUpdate("UPDATE data_mhs SET nama='" + tfNama.getText() + "'," + "alamat='" +
            tfAlamat.getText() + "' WHERE nim='" + tfNim.getText() + "'" );
            JOptionPane.showMessageDialog(null, "Data Berhasil di Update!", "Hasil", JOptionPane.INFORMATION_MESSAGE);
            statement.close();
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Data Gagal di Update!", "Hasil", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null, "Driver tidak ditemukan!", "Hasil", JOptionPane.ERROR_MESSAGE);
        }
        
    }
     

    
}
