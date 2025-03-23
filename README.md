# SeleniumProject

## Opis projektu

**SeleniumProject** to aplikacja stworzona w celu nauki tworzenia testów automatycznych z wykorzystaniem narzędzia Selenium. Projekt został zrealizowany w ramach kursu na platformie Udemy, co pozwoliło na praktyczne zastosowanie zdobytej wiedzy.

## Funkcjonalności

- **Tworzenie testów automatycznych**: Umożliwia pisanie i uruchamianie testów automatycznych dla aplikacji webowych z użyciem Selenium.
- **Integracja z różnymi przeglądarkami**: Wsparcie dla testowania na różnych przeglądarkach internetowych.

## Technologie

- **Język programowania**: Java
- **Narzędzie do automatyzacji testów**: Selenium WebDriver
- **System budowania**: Maven

## Struktura projektu

- **src/**: Katalog zawierający pliki źródłowe testów.
- **target/**: Katalog z wygenerowanymi plikami po kompilacji.
- **pom.xml**: Plik konfiguracyjny Maven zawierający zależności i konfiguracje projektu.

## Wymagania

- Java Development Kit (JDK) w wersji 8 lub wyższej
- Maven
- Przeglądarka internetowa (np. Chrome, Firefox)

## Instalacja

1. Sklonuj repozytorium:
   
   ```bash
   git clone https://github.com/Hubi0295/SeleniumProject.git
   ```

2. Przejdź do katalogu projektu:
   
   ```bash
   cd SeleniumProject
   ```

3. Zainstaluj zależności za pomocą Mavena:
   
   ```bash
   mvn install
   ```

## Uruchomienie testów

Aby uruchomić testy, wykonaj poniższe polecenie:

```bash
mvn test
```

Testy zostaną uruchomione na domyślnej przeglądarce skonfigurowanej w projekcie.


