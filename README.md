# Zoo Management – Java (Terminal App) 🦁
### University Project | Faculty of Economic Sciences and Management of Tunis (FSEGT)

A robust, "crash-proof" terminal-based zoo management application written in Java. It allows users to manage enclosures, handle animals of different species, and enforce strict logic constraints using custom exceptions.

This project was designed with a focus on **stability and user experience**, featuring a compiled `.exe` version for easy execution on Windows without needing an IDE.

---

## 🚀 Features
- **Standalone Executable:** Runs as a native Windows `.exe` file for portability.
- **Crash-Proof Input:** Robust validation ensures the app never crashes on invalid inputs (e.g., entering letters where numbers are expected).
- **Smart Management:**
  - Create and manage enclosures.
  - Add animals (Mammals, Birds, Reptiles, Herbivores, Carnivores).
  - **Auto Fill** option for quick testing.
  - **Search by ID** for quick animal lookup.
- **Logic Enforcement:**
  - Validates animal types before adding them.
  - Prevents adding animals to full enclosures.
  - Prevents moving animals to invalid or non-existing enclosures.
- **Clean Architecture:** Fully OOP with custom exceptions (`FullEnclosureException`, `AnimalNotFoundException`, etc.).
- **Data Persistence:** Reads initial animal data from `animals.txt`.

---

## 📂 Project Structure

```text
src/
│
├─ exceptions/
│   ├─ AnimalNotFoundException.java
│   ├─ AnimalNotIncludedException.java
│   ├─ DeplacementImpossibleException.java
│   ├─ EnclosNotFoundException.java
│   ├─ FullEnclosureException.java
│   └─ TypeAnimalNotValidException.java
│
├─ zoo/
│   ├─ animals/
│   │   ├─ Animal.java
│   │   ├─ Carnivore.java
│   │   ├─ Herbivore.java
│   │   ├─ Mammifere.java
│   │   ├─ Oiseau.java
│   │   └─ Reptile.java
│   │
│   ├─ animals.txt
│   ├─ Enclos.java
│   └─ Zoo.java
└─ Main.java
