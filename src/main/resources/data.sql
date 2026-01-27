
DELETE FROM addresses;
DELETE FROM cities;
DELETE FROM regions;
DELETE FROM countries;


INSERT INTO countries (country_full, country_short) VALUES 
('Российская Федерация', 'RU'),
('Соединенные Штаты Америки', 'US'),
('Германия', 'DE'),
('Франция', 'FR');


INSERT INTO regions (country_id, region) VALUES 
(1, 'Московская область'),
(1, 'Ленинградская область'),
(2, 'Калифорния'),
(2, 'Нью-Йорк'),
(3, 'Бавария'),
(4, 'Иль-де-Франс');


INSERT INTO cities (region_id, city) VALUES 
(1, 'Москва'),
(1, 'Химки'),
(2, 'Санкт-Петербург'),
(2, 'Выборг'),
(3, 'Лос-Анджелес'),
(3, 'Сан-Франциско'),
(4, 'Нью-Йорк'),
(5, 'Мюнхен'),
(6, 'Париж');


INSERT INTO addresses (person, city_id, street, building, office) VALUES 
('Иванов Иван Иванович', 1, 'Тверская ул.', '12', '45'),
('Петров Петр Петрович', 3, 'Невский пр.', '25', '101'),
('John Smith', 5, 'Hollywood Blvd', '1234', 'A'),
('Maria Schmidt', 8, 'Marienplatz', '1', '300'),
('Pierre Dupont', 9, 'Champs-Élysées', '88', '12');