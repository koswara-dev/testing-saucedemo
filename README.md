# testing-saucedemo

Selenium WebDriver + TestNG automation project for SauceDemo and DemoQA practice form.

## Project structure

- `src/main/java/com/juaracoding`: core utility and Page Object classes
  - `drivers/WebDriverSingleton.java`: WebDriver singleton provider (chrome/firefox, headless options)
  - `pages/LoginPage.java`: Page Object for SauceDemo login page
  - `pages/PracticeFormPage.java`: Page Object for DemoQA form page
  - `utils/Utils.java`: helper utilities (delay, etc.)
- `src/test/java/com/juaracoding`: TestNG test classes
  - `LoginTest.java`
  - `PracticeFormTest.java`
  - `WebTablesTest.java` (if present)

## Requirements

- Java 17+
- Maven 3.6+
- ChromeDriver or GeckoDriver (Firefox) available in PATH, or set via system property

## Dependencies

Defined in `pom.xml`:
- `selenium-java 4.41.0`
- `testng 7.12.0`

## Driver options

By default, the project uses Chrome.
Set the browser in Maven command:

- Chrome: `mvn test -Dbrowser=chrome`
- Headless Chrome: `mvn test -Dbrowser=chrome-headless`
- Firefox: `mvn test -Dbrowser=firefox`
- Headless Firefox: `mvn test -Dbrowser=firefox-headless`

If driver executable is not in PATH, configure in `WebDriverSingleton`:

```java
System.setProperty("webdriver.chrome.driver", "C:\\path\\to\\chromedriver.exe");
System.setProperty("webdriver.gecko.driver", "C:\\path\\to\\geckodriver.exe");
```

## Run tests

Run all tests:

```bash
mvn clean test
```

Run specific tests:

```bash
mvn -Dtest=LoginTest test
mvn -Dtest=PracticeFormTest test
```

## Page Object Model

Implemented using Selenium `PageFactory` for:
- `LoginPage` (SauceDemo login scenarios)
- `PracticeFormPage` (DemoQA form fill scenario)

## Notes

- `WebDriverSingleton` ensures one driver instance per test flow and proper cleanup.
- `PracticeFormPage` uses explicit form interactions and encapsulates selectors.
- `LoginTest` validates positive and negative login flows using page object methods.

## Troubleshooting

1. Ensure browser driver version matches browser version.
2. If tests fail due to element timing, adjust waits in page class (replace `Utils.delay` with explicit waits).
3. Verify internet access for `https://www.saucedemo.com` and `https://demoqa.com`.
