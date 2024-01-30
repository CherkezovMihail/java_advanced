package trafficLights;

public class TrafficLight {
    private String color;

    public TrafficLight(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void updatelight() {

        switch (color) {
            case "GREEN":
                setColor("YELLOW");
                break;
            case "RED":
                setColor("GREEN");
                break;
            case "YELLOW":
                setColor("RED");
                break;
        }
        System.out.print(getColor() + " ");
    }
}
