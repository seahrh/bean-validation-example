# bean-validation-example

[![Build Status](https://travis-ci.org/seahrh/bean-validation-example.svg?branch=master)](https://travis-ci.org/seahrh/bean-validation-example)

The Bean Validation API allows code reuse of validators through annotations. Validators pass constraint violations to the application so that it can decide error handling.

## Goals
Learn how to use the Bean Validation API 2.0
- What are the features and limitations?
- Add tests to verify behaviour not covered in the original examples from Hibernate Validator's reference guide<sup>[1](#1)</sup>
- Find out the minimal dependency set required

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
## Evaluation
My personal opinion of Hibernate Validator: TLDR; yes I will definitely use it in my next Java project!
### Features
1. Out of the box, constraints can be declared on the following via Java annotations
    1. [Fields](https://docs.jboss.org/hibernate/stable/validator/reference/en-US/html_single/#_field_level_constraints)
    1. [Properties](https://docs.jboss.org/hibernate/stable/validator/reference/en-US/html_single/#_property_level_constraints) i.e. getter methods, following the JavaBean standard
    1. Values in [standard Java containers](https://docs.jboss.org/hibernate/stable/validator/reference/en-US/html_single/#container-element-constraints) like `java.util.Iterable`, `java.util.Map` and `java.util.Optional`
        1. Also works on nested containers like `Map<@NotNull Part, List<@NotNull Manufacturer>>`
        1. Custom containers require additional work by writing a `ValueExtractor`
    1. Validating the [entire class](https://docs.jboss.org/hibernate/stable/validator/reference/en-US/html_single/#validator-usingvalidator-classlevel), useful for interactions among fields e.g. the seating capacity of a car and number of passengers
    1. [Inheriting contraints](https://docs.jboss.org/hibernate/stable/validator/reference/en-US/html_single/#section-constraint-inheritance) from the superclass
    1. Cascading validation through the [object graph](https://docs.jboss.org/hibernate/stable/validator/reference/en-US/html_single/#section-object-graph-validation) (when an object holds a reference to another object)
        1. Also works for containers
        1. `null` is ignored during cascaded validation
        1.  The validation engine ensures that no infinite loops occur during cascaded validation, for example if two objects hold references to each other.
1. Validators can check the entire object or [parts of it](https://docs.jboss.org/hibernate/stable/validator/reference/en-US/html_single/#_validator_methods) e.g. a single field
1. List of [built-in constraints](https://docs.jboss.org/hibernate/stable/validator/reference/en-US/html_single/#section-builtin-constraints)
    1. Common business objects like `@Email`, `@CreditCardNumber`, `@Currency`
    1. Web: `@URL`, `@SafeHtml`
    1. Time: `@PastOrPresent`, `@Future`
1. Write your own [custom validator](https://docs.jboss.org/hibernate/stable/validator/reference/en-US/html_single/#validator-customconstraints) or [compose](https://docs.jboss.org/hibernate/stable/validator/reference/en-US/html_single/#section-constraint-composition) a new one from existing constraints
    1. By default, constraint composition is logical `AND`. It is also possible to configure logical [`OR` and `ALL FALSE`](https://docs.jboss.org/hibernate/stable/validator/reference/en-US/html_single/#section-boolean-constraint-composition)
1. [Group constraints](https://docs.jboss.org/hibernate/stable/validator/reference/en-US/html_single/#chapter-groups) to check in stages
    1. This mimics business processes/object lifecycles that require different validation logic in each stage
    1. e.g. driving off a new car at the showroom
        1. car must have passed vehicle inspection
        1. driver must have a license
1. Set [dynamic error messages](https://docs.jboss.org/hibernate/stable/validator/reference/en-US/html_single/#chapter-message-interpolation)
1. Dynamic payload
    1. [Pass a payload to the constraint](https://docs.jboss.org/hibernate/stable/validator/reference/en-US/html_single/#validator-customconstraints-constraintannotation), so as to set the control flow of the validation
        1. e.g. a custom constraint `@CheckCase` can have two different payloads `@CheckCase(UPPER)` or `@CheckCase(LOWER)`
    1. [As part of `ConstraintViolation`](https://docs.jboss.org/hibernate/stable/validator/reference/en-US/html_single/#section-dynamic-payload)
        1. Customise error messages e.g. suggest valid values
        1. Provide hints to the application on how to handle the error e.g. error severity
1. For reproducible testing, [define what is the time now](https://docs.jboss.org/hibernate/stable/validator/reference/en-US/html_single/#section-clock-provider) for time-related validation (such as `@Past` or `@Future` constraints)
1. By default, validation reports all the errors found instead of stopping at the first error. Optionally the validator can be configured to [fail fast](https://docs.jboss.org/hibernate/stable/validator/reference/en-US/html_single/#section-fail-fast) e.g. expensive validation of large object graphs

### Limitations
1. Do not recommend use of [method constraints](https://docs.jboss.org/hibernate/stable/validator/reference/en-US/html_single/#section-declaring-method-constraints)
    1. Requires an additional library that has a method interception facility, like Spring AOP
    1. Can only used for instance methods (static methods are not supported)

## References
<a name="1">[1]:</a> Hibernate Validator [reference guide](https://docs.jboss.org/hibernate/stable/validator/reference/en-US/html_single/) and [source code](https://github.com/hibernate/hibernate-validator/tree/master/documentation/src/test/java/org/hibernate/validator/referenceguide)

<a name="2">[2]:</a> [Baeldung examples of Bean Validation API](https://github.com/eugenp/tutorials/tree/master/javaxval/src/main/java/org/baeldung/javaxval/methodvalidation)
