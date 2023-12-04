-- Создание базы данных
CREATE DATABASE IF NOT EXISTS `friend_man`;

-- Использование базы данных
USE `friend_man`;

-- Таблица Домашние животные
CREATE TABLE IF NOT EXISTS `friend_man` (
    `id` INT AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(255) NOT NULL,
    `commands` VARCHAR(255),
    `birthdate` DATE
);

-- Таблица Вьючные животные
CREATE TABLE IF NOT EXISTS `pack_animals` (
    `id` INT AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(255) NOT NULL,
    `commands` VARCHAR(255),
    `birthdate` DATE
);

-- Таблица Лошади
CREATE TABLE IF NOT EXISTS `horse` (
    `id` INT AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(255) NOT NULL,
    `commands` VARCHAR(255),
    `birthdate` DATE
);

-- Таблица Верблюды
CREATE TABLE IF NOT EXISTS `camels` (
    `id` INT AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(255) NOT NULL,
    `commands` VARCHAR(255),
    `birthdate` DATE
);

-- Таблица Ослы
CREATE TABLE IF NOT EXISTS `donkeys` (
    `id` INT AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(255) NOT NULL,
    `commands` VARCHAR(255),
    `birthdate` DATE
);

-- Заполнение таблицы Домашние животные
INSERT INTO `friend_man` (`name`, `commands`, `дата_рождения`) VALUES
    ('Рекс', 'Сидеть', 'Лежать', '2020-01-15'),
    ('Барсик', 'Мяукает', 'Прыгает', '2019-05-20'),
    ('Шарик', 'Дай лапу', 'Фас', '2021-03-10');

-- Заполнение таблицы Вьючные_животные
INSERT INTO `pack_animals` (`name`, `commands`, `дата_рождения`) VALUES
    ('Буран', 'Тяни', 'Иди', '2018-11-25'),
    ('Алмаз', 'Громче', 'Беги', '2019-07-02'),
    ('Грета', 'Тормоз', 'Поворот', '2020-02-18');

-- Заполнение таблицы Лошади
INSERT INTO `horse` (`name`, `commands`, `дата_рождения`) VALUES
    ('Артос', 'Галоп', 'Скачок', '2019-01-08'),
    ('Дина', 'Прыжок', 'Веревка', '2020-06-14');

-- Заполнение таблицы Верблюды
INSERT INTO `camels` (`name`, `commands`, `дата_рождения`) VALUES
    ('Саид', 'Кивок', 'Хождение', '2017-09-30'),
    ('Милашка', 'Взгляд', 'Веревка', '2018-12-05');

-- Заполнение таблицы Ослы
INSERT INTO `donkeys` (`name`, `commands`, `дата_рождения`) VALUES
    ('Гарри', 'Тащи', 'Веревка', '2020-03-22'),
    ('Оливия', 'Кивок', 'Прыжок', '2019-08-10');
10 
-- Создание таблицы horse_and_donkeys
CREATE TABLE IF NOT EXISTS `horse_and_donkeys` AS
SELECT * FROM `horse`
UNION
SELECT * FROM `donkeys`;

-- Вывод данных из объединенной таблицы
SELECT * FROM `horse_and_donkeys`;
11

-- Создание таблицы Молодые_животные
CREATE TABLE IF NOT EXISTS `young_animals` AS
SELECT * FROM `friend_man`
WHERE TIMESTAMPDIFF(YEAR, `birthdate`, CURDATE()) BETWEEN 1 AND 3;

-- Добавление столбца "возраст_в_месяцах" в таблицу "Молодые_животные"
ALTER TABLE `young_animals`
ADD COLUMN `age_of_the_month'

