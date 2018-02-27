package com.tempest;

import java.util.ArrayList;

/**
 * Copyright (c) 2018 Omnitracs, LLC. All rights reserved.
 * Confidential and Proprietary – Omnitracs, LLC
 * This software may be subject to U.S. and international export, re-export, or transfer
 * (“export”) laws.
 * Diversion contrary to U.S. and international laws is strictly prohibited.
 * <p>
 * Created by Carla.Hennes on 2/5/2018.
 */
public class Playlist {
    private ArrayList<Album> albums;
    private String playListName;

    public Playlist(String playListName) {
        this.albums = new ArrayList<Album>();
        this.playListName = playListName;
    }

    public ArrayList<Album> getAlbums() {
        return albums;
    }

    public String getPlayListName() {
        return playListName;
    }


}
