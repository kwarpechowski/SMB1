# SMB1 - Mini-projekt 1
## Treść zadania:

Zadanie polega na stworzeniu aplikacji mającej na celu zarządzanie oraz
zapisywania/odczytywanie listy zakupów przy wykorzystaniu androidowych metod
przechowywania danych (SharedPreferences, zapisywanie do pliku – pamięć
wewnętrzna/zewnętrzna, SQLite, ewentualnie Content Provider)


## Wymagania:
* Skorzystanie z kilku *Activity* (ewentualnie *ListActivity*) oraz *Intent* do nawigacji pomiędzy
widokami w aplikacji. Poniżej znajduje się wylistowany minimalny zestaw Activities:
  * *MainActivit*y: główne okno do nawigacji, znajdują się tu guziki do nawigacji do
kolejnych komponentów graficznych.
  * *ProductListActivity*: lista reprezentująca listę zakupów (nazwa produktu,
element oznaczający zaznaczenie danego produktu z listy). Dodatkowo
powinny znaleźć się elementy odpowiedzialne za dodawanie nowych
produktów do listy, modyfikację oraz usuwanie istniejących.
  * *OptionsActivity*: ekran reprezentujący opcje związane z aplikacją. Co najmniej . (np. rozmiar i kolor czcionki)
  * Należy zapisać wartości opcji za pomocą SharedPreferences. Przy ponownym odpaleniu
odczytujemy poprzednio zapisane wartości. [3 pkt]
* Należy także zapisać listę produktów za pomocą bazy *SQLite*. Stworzyć co najmniej jedną
tabelę przechowującą nazwy produktów, ewentualnie ich identyfikator oraz wartość
oznaczającą ich kupno. [7 pkt]
(alternatywnie zapisywać jedynie do pliku [7-3=4 pkt])
  * (Opcjonalne, na 3 dodatkowe punkty) Utworzyć Content Providera umożliwiającego dostęp
do znajdujących się w bazie danych informacji.

Łączna liczba punktów do uzyskania: 10 + 3 (za Content Provider) = 13 pkt

## Terminy
Termin oddania (dzienne): 18.10.2016

Termin oddania (zaoczne): 05.11.2016
