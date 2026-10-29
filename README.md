# 📈 Trading Journal

A Java-based futures trading journal for logging trades, calculating profit and loss (P&L), and analyzing trading performance. Currently a command-line application, with plans to evolve into a full-stack web application.

## 🚧 Project Status

**Work in Progress** — The current version supports trade logging, local file persistence, and basic performance statistics. Database integration, a web frontend, and deployment are planned.

## ✨ Features

- **Trade Logging** — Record futures trades with instrument, direction (long or short), entry price, exit price, stop loss, number of contracts, and emotions.
- **P&L Calculation** — Calculate trade profit or loss based on entry and exit prices, direction, contract quantity, and instrument point value.
- **Multiple Instruments** — Supports MNQ, NQ, MES, ES, GC, MGC, MYM, and YM.
- **Trade History** — Save trades to a local text file and reload them when the application starts.
- **Performance Statistics**
  - Total number of trades
  - Total P&L
  - Win rate
  - Average P&L per trade
  - Best and worst trade by P&L
- **Input Validation** — Validate trade inputs, including instrument, direction, prices, contract quantity, and emotions.
- **Command-Line Interface** — Navigate the journal through an interactive menu.

## 🛠️ Technologies

- **Java 21**
- **Maven**
- **Git & GitHub**

## 🚀 Getting Started

### Prerequisites

- JDK 21 or a compatible Java version
- Maven

### Installation

1. Clone the repository:

   ```bash
   git clone https://github.com/eliasMohamadi/Trading-Journal.git
   ```

2. Navigate to the project directory:

   ```bash
   cd Trading-Journal
   ```

3. Compile the project:

   ```bash
   mvn compile
   ```

4. Run the `Main` class from your IDE.

## 📁 Project Structure

```text
Trading-Journal/
├── src/
│   └── main/
│       └── java/
│           ├── Main.java
│           ├── Trade.java
│           ├── TradeFileManager.java
│           └── TradeStatistics.java
├── pom.xml
├── .gitignore
└── README.md
```

## 🗺️ Roadmap

- [ ] Improve input handling and error recovery
- [ ] Add trade history searching and filtering
- [ ] Expand performance analytics
- [ ] Integrate SQLite for structured trade storage
- [ ] Connect the application to a relational database using JDBC
- [ ] Build a backend API
- [ ] Develop a web frontend with a trading dashboard
- [ ] Add automated tests
- [ ] Deploy the application

## 🎯 Project Goals

The goal is to evolve this project from a command-line trading journal into a full-stack application with structured trade storage, performance analytics, and an interactive dashboard.

---

**Built by Elias Mohamadi**
