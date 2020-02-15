package lk.ac.cmb.ucsc.euphoria.util;

import lk.ac.cmb.ucsc.euphoria.constants.AppointmentStatus;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class AppointmentStatusConverter implements AttributeConverter<AppointmentStatus,String> {

    @Override
    public String convertToDatabaseColumn(AppointmentStatus appointmentStatus) {
        if (appointmentStatus == null){
            return null;
        }
        return appointmentStatus.value();
    }

    @Override
    public AppointmentStatus convertToEntityAttribute(String s) {
        if (s == null){
            return null;
        }
        return AppointmentStatus.fromValue(s);
    }
}
