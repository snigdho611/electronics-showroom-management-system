-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 23, 2019 at 06:13 PM
-- Server version: 10.4.10-MariaDB
-- PHP Version: 7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dbproject`
--

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `empid` varchar(10) NOT NULL,
  `name` varchar(40) DEFAULT NULL,
  `password` varchar(15) DEFAULT NULL,
  `email` varchar(25) DEFAULT NULL,
  `phonenumber` varchar(20) DEFAULT NULL,
  `admin` varchar(3) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`empid`, `name`, `password`, `email`, `phonenumber`, `admin`) VALUES
('32145', 'Santi Ranjan Howlader', '1971', 'santi.1971@gmail.com', '+8801775141923', 'no'),
('361381', 'Arafat Antor', 'xeon', 'abirantor@gmail.com', '+8801623456789', 'yes'),
('36177', 'Snigdho Dip Howlader', 'sdhpass', 'dip.howlader@gmail.com', '+8801775641902', 'yes');

-- --------------------------------------------------------

--
-- Table structure for table `laptops`
--

CREATE TABLE `laptops` (
  `productid` varchar(32) NOT NULL,
  `model` varchar(40) DEFAULT NULL,
  `processor` varchar(40) DEFAULT NULL,
  `ram` varchar(15) DEFAULT NULL,
  `storage` varchar(15) DEFAULT NULL,
  `battery` varchar(12) DEFAULT NULL,
  `price` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `laptops`
--

INSERT INTO `laptops` (`productid`, `model`, `processor`, `ram`, `storage`, `battery`, `price`) VALUES
('LAP001', 'Notebook 7 Force 15.6', 'Intel Core i7-8750H', '16 GB', '512 GB SSD', '9 hrs', 96000),
('LAP002', 'Notebook Odyssey', 'Intel Hexa-Core i7-8750H', '16 GB', '512 GB SSD', '8.5 hrs', 94000),
('LAP003', 'Notebook 5', 'AMD Ryzen™ 5 2500U', '8 GB', '1 TB HDD', '6 hrs', 47000),
('LAP004', 'Notebook 9 Pro', 'Intel® Core™ i7 8565U', '8 GB', '256 GB SDD', '14.7 hrs', 85000),
('LAP005', 'Notebook Flash', 'Intel® Celeron® N4000', '4 GB', '64 GB HDD', '6 hrs', 85000),
('LAP006', 'Samsung Chromebook Plus V2', 'Intel® Celeron® Processor', '4 GB', '32 GB HDD', '9 hrs', 35000),
('LAP007', 'Samsung Galaxy Book S', 'Snapdragon™ Octa-core processor ', '8 GB', '256 GB HDD', '25 hrs', 85000);

-- --------------------------------------------------------

--
-- Table structure for table `phones`
--

CREATE TABLE `phones` (
  `productid` varchar(32) NOT NULL,
  `model` varchar(32) DEFAULT NULL,
  `processor` varchar(32) DEFAULT NULL,
  `ram` varchar(32) DEFAULT NULL,
  `storage` varchar(10) DEFAULT NULL,
  `camera` varchar(10) DEFAULT NULL,
  `price` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `phones`
--

INSERT INTO `phones` (`productid`, `model`, `processor`, `ram`, `storage`, `camera`, `price`) VALUES
('PHN001', 'Galaxy Note 2', 'Quad-core 1.6 GHz', '2 GB', '16 GB', '1.9 MP', 9500),
('PHN002', 'Galaxy Note 8', 'Octa-core EMEA', '6 GB', '64 GB', '12 MP', 22000),
('PHN003', 'Galaxy A71', 'Octa-core', '8 GB', '128 GB', '64 MP', 30000),
('PHN004', 'Galaxy Note 10+', 'Octa-core EMEA/LATAM', '12 GB', '256 GB', '12 MP', 40000),
('PHN005', 'Galaxy S7 edge', 'Quad-core', '4 GB', '32 GB', '12 MP', 22000),
('PHN006', 'Galaxy A20', 'Octa-core', '3 GB', '32 GB', '13 MP', 19000),
('PHN007', 'Galaxy A80', 'Octa-core', '8 GB', '128 GB', '48 MP', 41000),
('PHN008', 'Galaxy Ace', 'Dual-core', '2 GB', '16 GB', '5 MP', 6000),
('PHN009', 'Galaxy S7', 'Quad-core', '8 GB', '64 GB', '12 MP', 24000),
('PHN010', 'Galaxy S9', 'Octa-core EMEA', '4 GB', '256 GB', '12 MP', 28000);

-- --------------------------------------------------------

--
-- Table structure for table `televisions`
--

CREATE TABLE `televisions` (
  `productid` varchar(15) NOT NULL,
  `model` varchar(40) DEFAULT NULL,
  `screensize` varchar(10) DEFAULT NULL,
  `screentype` varchar(30) DEFAULT NULL,
  `soundtype` varchar(30) DEFAULT NULL,
  `connectivity` varchar(30) DEFAULT NULL,
  `price` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `televisions`
--

INSERT INTO `televisions` (`productid`, `model`, `screensize`, `screentype`, `soundtype`, `connectivity`, `price`) VALUES
('TVS001', 'J5250 Smart Full HD TV', '49 inch', 'HDTV', 'Dolby Digital Plus', 'Wifi, BT', 44000),
('TVS002', 'RU7100 4K Smart UHD TV', '75 inch', '4K UHDTV', 'Dolby Digital Plus', 'Wifi, BT', 205000),
('TVS003', 'NU7090 4K Smart UHD TV', '65 inch', '4K UHDTV', 'Dolby Digital Plus', 'Wifi, BT', 105000),
('TVS004', 'RU8000 4K Smart Premium UHD TV', '82 inch', '4K UHDTV', 'Dolby Digital Plus', 'Wifi, BT', 380000);

-- --------------------------------------------------------

--
-- Table structure for table `transactions`
--

CREATE TABLE `transactions` (
  `tranID` int(11) NOT NULL,
  `cusname` varchar(40) DEFAULT NULL,
  `cusphone` varchar(20) DEFAULT NULL,
  `cusemail` varchar(30) DEFAULT NULL,
  `productid` varchar(20) DEFAULT NULL,
  `modelname` varchar(40) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `price` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `transactions`
--

INSERT INTO `transactions` (`tranID`, `cusname`, `cusphone`, `cusemail`, `productid`, `modelname`, `date`, `price`) VALUES
(1, 'Fahamidul Haque', '+8801671234567', 'aoyon@gmail.com', 'PHN002', 'Galaxy Note 8', '2016-10-12', 22000),
(2, 'Asif Sijan', '+8801613456789', 'asijan@gmail.com', 'TVS001', 'J5250 Smart Full HD TV', '2017-06-04', 44000),
(3, 'Aishwarjyo Roy', '+8801771243526', 'aishwarjyo@gmail.com', 'LAP003', 'Notebook 5', '2019-01-01', 47000),
(4, 'Michael Bay', '+8801875239128', 'michael@gmail.com', 'TVS004', 'RU8000 4K Smart Premium UHD TV', '2014-02-24', 380000),
(5, 'Arup Saha', '+8801628502934', 'arup.saha@gmail.com', 'LAP004', 'RU8000 4K Smart Premium UHD TV', '2018-05-18', 205000),
(6, 'Fayyadh Kabir', '+8801733462823', 'fk@gmail.com', 'PHN001', 'Galaxy Note 2', '2019-01-01', 9500),
(7, 'Maisha Maliha', '+8801733462823', 'maisha.maliha@gmail.com', 'LAP007', 'Samsung Galaxy Book S', '2019-11-21', 85000),
(8, 'Rashik Rafiq', '+8801624283721', 'rashik@gmail.com', 'LAP005', 'Notebook Flash', '2018-12-25', 85000),
(9, 'Tausif Chowdhury', '+8801834194260', 'tausif.chowdhury@gmail.com', 'PHN005', 'Galaxy S7 edge', '2019-05-12', 22000),
(10, 'Mustafizur Rahman', '+8801629384128', 'mrahman@gmail.com', 'TVS003', 'NU7090 4K Smart UHD TV', '2017-04-28', 105000),
(11, 'Muzammel Hossain Chisty', '+8801734125980', 'chisty69@gmail.com', 'TVS004', 'RU8000 4K Smart Premium UHD TV', '2018-07-31', 380000),
(12, 'Arifuzzaman Himel', '+8801686841231', 'himel@gmail.com', 'TVS002', 'RU7100 4K Smart UHD TV', '2019-12-23', 205000),
(13, 'Arup Saha', '+8801628502934', 'arup.saha@gmail.com', 'PHN008', 'Galaxy Ace', '2019-12-22', 6000);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`empid`);

--
-- Indexes for table `laptops`
--
ALTER TABLE `laptops`
  ADD PRIMARY KEY (`productid`);

--
-- Indexes for table `phones`
--
ALTER TABLE `phones`
  ADD PRIMARY KEY (`productid`);

--
-- Indexes for table `televisions`
--
ALTER TABLE `televisions`
  ADD PRIMARY KEY (`productid`);

--
-- Indexes for table `transactions`
--
ALTER TABLE `transactions`
  ADD PRIMARY KEY (`tranID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `transactions`
--
ALTER TABLE `transactions`
  MODIFY `tranID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
