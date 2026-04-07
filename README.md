# App Meteo 🌦️

Un'applicazione metereologica professionale basata su Java per recuperare e visualizzare informazioni in tempo reale tramite terminale.

## 🏗️ Architettura del Progetto

L'applicazione segue il pattern **Service-Model**, separando la logica di business dalla rappresentazione dei dati.

```text
GenerationApp/
├── src/
│   ├── main/
│   │   ├── java/com/generation/meteo/
│   │   │   ├── App.java                 # Entry point e interfaccia CLI
│   │   │   ├── model/
│   │   │   │   └── Weather.java         # Data Model (POJO)
│   │   │   └── service/
│   │   │       └── WeatherService.java  # Core Logic (API & Parsing)
│   └── test/
│       └── java/com/generation/meteo/service/
│           └── WeatherServiceTest.java  # Test Suite (JUnit 5)
├── pom.xml
└── README.md

Gemini ha detto
Ecco il file README.md completo, formattato in Markdown professionale, pronto per essere copiato e incollato nel tuo progetto. Ho incluso tutte le correzioni per riflettere l'uso di Java 25, le emoji e la struttura finale che abbiamo costruito.

Markdown
# 🌦️ Weather App - Java Edition

Un'applicazione metereologica professionale basata su Java per recuperare e visualizzare informazioni in tempo reale tramite terminale. Sviluppata come progetto finale per il corso di AI & Java Development.

---

## 🏗️ Struttura del Progetto

L'applicazione segue una struttura modulare Maven, separando la logica di business dal modello dei dati e dall'interfaccia utente.

```text
GenerationApp/
├── src/
│   ├── main/
│   │   ├── java/com/generation/meteo/
│   │   │   ├── App.java                 # Entry point e interfaccia CLI
│   │   │   ├── model/
│   │   │   │   └── Weather.java         # Modello dati (POJO)
│   │   │   └── service/
│   │   │       └── WeatherService.java  # Core Logic & Parsing API
│   └── test/
│       └── java/com/generation/meteo/service/
│           └── WeatherServiceTest.java  # Suite di Test (JUnit 5)
├── pom.xml                              # Configurazione Maven
└── README.md                            # Documentazione del progetto
🛠️ Descrizione dei Componenti
🔹 App.java
Punto di ingresso dell'applicazione. Gestisce l'interazione con l'utente, valida l'input tramite URLEncoder (per gestire nomi di città complessi) e coordina le chiamate ai servizi esterni.

🔹 WeatherService.java
Il modulo centrale che gestisce la comunicazione HTTP tramite java.net.http.HttpClient. Include:

Geocoding: Conversione del nome città in coordinate geografiche.

Parsing JSON: Estrazione sicura dei dati tramite la libreria org.json.

Mappatura Condizioni: Traduzione dei codici WMO in descrizioni testuali ed emoji.

🔹 Weather.java
Classe Model che incapsula i dati meteorologici (Temperatura, Vento, Condizione), rendendo il codice pulito e orientato agli oggetti.

🚀 Compilazione ed Esecuzione
Prerequisiti
Java JDK 17 o superiore (Consigliato: OpenJDK 25)

Maven 3.6+

Comandi Maven
Copia e incolla i seguenti comandi nel terminale:

1. Compilare il progetto:

Bash
mvn clean compile
2. Eseguire la Suite di Test:

Bash
mvn test
3. Avviare l'Applicazione:

Bash
mvn exec:java -Dexec.mainClass="com.generation.meteo.App"
✨ Funzionalità Implementate
✅ Ricerca Intelligente: Geocodifica automatica da nome città a coordinate.

✅ Supporto Caratteri Speciali: Gestione di città con spazi o accenti (es. "New York", "Forlì").

✅ Localizzazione Robusta: Uso di Locale.US per garantire la compatibilità dei decimali con le API internazionali.

✅ Interfaccia CLI Evoluta: Visualizzazione dati formattata con emoji e suggerimenti pratici sull'abbigliamento basati sulla temperatura.

✅ Qualità Garantita: Suite di test unitari e di integrazione con JUnit 5.

📡 API & Dipendenze
L'app sfrutta i servizi gratuiti di Open-Meteo:

Geocoding API: Per la ricerca delle coordinate.

Forecast API: Per il recupero dei dati metereologici attuali.

Librerie esterne utilizzate:

org.json: Per il parsing strutturato dei file JSON.

junit-jupiter: Per il testing automatizzato.

📝 Licenza
Progetto rilasciato sotto licenza MIT. Libero per scopi didattici.

Sviluppato con il supporto dell'Intelligenza Artificiale come tutor di programmazione.
