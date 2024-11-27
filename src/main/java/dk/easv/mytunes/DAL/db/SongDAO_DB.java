package dk.easv.mytunes.DAL.db;

import BE.Song;
import DAL.ISongDataAccess;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static java.time.chrono.ThaiBuddhistEra.BE;

public class SongDAO_DB implements ISongDataAccess {

    private DataBaseConnector SongdatabaseConnector;

    public SongDAO_DB() throws IOException {
        SongdatabaseConnector = new DataBaseConnector();
    }

    @Override
    public List<Song> getAllSongs() throws Exception {
        ArrayList<Song> allSongs = new ArrayList<>();

        try (Connection conn = SongdatabaseConnector.getConnection();
             Statement stmt = conn.createStatement()) {

            String sql = "SELECT * " +
                    "FROM Songs " +
                    "JOIN Genre ON Songs.GenreID = Genre.GenreID " +
                    "JOIN Artist ON Songs.ArtistID = Artist.ArtistID;";

            ResultSet rs = stmt.executeQuery(sql);

            // Loop through rows from the database result set
            while (rs.next()) {

                //Map DB row to Movie object
                int id = rs.getInt("SongID");
                String artist = rs.getString("ArtistName");
                String title = rs.getString("SongTitle");
                String genre = rs.getString("GenreType");
                int length = rs.getInt("SongDuration");
                String filePath = rs.getString("FilePath");

                Song song = new Song(id, artist, title, genre, length, filePath);
                allSongs.add(song);
            }
            return allSongs;

        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new Exception("Could not get movies from database", ex);
        }
    }
}
