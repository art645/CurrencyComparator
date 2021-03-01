# CurrencyComparator

## Описание:
Данное REST API при отправке get запроса на url "http://localhost:8080/compare-currency-excgange/charcode/{name}", 
(где вместо переменной пути {name} можно ввести символьный код необходимой валюты без учета регистра) возвращает Gif-изображение в зависимости от изменения курса валюты относительно рубля за один день В случае роста курса, возвращается случайное GIF-изображение с тегом #rich, либо при снижении курса с тегом #broke c сервиса GIPHY.com.
При запросе с не поддерживаемой валютой, либо в случае, если курсы валют равны(данная ситуация возможна при просмотре курса рубля относительно рубля и в случае обращения к сервису в момент когда на данное число котировки по отношению к предыдущему дню не изменились) сервис вернет пустой ответ.


## Как запустить:
1. В командной строке введите следующее : docker run -d -p 8080:8080 aefanov05/currencycomparator:1.0.0
2. http://localhost:8080/compare-currency-excgange/charcode/{name}
Где {name} - символьный код валюты


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
