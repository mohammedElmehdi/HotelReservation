package com.hotel.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// Classes de la résérvation
data class Reservation {
    private int id;
    private String nomClient;
    private String typeChambre;
    private String dateArrivee;
    private String dateDepart;

    public Reservation(int id, String nomClient, String typeChambre, String dateArrivee, String dateDepart) {
        this.id = id;
        this.nomClient = nomClient;
        this.typeChambre = typeChambre;
        this.dateArrivee = dateArrivee;
        this.dateDepart = dateDepart;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getnomClient() { return nomClient; }
    public void setnomClient(String nomClient) { this.nomClient = nomClient; }
    public String gettypeChambre() { return typeChambre; }
    public void settypeChambre(String typeChambre) { this.typeChambre = typeChambre; }
    public String getdateArrivee() { return dateArrivee; }
    public void setdateArrivee(String dateArrivee) { this.dateArrivee = dateArrivee; }
    public String getdateDepart() { return dateDepart; }
    public void setdateDepart(String dateDepart) { this.dateDepart = dateDepart; }
}
