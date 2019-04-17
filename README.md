# awesome2048-api

Simple API made with the purpose of posting and getting scores of users in the game

## Initialization of database

1. Make sure you have PostgreSQL and maven properly installed
2. Set the environmental variables in your system as described in ``application.properties`` for the database configuration
3. In ``application.properties`` uncomment line ``spring.datasource.initialization-mode=always``
4. In ``application.properties`` comment line ``spring.jpa.hibernate.ddl-auto = update``
5. Run ``mvn spring-boot:run``
6. Undo steps 4 and 5.
