CREATE DATABASE  IF NOT EXISTS `1+x` DEFAULT CHARACTER SET utf8mb4;
USE `1+x`;

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `name` varchar(20) primary key,
  `pwd` varchar(20) COLLATE utf8_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('zs', '123');
INSERT INTO `student` VALUES ('ls', '456');
INSERT INTO `student` VALUES ('ww', '123456');

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `name` varchar(20) primary key,
  `author` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  `num` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES ('西游记', '吴承恩', 20, 50);
INSERT INTO `book` VALUES ('三国演义', '罗贯中', 25, 80);
INSERT INTO `book` VALUES ('红楼梦', '曹雪芹', 30, 30);
INSERT INTO `book` VALUES ('水浒传', '施耐庵', 18, 60);

-- ----------------------------
-- Table structure for sb
-- ----------------------------
DROP TABLE IF EXISTS `sb`;
CREATE TABLE `sb` (
  `id` int primary key auto_increment,
  `sname` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `bname` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `begintime` datetime DEFAULT NULL,
  `endtime` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of sb
-- ----------------------------
