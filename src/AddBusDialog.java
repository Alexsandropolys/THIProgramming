import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Alex on 12.05.2017.
 */
public class AddBusDialog extends JDialog implements ActionListener {
    private JButton ok_Button = new JButton("ok");
    private JTextField number = new JTextField();
    private  JTextField route = new JTextField();
    private JTextField price = new JTextField();
    private Solver solver;
    private MyForm form;

    public AddBusDialog(Solver solver, MyForm form){
        this.setSize(200,200);
        this.solver = solver;
        this.form = form;
        this.setModal(true);
        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        number.setText("Введите номер транспорта");
        route.setText("Введите маршрут");
        price.setText("Задайте цену");
        getContentPane().add(number);
        getContentPane().add(route);
        getContentPane().add(price);
        getContentPane().add(ok_Button);
        ok_Button.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Route r = new Route(route.getText());
        Bus bus =  new Bus(Integer.parseInt(number.getText()), r, Integer.parseInt(price.getText()));
        solver.addTransport(bus);
        form.getTransportList().setListData(solver.getTransports().toArray());
        this.dispose();
    }
}
