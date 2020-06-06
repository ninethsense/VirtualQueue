# Virtual Queue Management System
This *technical whitepaper* is an attempt to design an architecturally near perfect virtual queue application.

## Background
During the [Corona virus pandemic](https://en.wikipedia.org/wiki/COVID-19_pandemic) lockdown in 2020, [Kerala State Beverages Corporation Limited](https://www.ksbc.kerala.gov.in/), aka KSBC decided to introduce a virtual queue system, a mobile app to resume the sale of Liquor, Beer and Wine but also same time making sure the state wide lockdown protocol is followed, especially the social distancing part. But due to various reasons the said mobile app became a [fiasco](https://english.manoramaonline.com/news/kerala/2020/05/28/faircode-bevq-kerala-state-beverages-corp-glitches.html) (as on 30 May 2020).

As a citizen & netizen, and more over a technology enthusiast, I was following all the news coming out and was closely monitoring the technology aspects or views shared by mainstream and social media, and also the comments posted by the readers. There were logical as well as illogical comments from both the app developers as well as readers. This triggered me to think *why an app, which sounds simple, but became a mess* for the entire State of Kerala.

## Context & Intention
Definitely, political side of the problem is not my problem. Intention of this paper is to design a simple, but scalable Virtual Queue system.

Finally, I am making this whitepaper public, under MIT License so the public can refer the design to develop their own applications. And also, contribute suggestions & corrections so we can improve this paper.

## Table of Contents
1. Requirements Gathering & Analysis
2. High Level Solution Design
3. Deployment Architecture
4. Cost & Efforts Estimation5. 

## Requirements

I have tried to find exact requirements for the application, but had to do some guesswork due to unavailability of formal information. I have to depend on:
* KSBC Notice dt. 19.05.2020 [[Reference - UNDERTAKING.pdf](http://www.ksbc.kerala.gov.in/NOTICE/UNDERTAKING.pdf)]
* KSBC Guidance dt. 23.05-2020 [[Reference - GUIDELINES.pdf](https://www.ksbc.kerala.gov.in/NOTICE/GUIDLINES.pdf)]
* App functionalities mentioned in news by mainstream media, and common sense

There was a mention in media about a *implementation document* and a *proposal document* but however I did not get those so, let me build my own simple requirement set.

### **Requirements Assumptions**

- A Virtual Queue Token generator application - which should support iPhone, Android and a responsive website.
- SMS based Virtual Queue Token generator, which is primarily intended for classic mobile (non-smartphone) users, but smartphone users also can use this as an alternate method.
  - There is no mention anywhere in the reference documents that App need to be a website, iPhone, Android, or a tablet variant. 
- A token validator application for the Bars & outlets
- An admin management console, which can:
  - Take Reports
  - Change token generator Schedule 
  - CRUD for Bars and outlets
- High Level Use Case
  1. User visits the App*
  2. User enters the postal [pin code](https://en.wikipedia.org/wiki/Postal_Index_Number)
  3. User gets a eToken with a schedule. The venue is expected to be within 10 KM range
  4. User, as per the timeslot given, goes to the allotted venue - Bar or outlet
  5. Bartender, using his mobile app scans the user's eToken, or enters the eToken received as SMS 
  6. Server validates the authenticity of the eToken
  7. User buys the beverage of his choice

![Block Diagram](assets/req-highlevel.jpg)
