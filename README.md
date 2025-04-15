
## 📚 Selected Java Projects

### 🕹️ 1. Bomb or Diamond? – Swing Game(BombOrDiamond)
A simple game implemented in Java Swing where the player clicks buttons to randomly find either a "bomb" or a "diamond" over 20 rounds.  
- GridLayout-based GUI  
- Used `JButton`, `JLabel`, `JTextArea`  
- Random logic via `java.util.Random`  
- Name input via `Scanner`

---

### ❌⭕ 2. Tic Tac Toe – JavaFX Game(TicTakToe)
Graphical Tic Tac Toe game built with JavaFX and Scene Builder.  
- Built with FXML and `Button` components  
- Game logic implemented with Java variables and event handling  
- Introduced dependency injection to connect UI and controller logic

---

### 🧩 3. Custom Java Exception System(ExceptionApp)
Created a family of custom exceptions to handle user input errors in a Java application.  
- Used `AlertType.ERROR` from JavaFX for error messages  
- Created base exception and extended it with `DivisionByZero` and `OutOfRange`  
- Provided user-friendly feedback via `getMessage()`

---

### 📄 4. File Read/Write App – JavaFX(ReadWrite)
JavaFX app that allows users to write text to a `.txt` file and read it back.  
- Simple GUI with text area and buttons  
- Uses standard file I/O operations  
- Handles both read and write actions interactively

---

### 🏥 5. Patient Manager – Java + ArrayList(ShrinkManager)
App for managing a list of patients using `ArrayList` and sorting them by name or age.  
- Patient data: name, surname, age  
- Sort option via `ChoiceBox`  
- Output formatted as JSON to the console  
- (Optional) Validation with `java.util.regex`

---

### 📊 8. Word Frequency Analyzer – Producer-Consumer with BlockingQueue(AppFindWords)
A multithreaded Java application that scans `.txt` files in a directory and identifies the top 10 most frequent words.  
- Implements **Producer–Consumer pattern** using `LinkedBlockingQueue`  
- **Producer** traverses directories using `Files.walkFileTree` and queues text files  
- **Consumers** analyze word frequency with `Streams` and `Collectors`  
- Words are cleaned (punctuation removed), lowercased, and filtered (length ≥ 3)  
- Results returned as a sorted `LinkedHashMap<String, Long>`  
- Poison pills (`Optional.empty()`) signal consumers to stop  
- GUI includes basic control panel with `Start`, `Stop`, and `Close` buttons  
- Thread pool managed by `ExecutorService`



