-- 各種テーブル削除
--DROP TABLE IF EXISTS normal;
--DROP TABLE IF EXISTS premiere;
DROP TABLE IF EXISTS mem;
--DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS drink;
DROP TABLE IF EXISTS drinkcategory;
--DROP TABLE IF EXISTS checks;

---- 一般会員テーブル
--CREATE TABLE normal
--(
--	user_id SERIAL PRIMARY KEY,
--   	user_name TEXT,
--   	password TEXT,
--   	email TEXT,
--   	address TEXT,
--   	status TEXT
--);
--
---- プレミア会員テーブル
--CREATE TABLE premiere
--(
--	user_id SERIAL PRIMARY KEY,
--   	user_name TEXT,
--   	password TEXT,
--   	email TEXT,
--   	address TEXT,
--   	status TEXT
--);

--  会員テーブル
CREATE TABLE mem
(
	user_id SERIAL PRIMARY KEY,
	user_name TEXT,
   	password TEXT
   	);

----  会員テーブル
--CREATE TABLE users
--(
--	user_id SERIAL PRIMARY KEY,
--   	user_name TEXT,
--   	password TEXT,
--   	email TEXT,
--   	address TEXT,
--   	status TEXT,
--   	status_id INTEGER
--);

-- 商品一覧テーブル
CREATE TABLE drink
(
	drink_id SERIAL PRIMARY KEY,
	drink_name TEXT,
	price INTEGER,
	category_id INTEGER,
	amount INTEGER,
	factory TEXT
);

-- カテゴリーテーブル
CREATE TABLE drinkcategory
(
	category_id SERIAL PRIMARY KEY,
	category TEXT
);

---- 確認画面テーブル
--CREATE TABLE checks
--(
--	drink_id SERIAL PRIMARY KEY,
--	drink_name TEXT,
--	price INTEGER,
--	quantity INTEGER,
--	sub_total INTEGER,
--	main_total INTEGER
--);

