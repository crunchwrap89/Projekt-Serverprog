# Projekt-Serverprog

Starta derby genom att gå till mappen där derby ligger och skriv ./NetworkServerControl -p 50000 start

Skriv sedan ./ij.bat och skriv in connect 'jdbc:derby://localhost:50000/UserManagement; create=true';

Detta behöver man bara göra första gången

Starta sedan wildfly genom att gå till mappen där wildfly ligger och kör standalone.bat

Kör sedan filen build.xml i projektet för att deploya projektet till servern. 

Starta sedan klienten och följ instruktionerna för att lägga till eller ta bort användare.
