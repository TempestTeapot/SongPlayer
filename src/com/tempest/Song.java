package com.tempest;

/**
 * Copyright (c) 2018 Omnitracs, LLC. All rights reserved.
 * Confidential and Proprietary – Omnitracs, LLC
 * This software may be subject to U.S. and international export, re-export, or transfer
 * (“export”) laws.
 * Diversion contrary to U.S. and international laws is strictly prohibited.
 * <p>
 * Created by Carla.Hennes on 2/5/2018.
 */
public class Song {
    private String title;
    private double duration;

    public Song(String title, double duration) {
        this.title = title;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return this.title + ": " + this.duration;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }
}
