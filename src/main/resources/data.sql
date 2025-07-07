-- 一般会員テーブルデータ
INSERT INTO normal(user_name, password, email, address, status) VALUES( '周東佑京', 'himitu', 'syutou210@aaa', '福岡県福岡市中央地行浜2-2-2', '一般会員');

-- プレミア会員テーブルデータ
INSERT INTO premiere(user_name, password, email, address, status) VALUES( '柳田悠岐', 'himitu', 'gita1009@aaa', '福岡県福岡市中央地行浜2-2-2', 'プレミア会員');

-- 商品一覧テーブルデータ
INSERT INTO drink(drink_name, price, category, amount, factory) VALUES('厳選静岡茶', 250, 'お茶', 650, 'イ・トウエン');
INSERT INTO drink(drink_name, price, category, amount, factory) VALUES('BASS', 120 ,'コーヒー', 500, 'SONTORY');
INSERT INTO drink(drink_name, price, category, amount, factory) VALUES('いろばす', 100 ,'水', 500, 'コ・カコーラ');
INSERT INTO drink(drink_name, price, category, amount, factory) VALUES('クラフトコーラ', 120 ,'清涼飲料水', 350, 'コ・カコーラ');
INSERT INTO drink(drink_name, price, category, amount, factory) VALUES('エベレストの水', 200 ,'水', 1000, 'ネパール株式会社');
INSERT INTO drink(drink_name, price, category, amount, factory) VALUES('おいしいお茶', 120 ,'お茶', 600, 'イ・トウエン');
INSERT INTO drink(drink_name, price, category, amount, factory) VALUES('ポカエリアス', 130 ,'清涼飲料水', 550, 'コ・カコーラ');
INSERT INTO drink(drink_name, price, category, amount, factory) VALUES('GEORGIAN', 150 ,'コーヒー', 300, 'コ・カコーラ');