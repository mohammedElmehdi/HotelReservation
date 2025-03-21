// Classe de la connexion à la base de données
class Database {
    private static final String URL = "jdbc:mysql://localhost:3306/hotel_db";
    private static final String USER = "admin";
    private static final String PASSWORD = "12@34";

    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static List<Reservation> getAllReservations() {
        List<Reservation> reservations = new ArrayList<>();
        String query = "SELECT * FROM reservations";
        
        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            
        	while (rs.next()) {
                reservations.add(new Reservation(
                        rs.getInt("id"),
                        rs.getString("client_name"),
                        rs.getString("email"),
                        rs.getString("room_type"),
                        rs.getString("check_in_date"),
                        rs.getString("check_out_date")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reservations;
    }
}
