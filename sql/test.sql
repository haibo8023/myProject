/*
 Navicat MySQL Data Transfer

 Source Server         : 127.0.0.1_3306
 Source Server Type    : MySQL
 Source Server Version : 80011
 Source Host           : 192.168.2.198:3306
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 80011
 File Encoding         : 65001

 Date: 30/08/2018 11:33:16
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_customer
-- ----------------------------
DROP TABLE IF EXISTS `t_customer`;
CREATE TABLE `t_customer`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `city` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `customer` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `latitude` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `longitude` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `city`(`city`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_customer
-- ----------------------------
INSERT INTO `t_customer` VALUES (1, '南京市', 'qkzIESWIBkJyZUFnBsoNRSyMfithw04IhxRjAs6BI56A3fJYC_XbnHnY0DwE028olHdh0BqBwXnR9sQWPOdc_ZSIPfzz5Xu4GEMg9ideAMbPA7CcKwcgDNoFzQV78__ilCm9YU14MQxbSVbXMUKPIDuCL5EwwRPY3qTTp5_mhJ8=', NULL, NULL);
INSERT INTO `t_customer` VALUES (2, '北京市', 'mpGhxbaLBJbkP-t-BCeTYsRBnHMIuO7Z16LI2Ugi_0tdn2r33-7bpxRlIur3v31gM6myzjj2SdAMoKvD8Pp2BmB7nDWKI522awPcoEiWqvHc2m2g1Ne2AijTDEhfxr9v-wAtvBVWjbzh6htGaKpK-INorKKEUpLUWa79Maarf18=', '39.904602', '116.406987');
INSERT INTO `t_customer` VALUES (3, '上海市', 'rlHlJphEsh-G37vg2Gp5KOcpHoFfPjJNsI41xW_22jc2-skEam_SvyeQLp14R91MV73mgxgOhBQjju5FPFu5FXe3WOmwWzHzfmZeghF2ARNgJNqhP7QJPyPOI7knvn7SQc-W0W5VURbJPpP9d8lei_hL_mrAIWQVULeeNDLyKCs=', '31.229983', '121.473989');
INSERT INTO `t_customer` VALUES (4, '乌鲁木齐市', 'UdtgIPheY4JBtjY0jR8OMJQD5dMiiL3cNdFTtXj7Pk9h90z2s7tflVidUEWSuLTZ-p-v5MQb-7IyEEC-dApUbuFjdx-UEKuUywz5EzR-oCmBiqeRP4DYe2x3MMVIiOytpKJZ98Odr-V8mFQF2duAC9PQxy16TITX7I3NL87-EUQ=', '43.793234', '87.627013');
INSERT INTO `t_customer` VALUES (5, '银川市', 'gQTie5JySKcLthEWKU4xmlPBL1lVEhcBIDXwZmaFfGvfKSe_FHuYjCCRDrLtWfwm3V85k-fsseTWLG9YaTeUC5kkS6nMb6BWRD73RkOm6w0jEqt9HutSWD_6mTdHs822-T5Fu3rE-7zXKogfSVt9H4-Yb7U3LZdC7Jntthi8SQ4=', '38.548675', '106.370048');
INSERT INTO `t_customer` VALUES (6, '重庆市', 'PebNYk1B9e7BSncGS-CicNDXGEbK5SZKzbd7evvFxEE-BQXdmpb8TK1BoOQjUjJ4748TMW6epAdGlId6W8TqaZeFq52SZW7Wz2Yt_G-ADKpHJvlxNqisLW50cqd_QqtyzRMKWs5qzto7ded22QsJV9VdrxvbmZy13wfxLnIHRnc=', '29.562709', '106.552002');
INSERT INTO `t_customer` VALUES (7, '青岛市', 'y5xcSlpqidgpEmLXfeoz1XdQr3tZ2DuKWsI8-ba9fLyPqeCAHImLBvjxDp_w22W9J2nv_DKnI1WoHhclri45q8W_m6EqNIHlBNQgmY0B5vwxTlzqqXU2n1K5WNjFeYRFV-ijNwgMKTYCykkHM8RCH7Q66OORmsFn86p72_R-KeQ=', '36.066095', '120.382995');
INSERT INTO `t_customer` VALUES (8, '绍兴市', 'GiETI5u6cgYjq0UMyOvulIQx9cFD060VLVKTk2xtk0FPDIyjZETQhnK6I4vBczItwTp6NkkPgM9Eb0l3XZkcIt2FFbTbf4S8NP3quJ2f7kW1h1rcRZlYFc92LALabpBaXlm9Ttr4cdPUa7ZwJJqyqS6eiRp9p5bhENVRs9J_CMI=', '29.983091', '120.587631');

SET FOREIGN_KEY_CHECKS = 1;
