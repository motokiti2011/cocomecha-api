SET CHARSET UTF8;
CREATE DATABASE IF NOT EXISTS testdb DEFAULT CHARACTER SET utf8;

CREATE DATABASE IF NOT EXISTS testdb;
USE testdb;

CREATE TABLE IF NOT EXISTS cars (
    id INT NOT NULL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    price INT NOT NULL DEFAULT 0,
    created TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO cars(id, name, price) VALUES (1, 'カローラ　クロス', 21780)
    ON DUPLICATE KEY UPDATE id = VALUES (id);

INSERT INTO cars(id, name, price) VALUES (2, 'RAIZE', 16170)
    ON DUPLICATE KEY UPDATE id = VALUES (id);

INSERT INTO cars(id, name, price) VALUES (3, 'ルーミー', 14630)
    ON DUPLICATE KEY UPDATE id = VALUES (id);

INSERT INTO cars(id, name, price) VALUES (4, 'アクア', 19580)
    ON DUPLICATE KEY UPDATE id = VALUES (id);

INSERT INTO cars(id, name, price) VALUES (5, 'ハリアー', 26510)
    ON DUPLICATE KEY UPDATE id = VALUES (id);

INSERT INTO cars(id, name, price) VALUES (6, 'アルファード', 38280)
    ON DUPLICATE KEY UPDATE id = VALUES (id);

INSERT INTO cars(id, name, price) VALUES (7, 'ヤリス2WD', 14960)
    ON DUPLICATE KEY UPDATE id = VALUES (id);

INSERT INTO cars(id, name, price) VALUES (8, 'ヤリス　クロス', 21010)
    ON DUPLICATE KEY UPDATE id = VALUES (id);

INSERT INTO cars(id, name, price) VALUES (9, 'RAV4', 27610)
    ON DUPLICATE KEY UPDATE id = VALUES (id);

INSERT INTO cars(id, name, price) VALUES (10, 'プリウス', 18700)
    ON DUPLICATE KEY UPDATE id = VALUES (id);


-- ユーザー情報
CREATE TABLE IF NOT EXISTS user_detail (
    user_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    user_name VARCHAR(255) NOT NULL,
    mail_adress VARCHAR(255) NOT NULL,
    area VARCHAR(255) NOT NULL,
    corporation_div VARCHAR(255)NOT NULL,
    office_name VARCHAR(255),
    introduction VARCHAR(255),
    created TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated TIMESTAMP
);


INSERT INTO user_detail
(user_id, user_name, mail_adress, area, corporation_div, office_name, introduction ) 
VALUES (1, '田中', 'email@.com', '1', '0' , '' , 'テストユーザ１' )
    ON DUPLICATE KEY UPDATE user_id = VALUES (user_id);

INSERT INTO user_detail(user_id, user_name, mail_adress, area, corporation_div, office_name, introduction ) 
VALUES (2, '田中', 'emaily@.com', '1', '1' , '山田自動車' , 'テストユーザ２' )
    ON DUPLICATE KEY UPDATE user_id = VALUES (user_id);

/** 保留**************************************************************************/
-- ログイン
CREATE TABLE IF NOT EXISTS user_login (
    loginid VARCHAR(255)  NOT NULL PRIMARY KEY,
    password VARCHAR(255) NOT NULL,
    mailaddress VARCHAR(255)  NOT NULL,
    userid VARCHAR(255) NOT NULL,
    name VARCHAR(255) NOT NULL,
    admin VARCHAR(255) NOT NULL,
    created TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO user_login(loginid, mailaddress, password, userid,name, admin) 
VALUES ("test", "test", '$2a$10$6.f.KpSWL4kFQl9L8qMs3eG4GLt3m93fMNFgWnGIYv0BKwPDjHi6a', '1', '一郎', 'true')
    ON DUPLICATE KEY UPDATE loginid = VALUES (loginid);


-- -- ユーザー
-- CREATE TABLE IF NOT EXISTS user (
--     mailaddress VARCHAR(255)  NOT NULL PRIMARY KEY,
--     encodedPassword VARCHAR(255) NOT NULL,
--     name VARCHAR(255) NOT NULL,
--     roles VARCHAR(255) NOT NULL,
-- );

-- -- パーミッション
-- CREATE TABLE IF NOT EXISTS permission (
--     user_id INT NOT NULL PRIMARY KEY,
--     name VARCHAR(255) NOT NULL,
--     alias VARCHAR(255) NOT NULL,
-- );

-- -- ロール
-- CREATE TABLE IF NOT EXISTS role (
--     user_id INT  NOT NULL PRIMARY KEY,
--     name VARCHAR(255) NOT NULL,
--     alias VARCHAR(255) NOT NULL,
--     permissions VARCHAR(255) NOT NULL,
-- );
/** **************************************************************************/

-- ユーザー車両情報　ユーザーに紐づく車両情報
CREATE TABLE IF NOT EXISTS user_vehicle (
    user_id VARCHAR(255) NOT NULL PRIMARY KEY,
    vehicle_name VARCHAR(255) NOT NULL,
    vehicle_no VARCHAR(255),
    chassis_no VARCHAR(255),
    designated_classification VARCHAR(255) ,
    coler VARCHAR(255),
    coler_no VARCHAR(255),
    first_registration_date VARCHAR(255),
    inspection_expiration_date VARCHAR(255),
    created TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated TIMESTAMP
);

INSERT INTO user_vehicle
(user_id, vehicle_name, vehicle_no, chassis_no, designated_classification, coler, coler_no, first_registration_date, Inspection_expiration_date) 
VALUES 
('1', 'ムーヴ', '福岡580ふ1234', 'LA100-1234567', '12345-0001' , '黒' , 'C12','202001','20220131' )
    ON DUPLICATE KEY UPDATE user_id = VALUES (user_id);


-- 伝票情報　伝票情報
CREATE TABLE IF NOT EXISTS slip_detail (
    slip_no VARCHAR(255) NOT NULL PRIMARY KEY,
    user_id VARCHAR(255) NOT NULL ,
    title VARCHAR(255) NOT NULL,
    category VARCHAR(255),
    area VARCHAR(255),
    price VARCHAR(255) ,
    bid_method VARCHAR(255),
    bidder_id VARCHAR(255),
    bid_End_date VARCHAR(255),
    explanation VARCHAR(255),
    display_div VARCHAR(255),
    preferred_date VARCHAR(255),
    preferred_time VARCHAR(255),
    completion_date VARCHAR(255),
    image_url  VARCHAR(255),
    delete_div VARCHAR(255),
    messageOpenLebel VARCHAR(255),
    created TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated TIMESTAMP
);

INSERT INTO slip_detail
(slip_no, user_id, title, category, area, price, bid_method, bidder_id, bid_end_date, explanation, display_div, preferred_date, preferred_time, completion_date, delete_div, image_url) 
VALUES 
('1', '1', 'テスト１', '1', '1', '20000', '1' , '1' , '20221001', '説明１', '0', '20220131', '13', '20221031', '0', '' )
    ON DUPLICATE KEY UPDATE slip_no = VALUES (slip_no);

INSERT INTO slip_detail
(slip_no, user_id, title, category, area, price, bid_method, bidder_id, bid_end_date, explanation, display_div, preferred_date, preferred_time, completion_date, delete_div, image_url) 
VALUES 
('2', '2', 'テスト２', '1', '1', '10000', '1' , '1' , '20221001', '説明２', '0', '20220131', '13', '20221031', '0' , '')
    ON DUPLICATE KEY UPDATE slip_no = VALUES (slip_no);

INSERT INTO slip_detail
(slip_no, user_id, title, category, area, price, bid_method, bidder_id, bid_end_date, explanation, display_div, preferred_date, preferred_time, completion_date, delete_div, image_url) 
VALUES 
('3', '3', 'テスト3', '1', '1', '10000', '2' , '2' , '20221001', '説明3', '0', '20220131', '13', '20221031', '0' , '')
    ON DUPLICATE KEY UPDATE slip_no = VALUES (slip_no);
INSERT INTO slip_detail
(slip_no, user_id, title, category, area, price, bid_method, bidder_id, bid_end_date, explanation, display_div, preferred_date, preferred_time, completion_date, delete_div, image_url) 
VALUES 
('4', '4', 'テスト4', '2', '2', '20000', '1' , '1' , '20221001', '説明4', '0', '20220131', '13', '20221031', '0', '' )
    ON DUPLICATE KEY UPDATE slip_no = VALUES (slip_no);

INSERT INTO slip_detail
(slip_no, user_id, title, category, area, price, bid_method, bidder_id, bid_end_date, explanation, display_div, preferred_date, preferred_time, completion_date, delete_div, image_url) 
VALUES 
('5', '5', 'テスト5', '2', '3', '10000', '1' , '1' , '20221001', '説明5', '0', '20220131', '13', '20221031', '0', '' )
    ON DUPLICATE KEY UPDATE slip_no = VALUES (slip_no);

INSERT INTO slip_detail
(slip_no, user_id, title, category, area, price, bid_method, bidder_id, bid_end_date, explanation, display_div, preferred_date, preferred_time, completion_date, delete_div, image_url) 
VALUES 
('6', '6', 'テスト6', '2', '3', '10000', '2' , '2' , '20221001', '説明6', '0', '20220131', '13', '20221031', '0', '' )
    ON DUPLICATE KEY UPDATE slip_no = VALUES (slip_no);

-- ユーザー車両情報　ユーザーに紐づく車両情報
CREATE TABLE IF NOT EXISTS slip_vehicle (
    slip_no VARCHAR(255) NOT NULL PRIMARY KEY,
    vehicle_name VARCHAR(255) NOT NULL,
    vehicle_no VARCHAR(255),
    chassis_no VARCHAR(255),
    designated_classification VARCHAR(255) ,
    coler VARCHAR(255),
    coler_no VARCHAR(255),
    first_registration_date VARCHAR(255),
    inspection_expiration_date VARCHAR(255),
    created TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated TIMESTAMP
);



-- 伝票車両情報　伝票に紐づくコメント情報
CREATE TABLE IF NOT EXISTS slip_comment (
    comment_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    slip_no VARCHAR(255) NOT NULL ,
    display_order VARCHAR(255) NOT NULL,
    user_id VARCHAR(255) NOT NULL,
    comment VARCHAR(255),
    created TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated TIMESTAMP
);


-- ユーザーお気に入り　ユーザー,伝票に紐づくお気に入り情報
CREATE TABLE IF NOT EXISTS user_favorite (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    slip_no VARCHAR(255) NOT NULL ,
    user_id VARCHAR(255) NOT NULL,
    title VARCHAR(255) NOT NULL,
    image_url VARCHAR(255),
    created TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated TIMESTAMP
);


-- ユーザー閲覧履歴　ユーザー,伝票に紐づく閲覧履歴情報
CREATE TABLE IF NOT EXISTS user_browsing_history (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    slip_no VARCHAR(255) NOT NULL ,
    user_id VARCHAR(255) NOT NULL,
    title VARCHAR(255) NOT NULL,
    image_url VARCHAR(255),
    created TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated TIMESTAMP
);


-- 伝票情報　伝票情報
CREATE TABLE IF NOT EXISTS user_mylist (
    id VARCHAR(255) NOT NULL PRIMARY KEY,
    slip_no VARCHAR(255) NOT NULL,
    user_id VARCHAR(255) NOT NULL ,
    title VARCHAR(255) NOT NULL,
    category VARCHAR(255),
    area VARCHAR(255),
    price VARCHAR(255) ,
    bid_method VARCHAR(255),
    bidder_id VARCHAR(255),
    bid_End_date VARCHAR(255),
    explanation VARCHAR(255),
    preferred_date VARCHAR(255),
    preferred_time VARCHAR(255),
    completion_date VARCHAR(255),
    image_url  VARCHAR(255),
    delete_div VARCHAR(255),
    created TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated TIMESTAMP
);

INSERT INTO user_mylist
(id, slip_no, user_id, title, category, area, price, bid_method, bidder_id, bid_end_date, explanation,  preferred_date, preferred_time, completion_date, delete_div, image_url) 
VALUES 
('1', '1', '1', 'テスト１', '1', '1', '20000', '1' , '1' , '20221001', '説明１', '20220131', '13', '20221031', '0', '' )
    ON DUPLICATE KEY UPDATE id = VALUES (id);

