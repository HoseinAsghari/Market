# Market
We have developed our Ap-Project 5 parts:\
1-part:\
  we made some classes and their attributes and methodes as you can see in the "ap-project-phase0-99107838pdf".\
2-part:\
 we made some user cases and use cases as an objects and some descriptions corresponding.and you can see in the "ap-project-phase1-99107838.pdf"\
3-part:\
 we made Class Diagram and then specify Persistant classes as entity.and you can see in the "ap-project-phase2-99107838.pdf"\
 \
 \
 ![phase2](ap-project-phase2-99107838.png)
 \
 \
\4-part:\
   then we made a sequence diagram . because of that edrawmax do not have User interface Shape we could not implement it . and you can see in the "ap-project-phase2-99107838.pdf"\
   \and the image is as follows:\
   \
   \
![phase3](ap-project-phase3-99107838.jpg)
\
\
\and finally we used Java to implements our Projects:\
\
at first let take look at what do we have in our src dolder:\
App.java:\
it is our main class and only and only this class has main method . so it is the gate of our application. it means if we want to tun this we must at first run App.java\
\GrApplication.java:\
it makes a GUI for us to register , order and feedback.\
\afterwards we go to Customer package :\
\Address.java:\
\which only has some fields and a cunstructor to initialize those fields.\
\Person.java:\
\it is an abstract class with only some fields that our user cases extends it.\
\Customer.java :\
\this class extends Person.java and consists of some field and method related to its salary. and finaly a file as history of his wages from Store.\
\CustomerRegister.java :\
\it does nothing except of make an instance of Gr.java.\
\Gr.java :\
\ it makes a GUI to register as Customer.\
\Order.java :\
\after registration of customers and Stores you can go to this class and make an order as a customer from your desired store and then it makes \
changes in files in directory Manager\Foods\* . in this directory we have some information about menu of each stores.\
as well , in directory Manager\* we have an important files named "Storeslogin ",Storeslogi "Customerslogin" and "FeedbacksOfUsers" inwhich they give us persistent\
information about database.
\then we go to Manager package :\
\ 
\in directory Manager\Foods\* . in this directory we have some information about menu of each stores.\
as well , in directory Manager\* we have an important files named "Storeslogin ",Storeslogi "Customerslogin" and "FeedbacksOfUsers" inwhich they give us persistent\
information about database.\
\as well we have class "Feedback.java" which is very simple class only to records complaints from customers or store owners.\
\then we go to Store package :\




