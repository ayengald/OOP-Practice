package com.assignment13;

public enum Planet {

    MERCURY (1),
    VENUS   (2),
    EARTH   (3),
    MARS   (4),
    JUPITER   (5),
    SATURN   (6),
    URANUS   (7),
    NEPTUNE   (8);

    //variables
    private int position;
    private String ending;

    //constructors
    Planet(int position){
        this.position = position;

        switch (position) {
            case 1:
                ending = "st";
                break;
            case 2:
                ending = "nd";
                break;
            case 3:
                ending = "rd";
                break;
            default:
                ending = "th";
                break;
        }
    }

    //methods
    public int getPosition(){
        return position;
    }

    public String getEnding(){
        return ending;
    }

}
