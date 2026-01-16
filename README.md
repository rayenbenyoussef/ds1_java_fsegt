# Zoo Management – Java (Terminal App)

A straightforward terminal-based zoo management application written in Java. It lets you manage enclosures, handle animals of different types, and enforce constraints using custom exceptions. Everything is fully OOP, no external libraries.

---

## Features
- Create and manage enclosures  
- Add animals (mammals, birds, reptiles, herbivores, carnivores)  
- Validate animal types before adding them  
- Prevent adding animals to full enclosures  
- Prevent moving animals to invalid or non-existing enclosures  
- Custom exceptions for clean error handling  
- Reads initial animals from a simple text file (`animals.txt`)

---

## Project Structure

```
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
```

---

## How to Run

### Using terminal
Compile everything:

```bash
javac -d bin src/**/*.java
```

Run the main program:

```bash
java -cp bin Main
```

### Using IntelliJ / Eclipse / NetBeans
- Open the project  
- Make sure `src` is marked as a source folder  
- Run `Main.java`

---

## Technologies
- Java 8+  
- Pure OOP  
- No external dependencies

---

## Future Improvements
- Add serialization (save/load zoo state)  
- Add feeding schedules  
- Add automatic health tracking for animals  
- Replace terminal menu with JavaFX UI  
- Add unit tests (JUnit)

---
## ⚖️ License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
