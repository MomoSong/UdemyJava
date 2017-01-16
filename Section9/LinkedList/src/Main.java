import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;

/**
 * Created by johnm on 2017-01-16.
 */
public class Main {
    static Scanner scanner = new Scanner(System.in);
    static boolean quit = false;
    static ArrayList<Album> myAlbumList = new ArrayList<Album>();
    static Playlist playlist = new Playlist();

    public static void main(String[] args) {
        boolean check = false;
        Song nowSong = null;

        printMenu();


        while(!quit){


            int selection = scanner.nextInt();
            scanner.nextLine();

            switch (selection){
                case 1:
                    System.out.println("Enter new Album name :");
                    String albumName = scanner.nextLine();
                    check = Album.findAlbum(myAlbumList, albumName);
                    if (!check) {
                        myAlbumList.add(new Album(albumName));
                        System.out.println("Album Added Successfully.");
                        break;
                    }else{
                        System.out.println("There is same Album has the name.");
                        break;
                    }

                case 2:
                    System.out.println("Enter Album name, new song name and duration");
                    System.out.print("Album name : \n");
                    String nameOfAlbum = scanner.nextLine();
                    System.out.print("Song name : \n");
                    String songName = scanner.nextLine();
                    System.out.print("Duration : \n");
                    int duration = scanner.nextInt();
                    scanner.nextLine();

                    if(getAlbum(nameOfAlbum)==null){
                        System.out.println("There is no such Album name.");
                        break;
                    }else{
                        Album myAlbum = getAlbum(nameOfAlbum);
                        ArrayList<Song> songList = myAlbum.getArSong();
                        check = myAlbum.findSong(songList, songName);
                        if(!check){
                            myAlbum.getArSong().add(new Song(songName, duration));
                            System.out.println("Song Added Successfully");
                            break;
                        }else{
                            System.out.println("There is same Song has the name.");
                        }
                        break;
                    }
                case 3:
                    System.out.println("Enter song name in your Album.");
                    System.out.print("Song name : \n");
                    String songName1 = scanner.nextLine();
                    check = playlist.addSong(myAlbumList, songName1);
                    if(!check){
                        System.out.println("You only add song what you have one.");
                        break;
                    }else{
                        System.out.println("Song added in playlist");
                        break;
                    }

                case 4:
                    playlist.printList();
                    break;

                case 5:
                    System.out.println("Enter song name in play list.");
                    System.out.print("Song name : \n");
                    String songName2 = scanner.nextLine();
                    nowSong = playlist.findSong(songName2);
                    if(nowSong!=null){
                        System.out.println("now playing... " + nowSong.getTitle());
                        break;
                    }else{
                        System.out.println("No such song in playlist");
                        break;
                    }
                case 6:
                    ListIterator<Song> iList = playlist.getMyList().listIterator();

                    while(!iList.equals(nowSong)){
                        if(nowSong!=null){
                            iList.next();
                        }else{
                            System.out.println("no song playing..play start first");
                        }
                    }

                    if(iList.hasNext()){
                        nowSong = iList.next();
                        System.out.println("now playing... " + nowSong.getTitle());
                        break;
                    }
                    System.out.println("this is end of list");
                    break;

                case 7:
                    ListIterator<Song> iList7 = playlist.getMyList().listIterator();

                    while(!iList7.equals(nowSong)){
                        if(nowSong!=null){
                            iList7.next();
                        }else{
                            System.out.println("no song playing..play start first");
                        }
                    }

                    if(iList7.hasPrevious()){
                        nowSong = iList7.previous();
                        System.out.println("now playing... " + nowSong.getTitle());
                        break;
                    }
                    System.out.println("this is end of list");
                    break;

                case 8:
                    printMenu();
                    break;

                case 9:
                    System.exit('0');

            }

        }

    }

    private static void printMenu(){
        System.out.println("        Menu\n" +
                "        1. add new Album\n" +
                "        2. add new Song\n" +
                "        3. add playlist\n" +
                "        4. print playlist\n" +
                "        5. play\n" +
                "        6. skip forward\n" +
                "        7. skip back\n" +
                "        8. print menu\n" +
                "        9. quit\n"+
                "        Select your action : \n");
    }

    public static Album getAlbum(String name){
        for(int i=0; i<myAlbumList.size(); i++){
            if (myAlbumList.get(i).getName().equals(name)) {
                return myAlbumList.get(i);
            }
        }
        return null;
    }

}
