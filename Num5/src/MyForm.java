import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.util.ArrayList;
import java.util.Collections;

public class MyForm extends JDialog {

    ArrayList<Paper> papers = new ArrayList<>();

    private JPanel contentPane;

    private JList list1;
    private JTextField authorField;
    private JTextField titleField;
    private JTextField countField;
    private JTextField searchField;
    private JComboBox categoryBox;
    private JComboBox searchBox;
    private JComboBox sortBox;
    private JButton searchButton;
    private JButton sortUpButton;
    private JButton deleteButton;
    private JButton addButton;
    private JButton changeButton;
    private JButton showAllButton;
    private JButton CloseButton;
    private JButton sortDownButton;
    private JTextField Date;

    public MyForm() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(CloseButton);


        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Paper paper1 = new Paper(authorField.getText(), titleField.getText(), Integer.valueOf(countField.getText()), categoryBox.getSelectedItem().toString(), Date.getDate());
                papers.add(paper1);
                list1.setListData(papers.toArray());
                Date.setText("");
                authorField.setText("");
                titleField.setText("");
                countField.setText("");
                categoryBox.setSelectedItem("Java");
            }
        });

        list1.addMouseListener(new MouseAdapter(){
            /// клик по элементам списка
            public void mouseClicked(MouseEvent e){
                int index = list1.getSelectedIndex();
                authorField.setText(papers.get(index).getAuthor());
                titleField.setText(papers.get(index).getTitle());
                countField.setText(Integer.toString(papers.get(index).getCount()));
                categoryBox.setSelectedItem(papers.get(index).getCategory());
            }

        });

        changeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = list1.getSelectedIndex();;
                Paper paperRemove = new Paper(authorField.getText(), titleField.getText(), Integer.valueOf(countField.getText()), categoryBox.getSelectedItem().toString(),LocalDate.now());
                papers.set(index,paperRemove);
                list1.setListData(papers.toArray());
                Date.setText("");
                authorField.setText("");
                titleField.setText("");
                countField.setText("");
                categoryBox.setSelectedItem("Java");
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = list1.getSelectedIndex();;
                papers.remove(index);
                list1.setListData(papers.toArray());
                authorField.setText("");
                titleField.setText("");
                countField.setText("");
                categoryBox.setSelectedItem("Java");
            }
        });

        showAllButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                list1.setListData(papers.toArray());
                authorField.setText("");
                titleField.setText("");
                countField.setText("");
                categoryBox.setSelectedItem("Java");
            }
        });

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<Paper> paperSearch = new ArrayList<>();
                String parameter = searchBox.getSelectedItem().toString();
                String searchWord = searchField.getText().toString();
                if (parameter == "Автор") {
                    for (int i = 0; i < papers.size(); i++) {
                        if (papers.get(i).getAuthor().contains(searchWord)) {
                            paperSearch.add(papers.get(i));
                        }
                    }
                } else if (parameter == "Название") {
                    for (int i = 0; i < papers.size(); i++) {
                        if (papers.get(i).getTitle().contains(searchWord)) {
                            paperSearch.add(papers.get(i));
                        }
                    }
                } else if (parameter == "Кол-во просмотров") {
                    for (int i = 0; i < papers.size(); i++) {
                        if (papers.get(i).getCount() <= Integer.parseInt(searchWord)) {
                            paperSearch.add(papers.get(i));
                        }
                    }
                } else if(parameter == "Рубрика"){
                    for(int i=0;i<papers.size();i++){
                        if(papers.get(i).getCategory().contains(searchWord)){
                            paperSearch.add(papers.get(i));
                        }
                    }
                }

                list1.setListData(paperSearch.toArray());
            }
        });

        sortDownButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                var newPapers = papers;
                newPapers.sort(new Compare((String) sortBox.getSelectedItem()));
                ArrayList<Paper> paperSort = new ArrayList<>();
                for(Paper paper: newPapers){
                    paperSort.add(paper);
                }
                Collections.reverse(paperSort);
                list1.setListData(paperSort.toArray());
            }
        });

        sortUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                var newPapers = papers;
                newPapers.sort(new Compare((String) sortBox.getSelectedItem()));
                ArrayList<Paper> paperSort = new ArrayList<>();
                for(Paper paper: newPapers){
                    paperSort.add(paper);
                }
                list1.setListData(paperSort.toArray());
            }
        });

        CloseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    public static void main(String[] args) {
        MyForm dialog = new MyForm();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}