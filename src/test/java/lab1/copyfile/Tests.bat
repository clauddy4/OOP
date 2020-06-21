@echo off

SET CopyFiles=C:\Users\Olga\IdeaProjects\OOP\out\artifacts\copyfiles\copyfiles.jar

REM copy empty files
java -jar %CopyFiles% Empty.txt TestOutput.txt || goto err
fc Empty.txt TestOutput.txt || goto err

REM copy non empty files
java -jar %CopyFiles% TestFile.txt TestOutput.txt || goto err
fc TestFile.txt TestOutput.txt || goto err

echo tests completed successfully
exit /B 0

:err
echo test fail
exit /B 1