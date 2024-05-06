package main.services;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import main.connection.DatabaseConnection;
import main.model.ModelAppointment;

/**
 *
 * @author malco
 */
public class ServiceAppointment {
    private final Connection conn;
    
    public ServiceAppointment() {
        conn = DatabaseConnection.getInstance().getConnection();
    }
    
    public void createAppoitment(ModelAppointment appointment) throws SQLException {
        PreparedStatement query = conn.prepareStatement(
                "INSERT INTO `appointment` (`date`, `hour`, `endHour`, `patientID`, `receptionistID`, `doctorID`, `serviceID`) "
                        + "VALUES (?, ?, ?, ?, ?, ?, ?)");
        
        query.setDate(1, Date.valueOf(appointment.getDate()));
        query.setTime(2, Time.valueOf(appointment.getHour()));
        query.setTime(3, Time.valueOf(appointment.getEndHour()));
        query.setInt(4, appointment.getPatient_id());
        query.setInt(5, appointment.getReceptionist_id());
        query.setInt(6, appointment.getDoctor_id());
        query.setInt(7, appointment.getService_id());
        
        query.execute();
    }
    
    public ModelAppointment[] getAllUpCommingAppointments() throws SQLException {
        List<ModelAppointment> upCommingAppointemts = new ArrayList<>();
        
        String sql = """
            SELECT * FROM `appointment`
            WHERE `date` > CURDATE() OR (`date` = CURDATE() AND `hour` >= CURTIME())
        """;
        
        try (PreparedStatement query = conn.prepareStatement(sql)) {
            try (ResultSet res = query.executeQuery()) {
                while (res.next()) {
                    int appointementId = res.getInt("appoitmentID");
                    int patientId = res.getInt("patientID");
                    int doctorId = res.getInt("doctorID");
                    int receptionistId = res.getInt("receptionistID");
                    Date date = res.getDate("date");
                    Time hour = res.getTime("hour");
                    
                    ModelAppointment modelAppointment = new ModelAppointment();
                    modelAppointment.setAppointementID(appointementId);
                    modelAppointment.setPatient_id(patientId);
                    modelAppointment.setReceptionist_id(receptionistId);
                    modelAppointment.setDoctor_id(doctorId);
                    modelAppointment.setDate(date.toLocalDate());
                    modelAppointment.setHour(hour.toLocalTime());
                    
                    
                    upCommingAppointemts.add(modelAppointment);
                }
            }
        }
        return upCommingAppointemts.toArray(ModelAppointment[]::new);
    }
}
