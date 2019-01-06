cd src
javac compute\Compute.java compute\Task.java
jar cvf compute.jar compute\*.class

javac -cp compute.jar engine\ComputeEngine.java
jar cvf ComputeEngine.jar engine\*.class

javac -cp compute.jar client\ComputePi.java client\Pi.java
jar cvf client.jar client\*.class

move .\*.jar ..\output\
move compute\*.class ..\output\
move engine\*.class ..\output\
move client\*.class ..\output\
pause