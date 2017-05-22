import javafx.geometry.VerticalDirection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Alex on 12.05.2017.
 */
public class FindTheWayDialog extends JDialog implements ActionListener {
    private JButton ok_Button = new JButton("OK");
    private JTextField point_A = new JTextField();
    private JTextField point_B = new JTextField();
    private Solver solver;
    public FindTheWayDialog(Solver solver){
        this.solver = solver;
        this.setModal(true);
        this.setSize(50, 100);
       getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        getContentPane().add(point_A);
        getContentPane().add(point_B);
        getContentPane().add(ok_Button);
        ok_Button.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(ok_Button, solver.findTheWay(point_A.getText(), point_B.getText()));
        this.dispose();
    }
}
