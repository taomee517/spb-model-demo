/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50722
Source Host           : 127.0.0.1:3306
Source Database       : db_spb_demo

Target Server Type    : MYSQL
Target Server Version : 50722
File Encoding         : 65001

Date: 2019-11-01 17:33:03
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for dba_user
-- ----------------------------
DROP TABLE IF EXISTS `dba_user`;
CREATE TABLE `dba_user` (
  `id` int(11) NOT NULL DEFAULT '0',
  `nick_name` varchar(64) DEFAULT NULL,
  `real_name` varchar(64) DEFAULT NULL,
  `phone` varchar(128) DEFAULT NULL,
  `city` varchar(32) DEFAULT NULL,
  `sex` varchar(8) DEFAULT NULL,
  `age` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dba_user
-- ----------------------------
INSERT INTO `dba_user` VALUES ('1', 'admin', '刘备', '13125364852', '成都', '男', '60');
INSERT INTO `dba_user` VALUES ('2', 'root', '诸葛亮', '18821656645', '荆州', '男', '45');

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nick_name` varchar(64) DEFAULT NULL,
  `real_name` varchar(64) DEFAULT NULL,
  `phone` varchar(128) DEFAULT NULL,
  `city` varchar(32) DEFAULT NULL,
  `sex` varchar(8) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES ('1', 'admin', '刘备', '13125364852', '成都', '男', '60');
INSERT INTO `tb_user` VALUES ('2', 'root', '诸葛亮', '18821656645', '荆州', '男', '45');

-- ----------------------------
-- Table structure for tb_vehicle_brand
-- ----------------------------
DROP TABLE IF EXISTS `tb_vehicle_brand`;
CREATE TABLE `tb_vehicle_brand` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '品牌id',
  `name` varchar(32) NOT NULL COMMENT '品牌中文名称',
  `logo` varchar(255) NOT NULL COMMENT '品牌图片url',
  `crt_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `description` varchar(255) DEFAULT NULL COMMENT '品牌描述',
  `crt_uid` int(11) NOT NULL COMMENT '创建人id',
  `upd_uid` int(11) DEFAULT NULL COMMENT '修改人id',
  `upd_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8 COMMENT='车辆品牌表';

-- ----------------------------
-- Records of tb_vehicle_brand
-- ----------------------------
INSERT INTO `tb_vehicle_brand` VALUES ('1', '奥迪', 'http://img.zcool.cn/community/0117e2571b8b246ac72538120dd8a4.jpg@1280w_1l_2o_100sh.jpg', '2018-08-02 10:17:56', '测试 奥迪1114', '1', '1', '2018-09-18 15:28:47');
INSERT INTO `tb_vehicle_brand` VALUES ('2', '本田', 'http://pic18.photophoto.cn/20110119/0015027489146390_b.jpg', '2018-08-02 10:18:00', '测试 本田5552312312', '1', '1', '2018-09-14 14:40:11');
INSERT INTO `tb_vehicle_brand` VALUES ('3', '大众', 'http://pic.90sjimg.com/inspiration/02/07/75/85/61/s_1024_Vblsypw2ietQF0d1R4gx.jpg', '2018-08-25 21:46:55', '测试 大众', '1', '2', '2019-11-01 16:35:49');
INSERT INTO `tb_vehicle_brand` VALUES ('11', '12323', 'http://blacktea-file.oss-cn-hangzhou.aliyuncs.com/201809/eadebb98-36e4-4c28-a627-dc8f937edd96logo.png', '2018-09-04 09:17:56', '123', '2', '2', '2018-09-04 09:17:56');
INSERT INTO `tb_vehicle_brand` VALUES ('13', '长安', 'http://img5.imgtn.bdimg.com/it/u=4233882962,1859475847&fm=27&gp=0.jpg', '2018-09-05 16:45:43', '测试 长安', '2', '2', '2018-09-05 16:45:43');
INSERT INTO `tb_vehicle_brand` VALUES ('18', 'ewrwer4444', 'http://blacktea-file.oss-cn-hangzhou.aliyuncs.com/201809/7fb3d09c-3e81-41b9-b3f7-33b542c60bd1hua.jpg', '2018-09-08 08:17:08', 'qerw', '2', '1', '2018-09-13 10:03:39');
INSERT INTO `tb_vehicle_brand` VALUES ('19', '4524', 'http://blacktea-file.oss-cn-hangzhou.aliyuncs.com/201809/d8646a29-30f7-40be-8aa8-a05d95764de3hua.jpg', '2018-09-10 15:49:23', '', '1', '1', '2018-09-10 17:21:00');
INSERT INTO `tb_vehicle_brand` VALUES ('23', '3', 'http://blacktea-file.oss-cn-hangzhou.aliyuncs.com/201809/a4fd5835-03ca-4415-945a-83dfac190c7dflower.png', '2018-09-13 10:00:04', '3', '1', '1', '2018-09-13 10:02:21');
INSERT INTO `tb_vehicle_brand` VALUES ('24', '叮当猫', 'http://blacktea-file.oss-cn-hangzhou.aliyuncs.com/201809/c53d5368-f7c5-444f-82b1-edb9572cf8f4热气球.jpg', '2018-09-14 14:30:12', '123', '1', '1', '2018-09-14 14:30:12');
INSERT INTO `tb_vehicle_brand` VALUES ('26', '464', 'http://blacktea-file.oss-cn-hangzhou.aliyuncs.com/201809/92501fca-2a6a-4339-8fdc-fccd974b3a26hua.jpg', '2018-09-25 15:34:35', '465', '1', '1', '2018-09-25 15:34:35');

-- ----------------------------
-- Table structure for tb_vehicle_model
-- ----------------------------
DROP TABLE IF EXISTS `tb_vehicle_model`;
CREATE TABLE `tb_vehicle_model` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '车型id',
  `name` varchar(32) NOT NULL COMMENT '车型名称',
  `energy_type` int(11) NOT NULL DEFAULT '3' COMMENT '能源类型：1-燃油、2-电动、3-混动',
  `car_code` varchar(32) DEFAULT NULL COMMENT '车型对应的car_code',
  `crt_time` datetime NOT NULL COMMENT '创建时间',
  `crt_uid` int(11) NOT NULL COMMENT '创建人id',
  `upd_uid` int(11) DEFAULT NULL COMMENT '修改人id',
  `upd_time` datetime DEFAULT NULL COMMENT '修改时间',
  `fuel_tank_cap` int(11) NOT NULL DEFAULT '0' COMMENT '油箱容量',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8 COMMENT='车辆的车型表';

-- ----------------------------
-- Records of tb_vehicle_model
-- ----------------------------
INSERT INTO `tb_vehicle_model` VALUES ('1', '奥迪A4L 30周年版 40 TFSI 时尚版2018款', '1', '1/1/1', '2018-08-16 10:04:21', '2', '1', '2018-09-14 14:42:56', '111');
INSERT INTO `tb_vehicle_model` VALUES ('2', '奥迪A4L 30周年版 40 TFSI 运动版2018款', '2', '1/1/2', '2018-08-16 10:04:52', '2', '1', '2018-09-14 14:41:32', '0');
INSERT INTO `tb_vehicle_model` VALUES ('3', '雅阁 混动 2.0L E-CVT 锐酷版2016款', '2', '2/3/3', '2018-08-25 21:34:00', '2', '2', '2018-09-04 09:17:04', '10033');
INSERT INTO `tb_vehicle_model` VALUES ('4', '雅阁 260TURBO 精英版2018款', '2', '2/3/4', '2018-08-25 21:33:57', '2', '1', '2018-09-18 17:37:02', '0');
INSERT INTO `tb_vehicle_model` VALUES ('5', '奥迪Q5 典藏版 40 TFSI 技术版2018款', '1', '1/2/5', '2018-08-25 21:34:23', '2', '1', '2018-09-18 15:30:11', '131');
INSERT INTO `tb_vehicle_model` VALUES ('6', '2015款 3.0L 智享版', '2', '3/4/6', '2018-08-24 21:46:47', '2', '1', '2018-09-14 14:35:41', '0');
INSERT INTO `tb_vehicle_model` VALUES ('11', '雅阁  2018款 260TURBO 精英版', '2', '2/3/11', '2018-08-30 10:45:42', '2', '1', '2018-09-18 17:37:34', '0');
INSERT INTO `tb_vehicle_model` VALUES ('14', '2018款 1.6L GDI 手动 风尚版', '2', '13/17/14', '2018-09-05 16:55:25', '2', '1', '2018-09-11 09:43:54', '0');
INSERT INTO `tb_vehicle_model` VALUES ('20', '测试版 雅阁', '2', '2/3/20', '2018-09-11 09:16:12', '1', '2', '2018-09-11 09:34:40', '0');

-- ----------------------------
-- Table structure for tb_vehicle_series
-- ----------------------------
DROP TABLE IF EXISTS `tb_vehicle_series`;
CREATE TABLE `tb_vehicle_series` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '表id',
  `car_code` varchar(32) DEFAULT NULL COMMENT '车牌品牌id',
  `name` varchar(50) NOT NULL COMMENT '车系名称',
  `description` varchar(255) DEFAULT NULL COMMENT '车系描述',
  `crt_time` datetime NOT NULL COMMENT '创建时间',
  `crt_uid` int(11) NOT NULL COMMENT '创建人id',
  `upd_uid` int(11) DEFAULT NULL COMMENT '修改人id',
  `upd_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COMMENT='车辆的车系表';

-- ----------------------------
-- Records of tb_vehicle_series
-- ----------------------------
INSERT INTO `tb_vehicle_series` VALUES ('1', '1/1', '奥迪A4', '测试A4111413', '2018-08-29 13:34:58', '2', '1', '2018-09-14 14:40:21');
INSERT INTO `tb_vehicle_series` VALUES ('2', '1/2', '奥迪Q5', '测试Q5', '2018-08-29 13:35:31', '2', '1', '2018-09-14 14:32:31');
INSERT INTO `tb_vehicle_series` VALUES ('3', '2/3', '本田雅阁', '测试雅阁', '2018-08-29 13:36:00', '2', '2', '2018-08-30 14:04:32');
INSERT INTO `tb_vehicle_series` VALUES ('4', '3/4', '大众辉腾', '测试辉腾', '2018-08-29 13:37:18', '2', '1', '2018-09-10 17:24:06');
INSERT INTO `tb_vehicle_series` VALUES ('12', '1/12', '奥迪Q7', '测试Q7', '2018-08-30 17:29:49', '2', '2', '2018-08-30 17:29:49');
INSERT INTO `tb_vehicle_series` VALUES ('17', '13/17', '长安逸动', '测试 长安逸动', '2018-09-05 16:50:18', '2', '1', '2018-09-18 17:33:41');
INSERT INTO `tb_vehicle_series` VALUES ('19', '13/19', '长安欧尚', '测试 长安欧尚', '2018-09-05 17:17:03', '2', '2', '2018-09-05 17:17:03');
INSERT INTO `tb_vehicle_series` VALUES ('20', '24/20', '111', '1115654', '2018-09-14 14:32:38', '1', '1', '2018-09-18 15:29:50');
