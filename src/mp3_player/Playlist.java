package mp3_player;

import javax.swing.JOptionPane;
import javazoom.jlgui.basicplayer.BasicPlayer;
import javazoom.jlgui.basicplayer.BasicPlayerException;
import java.io.File;

public class Playlist {

    public Song head;
    public Song tail;
    public Song current;

    private BasicPlayer player;
    public boolean isPaused = false;
    public boolean isPlaying = false;

    public Playlist() {
        player = new BasicPlayer();
    }

    public void addSong(String title, String filePath) {
        Song song = new Song(title, filePath);

        if (head == null) {
            head = tail = current = song;
            tail.next = head;
            head.previous = tail;
        } else {
            tail.next = song;
            song.previous = tail;
            tail = song;
            tail.next = head;
            head.previous = tail;
        }

        JOptionPane.showMessageDialog(null, 
                "Song added to playlist!", "Alert", JOptionPane.INFORMATION_MESSAGE);
    }

    // FIXED PLAY METHOD
  public void play() {
    try {
        if (isPaused) {
            // RESUME from paused point
            player.resume();
            isPaused = false;
            isPlaying = true;
        } else {
            // FIRST TIME PLAY
            player.open(new File(current.filePath));
            player.play();
            isPlaying = true;
            isPaused = false;
        }
    } catch (BasicPlayerException e) {
        e.printStackTrace();
    }
}


    // FIXED PAUSE
   public void pause() {
    try {
        if (isPlaying && !isPaused) {
            player.pause();
            isPaused = true;
            isPlaying = false;
        }
    } catch (BasicPlayerException e) {
        e.printStackTrace();
    }
}


    // FIXED RESUME
    public void resume() {
        try {
            if (isPaused) {
                player.resume();
                isPaused = false;
                isPlaying = true;
            }
        } catch (BasicPlayerException e) {
            e.printStackTrace();
        }
    }

    public void playNext() {
        if (current == null) {
            JOptionPane.showMessageDialog(null, "Playlist empty!");
            return;
        }

        current = current.next;
        isPlaying = false;
        play();
    }

    public void playPrev() {
        if (current == null) {
            JOptionPane.showMessageDialog(null, "Playlist empty!");
            return;
        }

        current = current.previous;
        isPlaying = false;
        play();
    }
}