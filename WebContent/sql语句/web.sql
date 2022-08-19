/*
 Navicat Premium Data Transfer

 Source Server         : test2
 Source Server Type    : MySQL
 Source Server Version : 80018
 Source Host           : localhost:3306
 Source Schema         : web

 Target Server Type    : MySQL
 Target Server Version : 80018
 File Encoding         : 65001

 Date: 19/12/2019 09:07:39
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for business
-- ----------------------------
DROP TABLE IF EXISTS `business`;
CREATE TABLE `business`  (
  `BusinessID` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `BusinessName` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `BusinessPhone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `BusinessPsw` varchar(18) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `BusinessAddress` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`BusinessID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of business
-- ----------------------------
INSERT INTO `business` VALUES ('00', '00', '00', '00', '00');
INSERT INTO `business` VALUES ('123', '天', '13475704341', '123456', '123456');
INSERT INTO `business` VALUES ('132', '包袱斋', '12123132211', '1', '落魄山');
INSERT INTO `business` VALUES ('321', '桂花岛', '12345608600', '1', '老龙城');
INSERT INTO `business` VALUES ('test', '陈好人', '13222222222', '1', '二掌柜酒铺');

-- ----------------------------
-- Table structure for customer
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer`  (
  `CustomerID` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `CustomerName` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `CustomerPhone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `CustomerAddress` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `CustomerPsw` varchar(18) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`CustomerID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of customer
-- ----------------------------
INSERT INTO `customer` VALUES ('00', '00', '00', '00', '00');
INSERT INTO `customer` VALUES ('000', '1232312313212321', '13222222444', '123213', '1');
INSERT INTO `customer` VALUES ('0000', '111111', '12345678912', '123456', '1');
INSERT INTO `customer` VALUES ('12', '妮妮ni', '15875704341', '456789', '123456');
INSERT INTO `customer` VALUES ('123', '大杂烩', '13111212121', '广东省肇庆市肇庆学院', '1');
INSERT INTO `customer` VALUES ('13', '13', '17870704241', '23568', '23256');
INSERT INTO `customer` VALUES ('132', '包袱斋', '12312322132', '落魄山', '1');
INSERT INTO `customer` VALUES ('157', 'zzzz稚圭', '13115921230', '肇庆学院', '1');
INSERT INTO `customer` VALUES ('159', 'zzzz稚圭', '13115921238', '肇庆学院', '1');
INSERT INTO `customer` VALUES ('321', '桂花岛', '14725836996', '老龙城', '1');
INSERT INTO `customer` VALUES ('ss', '陈平安', '13115921234', '梦里', '1');
INSERT INTO `customer` VALUES ('sss', '1234567', '13115921235', '123132132123', '1');

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods`  (
  `GoodsID` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `GoodsName` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `GoodsType` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `Introduction` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `Image` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`GoodsID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES ('1', '三星电视', 'tv', '12月12日-22日，下单立减500元', './images2/sanxing_1.jpg');
INSERT INTO `goods` VALUES ('10', '小米笔记本', 'ipan', '更轻更薄，像杂志一样随身携带', './image/pinpai5.png');
INSERT INTO `goods` VALUES ('11', '小米6', 'phone', '666', './image/xm6_80.png');
INSERT INTO `goods` VALUES ('12', 'iphone11', 'phone', 'A P P L E ! ! !', './images/iphone11pro.jpg');
INSERT INTO `goods` VALUES ('13', '华为P30', 'phone', '华为P30', './images/Huawei_p30.jpg');
INSERT INTO `goods` VALUES ('14', 'C语言程序设计', 'book', 'C语言', './images/C_book.jpg');
INSERT INTO `goods` VALUES ('15', 'python书籍', 'book', '最好的语言', './images/ptython_book.jpg');
INSERT INTO `goods` VALUES ('16', '算法设计', 'book', 'ALgorithm', './images/suanfa_book.jpg');
INSERT INTO `goods` VALUES ('17', 'ipad air2', 'ipan', '最值得入手的智能产品', './images/ipad_air2.jpg');
INSERT INTO `goods` VALUES ('18', '华为M6', 'ipan', 'paaaad！！！', './images/Huawei_M6.jpg');
INSERT INTO `goods` VALUES ('19', '小米平板4', 'ipan', 'Are u O K ?', './images/xiaomi-4.jpg');
INSERT INTO `goods` VALUES ('2', '微软平板', 'ipan', '12月12日-22日，下单减300', './images2/weiruan_1.jpg');
INSERT INTO `goods` VALUES ('20', '微软平板', 'ipan', 'Microsoft', './images/weiruan.jpg');
INSERT INTO `goods` VALUES ('21', 'surface', 'ipan', 'Microsoft x 2！！', './images/surface pro 3.jpg');
INSERT INTO `goods` VALUES ('22', '小米电视', 'tv', '米店', './images/xiaomi_tv.jpg');
INSERT INTO `goods` VALUES ('23', '康佳电视', 'tv', 'JK TV', './images/kangjia_tv.jpg');
INSERT INTO `goods` VALUES ('24', '三星电视', 'tv', 'SAMSUNG', './images/sanxing_tv.jpg');
INSERT INTO `goods` VALUES ('25', '大头机电视', 'tv', '复古', './images/bighead.jpg');
INSERT INTO `goods` VALUES ('26', 'tp-link-r406', 'router', '路由器', './images/tp-link-tl-r406.jpg');
INSERT INTO `goods` VALUES ('27', 'H3C路由交换机', 'router', 'H3C路由交换机', './images/H3C_MSR2600.jpg');
INSERT INTO `goods` VALUES ('28', '腾达W18E', 'router', '腾达W18E', './images/tengda_w18e.jpg');
INSERT INTO `goods` VALUES ('29', 'TP-LINK交换机', 'router', 'TP-LINK交换机', './images/tp_link_tl_er6120.jpg');
INSERT INTO `goods` VALUES ('3', '华为Mate Pro', 'phone', '12月12日起售，麒麟990处理器，彭拜性能，重构芯片想象', './images2/huawei_mate_pro.jpg');
INSERT INTO `goods` VALUES ('30', 'adidas服饰', 'cloth', 'ADIDAS', './images/adidas.jpg');
INSERT INTO `goods` VALUES ('31', 'nike服饰', 'cloth', 'nike服饰', './images/nike.jpg');
INSERT INTO `goods` VALUES ('32', 'lining服饰', 'cloth', 'lining服饰', './images/lining.jpg');
INSERT INTO `goods` VALUES ('4', 'a21潮流服装', 'cloth', '12月12日-22日，全场8折', './images2/a21.jpg');
INSERT INTO `goods` VALUES ('40', '测试', 'phone', '测试用', 'C:\\fakepath\\微信图片_20191119000050.jpg');
INSERT INTO `goods` VALUES ('49', '1', '1', '1', 'C:\\fakepath\\微信图片_20191120234144.jpg');
INSERT INTO `goods` VALUES ('5', 'javaweb', 'book', '12月12日-22日，满99-30元', './images2/javaweb.jpg');
INSERT INTO `goods` VALUES ('6', 'iphone11 pro', 'phone', '12月12日-22日享花呗12期分期免息', './images2/iphone11pro_1.jpg');
INSERT INTO `goods` VALUES ('7', '华为P30', 'phone', '12月12日-22日，下单立减200元', './images2/huaweip30_1.jpg');
INSERT INTO `goods` VALUES ('8', 'vivo p20 超清摄像头', 'phone', '12月12日-22日，下单送八重好礼', './images2/vivop20.jpg');
INSERT INTO `goods` VALUES ('88', '22', '22', '22', './image/liebiao_hongmin4_dd.jpg');
INSERT INTO `goods` VALUES ('9', '小米电视3s 55英寸', 'tv', '5月9日，下单立减200元', './image/pinpai4.png');
INSERT INTO `goods` VALUES ('94', '4', 'phone', '4', '');
INSERT INTO `goods` VALUES ('96', 'asdasd', 'phone', '测试用', '');
INSERT INTO `goods` VALUES ('97', '123', 'phone', '123', '');
INSERT INTO `goods` VALUES ('98', '132', 'phone', '123', '');
INSERT INTO `goods` VALUES ('99', '天长地久', 'phone', '测试用', 'C:\\Users\\91436\\Desktop\\20191120234144.jpg');

-- ----------------------------
-- Table structure for manager
-- ----------------------------
DROP TABLE IF EXISTS `manager`;
CREATE TABLE `manager`  (
  `ManagerID` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `ManagerName` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `ManagerPhone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `ManagerPsw` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `ManagerAddress` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`ManagerID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of manager
-- ----------------------------
INSERT INTO `manager` VALUES ('00', '00', '00', '00', '00');
INSERT INTO `manager` VALUES ('123', 'vvvv', '123456', '123456', 'vvvvvvv');

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `CustomerID` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `BusinessID` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `GoodsID` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `Number` int(11) NOT NULL,
  `SalePrice` decimal(65, 2) NOT NULL,
  `Sum` decimal(65, 2) NOT NULL,
  `Date` date NULL DEFAULT NULL,
  PRIMARY KEY (`id`, `CustomerID`, `BusinessID`, `GoodsID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 48 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES (1, '00', '123', '88', 4, 30.00, 2499.00, NULL);
INSERT INTO `orders` VALUES (2, '00', '123', '123', 2, 3.00, 4.00, NULL);
INSERT INTO `orders` VALUES (3, '00', '123', '88', 5, 30.00, 150.00, NULL);
INSERT INTO `orders` VALUES (4, '12', '123', '88', 5, 30.00, 150.00, NULL);
INSERT INTO `orders` VALUES (8, 'ss', '123', '1', 1, 4999.00, 4999.00, '2019-12-18');
INSERT INTO `orders` VALUES (16, 'ss', '321', '2', 1, 6999.00, 6999.00, '2019-12-18');
INSERT INTO `orders` VALUES (17, 'ss', '132', '3', 5, 3299.00, 16495.00, '2019-12-18');
INSERT INTO `orders` VALUES (18, 'ss', '123', '4', 5, 99.00, 495.00, '2019-12-18');
INSERT INTO `orders` VALUES (19, 'ss', '123', '10', 26, 3599.00, 93574.00, '2019-12-18');
INSERT INTO `orders` VALUES (20, 'ss', '123', '10', 20, 3599.00, 71980.00, '2019-12-18');
INSERT INTO `orders` VALUES (21, 'ss', '123', '7', 3, 3999.00, 11997.00, '2019-12-18');
INSERT INTO `orders` VALUES (22, 'ss', '321', '2', 1, 6999.00, 6999.00, '2019-12-18');
INSERT INTO `orders` VALUES (23, 'ss', '132', '3', 1, 3299.00, 3299.00, '2019-12-18');
INSERT INTO `orders` VALUES (24, 'ss', '123', '1', 1, 4999.00, 4999.00, '2019-12-18');
INSERT INTO `orders` VALUES (27, 'ss', '321', '2', 4, 6999.00, 27996.00, '2019-12-18');
INSERT INTO `orders` VALUES (28, 'ss', '321', '2', 1, 6999.00, 6999.00, '2019-12-18');
INSERT INTO `orders` VALUES (29, 'ss', '123', '7', 1, 3999.00, 3999.00, '2019-12-18');
INSERT INTO `orders` VALUES (30, 'ss', '123', '1', 1, 4999.00, 4999.00, '2019-12-18');
INSERT INTO `orders` VALUES (31, 'ss', '123', '6', 28, 8499.00, 237972.00, '2019-12-18');
INSERT INTO `orders` VALUES (32, 'ss', '132', '3', 1, 3299.00, 3299.00, '2019-12-18');
INSERT INTO `orders` VALUES (33, 'ss', '132', '3', 4, 3299.00, 13196.00, '2019-12-18');
INSERT INTO `orders` VALUES (34, 'ss', '123', '5', 7, 49.00, 343.00, '2019-12-18');
INSERT INTO `orders` VALUES (36, 'ss', '123', '1', 8, 4999.00, 39992.00, '2019-12-18');
INSERT INTO `orders` VALUES (37, 'ss', '123', '1', 8, 4999.00, 39992.00, '2019-12-18');
INSERT INTO `orders` VALUES (38, 'ss', '123', '1', 10, 4999.00, 49990.00, '2019-12-18');
INSERT INTO `orders` VALUES (39, 'ss', '321', '2', 7, 6999.00, 48993.00, '2019-12-18');
INSERT INTO `orders` VALUES (40, 'ss', '123', '1', 5, 4999.00, 24995.00, '2019-12-18');
INSERT INTO `orders` VALUES (41, 'ss', '123', '1', 1, 4999.00, 4999.00, '2019-12-18');
INSERT INTO `orders` VALUES (42, '123', '132', '3', 1, 3299.00, 3299.00, '2019-12-18');
INSERT INTO `orders` VALUES (43, '123', '123', '11', 1, 2999.00, 2999.00, NULL);
INSERT INTO `orders` VALUES (44, '123', '123', '5', 38, 49.00, 1862.00, NULL);
INSERT INTO `orders` VALUES (45, 'ss', '321', '2', 4, 6999.00, 27996.00, '2019-12-19');
INSERT INTO `orders` VALUES (46, 'ss', '123', '1', 1, 4999.00, 4999.00, '2019-12-19');
INSERT INTO `orders` VALUES (47, 'ss', '123', '99', 1, 1024.00, 1024.00, '2019-12-19');
INSERT INTO `orders` VALUES (48, 'ss', '123', '14', 1, 39.00, 39.00, '2019-12-19');
INSERT INTO `orders` VALUES (49, 'ss', '132', '3', 1, 3299.00, 3299.00, '2019-12-19');
INSERT INTO `orders` VALUES (50, 'ss', '321', '2', 15, 6999.00, 104985.00, '2019-12-19');

-- ----------------------------
-- Table structure for stock
-- ----------------------------
DROP TABLE IF EXISTS `stock`;
CREATE TABLE `stock`  (
  `BusinessID` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `GoodsID` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `SalePrice` decimal(7, 2) NOT NULL,
  `PurchasePrice` decimal(7, 2) NOT NULL,
  `PurchaseNum` int(11) NOT NULL,
  `Stock` int(11) NOT NULL,
  PRIMARY KEY (`BusinessID`, `GoodsID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of stock
-- ----------------------------
INSERT INTO `stock` VALUES ('123', '1', 4999.00, 4000.00, 500, 499);
INSERT INTO `stock` VALUES ('123', '10', 99.00, 3000.00, 11000, 499);
INSERT INTO `stock` VALUES ('123', '11', 2999.00, 1000.00, 1000, 1000);
INSERT INTO `stock` VALUES ('123', '12', 5999.00, 5000.00, 400, 1000);
INSERT INTO `stock` VALUES ('123', '13', 5999.00, 4000.00, 4000, 4000);
INSERT INTO `stock` VALUES ('123', '14', 39.00, 20.00, 400, 399);
INSERT INTO `stock` VALUES ('123', '15', 49.00, 20.00, 400, 4000);
INSERT INTO `stock` VALUES ('123', '16', 89.00, 50.00, 400, 500);
INSERT INTO `stock` VALUES ('123', '17', 3000.00, 2000.00, 400, 400);
INSERT INTO `stock` VALUES ('123', '18', 2500.00, 200.00, 300, 500);
INSERT INTO `stock` VALUES ('123', '19', 2000.00, 1000.00, 500, 5000);
INSERT INTO `stock` VALUES ('123', '20', 5000.00, 123.00, 1000, 1000);
INSERT INTO `stock` VALUES ('123', '21', 6700.00, 1000.00, 1000, 1000);
INSERT INTO `stock` VALUES ('123', '22', 4399.00, 132.00, 123, 1800);
INSERT INTO `stock` VALUES ('123', '23', 4799.00, 123.00, 1000, 1000);
INSERT INTO `stock` VALUES ('123', '24', 8799.00, 1321.00, 11321, 11111);
INSERT INTO `stock` VALUES ('123', '25', 500.00, 500.00, 500, 500);
INSERT INTO `stock` VALUES ('123', '27', 300.00, 210.00, 2222, 2000);
INSERT INTO `stock` VALUES ('123', '28', 200.00, 123.00, 1111, 1111);
INSERT INTO `stock` VALUES ('123', '29', 300.00, 145.00, 1111, 1111);
INSERT INTO `stock` VALUES ('123', '30', 400.00, 123.00, 11111, 1111);
INSERT INTO `stock` VALUES ('123', '31', 599.00, 456.00, 4560, 4545);
INSERT INTO `stock` VALUES ('123', '32', 400.00, 123.00, 1111, 1111);
INSERT INTO `stock` VALUES ('123', '4', 99.00, 10.00, 400, 499);
INSERT INTO `stock` VALUES ('123', '40', 1024.00, 400.00, 400, 400);
INSERT INTO `stock` VALUES ('123', '49', 1024.00, 100.00, 32, 23);
INSERT INTO `stock` VALUES ('123', '5', 49.00, 20.00, 100000, 500);
INSERT INTO `stock` VALUES ('123', '6', 8499.00, 5000.00, 11021, 500);
INSERT INTO `stock` VALUES ('123', '7', 3999.00, 3000.00, 1111, 500);
INSERT INTO `stock` VALUES ('123', '8', 2999.00, 2999.00, 1111, 499);
INSERT INTO `stock` VALUES ('123', '88', 50.00, 30.00, 400, 100);
INSERT INTO `stock` VALUES ('123', '9', 3999.00, 3000.00, 11110, 499);
INSERT INTO `stock` VALUES ('123', '94', 4.00, 4.00, 4, 4);
INSERT INTO `stock` VALUES ('123', '96', 1024.00, 100.00, 100, 100);
INSERT INTO `stock` VALUES ('123', '97', 1024.00, 100.00, 123123, 123323);
INSERT INTO `stock` VALUES ('123', '98', 1024.00, 100.00, 100, 1000);
INSERT INTO `stock` VALUES ('132', '26', 400.00, 100.00, 1555, 2000);
INSERT INTO `stock` VALUES ('132', '3', 3299.00, 2000.00, 400, 496);
INSERT INTO `stock` VALUES ('321', '2', 6999.00, 4000.00, 400, 472);

SET FOREIGN_KEY_CHECKS = 1;
