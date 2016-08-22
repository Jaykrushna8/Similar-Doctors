-- phpMyAdmin SQL Dump
-- version 4.5.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Aug 22, 2016 at 04:24 PM
-- Server version: 5.7.11
-- PHP Version: 5.6.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `doctors`
--

-- --------------------------------------------------------

--
-- Table structure for table `doctor_information`
--

CREATE TABLE `doctor_information` (
  `Id` int(11) DEFAULT NULL,
  `Firstname` varchar(30) DEFAULT NULL,
  `Lastname` varchar(30) DEFAULT NULL,
  `Specialty` varchar(40) DEFAULT NULL,
  `City` varchar(30) DEFAULT NULL,
  `Reviewscore` double(10,2) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `doctor_information`
--

INSERT INTO `doctor_information` (`Id`, `Firstname`, `Lastname`, `Specialty`, `City`, `Reviewscore`) VALUES
(1, 'Sachin', 'Jagar', 'General', 'Sunnyvale', 3.20),
(2, 'Jay', 'Patel', 'oncology', 'Newyork', 3.00),
(3, 'Chirayu', 'Shah', 'accupuncture', 'Chicago', 2.90),
(4, 'Prashant', 'Patel', 'Pathology', 'Cleveland', 4.00),
(5, 'Archit', 'Trivedi', 'Pediatrist', 'Santa Clara', 4.10),
(6, 'Rohan', 'Patel', 'Pediatrist', 'Columbus', 1.90),
(7, 'Sandy', 'Joshi', 'General', 'Boston', 4.10),
(8, 'Bhargav', 'Dabhi', 'oncology', 'San Jose', 2.50),
(9, 'Nisarg', 'Patel', 'General', 'Jersey City', 4.20),
(10, 'Abhay', 'Raval', 'Gyno', 'Cleveland', 3.20),
(11, 'Mohit', 'Moradiya', 'Gyno', 'Columbus', 3.10),
(12, 'Saj', 'Desai', 'General', 'Pennsylvania', 3.10),
(13, 'Nihar', 'Sheth', 'oncology', 'Redwood', 2.50),
(14, 'Annie', 'Myers', 'accupuncture', 'Pennsylvania', 3.00),
(15, 'Mohan', 'Misra', 'Pediatrist', 'Cleveland', 2.90),
(16, 'Sunny', 'Lawrence', 'Pathology', 'Newyork', 3.10),
(17, 'Jenil', 'Shah', 'Gyno', 'Chicago', 3.20),
(18, 'Laura', 'Bretan', 'General', 'Sunnyvale', 4.10),
(19, 'Julia', 'Scotti', 'oncology', 'Boston', 1.90),
(20, 'Keith', 'Scotti', 'Pediatrist', 'Redwood', 1.90),
(21, 'Hugh', 'Jass', 'Pathology', 'San Jose', 2.90),
(22, 'Mike', 'Rotch', 'General', 'Jersey City', 2.90),
(23, 'Jack', 'Mehoff', 'accupuncture', 'Chicago', 2.90),
(24, 'Amanda', 'Hugginkiss', 'Ortho', 'Sunnyvale', 2.20),
(25, 'Seymour', 'Butz', 'General', 'Jersey City', 1.90),
(26, 'Anita', 'Bhatia', 'Ortho', 'Redwood', 2.50),
(27, 'Holden', 'Strap', 'Pediatrist', 'Pennsylvania', 4.10),
(28, 'Hung', 'Lo', 'accupuncture', 'Boston', 4.20),
(29, 'Oliver', 'Queen', 'Ortho', 'Chicago', 2.50),
(30, 'Helen', 'Dung', 'Pathology', 'Newyork', 3.00),
(31, 'Sum', 'Yung', 'oncology', 'Columbus', 2.50),
(32, 'Maya', 'Bedd', 'Pathology', 'Texas', 4.10),
(33, 'Homer', 'Tang', 'Gyno', 'Cleveland', 2.30),
(34, 'George', 'Taco', 'accupuncture', 'Newyork', 4.10),
(35, 'Tally', 'Ban', 'Pediatrist', 'Chicago', 2.30),
(36, 'Noleg', 'Sorarms', 'Hematologist', 'Texas', 4.10),
(37, 'Diana', 'Hart', 'Physiatrist', 'Redwood', 2.30),
(38, 'Julian', 'Rampling', 'Hematologist', 'Chicago', 2.00),
(39, 'John', 'King', 'Physiatrist', 'Pennsylvania', 2.30),
(40, 'Joe', 'Martin', 'General', 'Sunnyvale', 2.00),
(41, 'Ann', 'Baker', 'Physiatrist', 'Jersey City', 3.20),
(42, 'Bella', 'Martin', 'Gyno', 'Santa Clara', 3.10),
(43, 'Alan', 'Turing', 'Hematologist', 'Redwood', 3.20),
(44, 'Pippa', 'Taylor', 'Pediatrist', 'Santa Clara', 3.10),
(45, 'Taylor', 'Swift', 'Physiatrist', 'Palo Alto', 1.90),
(46, 'Lisa', 'Hudson', 'oncology', 'Santa Clara', 2.00),
(47, 'Alison', 'White', 'Nephrologist', 'Las Vegas', 2.40),
(48, 'Oliva', 'Broyles', 'Hematologist', 'Chicago', 1.90),
(49, 'Andrea', 'Moh', 'Nephrologist', 'Cleveland', 2.40),
(50, 'Gordon', 'White', 'accupuncture', 'Columbus', 2.80),
(51, 'JK', 'Patel', 'Nephrologist', 'Des Moines', 4.80),
(52, 'Anil', 'Wilson', 'Obstetrician', 'Newyork', 2.80),
(53, 'Warren', 'Walker', 'Nephrologist', 'Palo Alto', 4.30),
(54, 'Steven', 'Young', 'Obstetrician', 'Des Moines', 2.80),
(55, 'Charles', 'Ross', 'Pediatrist', 'Palo Alto', 4.30),
(56, 'Lean', 'Willian', 'Nephrologist', 'Cleveland', 2.50),
(57, 'Paul', 'Hemming', 'Obstetrician', 'Des Moines', 2.50),
(58, 'Dom', 'Colemn', 'Hematologist', 'Jersey City', 2.80),
(59, 'Grace', 'Young', 'Obstetrician', 'Redwood', 4.40),
(60, 'Caroline', 'Greak', 'oncology', 'San Jose', 1.50),
(61, 'Moris', 'Grill', 'Obstetrician', 'Redwood', 4.40),
(62, 'Harrim', 'Joe', 'Hematologist', 'Cleveland', 1.50),
(63, 'Irene', 'Barie', 'Pediatrist', 'Pennsylvania', 1.30),
(64, 'Carol', 'Powell', 'Nephrologist', 'Boston', 1.90),
(65, 'David', 'Hunter', 'Gastroenterologist', 'San Jose', 1.30),
(66, 'Wendy', 'Crammer', 'Gyno', 'Texas', 4.30),
(67, 'Harry', 'Potter', 'Gastroenterologist', 'Palo Alto', 1.30),
(68, 'Sonia', 'Bane', 'Gyno', 'Jersey City', 1.50),
(69, 'Sue', 'Tuckler', 'Gastroenterologist', 'Texas', 4.30),
(70, 'Sarah', 'Bell', 'Gastroenterologist', 'Palo Alto', 1.30);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
