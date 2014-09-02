**Aihe:** Laskin graafiselle kayttoliittymalla. Toteutetaan laskin, joka pystyy laskemaan kayttajan
syottamia lausekkeita. Laskin tukee peruslaskutoimituksia ja -funktioita (esim.
trigonometrisia funktioita). Kayttaja voi syottaa lausekkeita luonnollisessa muodossa nappaimistolta
tai laskimen omista nappaimista.

**Toiminnot:**

  *lausekkeen laskeminen
  
**Rakenne:** Laskimen sovelluslogiikka rakentuu kolmesta paakomponentista. Lausekelogiikka sisaltaa
suoritettavan lausekkeen ydinlogiikan ja toimii periaatteessa täysin irrallaan muusta logiikasta.
Kirjasto sisaltaa yksittaisia laskutoimituksia ja funktioita vastaavan logiikan, siis esimerkiksi
mita pluslasku tekee laskettavilleen. Merkkijononkasittely mahdollistaa suoritettavan lausekkeen
muodostamisen String tyyppisen lausekkeen mukaisesti. Merkkijononkasittely hakee String tyyppisen
lausekkeeen elementteja Kirjaston tarjoaman toiminnallisuuden avulla ja valittaa nama lausekelogiikalle.

Lausekelogiikan pienimmat elementit ovat Arvollinen, Laskutoimitus ja Funktio. Arvollinen on rajapinta,
joka mahdollistaa double tyyppisen arvon kysymisen. Lausekelogiikan jokainen luokka toteuttaa rajapinnan
Arvollinen ja toteuttaa sen ilmeisella tavalla. Laskutoimitukselle annetaan kaksi Arvollista ja se
palauttaa laskutoimituksen arvon nailla arvoilla. Funktiolle taas asetetaan argumentti. Lauseke rakentuu
Lohkoista ja Lohko Suoritusjonoista.

Suoritusjono muodostaa Laskutoimituksista ja Arvollisista suoritettavan jonon, jossa metodin Arvo suoritus
etenee ensimmaisesta laskutoimituksesta viimeiseen.

Lohkon sisalla Suoritusjonot vastaavat laskutoimitusten eri prioriteettitasoja. Siis lohko lisaa perakkaiset
saman laskujarjestysprioriteetin laskutoimitukset samalle tasolle. Kun lisataan korkeampi prioriteetti,
avataan vastaavasti prioriteettitasoja, ja pienemman tapauksessa suljetaan korkeammat tasot. Jokaisella
hetkella prioriteettitasoja on auki edellisen lisatyn laskutoimituksen prioriteetin mukainen maara.
Korkeammat prioriteettitasot asetetaan Arvollisina alemmalle tasolle jolloin metodin Arvo suorituksessa
korkeampi prioriteettitaso suoritetaan ensin.

Luokka Lauseke on siis sen lausekkeen, jonka laskimen halutaan laskevan, suoritettava muoto. Lausekkeeseen
syotetaan lausekkeen elementit vasemmalta oikealle ja Lauseke olio rakentaa suoritettavan rakenteen, jonka
arvoa kutsuttaessa suoritus etenee oikeassa jarjestyksessa ja saadaan syotetyn lausekkeen oikea arvo.
Lauseke rakentuu lohkoista, jotka hoitavat laskutoimitusten linkittamisen. Lohkot vastaavat "sulkujen
sisapuolta". Kaytannossa Lauseke asettaa sisemman Lohkon ulompaan Aarvollisena, jolloin metodia arvo
kutsuttaessa laskeminen etenee sisemmista lohkoista uloimpiin, kuten kuuluukin. Lauseke hoitaa myos funktioiden
kasittelyn, silla lisattavalle funktiolle tulee avata uusi lohko, joka on siis funktion argumentti.

Kirjaston paaluokka on ToimintoKirjasto, jolta voidaan hakea Laskutoimitus ja Funktio luokkien konkreettisia
edustajia String tyyppisen tunnuksen perusteella. Siis ToimintoKirjastolta voitaisiin hakea esimerkiksi
yksittainen Plus olio.

Merkkijononkasittelyn paaluokka on MerkkijononKasittelija. Sille annetaan String tyyppinen lauseke, jonka se
lukee elementti (luku, laskutoimitus, jne.) kerrallaan samalla lisaten elementin Lausekkeeseen. MerkkijononKasittelija
delegoi lukujen lukemisen LuvunKasittelija luokan olioille ja vastaavasti laskutoimitukset LaskutoimituksenKasittelijoille
ja funktiot FunktionKasittelijoille.

MerkkijononKasittely on periaatteessa riippumaton kayttoliittymasta. Graafisen kayttoliittyman vastuulle jaa
ainoastaan lausekkeen syottamisen mahdollistaminen kayttajalle, syotteen valittaminen merkkijononkasittelylle
ja tuloksen tulostaminen kayttajalle.
