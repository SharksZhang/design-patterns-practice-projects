package model;

import model.media.AbstractMedia;
import model.media.Movie;
import model.media.Photo;
import model.media.Song;

import java.util.ArrayList;
import java.util.Iterator;

public class iPod implements Iterable<AbstractMedia> {

    private String name;

    // TODO: add fields here which represent this iPod's Movies, Photos, and Songs, they should be of the Collection type
    private ArrayList<Movie> movies = new ArrayList<>();
    private ArrayList<Photo> photos = new ArrayList<>();
    private ArrayList<Song> songs = new ArrayList<>();

    public iPod(String name) {
        this.name = name;
    }

    // getters
    public String getName() { return name; }

    public void addMovie(Movie movie){
        if (!movies.contains(movie)){
            movies.add(movie);
        }
    }

    public void addPhoto(Photo photo){
        if(!photos.contains(photo)){
            photos.add(photo);
        }
    }

    public void addSong(Song song){
        if(!songs.contains(song)){
            songs.add(song);
        }
    }


    @Override
    public Iterator iterator() {
        return new IpodIterator();
    }

    private class IpodIterator implements Iterator<AbstractMedia> {

        Iterator songIterator = songs.iterator();
        Iterator movieIterator = movies.iterator();
        Iterator photoIterator = photos.iterator();


        @Override
        public boolean hasNext() {
            return songIterator.hasNext() || movieIterator.hasNext() || photoIterator.hasNext();
        }

        @Override
        public AbstractMedia next() {
            AbstractMedia am = null;
            if (songIterator.hasNext()){
                am =  (Song)songIterator.next();
            }else if (movieIterator.hasNext()){
                am =  (Movie)movieIterator.next();
            }else{
                am =  (Photo)photoIterator.next();
            }
            return am;
        }
    }
}