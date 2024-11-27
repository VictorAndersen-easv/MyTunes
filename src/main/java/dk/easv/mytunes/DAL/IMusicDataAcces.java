package dk.easv.mytunes.DAL;

import dk.easv.mytunes.BE.Song;

import java.util.List;

public interface IMusicDataAcces {
    List<Song> getAllMusic() throws Exception;
}
