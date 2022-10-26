# Leap Year
## Software Development and testing, Oblig 3
### Github Actions
Generelle veiledninger: <br />
[Veiledning for github actions med Gradle](https://docs.github.com/en/actions/automating-builds-and-tests/building-and-testing-java-with-gradle) <br />
[Hvordan sette opp github actions](https://docs.github.com/en/actions/quickstart) <br />

Github Actions som er blitt benyttet i denne repo'en er laget med workflow malen: "Java with Gradle". 
For å få en god test med workflowen har følgende blitt lagt til under ```test {..}``` i build.gradle: 

```
testLogging {
events "passed", "skipped", "failed", "standardOut", "standardError"
}
```

Java with Gradle malen er: 
```
# This workflow uses actions that are not certified by GitHub.
# They are provided by a third-party and are governed by
# separate terms of service, privacy policy, and support
# documentation.
# This workflow will build a Java project with Gradle and cache/restore any dependencies to improve the workflow execution time
# For more information see: https://docs.github.com/en/actions/automating-builds-and-tests/building-and-testing-java-with-gradle

name: Java CI with Gradle

on:
  push:
    branches: [ "main" ]
  pull_request:
    branches: [ "main" ]

permissions:
  contents: read

jobs:
  build:

    runs-on: ubuntu-latest

    steps:
    - uses: actions/checkout@v3
    - name: Set up JDK 11
      uses: actions/setup-java@v3
      with:
        java-version: '11'
        distribution: 'temurin'
    - name: Build with Gradle
      uses: gradle/gradle-build-action@67421db6bd0bf253fb4bd25b31ebb98943c375e1
      with:
        arguments: build

```

Som en kan se i malen, så vil workflowen kun reagere når noe dyttes til "main" branch. 
Dette kan så klart endres ved behov. Dersom noe dyttes til main, med denne workflowen lagret i action vil 
resultatet under Build with gradle se slik ut:
```
Run gradle/gradle-build-action@67421db6bd0bf253fb4bd25b31ebb98943c375e1
16
Warning: The `save-state` command is deprecated and will be disabled soon. Please upgrade to using Environment Files. For more information see: https://github.blog/changelog/2022-10-11-github-actions-deprecating-save-state-and-set-output-commands/
17
Warning: The `save-state` command is deprecated and will be disabled soon. Please upgrade to using Environment Files. For more information see: https://github.blog/changelog/2022-10-11-github-actions-deprecating-save-state-and-set-output-commands/
18
Warning: The `save-state` command is deprecated and will be disabled soon. Please upgrade to using Environment Files. For more information see: https://github.blog/changelog/2022-10-11-github-actions-deprecating-save-state-and-set-output-commands/
19
Restore Gradle state from cache
42
Warning: The `save-state` command is deprecated and will be disabled soon. Please upgrade to using Environment Files. For more information see: https://github.blog/changelog/2022-10-11-github-actions-deprecating-save-state-and-set-output-commands/
43
/home/runner/work/LeapYear/LeapYear/gradlew build
44
Starting a Gradle Daemon (subsequent builds will be faster)
45
> Task :compileJava
46
> Task :processResources NO-SOURCE
47
> Task :classes
48
> Task :jar
49
> Task :assemble
50
> Task :compileTestJava
51
> Task :processTestResources NO-SOURCE
52
> Task :testClasses
53

54
> Task :test
55

56
LeapYearTests > See if 1900 was not a Leap year PASSED
57

58
LeapYearTests > See if 1800 was not a Leap year PASSED
59

60
LeapYearTests > Check if 2000 is leap year PASSED
61

62
LeapYearTests > Check if all years from year 0 until 2000 dividable with 4 but not 100 is leap year PASSED
63

64
LeapYearTests > Check if every year dividable with 400 is a Leap year PASSED
65

66
LeapYearTests > See if 1700 was not a Leap year PASSED
67

68
LeapYearTests > See if 2100 is not going to be Leap year PASSED
69

70
LeapYearTests > See if years dividable with 100 but not 400 is a leap year PASSED
71

72
LeapYearTests > See if years that is not dividable by four is not a leap year PASSED
73

74
> Task :check
75
> Task :build
76

77
BUILD SUCCESSFUL in 13s
78
4 actionable tasks: 4 executed
```
Her kan en se testene som blir kjørt. Dersom det er tester som feiler, 
så vil github sende ut en e-post om at noe gikk galt.