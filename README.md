# ZTP3

Obejrzyj załączony <a href="https://cez2.wi.pb.edu.pl/moodle/pluginfile.php/13282/mod_assign/intro/Mario.java">program</a>  (<a href="https://cez2.wi.pb.edu.pl/moodle/pluginfile.php/13282/mod_assign/intro/Mario-obrazy.zip">obrazy</a> do programu, przykładowa <a href="https://cez2.wi.pb.edu.pl/moodle/pluginfile.php/13282/mod_assign/intro/plansza01.txt">plansza</a>) lub projekt Maven  i uruchom go. Implementuje on grę planszową z Bohaterem, który może chodzić w lewo i prawo a także skakać (strzałka do góry lub spacja. Plansza gry złożona jest z 3 rodzajów segmentów. Każdy wyróżnia się zachowaniem: 

- solidny segment A (klasa SegmentBlock) - nie do przejścia,
- segment B (klasa SegmentBlockV), umożliwiający wskakiwanie na niego,
- segment "drewniany" C (klasa Segment) - nie wpływa na ruch bohatera.
Każdy z nich ma też inny obrazek graficzny. Dodatkowo na planszy umieszczone są monety G (klasa SegmentAnim) (póki co, pełnią tylko rolę ozdobnika).

Schemat planszy zapisany jest w pliku tekstowym 'plansza01.txt':
- w każdej linii umieszczona jest jeden poziom planszy,
- każda linia składa się z trójek: pierwszy znak koduje rodzaj segmentu (A, B, C, G, X - segment pusty), dwa kolejne - liczbę powtórzeń.

Zmodyfikuj ten program wykorzystując wzorzec Budowniczy (Builder). Rolę Producenta (Director) będzie pełnić klasa Game i jej zmodyfikowana metoda stworzPlansze (pozostaw w niej tylko funkcjonalność parsowania pliku tekstowego). Metoda ta powinna  pobrać obiekt budowniczego jako parametr i wywoływać jego metody, które będą tworzyć odpowiednie segmenty i dodawać do planszy. Obiekt budowniczego czyli konkretną klasę dziedziczącą z abstrakcyjnego typu bazowego. Metoda stworzPlansze nie zwraca wyniku. Wynik (gotową planszę - listę segmentów) pobiera  z budowniczego kod wywołujący metodę stworzPlansze . Obsługa współrzędnych powinna się znaleźć w klasie budowniczego.

Budowniczy podejmuje decyzję, jaki konkretny obiekt stworzy w miejsce segmentów A, B, C, G, X. Na początku stwórz klasę pierwszego budowniczego tworzącego identyczne obiekty jak program oryginalny.

Następnie napisz 2 klasę budowniczego, która w miejsce obiektów C stworzy obiekty solidne (klasy SegmentBlock) ale z pierwotnym obrazkiem.

UWAGA: w przypadku braku płynności animacji na początku funkcji main należy dodać linię:

System.setProperty("sun.java2d.opengl", "true");
