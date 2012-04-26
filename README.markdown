# Java Quality Assurance (JQA) ![](https://secure.travis-ci.org/jbaris/jqa.png?branch=master)
JQA is an open source tool for Java applications QA. It is considered a supplement to tools like PMD (http://pmd.sourceforge.net) or Firebugs (http://findbugs.sourceforge.net/) because it allows to write rules that exploit the bytecode engine capabilities.

## Quickstart
    git clone https://github.com/jbaris/jqa
    cd jqa/jqa-parent/
    mvn clean install
    cd jqa-test-parent
    mvn ar.com.fluxit.jqa:jqa-maven-plugin:check
    cat jqa-test-project/target/results-jqa-test-project.html

## Features
JQA is integrated with:
* Maven 2 (http://maven.apache.org/)
* Sonar (http://www.sonarsource.org/)
JQA allows you to write rules to check your classes regarding:
* Naming
* Typing
* Usage
* Allocations
* Exception throwing
* Astraction

## Documentation
TODO

## License
This project is under GNU General Public License version 3 or later (http://www.gnu.org/licenses/).
