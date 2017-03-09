FROM java:8-alpine
MAINTAINER Your Name <you@example.com>

ADD target/uberjar/operacion-halcon-negro.jar /operacion-halcon-negro/app.jar

EXPOSE 3000

CMD ["java", "-jar", "/operacion-halcon-negro/app.jar"]
