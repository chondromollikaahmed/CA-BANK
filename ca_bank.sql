-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 03, 2021 at 02:30 AM
-- Server version: 10.4.17-MariaDB
-- PHP Version: 8.0.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ca_bank`
--

-- --------------------------------------------------------

--
-- Table structure for table `acc_info`
--

CREATE TABLE `acc_info` (
  `username` varchar(256) NOT NULL,
  `acc_no` varchar(100) NOT NULL,
  `dob` date NOT NULL,
  `gender` text NOT NULL,
  `number` varchar(11) NOT NULL,
  `address` varchar(256) NOT NULL,
  `zip` text NOT NULL,
  `occu` text NOT NULL,
  `marital` text NOT NULL,
  `country` text NOT NULL,
  `nid` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `acc_info`
--

INSERT INTO `acc_info` (`username`, `acc_no`, `dob`, `gender`, `number`, `address`, `zip`, `occu`, `marital`, `country`, `nid`) VALUES
('ahmed', 'CA90081', '1999-11-25', 'Female', '01993522240', 'uyukh', '1216', 'Student', 'unmarried', 'Bangladesh', '129382983823'),
('ch', 'CA78981', '1999-11-25', 'Female', '01993522240', 'akas', '1216', 'Student', 'unmarried', 'Bangladesh', '12271'),
('ch1234', 'CA23456', '1999-11-25', 'Female', '01993522240', 'Jamtola ', '1216', 'Student', 'N/A', 'Bangladesh', '2198289128982'),
('je', 'CA51601', '1999-05-25', 'Male', '01788242956', 'ssdkjsd', '1216', 'Student', 'unmarried', 'Bangladesh', '32323828932382');

-- --------------------------------------------------------

--
-- Table structure for table `add_money`
--

CREATE TABLE `add_money` (
  `trace_id` int(11) NOT NULL,
  `acc_no` varchar(100) NOT NULL,
  `check_no` varchar(100) NOT NULL DEFAULT 'N/A',
  `card_no` varchar(100) NOT NULL DEFAULT 'N/A',
  `amount` double NOT NULL,
  `Branch` varchar(100) NOT NULL DEFAULT 'N/A',
  `csv` int(4) NOT NULL DEFAULT 0,
  `status` varchar(10) NOT NULL DEFAULT 'processing'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `add_money`
--

INSERT INTO `add_money` (`trace_id`, `acc_no`, `check_no`, `card_no`, `amount`, `Branch`, `csv`, `status`) VALUES
(2, 'CA23456', 'AC377438473', 'N/A', 400, 'Dhaka', 0, 'DONE'),
(3, 'CA23456', 'N/A', '1267893536', 200, 'N/A', 292, 'DONE'),
(4, 'CA23456', '8128127781263732', 'N/A', 400, 'Dhaka1216', 0, 'DONE'),
(5, 'CA23456', 'N/A', '283923828398329', 100, 'N/A', 4564, 'DONE'),
(6, 'CA23456', 'N/A', '6985864598', 10000, 'N/A', 234, 'DONE'),
(7, 'CA23456', '8723723287', 'N/A', 2000, 'online', 0, 'DONE'),
(8, 'CA23456', '29930209', 'N/A', 3000, 'online', 0, 'DONE'),
(9, 'CA23456', 'N/A', '637636', 200, 'N/A', 262, 'DONE'),
(10, 'CA23456', '723727382', 'N/A', 4300, 'online', 0, 'processing'),
(11, 'CA23456', '37373', 'N/A', 3200, 'online', 0, 'processing'),
(12, 'CA23456', '28772', 'N/A', 500, 'online', 0, 'processing'),
(13, 'CA23456', 'N/A', '26327662', 300, 'N/A', 121, 'processing'),
(14, 'CA23456', 'N/A', '2323232', 500, 'N/A', 232, 'processing'),
(15, 'CA23456', '23323', 'N/A', 300, 'online', 0, 'processing'),
(16, 'CA23456', 'N/A', '3987987987', 100, 'N/A', 1212, 'processing'),
(17, 'CA23456', '323233221', 'N/A', 560, 'online', 0, 'processing'),
(18, 'CA90081', 'N/A', '372873228', 500, 'N/A', 323, 'DONE'),
(19, 'CA90081', 'N/A', '372873228454', 6000, 'N/A', 323, 'DONE'),
(20, 'CA90081', '33877', 'N/A', 300, 'online', 0, 'DONE'),
(21, 'CA78981', 'N/A', '287273872', 2000, 'N/A', 22387, 'DONE'),
(22, 'CA78981', '122172212', 'N/A', 1500, 'online', 0, 'DONE'),
(23, 'CA23456', 'N/A', '870207', 1000, 'N/A', 705, 'processing'),
(24, 'CA23456', '12337883', 'N/A', 1000, 'comilla', 0, 'processing'),
(25, 'CA23456', '12337883', 'N/A', 1000, 'comilla', 0, 'processing');

-- --------------------------------------------------------

--
-- Table structure for table `blance_table`
--

CREATE TABLE `blance_table` (
  `acc_no` varchar(100) NOT NULL,
  `blance` double NOT NULL,
  `pending_bal` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `blance_table`
--

INSERT INTO `blance_table` (`acc_no`, `blance`, `pending_bal`) VALUES
('CA23456', 13700, 5460),
('CA51601', 13000, 0),
('CA78981', 3000, 0),
('CA90081', 3500, 0);

-- --------------------------------------------------------

--
-- Table structure for table `gen_card`
--

CREATE TABLE `gen_card` (
  `id` int(11) NOT NULL,
  `card_number` varchar(100) NOT NULL,
  `csv` int(3) NOT NULL,
  `pin` int(6) NOT NULL,
  `issued_to` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `gen_card`
--

INSERT INTO `gen_card` (`id`, `card_number`, `csv`, `pin`, `issued_to`) VALUES
(1, '870207', 705, 1234, 'ccccc');

-- --------------------------------------------------------

--
-- Table structure for table `gen_check`
--

CREATE TABLE `gen_check` (
  `id` int(11) NOT NULL,
  `check_no` int(11) NOT NULL,
  `branch` varchar(100) NOT NULL,
  `issued_to` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `gen_check`
--

INSERT INTO `gen_check` (`id`, `check_no`, `branch`, `issued_to`) VALUES
(1, 3764734, 'online', 'toto'),
(2, 12337883, 'Comilla', 'chondro');

-- --------------------------------------------------------

--
-- Table structure for table `info`
--

CREATE TABLE `info` (
  `acc_no` varchar(100) NOT NULL,
  `last_tran` double NOT NULL DEFAULT 0,
  `last_tran_date` timestamp NOT NULL DEFAULT current_timestamp(),
  `last_added_money` double NOT NULL DEFAULT 0,
  `Total` double NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `info`
--

INSERT INTO `info` (`acc_no`, `last_tran`, `last_tran_date`, `last_added_money`, `Total`) VALUES
('CA23456', 500, '2021-03-19 21:30:05', 200, 1900),
('CA51601', 700, '2021-03-13 22:15:01', 0, 1400),
('CA78981', 500, '2021-03-19 21:30:05', 1500, 500),
('CA90081', 0, '2021-03-13 19:00:38', 300, 0);

-- --------------------------------------------------------

--
-- Table structure for table `officer_acc`
--

CREATE TABLE `officer_acc` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `phoneNo` varchar(100) NOT NULL,
  `nid` varchar(100) NOT NULL,
  `pin` int(15) NOT NULL,
  `officer_no` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `officer_acc`
--

INSERT INTO `officer_acc` (`id`, `name`, `email`, `phoneNo`, `nid`, `pin`, `officer_no`) VALUES
(2, 'Chondromollika', 'emran.jehadur@gmail.com', '01788242956', '112893782383782', 491709, 'BCA-3425'),
(3, 'Chondro', 'Email', 'Mobile', '12216262', 274820, 'BCA-3585'),
(5, 'chondromollika ', 'chondromollika.ahmed@gmail.com', '01993522240', '2768272', 210020, 'BCA-3055');

-- --------------------------------------------------------

--
-- Table structure for table `officer_info`
--

CREATE TABLE `officer_info` (
  `officer_no` varchar(256) NOT NULL,
  `email` varchar(100) NOT NULL,
  `dob` date NOT NULL,
  `gender` text NOT NULL,
  `number` varchar(11) NOT NULL,
  `address` varchar(256) NOT NULL,
  `zip` text NOT NULL,
  `occu` text NOT NULL,
  `marital` text NOT NULL,
  `country` text NOT NULL,
  `nid` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `officer_info`
--

INSERT INTO `officer_info` (`officer_no`, `email`, `dob`, `gender`, `number`, `address`, `zip`, `occu`, `marital`, `country`, `nid`) VALUES
('BCA-3055', 'chondromollika.ahmed@gmail.com', '2021-03-25', 'Female', '01993522240', 'address', '1216', 'Public Servant', 'N/A', 'Bangladesh', '338438948'),
('BCA-3425', '01788242956', '2021-03-17', 'Male', '01993522240', 'sjddds', 'Z121', 'Public Servant', 'N/A', 'Bangladesh', '3737338');

-- --------------------------------------------------------

--
-- Table structure for table `signup`
--

CREATE TABLE `signup` (
  `id` int(11) NOT NULL,
  `firstname` text NOT NULL,
  `lastname` text NOT NULL,
  `password` varchar(256) NOT NULL,
  `email` varchar(30) NOT NULL,
  `username` varchar(256) NOT NULL,
  `acc_no` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `signup`
--

INSERT INTO `signup` (`id`, `firstname`, `lastname`, `password`, `email`, `username`, `acc_no`) VALUES
(12, 'Chondrmollika', 'Ahmed', '877c6458b7822afb09660eef6d10b12a', 'ch@gmail.com', 'ch1234', 'CA23456'),
(22, 'Jehadur', 'Rahman', 'af6e28bf8f85cc1cded2df0b6f982d8c', 'emran.jehadur@gmail.com', 'je', 'CA51601'),
(24, 'ahmed', 'chondro', 'af6e28bf8f85cc1cded2df0b6f982d8c', 'emran.jehadur@gmail.com', 'chondro', 'CA39451'),
(25, 'chondromollika', 'Ahmed', '877c6458b7822afb09660eef6d10b12a', 'emran.jehadur@gmail.com', 'ahmed', 'CA90081'),
(27, 'Ahmed', 'Chondromollika', '877c6458b7822afb09660eef6d10b12a', 'emran.jehadur@gmail.com', '', 'N/A'),
(30, 'ahmed', 'chondromollika', '877c6458b7822afb09660eef6d10b12a', 'emran.jehadur@gmail.com', 'ch', 'CA78981');

-- --------------------------------------------------------

--
-- Table structure for table `transaction`
--

CREATE TABLE `transaction` (
  `tran_id` int(30) NOT NULL,
  `reference` varchar(256) NOT NULL,
  `debit` double NOT NULL DEFAULT 0,
  `credit` double NOT NULL DEFAULT 0,
  `time_stamp` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `username` varchar(256) NOT NULL,
  `acc_no` varchar(100) NOT NULL,
  `to_acc` varchar(100) NOT NULL,
  `tran_stat` varchar(100) NOT NULL,
  `concur` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `transaction`
--

INSERT INTO `transaction` (`tran_id`, `reference`, `debit`, `credit`, `time_stamp`, `username`, `acc_no`, `to_acc`, `tran_stat`, `concur`) VALUES
(6, 'addm', 300, 0, '2021-03-04 16:10:23', 'ch1234', 'CA23456', 'CA51601', 'Done', 'NO'),
(7, 'addm', 400, 0, '2021-03-04 16:10:23', 'ch1234', 'CA23456', 'CA51601', 'Done', 'Nope'),
(8, 'send', -200, 0, '2021-03-04 17:46:34', 'ch1234', 'CA23456', 'CA51601', 'DONE', 'NO'),
(9, 'receive', 0, 2000, '2021-03-04 17:46:34', 'je', 'CA51601', 'CA23456', 'DONE', 'NO'),
(10, 'send', -1200, 0, '2021-03-04 17:53:46', 'ch1234', 'CA23456', 'CA51601', 'DONE', 'NO'),
(11, 'receive', 0, 3000, '2021-03-04 17:53:46', 'je', 'CA51601', 'CA23456', 'DONE', 'NO'),
(12, 'send', 12100, 0, '2021-03-13 14:53:29', 'ch1234', 'CA23456', 'CA51601', 'DONE', 'NO'),
(13, 'receive', 0, 10600, '2021-03-13 14:53:29', 'je', 'CA51601', 'CA23456', 'DONE', 'NO'),
(14, 'send', 500, 0, '2021-03-13 15:30:19', 'ch1234', 'CA23456', 'CA51601', 'DONE', 'NO'),
(15, 'receive', 0, 500, '2021-03-13 15:30:19', 'je', 'CA51601', 'CA23456', 'DONE', 'NO'),
(16, 'send', 700, 0, '2021-03-13 15:32:14', 'ch1234', 'CA23456', 'CA51601', 'DONE', 'NO'),
(17, 'receive', 0, 700, '2021-03-13 15:32:14', 'je', 'CA51601', 'CA23456', 'DONE', 'NO'),
(18, 'send', 1000, 0, '2021-03-13 19:20:58', 'ahmed', 'CA90081', 'CA23456', 'DONE', 'NO'),
(19, 'receive', 0, 1000, '2021-03-13 19:20:58', 'ch1234', 'CA23456', 'CA90081', 'DONE', 'NO'),
(20, 'send', 600, 0, '2021-03-13 19:44:26', 'ahmed', 'CA90081', 'CA23456', 'DONE', 'NO'),
(21, 'receive', 0, 600, '2021-03-13 19:44:26', 'ch1234', 'CA23456', 'CA90081', 'DONE', 'NO'),
(22, 'send', 900, 0, '2021-03-13 19:53:01', 'ahmed', 'CA90081', 'CA23456', 'DONE', 'NO'),
(23, 'receive', 0, 900, '2021-03-13 19:53:01', 'ch1234', 'CA23456', 'CA90081', 'DONE', 'NO'),
(24, 'send', 800, 0, '2021-03-13 19:54:48', 'ahmed', 'CA90081', 'CA23456', 'DONE', 'NO'),
(25, 'receive', 0, 800, '2021-03-13 19:54:48', 'ch1234', 'CA23456', 'CA90081', 'DONE', 'NO'),
(26, 'send', 500, 0, '2021-03-13 22:11:41', 'ch1234', 'CA23456', 'CA51601', 'DONE', 'NO'),
(27, 'receive', 0, 500, '2021-03-13 22:11:41', 'je', 'CA51601', 'CA23456', 'DONE', 'NO'),
(28, 'send', 700, 0, '2021-03-13 22:15:01', 'ch1234', 'CA23456', 'CA51601', 'DONE', 'NO'),
(29, 'receive', 0, 700, '2021-03-13 22:15:01', 'je', 'CA51601', 'CA23456', 'DONE', 'NO'),
(30, 'send', 500, 0, '2021-03-19 21:30:05', 'ch', 'CA78981', 'CA23456', 'DONE', 'NO'),
(31, 'receive', 0, 500, '2021-03-19 21:30:05', 'ch1234', 'CA23456', 'CA78981', 'DONE', 'NO');

-- --------------------------------------------------------

--
-- Table structure for table `transfer`
--

CREATE TABLE `transfer` (
  `id` int(255) NOT NULL,
  `acc_No` varchar(100) NOT NULL,
  `amount` double NOT NULL,
  `to_acc` varchar(100) NOT NULL,
  `status` varchar(12) NOT NULL DEFAULT 'processing'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `transfer`
--

INSERT INTO `transfer` (`id`, `acc_No`, `amount`, `to_acc`, `status`) VALUES
(1, 'CA23456', 1000, 'CA51601', 'DONE'),
(2, 'CA23456', 400, 'CA51601', 'DONE'),
(3, 'CA23456', 600, 'CA51601', 'DONE'),
(4, 'CA23456', 800, 'CA51601', 'DONE'),
(5, 'CA23456', 500, 'CA51601', 'DONE'),
(6, 'CA23456', 700, 'CA51601', 'DONE'),
(7, 'CA23456', 300, 'CA51601', 'DONE'),
(8, 'CA90081', 1000, 'CA23456', 'DONE'),
(9, 'CA90081', 600, 'CA23456', 'DONE'),
(10, 'CA90081', 800, 'CA23456', 'DONE'),
(11, 'CA90081', 800, 'CA23456', 'DONE'),
(12, 'CA90081', 900, 'CA23456', 'DONE'),
(13, 'CA23456', 500, 'CA51601', 'DONE'),
(14, 'CA23456', 700, 'CA51601', 'DONE'),
(15, 'CA78981', 500, 'CA23456', 'DONE');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `acc_info`
--
ALTER TABLE `acc_info`
  ADD PRIMARY KEY (`username`),
  ADD UNIQUE KEY `acc_no` (`acc_no`);

--
-- Indexes for table `add_money`
--
ALTER TABLE `add_money`
  ADD PRIMARY KEY (`trace_id`),
  ADD KEY `acc_no` (`acc_no`);

--
-- Indexes for table `blance_table`
--
ALTER TABLE `blance_table`
  ADD PRIMARY KEY (`acc_no`);

--
-- Indexes for table `gen_card`
--
ALTER TABLE `gen_card`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `gen_check`
--
ALTER TABLE `gen_check`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `info`
--
ALTER TABLE `info`
  ADD PRIMARY KEY (`acc_no`);

--
-- Indexes for table `officer_acc`
--
ALTER TABLE `officer_acc`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `nid` (`nid`);

--
-- Indexes for table `officer_info`
--
ALTER TABLE `officer_info`
  ADD PRIMARY KEY (`officer_no`),
  ADD UNIQUE KEY `acc_no` (`email`);

--
-- Indexes for table `signup`
--
ALTER TABLE `signup`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `username` (`username`) USING BTREE,
  ADD KEY `acc_no` (`acc_no`) USING BTREE;

--
-- Indexes for table `transaction`
--
ALTER TABLE `transaction`
  ADD PRIMARY KEY (`tran_id`),
  ADD KEY `username` (`username`),
  ADD KEY `transaction_ibfk_2` (`acc_no`),
  ADD KEY `to_acc` (`to_acc`);

--
-- Indexes for table `transfer`
--
ALTER TABLE `transfer`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `add_money`
--
ALTER TABLE `add_money`
  MODIFY `trace_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- AUTO_INCREMENT for table `gen_card`
--
ALTER TABLE `gen_card`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `gen_check`
--
ALTER TABLE `gen_check`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `officer_acc`
--
ALTER TABLE `officer_acc`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `signup`
--
ALTER TABLE `signup`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;

--
-- AUTO_INCREMENT for table `transaction`
--
ALTER TABLE `transaction`
  MODIFY `tran_id` int(30) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;

--
-- AUTO_INCREMENT for table `transfer`
--
ALTER TABLE `transfer`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `acc_info`
--
ALTER TABLE `acc_info`
  ADD CONSTRAINT `acc_info_ibfk_1` FOREIGN KEY (`username`) REFERENCES `signup` (`username`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `acc_info_ibfk_2` FOREIGN KEY (`acc_no`) REFERENCES `signup` (`acc_no`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `add_money`
--
ALTER TABLE `add_money`
  ADD CONSTRAINT `add_money_ibfk_1` FOREIGN KEY (`acc_no`) REFERENCES `signup` (`acc_no`);

--
-- Constraints for table `blance_table`
--
ALTER TABLE `blance_table`
  ADD CONSTRAINT `blance_table_ibfk_1` FOREIGN KEY (`acc_no`) REFERENCES `signup` (`acc_no`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `info`
--
ALTER TABLE `info`
  ADD CONSTRAINT `info_ibfk_1` FOREIGN KEY (`acc_no`) REFERENCES `signup` (`acc_no`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `transaction`
--
ALTER TABLE `transaction`
  ADD CONSTRAINT `transaction_ibfk_1` FOREIGN KEY (`username`) REFERENCES `signup` (`username`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `transaction_ibfk_2` FOREIGN KEY (`acc_no`) REFERENCES `signup` (`acc_no`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `transaction_ibfk_3` FOREIGN KEY (`to_acc`) REFERENCES `signup` (`acc_no`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
