set projectLocation=C:\Users\snukala\Downloads\Files\SeleniumTestAutomation\src\com\servicedesk\com
cd %projectLocation%
set classpath=%projectLocation%\bin;%projectLocation%\lib\*
java org.testng.TestNg %projectLocation%\testng.xml
pause
