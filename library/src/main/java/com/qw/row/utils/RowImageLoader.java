package com.qw.row.utils;

import android.widget.ImageView;

/**
 * Created by qinwei on 2019-12-20 11:43
 * email: qinwei_it@163.com
 */
public class RowImageLoader {

    private static IImageLoader imageLoader;

    public static void init(IImageLoader imageLoader) {
        RowImageLoader.imageLoader = imageLoader;
    }

    public static void load(String url, ImageView imageView) {
        if (imageLoader != null) {
            imageLoader.load(url, imageView);
        }
    }

    public interface IImageLoader {
        void load(String url, ImageView imageView);
    }
}


