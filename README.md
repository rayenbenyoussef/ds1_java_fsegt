# Zoo Management – Java (Terminal App) 🦁
### University Project | Faculty of Economic Sciences and Management of Tunis (FSEGT)

A robust, "crash-proof" terminal-based zoo management application written in Java. It allows users to manage enclosures, handle animals of different species, and enforce strict logic constraints using custom exceptions. [1]

This project was designed with a focus on **stability and user experience**, featuring a compiled .exe version for easy execution on Windows without needing an IDE. [1]

## 🚀 Features
* **Standalone Executable:** Runs as a native Windows .exe file for portability. [2]
* **Crash-Proof Input:** Robust validation ensures the app never crashes on invalid inputs (e.g., entering letters where numbers are expected). [2]
* **Smart Management:** [2]
    * Create and manage enclosures. [2]
    * Add animals (Mammals, Birds, Reptiles, Herbivores, Carnivores). [2]
    * **Auto Fill** option for quick testing. [2]
    * **Search by ID** for quick animal lookup. [2]
* **Logic Enforcement:** [2]
    * Validates animal types before adding them. [2]
    * Prevents adding animals to full enclosures. [2]
    * Prevents moving animals to invalid or non-existing enclosures. [2]
* **Clean Architecture:** Fully OOP with custom exceptions (`FullEnclosureException`, `AnimalNotFoundException`, etc.). [2]
* **Data Persistence:** Reads initial animal data from `animals.txt`. [2]

## 📂 Project Structure
* **src/**: Contient le code source Java du projet. [3]
* **test_projet/**: Contient les fichiers liés aux tests (incluant anciennement l'exécutable). [3]
* **LICENSE**: Fichier de licence MIT. [3]
* **README.md**: Documentation du projet. [3]
