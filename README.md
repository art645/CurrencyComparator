# CurrencyComparator

## Описание:
Данное REST API при отправке get запроса на url "http://localhost:8080/compare-currency-excgange/charcode/{name}", 
(где вместо переменной пути {name} можно ввести символьный код необходимой валюты без учета регистра) возвращает Gif-изображение в зависимости от изменения курса валюты относительно рубля за один день.
В случае роста курса, возвращается случайное GIF-изображение с тегом #rich, либо при снижении курса с тегом #broke c сервиса GIPHY.com.


## Как запустить:
1. Импортируйте Gradle проект и запустите CurrencyComporatorApplication.java из IDE.
2. http://localhost:8080/compare-currency-excgange/charcode/{name}

## Список основных символьных кодов и их наименований:
- USD-Доллар США
- EUR-Евро
- GBP-Фунт стерлингов Великобритании	
- JPY-Японская йена	
- CHF-Швейцарский франк	
- CNY-Китайский юань 
- RUB-Российский рубль

## Используемые технологии:
* Java 11 
* Gradle
* Spring boot 2.3.3
* OpenFeign
* JUnit