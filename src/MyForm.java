import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Alex on 25.04.2017.
 */
public class MyForm extends JFrame {
    private JPanel infoPanel = new JPanel();
    private JPanel transportsPanel = new JPanel();
    private JPanel buttonPanel =  new JPanel();
    private JButton findTheWayButton =  new JButton("Найти путь");
    private JButton addBusButton = new JButton("Добавить автобус");
    private JButton addTramButton =  new JButton("Добавить трамвай");
    private JButton addTrolleybusButton =  new JButton("Добавить троллейбус");
    private JButton changeCurrentTransport =  new JButton("Изменить");

    public JList getTransportList() {
        return transportList;
    }

    private JList transportList;
    private JTextArea infoTextArea = new JTextArea();

    public MyForm(Solver solver){
        this.setSize(500, 300);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout());

        getContentPane().add(infoPanel, BorderLayout.EAST);
        getContentPane().add(transportsPanel, BorderLayout.WEST);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);
        getContentPane().add(changeCurrentTransport, BorderLayout.CENTER);

        transportList = new JList();
        transportList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int index = transportList.getSelectedIndex();
                Transport t = solver.getTransports().get(index);
                String info = "Тип - " + t.getType() + "\n";
                info = info + "Номер - " + t.getNumber() + "\n";
                info = info + "Маршрут: " + t.getRoute().getPoints() + "\n";
                info = info + "Цена проезда - " + t.getPrice() + "\n";
                infoTextArea.setText(info);
            }
        });
        transportList.setListData(solver.getTransports().toArray());
        transportsPanel.add(transportList);

        infoPanel.add(infoTextArea);


        buttonPanel.setLayout(new BorderLayout());
        buttonPanel.add(findTheWayButton, BorderLayout.SOUTH);
        buttonPanel.add(addBusButton, BorderLayout.WEST);
        buttonPanel.add(addTramButton, BorderLayout.CENTER);
        buttonPanel.add(addTrolleybusButton, BorderLayout.EAST);

        findTheWayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FindTheWayDialog findTheWayDialog = new FindTheWayDialog(solver);
                findTheWayDialog.setVisible(true);
            }
        });

        addBusButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                AddBusDialog addBusDialog = new AddBusDialog(solver, solver.getForm());
                addBusDialog.setVisible(true);
            }
        });
        addTramButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddTramDialog addTramDialog = new AddTramDialog(solver, solver.getForm());
                addTramDialog.setVisible(true);
            }
        });
        addTrolleybusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddTrolleybusDialog addTrolleybusDialog = new AddTrolleybusDialog(solver, solver.getForm());
                addTrolleybusDialog.setVisible(true);
            }
        });

        changeCurrentTransport.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ChangeCurrentTransportDialog changeCurrentTransportDialog = new ChangeCurrentTransportDialog(solver, solver.getForm());
                changeCurrentTransportDialog.setVisible(true);
                transportList.setListData(solver.getTransports().toArray());
            }
        });
    }
}
