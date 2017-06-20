-- phpMyAdmin SQL Dump
-- version 4.6.2
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Apr 20, 2017 at 07:39 AM
-- Server version: 5.7.13-log
-- PHP Version: 5.6.22

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `shopspring`
--

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

CREATE TABLE `category` (
  `categoryID` bigint(20) NOT NULL,
  `categoryName` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `categoryParent` bigint(20) NOT NULL,
  `category_id` int(11) NOT NULL,
  `name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `parent` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `category`
--

INSERT INTO `category` (`categoryID`, `categoryName`, `categoryParent`, `category_id`, `name`, `parent`) VALUES
(1, 'Category 1', 0, 0, NULL, NULL),
(2, 'Category 2', 0, 0, NULL, NULL),
(3, 'Category 3', 0, 0, NULL, NULL),
(4, 'Category 4', 1, 0, NULL, NULL),
(5, 'Category 5', 1, 0, NULL, NULL),
(8, 'Category 8', 2, 0, NULL, NULL),
(9, 'Category 9', 2, 0, NULL, NULL),
(10, 'Category 10', 3, 0, NULL, NULL),
(11, 'Category 11', 3, 0, NULL, NULL),
(12, 'Category 12', 0, 0, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `productID` bigint(20) NOT NULL,
  `productDescription` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `productImage` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `productName` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `productPrice` double NOT NULL,
  `categoryID` bigint(20) DEFAULT NULL,
  `product_id` int(11) NOT NULL,
  `category_id` int(11) DEFAULT NULL,
  `description` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `image` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `price` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`productID`, `productDescription`, `productImage`, `productName`, `productPrice`, `categoryID`, `product_id`, `category_id`, `description`, `image`, `name`, `price`) VALUES
(0, 'description 0', 'image 0', 'product 0', 0, 1, 0, NULL, NULL, NULL, NULL, NULL),
(1, 'description 1', 'image 1', 'product 1', 1, 2, 0, NULL, NULL, NULL, NULL, NULL),
(2, 'description 2', 'image 2', 'product 2', 2, 3, 0, NULL, NULL, NULL, NULL, NULL),
(3, 'description 3', 'image 3', 'product 3', 3, 4, 0, NULL, NULL, NULL, NULL, NULL),
(4, 'description 4', 'image 4', 'product 4', 4, 1, 0, NULL, NULL, NULL, NULL, NULL),
(5, 'description 5', 'image 5', 'product 5', 5, 2, 0, NULL, NULL, NULL, NULL, NULL),
(6, 'description 6', 'image 6', 'product 6', 6, 3, 0, NULL, NULL, NULL, NULL, NULL),
(7, 'description 7', 'image 7', 'product 7', 7, 1, 0, NULL, NULL, NULL, NULL, NULL),
(8, 'description 8', 'image 8', 'product 8', 8, 2, 0, NULL, NULL, NULL, NULL, NULL),
(9, 'description 9', 'image 9', 'product 9', 8, 3, 0, NULL, NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `user_id` int(11) NOT NULL,
  `password` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `role` int(11) DEFAULT NULL,
  `username` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`user_id`, `password`, `role`, `username`) VALUES
(1, '12345611111', 0, '1111111'),
(2, '123456', 0, 'tramdo1610');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`categoryID`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`productID`),
  ADD KEY `FK_hfdpy6e6md3osou6tinpaysjj` (`categoryID`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`user_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `category`
--
ALTER TABLE `category`
  MODIFY `categoryID` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
--
-- AUTO_INCREMENT for table `product`
--
ALTER TABLE `product`
  MODIFY `productID` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `product`
--
ALTER TABLE `product`
  ADD CONSTRAINT `FK_hfdpy6e6md3osou6tinpaysjj` FOREIGN KEY (`categoryID`) REFERENCES `category` (`categoryID`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
