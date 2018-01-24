# Контрольная работа по предмету «Объектно-ориентированное программирование на языке Java» (1 Семестр)

## Задание №1

### Вариант №4

#### 1. Пакет – [text](src/main/java/text/). 

#### 2. Создайте публичный класс [Paragraph](src/main/java/text/Paragraph.java) – абзаца текстового документа; 

Класс не хранит явным образом местоположение в тексте, число строк. 

- каждый  абзац  характеризуется  строкой,  непосредственно  содержащей  весь  текст абзаца; 

- каждый  абзац  характеризуется  отступом  красной  строки  (число  символов,  а  не сантиметры); 

- конструктор  по-умолчанию  (без  параметров)  создает  «пустой»  абзац  – характеризующийся пустой строкой, и отступом = 0; 

- конструктор может принимать значение отступа (в этом случае строка – пустая); 

- конструктор может принимать значение отступа и строку – текст. 

- создайте метод получения строки текста; 

- создайте метод изменения строки текста; 

- создайте метод получения отступа красной троки; 

- создайте метод изменения отступа красной троки; 

#### 3. Создайте публичный класс [Text](src/main/java/text/Text.java) – текста. 

- класс характеризуется максимальным числом символов в строке; 

- класс явным образом хранит в себе массив абзацев; 

- конструктор по-умолчанию (длинна массива абзацев = 0, число символов 80); 

- конструктор может принимать массив абзацев (число символов в строке = 80); 

- конструктор может принимать массив абзацев и число символов в строке; 

- создайте метод, возвращающий общее число абзацев; 

- создайте метод, возвращающий общее число строк текста; 

- создайте  метод,  возвращающий  ссылку  на  абзац  по  его  номеру  (номер  абзаца  = номеру в массиве); 

- создайте  метод,  вставляющий  абзац  после  абзаца  (принимает  ссылку  на  новый абзац и номер абзаца, после которого нужно вставить новый) 

- создайте метод удаления абзаца по его номеру; 

- создайте  метод  изменения  абзаца  по  его  номеру  (принимает  ссылку  на  новый абзац и номер абзаца, который нужно заменить новым); 

- создайте метод, возвращающий массив абзацев; 
