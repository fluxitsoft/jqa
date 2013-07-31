<img src="http://www.fluxit.com.ar/logo.jpg"/>

[![githalytics.com alpha](https://cruel-carlota.pagodabox.com/3e55a8f746ec0a54a1a586e67f0bc632 "githalytics.com")](http://githalytics.com/fluxitsoft/jqa)


# Java Quality Assurance (JQA) [![](https://secure.travis-ci.org/fluxitsoft/jqa.png?branch=master)](http://travis-ci.org/fluxitsoft/jqa) 
JQA is an open source tool for QA of Java applications. It is considered a supplement to tools like PMD (http://pmd.sourceforge.net/) or Checkstyle (http://checkstyle.sourceforge.net/) because it allows to write rules that exploit the bytecode engine capabilities for high-level architecture validations.

## Features
JQA is integrated with:
* Maven 2 (http://maven.apache.org/)    
* Sonar (http://www.sonarsource.org/)
* Eclipse (http://www.eclipse.org/) <under development>

JQA allows you to check your application classes regarding:
* __Naming:__ _e.g., "all my DataAccessObject classes must be in the package com.mycompany.myapp.dao and must be named like *DAO"_
* __Typing:__ _e.g., "all my BusinessObject classes must extends to com.mycompany.myapp.bo.AbstractBO (directly or indirectly)"_
* __Usages:__ _e.g., "all my View classes (actions) can't use a DAO class"_
* __Exception throwing:__ _e.g., "all my Service classes must throw only exceptions that extends to com.mycompany.myapp.exception.ServiceException"_
* __Allocations:__ _e.g., "all my DataAccessObject classes must not be allocated/instantiated (via the new keyword)"_
* __Abstraction:__ _e.g., "all my types (files) in the com.mycompany.myapp.service package must be interfaces (contracts)"_

## Screenshots
[Here](http://github.com/fluxitsoft/jqa/wiki/Screenshots) are few screenshots of JQA in action.

## Requirements
* Java 5 or later
* Maven 2

## Documentation
### Quick start
First, download and install JQA:

    git clone http://github.com/fluxitsoft/jqa
    cd jqa/jqa-parent/
    mvn clean install
    
Then, run one of the JQA plugins. 
     
   **To run the JQA Maven plugin:**

    cd jqa-test-parent
    mvn ar.com.fluxit.jqa:jqa-maven-plugin:check
    xdg-open jqa-test-project/target/results-jqa-test-project.html     
   **To run the JQA Sonar plugin:**    

    cd jqa-sonar-plugin
    mvn org.codehaus.sonar:sonar-dev-maven-plugin::start-war -Dsonar.runtimeVersion=2.14 > target/sonar.log &
    tail -f target/sonar.log | while read line; do echo $line | grep -q 'Database is up' && break; done
    cd ../jqa-test-parent
    mvn sonar:sonar -Dsonar.profile="JQA way"
    xdg-open http://localhost:9000/drilldown/violations/ar.com.fluxit.jqa:jqa-test-parent
### Guides
If you want to use JQA, see the [User's guide](http://github.com/fluxitsoft/jqa/wiki/User-guide).     
If you want to contribute to JQA, see the [Developer's guide](http://github.com/fluxitsoft/jqa/wiki/Developer-guide).

## Contribute
JQA is under development, and contributors are welcome. If you have a feature request, suggestion, or bug report, please [open a new issue](http://github.com/fluxitsoft/jqa/issues). 
To submit patches, please send a pull request. 
Once your changes get merged back in, you’ll automatically be added to the [Contributors List](http://github.com/fluxitsoft/jqa/graphs/contributors).

## License
This project is under GNU Lesser General Public License version 3 or later (http://www.gnu.org/licenses/).

[![githalytics.com alpha](https://cruel-carlota.pagodabox.com/0fbedc5327f5a3ec49f4cc11768f0190 "githalytics.com")](http://githalytics.com/jbaris/jqa)


