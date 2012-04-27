# Java Quality Assurance (JQA) [![Build Status](https://secure.travis-ci.org/jbaris/jqa.png?branch=master)](http://travis-ci.org/jbaris/jqa)
JQA is an open source tool for QA of Java applications. It is considered a supplement to tools like PMD (http://pmd.sourceforge.net) or Firebugs (http://findbugs.sourceforge.net/) because it allows to write rules that exploit the bytecode engine capabilities.

## Features
JQA is integrated with:
* Maven 2 (http://maven.apache.org/)    
* Sonar (http://www.sonarsource.org/)

JQA allows you to write rules to check your classes regarding:
* Naming
* Typing
* Usages
* Allocations
* Exception throwing
* Abstraction

## Requirements
* Java 5 or later
* Maven 2

## Documentation
### Getting started
    git clone https://github.com/jbaris/jqa
    cd jqa/jqa-parent/
    mvn clean install
    cd jqa-test-parent
    mvn ar.com.fluxit.jqa:jqa-maven-plugin:check
    cat jqa-test-project/target/results-jqa-test-project.html
### Installation
TODO how to install JQA

### Usage
TODO how to run JQA

### Customizing JQA
TODO how to customize JQA by creating new rules

## Contribute
TODO hot to contribute

## License
This project is under GNU General Public License version 3 or later (http://www.gnu.org/licenses/)