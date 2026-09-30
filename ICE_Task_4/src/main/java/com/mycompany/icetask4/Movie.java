/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.icetask4;

public class Movie
{
    private final String title;
    private final String genre;
    private final double price;

    public Movie(String title, String genre, double price)
    {
        this.title = title;
        this.genre = genre;
        this.price = price;
    }

    public String getTitle()
    {
        return title;
    }

    public String getGenre()
    {
        return genre;
    }

    public double getPrice()
    {
        return price;
    }

    @Override
    public String toString()
    {
        return title + " - " + genre + " - R" + price;
    }
}