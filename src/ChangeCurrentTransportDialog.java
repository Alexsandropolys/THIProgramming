import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Alex on 14.05.2017.
 */
public class ChangeCurrentTransportDialog extends JDialog implements ActionListener {
    private JButton ok_Button = new JButton("ok");
    private JTextField number = new JTextField();
    private  JTextField route = new JTextField();
    private JTextField price = new JTextField();
    private Solver solver;
    private MyForm form;
    private Transport current_transport;

    public ChangeCurrentTransportDialog(Solver solver, MyForm form){
        this.setSize(200,200);
        this.solver = solver;
        this.form = form;
        this.setModal(true);
        current_transport =  solver.getTransports().get(form.getTransportList().getSelectedIndex());
        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        number.setText("" + current_transport.getNumber());
        route.setText(current_transport.getRoute().getPoints());
        price.setText("" + current_transport.getPrice());
        getContentPane().add(number);
        getContentPane().add(route);
        getContentPane().add(price);
        getContentPane().add(ok_Button);
        ok_Button.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Route r = new Route(route.getText());
        current_transport.setRoute(r);
        current_transport.setNumber(Integer.parseInt(number.getText()));
        current_transport.setPrice(Integer.parseInt(price.getText()));
        solver.getTransports().remove(form.getTransportList().getSelectedIndex());
        solver.addTransport(current_transport);
        form.getTransportList().clearSelection();
        form.getTransportList().setListData(solver.getTransports().toArray());
        this.dispose();
    }
}
