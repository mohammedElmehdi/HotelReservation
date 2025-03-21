package com.hotel.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// Classe de la reservation
data class Reservation {
    private int id;
    private String clientName;
    private String email;
    private String roomType;
    private String checkInDate;
    private String checkOutDate;

    public Reservation(int id, String clientName, String roomType, String checkInDate, String checkOutDate) {
        this.id = id;
        this.clientName = clientName;
        this.email = email;
        this.roomType = roomType;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }
    
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getClientName() { return clientName; }
    public void setClientName(String clientName) { this.clientName = clientName; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getRoomType() { return roomType; }
    public void setRoomType(String roomType) { this.roomType = roomType; }
    public String getCheckInDate() { return checkInDate; }
    public void setCheckInDate(String checkInDate) { this.checkInDate = checkInDate; }
    public String getCheckOutDate() { return checkOutDate; }
    public void setCheckOutDate(String checkOutDate) { this.checkOutDate = checkOutDate; }
}

	//Inserstion d'une nouvelle réservation

public static boolean insertReservation(String clientName, String email, String roomType, String checkInDate, String checkOutDate) {
    String query = "INSERT INTO reservations (client_name, email, room_type, check_in_date, check_out_date) VALUES (?, ?, ?, ?, ?)";
    try (Connection conn = Database.connect();
         PreparedStatement stmt = conn.prepareStatement(query)) {
        stmt.setString(1, clientName);
        stmt.setString(2, email);
        stmt.setString(3, roomType);
        stmt.setString(4, checkInDate);
        stmt.setString(5, checkOutDate);
        return stmt.executeUpdate() > 0;
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}

	// Mise à jour d'une réservation 

public static boolean updateReservation(int id, String clientName, String email, String roomType, String checkInDate, String checkOutDate) {
    String query = "UPDATE reservations SET client_name = ?, email = ?, room_type = ?, check_in_date = ?, check_out_date = ? WHERE id = ?";
    try (Connection conn = Database.connect();
         PreparedStatement stmt = conn.prepareStatement(query)) {
        stmt.setString(1, clientName);
        stmt.setString(2, email);
        stmt.setString(3, roomType);
        stmt.setString(4, checkInDate);
        stmt.setString(5, checkOutDate);
        stmt.setInt(6, id);
        return stmt.executeUpdate() > 0;
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}


// Supression d'une réservation

public static boolean deleteReservation(int id) {
    String query = "DELETE FROM reservations WHERE id = ?";
    try (Connection conn = Database.connect();
         PreparedStatement stmt = conn.prepareStatement(query)) {
        stmt.setInt(1, id);
        return stmt.executeUpdate() > 0;
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}
}
