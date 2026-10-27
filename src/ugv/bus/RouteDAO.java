package ugv.bus;

import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class RouteDAO {
    public void saveRoute(Route route, String routeType) {
        String sql = "INSERT INTO bus_routes (route_name, time, start_loc, end_loc, distance, unit_cost, total_fare, route_type) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, route.getRouteName());
            pstmt.setString(2, route.getTime());
            pstmt.setString(3, route.getStartLocation());
            pstmt.setString(4, route.getEndLocation());
            pstmt.setDouble(5, route.getDistance());
            pstmt.setDouble(6, route.getUnitCost());
            pstmt.setDouble(7, route.calculateTotalFare());
            pstmt.setString(8, routeType);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void loadRoutesToTable(DefaultTableModel model) {
        model.setRowCount(0);
        String sql = "SELECT * FROM bus_routes";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Object[] row = {
                    rs.getString("route_name"),
                    rs.getString("time"),
                    rs.getString("start_loc"),
                    rs.getString("end_loc"),
                    rs.getDouble("distance"),
                    rs.getDouble("total_fare"),
                    rs.getString("route_type")
                };
                model.addRow(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}