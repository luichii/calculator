# STEPS
Use the following commands:

1) 
    mvn install:install-file -Dfile=D:\Descargas\prueba_sanitas\src\main\resources\repo\tracer-1.0.0.jar -DgroupId=org.tracer -DartifactId=tracer -Dversion=1.0.0 -Dpackaging=jar -DlocalRepositoryPath=D:\Descargas\prueba_sanitas\src\main\resources\repo
    
 Note: change D:\Descargas\prueba_sanitas\src\main\resources\repo\tracer-1.0.0.jar to location you have tracer-1.0.0.jar


2) mvn clean install

3) mvn package

4) java -jar  D:\Descargas\prueba_sanitas\target\demo-0.0.1-SNAPSHOT.jar

 Note: change D:\Descargas\prueba_sanitas\target\demo-0.0.1-SNAPSHOT to location you have demo-0.0.1-SNAPSHOT.jar
