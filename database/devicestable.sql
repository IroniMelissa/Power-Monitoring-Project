-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 13, 2022 at 10:59 AM
-- Server version: 10.4.14-MariaDB
-- PHP Version: 7.2.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `electrogrid`
--

-- --------------------------------------------------------

--
-- Table structure for table `devicestable`
--

CREATE TABLE `devicestable` (
  `deviceID` int(11) NOT NULL,
  `device` varchar(50) NOT NULL,
  `powerUsage` decimal(20,2) NOT NULL,
  `hours` int(5) NOT NULL,
  `noOfdevices` int(11) NOT NULL,
  `DailypowerConsumption` decimal(20,2) NOT NULL,
  `MonthlyPowerConsumption` decimal(20,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `devicestable`
--

INSERT INTO `devicestable` (`deviceID`, `device`, `powerUsage`, `hours`, `noOfdevices`, `DailypowerConsumption`, `MonthlyPowerConsumption`) VALUES
(1, 'Fan Heater', '180.00', 10, 3, '5400.00', '162.00'),
(2, 'Printer', '200.00', 2, 1, '400.00', '12.00'),
(3, 'Computer', '500.00', 2, 2, '2000.00', '60.00'),
(4, 'Table fan', '200.00', 2, 1, '400.00', '12.00'),
(5, 'Lamp', '200.00', 2, 2, '800.00', '24.00'),
(7, 'Air Condiitioner', '1000.00', 10, 5, '50000.00', '1500.00'),
(8, 'Electric heater', '500.00', 2, 1, '1000.00', '30.00'),
(9, 'Electric water bottle', '500.00', 2, 2, '2000.00', '60.00'),
(11, 'Tv recorder', '500.00', 2, 1, '1000.00', '30.00'),
(14, 'Electric Iron', '500.00', 2, 1, '1000.00', '30.00'),
(16, 'Televison', '200.00', 5, 3, '3000.00', '90.00'),
(67, 'Heater', '100.00', 10, 1, '1000.00', '30.00');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `devicestable`
--
ALTER TABLE `devicestable`
  ADD PRIMARY KEY (`deviceID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `devicestable`
--
ALTER TABLE `devicestable`
  MODIFY `deviceID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=69;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
