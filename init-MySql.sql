CREATE DATABASE  IF NOT EXISTS `1+x` DEFAULT CHARACTER SET utf8mb4;
USE `1+x`;

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for member
-- ----------------------------
DROP TABLE IF EXISTS `member`;
CREATE TABLE `member` (
  `name` varchar(20) primary key,
  `pwd` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `score` float DEFAULT NULL,
  `rank` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of member
-- ----------------------------
INSERT INTO `member` VALUES ('zs', '123', 120, 0);
INSERT INTO `member` VALUES ('ls', '456', 320, 0);
INSERT INTO `member` VALUES ('ww', '123456', 900, 0);

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `name` varchar(20) primary key,
  `price` float DEFAULT NULL,
  `num` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES ('辣条', 5.2, 50);
INSERT INTO `goods` VALUES ('面包', 3.5, 10);
INSERT INTO `goods` VALUES ('可乐', 2.8, 40);
INSERT INTO `goods` VALUES ('中华', 50.0, 10);
INSERT INTO `goods` VALUES ('牙刷', 8.5, 20);

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `id` int,
  `mname` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `gname` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `num` int(11) DEFAULT NULL,
  `price` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of order
-- ----------------------------
INSERT INTO `order` VALUES ('1', 'zs', '辣条', 2, 5.2);
INSERT INTO `order` VALUES ('1', 'zs', '面包', 1, 3.5);
INSERT INTO `order` VALUES ('1', 'zs', '可乐', 1, 2.8);
INSERT INTO `order` VALUES ('2', 'ls', '中华', 1, 50.0);
INSERT INTO `order` VALUES ('3', 'ww', '可乐', 2, 2.8);
INSERT INTO `order` VALUES ('4', 'zs', '牙刷', 1, 8.5);
INSERT INTO `order` VALUES ('4', 'zs', '辣条', 3, 5.2);