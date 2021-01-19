-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 19, 2021 at 09:00 PM
-- Server version: 10.4.13-MariaDB
-- PHP Version: 7.4.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `gestionformations`
--

-- --------------------------------------------------------

--
-- Table structure for table `employé`
--

CREATE TABLE `employé` (
  `id_employee` int(200) NOT NULL,
  `matricule` varchar(200) NOT NULL,
  `nom` varchar(200) NOT NULL,
  `prénom` varchar(200) NOT NULL,
  `login` varchar(200) NOT NULL,
  `mot_de_passe` varchar(200) NOT NULL,
  `ville` varchar(200) NOT NULL,
  `type` varchar(200) NOT NULL,
  `Request` varchar(200) NOT NULL,
  `code_formation` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `employé`
--

INSERT INTO `employé` (`id_employee`, `matricule`, `nom`, `prénom`, `login`, `mot_de_passe`, `ville`, `type`, `Request`, `code_formation`) VALUES
(1, 'Agadir', 'CHERKAOUI', 'YASSINE', 'admin', 'admin', 'AD123', 'Admin', 'Admin', ''),
(9, 'ATY121', 'Cherkaoui', 'Yassine', 'yassine', 'yassine', 'Safi', 'Employee', 'Complate', 'AD454'),
(34, 'a', 'a', 'a', 'a', 'a', 'a', 'Employee', 'Incomplate', ''),
(35, 'YA121', 'YASSINE', 'CHERKAOUI', 'yassinee', 'yassinee', 'AGADIR', 'Employee', 'Complate', 'AD144'),
(36, 'sm', 'sm', 'sm', 'sm', 'sm', 'agadir', 'Employee', 'Complate', 'AD123');

-- --------------------------------------------------------

--
-- Table structure for table `formation`
--

CREATE TABLE `formation` (
  `id_formation` int(200) NOT NULL,
  `code` varchar(200) NOT NULL,
  `libellé` varchar(200) NOT NULL,
  `description` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `formation`
--

INSERT INTO `formation` (`id_formation`, `code`, `libellé`, `description`) VALUES
(1, 'AD123', 'Formation centre d\'appel', 'Parcourez sur cette page toutes nos offres de formation centre d\'appel. Ces formations professionnelles sont disponibles partout en France en présentiel ou de chez vous grâce au e-learning. Comparez toutes ces offres et trouvez celle qui répond à tous vos critères. Lorsque vous avez trouvé votre formation vous pouvez remplir un formulaire de demande de renseignements. '),
(2, 'AD112', 'comptabilité', 'le bachelor de comptabilité/\r\nla licence pro de comptabilité/\r\nla licence de comptabilité/\r\nle Diplôme de Comptabilité et Gestion (DCG).'),
(4, 'AD122', 'technicien informatique', 'Gérez le matériel du parc informatique, déployez des postes de travail et apportez un support aux utilisateurs'),
(5, 'AD124', 'Développeur Web', 'Faites vos premiers pas dans le monde du développement web : créez des sites web et donnez vie aux maquettes !'),
(6, 'AD144', 'Data Analyst', 'Découvrez pas à pas le monde de la Data Science : préparez, analysez et modélisez des données.'),
(7, 'AD212', 'Développeur Salesforce', 'Préparez votre certification de développeur Salesforce et codez en Apex pour construire des applications.'),
(10, 'AD213', 'Chef de projet digital', 'Coordonnez des équipes pluridisciplinaires dans la réalisation de projets numériques.'),
(11, 'AD332', 'Développeur d\'application - Android', 'Devenez développeur et réalisez vos applications pour Android.'),
(12, 'AD343', 'Développeur Front-End', 'Réalisez des projets web de A à Z et spécialisez-vous dans l\'optimisation des interfaces de vos sites.'),
(13, 'AD432', 'Architecte logiciel', 'Devenez un expert dans le développement logiciel en concevant des solutions complexes.'),
(14, 'AD323', 'Développeur d\'application - iOS', 'Découvrez le développement iOS et réalisez des applications taillées pour l\'iPhone et l\'iPad !'),
(15, 'AD454', 'Développeur d\'application - Java', 'Devenez développeur d\'applications avec Java, l\'un des langages les plus utilisés au monde.'),
(16, 'AD322', 'Développeur d\'application - PHP / Symfony', 'Devenez développeur et constituez votre portfolio en réalisant des applications avec PHP.\r\n\r\n');

-- --------------------------------------------------------

--
-- Table structure for table `session`
--

CREATE TABLE `session` (
  `id_session` int(200) NOT NULL,
  `id_employee` int(200) NOT NULL,
  `code` varchar(200) NOT NULL,
  `libellé` varchar(200) NOT NULL,
  `formation` varchar(200) NOT NULL,
  `Mois` varchar(200) NOT NULL,
  `annee` int(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `session`
--

INSERT INTO `session` (`id_session`, `id_employee`, `code`, `libellé`, `formation`, `Mois`, `annee`) VALUES
(10, 10, 'AA121', 'AA121', 'technicien informatique', '5', 2021),
(35, 35, '1323', '1231', 'Data Analyst', '05', 1223),
(9, 9, 'AZA', 'AZA', 'Développeur Web', '04', 2022),
(36, 36, 'ada11', 'ada11', 'Développeur Web', '05', 2022);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `employé`
--
ALTER TABLE `employé`
  ADD PRIMARY KEY (`id_employee`);

--
-- Indexes for table `formation`
--
ALTER TABLE `formation`
  ADD PRIMARY KEY (`id_formation`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `employé`
--
ALTER TABLE `employé`
  MODIFY `id_employee` int(200) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=37;

--
-- AUTO_INCREMENT for table `formation`
--
ALTER TABLE `formation`
  MODIFY `id_formation` int(200) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
