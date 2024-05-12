package main.model;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author malco
 */
public class ModelService {

    private int id;
    private String title;
    private int price;
    private LocalTime duration;
    
    DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("HH:mm");

    public ModelService(String title, String duration, int price) {
        this.title = title;
        this.price = price;
        this.duration = LocalTime.parse(duration, timeFormat);
        this.id = -1;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public int getPrice() {
        return price;
    }

    public LocalTime getDuration() {
        return duration;
    } 
}
