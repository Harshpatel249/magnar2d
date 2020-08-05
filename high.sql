-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Apr 15, 2019 at 07:21 AM
-- Server version: 5.7.24
-- PHP Version: 7.2.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `high`
--

-- --------------------------------------------------------

--
-- Table structure for table `tbl_score`
--

DROP TABLE IF EXISTS `tbl_score`;
CREATE TABLE IF NOT EXISTS `tbl_score` (
  `score` int(11) NOT NULL,
  `name` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_score`
--

INSERT INTO `tbl_score` (`score`, `name`) VALUES
(0, 'harsh'),
(0, 'mynameissheila'),
(6741300, 'harsh'),
(16, 'harsh'),
(0, 'null'),
(0, 'null'),
(0, 'null'),
(118, 'Your Dad! Nigga'),
(21, 'jabroescobar'),
(-7, 'jh'),
(-23, 'jabroescobar'),
(-100, 'null'),
(-53, 'yg'),
(-35, 'jabroescobar'),
(9, 'jabroescobar'),
(-57, 'flash'),
(61, 'itsbordie'),
(28, 'asd'),
(-46, 'jabroescobar'),
(-10, 'jabroescobar'),
(-55, 'savitar'),
(-48, 'immature'),
(88, 'hgh'),
(-6, 'JHVSDJH'),
(-30, 'JU'),
(98, 'ValarMorghulis');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
