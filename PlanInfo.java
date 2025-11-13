Perfect — I got your full demo explanation. You’ve built an automated Task Monitoring System that detects failed jobs in Windows EC2 instances, restarts them automatically, and escalates only when needed. Let’s turn your spoken walkthrough into a professional, structured, clear presentation script you can use word-for-word in your demo or slides.

🎯 Task Monitoring Process – Demo Presentation

🟦 1. Introduction
You can say:
Good morning everyone.
Today I’m going to give a demo on the Task Monitoring Process, which is an updated version of the application I showed earlier.
Previously, we had a semi-manual setup — today’s version is smarter and more automated. I’ll walk you through what problem we’re solving, how the new solution works, and what improvements we’ve made.

🟦 2. Problem Statement
You can say:
So, as you know, we have multiple EC2 instances, and inside each EC2 instance, there are several scheduled tasks or jobs running regularly.
The main issue we faced is that sometimes these jobs fail to run properly.
To detect this, we had to manually log into each EC2 instance and check the Task Scheduler.
This was:


Time-consuming,


Labor-intensive, and


Prone to human error.


So overall, a lot of manual effort was going into simply checking whether jobs were running or not.

🟦 3. Objective
You can say:
The goal was to automate the entire monitoring and recovery process —
to automatically detect failed tasks, attempt recovery, and notify the right people —
without needing to manually log in every time.

🟦 4. Proposed Solution
You can say:
To solve this, I implemented an automated Task Monitoring System.
Here’s how it works step-by-step:


On each EC2 instance, I installed a small Amazon “Robot Checker” agent.


This component continuously checks the Windows Task Scheduler to monitor job statuses.




When a job fails, the robot checker sends log data to AWS CloudWatch.


CloudWatch detects this failure and triggers an AWS Lambda function automatically.


The Lambda function then takes control — it:


Checks the instance ID and task name as a unique key.


Looks up this key in a separation table (a tracking table to prevent redundant restarts).


If not found in the table, it tries to restart the failed task once.


If the restart fails, it waits for a minute and retries again.


After multiple failed attempts, it adds that instance-task pair to the separation table to avoid infinite retry loops.




The separation table entry also has a time limit — after that duration expires, the system will recheck that task again.



🟦 5. Notification & Escalation
You can say:
If the Lambda fails to restart the job after multiple tries, it sends an email alert.
This alert includes:


The instance name,


The task name,


And the error details.


The alert goes directly to the team responsible for that particular machine,
so only the relevant person needs to take action — this saves a lot of time.

🟦 6. Dashboard and Metrics
You can say:
I’ve also added a monitoring dashboard that provides visibility into what’s happening.
The dashboard shows:


For each task:


How many times the Lambda successfully restarted it,


How many times it failed,


And how many times it triggered alerts.




This helps us identify unstable tasks and problematic instances easily.

🟦 7. Benefits
You can say:
This solution provides several benefits:


Reduces manual monitoring effort drastically.


Detects and resolves failures automatically.


Escalates only when necessary.


Improves reliability and uptime of scheduled jobs.


Gives a centralized view through the dashboard.


Overall, this system saves time, improves efficiency, and reduces human dependency.

🟦 8. Future Improvements
You can say:
There’s still room for improvement.
Some upcoming updates I’m planning:


Adding multi-region instance support.


Integrating Slack or Teams notifications for faster alerts.


Building an auto-healing decision layer using environment flags (e.g., rebooting in UAT only).


Improving dashboard visualization with more filters and history trends.



🟦 9. Conclusion
You can say:
So, in summary:


We started with a manual, time-consuming process.


We built an automated, CloudWatch-driven, Lambda-based system.


Now, the system monitors, restarts, logs, and alerts — all automatically.


This significantly reduces human effort and improves reliability.
Thank you — that’s the overview and demo of the updated Task Monitoring Process.

Would you like me to make this into a PowerPoint-style slide deck (with bullet points and short text) or a speaker script version (with talking flow for each slide)?

Continue to build your rewarding career helping others achieve their financial dream at an organization that values your own long-term success. With your unique talents, you have what it takes to be bold and brilliant in everything you do and reach new heights for a company dedicated to diversity and inclusion, community and you. 

This role is a job level of G Professional/Technical.





3-6 years of hands-on experience in technology testing. Ability to understand the application designs along with working with multiple stakeholders in different locations.

Additional Job Description

A minimum of 3-6 years of hands-on testing experience in technology space.Should have in-depth knowledge of how a back-end system functions with skills in coding PL/SQL, Unix scripts and Core Java.Degree in computer science or information systems or equivalent applicable work experience.Should have experience in working with developers and architects in designing test cases.

Should have experience in writing complex SQL queries.

Should replicate production issues and co-ordinate with developers in analysis.Exposure to behavior Driven Development and Test-Driven Development is a huge plus.Team player and demonstrated an ability to work with multiple teams across locations.Good Analytical skills and ability to think of ways to break the system by innovative test case management.Desirable to have worked on Financial industry, specifically US retirement or Insurance products.Good written and verbal communication skills.Agile/Scrum MethodologyHand on to Automation and Performance testing tools/products is a definite plus.



This job description is not intended to be an exhaustive list of all duties, responsibilities and qualifications of the job.  The employer has the right to revise this job description at any time.   You will be evaluated in part based on your performance of the responsibilities and/or tasks listed in this job description.   You may be required perform other duties that are not included on this job description. The job description is not a contract for employment, and either you or the employer may terminate employment at any time, for any reason, as per terms and conditions of your employment contract.

We are an equal opportunity employer with a commitment to diversity.  All individuals, regardless of personal characteristics, are encouraged to apply.  All qualified applicants will receive consideration for employment without regard to age, race, color, national origin, ancestry, sex, sexual orientation, gender, gender identity, gender expression, marital status, pregnancy, religion, physical or mental disability, military or veteran status, genetic information, or any other status protected by applicable state or local law. 

DEVOPS:
Engineer DevOps-1
Applied 11/04/2025, 7:51 PM
Continue to build your rewarding career helping others achieve their financial dream at an organization that values your own long-term success. With your unique talents, you have what it takes to be bold and brilliant in everything you do and reach new heights for a company dedicated to diversity and inclusion, community and you. 

This role is a job level of G Professional/Technical.





DevOps Engineer at Empower

Overview

As a DevOps Engineer at Empower, you’ll help support, design, build, and operate our AWS-native cloud infrastructure. You’ll automate provisioning, configuration, and deployment pipelines following Infrastructure as Code (IaC) best practices, while empowering engineering teams with tools and processes that improve velocity, reliability, and security.

You’ll work on a small, high-impact team that values ownership, collaboration, and continuous improvement, balancing short-term tactical priorities with long-term architectural goals.

Key Responsibilities

Automate AWS infrastructure provisioning using Terraform, AWS CDK, and CloudFormation.
Build and maintain CI/CD pipelines for Java and Python applications using modern DevOps tooling in cloud resources.
Enhance operational excellence by reducing manual tasks, optimizing cost, and improving system reliability through automation.
Collaborate with engineering teams to improve developer experience, deployment consistency, and observability.
Implement security best practices across AWS environments, including IAM, networking, and data protection.
Monitor and optimize application performance, leveraging AWS services like CloudWatch, Quick Sight, ECS/EKS and Lambda.
Support and troubleshoot production environments as part of an on-call rotation.
Continuously evaluate emerging technologies and propose ways to increase efficiency and resilience.
Required Skills & Experience

2+ years of experience in DevOps, cloud system support, cloud engineering, or software engineering roles.
Strong AWS experience (EC2, S3, IAM, RDS, Lambda, CloudFormation, CloudWatch, ECS/EKS).
Proficient in Python and/or Java for automation, scripting, and service integration.
Hands-on experience with IaC tools (Terraform, CDK, or CloudFormation).
Proficient with Linux systems administration and shell scripting.
Experience with CI/CD tools such as Jenkins, GitHub Actions, or AWS CodePipeline.
Solid understanding of networking, security, and cloud architecture fundamentals.
Preferred Qualifications

Experience with containerization and orchestration (Docker, Kubernetes, EKS).
Familiarity with monitoring and observability tools such as Datadog, Splunk, or CloudWatch.
Understanding of relational and NoSQL databases (e.g., Postgres, DynamoDB, Redshift).
Experience with automated security and compliance controls in AWS environments.
Experience with ChatGPT or other Ai platforms
Excellent collaboration and communication skills, with a mindset of continuous learning and improvement.
Why Join Us

You’ll join a forward-looking DevOps organization that believes in automation-first operations, deep AWS integration, and enabling developers through smart tooling. We value engineers who are curious, pragmatic, and passionate about making cloud infrastructure simple, secure, and scalable.





We are an equal opportunity employer with a commitment to diversity.  All individuals, regardless of personal characteristics, are encouraged to apply.  All qualified applicants will receive consideration for employment without regard to age, race, color, national origin, ancestry, sex, sexual orientation, gender, gender identity, gender expression, marital status, pregnancy, religion, physical or mental disability, military or veteran status, genetic information, or any other status protected by applicable state or local law. 


package com.example.firstt;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class PlanInfo {

    @Id
    private String evId;
    private String planName;
    private String irsrlCode;
    private String provCompany;
    private String prodId;
    private String statusCode;
    private String dpDateTime;
    private String rolloverInd;
    private String gaId;
    private String clientName;
    private String firstLineMailing;
    private String scndLineMailing;
    private String city;
    private String stateCode;
    private String zipCode;
    private String country;
    private String internalComplianceInd;
    private String planAnnivDate;
    private int estNumberOfParticipants;
    private long estPlanAssets;
    private LocalDate estImplementationDate;
    private String subsetCashCode;
    private String clientEntityType;
    private String tpaFirmId;
	
    
    
    public String getEvId() {
        return evId;
    }

    public void setEvId(String evId) {
        this.evId = evId;
    }
	public String getPlanName() {
		return planName;
	}
	public void setPlanName(String planName) {
		this.planName = planName;
	}
	public String getIrsrlCode() {
		return irsrlCode;
	}
	public void setIrsrlCode(String irsrlCode) {
		this.irsrlCode = irsrlCode;
	}
	public String getProvCompany() {
		return provCompany;
	}
	public void setProvCompany(String provCompany) {
		this.provCompany = provCompany;
	}
	public String getProdId() {
		return prodId;
	}
	public void setProdId(String prodId) {
		this.prodId = prodId;
	}
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	public String getDpDateTime() {
		return dpDateTime;
	}
	public void setDpDateTime(String dpDateTime) {
		this.dpDateTime = dpDateTime;
	}
	public String getRolloverInd() {
		return rolloverInd;
	}
	public void setRolloverInd(String rolloverInd) {
		this.rolloverInd = rolloverInd;
	}
	public String getGaId() {
		return gaId;
	}
	public void setGaId(String gaId) {
		this.gaId = gaId;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public String getFirstLineMailing() {
		return firstLineMailing;
	}
	public void setFirstLineMailing(String firstLineMailing) {
		this.firstLineMailing = firstLineMailing;
	}
	public String getScndLineMailing() {
		return scndLineMailing;
	}
	public void setScndLineMailing(String scndLineMailing) {
		this.scndLineMailing = scndLineMailing;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStateCode() {
		return stateCode;
	}
	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getInternalComplianceInd() {
		return internalComplianceInd;
	}
	public void setInternalComplianceInd(String internalComplianceInd) {
		this.internalComplianceInd = internalComplianceInd;
	}
	public String getPlanAnnivDate() {
		return planAnnivDate;
	}
	public void setPlanAnnivDate(String planAnnivDate) {
		this.planAnnivDate = planAnnivDate;
	}
	public int getEstNumberOfParticipants() {
		return estNumberOfParticipants;
	}
	public void setEstNumberOfParticipants(int estNumberOfParticipants) {
		this.estNumberOfParticipants = estNumberOfParticipants;
	}
	public long getEstPlanAssets() {
		return estPlanAssets;
	}
	public void setEstPlanAssets(long estPlanAssets) {
		this.estPlanAssets = estPlanAssets;
	}
	public LocalDate getEstImplementationDate() {
		return estImplementationDate;
	}
	public void setEstImplementationDate(LocalDate estImplementationDate) {
		this.estImplementationDate = estImplementationDate;
	}
	public String getSubsetCashCode() {
		return subsetCashCode;
	}
	public void setSubsetCashCode(String subsetCashCode) {
		this.subsetCashCode = subsetCashCode;
	}
	public String getClientEntityType() {
		return clientEntityType;
	}
	public void setClientEntityType(String clientEntityType) {
		this.clientEntityType = clientEntityType;
	}
	public String getTpaFirmId() {
		return tpaFirmId;
	}
	public void setTpaFirmId(String tpaFirmId) {
		this.tpaFirmId = tpaFirmId;
	}
	@Override
	public String toString() {
		return "PlanInfo [ evId=" + evId + ", planName=" + planName + ", irsrlCode=" + irsrlCode
				+ ", provCompany=" + provCompany + ", prodId=" + prodId + ", statusCode=" + statusCode + ", dpDateTime="
				+ dpDateTime + ", rolloverInd=" + rolloverInd + ", gaId=" + gaId + ", clientName=" + clientName
				+ ", firstLineMailing=" + firstLineMailing + ", scndLineMailing=" + scndLineMailing + ", city=" + city
				+ ", stateCode=" + stateCode + ", zipCode=" + zipCode + ", country=" + country
				+ ", internalComplianceInd=" + internalComplianceInd + ", planAnnivDate=" + planAnnivDate
				+ ", estNumberOfParticipants=" + estNumberOfParticipants + ", estPlanAssets=" + estPlanAssets
				+ ", estImplementationDate=" + estImplementationDate + ", subsetCashCode=" + subsetCashCode
				+ ", clientEntityType=" + clientEntityType + ", tpaFirmId=" + tpaFirmId + "]";
	}

    // Constructors, getters, setters...
    
}


