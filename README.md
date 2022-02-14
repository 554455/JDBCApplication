# Задание
 Необходимо реализовать консольное CRUD приложение, которое взаимодействует с БД и позволяет выполнять все CRUD операции над сущностями:
 
Team(id, name, List<Developer> developers)
Developer(id, firstName, lastName, List<Skill> skills)
Skill(id, name)
TeamStatus (enum ACTIVE, DELETED)
  
**Требования:**
Придерживаться шаблона MVC (пакеты model, repository, service, controller, view)
Для миграции БД использовать https://www.liquibase.org/
Сервисный слой приложения должен быть покрыт юнит тестами (junit + mockito).
Для импорта библиотек использовать Maven

**Технологии:**
 Java, MySQL, JDBC, Maven, Liquibase, JUnit, Mockito
