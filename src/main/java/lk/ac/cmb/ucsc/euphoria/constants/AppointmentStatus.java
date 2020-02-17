package lk.ac.cmb.ucsc.euphoria.constants;

public enum AppointmentStatus {
    PENDING("pending"), ONGOING("ongoing"), COMPLETED("completed"), REJECTED("rejected"), ACCEPTED("accepted"),ALL("all");

    String value;
    AppointmentStatus(String s) {
        this.value =s;
    }

    public String value() {
        return value;
    }

    public static AppointmentStatus fromValue(String value){
        for (AppointmentStatus s : AppointmentStatus.values()) {
            if (s.value().equals(value))
                return s;
        }
        throw new UnsupportedOperationException("The value "+value+" is not of a supported state");
    }
}


