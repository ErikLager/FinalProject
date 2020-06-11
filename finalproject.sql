-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Värd: 127.0.0.1
-- Tid vid skapande: 11 jun 2020 kl 14:47
-- Serverversion: 10.4.11-MariaDB
-- PHP-version: 7.4.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Databas: `finalproject`
--

-- --------------------------------------------------------

--
-- Tabellstruktur `categories`
--

CREATE TABLE `categories` (
  `Id` int(128) NOT NULL,
  `Name` varchar(128) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumpning av Data i tabell `categories`
--

INSERT INTO `categories` (`Id`, `Name`) VALUES
(1, 'Dessert'),
(2, 'BBQ'),
(3, 'Asian'),
(4, 'Chicken'),
(5, 'Beef'),
(6, 'Pork');

-- --------------------------------------------------------

--
-- Tabellstruktur `incategory`
--

CREATE TABLE `incategory` (
  `Category_Id` int(11) NOT NULL,
  `Recipes_Id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumpning av Data i tabell `incategory`
--

INSERT INTO `incategory` (`Category_Id`, `Recipes_Id`) VALUES
(2, 5),
(3, 4);

-- --------------------------------------------------------

--
-- Tabellstruktur `ingredience`
--

CREATE TABLE `ingredience` (
  `Id` int(128) NOT NULL,
  `Commodities` varchar(128) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumpning av Data i tabell `ingredience`
--

INSERT INTO `ingredience` (`Id`, `Commodities`) VALUES
(8, 'Glasnoodles'),
(9, 'Cabbage'),
(10, 'Flour'),
(11, 'salt'),
(12, 'Milk'),
(13, 'Egg'),
(14, 'Butter'),
(15, 'Pasta'),
(16, 'valilla suggar'),
(17, 'suggar'),
(18, 'Water'),
(19, 'Pork');

-- --------------------------------------------------------

--
-- Tabellstruktur `liked`
--

CREATE TABLE `liked` (
  `User_ID` int(11) NOT NULL,
  `Recipes_Id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Tabellstruktur `recipes`
--

CREATE TABLE `recipes` (
  `Id` int(128) NOT NULL,
  `Name` varchar(128) NOT NULL,
  `Picture` varchar(2048) NOT NULL,
  `StepGuide` varchar(2048) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumpning av Data i tabell `recipes`
--

INSERT INTO `recipes` (`Id`, `Name`, `Picture`, `StepGuide`) VALUES
(1, 'Pankakes', '//assets.icanet.se/f_auto,q_auto/imagevaultfiles/id_33719/cf_5291/pannkakor.jpg', 'Mix the flour and salt in a bowl. Mix in 1/2 of the milk & egg.'),
(3, 'Pasta', '//assets.icanet.se/f_auto,q_auto/imagevaultfiles/id_211210/cf_5291/graddig_pasta_med_kalkonbacon.jpg', 'Idk'),
(4, 'noodles', '//assets.icanet.se/f_auto,q_auto/imagevaultfiles/id_210863/cf_5291/wok_med_glasnudlar_och_kal.jpg', 'Cook the nudles. Slice the cabbage. '),
(5, 'Waffles', '//assets.icanet.se/f_auto,q_auto/imagevaultfiles/id_113011/cf_5291/vaffla_special_utan_agg.jpg', 'Mix the ingrediences. Pour the liquid '),
(6, 'Waffles with pork', 'https://www.aducksoven.com/wp-content/uploads/2015/02/pork-waffles6.jpg', 'Make waffles according to the other recipe. Make some pork, throw it in the trash and reconsider your life choices');

-- --------------------------------------------------------

--
-- Tabellstruktur `recipes_ingredience`
--

CREATE TABLE `recipes_ingredience` (
  `Recipes_Id` int(11) NOT NULL,
  `Ingredience_Id` int(11) NOT NULL,
  `Amount` varchar(128) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumpning av Data i tabell `recipes_ingredience`
--

INSERT INTO `recipes_ingredience` (`Recipes_Id`, `Ingredience_Id`, `Amount`) VALUES
(1, 10, '7.5dL'),
(1, 11, '1 tsp'),
(1, 13, '8'),
(1, 14, '75g'),
(3, 14, '2.5dL'),
(3, 15, '4 '),
(4, 8, '250g'),
(4, 9, '1 Barrel!'),
(5, 10, '2 dl'),
(5, 14, '2msk'),
(5, 16, '1.5 msk'),
(5, 18, '1.5 dl'),
(6, 10, '1 liter'),
(6, 13, '3'),
(6, 14, '2dl'),
(6, 16, '1 m^3'),
(6, 19, '2 metric tonnes');

-- --------------------------------------------------------

--
-- Ersättningsstruktur för vy `recipe_commodities`
-- (See below for the actual view)
--
CREATE TABLE `recipe_commodities` (
`Recipes_Id` int(11)
,`Amount` varchar(128)
,`Commodities` varchar(128)
);

-- --------------------------------------------------------

--
-- Tabellstruktur `usercomments`
--

CREATE TABLE `usercomments` (
  `Id` int(128) NOT NULL,
  `User_ID` int(11) NOT NULL,
  `Recipes_Id` int(11) NOT NULL,
  `Comment` varchar(1024) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Tabellstruktur `users`
--

CREATE TABLE `users` (
  `ID` int(128) NOT NULL,
  `Username` varchar(128) NOT NULL,
  `Oauth_Id` varchar(128) NOT NULL,
  `Password` varchar(128) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Struktur för vy `recipe_commodities`
--
DROP TABLE IF EXISTS `recipe_commodities`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `recipe_commodities`  AS  select `recipes_ingredience`.`Recipes_Id` AS `Recipes_Id`,`recipes_ingredience`.`Amount` AS `Amount`,`ingredience`.`Commodities` AS `Commodities` from (`recipes_ingredience` join `ingredience` on(`ingredience`.`Id` = `recipes_ingredience`.`Ingredience_Id`)) ;

--
-- Index för dumpade tabeller
--

--
-- Index för tabell `categories`
--
ALTER TABLE `categories`
  ADD PRIMARY KEY (`Id`);

--
-- Index för tabell `incategory`
--
ALTER TABLE `incategory`
  ADD PRIMARY KEY (`Category_Id`,`Recipes_Id`),
  ADD KEY `Recipes_Id` (`Recipes_Id`);

--
-- Index för tabell `ingredience`
--
ALTER TABLE `ingredience`
  ADD PRIMARY KEY (`Id`);

--
-- Index för tabell `liked`
--
ALTER TABLE `liked`
  ADD PRIMARY KEY (`User_ID`,`Recipes_Id`);

--
-- Index för tabell `recipes`
--
ALTER TABLE `recipes`
  ADD PRIMARY KEY (`Id`);

--
-- Index för tabell `recipes_ingredience`
--
ALTER TABLE `recipes_ingredience`
  ADD PRIMARY KEY (`Recipes_Id`,`Ingredience_Id`),
  ADD KEY `Ingredience_Id` (`Ingredience_Id`);

--
-- Index för tabell `usercomments`
--
ALTER TABLE `usercomments`
  ADD PRIMARY KEY (`Id`),
  ADD UNIQUE KEY `User_ID` (`User_ID`,`Recipes_Id`);

--
-- AUTO_INCREMENT för dumpade tabeller
--

--
-- AUTO_INCREMENT för tabell `categories`
--
ALTER TABLE `categories`
  MODIFY `Id` int(128) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT för tabell `ingredience`
--
ALTER TABLE `ingredience`
  MODIFY `Id` int(128) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT för tabell `recipes`
--
ALTER TABLE `recipes`
  MODIFY `Id` int(128) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT för tabell `usercomments`
--
ALTER TABLE `usercomments`
  MODIFY `Id` int(128) NOT NULL AUTO_INCREMENT;

--
-- Restriktioner för dumpade tabeller
--

--
-- Restriktioner för tabell `incategory`
--
ALTER TABLE `incategory`
  ADD CONSTRAINT `incategory_ibfk_1` FOREIGN KEY (`Category_Id`) REFERENCES `categories` (`Id`),
  ADD CONSTRAINT `incategory_ibfk_2` FOREIGN KEY (`Recipes_Id`) REFERENCES `recipes` (`Id`);

--
-- Restriktioner för tabell `recipes_ingredience`
--
ALTER TABLE `recipes_ingredience`
  ADD CONSTRAINT `recipes_ingredience_ibfk_1` FOREIGN KEY (`Ingredience_Id`) REFERENCES `ingredience` (`Id`),
  ADD CONSTRAINT `recipes_ingredience_ibfk_2` FOREIGN KEY (`Recipes_Id`) REFERENCES `recipes` (`Id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
