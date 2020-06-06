/*
SQLyog Community v13.1.6 (64 bit)
MySQL - 5.7.25-log : Database - z
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`z` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `z`;

/*Table structure for table `comment` */

DROP TABLE IF EXISTS `comment`;

CREATE TABLE `comment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `parent_comment_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `comment` */

insert  into `comment`(`id`,`username`,`email`,`content`,`create_time`,`parent_comment_id`) values 
(1,'游客小芳','xiaofang@qq.com','过来看看这是啥东西，不管先打赏先！','2020-05-30 19:47:41',-1);
insert  into `comment`(`id`,`username`,`email`,`content`,`create_time`,`parent_comment_id`) values 
(2,'美女小丽','xiaolibeauty@qq.com','本美女到此一游~','2020-05-30 19:52:57',-1);
insert  into `comment`(`id`,`username`,`email`,`content`,`create_time`,`parent_comment_id`) values 
(3,'老王','laowang@qq.com','我从隔壁过来了','2020-05-30 19:53:26',-1);
insert  into `comment`(`id`,`username`,`email`,`content`,`create_time`,`parent_comment_id`) values 
(4,'小王','xiaowang@qq.com','我也过来看看','2020-05-30 19:58:29',-1);
insert  into `comment`(`id`,`username`,`email`,`content`,`create_time`,`parent_comment_id`) values 
(5,'老王','laowang@qq.com','作业不写跑来上网？等下我就抽死你','2020-05-30 20:01:33',4);
insert  into `comment`(`id`,`username`,`email`,`content`,`create_time`,`parent_comment_id`) values 
(6,'老王','laowang@qq.com','嘿嘿 ， 加个微信呗美女！','2020-05-30 20:02:05',2);
insert  into `comment`(`id`,`username`,`email`,`content`,`create_time`,`parent_comment_id`) values 
(7,'小王','xiaowang@qq.com','。。。','2020-05-30 20:02:38',5);

/*Table structure for table `guess` */

DROP TABLE IF EXISTS `guess`;

CREATE TABLE `guess` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `question` varchar(255) NOT NULL,
  `answer` varchar(255) NOT NULL,
  `groupid` int(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=272 DEFAULT CHARSET=utf8;

/*Data for the table `guess` */

insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(1,'黄铜铃，紫铜铃，铜铃里面红铜芯。','枇杷',1);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(2,'有个老头子，头上张胡子，脱下绿袍子，满身是珠子。','玉米',1);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(3,'小白长得很像他哥哥。','真相大白',1);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(4,'红公鸡，绿尾巴，一头钻在地底下。','红皮萝卜',1);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(5,'红口袋，绿口袋，有人怕，有人爱。','辣椒',1);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(6,'黄金衣服包银条，中间弯弯两头翘。','香蕉',1);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(7,'嘴像小铲，脚像小扇，一走一晃，水上游荡。','鸭子',1);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(8,'一生都在忙，有花它在场，采回百花蜜，香甜胜过糖。','蜜蜂',1);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(9,'麻屋子，红帐子，里面睡个白胖子。','花生',1);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(10,'高高个儿戴草帽，天天对着太阳笑。','向日葵',1);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(11,'大眼睛，阔嘴巴，呱呱呱呱爱说话，捉虫能手就是它。','青蛙',1);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(12,'大红花儿头上戴，彩衣不用剪刀裁，清晨昂首歌一曲，唱的千门万户开。','公鸡',1);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(13,'看着是绿，吃着是红，吐出来是黑。','西瓜',1);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(14,'一把刀，水中漂，有眼睛，没眉毛。','鱼',1);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(15,'黄皮面子，白布果子，打开白布是梳子。','柚子',1);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(16,'身穿白袍子，头戴红帽子，走路像公子，说话大嗓子。','鹅',1);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(17,'翅膀薄又轻，两只大眼睛，身形像飞机，专门捉蚊蝇。','蜻蜓',1);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(18,'一座山，两个洞，进进出出都通风。','鼻',1);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(19,'上边毛，下边毛，中间有个黑葡萄。','眼镜',1);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(20,'紫色树，紫色花，紫花谢了结紫果，紫果肚里有芝麻。','茄子',1);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(21,'兄弟六七个，围着柱子坐，一旦要分开，衣服就撕破。','大蒜',1);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(24,'矮子骑大马','上下两难',2);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(25,'铁打的公鸡','毛不拔',2);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(26,'鸡蛋碰石头','不自量力',2);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(27,'姜太公钓鱼','愿者上钩',2);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(28,'脚踏西瓜皮','滑到哪里是哪里',2);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(29,'孔夫子搬家','净是书',2);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(30,'老鼠钻风箱','两头受气',2);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(31,'留得青山在','不怕没柴烧',2);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(32,'门缝里看人','把人看扁了',2);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(33,'扁担挑水','心挂了两头',2);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(34,'对牛弹琴','白费劲',2);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(35,'八仙聚会','神聊',2);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(36,'霸王敬酒','不干也得干',2);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(37,'背鼓上门','讨打',2);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(38,'麻雀子下鹅蛋','讲大话',2);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(39,'打肿脸','充胖子',2);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(40,'竹笋出土','节节高',2);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(41,'菜刀切豆腐','两面光',2);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(42,'钉头碰钉子','硬碰硬',2);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(43,'高山上敲鼓','四面闻名（鸣）',2);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(44,'狗咬吕洞宾','不识好人心',2);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(45,'关公走麦城','骄必败',2);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(46,'泥菩萨过河','自身难保',2);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(47,'泼出去的水','收不回',2);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(48,'骑驴看唱本','走着瞧',2);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(49,'千里送鹅毛','礼轻情意重',2);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(50,'肉包子打狗','有去无回',2);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(51,'山中无老虎','猴子称大王',2);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(52,'司马昭之心','路人皆知',2);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(53,'外甥打灯笼','照旧（舅）',2);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(54,'王八吃年糕','铁了心',2);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(55,'小葱拌豆腐','清二白',2);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(56,'小和尚念经','有口无心',2);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(57,'八仙过海','各显神通',2);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(58,'不入虎穴','焉得虎子',2);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(59,'蚕豆开花','黑心',2);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(60,'车到山前','必有路',2);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(61,'打破砂锅','问到底',2);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(62,'和尚打伞','无法（发）无天',2);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(63,'虎落平阳','被犬欺',2);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(64,'画蛇添足','多此一举',2);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(65,'周瑜打黄盖','两厢情愿',2);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(66,'赶鸭子上架','吃力不讨好',2);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(67,'擀面杖吹火','一窍不通',2);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(68,'瞎子戴眼镜','装饰',2);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(69,'猴子捞月亮','空忙一场',2);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(70,'秀才遇到兵','有理讲不清',2);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(71,'三个臭皮匠','顶个诸葛亮',2);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(72,'黄牛追兔子','有劲使不上',2);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(73,'和尚训道士','管得宽',2);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(74,'过年娶媳妇','双喜临门',2);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(75,'聋子见哑巴','不闻不问',2);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(76,'里弄里扛竹竿','直来直去',2);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(77,'苦水里泡黄连','苦上加苦',2);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(78,'驴唇不对马嘴','答非所问',2);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(79,'猪鼻子里插葱','装象',2);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(80,'只许州官放火','不许百姓点灯',2);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(81,'猪八戒照镜子','里外不是人',2);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(82,'放风筝断了线','没指望了',2);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(83,'池塘里的风波','大不了',2);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(84,'关门掩着耗子','急（挤）死',2);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(85,'顶风顶水划船','硬撑',2);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(86,'东北的二人转','一唱一和',2);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(87,'东洋人戴高帽','假充大个',2);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(88,'到火神庙求雨','找错了门',2);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(89,'鲁班门前耍斧','有眼无珠',2);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(90,'老太太吃汤圆','囫囵 吞',2);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(91,'出太阳下暴雨','假情（晴）',2);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(92,'挂羊头卖狗肉','虚情假意',2);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(93,'担着胡子过河','谦虚过度',2);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(94,'唱歌不看曲本','离谱',2);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(95,'箭在弦上','不得不发',2);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(96,'井底青蛙','目光短浅',2);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(97,'大海捞针','没处寻',2);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(98,'竹篮打水','一场空',2);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(99,'打开天窗','说亮话',2);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(100,'船到桥头','自会直',2);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(101,'飞蛾扑火','自取灭亡',2);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(102,'百米赛跑','分秒必争',2);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(103,'拔苗助长','急于求成',2);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(104,'仇人相见','分外眼红',2);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(105,'芝麻开花','节节高',2);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(106,'新官上任','三把火',2);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(107,'瞎子点灯','白费蜡',2);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(108,'兔子尾巴','长不了',2);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(109,'偷鸡不成','蚀把米',2);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(110,'王婆卖瓜','自卖自夸',2);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(111,'老虎屁股','摸不得',2);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(112,'老虎拉车','谁敢',2);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(113,'老鼠过街','人人喊 打',2);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(114,'麻雀虽小','五脏俱全',2);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(115,'墙上茅草','随风两边倒',2);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(116,'三十六计','走为上计',2);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(117,'塞翁失马','焉知祸福',2);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(118,'阴沟里洗手','假干净',2);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(119,'丈二和尚','摸不着头脑',2);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(120,'有借有还','再借不难',2);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(121,'猫哭耗子','假慈悲',2);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(122,'聋子的耳朵','摆样子',2);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(123,'饺子破皮','露了馅',2);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(124,'前程似锦创大业','春风得意展宏图',3);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(125,'迎新春快乐祥和','庆佳节顺意平安',3);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(126,'迎新春前程似锦','贺佳节事业辉煌',3);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(127,'万事如意展宏图','心想事成兴伟业',3);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(128,'喜居宝地千年旺','福照家门万事兴',3);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(129,'壮丽山河多异彩','文明国度遍高风',3);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(130,'一年四季春常在','万紫千红永开花',3);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(131,'年年顺景则源广','岁岁平安福寿多',3);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(132,'喜迎四季平安福','笑纳八方富贵财',3);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(133,'心想事成福临门','万事如意财运通',3);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(134,'和气生财长富贵','顺意平安永吉祥',3);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(135,'天赐鸿运财源广','地呈吉祥业兴旺',3);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(136,'一年好运随春到','四季彩云滚滚来',3);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(137,'欢天喜地度佳节','张灯结彩迎新春',3);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(138,'占天时地利人和','取九州四海财宝',3);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(139,'和顺一门有百福','平安二字值千金',3);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(140,'高居宝地财兴旺','福照家门富生辉',3);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(141,'迎新春事事如意','接鸿福步步高升',3);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(142,'创大业千秋昌盛','展宏图再就辉煌',3);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(143,'春归大地人间暖','福降神州喜临门',3);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(144,'一年四季行好运','八方财宝进家门',3);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(145,'荣华富贵财源广','吉祥如意喜临门',3);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(146,'财源滚滚随春到','喜气洋洋伴福来',3);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(147,'门迎富贵平安福','家庆祥和康乐年',3);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(148,'桃符早易朱红纸','春帖喜题吉庆词',3);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(149,'鸟鸣花艳春光好','人寿年丰喜事多',3);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(150,'瑞气满门吉祥宅','春风及第如意家',3);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(151,'吉星永照平安宅','五福常临积善家',3);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(152,'家过小康欢乐日','春回大地艳阳天',3);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(153,'阶前春色浓如许','户外风光翠欲流',3);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(154,'接天瑞雪千家乐','献岁梅花万朵香',3);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(155,'绿柳舒眉观新岁','红桃开口笑丰年',3);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(156,'大地流金万事通','冬去春来万象新',3);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(157,'和顺门第增百福','合家欢乐纳千祥',3);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(158,'天地和顺家添财','平安如意人多福',3);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(159,'一帆风顺年年好','万事如意步步高',3);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(160,'百年天地回元气','一统山河际太平',3);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(161,'迎新春江山锦绣','辞旧岁事泰辉煌',3);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(162,'日出江花红胜火','春来江水绿如蓝',3);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(163,'日日财源顺意来','年年福禄随春到',3);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(164,'富贵门庭财源进','黄金宝地事业兴',3);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(165,'朱门北启新春色','紫气东来大吉祥',3);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(166,'三春花露酿美酒','一腔激情写春秋',3);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(167,'山清水秀天地美','鸟语花香气象新',3);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(168,'天增岁月人增寿','春满人间福满门',3);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(169,'春归大地人间暖','福降神州喜临门',3);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(170,'春风送喜财入户','岁月更新福满门',3);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(171,'事事如意大吉祥','家家顺心永安康',3);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(172,'岁通盛世家家富','人遇年华个个欢',3);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(173,'五湖四海皆春色','万水千山尽得辉',3);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(174,'美酒千盅辞旧岁','梅花万树迎新春',3);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(175,'事业辉煌迎富贵','前程似锦庆荣华',3);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(176,'四海财源通宝地','九州鸿运进福门',3);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(177,'四海来财兴骏业','九州进宝铸辉煌',3);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(178,'吉祥如意财源到','幸福平安鸿运来',3);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(179,'门迎百福财运广','户纳千祥喜乐多',3);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(180,'一年四季春常在','万紫千红永开花',3);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(181,'大顺大财大吉利','新春新喜新世纪',3);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(182,'财运亨通步步高','日子红火腾腾起',3);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(183,'发愤图强兴大业','勤劳致富建小康',3);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(184,'精耕细作丰收岁','勤俭持家有余年',3);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(185,'一年四季行好运','八方财宝进家门',3);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(186,'福旺财旺运气旺','家兴人兴事业兴',3);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(187,'迎喜迎春迎富贵','接财接福接平安',3);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(188,'和顺一门有百福','平安二字值千金',3);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(189,'百世岁月当代好','千古江山今朝新',3);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(190,'内外平安好运来','合家欢乐财源进',3);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(191,'一干二净除旧习','五讲四美树新风',3);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(192,'一帆风顺年年好','万事如意步步高',3);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(193,'白雪银枝辞旧岁','和风细雨兆丰年',3);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(194,'春临华堂添瑞气','福到门庭起祥云',3);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(195,'春雨丝丝润万物','红梅点点绣千山',3);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(196,'欢声笑语贺新春','欢聚一堂迎新年',3);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(197,'家过小康欢乐日','春回大地艳阳天',3);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(198,'五湖四海皆春色','万水千山尽得辉',3);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(199,'门迎旭日财源广','户纳春风吉庆多',3);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(200,'创业门庭鸿运起','和睦宅院财源来',3);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(201,'朱红春帖千门瑞','翠绿柳风万户新',3);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(202,'新春富旺鸿运开','佳节吉祥如意来',3);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(203,'新春如意多富贵','佳节平安添吉祥',3);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(204,'花香满院花觉趣','鸟语飘林鸟知春',3);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(205,'万事胜意迎新春','千秋吉祥贺佳节',3);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(206,'财来运转家昌盛','心想事成万事兴',3);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(207,'花开富贵全家福','竹报平安满堂春',3);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(208,'春风入喜财入户','岁月更新福满门',3);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(209,'春风吹绿千枝柳','时雨催红万树花',3);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(210,'天增岁月人增寿','春满乾坤福满楼',3);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(211,'鼠年吉星高照','猪岁捷报频传',3);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(212,'天启三春美景','人描四化宏图',3);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(213,'不靠苍天赐福','全凭白手起家',3);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(214,'开创千秋大业','绘成四化宏图',3);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(215,'历尽酸甜苦辣','迎来洒脱风流',3);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(216,'日丽风和人乐','国强民富年丰',3);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(217,'日日生财有道','春春纳福无涯',3);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(218,'日丽风和春暖','党廉政善民安',3);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(219,'日暖风调雨顺','家和人寿年丰',3);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(220,'月圆常念家国','花好倍思眷亲',3);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(221,'月明五湖曙色','潮满三江春光',3);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(222,'风过红旗似画','春来绿水如烟',3);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(223,'风景这边独好','江山如此多娇',3);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(224,'风展红旗似画','春来绿水如蓝',3);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(225,'风正江山吐秀','心齐国运昌隆',3);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(226,'风展红旗如画','春来众志成城',3);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(227,'心似春花怒放','财如瑞雪翻飞',3);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(228,'认认真真办事','清清白白做人',3);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(229,'六合和平博爱','三江富裕常宁',3);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(230,'为江山添秀色','与日月争光辉',3);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(231,'为创甜蜜事业','何辞雨露风霜',3);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(232,'春到芙蓉国里','福临杨柳门前',3);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(233,'春风吹遍天涯','阳光普照人间',3);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(234,'春风春雨春花','新年新岁新景',3);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(235,'春风春雨春色','新年新岁新景',3);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(236,'华夏政通人杰','神州长治久安',3);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(237,'欢歌笑语辞旧','爆竹花灯迎新',3);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(238,'火树银花盛景','红梅绿柳新春',3);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(239,'家家恭喜致富','人人庆贺安康',3);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(240,'江山万里皆春','祖国前程似锦',3);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(241,'借问春从何至','皆言福自群生',3);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(242,'今日千家辞旧','明朝万户更新',3);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(243,'春意布满大地','阳光普照人间',3);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(244,'福日九州共乐','新年四海同春',3);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(245,'国贵安定团结','家宜勤俭节约',3);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(246,'和睦聚财致富','忠厚多福永安',3);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(247,'红梅初绽花二','东方风来又一',3);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(248,'虎跃龙骧鹏举','花明柳暗春浓',3);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(249,'喜爆声声报岁','红灯盏盏迎春',3);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(250,'细雨无声润物','和风会意迎春',3);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(251,'有竹有梅门第','半村半廓人家',3);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(252,'户户金花报喜','家家紫燕迎春',3);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(253,'水秀山明草茂','羊肥马壮春荣',3);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(254,'春风春雨春色','新岁新年新风',3);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(255,'春风花香鸟语','夜月书韵琴声',3);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(256,'春到碧桃树上','莺歌绿柳楼前',3);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(257,'春引百花竟放','福到人寿年丰',3);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(258,'春织千山锦绣','旗扬万里雄风',3);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(259,'北京赢来奥运','中国获得成功',3);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(260,'碧海苍山玉宇','春风丽日神州',3);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(261,'彩笔精描四化','红心巧绣三春',3);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(262,'千乡同歌国盛','万民共庆年丰',3);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(263,'处处欢歌遍地','家家喜笑连天',3);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(264,'处处明山秀水','家家笑语欢歌',3);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(265,'窗外红梅最艳','心头美景尤佳',3);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(266,'创造万千气象','建设两个文明',3);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(267,'春光洒满大地','彩霞映遍神州',3);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(268,'傲骨高风亮节','红梅翠竹青松',3);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(269,'白发同偕千岁','红心共映春秋',3);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(270,'白雪红梅报喜','黄莺紫燕迎春',3);
insert  into `guess`(`id`,`question`,`answer`,`groupid`) values 
(271,'春来鸟语花香','冬去山明水秀',3);

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `role` varchar(10) DEFAULT NULL,
  `gender` int(11) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `cdate` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10006 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`username`,`password`,`role`,`gender`,`email`,`cdate`) values 
(10000,'admin','cb812c2740486b0fdd6fd30423f89fb5','1',NULL,'319931482@qq.com','2020-05-30 20:03:41');
insert  into `user`(`id`,`username`,`password`,`role`,`gender`,`email`,`cdate`) values 
(10001,'小王','6732eb3ac94db96d344084181c7ee448',NULL,NULL,'xiaowang@qq.com','2020-05-30 19:41:06');
insert  into `user`(`id`,`username`,`password`,`role`,`gender`,`email`,`cdate`) values 
(10002,'老王','a3ae4ad5367d44d013368393ac250c10',NULL,NULL,'laowang@qq.com','2020-05-30 19:41:33');
insert  into `user`(`id`,`username`,`password`,`role`,`gender`,`email`,`cdate`) values 
(10003,'游客小芳','ada6e07e4d878117ae909a9ee2fb58c8',NULL,NULL,'xiaofang@qq.com','2020-05-30 19:45:48');
insert  into `user`(`id`,`username`,`password`,`role`,`gender`,`email`,`cdate`) values 
(10004,'美女小丽','85497018c873c8a31df9d29bd0b1ae22',NULL,NULL,'xiaolibeauty@qq.com','2020-05-30 19:46:12');
insert  into `user`(`id`,`username`,`password`,`role`,`gender`,`email`,`cdate`) values 
(10005,'yezihao','dd44765c878a63556de23a4dde2d3f52','1',1,'13650121303@163.com','2020-05-30 20:24:51');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
