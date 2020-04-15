
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;


public class HapusData extends JFrame {
    Statement statement;
    ResultSet resultset;
    JLabel lnim,lJudul;
    JTextField tfnim;
    JButton btnDel, btnKembali;
    
    public void HapusData(){
        lJudul = new JLabel("Hapus Data Mahasiswa");
        lnim = new JLabel("nim ");
        tfnim = new JTextField();
        btnDel = new JButton("Hapus");
        btnKembali = new JButton("Kembali");
        
        setTitle("Hapus Data Mahasiswa");
        setSize(300, 200);
        lJudul.setHorizontalAlignment(SwingConstants.CENTER);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    
        setLayout(null);
        add(lJudul);
        add(lnim);
        add(tfnim);
        add(btnDel);
        add(btnKembali);
        
   
        lJudul.setBounds(50, 10, 150, 25);
        lnim.setBounds(50, 50, 100, 25);
        tfnim.setBounds(100, 50, 100, 25);
        btnKembali.setBounds(30, 90, 100, 25);
        btnDel.setBounds(140, 90, 100, 25);
        
        btnKembali.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                setVisible(false);
                new formmhs();
            }
        });
        
        btnDel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                btnBuatactionListener();
            }
        });
    }
    

    private void btnBuatactionListener() {
       KoneksiDB koneksi = new KoneksiDB();
       
        try {
            statement = koneksi.getKoneksi().createStatement();
            statement.executeUpdate("DELETE FROM data_mhs WHERE nim='" + tfnim.getText() + "'" );
            JOptionPane.showMessageDialog(null, "Data Berhasil dihapus!", "Hasil", JOptionPane.INFORMATION_MESSAGE);
            statement.close();
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Data Gagal dihapus!", "Hasil", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
JOptionPane.showMessageDialog(null, "Drive Tidak Ditemukan!", "Hasil", JOptionPane.ERROR_MESSAGE);
        }
           
    }
    
}
