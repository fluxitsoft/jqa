# Java Quality Assurance (JQA) [![](https://secure.travis-ci.org/jbaris/jqa.png?branch=master)](http://travis-ci.org/jbaris/jqa)
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

## Screenshots
[Here](http://github.com/jbaris/jqa/wiki/Screenshots) are few screenshots of JQA in action.

## Requirements
* Java 5 or later
* Maven 2

## Documentation
### Getting started
    git clone http://github.com/jbaris/jqa
    cd jqa/jqa-parent/
    mvn clean install
    cd jqa-test-parent
    mvn ar.com.fluxit.jqa:jqa-maven-plugin:check
    cat jqa-test-project/target/results-jqa-test-project.html

### Guides
If you want to use JQA, see the [User's guide](http://github.com/jbaris/jqa/wiki/User-guide).
If you want to contribute to JQA, see the [Developer's guide](http://github.com/jbaris/jqa/wiki/Developer-guide).

## Contribute
JQA is under development, and contributors are welcome. If you have a feature request, suggestion, or bug report, please [open a new issue](http://github.com/jbaris/jqa/issues). To submit patches, please send a pull request. Once your changes get merged back in, you’ll automatically be added to the [Contributors List](http://github.com/jbaris/jqa/graphs/contributors)

## License
This project is under GNU General Public License version 3 or later (http://www.gnu.org/licenses/)
