package hotelReservation;

public enum Season {
    WINTER(3),
    SUMMER(4),
    SPRING(2),
    AUTUMN(1);

    int coeff;

    Season(int coeff) {
        this.coeff = coeff;
    }

    public int getCoeff() {
        return coeff;
    }

    public void setCoeff(int coeff) {
        this.coeff = coeff;
    }
}


