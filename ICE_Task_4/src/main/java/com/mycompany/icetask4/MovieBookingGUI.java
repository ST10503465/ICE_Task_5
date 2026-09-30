/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.icetask4;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.*;

public class MovieBookingGUI extends JFrame
{
    private final JTextField txtTitle;
    private final JTextField txtGenre;
    private final JTextField txtPrice;
    private final JTextField txtCustomer;

    private final JButton btnAddMovie;
    private final JButton btnBookMovie;

    private final JList<String> movieList;
    private final DefaultListModel<String> listModel;

    private final JTextArea bookingArea;

    private final ArrayList<Movie> movies;

    public MovieBookingGUI()
    {
        movies = new ArrayList<>();

        setTitle("Movie Booking System");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Movie details section
        JPanel moviePanel = new JPanel(new GridLayout(4, 2, 5, 5));

        moviePanel.add(new JLabel("Movie Title:"));
        txtTitle = new JTextField();
        moviePanel.add(txtTitle);

        moviePanel.add(new JLabel("Genre:"));
        txtGenre = new JTextField();
        moviePanel.add(txtGenre);

        moviePanel.add(new JLabel("Ticket Price:"));
        txtPrice = new JTextField();
        moviePanel.add(txtPrice);

        btnAddMovie = new JButton("Add Movie");
        moviePanel.add(btnAddMovie);

        // Movie list
        listModel = new DefaultListModel<>();
        movieList = new JList<>(listModel);

        JScrollPane movieScroll =
                new JScrollPane(movieList);

        // Booking section
        JPanel bookingPanel =
                new JPanel(new GridLayout(2, 2, 5, 5));

        bookingPanel.add(new JLabel("Customer Name:"));

        txtCustomer = new JTextField();
        bookingPanel.add(txtCustomer);

        btnBookMovie = new JButton("Book Movie");
        bookingPanel.add(btnBookMovie);

        // Booking confirmation area
        bookingArea = new JTextArea(7, 30);
        bookingArea.setEditable(false);

        JScrollPane bookingScroll =
                new JScrollPane(bookingArea);

        JPanel bottomPanel = new JPanel();

        bottomPanel.setLayout(
                new BoxLayout(bottomPanel,
                        BoxLayout.Y_AXIS));

        bottomPanel.add(bookingPanel);
        bottomPanel.add(bookingScroll);

        // Add everything to window
        add(moviePanel, BorderLayout.NORTH);
        add(movieScroll, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        // Add Movie button
        btnAddMovie.addActionListener(e ->
        {
            addMovie();
        });

        // Book Movie button
        btnBookMovie.addActionListener(e ->
        {
            bookMovie();
        });
    }

    public void addMovie()
    {
        String title = txtTitle.getText();
        String genre = txtGenre.getText();

        if (title.isEmpty()
                || genre.isEmpty()
                || txtPrice.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(
                    this,
                    "Please enter all movie details.");

            return;
        }

        try
        {
            double price =
                    Double.parseDouble(txtPrice.getText());

            Movie movie =
                    new Movie(title, genre, price);

            movies.add(movie);

            listModel.addElement(movie.toString());

            JOptionPane.showMessageDialog(
                    this,
                    "Movie added successfully.");

            txtTitle.setText("");
            txtGenre.setText("");
            txtPrice.setText("");
        }
        catch (NumberFormatException ex)
        {
            JOptionPane.showMessageDialog(
                    this,
                    "Please enter a valid ticket price.");
        }
    }

    public void bookMovie()
    {
        int selectedIndex =
                movieList.getSelectedIndex();

        String customer =
                txtCustomer.getText();

        if (selectedIndex == -1)
        {
            JOptionPane.showMessageDialog(
                    this,
                    "Please select a movie.");

            return;
        }

        if (customer.isEmpty())
        {
            JOptionPane.showMessageDialog(
                    this,
                    "Please enter the customer name.");

            return;
        }

        Movie selectedMovie =
                movies.get(selectedIndex);

        Booking booking =
                new Booking(customer, selectedMovie);

        bookingArea.setText(
                booking.getBookingDetails());

        JOptionPane.showMessageDialog(
                this,
                "Movie booked successfully.");
    }

    public static void main(String[] args)
    {
        MovieBookingGUI gui =
                new MovieBookingGUI();

        gui.setVisible(true);
    }
}