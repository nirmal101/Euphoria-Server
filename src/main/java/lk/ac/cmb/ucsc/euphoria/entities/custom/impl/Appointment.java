package lk.ac.cmb.ucsc.euphoria.entities.custom.impl;

import lk.ac.cmb.ucsc.euphoria.entities.BaseEntity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@SequenceGenerator(name = "APPOINTMENT_SEQ",allocationSize = 1)
public class Appointment extends BaseEntity {

    @Column
    private LocalDateTime appointmentDateTime;

    @Convert(converter = AppointmentConverter.class)
    private AppointmentStatus appointmentStatus;

    public enum AppointmentStatus {
        APPROVED("A"),
        PENDING("P"),
        CANCELLED("C")
        ;

        private String code;

        AppointmentStatus(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }

        public AppointmentStatus fromCode(String code){
            for (AppointmentStatus o : AppointmentStatus.values()) {
                if (o.getCode().equals(code))
                    return o;
            }
            throw new UnsupportedOperationException("The code '"+code+"' is not supported");
        }
    }
}

/**
 * This class is responsible for converting the enumuration <code>AppointmentStatus</code> to String and vice versa for the ease of
 * mapping in Hibernate
 * */
class AppointmentConverter implements AttributeConverter<Appointment.AppointmentStatus,String>{

    @Override
    public String convertToDatabaseColumn(Appointment.AppointmentStatus appointmentStatus) {
        if (appointmentStatus == null){
            return null;
        }

        return appointmentStatus.getCode();
    }

    @Override
    public Appointment.AppointmentStatus convertToEntityAttribute(String s) {
        return null;
    }
}
