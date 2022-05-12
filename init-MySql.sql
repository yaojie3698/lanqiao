CREATE DATABASE  IF NOT EXISTS `1+x` DEFAULT CHARACTER SET utf8mb4;
USE `1+x`;

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `name` varchar(20) primary key,
  `pwd` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `grade` int(11) DEFAULT NULL,
  `rate` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('zs', '123', 20, 1, 0);
INSERT INTO `student` VALUES ('ls', '456', 21, 2, 0);
INSERT INTO `student` VALUES ('ww', '123456', 22, 3, 0);
INSERT INTO `student` VALUES ('zl', '111222', 23, 4, 0);

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `name` varchar(20) primary key,
  `teacher` varchar(20) DEFAULT NULL,
  `difficulty` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES ('语文', '郭靖', '低');
INSERT INTO `course` VALUES ('数学', '黄蓉', '高');
INSERT INTO `course` VALUES ('英语', '洪七公', '中');
INSERT INTO `course` VALUES ('C语言', '小龙女', '高');

-- ----------------------------
-- Table structure for score
-- ----------------------------
DROP TABLE IF EXISTS `score`;
CREATE TABLE `score` (
  `sname` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `cname` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `score` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of score
-- ----------------------------
INSERT INTO `score` VALUES ('zs', '语文', 80);
INSERT INTO `score` VALUES ('zs', '数学', 70);
INSERT INTO `score` VALUES ('zs', '英语', 75);
INSERT INTO `score` VALUES ('ls', '语文', 65);
INSERT INTO `score` VALUES ('ls', '数学', 90);
INSERT INTO `score` VALUES ('ls', '英语', 70);
INSERT INTO `score` VALUES ('ww', '语文', 85);
INSERT INTO `score` VALUES ('ww', '数学', 60);
INSERT INTO `score` VALUES ('ww', '英语', 90);
INSERT INTO `score` VALUES ('zl', 'C语言', 80);