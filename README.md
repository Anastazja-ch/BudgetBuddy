# BudgetBuddy

BudgetBuddy to aplikacja webowa służąca do zarządzania finansami osobistymi. Umożliwia użytkownikom śledzenie przychodów i wydatków.

## Spis Treści
1. Opis Projektu
2. Jak zacząć?
3. Struktura Projektu
4. Jak zakończyć pracę z projektem?
5. Kontakt

## Opis Projektu

BudgetBuddy to aplikacja webowa służąca do zarządzania finansami osobistymi. Umożliwia użytkownikom śledzenie przychodów i wydatków.

## Jak zacząć?
1.Stwórz fork repozytorium BudgetBuddy:

2. Wejdź na stronę głównego repozytorium BudgetBuddy i kliknij przycisk "Fork", aby stworzyć kopię repozytorium w swoim koncie GitHub.
Sklonuj repozytorium na swój komputer:

3. Skopiuj adres URL swojego forka repozytorium. Powinien wyglądać zgodnie ze schematem: https://github.com/twoj-login/adres_repozytorium.
W terminalu wykonaj komendę:
git clone https://github.com/twoj-login/adres_repozytorium

4. Zaimportuj projekt jako projekt Maven w IntelliJ:
W IntelliJ wybierz: File -> New -> Project from Existing Sources...
Wskaż lokalizację katalogu ze sklonowanym projektem i zatwierdź.
W nowym oknie wybierz: Import project from external model i wskaż Maven.
Kliknij Finish. W starszych wersjach IntelliJ (przed 2020): Next -> Next -> Next -> Finish.

5. Skonfiguruj bazę danych:
Upewnij się, że masz zainstalowaną bazę danych MySQL.
Utwórz bazę danych o nazwie budget:
CREATE DATABASE budget;

6. Zaktualizuj plik application.properties w katalogu src/main/resources, aby zawierał poprawne dane do połączenia z bazą danych

Uruchom aplikację:
W IntelliJ kliknij prawym przyciskiem myszy na klasę BudgetApplication i wybierz Run 'BudgetApplication'.
Aplikacja powinna uruchomić się na porcie 8080. Możesz uzyskać do niej dostęp, otwierając przeglądarkę i przechodząc do http://localhost:8080.

## Struktura Projektu

Kontrolery
UserController: zarządza rejestracją i logowaniem użytkowników.
TransactionController: zarządza operacjami CRUD na transakcjach.

Modele
User: model użytkownika.
Transaction: model transakcji.

Usługi
UserService: logika biznesowa dla użytkowników.
TransactionService: logika biznesowa dla transakcji.

Widoki
register.html: formularz rejestracji.
login.html: formularz logowania.
transactions.html: lista transakcji.
create_transaction.html: formularz tworzenia nowej transakcji.
edit_transaction.html: formularz edycji transakcji.
saldo.html: widok salda.

## Jak zakończyć pracę z projektem?
Aby zakończyć pracę z repozytorium, wykonaj następujące kroki:

Zakończ pracę nad kodem:

1. Upewnij się, że wszystkie zmiany zostały zapisane i przetestowane.
Dodaj zmiany do repozytorium:

2. Użyj komendy git add <nazwa_pliku> aby dodać konkretny plik do obszaru przechowywania.
Aby dodać wszystkie zmienione pliki, użyj git add .

3. Zakomituj zmiany:
Zakomituj zmiany używając komendy git commit -m "Twoja wiadomość commita".
Wypchnij zmiany do repozytorium na GitHubie:

4. Wypchnij zmiany do swojego repozytorium na GitHubie używając komendy git push origin main.

## Kontakt
W razie uwag zapraszam do kontaktu: anastazjachteinman@gmail.com :)
  
