/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mp3_player;

/**
 *
 * @author paulanthony
 */
public class Song {
    String title;
    String filePath;
    Song next;
    Song previous;
    
    public Song(String title, String filePath){
        this.title = title;
        this.filePath = filePath;
        this.next = null;
        this.previous = null;
    
    }
}
