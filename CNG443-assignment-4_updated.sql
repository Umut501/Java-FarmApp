
--
-- User: `CNG443user`
--
CREATE USER IF NOT EXISTS 'cng443user'@'localhost' IDENTIFIED BY '1234';

--
-- Database: `FarmAppDB`
--
CREATE DATABASE IF NOT EXISTS `FarmAppDB` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

--
-- Give all privileges to CNG443user on this database
--
GRANT ALL PRIVILEGES ON `FarmAppDB`.* TO 'cng443user'@'localhost';


--
-- Use this database to create the tables
--
USE `FarmAppDB`;



--
-- Table structure for table `Animal`
--

CREATE TABLE `Animal` (
  `tagNo` int(6) NOT NULL,
  `gender` char(1) NOT NULL,
  `dateOfBirth` date NOT NULL,
  `purchased` tinyint(1) NOT NULL,
  `type` char(1) NOT NULL,
  `Weight` int(11)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `Employee`
--

CREATE TABLE `Employee` (
  `empID` int(11) NOT NULL,
  `gender` char(1) NOT NULL,
  `dateOfBirth` date NOT NULL,
  `type` char(1) NOT NULL,
  `BScDegree` tinyint(1),
  `dateOfGraduation` date,
  `expertiseLevel` int(11),
  `previousFarmName` varchar(50),
  `workExperience` int(11)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Animal`
--
ALTER TABLE `Animal`
  ADD PRIMARY KEY (`tagNo`);

--
-- Indexes for table `Employee`
--
ALTER TABLE `Employee`
  ADD PRIMARY KEY (`empID`);
