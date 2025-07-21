# 🎮 Java Console-Based Quiz Game

![Java CI](https://github.com/yourusername/quiz-game-java/actions/workflows/java-ci.yml/badge.svg)
![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)

A simple console-based Java quiz game that fetches multiple-choice questions from the [Open Trivia DB API](https://opentdb.com/api_config.php). Built using `json-simple` for JSON parsing.

## 🚀 Features

- Fetches live trivia questions
- Multiple choice with randomized options
- Tracks user score and displays result
- Clean console UI

## 🛠 Technologies Used

- Java 8+
- `json-simple-1.1.1.jar`
- Open Trivia DB API

## 📦 Setup

1. **Clone the repository**

```bash
git clone https://github.com/yourusername/quiz-game-java.git
cd quiz-game-java
```

2. **Add the json-simple JAR**

Download [`json-simple-1.1.1.jar`](https://mvnrepository.com/artifact/com.googlecode.json-simple/json-simple/1.1.1) and place it in the `lib/` folder.

3. **Compile and run**

```bash
javac -cp lib/json-simple-1.1.1.jar src/*.java -d out
java -cp "out:lib/json-simple-1.1.1.jar" QuizGame
```

> On Windows, replace `:` with `;` in the classpath.

## 🔄 Run GUI Version

```bash
java -cp "out:lib/json-simple-1.1.1.jar" QuizGameGUI
```

## 🔍 Sample API Response

Stored in `data/sample.json` for testing JSON parsing.

## 📚 References

- [Open Trivia DB API](https://opentdb.com/)
- [json-simple on Maven](https://mvnrepository.com/artifact/com.googlecode.json-simple/json-simple/1.1.1)

## 🔮 Future Ideas

- Timer per question
- Category & difficulty selection
- Save and load high scores
- GUI with Swing

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

---
Made with ☕ + ❤️