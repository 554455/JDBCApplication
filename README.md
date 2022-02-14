# Задание
 Необходимо реализовать консольное CRUD приложение, которое взаимодействует с БД и позволяет выполнять все CRUD операции над сущностями:
 
Team(id, name, List<Developer> developers)
 
Developer(id, firstName, lastName, List<Skill> skills)
 
Skill(id, name)
   
**Требования:**
 
Придерживаться шаблона MVC (пакеты model, repository, service, controller, view)
Для миграции БД использовать https://www.liquibase.org/
Сервисный слой приложения должен быть покрыт юнит тестами (junit + mockito).
Для импорта библиотек использовать Maven

 
**Технологии:**
 
 Java, MySQL, JDBC, Maven, Liquibase, JUnit, Mockito

 **Инструкция по запуску**
 
1.Скачать приложение

2.Перейти в репозиторий по ссылке https://github.com/554455/JDBCApplication

3.Кликнуть зеленую кнопку "Clone or Download" в правой верхней части страницы.

4.Распаковать архиватором

5.Открыть проект в intellij idea
 
6.Запустить файлы Liquibase (src/main/resources/db/changelog/changeset/*)

7.Запустить класс main.java.com.umaraliev.crud.Main
