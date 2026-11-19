Harjoitustehtävä 1 raportti Joona Mikkola

Koodissani on suoritettu kaikki 9 tehtävää + raportti readme.md tiedostona. Käytin harjoitustyön pohjana ohjeiden mukaisesti SortTest.java tiedostoa ja lisäilin tähän koodiin järjestysalgoritmejä geeksforgeeks sivuston esimerkeistä, joita tarvittaessa muokkasin sopimaan koodiin. Koodini suorittaa Insertion sort, Bubble sort, Array sort, Shell sort, Quick sort ja Merge sortin ensiksi randomisoidulla 100 000 alkion taululla. Seuraavaksi nousevassa järjestyksessä ja viimeisenä laskevassa järjestyksessä. Koodissani käytän funktioreferenssiä (esim. SortTest::insertionSort ja Arrays::sort) ja lambda-lausekkeita (esim. arr -> quickSort(...)) välittääkseni itse lajittelualgoritmin parametrina testaaLajittelu-metodille. Tämä mahdollistaa sen, että ajanotto- ja tulostuskoodi on kirjoitettu vain kerran, ja uusien algoritmien lisääminen onnistuu yhdellä rivillä ilman koodin kopioimista. Ajaessani nousevaa/laskevaa taulukkoa Quick sortille huomasin, että ohjelma kaatui ja tämän takia jouduin optimoimaan quick sortin käyttämää partition funktiota, siten että se ei valitse taulukon viimeisintä alkiota vaan valitsee alkion satunnaisesta kohdasta ja tämä tuntui korjaavan ongelman. 

Tulokset vertailussa teoreettisiin nopeuksiin:
N = 100 000
Insertion sort (random): 4.5067148 s    *O(n^2)
bubble sort (random): 22.7024009 s  *O(n^2)
Array sort (random): 0.0368961 s   *O(n log (n))
Shell sort (random): 0.0478417 s    *O(n log(n))
Quick sort (random): 0.0469517 s    *O(n log(n))
Merge sort (random): 0.041347 s     *O(n log(n))
Insertion sort (ascending): 0.0013009 s    *O(n)
bubble sort (ascending): 2.915E-4 s     *O(n)
Array sort (ascending): 0.004402 s      *O(n log (n))
Shell sort (ascending): 0.00512 s       *O(n log(n))
Quick sort (ascending): 0.0315652 s     *O(n log(n))
Merge sort (ascending): 0.0216185 s     *O(n log(n))
Insertion sort (descending): 7.3691982 s    *O(n^2)
bubble sort (descending): 14.957133 s   *O(n^2)
Array sort (descending): 0.0052519 s    *O(n^2)
Shell sort (descending): 0.0047832 s    *O(n^2)
Quick sort (descending): 0.0150913 s    *O(n^2)
Merge sort (descending): 0.0192522 s    *O(n log(n))

Algoritmejä on mitattu kolmella eri skenaariolla, randomisoidulla taulukolla, joka kuvastaa keskimääräistä aikaa, nousevalla joka kuvastaa parhainta mahdollista tilannetta ja laskevalla joka kuvastaa huonointa mahdollista tilannetta. Hitain algoritmeistä oli bubble sort isolla marginaalilla verrattuna toisiksi hitaimpaan eli insertion sorttiin. Array sort, quick sort ja shell sort olivat nopeimmat kuten kurssimateriaalissa luvattiin, nopein näistä oli kuitenkin array sort. Mittaukseni vahvistavat teoriaa: taulukon koon kasvaessa lineaarisesti n2n2-luokan algoritmien (kuten bubble sort) suoritusaika kasvoi eksponentiaalisesti, kun taas O(nlog⁡n)O(nlogn)-luokan algoritmit (kuten quick sort) säilyttivät erittäin nopean suorituskykynsä. Voin siis todeta, että randomisoidulla listalla ajat ovat hyvin linjassa teoreettisiin aikoihin.
