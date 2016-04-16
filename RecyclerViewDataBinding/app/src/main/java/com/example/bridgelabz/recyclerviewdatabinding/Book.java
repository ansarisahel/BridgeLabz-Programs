package com.example.bridgelabz.recyclerviewdatabinding;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.example.bridgelabz.recyclerviewdatabinding.BR;

/**
 * Created by bridgelabz on 12/3/16.
 */
public class Book extends BaseObservable {
    String title;
    String author;

    public Book(String title, String author)
    {
        this.title = title;
        this.author = author;
    }

    @Bindable
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
        notifyPropertyChanged(BR.title);
    }

    @Bindable
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
        notifyPropertyChanged(BR.author);
    }
}
