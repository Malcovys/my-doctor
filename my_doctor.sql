-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3308
-- Généré le : mar. 14 mai 2024 à 17:41
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
-- Structure de la table `appointment`
--

DROP TABLE IF EXISTS `appointment`;
CREATE TABLE IF NOT EXISTS `appointment` (
  `appointmentID` int NOT NULL AUTO_INCREMENT,
  `date` date NOT NULL,
  `hour` time NOT NULL,
  `endHour` time NOT NULL,
  `patientID` int NOT NULL,
  `doctorID` int NOT NULL,
  `serviceID` int NOT NULL,
  `appoitement_statusID` int NOT NULL DEFAULT '1',
  PRIMARY KEY (`appointmentID`),
  KEY `doctorID` (`doctorID`),
  KEY `patientID` (`patientID`),
  KEY `serviceID` (`serviceID`),
  KEY `appoitement_statusID` (`appoitement_statusID`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `appointment`
--

INSERT INTO `appointment` (`appointmentID`, `date`, `hour`, `endHour`, `patientID`, `doctorID`, `serviceID`, `appoitement_statusID`) VALUES
(12, '2024-04-30', '08:30:00', '08:50:00', 5, 2, 1, 2),
(13, '2024-05-06', '16:00:00', '16:15:00', 5, 3, 2, 2),
(14, '2024-05-08', '07:30:00', '07:50:00', 5, 2, 3, 2),
(15, '2024-05-09', '08:30:00', '08:50:00', 5, 2, 1, 2),
(16, '2024-05-08', '16:30:00', '16:50:00', 5, 3, 3, 2),
(17, '2024-05-09', '14:30:00', '14:50:00', 5, 2, 1, 3),
(18, '2024-05-10', '18:00:00', '18:20:00', 5, 3, 1, 3),
(19, '2024-05-09', '05:31:00', '05:51:00', 5, 2, 1, 3),
(20, '2024-05-13', '08:00:00', '09:00:00', 5, 10, 4, 1),
(21, '2024-05-13', '11:04:00', '11:24:00', 5, 2, 1, 2),
(22, '2024-05-14', '08:21:00', '08:36:00', 5, 2, 2, 1);

-- --------------------------------------------------------

--
-- Structure de la table `appoitementstatus`
--

DROP TABLE IF EXISTS `appoitementstatus`;
CREATE TABLE IF NOT EXISTS `appoitementstatus` (
  `appoitement_statusID` int NOT NULL AUTO_INCREMENT,
  `status` varchar(15) NOT NULL,
  PRIMARY KEY (`appoitement_statusID`),
  UNIQUE KEY `status` (`status`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `appoitementstatus`
--

INSERT INTO `appoitementstatus` (`appoitement_statusID`, `status`) VALUES
(1, 'à venir'),
(3, 'annuler'),
(2, 'terminer');

-- --------------------------------------------------------

--
-- Structure de la table `facture`
--

DROP TABLE IF EXISTS `facture`;
CREATE TABLE IF NOT EXISTS `facture` (
  `factureID` int NOT NULL AUTO_INCREMENT,
  `appoitmentID` int NOT NULL,
  `isPaid` tinyint(1) NOT NULL DEFAULT '0',
  `date` date NOT NULL,
  PRIMARY KEY (`factureID`),
  UNIQUE KEY `appoitmentID` (`appoitmentID`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `facture`
--

INSERT INTO `facture` (`factureID`, `appoitmentID`, `isPaid`, `date`) VALUES
(6, 13, 1, '2024-05-10'),
(7, 12, 1, '2024-05-11'),
(8, 14, 1, '2024-05-11'),
(9, 15, 1, '2024-05-11'),
(10, 16, 1, '2024-05-11'),
(11, 21, 1, '2024-05-13');

--
-- Déclencheurs `facture`
--
DROP TRIGGER IF EXISTS `set_date_to_current_date`;
DELIMITER $$
CREATE TRIGGER `set_date_to_current_date` BEFORE INSERT ON `facture` FOR EACH ROW SET NEW.date = CURDATE()
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Structure de la table `patient`
--

DROP TABLE IF EXISTS `patient`;
CREATE TABLE IF NOT EXISTS `patient` (
  `patientID` int NOT NULL AUTO_INCREMENT,
  `firstName` varchar(255) DEFAULT NULL,
  `lastName` varchar(255) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `telephone` varchar(14) DEFAULT NULL,
  PRIMARY KEY (`patientID`),
  UNIQUE KEY `telephone` (`telephone`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `patient`
--

INSERT INTO `patient` (`patientID`, `firstName`, `lastName`, `email`, `telephone`) VALUES
(5, 'Bonely', 'Malcovys', 'malcovys@gmail.com', '0328271024'),
(6, 'Some', 'Pauline', 'paulineSoma@gmail.com', '0325149174');

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
  `duration` time NOT NULL,
  PRIMARY KEY (`serviceID`),
  UNIQUE KEY `title` (`title`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `service`
--

INSERT INTO `service` (`serviceID`, `title`, `price`, `duration`) VALUES
(1, 'consultation', 10000, '00:20:00'),
(2, 'picure', 30000, '00:15:00'),
(3, 'suivie', 0, '00:20:00'),
(4, 'lavage oreil', 30000, '01:00:00');

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `userID` int NOT NULL AUTO_INCREMENT,
  `roleID` int NOT NULL,
  `userName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `telephone` varchar(14) DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`userID`),
  UNIQUE KEY `userName` (`userName`),
  UNIQUE KEY `email` (`email`),
  KEY `roleID` (`roleID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `user`
--

INSERT INTO `user` (`userID`, `roleID`, `userName`, `email`, `telephone`, `password`) VALUES
(1, 1, '', 'admin', NULL, 'admin'),
(2, 2, 'dorcteur 1', 'dorcteur1@gmail.coù', '0328884208', 'docteur1'),
(3, 2, 'docteur 2', 'docteur2@gmail.com', '0342252760', 'docteur2'),
(5, 3, 'receptioniste 1', 'receptioniste1@gmail.com', '0265658575', 'receptioniste1'),
(6, 3, 'recep', 'recep@gmail.com', '0327102423', 'recep'),
(8, 3, 'reception', 'reception@gmail.com', '0327102423', 'reception'),
(9, 2, 'doc', 'doc@gmail.com', '0328263178', 'doc'),
(10, 2, 'docky', 'docky@gmail.com', '0324568545', 'docky');

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `appointment`
--
ALTER TABLE `appointment`
  ADD CONSTRAINT `appointment_ibfk_2` FOREIGN KEY (`doctorID`) REFERENCES `user` (`userID`),
  ADD CONSTRAINT `appointment_ibfk_3` FOREIGN KEY (`patientID`) REFERENCES `patient` (`patientID`),
  ADD CONSTRAINT `appointment_ibfk_4` FOREIGN KEY (`serviceID`) REFERENCES `service` (`serviceID`),
  ADD CONSTRAINT `appointment_ibfk_5` FOREIGN KEY (`appoitement_statusID`) REFERENCES `appoitementstatus` (`appoitement_statusID`);

--
-- Contraintes pour la table `facture`
--
ALTER TABLE `facture`
  ADD CONSTRAINT `facture_ibfk_1` FOREIGN KEY (`appoitmentID`) REFERENCES `appointment` (`appointmentID`);

--
-- Contraintes pour la table `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `user_ibfk_1` FOREIGN KEY (`roleID`) REFERENCES `role` (`roleID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
