-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th5 14, 2023 lúc 05:27 AM
-- Phiên bản máy phục vụ: 10.4.27-MariaDB
-- Phiên bản PHP: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `qldoannhanh`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `bill`
--

CREATE TABLE `bill` (
  `id` int(11) NOT NULL,
  `idMenu` int(11) NOT NULL DEFAULT 1,
  `dateOfUriba` date DEFAULT NULL,
  `idUser` int(11) NOT NULL,
  `discount` int(11) NOT NULL,
  `status` int(11) NOT NULL,
  `TotalPrice` float DEFAULT NULL,
  `finalTotalPrice` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `bill`
--

INSERT INTO `bill` (`id`, `idMenu`, `dateOfUriba`, `idUser`, `discount`, `status`, `TotalPrice`, `finalTotalPrice`) VALUES
(184, 2, '2023-05-13', 2, 5, 0, 260000, 247000),
(185, 2, '2023-05-13', 2, 5, 0, 260000, 247000),
(186, 3, '2023-05-13', 2, 6, 0, 950000, 893000),
(187, 3, '2023-05-13', 2, 6, 0, 950000, 893000),
(188, 3, '2023-05-14', 2, 6, 0, 950000, 893000),
(189, 4, '2023-05-13', 1, 5, 0, 950000, 902500),
(190, 4, '2023-05-14', 1, 5, 0, 950000, 902500),
(191, 4, '2023-05-14', 1, 5, 0, 950000, 902500),
(192, 5, '2023-05-13', 1, 10, 0, 905000, 814500),
(193, 5, '2023-05-13', 1, 10, 0, 905000, 814500),
(194, 5, '2023-05-14', 1, 10, 0, 905000, 814500),
(195, 5, '2023-05-14', 1, 10, 0, 905000, 814500),
(196, 6, '2023-05-13', 4, 0, 0, 190000, 190000),
(197, 6, '2023-05-13', 4, 0, 0, 190000, 190000),
(198, 6, '2023-05-13', 4, 0, 0, 190000, 190000),
(199, 7, '2023-05-14', 4, 10, 0, 805000, 724500),
(200, 7, '2023-05-14', 4, 10, 0, 805000, 724500),
(201, 7, '2023-05-14', 4, 10, 0, 805000, 724500),
(202, 7, '2023-05-14', 4, 10, 0, 805000, 724500),
(203, 8, '2023-05-14', 1, 10, 0, 1710000, 1539000),
(204, 8, '2023-05-14', 1, 10, 0, 1710000, 1539000),
(205, 8, '2023-05-14', 1, 10, 0, 1710000, 1539000),
(206, 8, '2023-05-14', 1, 10, 0, 1710000, 1539000),
(207, 8, '2023-05-14', 1, 10, 0, 1710000, 1539000),
(208, 8, '2023-05-14', 1, 10, 0, 1710000, 1539000),
(209, 9, '2023-05-14', 1, 11, 0, 1455000, 1294950),
(210, 9, '2023-05-14', 1, 11, 0, 1455000, 1294950),
(211, 9, '2023-05-14', 1, 11, 0, 1455000, 1294950);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `billinfo`
--

CREATE TABLE `billinfo` (
  `id` int(11) NOT NULL,
  `IdBill` int(11) NOT NULL,
  `IdFood` int(11) NOT NULL,
  `Count` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `billinfo`
--

INSERT INTO `billinfo` (`id`, `IdBill`, `IdFood`, `Count`) VALUES
(187, 184, 6, 5),
(188, 185, 1, 9),
(189, 186, 9, 10),
(190, 187, 3, 10),
(191, 188, 17, 5),
(192, 189, 6, 6),
(193, 190, 10, 6),
(194, 191, 16, 4),
(195, 192, 6, 5),
(196, 193, 12, 6),
(197, 194, 2, 5),
(198, 195, 3, 4),
(199, 196, 9, 1),
(200, 197, 10, 1),
(201, 198, 3, 2),
(202, 199, 10, 5),
(203, 200, 1, 7),
(204, 201, 4, 7),
(205, 202, 2, 3),
(206, 203, 13, 4),
(207, 204, 1, 4),
(208, 205, 2, 2),
(209, 206, 6, 6),
(210, 207, 23, 6),
(211, 208, 19, 6),
(212, 209, 9, 9),
(213, 210, 12, 9),
(214, 211, 5, 7);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `employee`
--

CREATE TABLE `employee` (
  `Id` int(11) NOT NULL,
  `Name` text NOT NULL,
  `dateOfBirth` date DEFAULT NULL,
  `Phone` varchar(11) NOT NULL,
  `Sex` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `employee`
--

INSERT INTO `employee` (`Id`, `Name`, `dateOfBirth`, `Phone`, `Sex`) VALUES
(1, 'Hoàng Nguyễn Nhật Minh', '2003-11-22', '0988319860', 1),
(2, 'Võ Viết Trường', '2003-10-14', '0857937360', 1),
(3, 'Hồ Văn Thảo', '1996-05-06', '0369276372', 1),
(4, 'Admin', '2023-05-01', '0123123123', 1),
(5, 'Hoa', '2004-02-11', '0321321321', 0);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `food`
--

CREATE TABLE `food` (
  `id` int(11) NOT NULL,
  `Name` text NOT NULL,
  `idCategory` int(11) NOT NULL,
  `price` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `food`
--

INSERT INTO `food` (`id`, `Name`, `idCategory`, `price`) VALUES
(1, 'Bánh mì kẹp', 1, 15000),
(2, 'Bánh mì phô mai', 1, 20000),
(3, 'Bánh mì thịt nướng', 1, 20000),
(4, 'Bánh mì baguette', 1, 20000),
(5, 'Cheeseburger', 2, 15000),
(6, 'Bacon burger', 2, 25000),
(7, 'BBQ burger', 2, 100000),
(8, 'Sandwich thịt bò', 3, 20000),
(9, 'Sandwich thịt gà', 3, 50000),
(10, 'Sandwich kẹp thịt', 3, 100000),
(11, 'Sandwich trứng', 3, 50000),
(12, 'Pizza Vegetarian', 4, 100000),
(13, 'Pizza Margherita', 4, 200000),
(14, 'Pizza Marinara', 4, 150000),
(15, 'Pizza Pepperoni', 4, 250000),
(16, 'Kentucky Fried Chicken - KFC', 5, 50000),
(17, 'Gà rán Jollibee', 5, 50000),
(18, 'Kem tươi (vanilla)', 6, 100000),
(19, 'Kem socola', 6, 100000),
(20, 'Kem dâu tây', 6, 100000),
(21, 'Kem caramel', 6, 100000),
(22, 'Cocacola', 7, 10000),
(23, 'Pepsi', 7, 10000),
(24, 'Soda', 7, 10000);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `foodcategory`
--

CREATE TABLE `foodcategory` (
  `Id` int(11) NOT NULL,
  `Name` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `foodcategory`
--

INSERT INTO `foodcategory` (`Id`, `Name`) VALUES
(1, 'Bánh mì'),
(2, 'Hamburger'),
(3, 'Sandwich'),
(4, 'Pizza'),
(5, 'Gà rán'),
(6, 'Kem'),
(7, 'Đồ uống các loại');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `Account` text NOT NULL,
  `Password` varchar(11) NOT NULL,
  `Authority` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `user`
--

INSERT INTO `user` (`id`, `Account`, `Password`, `Authority`) VALUES
(1, 'MinhDepTrai', '123', 0),
(2, 'Truong', '123', 0),
(3, 'Thao', '123', 0),
(4, 'Admin', '123', 1),
(5, 'Hoa123', '123', 1);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `bill`
--
ALTER TABLE `bill`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idUser` (`idUser`);

--
-- Chỉ mục cho bảng `billinfo`
--
ALTER TABLE `billinfo`
  ADD PRIMARY KEY (`id`),
  ADD KEY `IdFood` (`IdFood`),
  ADD KEY `IdBill` (`IdBill`);

--
-- Chỉ mục cho bảng `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`Id`);

--
-- Chỉ mục cho bảng `food`
--
ALTER TABLE `food`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idCategory` (`idCategory`);

--
-- Chỉ mục cho bảng `foodcategory`
--
ALTER TABLE `foodcategory`
  ADD PRIMARY KEY (`Id`);

--
-- Chỉ mục cho bảng `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `bill`
--
ALTER TABLE `bill`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=212;

--
-- AUTO_INCREMENT cho bảng `billinfo`
--
ALTER TABLE `billinfo`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=215;

--
-- AUTO_INCREMENT cho bảng `food`
--
ALTER TABLE `food`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `bill`
--
ALTER TABLE `bill`
  ADD CONSTRAINT `bill_ibfk_1` FOREIGN KEY (`idUser`) REFERENCES `user` (`id`);

--
-- Các ràng buộc cho bảng `billinfo`
--
ALTER TABLE `billinfo`
  ADD CONSTRAINT `billinfo_ibfk_2` FOREIGN KEY (`IdFood`) REFERENCES `food` (`id`),
  ADD CONSTRAINT `billinfo_ibfk_3` FOREIGN KEY (`IdBill`) REFERENCES `bill` (`id`);

--
-- Các ràng buộc cho bảng `food`
--
ALTER TABLE `food`
  ADD CONSTRAINT `food_ibfk_1` FOREIGN KEY (`idCategory`) REFERENCES `foodcategory` (`Id`);

--
-- Các ràng buộc cho bảng `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `user_ibfk_1` FOREIGN KEY (`id`) REFERENCES `employee` (`Id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
