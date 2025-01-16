import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.*;

public class engCom {
    JFrame frame = new JFrame();
    JLabel title = new JLabel();
    Choice enco = new Choice();
    JButton rev = new JButton();
    String[] movies = new String[]{"Baby's Day Out", "Home Alone", "Mr. Bean"};
    Map<String,String> reviews = new HashMap<>();
    Map<String,String> images = new HashMap<>();
    engCom() {
        reviews.put("Baby's Day Out","\"Baby's Day Out\" is a slapstick comedy about a mischievous baby who escapes his kidnappers and explores New York City, causing hilarious chaos throughout the day, with plenty of physical humor and over-the-top situations, but can be a bit too crude for younger viewers due to some exaggerated slapstick violence");
        reviews.put("Home Alone","Home Alone is a film about a young 8 year old boy called Kevin who got annoyed at his older brother then hated his family... personally love this classic popular movie... I would also love to watch any of the others but this one is the best and probably the 2nd most funniest because I also love the 2nd one. There was my favorite part where one of the robbers got half his hair burnt off.");
        reviews.put("Mr. Bean","This movie is roll-out-of-your-chair-laughing funny. Rowan Atkinson's acting is beyond excellent, and all of the other characters are good as well.\n" +
                "\n" +
                "The only thing I can find to nitpick about this movie is that there is not a very strong plot. The movie is basically a line of connected humor skits. I personally do not mind this too much, but if you are looking for a movie with a story that can be made into a book, look elsewhere.\n");

        images.put("Baby's Day Out","src/baby.jpeg");
        images.put("Home Alone","src/home alone.jpeg");
        images.put("Mr. Bean","src/mrBean.jpeg");

        frame.setVisible(true);
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("English Comedies");
        frame.setLayout(null);


        ImageIcon backgroundImage = new ImageIcon("C:\\Users\\Administrator\\OneDrive\\Desktop\\hollywoodhills.jpeg");
        JLabel background = new JLabel(new ImageIcon(
                backgroundImage.getImage().getScaledInstance(400, 400, Image.SCALE_SMOOTH)));
        background.setBounds(0, 0, 400, 400);


        frame.setContentPane(background);
        background.setLayout(null);

        title.setText("Top English Comedies");
        title.setBounds(80, 20, 250, 50);
        title.setFont(new Font("SansSerif", Font.BOLD, 20));
        title.setForeground(Color.black);
        background.add(title);

        for (String m : movies) {
            enco.add(m);
        }
        enco.setBounds(100, 100, 200, 30);
        background.add(enco);

        rev.setText("Review");
        rev.setBounds(125, 200, 150, 50);
        rev.setForeground(Color.BLACK);
        rev.setFont(new Font("Arial", Font.BOLD, 20));
        background.add(rev);

        rev.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedMovie = enco.getSelectedItem();
                String review = reviews.getOrDefault(selectedMovie,"No Review Available!!!");
                String poster = images.getOrDefault(selectedMovie,"src/car.jpeg");
                JOptionPane.showMessageDialog(frame, "You selected: " + selectedMovie, "Movie Review", JOptionPane.INFORMATION_MESSAGE);
                reviewMaker(selectedMovie,review,poster);
            }
        });
    }
    private void reviewMaker(String movie,String reviews,String poster){
        JFrame frame = new JFrame(movie);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 900);
        frame.setLayout(null);


        JLabel mvName = new JLabel(movie);
        mvName.setFont(new Font("SansSerif", Font.BOLD, 50));
        mvName.setBounds(200, 20, 500, 80);
        mvName.setHorizontalAlignment(SwingConstants.CENTER);
        mvName.setForeground(Color.BLACK);
        frame.add(mvName);


        ImageIcon backgroundImage = new ImageIcon(poster);
        JLabel background = new JLabel(new ImageIcon(
                backgroundImage.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH))); // Adjust size
        background.setBounds(150, 150, 300, 300);
        frame.add(background);

        JTextArea reviewArea = new JTextArea(reviews);
        reviewArea.setBounds(500, 150, 300, 300);
        reviewArea.setFont(new Font("Impact", Font.PLAIN, 20));
        reviewArea.setLineWrap(true);
        reviewArea.setWrapStyleWord(true);
        reviewArea.setEditable(false);
        reviewArea.setForeground(Color.BLUE);
        frame.add(reviewArea);

        JButton bad = new JButton("Bad");
        bad.setBounds(150, 550, 100, 50);
        bad.setFont(new Font("Cascadia Code ExtraLight", Font.BOLD, 20));
        bad.setBackground(Color.PINK);
        frame.add(bad);

        JButton avg = new JButton("Average");
        avg.setBounds(300, 550, 200, 50);
        avg.setFont(new Font("Cascadia Code ExtraLight", Font.BOLD, 20));
        avg.setBackground(Color.yellow);
        frame.add(avg);

        JButton gud = new JButton("Good");
        gud.setBounds(550, 550, 100, 50);
        gud.setFont(new Font("Cascadia Code ExtraLight", Font.BOLD, 20));
        gud.setBackground(Color.green);
        frame.add(gud);
        frame.setVisible(true);

        String[] con= new String[]{"Baby's Day Out","Home Alone","Mr.Bean"};
        String context = "";
        for(String s:con) {
            if (!s.equals(movie)) {
                context += " " + s + " ";
            }
        }
        bad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "If it doesnt suit you watch action and sci fi movies!!!");
            }
        });

        String finalContext = context;

        avg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "You can try these to get better experience or try action and sci fi movies: "+ finalContext);
            }
        });

        gud.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame,"You will love these too!!!"+finalContext);
            }
        });
    }
}
