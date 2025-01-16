import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class engAct {
        JFrame frame = new JFrame();
        JLabel title = new JLabel();
        Choice enco = new Choice();
        JButton rev = new JButton();
        String[] movies = new String[]{"John Wick", "Extraction", "Mission Impossible"};
        Map<String,String> reviews = new HashMap<>();
        Map<String,String> images = new HashMap<>();
        engAct() {
            reviews.put("John Wick","John Wick delivers relentless action, breathtaking choreography, and a deeper dive into its intriguing assassin underworld, making it a high-octane spectacle for fans of the franchise.");
            reviews.put("Extraction","Extraction is an adrenaline-fueled action thriller featuring Chris Hemsworth as a skilled mercenary on a deadly mission. The intense fight sequences and gripping cinematography keep you on the edge of your seat. While the plot is straightforward, the emotional core adds depth. A must-watch for action enthusiasts.");
            reviews.put("Mission Impossible","Mission: Impossible is a masterclass in high-stakes espionage, blending jaw-dropping stunts, clever twists, and  gripping storyline.Tom Cruise’s dedication to perform death-defying action sequences elevates  film to an adrenaline-pumping experience. The mix of suspense, intrigue, and breathtaking set pieces keeps you hooked. A thrilling ride that defines action cinema at its best.");
            images.put("John Wick","src/john wick.jpeg");
            images.put("Extraction","src/extraction.jpeg");
            images.put("Mission Impossible","src/mission impossible.jpeg");

            frame.setVisible(true);
            frame.setSize(400, 400);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setTitle("English Action");
            frame.setLayout(null);


            ImageIcon backgroundImage = new ImageIcon("C:\\Users\\Administrator\\OneDrive\\Desktop\\hollywoodhills.jpeg");
            JLabel background = new JLabel(new ImageIcon(
                    backgroundImage.getImage().getScaledInstance(400, 400, Image.SCALE_SMOOTH)));
            background.setBounds(0, 0, 400, 400);


            frame.setContentPane(background);
            background.setLayout(null);

            title.setText("Top English Action");
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

            String[] con= new String[]{"John Wick","Extraction","Mission Impossible"};
            String context = "";
            for(String s:con) {
                if (!s.equals(movie)) {
                    context =context + " " + s + " ";
                }
            }
            bad.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(frame, "If it doesnt suit you watch Sci-Fi and comedy movies!!!");
                }
            });

            String finalContext = context;

            String finalContext1 = context;
            avg.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(frame, "You can try Sci-Fi and comedy movies or try these epic sci-fi too "+finalContext1);
                }
            });

            gud.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(frame,"You will love these too!!!"+finalContext1);
                }
            });
        }
        public static void main(String[] args){
            new engAct();
        }
    }


