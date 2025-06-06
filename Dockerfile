FROM eclipse-temurin:17-jdk AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

FROM eclipse-temurin:17-jdk
WORKDIR /app
COPY --from=build /app/target/quarkus-app/lib /app/lib
COPY --from=build /app/target/quarkus-app/*.jar /app/
COPY --from=build /app/target/quarkus-app/app /app/app
COPY --from=build /app/target/quarkus-app/quarkus /app/quarkus
CMD ["java", "-jar", "quarkus-run.jar"]
