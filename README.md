![Rick and Morty: Android](sources/image_header_readme.png)

# Rick And Morty - Android

## Gradle

### Plugins

List of plugins used in app

- [Ktlint](https://github.com/pinterest/ktlint)
- [Detekt](https://github.com/arturbosch/detekt#with-gradle)
- [Spotless](https://github.com/diffplug/spotless)
- [Gradle Version Plugin](https://github.com/ben-manes/gradle-versions-plugin)

#### Code analysis

Plugins `Ktlint`, `Spotless` and `Detekt` used for code formating and analysis.

**Usage**:

`gradle ktlintCheck` - code scan

`gradle ktlintFormat` - code scan and format 

`gradle detekt` - code scan and format

`gradle spotlessCheck` - purely code scan

`gradle spotlessApply` - check and format code 

`gradle ktlintFormat detekt spotlessApply ` - use every linter

#### Check for dependencies' update

Plugin **Gradle Versions Plugin**, check version and logs possible updates

**Usage**:

`gradle dependencyUpdates` - check and out updates

Project was developed in internship project at Ronast IT

Design was provided by company [Ronas IT](https://www.ronasit.com)
