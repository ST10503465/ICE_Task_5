/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.icetask4;

public class Booking
{
    private final String customerName;
    private final Movie movie;

    public Booking(String customerName, Movie movie)
    {
        this.customerName = customerName;
        this.movie = movie;
    }

    public String getCustomerName()
    {
        return customerName;
    }

    public Movie getMovie()
    {
        return movie;
    }

    public String getBookingDetails()
    {
        return """
               BOOKING CONFIRMED
               Customer: """ + customerName + "\n"
                + "Movie: " + movie.getTitle() + "\n"
                + "Genre: " + movie.getGenre() + "\n"
                + "Ticket Price: R" + movie.getPrice();
    }
}