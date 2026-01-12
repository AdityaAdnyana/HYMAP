-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 12, 2026 at 03:09 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `hymap-db`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `id` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password_hash` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`id`, `username`, `password_hash`) VALUES
(1, 'Admin', '1');

-- --------------------------------------------------------

--
-- Table structure for table `armada`
--

CREATE TABLE `armada` (
  `kode_armada` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `armada`
--

INSERT INTO `armada` (`kode_armada`) VALUES
('DPS-01'),
('DPS-02'),
('NONE');

-- --------------------------------------------------------

--
-- Table structure for table `pelanggan`
--

CREATE TABLE `pelanggan` (
  `id` int(11) NOT NULL,
  `nama` varchar(255) NOT NULL,
  `alamat` varchar(255) NOT NULL,
  `no_telepon` varchar(25) NOT NULL,
  `jumlah_galon` int(11) NOT NULL DEFAULT 0,
  `harga_per_galon` decimal(10,2) NOT NULL DEFAULT 20000.00,
  `daerah_kiriman` varchar(20) DEFAULT NULL,
  `rentang_pengiriman` int(2) NOT NULL DEFAULT 7,
  `tgl_mulai_rentang` date NOT NULL DEFAULT '2025-01-01',
  `status_pembayaran` enum('cash','bon','transfer') NOT NULL DEFAULT 'bon'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `pelanggan`
--

INSERT INTO `pelanggan` (`id`, `nama`, `alamat`, `no_telepon`, `jumlah_galon`, `harga_per_galon`, `daerah_kiriman`, `rentang_pengiriman`, `tgl_mulai_rentang`, `status_pembayaran`) VALUES
(7, 'Aditya', 'jalan nina', '0719999', 5, 10000.00, 'DPS-01', 7, '2025-01-05', 'bon'),
(12, 'Sijawa', 'Jalan Merpati no 12', '081123441', 0, 10000.00, 'DPS-01', 7, '2025-01-01', 'cash'),
(13, 'Bujan', 'Jalan Kenari no 25', '08123731', 0, 10000.00, 'DPS-01', 7, '2025-01-01', 'transfer'),
(14, 'Maka', 'Jalan Pulau Baru X no 91', '081273191', 0, 10000.00, 'DPS-01', 7, '2025-01-01', 'bon'),
(15, 'Julius', 'Jalan Bersama', '081888777444', 10, 10000.00, 'DPS-01', 1, '2025-01-01', 'transfer'),
(16, 'Asep', 'Jalan Merdeka 2 No 8', '0812888777333', 0, 10000.00, 'DPS-01', 7, '2025-01-01', 'bon'),
(17, 'Madun', 'Jalan Ketawa no 9 ', '0812345666222', 4, 10000.00, 'DPS-01', 7, '2025-01-01', 'transfer'),
(18, 'Walnut', 'Jalan Coba coba no 91', '0817776662223', 4, 10000.00, 'DPS-01', 7, '2025-01-01', 'transfer'),
(19, 'Arabica', 'Jln gurun pasir no 11', '081444555323', 5, 10000.00, 'DPS-01', 7, '2025-01-01', 'bon'),
(20, 'Eka', 'jalan tunggal no 1', '9000666677778', 9, 10000.00, 'DPS-01', 7, '2025-01-01', 'bon'),
(21, 'abjadz', 'jalan sampaiz no7', '081222223333', 0, 10000.00, 'DPS-01', 7, '2025-01-01', 'bon'),
(22, 'A', 'ss', '11', 0, 10000.00, 'DPS-01', 7, '2025-01-01', 'bon'),
(23, 'An', 'ada', '111', 0, 10000.00, 'DPS-02', 7, '2025-01-20', 'bon');

-- --------------------------------------------------------

--
-- Table structure for table `pengiriman`
--

CREATE TABLE `pengiriman` (
  `id` int(11) NOT NULL,
  `pelanggan_id` int(11) NOT NULL,
  `tanggal_pengiriman` date NOT NULL,
  `status` varchar(50) NOT NULL,
  `status_pembayaran` varchar(50) DEFAULT 'bon'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `pengiriman`
--

INSERT INTO `pengiriman` (`id`, `pelanggan_id`, `tanggal_pengiriman`, `status`, `status_pembayaran`) VALUES
(1, 15, '2026-01-12', 'belum terkirim', 'cash'),
(2, 15, '2026-01-14', 'belum terkirim', 'bon'),
(3, 15, '2026-01-16', 'sudah terkirim', 'bon'),
(4, 15, '2026-01-18', 'belum terkirim', 'bon'),
(6, 15, '2026-01-22', 'sudah terkirim', 'bon'),
(7, 7, '2026-01-22', 'belum terkirim', 'bon'),
(8, 15, '2026-01-30', 'belum terkirim', 'bon'),
(9, 7, '2026-02-05', 'sudah terkirim', 'bon'),
(10, 15, '2026-03-09', 'sudah terkirim', 'bon'),
(11, 15, '2026-04-18', 'sudah terkirim', 'bon'),
(12, 7, '2026-04-30', 'sudah terkirim', 'bon'),
(21, 15, '2026-01-20', 'belum terkirim', 'bon'),
(26, 12, '2026-02-11', 'sudah terkirim', 'bon'),
(27, 13, '2026-02-11', 'sudah terkirim', 'bon'),
(28, 14, '2026-02-11', 'sudah terkirim', 'bon'),
(29, 15, '2026-02-11', 'sudah terkirim', 'bon'),
(30, 12, '2026-02-25', 'sudah terkirim', 'bon'),
(31, 14, '2026-03-11', 'sudah terkirim', 'bon'),
(32, 23, '2026-01-14', 'sudah terkirim', 'bon'),
(33, 23, '2026-01-28', 'sudah terkirim', 'bon'),
(34, 23, '2026-02-11', 'sudah terkirim', 'bon'),
(35, 23, '2026-02-25', 'sudah terkirim', 'bon'),
(36, 23, '2026-03-11', 'sudah terkirim', 'bon'),
(37, 15, '2026-03-07', 'sudah terkirim', 'bon'),
(38, 15, '2026-03-08', 'sudah terkirim', 'bon'),
(39, 15, '2026-03-10', 'sudah terkirim', 'bon'),
(40, 15, '2026-02-28', 'sudah terkirim', 'bon'),
(43, 12, '2026-01-14', 'sudah terkirim', 'bon'),
(44, 13, '2026-01-14', 'sudah terkirim', 'bon'),
(49, 23, '2026-01-12', 'sudah terkirim', 'cash'),
(53, 7, '2026-01-25', 'sudah terkirim', 'cash'),
(54, 15, '2026-01-25', 'sudah terkirim', 'cash'),
(55, 15, '2026-01-15', 'sudah terkirim', 'bon'),
(57, 15, '2026-01-19', 'sudah terkirim', 'bon'),
(58, 7, '2026-01-18', 'sudah terkirim', 'bon'),
(60, 15, '2026-01-24', 'sudah terkirim', 'bon');

-- --------------------------------------------------------

--
-- Table structure for table `sopir`
--

CREATE TABLE `sopir` (
  `id` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `nama` varchar(255) NOT NULL,
  `no_telepon` varchar(25) DEFAULT NULL,
  `armada` varchar(10) DEFAULT NULL,
  `username` varchar(25) DEFAULT NULL,
  `password` varchar(60) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `sopir`
--

INSERT INTO `sopir` (`id`, `user_id`, `nama`, `no_telepon`, `armada`, `username`, `password`) VALUES
(9, NULL, 'Komang Artha', '08123456789', 'DPS-01', 'Komang', '$2a$10$77qNc5Ils9X87R2Wozt9eensK9vFp38DOdKpEmZph3jpm2KtY9kEG'),
(11, NULL, 'A', 'AA', 'NONE', 'AA', '$2a$10$QH.KJfiy4NBL2BO0BApgkey9ORW6TUf27VBVnWdjfQSXPayAbxdqy'),
(12, NULL, 'Ai', '1', 'DPS-02', 'AiBro', '$2a$10$mhDcVao2yWCcmitfTNM2a.iavNfxePAiOS4mqwuEYf0BhD5SL0zty');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(255) NOT NULL,
  `role` enum('admin','sopir') NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `armada`
--
ALTER TABLE `armada`
  ADD PRIMARY KEY (`kode_armada`);

--
-- Indexes for table `pelanggan`
--
ALTER TABLE `pelanggan`
  ADD PRIMARY KEY (`id`),
  ADD KEY `daerah_kiriman` (`daerah_kiriman`);

--
-- Indexes for table `pengiriman`
--
ALTER TABLE `pengiriman`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `unique_delivery` (`pelanggan_id`,`tanggal_pengiriman`),
  ADD UNIQUE KEY `idx_pelanggan_tanggal` (`pelanggan_id`,`tanggal_pengiriman`);

--
-- Indexes for table `sopir`
--
ALTER TABLE `sopir`
  ADD PRIMARY KEY (`id`),
  ADD KEY `user_id` (`user_id`),
  ADD KEY `armada` (`armada`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `username` (`username`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `pelanggan`
--
ALTER TABLE `pelanggan`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- AUTO_INCREMENT for table `pengiriman`
--
ALTER TABLE `pengiriman`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=61;

--
-- AUTO_INCREMENT for table `sopir`
--
ALTER TABLE `sopir`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `pelanggan`
--
ALTER TABLE `pelanggan`
  ADD CONSTRAINT `pelanggan_ibfk_1` FOREIGN KEY (`daerah_kiriman`) REFERENCES `armada` (`kode_armada`);

--
-- Constraints for table `pengiriman`
--
ALTER TABLE `pengiriman`
  ADD CONSTRAINT `fk_pelanggan` FOREIGN KEY (`pelanggan_id`) REFERENCES `pelanggan` (`id`) ON DELETE CASCADE;

--
-- Constraints for table `sopir`
--
ALTER TABLE `sopir`
  ADD CONSTRAINT `sopir_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE SET NULL,
  ADD CONSTRAINT `sopir_ibfk_2` FOREIGN KEY (`armada`) REFERENCES `armada` (`kode_armada`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
