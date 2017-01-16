import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by johnm on 2017-01-16.
 */

// Once the songs have been added to the playlist, create a menu of options to:-
// Quit,Skip forward to the next song, skip backwards to a previous song.  Replay the current song.

public class Playlist {
    private LinkedList<Song> myList;

    {
        myList = new LinkedList<Song>();
    }

    public LinkedList<Song> getMyList() {
        return myList;
    }

    public boolean addSong(ArrayList<Album> albumList, String name) {
        Song tmp = findSong(albumList, name);
        if (tmp == null) {
            return false;
        } else {
            myList.add(tmp);
            return true;
        }
    }

    public Song findSong(ArrayList<Album> albumList, String songName) {
        int albumSize = albumList.size();

        for (int i = 0; i < albumSize; i++) {
            int songSize = albumList.get(i).getArSong().size();
            for (int j = 0; j < songSize; j++) {
                if (albumList.get(i).getArSong().get(j).getTitle().equals(songName)) {
                    return albumList.get(i).getArSong().get(j);
                }
            }
        }
        System.out.println("oops");
        return null;
    }

    public Song findSong(String songName) {
        for(int i=0; i<myList.size(); i++){
            if(myList.get(i).getTitle().equals(songName)){
                return myList.get(i);
            }
        }
        return null;
    }

    public void printList() {
        for(int i=0; i<myList.size(); i++){
            System.out.println("#" + (i+1)+ " Title : " + myList.get(i).getTitle() );
        }
    }

}
