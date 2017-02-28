# CDT-ADPQ-0117
Prototype for CDT-ADPQ-0117

## Technical Approach

Stanfield Systems applies a Disciplined Agile life cycle for product delivery (See http://www.disciplinedagiledelivery.com/process/).  Disciplined Agile is process decision framework for delivering projects of varying sizes within an enterprise environment.  Disciplined Agile recognizes that a product release is part of a larger product life cycle that operates within an operational enterprise.  Consequently, in addition to the Construction phase at the core of all agile methodologies, Disciplined Agile includes a short Inception phase to envision and plan the product release and a short Transition phase to deploy and release the product into operations.  

During the Inception phase, Stanfield Systems defines how Disciplined Agile will be implemented for a specific project or product release.  The Inception phase decisions for the CDT-ADPQ-0117 prototype were significantly influenced by the short delivery cycle and the delivery target of a prototype rather than an operational product.  This phase achieves the following goals:

 * Form Initial Team – Team roles align with our typical Disciplined Agile delivery team structure.  Staff availability requires some team members to fill multiple roles (see __Team Members__ below)
 *	Develop Common Vision – Demonstrate our agile processes and automated DevOps capabilities.
 *	Align with Enterprise Direction – Satisfy the requirements in the RFI.
 *	Explore Initial Scope – Four high-level requirements (epics) and some omitted capabilities
  *	Publish Product Information (administrator)
  *	Compare Products to Create an Order (user)
  *	Cancel and Track Orders (user)
  *	Track, Analyze, and Visualize Orders (administrator)
  * No exception handling, logging, or authentication and authorization for prototype
 *	Identify Initial Technical Strategy – domain-driven rapid prototyping tools generate the basic product scaffolding to create, retrieve, update, and delete domain entities (e.g. products, users, orders) (see __DevOps Tools and Technologies__ and __Application Tools and Technologies__ below)
 *	Develop Initial Release Plan – One release with three week long sprints -  One inception Sprint and two Construction sprints.
 *	Secure Funding – Proposal budget approved based on hourly rates for team members.
 *	Form Work Environment – Most team members share office space at the same address; however, in some cases remote collaboration is required.  Webex is used for virtual meetings and Trello is used to collaborate and track project activities
 *	Identify Risks – two risks
  *	Balancing priorities and time to meet schedule – delivery is a feature.  We mitigate this by prioritizing tasks to achieve minimal viable product.
  *	Limited time and staff for functional testing – quality may suffer.  We mitigate with automated unit testing and usability testing.  Impact is low as this is a prototype.
  
For the CDT-ADPQ-0117 prototype, the Inception phase lasted one sprint (one week).  We planned and tracked our inception phase goals and activities as cards in our Trello project management board (see __Agile Project Management__ below).  

During the Construction phase, Stanfield Systems applies an agile Scrum-based life cycle (see __Agile Product Development__ below).  Like Scrum, the basic Disciplined Agile life cycle:

*	Manages work within time-boxed iterations (Sprints) 
*	Incorporates frequent collaboration with daily stand-up meetings (Scrums)
*	Employs a cross-functional, self-organizing team with developers, functional experts, and others
*	Designates a team lead to enforce the discipline of the Scrum process
*	Designates a product manager that prioritizes the features to be included in the product release.

The basic Disciplined Agile life cycle has some minor differences from the Scrum life cycle.  For the CDT-ADPQ-0117 prototype, the most important difference is that our backlog contains both product features as well as project management and enterprise integration activities (such as documentation and usability analysis) necessary to successfully deliver the product into operations.  All of these product capabilities and project activities are tracked as cards in our Trello project management board.

During the Transition phase, Stanfield Systems performs the activities necessary to validate and certify the product for release into the operational product.  For some organizations, especially those with significant regulatory, security, or safety requirements this phase may involve formal documentation and certifications that take a sprint or two to complete.  In other cases, the Transition phase may be as simple as an administrative handoff.  For the CDT-ADPQ-0117 prototype, the operational deployment is fully automated; however, the RFI requirements involve some documentation and other administrative activities that may take a day or two to complete. 

## Agile Project Management
Stanfield Systems managed the project sprints with Trello, a collaboration and task management tool that utilizes a board, lists, and cards to effectively manage the collection of backlog activities.  The real time updates afforded by the tool were critical to manage standups with remote team members. Team members are informed about all aspects of planning and daily standup activities and understand their role in enabling success. The board is organized into individual lists to track the product backlog, sprint backlog, completed sprints, and issues/risks. The lists are further broken down into cards, or activities for categorization, prioritization and assignment. The board facilitated sprint planning and was used during the daily standups to drive discussions and decisions. Updates are real-time and interactive allowing comments, checklists, labels, and attachments promoting team collaboration.

## Agile Product Development
Stanfield Systems used an agile Scrum methodology to implement the CDT-ADPQ-0117 prototype.  

### Develop backlog
Four Epic user stories, which described the project need at a very high level, were developed by the product owner and added to the product backlog. Prior to sprint planning, the product owner prioritized the Epics, taking the highest priority need and dependencies into consideration. Epics were color coded to categorize related user stories. The four prioritized epics were:

 1.	Publish Product Information
 2.	Compare and Order
 3.	Cancel and Track Orders
 4.	Track, Analyze, and Visualize Orders
 
Individual user stories were derived from the Epic, color coded by category to match the Epic, and grouped together to help the developers understand the primary intent of the deconstructed user stories. The epic was then deleted from the backlog. Refer to “Epic User Stories” at <insert doclink> to review the four epics and deconstructed user stories.

### Sprint Planning
The timeboxed sprint planning meeting is a collaborative effort to commit documented backlog items into a sprint. Due to the aggressive timeline, only two sprints were planned. The user stories were clarified by the product owner and developers prioritized and estimated the backlog for potential sprint candidates. Two project activities remained from the Inception Phase sprint related to technology. Refer to <Sprint 1 Planning.PNG> for an example of the Trello board at the beginning of the first Construction Phase sprint meeting.

### Sprint Backlog
User stories, or cards, were committed to the sprint backlog list once developers confirmed they understood the development and had the capacity to meet their commitment within the sprint timebox. Once the sprint backlog reached capacity, the cards were updated with activity owners and the daily standup meetings were scheduled.

### Daily Scrum
Daily standup meetings were facilitated through WebEx, where each developer informed the team of their current work, expectations of work to be completed the following day, and any challenges. As developers began working on an assigned item in the Sprint Backlog, the card was moved to the “In Progress” list, and then moved to the “Done Sprint 1” list in Trello once done. 

A potential issue was identified and documented to track integration efforts, which presented a technology challenge. To mitigate the risk of losing momentum due to the aggressive timeline, or the allocation of resources, additional backlog items not dependent on the technology were added to the sprint and worked on by other developers during the sprint. This allowed the integration owner to focus on resolving the issue. Refer to <Sprint1 in progress. PNG>. 

### Sprint Review

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

### User-Centric Design (c, d)
 - [ ] User team (People) - describe characteristics and number
 
The User-centered design (UCD) process outlines the phases throughout a design and development life-cycle all while focusing on gaining a deep understanding of who will be using the product. The international standard 13407 is the basis for many UCD methodologies. It’s important to note that the UCD process does not specify exact methods for each phase. 

Here are principles we apply to ensure a design is user centered:

 *	The design is based upon an explicit understanding of users, tasks and environments.
 *	Users are involved throughout design and development.
 *	The design is driven and refined by user-centered evaluation.
 *	The process is iterative.

#### Personas and Scenarios
During the UCD process, we created multiple Personas representing the product users. A persona is a user archetype used to help guide decisions about product features, navigation, interactions, and even visual design. 

We developed scenarios depicting a fictional story about the "daily life of" or a sequence of events with the primary stakeholder group as the main character. Typically, a persona that was created earlier is used as the main character of this story. The story should be specific of the events happening that relate to the problems of the primary stakeholder group, and normally the main research questions the design process is built upon. 

#### Contextual Inquiry
We simulated a contextual inquiry, which is a specific type of interview for gathering field data from users. It is usually done by one interviewer speaking to one interviewee (person being interviewed) at a time. The aim is to gather as much data as possible from the interviews for later analysis.

#### Affinity Diagramming
We simulated affinity diagramming to sort large amounts of data into logical groups. With affinity diagraming, existing items and/or new items identified by individuals are written on sticky notes, which are sorted into categories as a workshop activity. Affinity diagramming can be used to:

  *	analyse findings from field studies
  * identify and group user functions as part of design
  * analyse findings from a usability evaluation
 
#### Journey Mapping
We developed a customer journey map, which is a visualization of the process that a person goes through in order to accomplish a goal. It’s used for understanding and addressing customer needs and pain points.

In its most basic form, journey mapping starts by compiling a series of user goals and actions into a timeline skeleton. Next, the skeleton is fleshed out with user thoughts and emotions in in order to create a narrative. Finally, that narrative is condensed into a visualization used to communicate insights that will inform design processes.

### DevOps Tools and Technologies (e, f, m, n)

Stanfield Systems uses several open source tools and technologies to support continuous integration and DevOps.  We use free services from Amazon Web Services for our PAAS hosting in the cloud.

 * GitHub - version control of code and documents, issue tracking
 * GitHub WebHook - notifies build system of check-in
 * Jenkins - build and test management
 * Amazon Web Services CodeDeploy - API for automating code deployment
 * Amazon Web Services EC2 ElasticBeans - 
 * Amazon Web Services Cloudwatch - continuous performance monitoring
 * Amazon Web Services Portal - configuration management of platform services
 * Docker - containerization
 * Swagger - RESTful API documentation

### Application Tools and Technologies (k, l)

Stanfield Systems used several open source tools and technologies for developing the prototype.  

 * Spring MVC - RESTful services
 * Bootstrap - responsive design styling
 * JQuery - client side scripting
 * Thymeleaf - view engine
 * Derby - embedded database
 * Java 8 - server side development toolkit
 * Maven - dependency and build management
 * Spring Boot - Spring quick start framework
 * Eclipse - integrated development environment.
  * Spring STS Plugin - tools and frameworks for Spring development
  * Spring Roo Plugin - rapid application development
  * Maven Plugin - tools for working with Maven

### Usability (g, h, i)

#### Style Guide 
We developed our style guide based on [US Web Design Standards](https://standards.usa.gov/).  For the prototype, we used basic styles integrated with our development tools with minimal changes as necessary to reflect user requirements.

#### Section 508 Compliance
We applied the 508 compliance approach outlined by [W3C](https://www.w3.org/WAI/eval/Overview.html). We used Thymeleaf templates to develop user interfaces that are Section 508 Compliance.  We then validated with manual checks against the [WCAG 2.0 Checklist](https://www.w3.org/TR/2005/WD-WCAG20-20051123/appendixB.html).  

#### Usability Testing
In Agile, usability testing is abbreviated and lean.  We incorporate testing into each sprint with fewer participants but increased frequency.  A dashboard for each study is created which includes the test goals and logistics.  Tests are done remotely using Join Me.  Each session is recorded to assist in sharing results.  Within 24 hours after the end of a test, a results document is distributed to the team.  Any immediate findings will be shared with the team through the team collaboration tool (GitHub).
