# primeAID
[Devpost Here](https://devpost.com/software/primeaid)

## Inspiration
As four students who have dealt extensively with the Canadian healthcare system, we knew there was an incredible room for improvement. Canada doesn’t fare well when it comes to emergency department wait times; it ranked last among the 11 countries surveyed by the OECD, with an average wait time of over four hours. Furthermore, in 2013, a US commission found that 70% of all critical events and delays in patient care could be traced to communication breakdowns. 

We aim to make a social impact in the medical industry by helping patients and institutions; transforming their medical experience to be a more convenient, transparent and streamlined experience.

## What it does

primeAID is medical software that intends to streamline communication and information among medical facilities. We also aim to elevate the convenience of the patient and administrative experience. 

Patient Side: Patients will be able to access critical information through our web application. This information includes viewing current patient wait times, nearby medical facilities, and preliminary triage services. This will ultimately result in fewer resources being wasted, patients getting faster treatment, and an overall reduction in administrative expenses.

Administrative Side: Implemented a remote registration system that confirms a patient's registration and verifies EMR.

## How we built it
For the triage portion of the application, an API called APIMedic was used to diagnose symptoms and severity level. This was done in Python and using a flask server for front-end communication. We used JavaScript for the web-application to communicate with the front-end, Google-Maps API and with the Tactio-API. Lastly, we built the clinical side application using Java Swing for the GUI and Java to communicate with the Tactio-API.

## Challenges we ran into
- Communicating between different languages on our backend (Solved using ajax to send requests on JS and flask to handle requests)
- Handing everything synchronously 
- Communicating with the TactioAPI for the clinic side application
- UI looks good

## Accomplishments that we're proud of
- Worked extremely well as a team

## What's next for primeAID
- Build our own ML model for triage assessment
- Build patient side registration
- Contact medical institutions to get real-time, pertinent information
