# CDT-ADPQ-0117
[Prototype](http://52.52.140.5/CHAOS/) for CDT-ADPQ-0117

## Technical Approach

Stanfield Systems developed this prototype using a fully open source set of tools and components. Not only is our application stack completely open source, our development tools and continuous integration environments are too.

Our intent for this project was to choose the simplest combination of technologies that supported development of the prototype while retaining some resemblance to the stack we would choose for a production app. Certain design decisions we made here would be different for a production application. For example, a production application would likely use Angular for user interface (UI) development rather than Java Server Pages.

For the database layer we chose PostgreSQL 9 for its advanced features, scalability, and security. The PostgreSQL database is run in a container from the official Docker repository on Docker Hub. We used Flyway integration with Maven to reset the database on every build, so database persistence on a volume outside the container was not needed or implemented.

The application was written in Java 8 using the Spring MVC framework. We use JPA entities to interact with the database. We have demonstrated the use of both internal controller methods and published REST endpoints for accessing data. The rest endpoints implement the Swagger API for documentation and testing of the endpoints.

The UI is implemented using Java Server Pages, JQuery and Bootstrap. The Data Tables plugin for JQuery is used to facilitate sorting and paging when displaying tabular data. The site is designed to be responsive to any screen size or device.

JUnit was implemented in the project to facilitate unit testing.

Our Continuous Integration (CI) environment consists of an Ubuntu server running as a IaaS VPC hosted by Amazon AWS. This server has Jenkins, Maven, and Docker installed on it and is configured to build when it receives a check in notification from a GitHub WebHook. The Jenkins server pulls the latest version, builds it using maven and runs a script if the build is successful. The script copies the newly compiled WAR file to a folder that contains our support files for Docker, stops our running application container, configures and builds a new container image using a Dockerfile, then launches the new container. Our application container is based on CentOS and runs Tomcat 9 over Java 8.

For development, we used the Spring Tool Suite, which is based on Eclipse. We used Java JDK 8, and built using Maven 3. Tomcat 9 was used to debug/run builds.

### Data Flow 
To demonstrate how the application flows data through its layers, we will use the example of adding a product.

When an admin wants to add a new product to the database, they would browse to http://52.52.140.5/CHAOS/create-product-form. This maps to the Product controller (/src/main/java/com/chaos/stanfield/controller/ProductController.java) which sets up our model (/src/main/java/com/chaos/stanfield/model/Product.java) and calls the view product/create (/src/main/webapp/WEB-INF/pages/product/create), which loads the form used to add a new product.

The form has its action set to "createProduct" with a method of "POST", so when the submit button is clicked the form posts its data to the url /createProduct, which is again handled by our Product controller.

The createProduct function takes the parameters from the form submission and uses them to populate a product instance. This instance is then passed to an instance of the JPAInitEMF class using the InsertEntity call of that class.

JPAInitEMF (/src/main/java/com/chaos/stanfield/utils/JPAInitEMF.java) is a class that facilitates passing objects to the Entity Manager so we don't have to write separate methods for handling each entity. In this case our Product model is passed to the Entity Manager, which is instructed to persist the object and commit the transaction.

The persistence connection is configured using a persistence.xml file (/src/main/resources/META-INF/persistence.xml).

## Agile Methodology

Stanfield Systems applies a Disciplined Agile life cycle for product delivery (See http://www.disciplinedagiledelivery.com/process/).  Disciplined Agile is a process decision framework for delivering projects of varying sizes within an enterprise environment.  Disciplined Agile recognizes that a product release is part of a larger product life cycle that operates within an operational enterprise.  The Construction phase, in which the team collaboratively develops the solution, is at the core of all agile methodologies.  In addition, Disciplined Agile includes a short Inception phase to envision and plan the product release and a short Transition phase to deploy and release the product into operations. 

During the Inception phase, Stanfield Systems defines how Disciplined Agile will be implemented for a specific project or product release.  The Inception phase decisions for the CDT-ADPQ-0117 prototype were significantly influenced by the short delivery cycle and the delivery target of a prototype rather than an operational product.  This phase achieves the following goals:

 * Form Initial Team – Team roles align with our typical Disciplined Agile delivery team structure.  Staff availability requires some team members to fill multiple roles (see __Team Members__ below).
 *	Develop Common Vision – Demonstrate our agile processes and automated DevOps capabilities.
 *	Align with Enterprise Direction – Satisfy the requirements in the RFI.
 *	Explore Initial Scope – Four high-level requirements (epics) and some omitted capabilities:
  *	Publish Product Information (administrator)
  *	Compare Products to Create an Order (user)
  *	Cancel and Track Orders (user)
  *	Track, Analyze, and Visualize Orders (administrator)
  * No exception handling, logging, or authentication and authorization for prototype
 *	Identify Initial Technical Strategy – domain-driven rapid prototyping tools generate the basic product scaffolding to create, retrieve, update, and delete domain entities (e.g. products, users, orders) (see __DevOps Tools and Technologies__ and __Application Tools and Technologies__ below).
 *	Develop Initial Release Plan – One release with three week long sprints -  One inception Sprint and two Construction sprints.
 *	Secure Funding – Proposal budget approved based on hourly rates for team members.
 *	Form Work Environment – Most team members share office space at the same address; however, in some cases remote collaboration is required.  Webex is used for virtual meetings and Trello is used to collaborate and track project activities.
 *	Identify Risks – two risks:
  *	Balancing priorities and time to meet schedule – delivery is a feature.  We mitigate this by prioritizing tasks to achieve a minimal viable product.
  *	Limited time and staff for functional testing – quality may suffer.  We mitigate with automated unit testing and usability testing.  Impact is low as this is a prototype.
  
For the CDT-ADPQ-0117 prototype, the Inception phase lasted one sprint (one week).  We planned and tracked our inception phase goals and activities as cards in our Trello project management board (see __Agile Project Management__ below).  

During the Construction phase, Stanfield Systems applies an agile Scrum-based life cycle (see __Agile Product Development__ below).  Like Scrum, the basic Disciplined Agile life cycle:

*	Manages work within time-boxed iterations (Sprints). 
*	Incorporates frequent collaboration with daily stand-up meetings (Scrums).
*	Employs a cross-functional, self-organizing team with developers, functional experts, and others.
*	Designates a team lead to enforce the discipline of the Scrum process.
*	Designates a product manager that prioritizes the features to be included in the product release.

The basic Disciplined Agile life cycle has some minor differences from the Scrum life cycle.  For the CDT-ADPQ-0117 prototype, the most important difference is that our backlog contains both product features as well as project management and enterprise integration activities (such as documentation and usability analysis) necessary to successfully deliver the product into operations.  All of these product capabilities and project activities are tracked as cards in our Trello project management board.

During the Transition phase, Stanfield Systems performs the activities necessary to validate and certify the product for release into the operational product.  For some organizations, especially those with significant regulatory, security, or safety requirements this phase may involve formal documentation and certifications that take a sprint or two to complete.  In other cases, the Transition phase may be as simple as an administrative handoff.  For the CDT-ADPQ-0117 prototype, the operational deployment is fully automated; however, the RFI requirements involve some documentation and other administrative activities that may take a day or two to complete. 

## Agile Project Management
Stanfield Systems managed the project sprints with Trello, a collaboration and task management tool that utilizes a board, lists, and cards to effectively manage the collection of backlog activities (See [example Trello board](https://github.com/StanfieldSystems/CDT-ADPQ-0117/tree/master/documents/Example_Trello_Board.png)).  The real time updates afforded by the tool were critical to manage standups with remote team members. Team members are informed about all aspects of planning and daily standup activities and understand their role in enabling success. The board is organized into individual lists to track the product backlog, sprint backlog, completed sprints, and issues/risks. The lists are further broken down into cards, or activities for categorization, prioritization and assignment. The board facilitated sprint planning and was used during the daily standups to drive discussions and decisions. Updates are real-time and interactive allowing comments, checklists, labels, and attachments promoting team collaboration.

## Agile Product Development
Stanfield Systems used an agile Scrum methodology to implement the CDT-ADPQ-0117 prototype.  

### Develop backlog
Four Epic user stories, which described the project need at a very high level, were developed by the product owner and added to the product backlog. Prior to sprint planning, the product owner prioritized the Epics, taking the highest priority need and dependencies into consideration. Epics were color coded to categorize related user stories. The four prioritized epics were:

 1.	Publish Product Information
 2.	Compare and Order
 3.	Cancel and Track Orders
 4.	Track, Analyze, and Visualize Orders
 
Individual user stories were derived from the Epic, color coded by category to match the Epic, and grouped together to help the developers understand the primary intent of the deconstructed user stories. The epic was then deleted from the backlog. Refer to [Epic User Stories](https://github.com/StanfieldSystems/CDT-ADPQ-0117/tree/master/documents/EpicUserStories.docx) to review the four epics and deconstructed user stories.

### Sprint Planning
The timeboxed sprint planning meeting is a collaborative effort to commit documented backlog items into a sprint. Due to the aggressive timeline, only two Construction phase sprints were planned. The user stories were clarified by the product owner and developers prioritized and estimated the backlog for potential sprint candidates. Additional user-centric design requirements were added to the user story cards based on input from the Product Owner. Additional details included example screenshots, or expected specifications. See [User Story Details](https://github.com/StanfieldSystems/CDT-ADPQ-0117/tree/master/documents/User_Story_UCD_Detail.docx) for an example of a user story card updated with user-centric detail.

Two project activities remained from the Inception Phase sprint related to technology. See an [example of the Trello board](https://github.com/StanfieldSystems/CDT-ADPQ-0117/tree/master/documents/Sprint_1_Planning.PNG) at the beginning of the first Construction Phase sprint meeting.

### Sprint Backlog
User stories, or cards, were committed to the sprint backlog list once developers confirmed they understood the development and had the capacity to meet their commitment within the sprint timebox. Once the sprint backlog reached capacity, the cards were updated with activity owners and the daily standup meetings were scheduled.

### Daily Scrum
Daily standup meetings were facilitated through WebEx, where each developer informed the team of work completed the previous day, what they will work on the present day, and discuss any challenges. As developers began working on an assigned item in the Sprint Backlog, the card was moved to the “In Progress” list. Once completed, the card was moved to the “Done Sprint” list in Trello. 

An issue was identified and documented during execution of Sprint 1 to track the continuous integration, which presented a technology challenge. To mitigate the risk of losing momentum due to the aggressive timeline, or the allocation of resources, additional backlog items not dependent on the technology were added to the sprint and worked on by other developers during the sprint. This allowed the integration owner to focus on resolving the issue (See [Sprint 1 Trello image](https://github.com/StanfieldSystems/CDT-ADPQ-0117/tree/master/documents/Sprint1_inprogress.PNG)). 

### Sprint Review
At the end of the sprint, the development team demonstrated completed user stories verifying a potentially shippable product increment. 

### Sprint Retrospective
A comprehensive, but very focused sprint retrospective meeting was facilitated to capture lessons learned from the sprint and further promote a high performing team. 

## RFI Requirements

The remainder of this document addresses specific requirements within the RFI.

### Team Members (a, b)
 * Team Lead - Christine Cox
 * Product Manager - Christine Cox
 * Technical Architect - Tim Jacobs
 * Interaction Designer/User Researcher/Usability Tester - Diana Persell
 * Visual Designer - Diana Persell
 * Frontend Web Developer - Greg Fortune, Bhagyesh Patel
 * Backend Web Developer - Greg Fortune, Bhagyesh Patel
 * DevOps Engineer - Greg Fortune

### User-Centric Design (c, d, j)
A sample set of nine users not involved in development of the prototype were identified to provide iterative input into the design, using user-centered design processes, and perform usability testing as indicated below:

 * Three users represent users familiar with online shopping
 * Two user represent a user less familiar with online shopping
 * Four users represent users familiar with technology and support
 
The User-centered design (UCD) process outlines the phases throughout a design and development life cycle all while focusing on gaining a deep understanding of who will be using the product. It is important to note that the UCD process does not specify exact methods for each phase. 

Here are the principles Stanfield Systems applies to ensure a design is user-centered:

 *	The design is based upon an explicit understanding of users, tasks and environments.
 *	Users are involved throughout design and development.
 *	The design is driven and refined by user-centered evaluation.
 *	The process is iterative.

#### Personas and Scenarios
During the UCD process, we created three [Personas](https://github.com/StanfieldSystems/CDT-ADPQ-0117/tree/master/documents/UCD_Personas.pptx) representing the product users. A persona is a user archetype used to help guide decisions about product features, navigation, interactions, and even visual design. 

We developed scenarios depicting a fictional story about the "daily life of" or a sequence of events with the primary stakeholder group as the main character. This person is used as the main character of the story. The story is specific of the events happening relating to the problems of the primary stakeholder group, and the main research questions the design process is built upon. 

#### Online Survey
Because our user team was remote, Stanfield Systems distributed an online survey in Survey Monkey, (https://www.surveymonkey.com/r/JFQYTHB), prior to development to gather information about the user’s typical online shopping experiences. The questionnaire included a mix of ten open-ended and closed questions soliciting general responses regarding the comfort, reliability, and ease of use of their recent shopping experiences. 
While the sample size is not indicative the population of users for a production system, the results provided a sense of how consumers would expect to use an ordering system. The survey results  were analyzed using built in Survey Monkey analytic tools. This knowledge helped drive decisions on usability and visual design.

#### Affinity Diagramming
Stanfield Systems also simulated affinity diagramming to sort data into logical groups. With affinity diagraming, existing items and/or new items identified by individuals are written on sticky notes, which are sorted into categories as a workshop activity. [Affinity diagramming](https://github.com/StanfieldSystems/CDT-ADPQ-0117/tree/master/documents/UCD_Affinity_Diagramming.pptx) was used to identify and group user functions as part of design and analyze the findings from a usability evaluation.
 
### DevOps Tools and Technologies (e, f, m, n, o, p, q, r, s, t)

Stanfield Systems uses several open source tools and technologies to support continuous integration and DevOps.  We use free services from Amazon Web Services for our IAAS hosting in the cloud.

 * GitHub - version control of code and documents, issue tracking
 * GitHub WebHook - notifies build system of check-in
 * Jenkins - build and test management
 * Amazon Web Services Cloudwatch - continuous performance monitoring
 * Amazon Web Services Portal - configuration management of platform services
 * Docker - containerization
 * Swagger - RESTful API documentation

Documentation for installing and running the prototype on another machine is provided in the <>

### Installing and running the prototype on another machine

These instructions assume that the user has properly configured their environment for building and deploying a Java application. This includes installation of an appropriate Java JDK, Maven, modifications to the path, and setup of any required environment variables.

#### Prerequisites

In order to deploy the application in a new environment, the following prerequisites must be met:

 *	Java JDK 8
 * Java Server that supports Java 8 (Tomcat, Glassfish, etc.)
 *	Maven 3
 *	PostgreSQL database
 *	Docker (optional)
 
#### Building

To build the project, perform the following steps:

 *	Update the pom.xml file so that the Flyway Plugin configuration matches the location and authentication requirements of your database server.
 *	Run the command  mvn flyway:migrate  from the project folder to setup and populate your database
 *	Update the /src/main/resources/META-INF/persistence.xml file with the correct JDBC connection string and authentication information 
 *	Run the command  mvn install  from the project folder
 *	Copy the war file in the target folder to the app deployment folder of your Java Server.
 *	Start your Java server
 
#### Optional (Docker)

Both the database and application servers can be run from Docker containers if desired.  

### Application Tools and Technologies (k, l, n)

Stanfield Systems used several open source tools and technologies for developing the prototype.  

 * Spring MVC - RESTful services
 *	Java Persistence Objects (JPA) - object relational mapping (ORM)
 *	Java Server Pages (JSP) - page templating
 * Bootstrap - responsive design styling
 * JQuery - client side scripting
 * PostgresSQL - open source database
 * JUnit - automated unit testing
 * Java 8 - server side development toolkit
 * Maven - dependency and build management
 * Eclipse - integrated development environment.
  * Spring STS Plugin - tools and frameworks for Spring development
  * Maven Plugin - tools for working with Maven

### Usability (g, h, i)

#### Style Guide 
We developed our style guide based on [US Web Design Standards](https://standards.usa.gov/).  For the prototype, we used basic styles integrated with our development tools with minimal changes as necessary to reflect user requirements.

#### Section 508 Compliance
We applied the 508 compliance approach outlined by [W3C](https://www.w3.org/WAI/eval/Overview.html). We used Thymeleaf templates to develop user interfaces that are Section 508 Compliant.  We then validated with manual checks against the [WCAG 2.0 Checklist](https://www.w3.org/TR/2005/WD-WCAG20-20051123/appendixB.html).  

#### Usability Testing
The value of actually meeting your customers and letting them experience your product makes a significant impact to the shape of that product.  Stanfield Systems engaged users early and often during the development process.  Due to the compressed timeline, UX adopted a guerrilla testing method utilizing paper and functioning prototypes. A day of the week was established to conduct repeated tests on a weekly basis.  The goal is to make that day synonymous with testing. UX could stretch to get work into that day’s test and use the cadence to drive productivity.

The sample size was kept small intentionally in order to complete moderated tests quickly and return results to the development team. The [Usability Test Plan](https://github.com/StanfieldSystems/CDT-ADPQ-0117/tree/master/documents/Usability_Test_Plan.pdf)  document was created and distributed prior to each test in order to capture the goals and logistics of the test.   In order to ensure consistency and reduce bias, a [Usability Test Script](https://github.com/StanfieldSystems/CDT-ADPQ-0117/tree/master/documents/ParticipantTestScript.pdf)  was created.  This script is read to every test participant.  The script contains an introduction and scenarios in addition to the specific tasks that the user was asked to accomplish. While these early tests were not recorded, a [Consent Form](https://github.com/StanfieldSystems/CDT-ADPQ-0117/tree/master/documents/Usability_Testing_Informed_Consent.pdf)  was still reviewed and provided to users to outline the overall goals, provide visibility into the methodology of usability testing, make the user feel confident that their information and contributions are confident, and ultimately getting the users consent.

Once the tests were complete, a [Usability Test Outcome](https://github.com/StanfieldSystems/CDT-ADPQ-0117/tree/master/documents/Usability_Test_Outcome.pdf) document was created and posted to share specific findings and data.  During iterative design and development, this data can be used to make small changes and can provide insight into what might be a more significant issue.  UX collaborated with the development team to prioritize issues (if any) that came up during testing that needed to be resolved. The update was then re-tested to a new set of users to measure incremental improvement.

