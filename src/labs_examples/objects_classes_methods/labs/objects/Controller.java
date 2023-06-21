package labs_examples.objects_classes_methods.labs.objects;

public class Controller {
    public static void main(String[] args){
        Artist artistOne = new Artist("Elton John", "high");
        Event eventOne = new Event(artistOne);
        System.out.println("Number of attendees at " + eventOne.getArenaName() + " is " + eventOne.getCapacity()); // capacity with no one attending
        try {
            Attendee attendeeOne = new Attendee('F', 29, eventOne);
            System.out.println("attendeeOne's personal and ticket information is: " + attendeeOne);
        } catch (IllegalArgumentException e){
            System.out.println("Failed to create ticket for attendee: " + e.getMessage());
        }

        System.out.println("Number of attendees at " + eventOne.getArenaName() + " is " + eventOne.getCapacity()); // checking if capacity drops
        Artist artistTwo = new Artist("Kaleo", "low");
        Event eventTwo = new Event(artistTwo);
        System.out.println("Number of attendees at " + eventTwo.getArenaName() + " is " + eventTwo.getCapacity()); // capacity with no one attending
        Attendee attendeeTwo = new Attendee('M', 34, eventTwo);

        System.out.println("attendeeTwo's personal and ticket information is: " + attendeeTwo);
        System.out.println("Number of attendees at " + eventTwo.getArenaName() + " is " + eventTwo.getCapacity()); // checking if capacity drops
        System.out.println("attendeeTwo is going to see: " + attendeeTwo.getArena().getArtist().getArtistName());
  }
}

class Attendee {
    private char gender;
    private int age;
    private Event event;

    public Attendee(char gender, int age, Event event) {
        if (event.getCapacity() > 0) { // check availability
            event.decreaseCapacity(); // for every attendee the capacity of the event drops by 1
            this.gender = gender;
            this.age = age;
            this.event = event;
        } else {
            throw new IllegalArgumentException("Sorry, event sold out!"); // won't create object
        }
    }

    public char getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public Event getArena() {
        return event;
    }

    @Override
    public String toString() {
        return "Attendee{" +
                "gender=" + gender +
                ", age=" + age +
                ", event=" + event +
                '}';
    }
}

class Artist {
    private String artistName;
    private int artistPopularity;

    public Artist(String artistName, String artistPopularity) {
        this.artistName = artistName;

        switch (artistPopularity) {
            case "high":
                this.artistPopularity = 1;
                break;
            case "medium":
                this.artistPopularity = 2;
                break;
            case "low":
                this.artistPopularity = 3;
                break;
            default:
                this.artistPopularity = 0;
        }
    }

    public String getArtistName() {
        return artistName;
    }

    public int getArtistPopularity() {
        return artistPopularity;
    }

    @Override
    public String toString() {
        return "Artist{" +
                "artistName='" + artistName + '\'' +
                ", artistPopularity=" + artistPopularity +
                '}';
    }
}

class Event {
    private String arenaName;
    private int capacity;
    private Artist artist;

    public Event(Artist artist) {
        this.artist = artist;
        switch (artist.getArtistPopularity()) {
            case 1:
                this.arenaName = "Tele2";
                this.capacity = 40000;
                break;
            case 2:
                this.arenaName = "Globen";
                this.capacity = 16000;
                break;
            case 3:
                this.arenaName = "Hovet";
                this.capacity = 10000;
                break;
            case 0:
                this.arenaName = "Debaser";
                this.capacity = 100;
                break;
        }
    }

    public String getArenaName() {
        return arenaName;
    }

    public int getCapacity() {
        return capacity;
    }

    public void decreaseCapacity() {
        capacity--;
    }

    public Artist getArtist() {
        return artist;
    }

    @Override
    public String toString() {
        return "Event{" +
                "arenaName='" + arenaName + '\'' +
                ", capacity=" + capacity +
                ", artist=" + artist +
                '}';
    }
}