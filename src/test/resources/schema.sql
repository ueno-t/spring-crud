CREATE TABLE `users` (
  `USER_ID` char(36) NOT NULL COMMENT '共通ユーザー番号:共通ユーザー番号',
  `USER_TYPE` char(1) NOT NULL COMMENT 'ユーザータイプ種別:ユーザータイプ種別',
  `USER_NAME_KN` varchar(135) DEFAULT NULL COMMENT 'お名前(カナ):お名前(カナ)',
  `USER_NAME_KJ` varchar(135) DEFAULT NULL COMMENT 'お名前(漢字):お名前(漢字)',
  `BIRTHDAY` date DEFAULT NULL COMMENT '生年月日:生年月日',
  `CREATE_USER_ID` varchar(20) NOT NULL COMMENT '登録者ID:登録者ID',
  `CREATE_DATE` timestamp NOT NULL COMMENT '登録日時:登録日時',
  `UPDATE_USER_ID` varchar(20) NOT NULL COMMENT '更新者ID:更新者ID',
  `UPDATE_DATE` timestamp NOT NULL COMMENT '更新日時:更新日時',
  PRIMARY KEY (`USER_ID`),
  KEY `USERS_IX1` (`USER_NAME_KJ`),
  KEY `USERS_IX2` (`USER_NAME_KN`)
) DEFAULT CHARSET=utf8 COMMENT='ユーザー:ユーザー'
/