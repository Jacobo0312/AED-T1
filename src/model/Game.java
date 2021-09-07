package model;

import java.util.ArrayList;

public class Game {

    private int code;
    private String name;
    private String platform;
    private int year;
    private String genre;
    private String publisher;
    private double score;
    private ArrayList<String> reviews;


    public Game(int code, String name, String platform, int year, String genre, String publisher) {
        this.code = code;
        this.name = name;
        this.platform = platform;
        this.year = year;
        this.genre = genre;
        this.publisher = publisher;
        this.score =  Math.random()*10;
        this.reviews = new ArrayList<>();
        reviews.add("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");
    }


    public int getCode() {
        return this.code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlatform() {
        return this.platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public int getYear() {
        return this.year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getGenre() {
        return this.genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPublisher() {
        return this.publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public double getScore() {
        return this.score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public ArrayList<String> getReviews() {
        return this.reviews;
    }

    public void setReviews(ArrayList<String> reviews) {
        this.reviews = reviews;
    }


    @Override
    public String toString() {
        return "{" +
            " code='" + getCode() + "'" +
            ", name='" + getName() + "'" +
            ", platform='" + getPlatform() + "'" +
            ", year='" + getYear() + "'" +
            ", genre='" + getGenre() + "'" +
            ", publisher='" + getPublisher() + "'" +
            ", score='" + getScore() + "'" +
            ", reviews='" + getReviews() + "'" +
            "}";
    }
    



    
}
