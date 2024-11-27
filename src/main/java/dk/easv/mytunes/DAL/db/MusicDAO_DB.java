package dk.easv.mytunes.DAL.db;

import dk.easv.mytunes.BE.Song;
import dk.easv.mytunes.DAL.IMusicDataAcces;


import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MusicDAO_DB implements IMusicDataAcces {

        private DBConnector dbConnector = new DBConnector();

    public MusicDAO_DB() throws IOException {
    }

    public void MovieDAO_DB() throws IOException {}

        @Override
        public List<Song> getAllMusic() throws Exception {

            ArrayList<Song> allMusic = new ArrayList<>();

            // try-with-resources
            try (Connection conn = dbConnector.getConnection();
                 Statement stmt = conn.createStatement())
            {
                String sql = "SELECT * FROM dbo.Song";
                ResultSet rs = stmt.executeQuery(sql);

                // Loop through rows from the database result set
                while (rs.next()) {

                    //Map DB row to Movie object
                    int id = rs.getInt("Id");
                    String title = rs.getString("Title");
                    String artist = rs.getString("Artist");
                    String genre = rs.getString("Genre");
                    float duration = rs.getFloat("Duration");
                    String path = rs.getString("Path");

                    Song movie = new Song(id, title, artist, genre, duration, path);
                    allMusic.add(movie);
                }
                return allMusic;

            }


            catch (SQLException ex)
            {

                ex.printStackTrace();
                throw new Exception("Could not get movies from database", ex);
            }
        }
}
