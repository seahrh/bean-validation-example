# bean-validation-example

[![Build Status](https://travis-ci.org/seahrh/bean-validation-example.svg?branch=master)](https://travis-ci.org/seahrh/bean-validation-example)

## Goals
- Learn how to use the Bean Validation API 2.0.
- Added more tests of my own to verify behaviour not covered in the original examples from Hibernate Validator's reference guide<sup>[1](#1)</sup>.
- Find out the minimum dependency set required

## Prerequisites
- JDK 8
- Apache Maven

### Maven Dependencies
Two dependencies required.

1. Hibernate Validator - implementation of the Bean Validation API

    `pom.xml`
    ```xml
    <dependency>
        <groupId>org.hibernate.validator</groupId>
        <artifactId>hibernate-validator</artifactId>
        <version>6.0.13.Final</version>
    </dependency>
    ```
1. Unified EL - implementation of the Unified Expression Language (JSR 341) for evaluating dynamic expressions in constraint violation messages. Not required if the application is running in a Java EE container.

    `pom.xml`
    ```xml
    <dependency>
        <groupId>org.glassfish</groupId>
        <artifactId>javax.el</artifactId>
        <version>3.0.1-b09</version>
    </dependency>
    ```

## References
<a name="1">[1]:</a> Hibernate Validator [reference guide](https://docs.jboss.org/hibernate/stable/validator/reference/en-US/html_single/) and [source code](https://github.com/hibernate/hibernate-validator/tree/master/documentation/src/test/java/org/hibernate/validator/referenceguide)

<a name="2">[2]:</a> [Baeldung examples of Bean Validation API](https://github.com/eugenp/tutorials/tree/master/javaxval/src/main/java/org/baeldung/javaxval/methodvalidation)
