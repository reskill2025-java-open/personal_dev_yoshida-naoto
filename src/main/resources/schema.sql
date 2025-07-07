-- 各種テーブル削除
DROP TABLE IF EXISTS normal;
DROP TABLE IF EXISTS premiere;
DROP TABLE IF EXISTS drink;
DROP TABLE IF EXISTS checks;

-- 一般会員テーブル
CREATE TABLE normal
(
	user_id SERIAL PRIMARY KEY,
   	user_name TEXT,
   	password TEXT,
   	email TEXT,
   	address TEXT,
   	status TEXT
);

-- プレミア会員テーブル
CREATE TABLE premiere
(
	user_id SERIAL PRIMARY KEY,
   	user_name TEXT,
   	password TEXT,
   	email TEXT,
   	address TEXT,
   	status TEXT
);

-- 商品一覧テーブル
CREATE TABLE drink
(
	drink_id SERIAL PRIMARY KEY,
	drink_name TEXT,
	price INTEGER,
	category TEXT,
	amount INTEGER,
	factory TEXT
);

-- 確認画面テーブル
CREATE TABLE checks
(
	drink_id SERIAL PRIMARY KEY,
	drink_name TEXT,
	price INTEGER,
	quantity INTEGER,
	sub_total INTEGER,
	main_total INTEGER
);

