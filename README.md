# CDT-ADPQ-0117
Prototype for CDT-ADPQ-0117

## Summary of Technical Approach

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
  
For the CDT-ADPQ-0117 prototype, the Inception phase lasted one sprint (one week).  We planned and tracked our inception phase goals and activities as cards in our Trello project management board.  

During the Construction phase, Stanfield Systems applies an agile Scrum-based life cycle.  Like Scrum, the basic Disciplined Agile life cycle:

*	Manages work within time-boxed iterations (Sprints) 
*	Incorporates frequent collaboration with daily stand-up meetings (Scrums)
*	Employs a cross-functional, self-organizing team with developers, functional experts, and others
*	Designates a team lead to enforce the discipline of the Scrum process
*	Designates a product manager that prioritizes the features to be included in the product release.

The basic Disciplined Agile life cycle has some minor differences from the Scrum life cycle.  For the CDT-ADPQ-0117 prototype, the most important difference is that our backlog contains both product features as well as project management and enterprise integration activities (such as documentation and usability analysis) necessary to successfully deliver the product into operations.  All of these product capabilities and project activities are tracked as cards in our Trello project management board.

During the Transition phase, Stanfield Systems performs the activities necessary to validate and certify the product for release into the operational product.  For some organizations, especially those with significant regulatory, security, or safety requirements this phase may involve formal documentation and certifications that take a sprint or two to complete.  In other cases, the Transition phase may be as simple as an administrative handoff.  For the CDT-ADPQ-0117 prototype, the operational deployment is fully automated; however, the RFI requirements involve some documentation and other administrative activities that may take a day or two to complete. 

## Team Members (a, b)
 * Team Lead - Christine Cox
 * Product Manager - Christine Cox
 * Technical Architect - Tim Jacobs
 * Interaction Designer/User Researcher/Usability Tester - Diana Persell
 * Visual Designer - Diana Persell
 * Frontend Web Developer - Greg Fortune, Bhagyesh Patel
 * Backend Web Developer - Greg Fortune, Bhagyesh Patel
 * DevOps Engineer - Greg Fortune

## User-Centric Design (c, d)
 - [ ] User team (People) - describe characteristics and number
 - [ ] Technique 1 - Label/Summarize - reference artifacts (e.g. approach and artifacts)
 - [ ] Technique 2 - Label/Summarize - reference artifacts (e.g. approach and artifacts)
 - [ ] Technique 3 - Label/Summarize - reference artifacts (e.g. approach and artifacts)

## DevOps Tools and Technologies (e, f, m, n)
 * GitHub - version control of code and documents
 * Swagger - RESTful API documentation
 - [ ] others.....

## Application Tools and Technologies (k, l)
 * Spring MVC
 * Spring Roo
 * Derby
 * Eclipse IDE
  * Spring STS Plugin
  * Spring Roo Plugin 
 - [ ] others....
 - [ ] describe purpose

## Usability (g, h, i)
 - [ ] Style Guide - reference artifacts (e.g. Style Guide used)
 - [ ] Section 508 Compliance - describe approach/tools - reference artifacts (e.g. tool results)
 - [ ] Usability Testing - describe approach - reference artifacts (e.g. test cases, results)

## Agile Development Process (j)
 - [ ] Summarize Disciplined Agile - reference artifacts as appropriate
 - [ ] Summarize Trello for Project Management - reference screenshots for each sprint
 - [ ] Summarize Scrum for Construction Iterations - reference meeting results (e.g. Trello screen shots, sprint backlogs, issues, risks)
