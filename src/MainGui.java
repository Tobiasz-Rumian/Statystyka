import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by zekori on 23.11.16.
 */
public class MainGui extends JFrame{
    private JButton showButton;
    private JTable statisticTable;
    private JButton aboutButton;
    private JPanel mainPanel;
    private JTextField answer;
    private int[][] numbers= new int[8][2];
    private DefaultTableModel tableModel;
    MainGui(){
        setContentPane(mainPanel);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        createTable();
        addNumbersToArray();
        createValue(numbers);//TODO: dodać prawidłowe wartości
        setVisible(true);
        showButton.addActionListener(actionEvent -> {

        });
        aboutButton.addActionListener(actionEvent -> {
            About about;
            try {
                about = new About(this);
                about.setVisible(true);
            } catch (Exception event) {
                System.err.println(event.getMessage());
            }
        });
    }

    public static void main(String[] args) {
        new MainGui();
    }

    public double createValue(int[][] array){
        //TODO: Zapisać równanie podane na zajęciach
        return 0;
    }

    public void addNumbersToArray(){
        //TODO: Dodać prawidlowe numery
        numbers[0][0]=0;numbers[0][1]=0;
        numbers[1][0]=0;numbers[1][1]=0;
        numbers[2][0]=0;numbers[2][1]=0;
        numbers[3][0]=0;numbers[3][1]=0;
        numbers[4][0]=0;numbers[4][1]=0;
        numbers[5][0]=0;numbers[5][1]=0;
        numbers[6][0]=0;numbers[6][1]=0;
        numbers[7][0]=0;numbers[7][1]=0;
        tableModel.setRowCount(0);

        for(int i=0;i<numbers.length;i++){
                String[] row={(i+1)+")",Integer.toString(numbers[i][0]),Integer.toString(numbers[i][1])};
                tableModel.addRow(row);
        }

    }
    public void createTable(){

        String[] column = {"Lp.", "Ilość godzin", "Ocena"};

        tableModel = new DefaultTableModel(column, 0);
        statisticTable.setModel(tableModel);
        tableModel.addRow(column);
    }

}
class About extends JDialog {
    About(JFrame owner) throws MalformedURLException {
        super(owner, "O Autorze", true);
        URL url = null;
        try {
            url = new URL("https://media.giphy.com/media/l0HlIKdi4DIEDk92g/giphy.gif");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        Icon icon = new ImageIcon(url);
        JLabel label = new JLabel(icon);
        add(new JLabel("Autor:\t Tobiasz Rumian\t Indeks: 226131"), BorderLayout.NORTH);
        add(label, BorderLayout.CENTER);
        JButton ok = new JButton("ok");
        ok.addActionListener(e -> setVisible(false));
        add(ok, BorderLayout.SOUTH);
        setSize(400, 400);
    }
}

