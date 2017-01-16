import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by johnm on 2017-01-16.
 */
// The program will have an Album class containing a list of songs.
// The albums will be stored in an ArrayList
public class Album {
    private String name;
    private ArrayList<Song> arSong;

    {this.arSong = new ArrayList<Song>();}

    public Album(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Song> getArSong() {
        return arSong;
    }

    public boolean addAlbum(ArrayList<Album> thisList, String name){
        boolean check = false;
        check = this.findAlbum(thisList, name);
        if(check){
            thisList.add(new Album(name));
            return true;
        }
        return false;
    }

    public static boolean findAlbum(ArrayList<Album> thisList, String name){
        if(thisList.size() == 0) return false;
        boolean check = false;
        Iterator<Album> iList = thisList.iterator();
        while(iList.hasNext()){
            if (iList.next().getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public boolean findSong(ArrayList<Song> thisList, String name){
        if(thisList.size() == 0) return false;
        boolean check = false;
        Iterator<Song> iList = thisList.iterator();
        while(iList.hasNext()){
            if (iList.next().getTitle().equals(name)) {
                return true;
            }
        }
        return false;
    }



}
