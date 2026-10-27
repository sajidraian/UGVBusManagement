package ugv.bus;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BusRouteUI extends JFrame {

    private JTextField txtRoute, txtTime, txtStart, txtEnd, txtDistance, txtUnitCost;
    private JComboBox<String> cmbRouteType;
    private JTable table;
    private DefaultTableModel model;
    private RouteDAO routeDAO;

    public BusRouteUI() {
        routeDAO = new RouteDAO();

        setTitle("UGV Bus Route Management System");
        setSize(850, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(7, 2, 5, 5));
        
        inputPanel.add(new JLabel(" Route Name:"));
        txtRoute = new JTextField();
        inputPanel.add(txtRoute);

        inputPanel.add(new JLabel(" Departure Time:"));
        txtTime = new JTextField();
        inputPanel.add(txtTime);

        inputPanel.add(new JLabel(" Start Location:"));
        txtStart = new JTextField();
        inputPanel.add(txtStart);

        inputPanel.add(new JLabel(" End Location:"));
        txtEnd = new JTextField();
        inputPanel.add(txtEnd);

        inputPanel.add(new JLabel(" Distance (km):"));
        txtDistance = new JTextField();
        inputPanel.add(txtDistance);

        inputPanel.add(new JLabel(" Unit Cost (Tk):"));
        txtUnitCost = new JTextField();
        inputPanel.add(txtUnitCost);

        inputPanel.add(new JLabel(" Route Type:"));
        cmbRouteType = new JComboBox<>(new String[]{"City Route", "Intercity Route", "Shuttle Route"});
        inputPanel.add(cmbRouteType);

        add(inputPanel, BorderLayout.NORTH);

        String[] columns = {"Route Name", "Time", "Start", "End", "Distance", "Total Fare", "Type"};
        model = new DefaultTableModel(columns, 0);
        table = new JTable(model);
        add(new JScrollPane(table), BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        JButton btnAdd = new JButton("Add Route to DB");
        JButton btnRefresh = new JButton("Load Database Data");

        buttonPanel.add(btnAdd);
        buttonPanel.add(btnRefresh);
        add(buttonPanel, BorderLayout.SOUTH);

        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String name = txtRoute.getText();
                    String time = txtTime.getText();
                    String start = txtStart.getText();
                    String end = txtEnd.getText();
                    double distance = Double.parseDouble(txtDistance.getText());
                    double unitCost = Double.parseDouble(txtUnitCost.getText());
                    String type = cmbRouteType.getSelectedItem().toString();

                    Route route;
                    if (type.equals("City Route")) {
                        route = new CityRoute(name, time, start, end, distance, unitCost);
                    } else if (type.equals("Intercity Route")) {
                        route = new IntercityRoute(name, time, start, end, distance, unitCost);
                    } else {
                        route = new ShuttleRoute(name, time, start, end, distance, unitCost);
                    }

                    routeDAO.saveRoute(route, type);
                    routeDAO.loadRoutesToTable(model);

                    JOptionPane.showMessageDialog(null, "Route Saved Successfully!");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error: Please check inputs!");
                }
            }
        });

        btnRefresh.addActionListener(e -> routeDAO.loadRoutesToTable(model));
        routeDAO.loadRoutesToTable(model);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new BusRouteUI().setVisible(true);
        });
    }
}