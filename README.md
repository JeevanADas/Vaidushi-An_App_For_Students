# Vaidushi-An_App_For_Students

Since the start of the pandemic, the information received by students are through  many sources, causing uncertainty and confusion. For example, our college has no phone application where the students have easy access to announcements, upcoming events, notes or a place where they could keep a track of their attendance all at one place. Our application solves this by giving a common ground which focuses on a student's everyday requirement and helps the student have easy access to the necessary information.


The proposed system is a handy application that can be used by all the users to facilitate communication. The application introduces portability as it is used on a mobile device which can be carried anywhere. 

## Technologies

- Java
- Android Studio
- Firebase - Authentincation Module, Cloud Firestore, Storage Module.

## Dependencies

- implementation 'androidx.appcompat:appcompat:1.3.1'
- implementation 'com.google.android.material:material:1.4.0'
- implementation 'androidx.constraintlayout:constraintlayout:2.1.1'
- implementation 'com.github.denzcoskun:ImageSlideshow:0.1.0'
- implementation 'com.google.firebase:firebase-auth:21.0.1'
- implementation 'com.google.firebase:firebase-firestore:23.0.4'
- implementation 'com.google.firebase:firebase-storage:20.0.0'
- implementation 'com.firebaseui:firebase-ui-firestore:6.2.1'
- implementation 'com.github.MikeOrtiz:TouchImageView:1.4.1'
- testImplementation 'junit:junit:4.+'
- androidTestImplementation 'androidx.test.ext:junit:1.1.3'
- androidTestImplementation 'androidx.test.espresso:espresso-core:3.4.0'

## Module wise breakdown 

### Main page: 
#### This module consists of information about the college along with options to login and signup.

<img src="https://user-images.githubusercontent.com/71747053/146725156-00bb0f79-b935-4f4e-ac2e-8a9447e12994.jpg" height="450"/>

### Signup Page:
#### This module prompts the student to enter their credentials such as their USN, phone number, year of study etc. This information is then stored onto the firebase, which will be used further to validate the students' identity.

<img src="https://user-images.githubusercontent.com/71747053/146726240-d5730f6c-f0c7-4b34-810d-3d8653709d58.jpg" height="450"/>

### Login Page:
#### The authentication system on the firebase authenticates using the email ID of the student and the password that they'd entered on singing up. Once the student logs in with the correct credentials, they will be directed to their dashboard and can continue using the application to its best use.

<img src="https://user-images.githubusercontent.com/71747053/146726487-07af11c0-ff69-4b3a-8881-9855d9b7568d.jpg" height="450"/>

### Dashboard:
#### The dashboard module will consist of all the ongoing events and important notices such as exams, ongoing seminars etc.

<img src="https://user-images.githubusercontent.com/71747053/146727502-b7d9d6ea-4c0f-4415-abb7-f8887ad42a8c.jpg" height="450"/>

### Navgation Drawer:
#### The navigation bar module gives the student the ability to navigate around different sections in the application.

<img src="https://user-images.githubusercontent.com/71747053/146727710-83d8574e-f6aa-479d-9e67-900d20bcce0f.jpg" height="450"/>

### Notice Board:
#### This option redirects the user back to the Dashboard again.

### Time Table:
#### Students have easy access to their time table by entering their semester followed by their section.

<img src="https://user-images.githubusercontent.com/71747053/146728651-1c320872-9e94-4245-a121-7d0d7417edb7.jpg" height="450"/>

### Attendance:
#### The user can view their attendance once it has been updated by the faculty at the end of the semester.

<img src="https://user-images.githubusercontent.com/71747053/146728789-644884ec-cac8-451f-a182-f268f4a81f0b.jpg" height="450"/>

### Subject Resources:
#### Easy access to subject resources such as notes, previous year question papers etc.

<img src="https://user-images.githubusercontent.com/71747053/146728938-22045efb-6f30-418c-8e77-ee80a4175cce.jpg" height="450"/>
<img src="https://user-images.githubusercontent.com/71747053/146729061-279a4efb-833f-4b7e-8e39-4bd7e83db414.jpg" height="450"/>
<img src="https://user-images.githubusercontent.com/71747053/147075717-36a3a8f5-bbb3-49e7-91c8-2406c57483ae.jpg" height="450"/>


### Academic Calendar:
#### The academic Calendar can be viewed semester wise.

<img src="https://user-images.githubusercontent.com/71747053/146729258-8123ddf7-8f30-4588-a882-5e05d768d1f2.jpg" height="450"/>

### Faculty Details:
#### Fculty details such as their phone number, email and cain number can be easily found here.

<img src="https://user-images.githubusercontent.com/71747053/146729473-a369e6e8-a1cc-4aff-aa9e-e0bd9d2eb55f.jpg" height="450"/>

### About us:
#### This section gives information about the developers wo worked on this application.

<img src="https://user-images.githubusercontent.com/71747053/146729650-a2cc97dc-dd52-454c-9063-dec1f2665d58.jpg" height="450"/>

### Logout Option:
#### This option lets the student logout of their account on their device.
