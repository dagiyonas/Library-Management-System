package dao;

import model.Member;
import util.DBConnectionUtil;

import java.sql.*;
import java.util.ArrayList;

public class MemberDAO {
    public void insertMember(Member member) {
        String sql = "INSERT INTO members (id, section, authorized) VALUES (?, ?, ?)";
        try (Connection conn = DBConnectionUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, member.getUserId());
            stmt.setString(2, member.getSection());
            stmt.setBoolean(3, member.getIsAuthorized());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Insert Member Failed: " + e.getMessage());
        }
    }

    public ArrayList<Member> getAllMembers() {
        ArrayList<Member> list = new ArrayList<>();
        String sql = "SELECT * FROM members";
        try (Connection conn = DBConnectionUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                list.add(new Member(rs.getString("id"), rs.getString("section"), rs.getBoolean("authorized")));
            }
        } catch (SQLException e) {
            System.err.println("Retrieve Members Failed: " + e.getMessage());
        }
        return list;
    }
}
