![Rick and Morty: Android](sources/image_header_readme.png)

# Rick And Morty - Android

## Gradle

### Плагины

В проекте есть набор плагинов, ниже представлен список и варианты использования.

- [Ktlint](https://github.com/pinterest/ktlint)
- [Detekt](https://github.com/arturbosch/detekt#with-gradle)
- [Spotless](https://github.com/diffplug/spotless)
- [Gradle Version Plugin](https://github.com/ben-manes/gradle-versions-plugin)

#### Анализ кода

Плагины `Ktlint`, `Spotless` и `Detekt`, для анализа и форматирования кода.

**Использование**:

`gradle ktlintCheck` - проверка кода

`gradle ktlintFormat` - проверка и форматирование кода

`gradle detekt` - проверка и форматирование кода

`gradle spotlessCheck` - только для проверки кода

`gradle spotlessApply` - проверки и форматирование кода

`gradle ktlintFormat detekt spotlessApply ` - с использованием всех линтеров

#### Проверка версии зависимостей

Плагин **Gradle Versions Plugin**, проверяет и выводит текущие версии используемых в проекте
библиотек и их последнии вресии.

**Использование**:

`gradle dependencyUpdates` - проверяет и выводит версии библиотек

Проект разработан в рамках прохождения стажировки по направлению Android
Дизайн был подготовлен компанией [Ronas IT](https://www.ronasit.com)