import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.*;
import javax.swing.*;
public class Movie {
    JFrame frame  = new JFrame();
    JLabel Name = new JLabel();
    JTextField name = new JTextField();
    JLabel type = new JLabel();
    Choice Type = new Choice();
    JLabel Genre = new JLabel();
    Choice genre = new Choice();
    JButton Submit = new JButton();
    String[] lang =  new String[]{"Tamil","English","Hindi"};
    String[] genres = new String[]{"Sci-fi","Action","Comedy"};
    Movie(){
        frame.setVisible(true);
        frame.setSize(400,400);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setTitle("Movies");
        frame.setLayout(null);
        Name.setText("Enter your name");
        Name.setFont(new Font("Arial",Font.BOLD,20));
        Name.setBounds(50, 30, 200, 20);
        name.setBounds(50, 60, 300, 30);
        frame.add(Name);
        frame.add(name);
        for(String t:lang) {
            Type.add(t);
        }
        type.setText("Choose language");
        type.setFont(new Font("Arial",Font.BOLD,20));
        type.setBounds(50, 110, 200, 20);
       Type.setBounds(50, 140, 300, 30);
        frame.add(type);
        frame.add(Type);
        Genre.setText("Choose your Genre");
        Genre.setFont(new Font("Arial",Font.BOLD,20));
        Genre.setBounds(50, 190, 200, 20);
        for(String g:genres){
            genre.add(g);
        }
        genre.setBounds(50, 220, 300, 30);
        frame.add(Genre);
        frame.add(genre);
        Submit.setBounds(150, 280, 100, 30);
        Submit.setText("Submit!");
        frame.add(Submit);
        Submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nme = name.getText();
                String typ = Type.getSelectedItem();
                String genr = genre.getSelectedItem();
                String message =  "Name: " + nme + " Language: "+ typ + " Genre: " +genr;
                if (nme.isEmpty() || typ.isEmpty() || genr.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Please fill all fields.", "Error", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                JOptionPane.showMessageDialog(frame, "Welcome "+nme+"!!!", "Your Preferences", JOptionPane.INFORMATION_MESSAGE);
                switch(typ+genr){
                    case "EnglishComedy":
                        engCom ec = new engCom();
                        break;
                    case "EnglishSci-fi":
                        engSci es = new engSci();
                        break;
                    case "EnglishAction":
                        engAct ea = new engAct();
                        break;
                    case "TamilSciFi":
                        tamsci ts = new tamsci();
                        break;
                    case "TamilComedy":
                        tamcom tc = new tamcom();
                        break;
                    case "TamilAction":
                        tamAct ta = new tamAct();
                        break;
                    case "HindiSciFi":
                        hinsci hs = new hinsci();
                        break;
                    case "HindiAction":
                        hinact ha = new hinact();
                        break;
                    case "HindiComedy":
                        hincom hc = new hincom();
                        break;
                    default:
                        break;
                 }
                System.out.println(message);
                storeInDb(nme,typ,genr);
            }
        });
    }

private void storeInDb(String name,String lang,String genre){
    String url = "jdbc:mysql://localhost:3306/movie?useSSL=false";
    String user="root";
    String password = "Abhi2209!!";
    try{
        Connection connection = DriverManager.getConnection(url, user, password);
        String sql = "INSERT INTO list(name, language, genre) VALUES (?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, name);
        statement.setString(2, lang);
        statement.setString(3, genre);

        int rowsInserted = statement.executeUpdate();
        if (rowsInserted > 0) {
            System.out.println("Data inserted successfully!");
        }
        connection.close();
    } catch (SQLException ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(frame, "Database Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}
    }

