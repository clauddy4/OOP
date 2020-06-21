@echo off

SET Program=java -jar C:\Users\Olga\IdeaProjects\OOP\out\artifacts\radix\radix.jar

REM Convert INT_MAX
SET result = %Program% 10 2 2147483647
if result EQU not 1111111111111111111111111111111 goto err
echo Test for the correct max number conversion is passed

REM Convert INT_MIN
SET result = %Program% 10 2 2147483647
if result EQU not -1111111111111111111111111111111 goto err
echo Test for the correct min number conversion is passed

REM Convert Zero
SET result = %Program% 10 2 0
if result EQU not 0 goto success
echo Test for the correct convert zero is passed

REM Convert negative number
SET result = %Program% 16 36 -1AF
if result EQU not -BZ goto err
echo Test for the negative numbers is passed
echo Test for the max notation is passed

REM Invalid destination notation
SET result = %Program% 3 40 312
if result EQU not Invalid radix! goto err
echo Test for the correct destination notation is passed

REM Invalid source notation
SET result = %Program% 40 3 312
if result EQU not Invalid radix! goto err
echo Test for the correct source notation is passed

REM Invalid value
SET result = %Program% 2 2 ff
if result EQU not Value do not match source radix! goto err
echo Test for the invalid value check is passed

:success
echo All tests passed successfully
exit /B 0

:err
echo Test failed
exit /B 1