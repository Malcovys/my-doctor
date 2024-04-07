CREATE TABLE `role` (
	roleID int PRIMARY KEY AUTO_INCREMENT,
    title varchar(60)
);

CREATE TABLE `service` (
	serviceID int PRIMARY KEY AUTO_INCREMENT,
    title varchar(255) NOT NULL,
    price int NOT NULL
);

CREATE TABLE `user` (
	userID int PRIMARY KEY AUTO_INCREMENT,
    roleID int NOT NULL,
    firstName varchar(255),
    lastName varchar(255),
    email varchar(255) NOT NULL,
    telephone varchar(14),
    password varchar(255) NOT NULL,
    FOREIGN KEY (roleID) REFERENCES `role`(roleID)
);

CREATE TABLE `patient` (
	patientID int PRIMARY KEY AUTO_INCREMENT,
    firstName varchar(255),
    lastName varchar(255),
    age int NOT NULL,
    email varchar(255) NOT NULL,
    telephone varchar(14)
);

CREATE TABLE `appointment` (
	appointmentID int PRIMARY KEY AUTO_INCREMENT,
    `date` date NOT NULL,
    patientID int NOT NULL,
    receptionistID int,
    doctorID int NOT NULL,
    FOREIGN KEY (receptionistID) REFERENCES `user`(userID),
    FOREIGN KEY (doctorID) REFERENCES `user`(userID),
    FOREIGN KEY (patientID) REFERENCES `patient`(patientID)
);

CREATE TABLE `appointmentDiagnostic` (
	appointmentDiagnosticID int PRIMARY KEY AUTO_INCREMENT,
    appointmentID int NOT NULL,
    content varchar(255) NOT NULL,
    FOREIGN KEY (appointmentID) REFERENCES `appointment`(appointmentID)
);

CREATE TABLE `appointmentPrescription` (
	prescriptionID int PRIMARY KEY AUTO_INCREMENT,
    appointmentID int NOT NULL,
    content varchar(255) NOT NULL,
    FOREIGN KEY (appointmentID) REFERENCES `appointment`(appointmentID)
);

CREATE TABLE `appointmentService` (
	appointmentServiceID int PRIMARY KEY AUTO_INCREMENT,
    appointmentID int NOT NULL,
    serviceID int NOT NULL,
    FOREIGN KEY (appointmentID) REFERENCES `appointment`(appointmentID),
    FOREIGN KEY (serviceID) REFERENCES `service`(serviceID)
);


DELIMITER //
CREATE TRIGGER check_age
BEFORE INSERT ON `patient`
FOR EACH ROW
BEGIN
  IF NEW.age < 0 THEN
    SIGNAL SQLSTATE '45000'
    SET MESSAGE_TEXT = 'Age cannot be negative';
  END IF;
END;//
DELIMITER ;