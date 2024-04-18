-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3308
-- Généré le : mer. 17 avr. 2024 à 11:23
-- Version du serveur : 8.2.0
-- Version de PHP : 8.2.13

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `my_doctor`
--

-- --------------------------------------------------------

--
-- Structure de la table `patient`
--

DROP TABLE IF EXISTS `patient`;
CREATE TABLE IF NOT EXISTS `patient` (
  `patientID` int NOT NULL AUTO_INCREMENT,
  `firstName` varchar(255) DEFAULT NULL,
  `lastName` varchar(255) DEFAULT NULL,
  `bithDate` date NOT NULL,
  `email` varchar(255) NOT NULL,
  `telephone` varchar(14) DEFAULT NULL,
  PRIMARY KEY (`patientID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `role`
--

DROP TABLE IF EXISTS `role`;
CREATE TABLE IF NOT EXISTS `role` (
  `roleID` int NOT NULL AUTO_INCREMENT,
  `title` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`roleID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `role`
--

INSERT INTO `role` (`roleID`, `title`) VALUES
(1, 'admin'),
(2, 'doctor'),
(3, 'receiver');

-- --------------------------------------------------------

--
-- Structure de la table `service`
--

DROP TABLE IF EXISTS `service`;
CREATE TABLE IF NOT EXISTS `service` (
  `serviceID` int NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `price` int NOT NULL,
  PRIMARY KEY (`serviceID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `userID` int NOT NULL AUTO_INCREMENT,
  `roleID` int NOT NULL,
  `userName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `telephone` varchar(14) DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`userID`),
  FOREIGN KEY `roleID` (`roleID`) REFERENCES `role`(`roleID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `user`
--

INSERT INTO `user` (`userID`, `roleID`, `userName`, `email`, `telephone`, `password`) VALUES
(1, 1, NULL, 'admin', NULL, 'admin');
COMMIT;

-- --------------------------------------------------------

--
-- Structure de la table `appointment`
--

DROP TABLE IF EXISTS `appointment`;
CREATE TABLE IF NOT EXISTS `appointment` (
  `appointmentID` int NOT NULL AUTO_INCREMENT,
  `date` date NOT NULL,
  `patientID` int NOT NULL,
  `receptionistID` int DEFAULT NULL,
  `doctorID` int NOT NULL,
  PRIMARY KEY (`appointmentID`),
  FOREIGN KEY `receptionistID` (`receptionistID`) REFERENCES `user`(`userID`),
  FOREIGN KEY `doctorID` (`doctorID`) REFERENCES `user`(`userID`),
  FOREIGN KEY `patientID` (`patientID`) REFERENCES `patient`(`patientID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `appointmentdiagnostic`
--

DROP TABLE IF EXISTS `appointmentdiagnostic`;
CREATE TABLE IF NOT EXISTS `appointmentdiagnostic` (
  `appointmentDiagnosticID` int NOT NULL AUTO_INCREMENT,
  `appointmentID` int NOT NULL,
  `content` varchar(255) NOT NULL,
  PRIMARY KEY (`appointmentDiagnosticID`),
  FOREIGN KEY `appointmentID` (`appointmentID`) REFERENCES `appointment`(`appointmentID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `appointmentprescription`
--

DROP TABLE IF EXISTS `appointmentprescription`;
CREATE TABLE IF NOT EXISTS `appointmentprescription` (
  `prescriptionID` int NOT NULL AUTO_INCREMENT,
  `appointmentID` int NOT NULL,
  `content` varchar(255) NOT NULL,
  PRIMARY KEY (`prescriptionID`),
  FOREIGN KEY `appointmentID` (`appointmentID`) REFERENCES `appointment`(`appointmentID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `appointmentservice`
--

DROP TABLE IF EXISTS `appointmentservice`;
CREATE TABLE IF NOT EXISTS `appointmentservice` (
  `appointmentServiceID` int NOT NULL AUTO_INCREMENT,
  `appointmentID` int NOT NULL,
  `serviceID` int NOT NULL,
  PRIMARY KEY (`appointmentServiceID`),
  FOREIGN KEY `appointmentID` (`appointmentID`) REFERENCES `appointment`(`appointmentID`),
  FOREIGN KEY `serviceID` (`serviceID`) REFERENCES `service`(`serviceID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
