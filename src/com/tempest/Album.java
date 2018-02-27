package com.tempest;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright (c) 2018 Omnitracs, LLC. All rights reserved.
 * Confidential and Proprietary – Omnitracs, LLC
 * This software may be subject to U.S. and international export, re-export, or transfer
 * (“export”) laws.
 * Diversion contrary to U.S. and international laws is strictly prohibited.
 * <p>
 * Created by Carla.Hennes on 2/5/2018.
 */
public class Album {
    private String albumTitle;
    private String artist;
    private ArrayList<Song> albumSongs;

    public Album(String albumTitle, String artist) {
        this.albumTitle = albumTitle;
        this.artist = artist;
        this.albumSongs = new ArrayList<Song>();
    }

    public boolean addSong(String title, double duration){
        if (findSong(title)==null){
            this.albumSongs.add(new Song(title,duration));
            return true;
        }
        return false;
    }

    private Song findSong(String title){
        for (Song checkedSong: this.albumSongs){
            if (checkedSong.getTitle().equals(title)){
                return checkedSong;
            }
        }
        return null;
    }

    public String getAlbumTitle() {
        return albumTitle;
    }

    public String getArtist() {
        return artist;
    }

    public ArrayList<Song> getAlbumSongs() {
        return albumSongs;
    }

    public boolean addToPlayList(int trackNumber, List<Song> playList){
        int index = trackNumber -1;
        if ((index>=0) && (index < this.albumSongs.size())) {
            playList.add(this.albumSongs.get(index));
//            System.out.println("Added " + this.albumSongs.get(index).getTitle());
            return true;
        }
//        System.out.println("This album does not have a track " + trackNumber + "for album" + albumTitle);
        return false;
    }

    public boolean addToPlayList (String title, List<Song> playList){
        Song checkedSong = findSong(title);
        if (checkedSong != null){
            playList.add(checkedSong);
//            System.out.println("Added " + checkedSong.getTitle());
            return true;
        }
//        System.out.println("The song " + title + " isn't in that album.");
        return false;
    }

}

