# Pratice Spring Boot in Backend

## Purpose 
Get more understanding in Spring Boot

## What I Learned
### Spring Boot 
1. Initialize maven Spring Boot Project
2. DB properties setting in yml file 
3. Implement the JPA by extends JpaRepository<T, D>  
   (T is your Model, D is primary key type)  
   If there is not enough, we can use self-defined query by below way  
   ```   
    @Query("SELECT s FROM Student s WHERE s.email = ?1")
    Optional<Student> findStudentByEmail(String email);
   ```
4. Basic tools like Lombok and so on, I gathered those useful annotation   
   https://airy-chinchilla-ff4.notion.site/Annotation-180b7cdd296f403a9503c3a6dab73480
5. Use ResponseEntity<Response> as returned type to provide for frontend to handle  
   include time, status, data and so on  
   ```
      return ResponseEntity.ok(
              Response.builder()
                      .timeStamp(now())
                      .data(Map.of("servers", serverService.list(10)))
                      .message("server retrived")
                      .status(HttpStatus.OK)
                      .statusCode(HttpStatus.OK.value())
                      .build()
      );
   ```
   Instead of try-catch error in the controller, try to use @ControllerAdvice to handle the customized Exception
   
### DB in Container
6. set up docker-compose file for building postgres db and pgAdmin



## Reference
1. https://www.youtube.com/watch?v=8ZPsZBcue50 : guiding me to build basic CRUD spring boot project
2. https://dzone.com/articles/bounty-spring-boot-and-postgresql-database : setup to connect with postgres db
3. https://www.udemy.com/course/docker-tutorial-for-devops-run-docker-containers/learn/lecture/6466750?start=180#overview for building docker concept  
