package dao;

import model.Librarian;
import util.DBConnectionUtil;

import java.sql.*;
import java.util.ArrayList;

public class LibrarianDAO {
    public void insertLibrarian(Librarian librarian) {
        String sql = "INSERT INTO librarians (id, section, authorized, shift) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnectionUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, librarian.getUserId());
            stmt.setString(2, librarian.section);
            stmt.setBoolean(3, librarian.isAuthorized);
            stmt.setString(4, librarian.shift);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Insert Librarian Failed: " + e.getMessage());
        }
    }

    public ArrayList<Librarian> getAllLibrarians() {
        ArrayList<Librarian> list = new ArrayList<>();
        String sql = "SELECT * FROM librarians";
        try (Connection conn = DBConnectionUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                list.add(new Librarian(rs.getString("id"), rs.getString("section"),
                        rs.getBoolean("authorized"), rs.getString("shift")));
            }
        } catch (SQLException e) {
            System.err.println("Retrieve Librarians Failed: " + e.getMessage());
        }
        return list;
    }
}
