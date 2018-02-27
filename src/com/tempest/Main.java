package com.tempest;

import java.util.*;

/**
 * Copyright (c) 2018 Omnitracs, LLC. All rights reserved.
 * Confidential and Proprietary – Omnitracs, LLC
 * This software may be subject to U.S. and international export, re-export, or transfer
 * (“export”) laws.
 * Diversion contrary to U.S. and international laws is strictly prohibited.
 * <p>
 * Created by Carla.Hennes on 2/5/2018.
 */
public class Main {

    public static ArrayList<Album> albums = new ArrayList<Album>();


    public static void main(String[] args) {

        Album myAlbum = new Album("The Grand Illusion","Styx");

        myAlbum.addSong("The Grand Illusion",4.37 );
        myAlbum.addSong("Fooling Yourself",5.30);
        myAlbum.addSong("Come Sail Away",6.05 );
        albums.add(myAlbum);

        myAlbum = new Album("Paradise Theatre", "Styx");
        myAlbum.addSong("Too Much Time on my Hands",4.33);
        albums.add(myAlbum);

        addAlbum("Guilty as Charged","The Gavinners");
        myAlbum = findAlbum("Guilty as Charged");
        myAlbum.addSong("The Guitar's Serenade",2.00);

        LinkedList<Song> playList = new LinkedList<Song>();
        albums.get(0).addToPlayList("Come Sail Away",playList);
        albums.get(0).addToPlayList(1,playList);
        albums.get(0).addToPlayList(2,playList);
        albums.get(0).addToPlayList(3,playList);
        albums.get(0).addToPlayList(4,playList);
        albums.get(1).addToPlayList(1,playList);
        albums.get(2).addToPlayList(1,playList);

        printMenu();

        play(playList);


    }

    public static void printMenu(){
        System.out.println("0 quit, 1 forward, 2 backward, 3 repeat, 4 remove song, 5 print albums, 6 print playlist, 7 print menu");
    }

    public static void printAlbumList(){
        for (Album album : albums)
        {
            System.out.println(album.getAlbumTitle() + " by " + album.getArtist());

        }
    }

    public static boolean addAlbum(String albumTitle, String artist){
        if (findAlbum(albumTitle)==null){
            albums.add(new Album(albumTitle,artist));
            return true;
        }
        return false;
    }

    private static Album findAlbum(String albumTitle){
        for (Album checkedAlbum: albums){
            if (checkedAlbum.getAlbumTitle().equals(albumTitle)){
//                System.out.println("Looked for album: " + albumTitle + "\nFound the album " + checkedAlbum.getAlbumTitle());
                return checkedAlbum;
            }
        }
//        System.out.println("Didn't find the album");
        return null;
    }

    private static void play(List<Song> playList){
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;

        ListIterator<Song> listIterator = playList.listIterator();
        if (playList.size()==0){
            System.out.println("No songs in playlist");
            return;
        } else {
            System.out.println("Now playing " + listIterator.next().toString());
        }

        while (!quit){

            int action = scanner.nextInt();
            scanner.nextLine();
            switch (action){
                case 0:
                    System.out.println("Playlist finished");
                    quit = true;
                    break;
                case 1:
                    if (!forward){
                        if (listIterator.hasNext()){
                            listIterator.next();
                        }
                        forward = true;
                    }
                    if (listIterator.hasNext()){
                        System.out.println("Now playing " + listIterator.next().toString());
                        printMenu();
                    } else {
                        System.out.println("End of playlist");
                        printMenu();
                        forward = false;
                    }
                    break;
                case 2:
                    if (forward){
                        if (listIterator.hasPrevious()){
                            listIterator.previous();
                        }
                        forward = false;
                    }
                    if (listIterator.hasPrevious()){
                        System.out.println("Now playing " + listIterator.previous().toString());
                        printMenu();
                    } else {
                        System.out.println("Beginning of playlist");
                        printMenu();
                        forward = true;
                    }
                    break;
                case 3:
                    if (forward){
                        if (listIterator.hasPrevious()){
                            System.out.println("Now replaying: " + listIterator.previous().toString());
                            forward = false;
                        } else {
                            System.out.println("No previous song to repeat");
                        }
                    }else {
                        if (listIterator.hasNext()){
                            System.out.println("Now replaying " + listIterator.next().toString());
                            forward = true;
                        } else {
                            System.out.println("No previous song to repeat");
                        }
                    }
                    break;
                case 4:
                    if (playList.size()>0){
                        listIterator.remove();
                        if (listIterator.hasNext()){
                            System.out.println("Now playing " + listIterator.next());
                        } else if (listIterator.hasPrevious()) {
                            System.out.println("Now playing " + listIterator.previous());
                        }
                    }
                    break;
                case 5:
                    printAlbumList();
                    printMenu();
                    break;
                case 6:
                    printPlayList(playList);
                    printMenu();
                    break;
                case 7:
                    printMenu();
                    break;
            }
        }
    }

    private static void printPlayList(List<Song> playList){
        Iterator<Song> iterator = playList.iterator();
        for (int i = 0; i < playList.size(); i++) {
            if (playList.size()==0){
                System.out.println("No songs in playlist");
            } else {
                System.out.println("Song " + (i+1) + ": " + iterator.next().toString());
            }
        }
    }

}
