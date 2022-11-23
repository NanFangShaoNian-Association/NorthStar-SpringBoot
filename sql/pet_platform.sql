/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80023
 Source Host           : localhost:3306
 Source Schema         : pet_platform

 Target Server Type    : MySQL
 Target Server Version : 80023
 File Encoding         : 65001

 Date: 23/11/2022 17:32:35
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for address
-- ----------------------------
DROP TABLE IF EXISTS `address`;
CREATE TABLE `address`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '地址ID',
  `user_id` int(0) NULL DEFAULT NULL COMMENT '用户ID',
  `province_id` int(0) NULL DEFAULT NULL COMMENT '省ID',
  `city_id` int(0) NULL DEFAULT NULL COMMENT '市ID',
  `region_id` int(0) NULL DEFAULT NULL COMMENT '区ID',
  `detail_address` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '0' COMMENT '详细地址',
  `receiver` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收件人',
  `phone_number` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号码',
  `deleted` tinyint(0) NOT NULL DEFAULT 0 COMMENT '是否删除（0未删除，1已删除）',
  `is_default` tinyint(0) NULL DEFAULT NULL COMMENT '是否默认（0否，1默认）',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `create_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of address
-- ----------------------------

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '文章ID',
  `user_id` int(0) NULL DEFAULT NULL COMMENT '用户ID',
  `location_info_id` int(0) NULL DEFAULT NULL COMMENT '位置信息ID',
  `article_url` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文章url',
  `article_content` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '内容',
  `create_time` datetime(0) NOT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '发表时间',
  `cover_url` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '封面',
  `like_count` int(0) NULL DEFAULT NULL COMMENT '点赞数(默认0)',
  `collection_count` int(0) NULL DEFAULT NULL COMMENT '收藏数(默认0)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of article
-- ----------------------------
INSERT INTO `article` VALUES (1, 1, 1, '1', '123456789', '2022-11-21 20:36:33', '1', 1, 1);
INSERT INTO `article` VALUES (2, 2, 2, '2', '2', '2022-11-20 15:00:54', '2', 2, 2);
INSERT INTO `article` VALUES (3, 3, 3, '3', '3', '2022-11-20 15:01:01', '3', 3, 3);

-- ----------------------------
-- Table structure for article_collection
-- ----------------------------
DROP TABLE IF EXISTS `article_collection`;
CREATE TABLE `article_collection`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '文章收藏ID',
  `user_id` int(0) NULL DEFAULT NULL COMMENT '用户ID',
  `article_id` int(0) NULL DEFAULT NULL COMMENT '文章ID',
  `deleted` tinyint(0) NOT NULL DEFAULT 0 COMMENT '是否删除（0未删除，1已删除）',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of article_collection
-- ----------------------------

-- ----------------------------
-- Table structure for article_comment
-- ----------------------------
DROP TABLE IF EXISTS `article_comment`;
CREATE TABLE `article_comment`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '文章评论ID',
  `user_id` int(0) NULL DEFAULT NULL COMMENT '用户ID',
  `article_id` int(0) NULL DEFAULT NULL COMMENT '文章ID',
  `content` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '内容',
  `deleted` tinyint(0) NOT NULL DEFAULT 0 COMMENT '是否删除（0未删除，1已删除）',
  `is_read` tinyint(0) NOT NULL DEFAULT 0 COMMENT '是否已读（0未读，1已读）',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of article_comment
-- ----------------------------
INSERT INTO `article_comment` VALUES (1, 1, 1, '1', 0, 0, '2022-11-21 16:57:57');
INSERT INTO `article_comment` VALUES (2, 1, 1, '1', 0, 0, '2022-11-21 20:00:01');

-- ----------------------------
-- Table structure for article_tag
-- ----------------------------
DROP TABLE IF EXISTS `article_tag`;
CREATE TABLE `article_tag`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '文章标签ID',
  `user_id` int(0) NULL DEFAULT NULL COMMENT '用户ID',
  `tag_id` int(0) NULL DEFAULT NULL COMMENT '标签ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of article_tag
-- ----------------------------

-- ----------------------------
-- Table structure for cart_goods
-- ----------------------------
DROP TABLE IF EXISTS `cart_goods`;
CREATE TABLE `cart_goods`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '购物车商品ID',
  `user_id` int(0) NULL DEFAULT NULL COMMENT '用户ID',
  `goods_id` int(0) NULL DEFAULT NULL COMMENT '商品ID',
  `goods_quantity` int(0) NULL DEFAULT 1 COMMENT '商品数量',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cart_goods
-- ----------------------------

-- ----------------------------
-- Table structure for caution
-- ----------------------------
DROP TABLE IF EXISTS `caution`;
CREATE TABLE `caution`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '提醒ID',
  `pet_id` int(0) NULL DEFAULT NULL COMMENT '宠物ID',
  `type` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '类型',
  `time` datetime(0) NOT NULL COMMENT '时间',
  `remark` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `caution_duration` int(0) NULL DEFAULT NULL COMMENT '提醒间隔（秒）',
  `finished` tinyint(0) NOT NULL DEFAULT 0 COMMENT '是否完成（0未完成，1已完成）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of caution
-- ----------------------------

-- ----------------------------
-- Table structure for city
-- ----------------------------
DROP TABLE IF EXISTS `city`;
CREATE TABLE `city`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '市ID',
  `province_id` int(0) NULL DEFAULT NULL COMMENT '省ID',
  `city_name` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '市名',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of city
-- ----------------------------

-- ----------------------------
-- Table structure for discount_coupon
-- ----------------------------
DROP TABLE IF EXISTS `discount_coupon`;
CREATE TABLE `discount_coupon`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '优惠券ID',
  `price` int(0) NOT NULL COMMENT '优惠券金额',
  `conditions` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '优惠券使用条件',
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '优惠券名',
  `expiration_date` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '有效期',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of discount_coupon
-- ----------------------------

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '商品ID',
  `merchant_id` int(0) NULL DEFAULT NULL COMMENT '商家ID',
  `merchant_type_id` int(0) NULL DEFAULT NULL COMMENT '商品类型ID',
  `merchant_info_id` int(0) NULL DEFAULT NULL COMMENT '商品信息ID',
  `title` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品标题',
  `introducation` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '简介',
  `price` int(0) NULL DEFAULT NULL COMMENT '价格',
  `goods_stocks` int(0) NULL DEFAULT NULL COMMENT '商品库存',
  `total_quantity` int(0) NULL DEFAULT NULL COMMENT '商品总数量',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES (1, 1, 1, 1, '11', '1111', 111, 111, 111, '2022-11-22 21:20:38', '2022-11-22 21:20:40');
INSERT INTO `goods` VALUES (2, 2, 2, 2, '22', '2222', 222, 222, 222, '2022-11-22 21:20:42', '2022-11-22 21:20:45');

-- ----------------------------
-- Table structure for health_info
-- ----------------------------
DROP TABLE IF EXISTS `health_info`;
CREATE TABLE `health_info`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '健康记录ID',
  `pet_id` int(0) NULL DEFAULT NULL COMMENT '宠物ID',
  `type` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '类型',
  `time` datetime(0) NOT NULL COMMENT '时间',
  `remark` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of health_info
-- ----------------------------

-- ----------------------------
-- Table structure for merchant
-- ----------------------------
DROP TABLE IF EXISTS `merchant`;
CREATE TABLE `merchant`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '商家ID',
  `user_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名，随机生成',
  `account` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '账号',
  `password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `avatar` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'http://jiatouxiang.com/hhh.jpg' COMMENT '头像',
  `registration_time` datetime(0) NOT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '注册时间',
  `login_time` datetime(0) NULL DEFAULT NULL COMMENT '登录时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of merchant
-- ----------------------------

-- ----------------------------
-- Table structure for merchant_comment
-- ----------------------------
DROP TABLE IF EXISTS `merchant_comment`;
CREATE TABLE `merchant_comment`  (
  `id` int(0) NOT NULL COMMENT '商品评价ID',
  `goods_id` int(0) NULL DEFAULT NULL COMMENT '商品id',
  `reviewer_id` int(0) NULL DEFAULT NULL COMMENT '评论者ID',
  `replier_id` int(0) NULL DEFAULT NULL COMMENT '回复者ID',
  `type` tinyint(0) NOT NULL COMMENT '内容类型（0文本，1表情包，2图片）',
  `content` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '内容',
  `deleted` tinyint(0) NOT NULL DEFAULT 0 COMMENT '是否删除（0未删除，1已删除）',
  `is_read` tinyint(0) NOT NULL DEFAULT 0 COMMENT '是否已读（0未读，1已读）',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of merchant_comment
-- ----------------------------
INSERT INTO `merchant_comment` VALUES (1, 1, 1, 1, 1, '1', 0, 0, '2022-11-22 22:18:58');
INSERT INTO `merchant_comment` VALUES (2, 1, 1, 1, 1, '1', 0, 0, '2022-11-22 22:19:07');

-- ----------------------------
-- Table structure for merchant_images
-- ----------------------------
DROP TABLE IF EXISTS `merchant_images`;
CREATE TABLE `merchant_images`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '商品图片ID',
  `merchant_id` int(0) NULL DEFAULT NULL COMMENT '商品ID',
  `image_url` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图片',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of merchant_images
-- ----------------------------
INSERT INTO `merchant_images` VALUES (1, 1, '1');
INSERT INTO `merchant_images` VALUES (2, 1, '1');
INSERT INTO `merchant_images` VALUES (3, 1, '1');
INSERT INTO `merchant_images` VALUES (4, 2, '2');

-- ----------------------------
-- Table structure for merchant_info
-- ----------------------------
DROP TABLE IF EXISTS `merchant_info`;
CREATE TABLE `merchant_info`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '商品信息ID',
  `detail_content` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '具体内容',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of merchant_info
-- ----------------------------
INSERT INTO `merchant_info` VALUES (1, '11111');

-- ----------------------------
-- Table structure for merchant_type
-- ----------------------------
DROP TABLE IF EXISTS `merchant_type`;
CREATE TABLE `merchant_type`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '商品类型ID',
  `type` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '类型',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of merchant_type
-- ----------------------------

-- ----------------------------
-- Table structure for message_info
-- ----------------------------
DROP TABLE IF EXISTS `message_info`;
CREATE TABLE `message_info`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '消息记录ID',
  `sender_id` int(0) NULL DEFAULT NULL COMMENT '发送者ID',
  `receiver_id` int(0) NULL DEFAULT NULL COMMENT '接受者ID',
  `content_type` tinyint(0) NOT NULL COMMENT '内容类型（0文本，1表情包，2图片，3视频）',
  `content` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '内容',
  `deleted` tinyint(0) NOT NULL DEFAULT 0 COMMENT '是否删除（0未删除，1已删除）',
  `is_read` tinyint(0) NOT NULL DEFAULT 0 COMMENT '是否已读（0未读，1已读）',
  `create_time` datetime(0) NOT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of message_info
-- ----------------------------

-- ----------------------------
-- Table structure for order_info
-- ----------------------------
DROP TABLE IF EXISTS `order_info`;
CREATE TABLE `order_info`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '订单ID',
  `user_id` int(0) NULL DEFAULT NULL COMMENT '用户ID',
  `goods_id` int(0) NULL DEFAULT NULL COMMENT '商品ID',
  `merchant_id` int(0) NULL DEFAULT NULL COMMENT '商家ID',
  `ship_address_id` int(0) NULL DEFAULT NULL COMMENT '收货地址ID',
  `order_no` int(0) NULL DEFAULT NULL COMMENT '商户订单编号',
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单标题',
  `total_fee` int(0) NULL DEFAULT NULL COMMENT '订单金额（分）',
  `code_url` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单二维码链接',
  `order_status` int(0) NULL DEFAULT NULL COMMENT '订单状态（0待发货，1已发货，2待收货，3已完成，4待退款）',
  `order_remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单备注',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order_info
-- ----------------------------
INSERT INTO `order_info` VALUES (1, 1, 1, 1, 1, 1, '1', 1, '1', 1, NULL, '2022-11-22 12:06:51', '2022-11-22 12:06:54');
INSERT INTO `order_info` VALUES (2, 1, 1, 1, 1, 1, '1', 1, '1', 1, NULL, '2022-11-22 12:07:03', '2022-11-22 12:07:05');

-- ----------------------------
-- Table structure for payment_info
-- ----------------------------
DROP TABLE IF EXISTS `payment_info`;
CREATE TABLE `payment_info`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '支付记录ID',
  `order_info_id` int(0) NULL DEFAULT NULL COMMENT '订单ID',
  `transaction_no` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '支付系统交易编号',
  `payment_type` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '支付类型',
  `trade_type` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '交易类型',
  `trade_state` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '交易状态',
  `payer_total` int(0) NULL DEFAULT NULL COMMENT '支付金额',
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '通知参数',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of payment_info
-- ----------------------------

-- ----------------------------
-- Table structure for pet
-- ----------------------------
DROP TABLE IF EXISTS `pet`;
CREATE TABLE `pet`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '宠物ID',
  `master_id` int(0) NULL DEFAULT NULL COMMENT '主人ID',
  `pet_variety_id` int(0) NULL DEFAULT NULL COMMENT '宠物品种ID',
  `nick_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '宠物名',
  `birthday` datetime(0) NULL DEFAULT NULL COMMENT '生日',
  `avatar` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'http://jiatouxiang.com/jiade.jpg' COMMENT '照片',
  `gender` char(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '未指定' COMMENT '性别（GG，MM，绝育GG，绝育MM，未指定）',
  `type` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '生物类型（喵星人、汪星人、其他）',
  `sterilization_status` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '健康' COMMENT '绝育情况',
  `insect_repellent_status` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '驱虫情况',
  `vaccine_status` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '疫苗情况',
  `create_time` datetime(0) NOT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of pet
-- ----------------------------

-- ----------------------------
-- Table structure for pet_variety
-- ----------------------------
DROP TABLE IF EXISTS `pet_variety`;
CREATE TABLE `pet_variety`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '宠物品种ID',
  `pet_variety_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '宠物品种名',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of pet_variety
-- ----------------------------

-- ----------------------------
-- Table structure for platform_administrator
-- ----------------------------
DROP TABLE IF EXISTS `platform_administrator`;
CREATE TABLE `platform_administrator`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '平台管理员ID',
  `user_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名，随机生成',
  `account` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '账号',
  `password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `avatar` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'http://jiatouxiang.com/hhh.jpg' COMMENT '头像',
  `registration_time` datetime(0) NOT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '注册时间',
  `login_time` datetime(0) NULL DEFAULT NULL COMMENT '登录时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of platform_administrator
-- ----------------------------

-- ----------------------------
-- Table structure for province
-- ----------------------------
DROP TABLE IF EXISTS `province`;
CREATE TABLE `province`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '省ID',
  `province_name` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '省名',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of province
-- ----------------------------

-- ----------------------------
-- Table structure for refund_info
-- ----------------------------
DROP TABLE IF EXISTS `refund_info`;
CREATE TABLE `refund_info`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '退款单ID',
  `order_info_id` int(0) NULL DEFAULT NULL COMMENT '订单ID',
  `refund_order_info_id` int(0) NULL DEFAULT NULL COMMENT '商户退款单ID',
  `refund_no` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '支付系统退款单号',
  `total_fee` int(0) NULL DEFAULT NULL COMMENT '原订单金额（分）',
  `refund` int(0) NULL DEFAULT NULL COMMENT '退款金额（分）',
  `reason` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '退款原因',
  `refund_status` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '退款状态',
  `content_return` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '申请退款返回参数',
  `content_notify` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '退款结果通知参数',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of refund_info
-- ----------------------------

-- ----------------------------
-- Table structure for region
-- ----------------------------
DROP TABLE IF EXISTS `region`;
CREATE TABLE `region`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '区ID',
  `city_id` int(0) NULL DEFAULT NULL COMMENT '市ID',
  `region` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '区名',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of region
-- ----------------------------

-- ----------------------------
-- Table structure for session
-- ----------------------------
DROP TABLE IF EXISTS `session`;
CREATE TABLE `session`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '会话ID',
  `user1_id` int(0) NULL DEFAULT NULL COMMENT '用户1ID',
  `user2_id` int(0) NULL DEFAULT NULL COMMENT '用户2ID',
  `last_content` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '最后内容',
  `last_content_type` tinyint(0) NULL DEFAULT NULL COMMENT '内容类型（0文本，1表情包，2图片，3视频）',
  `last_content_time` datetime(0) NULL DEFAULT NULL COMMENT '最后时间',
  `deleted` tinyint(0) NOT NULL DEFAULT 0 COMMENT '是否删除（0未删除，1已删除）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of session
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `user_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名，随机生成',
  `phone` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '手机号',
  `avatar` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'http://jialianjie.com/jiatupian.png' COMMENT '头像',
  `gender` char(5) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '男' COMMENT '性别（男，女，未指定）',
  `introduction` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '简介',
  `age` tinyint(0) NULL DEFAULT NULL COMMENT '年龄',
  `place` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地区',
  `last_login_ip` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '最后一次登陆的IP',
  `last_login_ip_place` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '最后一次登陆的IP属地',
  `registration_time` datetime(0) NOT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '注册时间',
  `login_time` datetime(0) NULL DEFAULT NULL COMMENT '最后一次登录时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '11', '1', 'http://jialianjie.com/jiatupian.png', '男', '1', 1, '1', '1', '1', '2022-11-20 18:09:06', '2022-11-20 18:09:09');
INSERT INTO `user` VALUES (2, '22', '2', 'http://jialianjie.com/jiatupian.png', '男', '2', 2, '2', '2', '2', '2022-11-20 18:09:21', '2022-11-20 18:09:24');

-- ----------------------------
-- Table structure for user_follow
-- ----------------------------
DROP TABLE IF EXISTS `user_follow`;
CREATE TABLE `user_follow`  (
  `id` int(0) NOT NULL COMMENT '关注ID',
  `blogger_id` int(0) NULL DEFAULT NULL COMMENT '博主ID',
  `fans_id` int(0) NULL DEFAULT NULL COMMENT '粉丝ID',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `create_time` datetime(0) NOT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_follow
-- ----------------------------

-- ----------------------------
-- Table structure for video
-- ----------------------------
DROP TABLE IF EXISTS `video`;
CREATE TABLE `video`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '视频ID',
  `user_id` int(0) NULL DEFAULT NULL COMMENT '用户ID',
  `location_info_id` int(0) NULL DEFAULT NULL COMMENT '位置信息ID',
  `video_url` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '视频url',
  `video_content` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '内容',
  `create_time` datetime(0) NOT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '发表时间',
  `title` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '标题',
  `cover_url` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '封面',
  `like_count` int(0) NULL DEFAULT NULL COMMENT '点赞数(默认0)',
  `collection_count` int(0) NULL DEFAULT NULL COMMENT '收藏数(默认0)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of video
-- ----------------------------
INSERT INTO `video` VALUES (1, 1, 1, '1', '12345678', '2022-11-21 22:05:50', '1', '1', 1, 1);
INSERT INTO `video` VALUES (2, 2, 2, '2', '23456789', '2022-11-21 22:05:55', '2', '2', 2, 2);

-- ----------------------------
-- Table structure for video_collection
-- ----------------------------
DROP TABLE IF EXISTS `video_collection`;
CREATE TABLE `video_collection`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '视频收藏ID',
  `user_id` int(0) NULL DEFAULT NULL COMMENT '用户ID',
  `video_id` int(0) NULL DEFAULT NULL COMMENT '视频ID',
  `deleted` tinyint(0) NOT NULL DEFAULT 0 COMMENT '是否删除（0未删除，1已删除）',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of video_collection
-- ----------------------------

-- ----------------------------
-- Table structure for video_comment
-- ----------------------------
DROP TABLE IF EXISTS `video_comment`;
CREATE TABLE `video_comment`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '视频评论ID',
  `user_id` int(0) NULL DEFAULT NULL COMMENT '用户ID',
  `video_id` int(0) NULL DEFAULT NULL COMMENT '视频ID',
  `content` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '内容',
  `deleted` tinyint(0) NOT NULL DEFAULT 0 COMMENT '是否删除（0未删除，1已删除）',
  `is_read` tinyint(0) NOT NULL DEFAULT 0 COMMENT '是否已读（0未读，1已读）',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of video_comment
-- ----------------------------
INSERT INTO `video_comment` VALUES (1, 1, 1, '1', 0, 0, '2022-11-21 22:25:20');
INSERT INTO `video_comment` VALUES (2, 1, 1, '1', 0, 0, '2022-11-21 22:25:30');

-- ----------------------------
-- Table structure for video_tag
-- ----------------------------
DROP TABLE IF EXISTS `video_tag`;
CREATE TABLE `video_tag`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '视频标签ID',
  `user_id` int(0) NULL DEFAULT NULL COMMENT '用户ID',
  `tag_id` int(0) NULL DEFAULT NULL COMMENT '标签ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of video_tag
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
