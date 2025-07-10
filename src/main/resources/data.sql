---- 一般会員テーブルデータ
--INSERT INTO normal(user_name, password, email, address, status) VALUES( '周東佑京', 'himitu', 'syutou210@aaa', '福岡県福岡市中央地行浜2-2-2', '一般会員');
--
---- プレミア会員テーブルデータ
--INSERT INTO premiere(user_name, password, email, address, status) VALUES( '柳田悠岐', 'himitu', 'gita1009@aaa', '福岡県福岡市中央地行浜2-2-2', 'プレミア会員');

-- 会員テーブルデータ
INSERT INTO users(user_name, password, email, address, status, status_id) VALUES( '周東佑京', 'himitu', 'syutou210@aaa', '福岡県福岡市中央地行浜2-2-2', '一般会員', 1);
INSERT INTO users(user_name, password, email, address, status, status_id) VALUES( '柳田悠岐', 'himitu', 'gita1009@aaa', '福岡県福岡市中央地行浜2-2-2', 'プレミア会員', 2);

-- 商品一覧テーブルデータ
INSERT INTO drink(drink_name, price, category_id, amount, factory) VALUES('厳選静岡茶', 250, 2, 650, 'イ・トウエン');
INSERT INTO drink(drink_name, price, category_id, amount, factory) VALUES('BASS', 120 ,4, 500, 'SONTORY');
INSERT INTO drink(drink_name, price, category_id, amount, factory) VALUES('いろばす', 100 ,3, 500, 'コ・カコーラ');
INSERT INTO drink(drink_name, price, category_id, amount, factory) VALUES('クラフトコーラ', 120 ,5, 350, 'コ・カコーラ');
INSERT INTO drink(drink_name, price, category_id, amount, factory) VALUES('エベレストの水', 200 ,3, 1000, 'ネパール株式会社');
INSERT INTO drink(drink_name, price, category_id, amount, factory) VALUES('おいしいお茶', 120 ,2, 600, 'イ・トウエン');
INSERT INTO drink(drink_name, price, category_id, amount, factory) VALUES('ポカエリアス', 130 ,5, 550, 'コ・カコーラ');
INSERT INTO drink(drink_name, price, category_id, amount, factory) VALUES('GEORGIAN', 150 ,4, 300, 'コ・カコーラ');

-- カテゴリーテーブルデータ
INSERT INTO drinkcategory(category) VALUES('全商品');
INSERT INTO drinkcategory(category) VALUES('お茶');
INSERT INTO drinkcategory(category) VALUES('水');
INSERT INTO drinkcategory(category) VALUES('コーヒー');
INSERT INTO drinkcategory(category) VALUES('清涼飲料水');
