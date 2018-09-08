CREATE TABLE `booked` (
  `pkID` int(11) NOT NULL AUTO_INCREMENT,
  `ThingsID` varchar(45) DEFAULT NULL,
  `FromDate` timestamp NULL DEFAULT NULL,
  `ToDate` timestamp NULL DEFAULT NULL,
  `ChangeDate` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`pkID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

CREATE TABLE `location` (
  `pkID` int(11) NOT NULL AUTO_INCREMENT,
  `thingsID` int(11) DEFAULT NULL,
  `Mainpos` varchar(45) DEFAULT NULL,
  `Subpos` varchar(45) DEFAULT NULL,
  `Heightpos` varchar(45) DEFAULT NULL,
  `Comment` varchar(45) DEFAULT NULL,
  `Changeddate` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`pkID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `things` (
  `pkID` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(255) NOT NULL,
  `Comment` varchar(255) NOT NULL,
  `Brand` varchar(255) NOT NULL,
  `Height` float DEFAULT NULL,
  `Width` float DEFAULT NULL,
  `Depth` float DEFAULT NULL,
  `ChangedDate` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`pkID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
